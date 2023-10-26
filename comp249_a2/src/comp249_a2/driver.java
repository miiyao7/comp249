package comp249_a2;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class driver {

	public static void main(String[] args) {
	//	do_part1();
	//	do_part2();
	//	do_part3();
		
	//	System.out.println("Current working directory: " + System.getProperty("user.dir")); 
		
		try { 
			BufferedReader inputStream =
					new BufferedReader(new FileReader("/Users/miiyao7/eclipse-workspace/comp249_a2/src/comp249_a2/part1_input_file_names.txt"));
				//	new BufferedReader(new FileReader("./comp249_a2/part1_input_file_names.txt"));
			
 
			String line = inputStream.readLine();
			int nbOfLines = Integer.parseInt(line);
					
			String[] csvFileName = new String[nbOfLines];
			for(int x = 0; x < nbOfLines; x++) {
				csvFileName[x] = inputStream.readLine();
				System.out.println(csvFileName[x]);//display the array of file name in part1_input_file_names
			}
			
			inputStream.close();
			
			
			for (int i = 0; i < nbOfLines; i++) {
			BufferedReader csvReader = 
					new BufferedReader(new FileReader("/Users/miiyao7/eclipse-workspace/comp249_a2/src/comp249_a2/"+csvFileName[i]));
			String nameCSV =( csvFileName[i]+".csv");
			System.out.println("\n"+nameCSV);
			
			String[] csvData = new String[300]; // max elements of 100 
			
			for(int x = 0; x < 300; x++) {
				while(csvReader.readLine() != null) {
				csvData[x] = csvReader.readLine();
				System.out.println(csvData[x]); //display the elements of the file.csv.txt
				}	 
			}
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

}
