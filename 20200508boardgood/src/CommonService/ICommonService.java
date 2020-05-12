package CommonService;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Popup;

public interface ICommonService {
	public Parent Load(String formPath);
	public Popup showPopUp(Popup popup, Scene scene);
	public Parent getScene(ActionEvent e);
	public Map<String, TextField> getTextFieldInfo(Parent root, String[] txtFldIdArr);
	public boolean isEmpty(Map<String, TextField> txtFldMap, String[] txtFldIdArr);
	void ErrorMsg(String title, String headerStr, String ContentTxt);
}
