package comp249_a0;
import java.util.Scanner;
public class assignment0 {

	public static void main(String[] args){
			
			Scanner keyIn = new Scanner (System.in);
			int maxBooks, choice, bookIndex, keyboard, count;
			
			String passsword = "249";
			
			System.out.println("Welcome to the Bookstore Storage Software!");
			System.out.print("Please enter the maximum number of books your bookstore can contain: ");
			maxBooks = keyIn.nextInt();
			Book[] inventory = new Book[maxBooks];
			
			int counter = 0;
			while (counter < 4) {
			System.out.println("\nWhat do you want to do?");
			System.out.println("1. Enter new books (password required)");
			System.out.println("2. Change information of a book (password required)");
			System.out.println("3. Display all books by a specific author");
			System.out.println("4. Display all books under a certain a price.");
			System.out.println("5. Quit");
			System.out.print("Please enter your choice > ");
			choice = keyIn.nextInt();
			
			switch(choice) {
			case 1:
				count = 0;
					System.out.print("Enter the password: ");
				
				while (count < 3) {	
					String userInput = keyIn.next();
				if (userInput.equals(passsword)) {
					System.out.println("Correct password!");
					System.out.print("How many books would like to enter? ");
					keyboard = keyIn.nextInt();
					int nbOfCreatedBooks = Book.findNumberOfCreatedBooks(inventory);
					if (nbOfCreatedBooks >= maxBooks) {
						System.out.println("There is no more places to add books.");
					}
					else if ((nbOfCreatedBooks+keyboard) >= maxBooks) {
						int extraBooks = (nbOfCreatedBooks+keyboard) - maxBooks;
						System.out.println("There is not enough place to add this many books.");
					}
					else {
					for (int i = 0; i<keyboard; i++) {
						System.out.print("Author: ");
						String author = keyIn.next();
						System.out.print("Title: ");
						String title = keyIn.next();
						System.out.print("ISBN: ");
						long ISBN = keyIn.nextLong();
						System.out.print("Price: ");
						double price = keyIn.nextDouble();
						Book newBook = new Book(author, title, ISBN, price);
						for(int x = 0; x < inventory.length; x++) {
							if (inventory[x]== null) {
								inventory[x] = newBook;
							}
							else
								continue;
						}
						System.out.print("Next book!\n");
					}
					System.out.println("The books have been added!");
					}
					
					break;
				}
				else {
					count++;
				}
				if (count >= 3) {
				break;
				}
				System.out.print("Wrong password! Enter the correct password: ");
				} 
				counter++;
				break;
				
			case 2:
				count = 0;
				
				System.out.print("Enter the password: ");
				
				while (count < 3) {	
					String userInput = keyIn.next();
				if (userInput.equals(passsword)) {
					// missing d.ii
					System.out.println("Correct password!");
					break;
				}
				else {
					count++;
				}
				if (count >= 3) {
				break;
				}
				System.out.print("Wrong password! Enter the correct password: ");
				} 
				
				System.out.print("What book number would you like to update? ");
				bookIndex = keyIn.nextInt();
				for (int x=0; x<=inventory.length; x++) {
				if (inventory[bookIndex]== null) {
				System.out.print("Invalid book number! Enter '0' if you like to re-enter another book or enter '1' if you would you like to quit this operation.");
				keyboard = keyIn.nextInt();
				if (keyboard == 0) {
				}
				else {
				break;
				}
				}
				else {
				System.out.println("Book #" + bookIndex);
				inventory[bookIndex].toString();
				System.out.println("What information would you like to change?");
				System.out.println("1. author");
				System.out.println("2. title");
				System.out.println("3. ISBN");
				System.out.println("4. price");
				System.out.println("5. Quit");
				System.out.print("Enter your choice > ");
				
				}}
			break;
			
			case 3:
				break;
				
			case 4:
				break;
			
			case 5:
				System.exit(0);
				break;
			
			}
			}
			System.out.println("Program detected suspicious activities and will terminate immediately!");
			System.exit(0);
	}
}

		



