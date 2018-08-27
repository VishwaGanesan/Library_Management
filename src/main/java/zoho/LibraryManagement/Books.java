package zoho.LibraryManagement;

import java.util.*;

public class Books {
	private String bookName = new String("");
	private int isbn;
	private int readersId;
	private String authorName = new String("");
	private static ArrayList<Books> BooksList = new ArrayList<Books>();
	private static HashMap<Integer,Books> BooksMap = new HashMap<Integer,Books>();
	public static HashMap<Integer, Books> getBooksMap() {
		return BooksMap;
	}
	public static void setBooksMap(HashMap<Integer, Books> booksMap) {
		BooksMap = booksMap;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getReadersId() {
		return readersId;
	}
	public void setReadersId(int readersId) {
		this.readersId = readersId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public static ArrayList<Books> getBooksList() {
		return BooksList;
	}
	public static void setBooksList(ArrayList<Books> booksList) {
		BooksList = booksList;
	}
	
	
}
