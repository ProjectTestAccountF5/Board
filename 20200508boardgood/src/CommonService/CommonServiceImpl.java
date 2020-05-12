package CommonService;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.stage.Window;

public class CommonServiceImpl implements ICommonService{

	@Override
	public Parent Load(String formPath) {
		Parent root = null;
		FXMLLoader loader = new  FXMLLoader(getClass().getResource(formPath));
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}

	@Override
	public Popup showPopUp(Popup popup, Scene scene) {
		ScrollPane sp = new ScrollPane();
		sp.setContent(Load("../application/PopUp.fxml"));
		if(popup.isShowing()) {
			popup.hide();
		}
		else {
			final Window window = scene.getWindow();
			BorderPane pane = (BorderPane)window.getScene().getRoot();
			popup.sizeToScene();

			popup.getContent().clear();
			popup.getContent().add(sp);
			popup.show(window,pane.getHeight(),pane.getWidth()/6);
		}
		return popup;
	}

	@Override
	public Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}
	public Map<String, TextField> getTextFieldInfo(Parent root, String[] txtFldIdArr) {
		Map<String, TextField> txtFldMap = new HashMap<String, TextField>();
		
		for(String txtFldId : txtFldIdArr) {
			TextField txtFld = (TextField)root.lookup(txtFldId);
			txtFldMap.put(txtFldId, txtFld);
		}
		return txtFldMap;
	}
	@Override
	public boolean isEmpty(Map<String, TextField> txtFldMap, String[] txtFldIdArr) {
		for(String txtFldId : txtFldIdArr) {
			TextField txtFld = txtFldMap.get(txtFldId);
			
			if(txtFld.getText().isEmpty()) {
				txtFld.requestFocus();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void ErrorMsg(String title, String headerStr, String ContentTxt) {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerStr);
		alert.setContentText(ContentTxt);
		alert.showAndWait();
	}

}
