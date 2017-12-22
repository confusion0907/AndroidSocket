import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	private String host;
	private int port;
	
	public SocketClient(String host,int port)
	{
		this.host = host;
		this.port = port;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void socketSend(String str)
	{
		try {
			Socket socket =new Socket(host,port);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw =new PrintWriter(os);
			pw.write(str);
			pw.flush();
			socket.shutdownOutput();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
