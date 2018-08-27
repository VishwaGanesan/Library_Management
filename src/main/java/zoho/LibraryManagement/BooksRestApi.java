package zoho.LibraryManagement;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BooksRestApi {
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
     public static String addBooks(Books b)
     {
		String response = Database.createBooksRecord(b);
		return response;
     }
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Books> getBooks()
	 {
		 return Database.retrieveBookRecords();
	 }
	 @GET
	 @Path("{isbn}")
	 public Books getBookDetails(@PathParam("isbn") Integer isbn)
	 {
		return Database.retrieveBookRecord(isbn);
	 }
	
	 
	 @DELETE
	 @Path("{isbn}")
	 public String deleteBooks(@PathParam("isbn") Integer isbn)
	 {
		 String response = Database.deleteBookRecord(isbn);
		 return response;
	 }
	 
	 @POST
	 @Path("/returnbooks/{isbn}")
	 public String updateReaderDetails(@PathParam("isbn") Integer isbn)
	 {
		 return Database.returnBooks(isbn);
	 }
	 
	 
  
  
}
