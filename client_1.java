import java.io.*;
import java.lang.*;
import java.net.*;

public class client_1
{
	public static void main(String args[])throws UnknownHostException
	{
		String str,name,msg,n_msg;

		try
		{
			Socket s=new Socket("localhost",1234);

			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);

			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("CLIENT SIDE");

			System.out.print("\nEnter Client name here :");
			str=br.readLine();

			dos.writeUTF(str);

			name=dis.readUTF();

			System.out.println("\nYou are connected to "+name+" server.");

			System.out.println("-------------------------------------------------------------------");

			while(true)
			{
				System.out.print("\nEnter message :");
				msg=br.readLine();

				dos.writeUTF(msg);

				n_msg=dis.readUTF();

				System.out.println("\n"+name+" : "+n_msg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}