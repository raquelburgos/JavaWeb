/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.seas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raquel
 */
@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"}) 
public class SessionServlet extends HttpServlet { 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
    // Establecemos el tipo MIME de la salida 
        response.setContentType("text/html;charset=UTF-8"); 
    // Declaración de variables 
        PrintWriter out = response.getWriter(); 
        Integer contadorAccesos; 
    // Devuelve la sesión si existe. Si no existe, crea una nueva. 
        HttpSession session = request.getSession(true); 
    // Los accesos al objeto sesión están sincronizados para 
    //garantizar la contabilización de todos los accesos al 
    //servlet. 
        synchronized(session) { 
            contadorAccesos = (Integer)session.getAttribute("contadorAccesos"); 
            if (contadorAccesos == null) { 
                contadorAccesos = 0; 
            } else { 
                contadorAccesos = new Integer(contadorAccesos + 1); 
            } 
            session.setAttribute("contadorAccesos", contadorAccesos); 
        } 
    // Se genera la página HTML de respuesta 
        try {
            out.println("<!DOCTYPE html>"); 
            out.println("<html>"); 
            out.println("<head><title> Servlet de Gestión de Sesiones </title></head><body>"); 
            out.println("<h2>Has accedido a este servlet " + contadorAccesos + " veces es esta sesión.</h2>"); 
            out.println("<p>El identificador de la sesión es " + session.getId() + ")</p>"); 
            out.println("<p>La sesión fue creada en " + new Date(session.getCreationTime()) + ")</p>"); 
            out.println("<p>Esta sesión fue accedida por última vez el " + new Date(session.getLastAccessedTime()) + ")</p>"); 
            out.println("<p>El intervalo máximo de inactividad de la sesión es " + session.getMaxInactiveInterval() + "segundos)</p>"); 
            out.println("<p><a href='" + request.getRequestURI() + "'>Refrescar</a></body></html>"); 
        } finally { 
            out.close(); 
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
