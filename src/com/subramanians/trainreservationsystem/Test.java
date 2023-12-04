package com.subramanians.trainreservationsystem;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {
	public static void main(String[] args) {
		Object readTrainDetails;
		Object readStationCode;
		JSONParser parser=new JSONParser();
		JSONObject retrievedTrainDetails;
		JSONObject retrievedStationCode;
		List<List<String>> retrieved=new ArrayList<>();
		try {
			readTrainDetails=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\TrainDetails.json"));
			retrievedTrainDetails=(JSONObject) readTrainDetails;
			readStationCode=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\TrainStationCode.json"));
			retrievedStationCode=(JSONObject) readStationCode;
			String stationCode=(String) retrievedStationCode.get("TENKASI")+"_"+retrievedStationCode.get("CHENNAIEGMORE");
			JSONArray temp= (JSONArray) retrievedTrainDetails.get(stationCode);
			for(int i=0;i<temp.size();i++)
			{
				JSONObject temp1=(JSONObject) temp.get(i);
				System.out.print(temp1.get("TrainNo")+"\t");
				System.out.print(temp1.get("TrainName")+"\t");
				System.out.print(temp1.get("Source")+"\t");
				System.out.println();
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}
