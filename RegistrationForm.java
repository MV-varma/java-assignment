import java.awt.*;
import java.awt.event.*;

class RegistrationForm extends Frame implements ActionListener{
	Label lbName,lbFatherName,lbAge,lbGender,lbCourse,lbHobbies,lbAddress;
	TextField nametf,fnametf, agetf;
	TextArea addressta;
	CheckBox rbMale, rbFemale;
	CheckBoxGroup cbgGender;
	Choice chCourse;
	CheckBox cbDrawing, cbSinging, cbMusic, cbOthers;
	Button btSave, btClear; 
	
	public RegistrationForm(){
		setTitle("User Registration Form");
		setSize(400,400);
		setBackground(new Color(black));
	
		setLayout(new GridBagLayout());
		GridBagL
	}
	
	public static void main(String []cp){
		
	}

}