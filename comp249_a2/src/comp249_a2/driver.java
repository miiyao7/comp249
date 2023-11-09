package comp249_a2;
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
		
		if (s== null) {
			return false;
		}
		else {
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
	}
	
	public static int getNbLines(String path){
		BufferedReader inputFileReader = null;
		
		try { 
			// create buffered reader to read all input file name 
			inputFileReader =
					new BufferedReader(new FileReader(path));
			
			// retrieve the number of files in part1_input_file_names.txt
			String line = inputFileReader.readLine();
			int nbOfLines = Integer.parseInt(line); // nbOfLines = 16
			
			inputFileReader.close(); // close the inputFileReader
			
			return nbOfLines;
			
	}
		catch(IOException e) {
			System.out.println(path + " was not found");
			System.out.println("or could not be opened");
			return -1;
		}
	}
	
	public static String[] readCSVFileName(String path, int nbOfLines) throws IOException {
		BufferedReader inputFileReader = null;
		String[] csvFileName = null;
		try { 
			// create buffered reader to read all input file name 
			inputFileReader =
					new BufferedReader(new FileReader(path));
			
			String buffer = inputFileReader.readLine();
			// create an array that stores all the names of the csv files
			csvFileName = new String[nbOfLines];
			for(int x = 0; x < nbOfLines; x++) {
				csvFileName[x] = inputFileReader.readLine();
			}
			
			
			inputFileReader.close(); // close the inputFileReader
			
			
			return csvFileName;
	}
		catch(IOException e) {
			System.out.println(path + " was not found");
			System.out.println("or could not be opened");
			csvFileName = null;
			return csvFileName;
		}
	}
////////////////////////////////////// count the lines in a file
	private static int countLines(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int numLines = 0;
        while (reader.readLine() != null) {
            numLines++;
        }
        reader.close();
        return numLines;
    }
/////////////////////////////////// remove commas in quotation marks
	public static String format(String csvDataLine) {
		if(csvDataLine.contains("\"")) {
			int q1 = csvDataLine.indexOf("\"");
			int q2 = csvDataLine.lastIndexOf("\"");
			String quottedString = csvDataLine.substring(q1,q2+1); 
			//// remove all commas from quotted strings
			String removedCommas = quottedString.replaceAll(",", "");
			csvDataLine = removedCommas + csvDataLine.substring(q2+1);
			return csvDataLine;
		}
		else {
			return csvDataLine;
		}
		
	}
////////////////////////////////////// retrieve all line from a file
	public static String[] readCSVFileData(String path) throws IOException{
		
		
			// create buffered reader to read the data from the csv file
			BufferedReader csvReader = 
					new BufferedReader(new FileReader(path));
			
					int nbLines = countLines(path);
					
					System.out.print(nbLines); //14
					
					String[] csvData = new String [nbLines];
					
					String csvDataLine;
					
					int x = 0;	
					
				while ((csvDataLine = csvReader.readLine()) != null) {
					
					csvData[x++] = csvDataLine;	
				}
				
				csvReader.close(); // close the csvReader
			
		return csvData; // array that store all the lines from a file
		
	}
	
	/////////////////////// split the line of a file into at every ',' and return its array
	public static String[] getDataParts(String csvData){
		String[] csvDataArray = null;
		String csvDataLine;
		
		while(csvData !=null) { // if the next line is not null then continue
			csvDataLine = format(csvData);
			csvDataArray = csvDataLine.split(","); // array that contents the parts of one line of the file
		}
		
		return csvDataArray;
	}
	
	public static void syntaxHandling( String csvData, String nameCSV, String path) throws IOException {
		
		String[] csvDataArray = getDataParts(csvData);
		int cfLength = arrayLength(csvDataArray);
		
	
		FileWriter syntaxE = new FileWriter("src/comp249_a2/syntax_error_file.txt");
		
		
        if(cfLength > 6) { // too many fields
        	try {
        		throw new TooManyFieldsException(csvData);
        	}
        	catch (TooManyFieldsException e) {
    			syntaxE.write("syntax error in file: " + nameCSV); // THIS WORKS
    			syntaxE.write("======================");
    			syntaxE.write("Error: too many field.");
    			syntaxE.write(csvData);
    			syntaxE.close();
    		}	
			
		}
        
        if(cfLength  == 6) { 
        	
        	for(int i = 0 ; i < cfLength; i++) {
        		if (csvDataArray[i] == "") { 
        			try {
        				throw new MissingFieldException(csvData);
        			}
        			catch (MissingFieldException e){
        				syntaxE.write("syntax error in file: " + nameCSV); // THIS WORKS
            			syntaxE.write("======================");
            			syntaxE.write("Error: missing field. (year)");
            			syntaxE.write(csvData);
            			syntaxE.close();
        			}
        		}
        	}
        		if(checkGenre(csvDataArray[4]) == false && csvDataArray[4] != null) {
        		try {
        			throw new UnknownGenreException(csvData);
        		}
        		catch (UnknownGenreException e) {
        			syntaxE.write("syntax error in file: " + nameCSV); // THIS WORKS
        			syntaxE.write("======================");
        			syntaxE.write("Error: invalid genre.");
        			syntaxE.write(csvData);
        			syntaxE.close();
        		}	
        	}
        		else {
        		try {
    				throw new MissingFieldException(csvData);
    			}
    			catch (MissingFieldException e){
    				syntaxE.write("syntax error in file: " + nameCSV); // THIS WORKS
        			syntaxE.write("======================");
        			syntaxE.write("Error: missing field. (genre) ");
        			syntaxE.write(csvData);
        			syntaxE.close();
    			}
        	}
        
        }
        
        if(cfLength < 6) { // too few fields
  
        		if (csvData.endsWith(",")) { 
        			try {
        				throw new MissingFieldException(csvData);
        			}
        			catch (MissingFieldException e){
        				syntaxE.write("syntax error in file: " + nameCSV); // THIS WORKS
            			syntaxE.write("======================");
            			syntaxE.write("Error: missing field. (year)");
            			syntaxE.write(csvData);
            			syntaxE.close();
        			}
        		}
        		else {
        			try {
        				throw new TooFewFieldsException(csvData);
        			}
        			catch (TooFewFieldsException e){
        				syntaxE.write("syntax error in file: " + nameCSV); // THIS WORKS
            			syntaxE.write("======================");
            			syntaxE.write("Error: too few fields");
            			syntaxE.write(csvData);
            			syntaxE.close();
        			}
        			
        		}
		}
        
        else {
        	System.out.println("Everything is okay! ");
        	return;
        }
     return;
	}
		
	public static void do_part1() {
		try {
			
		
		int nbOfLines = getNbLines("src/comp249_a2/part1_input_file_names.txt");
	
		 
		String[] csvFileName = readCSVFileName("src/comp249_a2/part1_input_file_names.txt", nbOfLines); // array that stores all the csv file names
		
		
		
		
		//////////// looping through the files
		//for (int n = 0; n<nbOfLines; n++) {
			String path = "";
			path = "src/comp249_a2/";
			
		  //System.out.println("\n" + csvFileName[n]);
		  
		 // path = path + csvFileName[n];
		  
		  String[]csvData = readCSVFileData("src/comp249_a2/books1995.csv.txt");
		  
		  System.out.println(csvData.length);
		  
		  for (int x =0; x<csvData.length;x++) {
			  
		 //  System.out.println(csvData[x]);
		  
		  syntaxHandling( csvData[x], "book1995.csv.text", path);
		  System.out.println("it still runs");
		  
		  }
		  
		    System.out.println("it still runs");
		//}
			

			 
		}
		 
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
