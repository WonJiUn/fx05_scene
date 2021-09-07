package quiz.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import quiz.loginService.loginService;
import quiz.membership.msOpen;

public class Controller implements Initializable {
	private Parent root;
	private loginService ls;
	private msOpen ms;

	public void setRoot(Parent root) {
		this.root = root;
		ls.setRoot(root);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new loginService();
		ms = new msOpen();
		
	}
	public void LoginProc() {
		ls.loginCheck();
	}
	public void CancelProc() {
		ls.loginClose();
	}
	public void OpenMembershipForm() {
		ms.membershipOpen();
	}

}
