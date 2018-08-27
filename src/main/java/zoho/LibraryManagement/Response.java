package zoho.LibraryManagement;

import java.util.*;

public class Response {
	private int responseCode;
	private String message;
	private Readers rd = new Readers();
	private Books bk = new Books();
	private ArrayList<Readers> rdList = new ArrayList<Readers>();
	private ArrayList<Books> bkList = new ArrayList<Books>();

	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Readers getRd() {
		return rd;
	}
	public void setRd(Readers rd) {
		this.rd = rd;
	}
	public Books getBk() {
		return bk;
	}
	public void setBk(Books bk) {
		this.bk = bk;
	}
	public ArrayList<Readers> getRdList() {
		return rdList;
	}
	public void setRdList(ArrayList<Readers> rdList) {
		this.rdList = rdList;
	}
	public ArrayList<Books> getBkList() {
		return bkList;
	}
	public void setBkList(ArrayList<Books> bkList) {
		this.bkList = bkList;
	}

}
