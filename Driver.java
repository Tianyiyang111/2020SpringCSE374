import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * Class to make the test.
 */
public class Driver {

	public static void main(String[] args) {
		String writeFile="";
		//LoadBalancer
		Algorithm1 alg1= new Algorithm1();
		HashMap<String,Integer> map= new HashMap<String,Integer>() ;
		
		
		//Servers available.
		HashMap<String,Server> serverList= new HashMap<String,Server>() ;
		
		
		//Create Servers List, with known ping for testing. 
		for(int i=0;i<10;i++) {
			serverList.put("192.168.3."+i,new Server(0, 10+i*10, "192.168.3."+i));
		}
		
		//Populate map with available servers. initial weight 1.
		for(String s:serverList.keySet()) {
			map.put(s, 1);
		}
		//System.out.println(map.toString());
		
		//Create 1000 connections and get proper server for each connection. Based on the weight.
		for(int i=0;i<1000;i++) {
			alg1.redistributionWeight(map,serverList);
			String s=alg1.getOptimalServer(map);
			Server temp=serverList.get(s);
			temp.setConections(temp.getConections()+1);
			
			
			serverList.put(s, temp);
			//map.put(temp, map.get(temp));
			
			//Result of changing weight for each connection added. 
			for(String d:serverList.keySet()) {
				writeFile+=""+serverList.get(d).toString()+" weight "+map.get(d)+"\n";
			}
			writeFile+="\n";
		}
		//write file 
		dumpToFile(writeFile);
		//Final Results
		for(String d:serverList.keySet()) {
			System.out.println(serverList.get(d).toString()+" weight "+map.get(d));
		}
		
		
	}
	public static void dumpToFile(String s) {
		File out = new File("data.txt");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.print(s + "\n");
		writer.close();
		System.out.println("Finished dumping file.");
	}
}
