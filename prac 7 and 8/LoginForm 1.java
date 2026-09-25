import java.awt.*;
import java.awt.event.*;


class LoginForm extends Frame implements ActionListener{
	
	Label user,password;
	Button b1,b2;
	TextField tf1,tf2;
	Panel p1,p2,p3;
	
	LoginForm(){
		setTitle("Login");
		setSize(400,250);
		setLayout(new GridLayout(4,1));
		setBackground(new Color(250,250,250));

		user= new Label("User   ");
		password= new Label("Password ");
		tf1= new TextField(20);
		tf2= new TextField(20);
		p1= new Panel();
		p1.add(user);
		p1.add(tf1);
		
		p2=new Panel();
		p2.add(password);
		p2.add(tf2);

		b1=new Button("Login");
		b2=new Button("clear");
		p3=new Panel();
		p3.add(b1);
		p3.add(b2);
	
		add(p1);
		add(p2);
		add(p3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
				System.exit(0);
			}	
		});
		setVisible(true);
	}
		
		
		
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==b1) {
				String inputUser = tf1.getText().trim();
				String inputPass = tf2.getText().trim();
				
				String correctUser = "may@gmail.com";
				String correctPass = "maya24082006";
				if (inputUser.equals(correctUser) && inputPass.equals(correctPass)){
					showDialog("Login Successful !");
				}else{
					showDialog("Invalid login or password");
				}
			}else if (e.getSource()==b2){
				tf1.setText("");
				tf2.setText("");
			}
		}
		
		public void showDialog(String message){
			Dialog d = new Dialog(this,"Message",true);
			d.setLayout(new FlowLayout());
			d.setSize(300,120);
			d.setLocation(300,400);
			
			Label lmessage = new Label(message);
			
			Button ok = new Button("OK");
			
			ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					d.dispose();
				}
			});
			d.add(lmessage);
			d.add(ok);	
			d.setVisible(true);
		}
		
	public static void main(String []cp){
		new LoginForm();
	}
}
