
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        int port = 5000;
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.err.println("TCP Server started on port " + port);
            System.err.println("Waiting for a client...");

            try(
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );
                PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
                )
            ){
                System.err.println("Client Connected!");
                String message;
                while((message = in.readLine()) != null){
                    System.out.println("Client says: " + message);
                    out.println("Server received: " + message);
                    if(message.equalsIgnoreCase("exit")){
                        break;
                    }
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
