package zoho.LibraryManagement;

import java.sql.*;
import java.util.*;

public class Database {
	// operations on readers -----------------------------------------------------------------------------------------------------------
	public static  String createReaderRecord(Readers obj)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt2 = con.createStatement();
			ResultSet rs = stmt2.executeQuery("select MAX(readersId) readersId  from readers");
			rs.next();
			Readers.setId(rs.getInt("readersId")+1); // for setting the id 
			PreparedStatement stmt = con.prepareStatement("insert into readers (name,readersId,fine) values(?,?,?);");
			stmt.setString(1,obj.getName());
			stmt.setInt(2,obj.getReadersId());     // create
			stmt.setInt(3,obj.getFine());
			stmt.executeUpdate();
			return "Success,\nMessage:Reader record added succesfully\n :)";
		}
		catch(Exception er)
		{
			return "Error message:"+er.toString();
		}
	}
	public static ArrayList<Readers> reteriveReaderRecords()
	{
		ArrayList<Readers> response  = new ArrayList<Readers>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from readers;");
			while(rs.next())
			{
				Readers r = new Readers();
				r.setName(rs.getString("name"));            //read all record
				r.setReadersId(rs.getInt("readersId"));
				r.setFine(rs.getInt("fine"));
			    r.setBorrowedBooks(retrieveBorrowBooks(rs.getInt("readersId")));
				response.add(r);
				System.out.println(response);
			}
			return response;
		}
		catch(Exception er)
		{
			System.out.println(er.toString());
			return response;
		}
	}
	public static Readers reteriveReaderRecord(int id)
	{
		Readers response  = new Readers();
		try                                                    // read single record
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from readers where readersId = "+id+";");
			if(rs.next())
			{
				response.setName(rs.getString("name"));
				response.setReadersId(rs.getInt("readersId"));
				response.setFine(rs.getInt("fine"));
				response.setBorrowedBooks(retrieveBorrowBooks(rs.getInt("readersId")));
				return response;
			}
			else
			{
				return response;
			}
		}
		catch(Exception er)
		{
			return response;
		}
	}
	public static String updateReaderRecord(Readers oldObj,Readers newObj)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from readers where readersId = "+oldObj.getReadersId()+";");
			rs.next();
			if(!newObj.getName().equals("") && !oldObj.getName().equals(newObj.getName())) // update record
			{
				stmt.executeUpdate("update readers set name ='"+newObj.getName()+"' where readersId = "+oldObj.getReadersId()+";");
			}
			if(oldObj.getFine() != 0 && oldObj.getFine() != newObj.getFine())
			{
				stmt.executeUpdate("update readers set fine ="+newObj.getFine()+"  where readersId = "+oldObj.getReadersId()+";");
			}
			return "Success:\\nMessage:Reader record updated succesfully\\n :)";
		}
		catch(Exception er)
		{
			return "Error message:"+er.toString();
		}
	}
	public static String deleteReaderRecord(int id)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();                                // delete record
			stmt.execute("delete from readers where readersId ="+id);
			return "Success:\\nMessage:Reader record deleted succesfully\\n :)";
		}
		catch(Exception er)
		{
			return "Error message:"+er.toString();
		}
	}
	// Operations on Books ---------------------------------------------------------------------------------------------------------------
	public static  String createBooksRecord(Books obj)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			PreparedStatement stmt = con.prepareStatement("insert into books (book_name,isbn,author_name) values(?,?,?);");
			stmt.setString(1,obj.getBookName());
			System.out.println(obj.getIsbn());
			stmt.setInt(2,obj.getIsbn());
			stmt.setString(3,obj.getAuthorName());
			stmt.executeUpdate();                               // create book record
			return "Success:\nMessage:Books record created succesfully :)";
		}
		catch(Exception er)
		{
			return "Error message:"+er.toString();
		}
	}
	public static ArrayList<Books> retrieveBookRecords()
	{
		ArrayList<Books> response  = new ArrayList<Books>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root",""); // read all book record
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books");
			while(rs.next())
			{
				Books r = new Books();
				r.setBookName(rs.getString("book_name"));
				r.setIsbn(rs.getInt("isbn"));
				r.setAuthorName(rs.getString("author_name"));
				r.setReadersId(rs.getInt("reader_id"));
				response.add(r);
			}
			return response;
		}
		catch(Exception er)
		{
			return response;
		}
	}
	public static Books retrieveBookRecord(int isbn)
	{
		Books response  = new Books();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books where isbn = "+isbn+";");      // read single book record
			rs.next();
			response.setBookName(rs.getString("book_name"));
			response.setIsbn(rs.getInt("isbn"));
			response.setAuthorName(rs.getString("author_name"));
			response.setReadersId(rs.getInt("reader_id"));
			return response;
		}
		catch(Exception er)
		{
			return response;
		}
	}
	public static String deleteBookRecord(int isbn)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root",""); // delete book record
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			ResultSet rs = stmt1.executeQuery("select * from books where isbn ="+isbn);
			if(rs.next())
			{
				stmt.execute("delete from books where isbn ="+isbn); 
				return "Book deleted successfully! :)";
			}
			else
			{
				return "Book is not available in Library!! :(";
			}
		}
		catch(Exception er)
		{
			return "Error message:"+er.toString();
		}
	}
	//Borrowbooks operations -----------------------------------------------------------------------------------------------------
	public static String updateBorrowBooks(int id,int isbn)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select * from books where isbn = "+isbn);
			ResultSet rs2 = stmt2.executeQuery("Select * from readers where readersId = "+id);
			ResultSet rs = stmt.executeQuery("select * from books where isbn = "+isbn);
			rs2.next();
			if(!rs.next())
			{
				return "This book is not available at this Library! :(";
			}
			else if(rs.getInt("reader_Id") == 0)
			{
				Statement stmt3 = con.createStatement();
				stmt3.executeUpdate("update books set reader_Id = "+id+" where isbn ="+isbn);
				return "Success:\nMessage:"+rs.getString("book_name")+" is lended to  "+rs2.getString("name")+" :)";
				
			}
			else
			{
				return "Sorry! book is not available at this moment! :(";
			}
		}
		catch(Exception er)
		{
			return "Error Message"+er.toString();
		}
	}
	public static ArrayList<Books> retrieveBorrowBooks(int id)
	{
		ArrayList<Books> booksList = new ArrayList<Books>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select isbn from books where reader_id = "+id);
			while(rs.next())
			{
				booksList.add(retrieveBookRecord(rs.getInt("isbn")));
			}
			return booksList;
		}
		catch(Exception er)
		{
			return booksList;
		}
	}
	// returnBooks operation ------------------------------------------------------------------------------------------------
	public static String returnBooks(int isbn)
	{
		try
		{	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			ResultSet rs = stmt1.executeQuery("select reader_id from books where isbn ="+isbn);
			rs.next();
			if(rs.getInt("reader_id") == 0)
			{
				return "Book is already available in Library :(";
			}
			else
			{
				stmt.executeUpdate("update books set reader_Id = NULL where isbn ="+isbn);    // update returnbooks
				return "Book returned recorded successfully :)";
			}
		}
		catch(Exception er)
		{
			return er.toString();
		}
	}
}
