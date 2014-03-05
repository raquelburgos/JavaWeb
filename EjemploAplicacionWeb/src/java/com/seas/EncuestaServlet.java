/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.seas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raquel
 */
public class EncuestaServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EncuestaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>OPINIÓN DE LOS ALUMNOS</h1>");
            out.println("<FORM action=\"EncuestaServlet\" method=\"post\">");
            out.println("<P>\n"+"<LABEL for=\"nombre\">Nombre: </LABEL>");
            out.println("<INPUT type=\"text\" name=\"nombre\"><BR>");
            out.println("<P>\n"+"<LABEL for=\"pass\">Contraseña: </LABEL>");
            out.println("<INPUT type=\"password\" name=\"pass\"><BR><br>");
            out.println("<LABEL>Sexo: </LABEL><INPUT type=\"radio\" name=\"sexo\" value=\"Hombre\"> Hombre " +
                        "<INPUT type=\"radio\" name=\"sexo\" value=\"Mujer\"> Mujer<BR><br>");
            out.println("<LABEL>Edad: </LABEL><SELECT name=\"edad\">");
            out.println("<option value=\"<18\" selected=\"selected\">< 18 años</option>");
            out.println("<option value=\"18-30\">Entre 18 y 30 años</option>");
            out.println("<option value=\">30\">> 30 años </option></SELECT><br><br>");
            out.println("<label>Conocimientos previos en lenguajes informáticos:</label><br>");
            out.print("<input type=\"checkbox\" name=\"java\" value=\"Java\">Java");
            out.print("<input type=\"checkbox\" name=\"c\" value=\"C\">C");
            out.print("<input type=\"checkbox\" name=\"c++\" value=\"C++\">C++");
            out.print("<input type=\"checkbox\" name=\"c#\" value=\"C#\">C#");
            out.print("<input type=\"checkbox\" name=\"objetiveC\" value=\"ObjetiveC\">ObjetiveC");
            out.print("<input type=\"checkbox\" name=\"cobol\" value=\"Cobol\">Cobol");
            out.print("<input type=\"checkbox\" name=\"php\" value=\"PHP\">PHP<br>");
            out.println("<label>Nivel de satisfacción con los materiales del curso:</label><br>");
            out.println("<SELECT name=\"materiales\">");
            out.println("<option value=\"1\" selected=\"selected\">1</option>");
            out.println("<option value=\"2\">2</option>");
            out.println("<option value=\"3\">3</option>");
            out.println("<option value=\"4\">4</option>");
            out.println("<option value=\"5\">5</option>");
            out.println("<option value=\"6\">6</option>");
            out.println("<option value=\"7\">7</option>");
            out.println("<option value=\"8\">8</option>");
            out.println("<option value=\"9\">9</option>");
            out.println("<option value=\"10\">10</option></SELECT><br><br>");
            out.println("<label>Nivel de satisfacción con los conocimientos adquiridos durante el curso:</label><br>");
            out.println("<SELECT name=\"conocimientos\">");
            out.println("<option value=\"1\" selected=\"selected\">1</option>");
            out.println("<option value=\"2\">2</option>");
            out.println("<option value=\"3\">3</option>");
            out.println("<option value=\"4\">4</option>");
            out.println("<option value=\"5\">5</option>");
            out.println("<option value=\"6\">6</option>");
            out.println("<option value=\"7\">7</option>");
            out.println("<option value=\"8\">8</option>");
            out.println("<option value=\"9\">9</option>");
            out.println("<option value=\"10\">10</option></SELECT><br><br>");
            out.println("<label>Comentarios:</label><br>");
            out.println("<textarea cols=\"40\" rows=\"5\" name=\"comentarios\">" +
                    "Introduce aquí tus comentarios...</textarea><br>");
            out.println("<input type=\"submit\" value=\"Enviar\">");
            out.println("<input type=\"reset\" value=\"Borrar\">");
            out.println("</P>\n</FORM>");
            out.println("</body>");
            out.println("</html>");
        }finally { 
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
        //processRequest(request, response);
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("pass");
        String sexo = request.getParameter("sexo");
        String edad = request.getParameter("edad");
        String lenguajes = "";
        if(request.getParameter("java")!=null)
            lenguajes+=" "+request.getParameter("java");
        if(request.getParameter("c")!=null)
            lenguajes+=" "+request.getParameter("c");
        if(request.getParameter("c++")!=null)
            lenguajes+=" "+request.getParameter("c++");
        if(request.getParameter("c#")!=null)
            lenguajes+=" "+request.getParameter("c#");
        if(request.getParameter("objetiveC")!=null)
            lenguajes+=" "+request.getParameter("objetiveC");
        if(request.getParameter("cobol")!=null)
            lenguajes+=" "+request.getParameter("cobol");
        if(request.getParameter("php")!=null)
            lenguajes+=" "+request.getParameter("php");
        String materiales = request.getParameter("materiales");
        String conocimientos = request.getParameter("conocimientos");
        String comentarios = request.getParameter("comentarios");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            out.println("<html>"); 
            out.println("<head>"); 
            out.println("<title>Servlet EjemploServlet</title>"); 
            out.println("</head>"); 
            out.println("<body>"); 
            out.println("<h1><i>" + request.getServletPath()+"</i></h1>"); 
            out.println("<h1>Muchas gracias por tu participación</h1>");
            out.println("<p>Nombre del alumno: "+nombre+"</p>");
            out.println("<p>Contraseña: "+password+"</p>");
            out.println("<p>Sexo: "+sexo+"</p>");
            out.println("<p>Edad: "+edad+"</p>");
            out.println("<p>Lenguajes: "+lenguajes+"</p>");
            out.println("<p>Valoración de materiales: "+materiales+"</p>");
            out.println("<p>Valoración de conocimientos: "+conocimientos+"</p>");
            out.println("<p>Comentarios: "+comentarios+"</p>");
            out.println("</body>");
            out.println("</html>");
        }finally { 
            out.close(); 
        } 
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
