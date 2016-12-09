/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.servicetester;

import java.util.List;

/**
 *
 * @author Florian
 */
public class ServiceTester {
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		
		
		try { // Call Web Service Operation
			services.BookServiceService service = new services.BookServiceService();
			services.BookService port = service.getBookServicePort();
			// TODO process result here
			java.util.List<services.AbstractBook> result = port.findAll();
			System.out.println("Result = "+result);
		} catch (Exception ex) {
			// TODO handle custom exceptions here
			System.out.println(ex.toString());
		}
		
		
		try { // Call Web Service Operation
			services.BookServiceService service = new services.BookServiceService();
			services.BookService port = service.getBookServicePort();
			// TODO initialize WS operation arguments here
			java.lang.String arg0 = "Harry";
			// TODO process result here
			java.util.List<services.AbstractBook> result = port.searchBooks(arg0);
			System.out.println("Result = "+result);
		} catch (Exception ex) {
			// TODO handle custom exceptions here
			System.out.println(ex.toString());
		}


		
		
		
	}
}
