package zoho.LibraryManagement;

import java.util.*;
public class Readers {
	private String name = new String();
	private static int id = 0;
	private int readersId = 0;
	private int fine = 0;
	private ArrayList<Books> borrowedBooks = new ArrayList<Books>();
	private ArrayList<Books> overdueBooks = new ArrayList<Books>();
	
	public int getReadersId() {
		return readersId;
	}

	public void setReadersId(int readersId) {
		this.readersId = readersId;
	}

	public static int getId() {
		return ++id;
	}

	public static void setId(int id) {
		Readers.id = id;
	} 


	public int getFine() {
		return fine;
	}

	public ArrayList<Books> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(ArrayList<Books> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public ArrayList<Books> getOverdueBooks() {
		return overdueBooks;
	}

   public void setOverdueBooks(ArrayList<Books> overdueBooks) {
		this.overdueBooks = overdueBooks;
	} 

	public void setFine(int fine) {
		this.fine = fine;
	}

	
	public String getName() {
	
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
  }
