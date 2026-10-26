import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        try(
            Socket socket = new Socket("localhost", 5000);
            BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in)
            );
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true
            )
        ){
            System.err.println("Connected to TCP server!");
            System.err.println("Type a message, or 'exit' to quit.");
            String message;
            while((message = keyboard.readLine()) != null){
                out.println(message);
                String response = in.readLine();
                System.err.println("Server reply: " + response);
                if(message.equalsIgnoreCase("exit")){
                    break;
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
