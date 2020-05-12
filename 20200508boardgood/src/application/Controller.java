package application;

import java.net.URL;
import java.util.ResourceBundle;

import CommonService.CommonServiceImpl;
import CommonService.ICommonService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Controller implements Initializable {
	ICommonService comserv = new CommonServiceImpl();
	@FXML CheckBox notShowCheckBox;
	@FXML Button fullscrBtn;

	static Boolean checked = false;
	private ScrollPane scrPane = new ScrollPane();
	private Scene scene;
	static Popup mainPopup = new Popup();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}


	public void CheckBox(ActionEvent e) {
		Parent root = (Parent)e.getSource();
		CheckBox notChk = (CheckBox)root.lookup("#notShowCheckBox");
		checked = notChk.isSelected();
		Popup notPopup = (Popup)root.getScene().getWindow();
		if(checked)
			notPopup.hide();
	}
	public void HomeView(ActionEvent e) {

		BorderPane borderPane = (BorderPane)comserv.getScene(e);
		borderPane.setLeft(null);
		borderPane.setCenter(null);

		Parent root = (Parent)e.getSource();
		scene = root.getScene();
		mainPopup = comserv.showPopUp(mainPopup, scene);
		if(checked)
			mainPopup.hide();
	}
	public void ShopView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)comserv.getScene(e);
		Parent leftScene = comserv.Load("../application/SubButton.fxml");
		borderPane.setLeft(leftScene);

		//BorderPane contentPane = new BorderPane();
		//scr.setOrientation(Orientation.VERTICAL);
		scrPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		VBox vbox = new VBox();
		for(int i=0; i<100;i++)
			vbox.getChildren().add(new Button(String.valueOf(i)));
		scrPane.setContent(vbox);
		borderPane.setCenter(scrPane);
	}
	public void BoardView() {

	}
	public void MembershipView() {

	}
	public void LoginView() {

	}
	public void SearchView() {

	}
	public void CartView() {

	}
	public void TopView(ActionEvent e) {
		scrPane.setVvalue(0);
	}
	public void BottomView(ActionEvent e) {
		scrPane.setVvalue(100);
	}

	public void FullScreen(ActionEvent e) {
		Stage stage = (Stage) fullscrBtn.getScene().getWindow();
		stage.setFullScreen(true);
	}
	

}
