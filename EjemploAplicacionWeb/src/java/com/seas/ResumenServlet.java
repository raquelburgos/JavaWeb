/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.seas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raquel
 */
public class ResumenServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static private String param1; 
    static private String param2; 
    private String contextAtt1; 
    private String contextAtt2; 
    private String contextAtt3; 
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter(); 
        try { 
            out.println("<html>"); 
            out.println("<head>"); 
            out.println("<title>Servlet EjemploServlet</title>"); 
            out.println("</head>"); 
            out.println("<body>"); 
            out.println("<h1>Servlet <i>" + request.getServletPath() + 
                    "</i> de la Aplicación <i>" + request.getContextPath() + 
                    "</i></h1>"); 
            out.println("Hoy es <i>" + new Date() + "</i>"); 
            out.println("<p>Método HTTP: <i>" + request.getMethod() + "</i></p>"); 
            out.println("<p>URI solicitada: <i>" + request.getRequestURI() + "</i></p>"); 
            out.println("<p>Protocolo: <i>" + request.getProtocol() + "</i></p>"); 
            out.println("<p>Codificación de caracteres: <i>" + request.getCharacterEncoding() + "</i></p>"); 
            out.println("<p>Dirección IP remota: <i>" + request.getRemoteAddr() + "</i></p>"); 
            out.println("<p>Un número aleatorio: <strong><i>" + Math.random() + "</i></strong></p>"); 
            out.println("<p>VALORES DE INICIALIZACIÓN DE LA APLICACIÓN (ServletConfig).</p>"); 
            out.println("<p><strong>Parametro 1: <i>" + param1 + "</i></strong></p>"); 
            out.println("<p><strong>Parametro 2: <i>" + param2 + "</i></strong></p>"); 
            out.println("<p>VALORES DE INICIALIZACIÓN DEL SERVLET (ServletContext):</p>"); 
            out.println("<p><strong>DatabaseURL: <i>" + contextAtt1 + "</i></strong></p>"); 
            out.println("<p><strong>UserDB: <i>" + contextAtt2 + "</i></strong></p>"); 
            out.println("<p><strong>PasswordDB: <i>" + contextAtt3 + "</i></strong></p>"); 
            out.println("</body>"); 
            out.println("</html>"); 
        } finally { 
            out.close(); 
        } 
    } 
    
    @Override public void init(ServletConfig config) throws ServletException { 
        super.init(config); 
        ResumenServlet.param1 = getInitParameter("Proveedor"); 
        ResumenServlet.param2 = getInitParameter("Contacto"); 
        ServletContext context = config.getServletContext(); 
        contextAtt1 = context.getInitParameter("DatabaseURL"); 
        contextAtt2 = context.getInitParameter("UserDB"); 
        contextAtt3 = context.getInitParameter("PasswordDB"); 
    }

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        processRequest(request, response); 
    } 
    
    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        processRequest(request, response); 
    } 
    
    @Override public String getServletInfo() { 
        return "Short description"; 
    }

}
