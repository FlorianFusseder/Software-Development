/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entity.Adresse;
import Entity.Email;
import Entity.Professor;
import Entity.Pruefungen;
import Entity.Student;
import Service.DBService;
import java.io.IOException;
import java.io.PrintWriter;
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
    DBService db;

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
            Adresse a1 = db.addAdresse("MusterStrasse", 1, "MusterStadt");
            Adresse a2 = db.addAdresse("MusterStrasse", 2, "MusterStadt");
            
            Professor p = new Professor("Max", "MusterProf", a1, new Email("Mustermann@prof.de"));    
            p = db.addProfessor(p);
            Student s = new Student("Max", "MusterStudent", a2, new Email("Mustermann@student.de"));
            Student s2 = new Student("Maxi", "MusterStudent", a2, new Email("Mustermann@student.de"));
            s = db.addStudent(s);
            s2 = db.addStudent(s2);
            
            Pruefungen pr = new Pruefungen("Mahte");
            pr = db.addPruefung(pr);
            
            db.addBachelor(p, s);
            
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