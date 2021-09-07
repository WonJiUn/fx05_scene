package quiz.commonService;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class commonService implements csInterface {

	Parent root;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}

	@Override
	public void windowClose() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		
	}

}
