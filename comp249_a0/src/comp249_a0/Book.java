package comp249_a0;

public class Book {
	private String title, author;
	private long ISBN;
	private double price;
	private static int numberOfCreatedBooks = 0;
	public Book() {
		title = "";
		author = "";
		ISBN = 0;
		price = 0;
		numberOfCreatedBooks++;
	}
	public Book(String inTitle, String inAuthor, long inISBN, double inPrice){
		title = inTitle;
		author = inAuthor;
		ISBN = inISBN;
		price = inPrice;
		numberOfCreatedBooks++;
	}
	public Book(Book AnotherBook) {
		this.title = AnotherBook.title;
		this.author = AnotherBook.author;
		this.ISBN = AnotherBook.ISBN;
		this.price = AnotherBook.price;
	}
	// getter methods
	public String getTitle() {
	return title;
	}
	public String getAuthor() {
	return author;
	}
	public long getISBN() {
	return ISBN;
	}
	public double getPrice() {
	return price;
	}

	// setter methods 
	public void setTitle(String inTitle) {
	title = inTitle;
	}
	public void setAuthor(String inAuthor) {
	author = inAuthor;
	}
	public void setISBN(long inISBN) {
	ISBN = inISBN;
	}
	public void setPrice(double inPrice) {
	price = inPrice;
	}

// find number of created books
	public static int findNumberOfCreatedBooks(Book[] bookArray){
		return numberOfCreatedBooks;
}
// to equal method
	public boolean equals(Book anotherBook) {
	        if (this == anotherBook) {
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
// to string method
	public String toString() {
	        return "Author: " + author + "\nTitle: " + title + "\nISBN: " + ISBN + "\nPrice: " + price ;
	}
}
