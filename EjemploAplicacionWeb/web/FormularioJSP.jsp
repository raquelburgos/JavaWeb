<%-- 
    Document   : FormularioJSP
    Created on : 10-mar-2014, 16:56:29
    Author     : Raquel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%= request.getParameter("nombre") %>
        <%= request.getParameter("password") %>
        <% String sexo = request.getParameter("sexo"); 
            String msgSexo=""; 
            if (sexo == null) { 
                msgSexo = "VACÍO"; 
            } else if (sexo.equals("h")) { 
                msgSexo = "HOMBRE"; 
            } else { 
                msgSexo = "MUJER"; 
            } 
        %> 
        <%= msgSexo %>
        <% String edad = request.getParameter("edad"); 
            String msgEdad = ""; 
            if (edad == null) { 
                msgEdad = "VACÍO"; 
            } else if (edad.equals("1")) { 
                msgEdad = "&lt; 18 años"; 
            } else if (edad.equals("18")) { 
                msgEdad = "Edad entre 18 y 25 años"; 
            } else if (edad.equals("26")) { 
                msgEdad = "Edad entre 26 y 35 años"; 
            } else if (edad.equals("36")) { 
                msgEdad = "Edad entre 36 y 45 años"; 
            } else if (edad.equals("46")) { 
                msgEdad = "Edad entre 46 y 65 años"; 
            } else { 
                msgEdad = "Edad: &gt; 65 años"; 
            } 
        %> 
        <%= msgEdad %>
        <% String[] lenguajes = request.getParameterValues("lenguaje"); 
            String msgLenguaje = ""; 
            if (lenguajes == null || lenguajes.length == 0) { 
                msgLenguaje = "NINGUNO"; 
            } else { 
                for (String lenguaje : lenguajes) { 
                    if (lenguaje.equals("java")) { 
                        msgLenguaje = "Java "; 
                    } else if (lenguaje.equals("c")) { 
                        msgLenguaje.concat("C "); 
                    } else if (lenguaje.equals("c++")) { 
                        msgLenguaje.concat("C++ "); 
                    } else if (lenguaje.equals("cs")) { 
                        msgLenguaje.concat("C# "); 
                    } else if (lenguaje.equals("objectivec")) { 
                        msgLenguaje.concat("ObjectiveC "); 
                    } else if (lenguaje.equals("cobol")) { 
                        msgLenguaje.concat("Cobol "); 
                    } else if (lenguaje.equals("php")) { 
                        msgLenguaje.concat("PHP "); 
                    } 
                } 
            } 
        %> 
        <%= msgLenguaje %>
        <%= request.getParameter("materiales") %>
        <%= request.getParameter("valoracion") %>
        <% String comentarios = request.getParameter("comentarios"); 
            String msgComentarios = ""; 
            if (comentarios == null || comentarios.equals("Introduce aquí tus comentarios...")) { 
                msgComentarios = "No hay comentarios."; 
            } else { 
                msgComentarios = comentarios; 
            } 
        %> 
        <%= msgComentarios %>
valoración Materiales
    </body>
</html>
