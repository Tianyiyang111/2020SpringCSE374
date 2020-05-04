/**
 * Represents a server object. 
 */
public class Server {
	//Connections established in server.
	private int conections;
	//Server ping, 
	private int ping;
	//Server load
	private double load;
	//Server ip
	private String ip;
	private int responseTime;
	/**
	 * Constructor for server
	 * @param conections int of connections
	 * @param ping int server ping 
	 * @param ip String server ip
	 */
	public Server(int conections,int ping,String ip){
		this.conections=conections;
		this.ping=ping;
		this.ip=ip;
	}

	public int getConections() {
		return conections;
	}


	public void setConections(int conections) {
		this.conections = conections;
	}


	public double getLoad() {
		return load;
	}


	public void setLoad(double load) {
		
		this.load = load;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public int getResponseTime() {
		return responseTime;
	}


	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}


	public int getPing() {
		return ping;
	}


	public void setPing(int ping) {
		this.ping = ping;
	}	
	public String toString() {
		return "Server ip :"+this.getIp()+", Conections established:"+this.getConections()+", ping:"+this.getPing()+", load:"+(int)this.getLoad();
	}
}
