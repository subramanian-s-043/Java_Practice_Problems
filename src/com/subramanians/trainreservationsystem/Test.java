package com.subramanians.trainreservationsystem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class pass
{
	int i=2;
	String a="Test";
}
public class Test {
	public static void main(String[] args) {
		JSONParser parser=new JSONParser();
		Object readBookedTickets;
		JSONArray retrieved;
		Map<Integer,pass> t=new HashMap<>();
		JSONObject booked=new JSONObject();
		JSONObject o=new JSONObject();
		JSONObject u=new JSONObject();
		try {
			readBookedTickets=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\BookedTickets.json"));
			booked=(JSONObject) readBookedTickets;
			u=(JSONObject) booked;
			o=(JSONObject) booked.get("12601");
			retrieved=(JSONArray) ((JSONObject) booked.get("12601")).get("2");
			retrieved.set(1, "changed");
			o.remove("2");
			o.put("2", retrieved);
			u.remove("12601");
			u.put("12601", o);
			try (FileWriter file = new FileWriter(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\BookedTickets.json")) {
				System.out.println(u.toJSONString());
				file.write(u.toJSONString());
			}catch(IOException e)
			{
				System.out.println("Error");
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}
