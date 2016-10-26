/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entity.Adresse;
import Entity.Email;
import Entity.Professor;
import Entity.Student;
import Service.DBService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
            Email e1 = db.addEmail("musteremail1@muster.de");
            Email e2 = db.addEmail("musteremail2@muster.de");
            
            Professor p = new Professor("Max", "MusterProf", a1, e1, null, null);
            Student s = new Student("Max", "MusterStudent", a2, e2, null, null);
            
            s.setErstPruefer(p);
            s.setZweitPruefer(p);
            
            p.setBachelorPruefer(new ArrayList<Student>(Arrays.asList(s)));
            p.setBachelorZweitPruefer(new ArrayList<Student>(Arrays.asList(s)));
            
            db.addProfessor(p);
            db.addStudent(s);
            
            
            
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
