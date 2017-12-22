import com.google.gson.Gson;

class Message
{
	private String sourceDevice;
	private String destinationDevice;
	private String nextHop;
	private String message;
	
	public Message(String destinationDevice, String message)
	{
		this.destinationDevice = destinationDevice;
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getNextHop() {
		return nextHop;
	}
	
	public void setNextHop(String nextHop)
	{
		this.nextHop = nextHop;
	}
	
	public String getSourceDevice() {
		return sourceDevice;
	}

	public void setSourceDevice(String sourceDevice) {
		this.sourceDevice = sourceDevice;
	}

	public String getDestinationDevice() {
		return destinationDevice;
	}

	public void setDestinationDevice(String destinationDevice) {
		this.destinationDevice = destinationDevice;
	}

	public String toGson()
	{
		Gson gson = new Gson();
        return gson.toJson(this);  
	}
	
	public static Message toMessage(String str)
	{
		Gson gson = new Gson();
		Message message = gson.fromJson(str, Message.class);
		return message;
	}
}