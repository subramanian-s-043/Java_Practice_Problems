package com.subramanians.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReadWriteCSV {
	public static void main(String[] args) throws IOException {
		String path = new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\task\\Stocks.csv";
		String writePath = new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\task\\NewStocks.csv";
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		String data;
		List<Integer> prices=new ArrayList<>();
		while((data=br.readLine())!=null)
		{
			String[] col = data.split(",");
			
			for(String row: col)
			{
				if(row.equals("Prices") || row.equals(""))
					continue;
				else
					prices.add(Integer.valueOf(row));
			}
		}
		System.out.println("Read From CSV Successfull!!");
		Collections.sort(prices,Comparator.reverseOrder());		
		try (BufferedWriter bf = new BufferedWriter(new FileWriter(writePath))) {
			bf.write("Sorted Price");
			bf.newLine();
			for(Integer ele: prices)
			{
				bf.write(ele.toString());
				bf.newLine();
			}
		}
		System.out.println("New CSV File Created!!");
	}
}
