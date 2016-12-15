/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.florian.fusseder.fuf31436.softwaredevelopment.ss17.bookstore.tester;

/**
 *
 * @author Florian
 */
public class Tester {

	public static void main(String[] args) {

		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

		try { 
			services.BookServiceService service = new services.BookServiceService();
			services.BookService port = service.getBookServicePort();
			java.util.List<services.AbstractBook> result = port.findAll();
			System.out.println("Result = " + result);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try { 
			services.BookServiceService service = new services.BookServiceService();
			services.BookService port = service.getBookServicePort();
			java.lang.String arg0 = "harry";
			java.util.List<services.AbstractBook> result = port.searchBooks(arg0);
			System.out.println("Result = " + result);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
