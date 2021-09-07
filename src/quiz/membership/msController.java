package quiz.membership;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class msController implements Initializable {
	Parent root;
	membership ms;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new membership();
	
	}
	
	public void setRoot(Parent root) {
		this.root = root;
		ms.setRoot(root);
	}

	
	public void membershipProc() {
		//System.out.println("회원가입 클릭");
		ms.membershipProc();
	}
	
	public void memberCancelProc() {
		//System.out.println("취소 클릭");
		ms.memberCancel();
	}
}
