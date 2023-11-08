package a2_comp249;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class driver {
	
	public static void doPart1() {
			
	}

	public static void main(String[] args) {
			
			
			do_part1(); 
		//	do_part2();
		//	do_part3();
		
	//	System.out.println("Current working directory: " + System.getProperty("user.dir")); 

	}
	
	public static int arrayLength(String[] array) {
		int n = 0;
		for (int i = 0; i<array.length-6; i++) {
			if(array[i+6] == null) {
				n++;
			}
			else {
				continue;
			}
		}
		int count = array.length - n;
		return count;
	}
	
	public static boolean checkGenre(String s) {
		switch (s) {
		case "CCB" :
		case "HCB" :
		case "MTV" : 
		case "MRB" :
		case "NEB" :
		case "OTR" : 
		case "SSM" :
		case "TPA" :
			return true;
		default:
			return false;
		}
	}
	
		
	public static void do_part1(){
		BufferedReader inputFileReader = null;
		String[] csvFileName = null;
		try { 
			// create buffered reader to read all input file name 
			inputFileReader =
					new BufferedReader(new FileReader("src/a2_comp249/part1_input_file_names.txt"));
			
			// retrieve the number of files in part1_input_file_names.txt
			String line = inputFileReader.readLine();
			int nbOfLines = Integer.parseInt(line); // nbOfLines = 16
			
			
			// create an array that stores all the names of the csv files
			csvFileName = new String[nbOfLines];
			for(int x = 0; x < nbOfLines; x++) {
				csvFileName[x] = inputFileReader.readLine();
			}
			
			inputFileReader.close(); // close the inputFileReader
			
			
			for (int n = 0; n < nbOfLines; n++) {// for loop to iterate through csvFileName array
			// create buffered reader to read the data from the csv file
			BufferedReader csvReader = 
					new BufferedReader(new FileReader("src/a2_comp249/"+csvFileName[n]));
				//	new BufferedReader(new FileReader("src/a2_comp249/books1998.csv.txt"));
			
			// FOR VERIFICATION PURPOSES 
			String nameCSV =( csvFileName[n]+".csv");
			System.out.println("\n"+nameCSV);
			
			// create an array that stores the data of each csv file
			String[] csvData = new String[2000]; // max elements of 300 
			String[] csvDataArray = new String[40];
			String[] csvFormatted = new String[40];
			String csvDataLine;
			boolean doubleQuotes = false;
			
			int x = 0;	
				
				while((csvDataLine = csvReader.readLine()) !=null && x < 2000) { // if the next line is not null then continue
					int count = 1;
					
					//System.out.println("\n"+csvDataLine); //display the elements of the file.csv.txt !!delete later!! THIS WORKS
					
					if(csvDataLine.contains("\"")) {
						int q1 = csvDataLine.indexOf("\"");
						int q2 = csvDataLine.lastIndexOf("\"");
						String quottedString = csvDataLine.substring(q1,q2+1); 
						//// remove all commas from quotted strings
						String removedCommas = quottedString.replaceAll(",", "");
						csvDataLine = removedCommas + csvDataLine.substring(q2+1);
					}
		
					
					csvDataArray = csvDataLine.split(",");
					
					int cfLength = arrayLength(csvDataArray); // csvFormatted length
					
					// System.out.println(cfLength);
					
					
					FileWriter syntaxE = new FileWriter("src/a2_comp249/syntax_error_file.txt");
					        if(cfLength > 6) { // too many fields
								System.out.println(csvDataLine);
								System.out.println("Too many fields."); //THIS SHOULD WORK
								
							}
					        else if(cfLength  == 6) { 
					        	for(int i = 0 ; i < cfLength; i++) {
					        		if (csvDataArray[i] == "") { 
					        			System.out.println(csvDataLine);
					        			System.out.println("Missing Field."); // THIS WORKS
					        		}
					        	}
					        	if(checkGenre(csvDataArray[4]) == false) {
					        		try {
					        			throw new UnknownGenreException(csvDataLine);
					        		}
					        		catch (UnknownGenreException e) {
					        			syntaxE.write("syntax error in file: " + nameCSV); // THIS WORKS
					        			syntaxE.write("======================");
					        			syntaxE.write("Error: invalid genre.");
					        			syntaxE.write(csvDataLine);
					        		}
					        		
					        		
					        	}
					        	else {
					        		//System.out.println(csvDataLine);
						        	//System.out.println("yay!");
					        	}
					        }
					        else if(cfLength < 6) { // too few fields
					  
					        		if (csvDataLine.endsWith(",")) { 
					        			System.out.println(csvDataLine);
					        			System.out.println("Missing Field (year)"); //THIS WORKS
					        		}
					        		else {
					        			System.out.println(csvDataLine);
										System.out.println("Too few fields."); // THIS SHOULD WORK
					        		}
							}	
					        else {
					        	//System.out.println(csvDataLine);
					        	//System.out.println("yay!");
					        	
							}
					
					    /////////////////////////////////////////  WORKS TILL HERE
					        x++;
				}
					
				csvReader.close(); // close the csvReader
			}
			
		} // try bracket
			
			
			
		// exception handling
				catch(FileNotFoundException e) {
					System.out.println("the file was not found");
					System.exit(0);
				}
				catch(IOException e) {
					System.out.println("part1 _input _file_names.txt was not found");
					System.out.println("or could not be opened");
					System.exit(0);
				}
		}

}
