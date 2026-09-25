import java.io.*;
import java.net.*;

class ServerArmstrong{
	public static void main(String []cp){
		try{
			ServerSocket ss = new ServerSocket(2323);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			String message;
			String data=dis.readUTF();
			int num=Integer.parseInt(data);
			int temp=num;
			int rem=0;
			int sum=0;	
			while(temp!=0){
				rem=temp%10;
				sum=sum+rem*rem*rem;
				temp/=10;
				}
			if(sum==num){
				message = "Armstrong Number";}
			else{
				message = "Not a Armstrong Number";}
			dos.writeUTF(message);
			dos.close();
			ss.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}