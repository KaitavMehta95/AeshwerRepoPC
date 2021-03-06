import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(1900);
		while(true){
		Socket sock = serverSocket.accept();
		
		//Accept the number to the client
		InputStreamReader stream = new InputStreamReader(sock.getInputStream());
		BufferedReader readFromClient  = new BufferedReader(stream);
		int temp = Integer.parseInt(readFromClient.readLine());
		int result = temp*2;
		
		//pass the number to the client
		PrintWriter write = new PrintWriter(sock.getOutputStream());
		write.println(result);
		
		}
	}
}
