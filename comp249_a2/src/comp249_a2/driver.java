package comp249_a2;
import java.util.Scanner;
import java.io.FileReader;
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
		int count = 0;
		for (int i = 0; i<array.length; i++) {
			if(array[i] != null) {
				count++;
			}
			else {
				continue;
			}
		}
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
					new BufferedReader(new FileReader("src/comp249_a2/part1_input_file_names.txt"));
			
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
					new BufferedReader(new FileReader("src/comp249_a2/"+csvFileName[n]));
				//	new BufferedReader(new FileReader("src/comp249_a2/books2003.csv.txt"));
			
			// FOR VERIFICATION PURPOSES 
			 String nameCSV =( csvFileName[n]+".csv");
			 System.out.println("\n"+nameCSV);
			
			// create an array that stores the data of each csv file
			String[] csvData = new String[2000]; // max elements of 300 
			String[] csvDataArray = new String[15];
			String[] csvFormatted = new String[15];
			boolean doubleQuotes = false;
			int count = 0;
			int x = 0;
				
				
				while((csvData[x] = csvReader.readLine()) !=null && x <2000) { // if the next line is not null then continue
					String csvDataLine = csvData[x] ;
					
				// System.out.println(csvDataLine); //display the elements of the file.csv.txt !!delete later!! THIS WORKS
					
				if(csvDataLine != null) {
					csvDataArray = csvDataLine.split(",");
					
					csvFormatted[0] = csvDataArray[0];
					
					for(int i = 0; i<csvDataArray.length; i++) { // iterate through all the parts of csvDataArray
					for (int y = 0; y < csvDataArray.length; y++) { // iterate through all the parts of csvDataArray 
							if (y==0 && csvDataArray[y].startsWith("\"") && csvDataArray[y+1].endsWith("\"")) { //yes
			                    csvFormatted[y] = csvDataArray[y] + csvDataArray[y+1];
			                    doubleQuotes=true;
			                    count = 2;
			                    break;
			                }
							else if (y!=1 && csvDataArray[y].endsWith("\"")) { 
								csvFormatted[0] += csvDataArray[y];
								count = 3;
								doubleQuotes=true;
								break;
							}
							else {
								doubleQuotes =false;
								continue;
							}		
					}
					
						if (doubleQuotes == true ) {
							csvFormatted[1] = csvDataArray[count];
						}
						else {
							csvFormatted[i] = csvDataArray[i];
						}
						
					}
					
					// WORKS TILL HERE
			
					int cfLength = arrayLength(csvFormatted); // csvFormatted length
					
					        if(cfLength > 6) { // too many fields
								System.out.println(csvDataLine);
								System.out.println("Too many fields.");
								
							}
					        else if(cfLength  == 6) { 
					        	for(int i = 0 ; i < cfLength; i++) {
					        		if (csvFormatted[i] == "") { // missing fields THIS WORK BUT THE END ONE
					        			System.out.println(csvDataLine);
					        			System.out.println("Missing Field.");
					        		}
					        	}
					        	if(checkGenre(csvFormatted[4]) == false) {
				        			System.out.println(csvDataLine);
				        			System.out.println("Unknown genre."); // THIS WORKS
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
		
				}
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
