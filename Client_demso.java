package LAB4;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Client_demso

{
    public static void main(String[] args) throws IOException

    {
        Socket mySocket = null;

        DataOutputStream dos = null;

        DataInputStream dis=null;

       

        try {

            mySocket = new Socket("localhost", 7325);

            dos = new DataOutputStream(mySocket.getOutputStream());

            dis = new DataInputStream(mySocket.getInputStream());

            Scanner input = new Scanner(System.in);

            String s = null;

            while(true)

            {

                System.out.print("Enter data: ");

                s =input.nextLine();

                dos.writeUTF(s);

               

                String str=dis.readUTF();

                System.out.print(" Server : "+str);

            }

        }

        catch(Exception e) {

            System.out.print("Disconnected");

            dis.close();

            dos.close();

            mySocket.close();

            e.printStackTrace();

        }

    }

}