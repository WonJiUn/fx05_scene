package quiz.membership;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class msOpen {
	public void membershipOpen() {
		
		try {
			Stage arg0 = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../main/Membership.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			msController ctl = loader.getController();
			ctl.setRoot(root);
			//이걸 안줘서 취소버튼 에러가 발생했음
			
			arg0.setScene(scene);
			arg0.show();
			
			
		}catch(Exception e) {
			
		}
	}
}
