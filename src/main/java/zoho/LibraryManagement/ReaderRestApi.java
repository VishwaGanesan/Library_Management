package zoho.LibraryManagement;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/readers")
public class ReaderRestApi {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String setCustomer(Readers obj)
	{
		obj.setReadersId(Readers.getId());
		String response = "";
		response = Database.createReaderRecord(obj);
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Readers> getCustomers()
	{
		return Database.reteriveReaderRecords();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Readers getCustomerById(@PathParam("id") Integer id)
	{
		return Database.reteriveReaderRecord(id);
	}
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCustomer(@PathParam("id") Integer id,Readers newObj)
	{
		String response = "";
		Readers oldObj = Database.reteriveReaderRecord(id);
		response = Database.updateReaderRecord(oldObj,newObj);
		return response;
	}
	@DELETE
	@Path("{id}")
	public String deleteCustomer(@PathParam("id") Integer id)
	{
		String response = "";
		response = Database.deleteReaderRecord(id);
		return response;
	}
	 @POST
	 @Path("{id}/borrowbooks/{isbn}")
	 public String recordBorrowBooks(@PathParam("isbn") Integer isbn,@PathParam("id") Integer id)
	 {
		 String response = Database.updateBorrowBooks(id, isbn);
		 return response;
	 }
	 @GET
	 @Path("{id}/borrowbooks")
	 @Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Books> retrieveBorrowBooksById(@PathParam("id") Integer id)
	 {
		 return Database.retrieveBorrowBooks(id);
	 }
	
}