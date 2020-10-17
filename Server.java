package Socket;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
public static void main(String[] args) {

try {
	ServerSocket server = new ServerSocket(9571);
	System.out.println("Server da duoc tao");
	Socket client = server.accept();
	System.out.println("Client da ket noi den server");
	Scanner inFromClient = new Scanner(client.getInputStream());
	PrintStream outToClient = new PrintStream(client.getOutputStream());
	outToClient.println("Hello, What is your favourite?");
	String name = inFromClient.nextLine();
	System.out.println("client: " + name);
	BufferedReader br= new BufferedReader(new FileReader("D:\\favourite.txt"));
	String tep=br.readLine();
	if(tep.contains(name))
		outToClient.println("I found " + name);
	else
		outToClient.println("Sorry, I can't find " + name);
	} catch (IOException e) {
		e.printStackTrace();
}
}
}