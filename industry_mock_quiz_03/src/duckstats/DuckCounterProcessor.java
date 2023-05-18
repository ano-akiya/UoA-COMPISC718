package duckstats;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;

/**
 * This class imports the duck statistics from a file, prints the first 10 duck
 * statistics, and the first 10 duck statistics in descending order.
 * 
 * @author Yu-Cheng Tu
 *
 */
public class DuckCounterProcessor {

	/**
	 * This is the main method, you may modify this method appropriately.
	 */
	public static void main(String[] args) {
		DuckCounterProcessor dp = new DuckCounterProcessor();

		System.out.println("Processing Duck Data");
		System.out.println("----------------------");
		String currentDir = System.getProperty("user.dir");
		List<DuckCounter> duckData = dp.processFile(currentDir + "/ducks.csv");
		
		System.out.println();
		System.out.println("=================");
		System.out.println("First 10 Duck Stats");
		System.out.println("=================");
		dp.printFirstTenDuckCounts(duckData);
		System.out.println("=================");
		
		System.out.println("First 10 Duck Stats in Descending Order");
		System.out.println("=================");
		
		// step c.
		duckData = Descend(duckData);
		dp.printFirstTenDuckCounts(duckData);
		System.out.println("=================");
	}

	// step b ii.
	private void printFirstTenDuckCounts(List<DuckCounter> duckData)
	{
		for (int i = 0; i < 10; i++)
		{
			DuckCounter item = duckData.get(i);
			String data = item.getDate().toString();
			int duck = item.getDuckCount();
			int duckling = item.getDucklingCount();
			System.out.println("Data: " + data + ", ducks: " + duck + ", ducklings: "+ duckling);
		}
	}

	// step b i.
	private List<DuckCounter> processFile(String filePath)
	{
		System.out.println("1");
		List<DuckCounter> DuckCounter = new ArrayList<>();
		File new_file = new File(filePath);
		try(BufferedReader reader = new BufferedReader(new FileReader(new_file)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				String[] item = line.split(",");
				int duck_num = Integer.parseInt(item[1]);
				int duckling_num = Integer.parseInt(item[2]);
				DuckCounter data = new DuckCounter(item[0], duck_num, duckling_num);
				DuckCounter.add(data);
			}
		}
		catch(Exception e)
		{
			System.out.println("err: " + e);
		}

		return DuckCounter;
	}

	private static List<DuckCounter> Descend(List<DuckCounter> duckData)
	{

		int[] duck_number = new int[duckData.size()];
		for (int i = 0; i < duck_number.length; i++)
		{
			duck_number[i] = duckData.get(i).getDuckCount();
		}

		DuckCounter higher;
		DuckCounter lower;
		for (int i = 0; i < duckData.size(); i++)
		{
			for (int j = i + 1; j < duckData.size(); j++)
			{
				if (duckData.get(i).getDuckCount() < duckData.get(j).getDuckCount())
				{
					higher = duckData.get(j);
					lower = duckData.get(i);
					duckData.set(i,higher);
					duckData.set(j, lower);
				}
			}
		}
		return duckData;
	}
}
