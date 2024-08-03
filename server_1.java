import java.io.*;
import java.lang.*;
import java.net.*;

public class server_1
{
	public static void main(String args[])throws UnknownHostException
	{
		String n_str,name,n_msg,msg;

		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			ServerSocket ss=new ServerSocket(1234);
			Socket s=ss.accept();

			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);

			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);

			System.out.println("SERVER SIDE");

			n_str=dis.readUTF();

			System.out.println("\nClient Name :"+n_str);

			System.out.print("\nEnter Server name :");
			name=br.readLine();

			dos.writeUTF(name);

			System.out.println("-------------------------------------------------------------------");

			while(true)
			{
				n_msg=dis.readUTF();

				System.out.println("\n"+n_str+" : "+n_msg);

				System.out.print("\nEnter message :");
				msg=br.readLine();

				dos.writeUTF(msg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}