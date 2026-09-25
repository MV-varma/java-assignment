import java.net.URL;

public class URLResourceInfo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com:443/docs/index.html?user=admin#section2");
            
            System.out.println("Full URL: " + url.toString());
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host Name: " + url.getHost());
            System.out.println("Port Number: " + url.getPort());
            System.out.println("Default Port: " + url.getDefaultPort());
            System.out.println("File Name: " + url.getFile());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query String: " + url.getQuery());
            System.out.println("Reference (Anchor): " + url.getRef());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}