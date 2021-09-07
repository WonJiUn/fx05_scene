package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class Controller implements Initializable {
	private Parent root;
	
	public void setRoot(Parent root) {
		this.root = root;
		addComboBox();
	}
	public void addComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		if(cmbAge != null) {
			cmbAge.getItems().addAll("20대 미만", "20대", "30대", "40대 이상");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	public void viewProc() {
		System.out.println("확인 버튼 클릭");
		boolean gender = getGender();
		int hobby = getHobby();
		String age = getComboBox();
		System.out.println(gender);
		System.out.println(hobby);
		System.out.println(age);
		
		//버튼 클릭시 다른 창 띄우는 방법
		try {
			Stage arg0 = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ex02/test.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			arg0.setScene(scene);
			arg0.show();
		}catch(Exception e) {
			
		}
		
	}
	public boolean getGender() {
		RadioButton rdoMan = (RadioButton)root.lookup("#rdoMan");
		if(rdoMan.isSelected()) return true;
		else return false;
		//둘을 그룹으로 묶어주었기 때문에 하나의 값만 체크하면 나머지 하나는 자동으로 결정된다.
	}
	public int getHobby() {
		int hobby = 0;
		CheckBox music = (CheckBox)root.lookup("#chkMusic");
		CheckBox sport = (CheckBox)root.lookup("#chkSport");
		CheckBox movie = (CheckBox)root.lookup("#chkMovie");
		if(music.isSelected()) {hobby += 1;}
		if(music.isSelected()) {hobby += 2;}
		if(music.isSelected()) {hobby += 4;}
		/*
		 hobby에 1이 들어와 있으면 음악을 선택
		 hobby에 3이 들어와 있으면 음악과 스포츠
		 hobby에 6이 들어와 있으면 스포츠, 영화 선택
		 ....
		 */
		return hobby;
	}
	public String getComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		//System.out.println("cmbAge : "+cmbAge);
        //System.out.println("cmbAge.value : "+cmbAge.getValue());
        String age = null;
		//null값을 가진 String은 .을 찍어서 기능을 사용할시 오류가 생김
		//cmbAge.getValue() 나 cmbAge 중에 어떤것이 null값을 가지고 있는지 sysout을 통해 확인 후 아래 if문 작성하면 오류가 사라짐
		if(cmbAge.getValue() == null) {
			System.out.println("콤보박스를 선택해주세요");
		}else {
			age = cmbAge.getValue().toString();
		}
		return age;
	}
	
	
}
