public class main {
	public static void main(String[] args) {
		new Thread(){
			public void run() {  
				Message message = new Message("FADF1641223DFEA","Good Afternoon!");
				SocketClient client = new SocketClient("localhost",25148);
				while(true)
				{
					client.socketSend(message.toGson());
				}
			}
		}.start();
		
		new Thread(){
			public void run() {
				Message message = new Message("FADF1641223DFEA","Good Morning!");
				SocketClient client = new SocketClient("localhost",25148);
				while(true)
				{
					client.socketSend(message.toGson());
				}
			}
		}.start();
		
		new Thread(){
			public void run() {  
				SocketServer server = new SocketServer(25148);
				while(true)
				{
					Message result = Message.toMessage(server.socketAccept());
					System.out.println(result.getMessage());
				}
			}
		}.start();
	}
}
