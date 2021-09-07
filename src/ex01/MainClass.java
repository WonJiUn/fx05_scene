package ex01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//${javafxCompControls},javafx.fxml
public class MainClass extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("eventTest.fxml"));
		//다른 패키지에 있는 fxml을 가져오는 방법
		//FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../ex02/test.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Controller ctl = loader.getController();
		ctl.setRoot(root);
		
		arg0.setScene(scene);
		arg0.show();
		
	}
	public static void main(String[] args) {
		
		launch(args);
		
	}
}
