package quiz.membership;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import quiz.commonService.commonService;
import quiz.main.Member;

public class membership implements msInterface {
	
	Parent root;
	
	public void check() {
		
		TextField id = (TextField)root.lookup("#fxId");
		TextField name = (TextField)root.lookup("#fxName");
		PasswordField pf = (PasswordField)root.lookup("#fxPw");
		PasswordField pfok = (PasswordField)root.lookup("#fxPwOk");
		
		if(name.getText().isEmpty()) {
			alertMethod("이름을 입력해주세요");
			name.requestFocus();
		}else if(id.getText().isEmpty()) {
			alertMethod("아이디를 입력해주세요");
			id.requestFocus();
		}else if(pf.getText().isEmpty()) {
			alertMethod("비밀번호를 입력해주세요");
			pf.requestFocus();
		}else if(pfok.getText().isEmpty()) {
			alertMethod("비밀번호 확인을 입력해주세요");
			pfok.requestFocus();
		}
		
	}
	public void alertMethod(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	public String getComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		String age = null;
		if(cmbAge.getValue() == null) { 	//isEmpty 혹은 .equals 쓰면 오류발생
			alertMethod("나이를 선택해주세요");
		}else {
			age = cmbAge.getValue().toString();
		}
		return age;
	}
	public boolean getGender() {
		RadioButton rdoMan = (RadioButton)root.lookup("#rdoMan");
		if(rdoMan.isSelected()) return true; 	//true 면 남자
		else return false;
	}
	public int getHobby() {
		int hobby = 0;
		CheckBox music = (CheckBox)root.lookup("#chkMusic");
		CheckBox sport = (CheckBox)root.lookup("#chkSport");
		CheckBox movie = (CheckBox)root.lookup("#chkMovie");
		if(music.isSelected()) {hobby += 1;}
		if(sport.isSelected()) {hobby += 2;}
		if(movie.isSelected()) {hobby += 4;}
		
		return hobby;
	}

	@Override
	public void membershipProc() {
		
		Member dto = new Member();
		
		
		check();
		
		dto.setName( ((TextField)root.lookup("#fxName")).getText() );
		dto.setId( ((TextField)root.lookup("#fxId")).getText() );
		dto.setPw(((PasswordField)root.lookup("#fxPw")).getText());
		dto.setGender(getGender());
		dto.setAge(getComboBox());
		dto.setHobby(getHobby());
		
		System.out.println("이름 : " + dto.getName());
		System.out.println("아이디 : " + dto.getId());
		System.out.println("비밀번호 : " + dto.getPw());
		
		if(dto.isGender() == true) {
			System.out.println("남성");
		}else {
			System.out.println("여성");
		}
		
		System.out.println("나이 : " + dto.getAge());
		
		if(getHobby() == 1) {
			System.out.println("취미 : 음악");
		}else if(getHobby() == 2) {
			System.out.println("취미 : 스포츠");
		}else if(getHobby() == 4) {
			System.out.println("취미 : 영화");
		}else if(getHobby() == 3) {
			System.out.println("취미 : 음악, 스포츠");
		}else if(getHobby() == 5) {
			System.out.println("취미 : 음악, 영화");
		}else if(getHobby() == 6) {
			System.out.println("취미 : 스포츠, 영화");
		}else if(getHobby() == 7) {
			System.out.println("취미 : 음악, 스포츠, 영화");
		}
		
	}

	@Override
	public void memberCancel() {
		System.out.println("취소연결");
		commonService cs = new commonService();
		cs.setRoot(root);
		cs.windowClose();
		
	}
	public void addComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		if(cmbAge != null) {
			cmbAge.getItems().addAll("10대 이하", "20대", "30대", "40대 이상");
		}
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		addComboBox();
	}

}
