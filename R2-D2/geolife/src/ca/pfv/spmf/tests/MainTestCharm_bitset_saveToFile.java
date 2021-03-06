package ca.pfv.spmf.tests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.frequentpatterns.charm_bitset_saveToFile.AlgoCharm_Bitset_saveToFile;

/**
 * Class to test the Charm algorithm.
 * @author Philippe Fournier-Viger (Copyright 2009)
 */
public class MainTestCharm_bitset_saveToFile {

	public static void main(String [] arg) throws IOException{
		String input = fileToPath("contextPasquier99.txt");  // the database
		String output = "C://frequent_itemsets.txt";  // the path for saving the frequent itemsets found
		
		double minsup = 0.4; // means a minsup of 2 transaction (we used a relative support)
		
		
		// Applying the Charm algorithm
		AlgoCharm_Bitset_saveToFile algo = new AlgoCharm_Bitset_saveToFile();
		algo.runAlgorithm(input, output, minsup, 100000);
		algo.printStats();
		
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestCharm_bitset_saveToFile.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
