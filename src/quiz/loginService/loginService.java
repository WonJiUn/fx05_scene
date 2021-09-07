package quiz.loginService;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import quiz.commonService.commonService;

public class loginService implements lsInterface {
	Parent root;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	
	@Override
	public void loginCheck() {
		System.out.println("로그인체크");
		TextField tf = (TextField)root.lookup("#fxId");
		PasswordField pf = (PasswordField)root.lookup("#fxPwd");
		System.out.println("ID : " + tf.getText());
		System.out.println("PW : " + pf.getText());
		
	}

	@Override
	public void loginClose() {
		//System.out.println("화면닫기");
		commonService cs = new commonService();
		cs.setRoot(root);
		cs.windowClose();
		
	}

	

}
