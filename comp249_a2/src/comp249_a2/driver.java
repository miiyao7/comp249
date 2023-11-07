package a2_comp249;
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
		int n = 0;
		for (int i = 0; i<array.length-6; i++) {
			if(array[i+6] == null) {
				n++;
			}
			else {
				continue;
			}
		}
		System.out.println(n);
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
			// String nameCSV =( csvFileName[n]+".csv");
			// System.out.println("\n"+nameCSV);
			
			// create an array that stores the data of each csv file
			String[] csvData = new String[2000]; // max elements of 300 
			String[] csvDataArray = new String[40];
			String[] csvFormatted = new String[40];
			String csvDataLine;
			boolean doubleQuotes = false;
			
			int x = 0;	
				
				while((csvDataLine = csvReader.readLine()) !=null && x < 2000) { // if the next line is not null then continue
					int count = 1;
					csvData[x] = csvDataLine;
					System.out.println("\n"+csvDataLine); //display the elements of the file.csv.txt !!delete later!! THIS WORKS
					
					csvDataArray = csvDataLine.split(",");
					for ( int m = 0; m < csvDataArray.length ; m++) {
						System.out.println(csvDataArray[m]);
					}
						
							if (csvDataArray[0].startsWith("\"") && csvDataArray[1].endsWith("\"")) { //yes
			                    count = 2;
			                    csvFormatted[0]= csvDataArray[0] + csvDataArray[1];
			                    doubleQuotes=true;
			                }
							
							else if (csvDataArray[0].startsWith("\"") && csvDataArray[2].endsWith("\"")) { 
								csvFormatted[0] = csvDataArray[0] + csvDataArray[1] + csvDataArray[2];
								count = 3;
								doubleQuotes=true;
							}
							else if (csvDataArray[0].startsWith("\"") && csvDataArray[3].endsWith("\"")) { 
									csvFormatted[0] = csvDataArray[0] +csvDataArray[1] +csvDataArray[2]+ csvDataArray[3];
									count = 4;
									doubleQuotes=true;
									
								}
							else {
								csvFormatted[0] = csvDataArray[0];
								doubleQuotes =false;
							}		
					
					
					int index = count;
				//	System.out.println(doubleQuotes);
					if (doubleQuotes == true ) {
					for(int p = 1; p <= csvDataArray.length-count; p++) { // it should iterate 5 times
						if (csvDataArray[index] != null) {
					csvFormatted[p] = csvDataArray[index]; // 5
						index++;
						}
						else {
							break;
						}
						}
					
					}
					else {
						for(int p = 1; p < csvDataArray.length-1; p++) { // it should iterate 5 times
							csvFormatted[p] = csvDataArray[p]; 
						}
					}
					
						System.out.println(csvFormatted[0]);	
						System.out.println(csvFormatted[1]);	
						System.out.println(csvFormatted[2]);	
						System.out.println(csvFormatted[3]);	
						System.out.println(csvFormatted[4]);	
						System.out.println(csvFormatted[5]);
						System.out.println(csvFormatted[6]);
						System.out.println(csvFormatted[7]);
						
					// WORKS TILL HERE
			
					int cfLength = arrayLength(csvFormatted); // csvFormatted length
					 System.out.println(cfLength);
					
					        if(cfLength > 6) { // too many fields
								System.out.println(csvDataLine);
								System.out.println("Too many fields.");
								
							}
					        else if(cfLength  == 6) { 
					        	for(int i = 0 ; i < cfLength; i++) {
					        		if (csvFormatted[i] == "") { 
					        			System.out.println(csvDataLine);
					        			System.out.println("Missing Field.");
					        		}
					        	}
					        	if(checkGenre(csvFormatted[4]) == false) {
					        		System.out.println(csvDataLine);
					        		System.out.println("Unknown genre."); // THIS WORKS
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
