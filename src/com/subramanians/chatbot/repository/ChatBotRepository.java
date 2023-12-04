package com.subramanians.chatbot.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ChatBotRepository {
	private static ChatBotRepository chatbotrepo;
	private Object reader;
	private JSONParser parser=new JSONParser();
	private JSONObject retrievedFiles;
	
	private ChatBotRepository()
	{
		try {
			reader = parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\chatbot\\StoreData.json"));
			retrievedFiles=(JSONObject) reader;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static ChatBotRepository getInstance()
	{
		if(chatbotrepo==null)
		{
			try {
				chatbotrepo=new ChatBotRepository();
			} catch (Exception e) {
				System.out.println("Error-In-Loading Data");
				e.printStackTrace();
			}
		}
		return chatbotrepo;
	}
	
	public List<String> getMenu(String level,String depth)
	{
		List<String> menu=new ArrayList<String>();
		JSONObject jsonLevel=(JSONObject) retrievedFiles.get(level);
		JSONArray menuData=(JSONArray)jsonLevel.get(depth);
		for(int i=0;i<menuData.size();i++)
		{
			menu.add((String)menuData.get(i));
		}
		return menu;
	}
}
