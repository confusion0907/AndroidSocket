import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	private BufferedWriter bufferedWriter=null;
	private ServerSocket serverSocket;
	private int port;
	
	public SocketServer(int port)
	{
		this.port = port;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String socketAccept()
	{
		String str = null;
		try {
			serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			str = reader.readLine();
			socket.shutdownInput();
			reader.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}