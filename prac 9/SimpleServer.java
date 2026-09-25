import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class SimpleServer extends Frame implements ActionListener {
    TextArea ta = new TextArea();
    TextField tf = new TextField();
    Button b = new Button("Send");
    
    ServerSocket ss;
    Socket s;
    DataInputStream din;
    DataOutputStream dout;

    public SimpleServer() {
        setTitle("Server");
        setSize(300, 400);
        setLayout(new BorderLayout());
        
        add(ta, BorderLayout.CENTER);
        Panel p = new Panel(new BorderLayout());
        p.add(tf, BorderLayout.CENTER);
        p.add(b, BorderLayout.EAST);
        add(p, BorderLayout.SOUTH);
        
        b.addActionListener(this);
        tf.addActionListener(this); // Send on Enter
        
        setVisible(true);
        startNetwork();
    }

    public void startNetwork() {
        try {
            ss = new ServerSocket(6000);
            ta.append("Waiting...\n");
            s = ss.accept();
            ta.append("Client Connected\n");
            
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while (true) {
                String msg = din.readUTF();
                ta.append("Client: " + msg + "\n");
            }
        } catch (Exception e) { 
            ta.append("Connection closed\n"); 
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String msg = tf.getText();
            dout.writeUTF(msg);
            ta.append("Me: " + msg + "\n");
            tf.setText("");
        } catch (Exception ex) {}
    }

    public static void main(String[] args) {
        new SimpleServer();
    }
}