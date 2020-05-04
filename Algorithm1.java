import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Algorithm Implementation.
 */
public class Algorithm1 {
	
	public String getOptimalServer(HashMap<String,Integer> temp) {
		//Compare values get first server and its weight.
		String res=temp.keySet().iterator().next();
		double weight=temp.get(res);
		
		//Get server with less weight.
		for(String s :temp.keySet()) {
			if(weight>temp.get(s)&&temp.get(s)>0) {
				weight=temp.get(s);
				res=s;
			}
		}
		//At this point we have selected server with less weight.
		return res;
	}
	
	public void redistributionWeight(HashMap<String,Integer> temp, HashMap<String, Server> serverList) {
		for(String str:temp.keySet()) {
			
			Server s=serverList.get(str);
			
			///Estimate transmitting time, random for each client, it make easier to test.   
			s.setResponseTime(s.getPing()-(int)(30.0 * Math.random()));
			
			//500ms constant of maximum response time, 
			s.setLoad(((double)s.getResponseTime()/500)*100);
	
			//Update Map table with weight.
			temp.put(str, (int) (100-s.getLoad()));
			//Update server
			serverList.put(str, s);
		}	
	}
}