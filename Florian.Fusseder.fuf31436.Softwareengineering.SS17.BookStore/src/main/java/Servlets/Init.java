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
import Entitys.PBookData;
import Entitys.PaperBook;
import Services.PersonService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "Init", urlPatterns =
{
    "/Init"
})
public class Init extends HttpServlet
{

    @Inject
    private PersonService personService;

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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Init</title>");
            out.println("</head>");
            out.println("<body>");

            Adress addr = new Adress("MusterStrasse", "Musterstadt", 84140);
            BankDetail b = new BankDetail("55551", "55551");
            
            Author a = new Author("MaxAuthor", "MusterAuthor", addr, 0);
            Customer c = new Customer("Max", "MusterCustomer", addr);
            
            personService.persistAuthor(a);
            personService.persistCustomer(c);
            c = personService.persistCustomer(c, b);
            
            List<PBookData> pbd = new ArrayList<>();
            pbd.add(new PBookData("oben rechts", "zum verkauf"));
            pbd.add(new PBookData("unten links", "unterwegs"));
            
            PaperBook pb = new PaperBook("Musterbuch", "ff-ff--fff", new Date(), BigDecimal.ONE, pbd);
            ElectronicBook eb = new ElectronicBook("MusterEBook", "ee-eee-333", new Date(), new BigDecimal(150), "lichensetwo2");
            
            personService.persistNewBook(a, pb);
            personService.persistNewBook(a, eb);
            
            List<AbstractBook> l = new ArrayList<>();
            l.add(pb);
            l.add(eb);
            //l.add(pb); todo works not with double
            
            personService.persistBill(c, l);
            //personService.persistBill(c, eb);
            //personService.persistBill(c, pb);

            out.println("<h1>Servlet Init at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
