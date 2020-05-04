
public class RegionServers {
	public int roundRobin;
	public Server lessPing;
	public int [] connectedRegions;
	public Server[] servers;
	
	public RegionServers() {
		
	}
	public void increseRoundRobin() {
		roundRobin++;
		if(roundRobin==servers.length-1) {
			roundRobin=0;
		}
	}
	public void getServerWithLessPing() {
		Server temp=null;
		for(int i=0;i<servers.length;i++) {
			if(servers[i].getPing()<=temp.getPing()) {
				temp=servers[i];
			}
		}
		lessPing=temp;;
	}
}
