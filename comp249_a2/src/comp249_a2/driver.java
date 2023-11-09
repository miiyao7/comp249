package a2_comp249;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class driver {
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

	
	public static int getNbLines(String path) throws IOException{
		BufferedReader inputFileReader = null;
		
			// create buffered reader to read all input file name 
			inputFileReader =
					new BufferedReader(new FileReader(path));
			
			// retrieve the number of files in part1_input_file_names.txt
			String line = inputFileReader.readLine();
			int nbOfLines = Integer.parseInt(line); // nbOfLines = 16
			
			inputFileReader.close(); // close the inputFileReader
			
			return nbOfLines;
		
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
		
			csvDataLine = format(csvData);
			
			csvDataArray = csvDataLine.split(","); // array that contents the parts of one line of the file
		
		
		return csvDataArray;
	}
	
	public static void syntaxHandling(String[] csvData, String nameCSV, String path) throws IOException {
		
	    FileWriter syntaxE = new FileWriter("src/a2_comp249/syntax_error_file.txt", true); // Append mode
	    
        syntaxE.write("\n\nsyntax error in file: " + nameCSV);
        syntaxE.write("\n======================");
        
	    for (int x = 0; x < csvData.length; x++) {
	        String csvDataLine = csvData[x];
	        String[] csvDataArray = getDataParts(csvDataLine);
	        int cfLength = arrayLength(csvDataArray);
	        
	        if (cfLength > 6) {
	            try {
	                throw new TooManyFieldsException(csvDataLine);
	            } catch (TooManyFieldsException e) {
	                
	                syntaxE.write("\nError: too many fields.\n");
	                syntaxE.write(csvDataLine);
	            }
	        } else if (cfLength == 6) {
	            for (int i = 0; i < cfLength; i++) {
	                if (csvDataArray[i] == null || csvDataArray[i].isEmpty()) {
	                    try {
	                        throw new MissingFieldException(csvDataLine);
	                    } catch (MissingFieldException e) {
	                        
	                        syntaxE.write("\nError: missing field.\n");
	                        syntaxE.write(csvDataLine);
	                    }
	                }
	            }
	            if (!checkGenre(csvDataArray[4]) && csvDataArray[4] != null) {
	                try {
	                    throw new UnknownGenreException(csvDataLine);
	                } catch (UnknownGenreException e) {
	                   
	                    syntaxE.write("\nError: invalid genre.\n");
	                    syntaxE.write(csvDataLine);
	                }
	            }
	          
	        } else if (cfLength < 6) {
	            if (csvDataLine.endsWith(",")) {
	                try {
	                    throw new MissingFieldException(csvDataLine);
	                } catch (MissingFieldException e) {
	                   
	                    syntaxE.write("\nError: missing field. (year)\n");
	                    syntaxE.write(csvDataLine);
	                }
	            } else {
	                try {
	                    throw new TooFewFieldsException(csvDataLine);
	                } catch (TooFewFieldsException e) {
	                	syntaxE.write("\nError: too few fields\n");
	                    syntaxE.write(csvDataLine);
	                }
	            }
	        }
	        else if(validPrice(csvData[x]) == false) {
	        	try {
	        		throw new InvalidPriceException(csvDataLine);
	        	}catch (InvalidPriceException e) {
                 
                    syntaxE.write("\nError: invalid price\n");
                    syntaxE.write(csvDataLine);
                }
	        	
	        }
	        else if(validYear(csvData[x]) == false) {
	        	try {
	        		throw new InvalidYearException(csvDataLine);
	        	}catch (InvalidYearException e) {
                   
                    syntaxE.write("\nError: invalid year\n");
                    syntaxE.write(csvDataLine);
                }
	        	
	        }
	        else if(validISBN(csvData[x]) == false) {
	        	try {
	        		throw new InvalidISBNException(csvDataLine);
	        	}catch (InvalidISBNException e) {
                   
                    syntaxE.write("\nError: invalid ISBN\n");
                    syntaxE.write(csvDataLine);
                }
	        }
	        else
	        	genreFile(csvData);
	    }

	    syntaxE.close(); // Close the FileWriter
	}
	
		public static void genreFile(String[] csvData){
			try {
				 
			 for (int x = 0; x < csvData.length; x++) {
			        String[] csvDataArray = getDataParts(csvData[x]);
			        String genre = csvDataArray[4];
			    	if (genre == null) {
					}
					else {
					switch (genre) {
					case "CCB" :
						FileWriter ccb = new FileWriter("src/a2_comp249/csv_files/Cartoon_Comics.csv.txt",true);
						ccb.write(csvData[x]+ "\n");
						ccb.close();
						break;
					case "HCB" :
						FileWriter hcb = new FileWriter("src/a2_comp249/csv_files/Hobbies_Collectibles.csv.txt",true);
						hcb.write(csvData[x]+ "\n");
						hcb.close();
						break;
					case "MTV" :
						FileWriter mtv = new FileWriter("src/a2_comp249/csv_files/Movies_TV_Books.csv.txt",true);
						mtv.write(csvData[x]+ "\n");
						mtv.close();
						break;
					case "MRB" :
						FileWriter mrb = new FileWriter("src/a2_comp249/csv_files/Music_Radio_Books.csv.txt",true);
						mrb.write(csvData[x]+ "\n");
						mrb.close();
						break;
					case "NEB" :
						FileWriter neb = new FileWriter("src/a2_comp249/csv_files/Nostalgia_Eclectic_Books.csv.txt",true);
						neb.write(csvData[x]+ "\n");
						neb.close();
						break;
					case "OTR" :
						FileWriter otr = new FileWriter("src/a2_comp249/csv_files/Old_Time_Radio_Books.csv.txt",true);
						otr.write(csvData[x]+ "\n");
						otr.close();
						break;
					case "SSM" :
						FileWriter ssm = new FileWriter("src/a2_comp249/csv_files/Sports_Sports_Memorabilia.csv.txt",true);
						ssm.write(csvData[x]+ "\n");
						ssm.close();
						break;
					case "TPA" :
						FileWriter tpa = new FileWriter("src/a2_comp249/csv_files/Trains_Planes_Automobiles.csv.txt",true);
						tpa.write(csvData[x]+ "\n");
						tpa.close();
						break;
		
					}
				}
			 }
			} 
			 catch(Exception e) {
					System.out.print("");
				}
		}
		
		
		/// count for lines in the csv files
	
		public static boolean validPrice(String csvData) {

	
			        String[] csvDataArray = getDataParts(csvData);
			        double price = Double.parseDouble(csvDataArray[2]);
			
			if (price < 0) {
				return false;
			}
			else
				return true;
			 }
		
		public static boolean validYear(String csvData) {

			
	        String[] csvDataArray = getDataParts(csvData);
	        int year = Integer.parseInt(csvDataArray[5]);
	
	        if (year >= 1995 && year <= 2010) {
	        	return true;
	        }
	        else
	        	return false;
			}
		
		public static boolean validISBN(String csvData) {

	        String[] csvDataArray = getDataParts(csvData);
	        int nbOfDigits = (csvDataArray[3]).length(); // nb of digits
	if (nbOfDigits == 10) {
		int[] digits = new int[10];
		int sum =0;
		int p =10;
		
		for (int n =0; n < 10; n++) {
			
			char digitChar = csvDataArray[3].charAt(n);
			digits[n]= Character.getNumericValue(digitChar);
		}
		
		while (p>0) {
			for (int b = 0; b < 10; b++) {
				sum += p*digits[b];
			}
		}
		
		if (sum%11 == 0) {
			return true;
		}
		else 
			return false;
		
	}
	else if (nbOfDigits == 13) {
		int[] digits = new int[13];
		int sum =0;
		int p=0;
		
		for (int n =0; n < 13; n++) {
			char digitChar = csvDataArray[3].charAt(n);
			digits[n]= Character.getNumericValue(digitChar);
		}
		
		while (p < 13) {
			for (int b = 0; b < 6; b++) {
				sum += digits[p++];
				sum += 3*digits[p];
			}
			sum += digits[p];
			
			p++;
		}
		if (sum%10 == 0) {
			return true;
		}
		else 
			return false;	
	}
	else 
		return false;
	
	}
		
		
	public static void do_part1() { /// syntax errors handling
		try {
		//int nbOfLines = getNbLines("src/comp249_a2/part1_input_file_names.txt");
			int nbOfLines = getNbLines("src/a2_comp249/part1_input_file_names.txt");
			
			String[] csvFileName = readCSVFileName("src/a2_comp249/part1_input_file_names.txt", nbOfLines); // array that stores all the csv file names
		
		//////////// looping through the files
		
		for (int n = 0; n<nbOfLines; n++) {
			
		String path = "";
			
		path = "src/a2_comp249/";
			
		  System.out.println("\n" + csvFileName[n]);
		  
		  path = path + csvFileName[n];
		  
		  String[]csvData = readCSVFileData(path);
		  
		 
		  
		//  genreFile(csvData, csvFileName[n], path);
		  
		} 
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
	
	public static void do_part2() {   ////  semantics errors handling
		try {
			
			String[] genreName = {"Cartoon_Comics.csv.txt", "Hobbies_Collectibles.csv.txt", "Movies_TV_Books.csv.txt", "Music_Radio_Books.csv.txt", "Nostalgia_Eclectic_Books.csv.txt", "Old_Time_Radio_Books.csv.txt", "Sports_Sports_Memorabilia.csv.txt", "Trains_Planes_Automobiles.csv.txt"};
					

		for (int n = 0; n<genreName.length; n++) {
			
		String path = "";
			
		path =("src/a2_comp249/csv_files/");
			
		  System.out.println("\n" + genreName[n]);
		  
		  path = path + genreName[n];
		  
		  String[]csvGenreData = readCSVFileData(path);
		  
		  syntaxHandling( csvGenreData, genreName[n], path);
		  
		} 
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
	
	
	public static void main(String[] args) {
			
			do_part1(); 
			do_part2();
		//	do_part3();

	}
	
	
		

}
