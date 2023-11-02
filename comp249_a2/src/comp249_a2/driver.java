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
	
		
	public static void do_part1(){
		BufferedReader inputFileReader = null;
		String[] csvFileName = null;
		try { 
			// create buffered reader to read all input file name 
			inputFileReader =
					new BufferedReader(new FileReader("/Users/miiyao7/eclipse-workspace/comp249_a2/src/comp249_a2/part1_input_file_names.txt"));
			
			// retrieve the number of files in part1_input_file_names.txt
			String line = inputFileReader.readLine();
			int nbOfLines = Integer.parseInt(line); // nbOfLines = 16
			// create an array that stores all the names of the csv files
			csvFileName = new String[nbOfLines];
			for(int x = 0; x < nbOfLines; x++) {
				csvFileName[x] = inputFileReader.readLine();
			//	System.out.println(csvFileName[x]);//display the array of file name in part1_input_file_names for verification !!delete later!!
			}
			
			inputFileReader.close(); // close the inputFileReader
			
			
			for (int i = 0; i < nbOfLines; i++) { // for loop to iterate through csvFileName array
			// create buffered reader to read the data from the csv file
			BufferedReader csvReader = 
					new BufferedReader(new FileReader("/Users/miiyao7/eclipse-workspace/comp249_a2/src/comp249_a2/"+csvFileName[i]));
			// FOR VERIFICATION PURPOSES 
			String nameCSV =( csvFileName[i]+".csv");
			System.out.println("\n"+nameCSV);
			// create an array that stores the data of each csv file
			String[] csvData = new String[300]; // max elements of 100 
			String[] csvDataArray = null;
			String[] csvDataName = null;
			for(int x = 0; x < 300; x++) { //for loop to iterate through all the elements of the csv file
				while(csvReader.readLine() !=null) { // if the next line is not null then continue
					csvData[x] = csvReader.readLine();
				String csvDataLine = csvData[x];
				if(csvDataLine != null && csvDataLine.contains("\"")) {
					String temp = csvDataLine.replace("\"", "");
					csvDataArray = csvDataLine.split(",");
				}
				else if(csvDataLine != null) {
					csvDataArray = csvDataLine.split(",");
				}
				else
					continue;
				//	System.out.println("CSV data line is NULL.");
				
				if(csvDataArray.length > 5) {
				//	System.out.println(csvDataLine);
				//	System.out.println("Too many fields.");
				}
				else if(csvDataArray.length == 5) {
					for(int y = 0; y < csvDataArray.length; y++) {
						if(csvDataArray[y]== null) {
							//System.out.println(csvDataLine);
							//System.out.println("Missing field.");
						}
				else if(csvDataArray.length < 5) {
				//	System.out.println(csvDataLine);
					//System.out.println("Too few fields.");
				}
				
					
				}
				}
				
			//	System.out.println(csvDataLine); //display the elements of the file.csv.txt !!delete later!!
				}	 
				csvReader.close(); // close the csvReader
				break;
			}
			}
		}
		
	
		
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

