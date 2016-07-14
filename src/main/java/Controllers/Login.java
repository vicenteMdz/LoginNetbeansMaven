/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;

/**
 *
 * @author Apple
 */
public class Login extends HttpServlet {
    private String Username="administrador";
    private String password="admin123";
    static org.apache.log4j.Logger log = LogManager.getLogger(Login.class.getName());
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
        log.info("Ejecutando Servlet Login.do");
        String u,p;
        u=request.getParameter("username");
        p=request.getParameter("password");
        log.trace("Valor del Username: "+u);
        log.trace("Valor del Password: "+p);
        if(u.equals("") || p.equals("")){
            log.error("Error campos vacios");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            //response.sendRedirect("Error.jsp");
        }else if(u.equals(Username) && p.equals(password)){
            log.info("Exito!!!");
            request.getRequestDispatcher("Exito.jsp").forward(request, response);
            //response.sendRedirect("Exito.jsp");
        }else{
            //response.sendRedirect("Error.jsp");
            log.error("Error Usuario y contrasena incorrectos");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
