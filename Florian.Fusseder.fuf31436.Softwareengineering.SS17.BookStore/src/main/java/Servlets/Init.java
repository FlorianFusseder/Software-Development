/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entitys.AbstractBook;
import Entitys.Author;
import Entitys.Customer;
import Entitys.Adress;
import Entitys.BankDetail;
import Entitys.ElectronicBook;
import Entitys.PaperBook;
import Services.BankService;
import Services.BookService;
import Services.PersonService;
import Services.ShoppingService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Florian
 */
@WebServlet(name = "Init", urlPatterns
		= {
			"/Init"
		})
public class Init extends HttpServlet {

	@Inject
	private PersonService personService;

	@Inject
	private BookService bookService;

	@Inject
	private BankService bankService;

	@Inject
	private ShoppingService shoppingService;


	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* todo output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Init</title>");
			out.println("</head>");
			out.println("<body>");
			
			

			Adress addr = new Adress("MusterStrasse", "Musterstadt", 84140);
			BankDetail b = new BankDetail("55551", "55551");
			AbstractBook pb = new PaperBook("Musterbuch", "ff-ff--fff", new Date(), BigDecimal.ONE, 14);
			AbstractBook eb = new ElectronicBook("MusterEBook", "ee-eee-333", new Date(), new BigDecimal(150), "lichensetwo2");

			Customer c1 = personService.createCustomer("Max", "MusterCustomer1", addr, b);
			Customer c2 = personService.createCustomer("Max", "MusterCustomer2", addr, b);
			Author a = personService.createAuthor("Max", "MusterAuthor", addr);

			//todo warum muss ich a zurückgeben um den eintrag für das zweite buch zu haben,
			//aber nicht bei addBookToCarpet
			a = bookService.persistNewBook(eb, a);
			a = bookService.persistNewBook(pb, a);

			shoppingService.addBookToCart(c1, eb);
			shoppingService.addBookToCart(c1, pb);
			shoppingService.addBookToCart(c1, pb);
			
			shoppingService.addBookToCart(c2, eb);
			shoppingService.addBookToCart(c2, pb);
			shoppingService.addBookToCart(c2, pb);
			
			shoppingService.buyCurrentCart(c1);

			out(a.toString(), out);

			out.println("<h1>Servlet Init at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}

	}

	public void out(String text, PrintWriter out) {
		out.println("<h1> " + text + "</h1>");
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
