import java.io.*;
import java.net.*;
import java.util.Scanner;

class ClientArmstrong{
	public static void main(String[] cp){
		try{
			Socket s = new Socket("localhost",2323);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number to check for Armstrong: ");
			int num = sc.nextInt();
			String nums =String.valueOf(num);
			dos.writeUTF(nums);
			dos.flush();
			String str = (String)dis.readUTF();
			System.out.println("server message: "+str);
			dos.close();
			s.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}