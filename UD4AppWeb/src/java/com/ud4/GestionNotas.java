/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ud4;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
/** 
 * 
 * @author Raquel Burgos Plaza
 */ 

public class GestionNotas { 
    static final String JDBCDRIVER = "com.mysql.jdbc.Driver"; 
    static final String DB_URL = "jdbc:mysql://localhost:3306/ud4"; 
    // Database credentials 
    static final String USER = "root"; 
    static final String PASS = "root"; 
    static Connection connection = null; 
    public GestionNotas() {} 
    
    public static void main(String[] args) { 
        try { 
            System.out.println("Conectando con la base de datos...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS); 
            System.out.println("Conexión extablecida correctamente..."); 
            muestraMenu(); 
            BufferedReader bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
            int opcion = Integer.parseInt(bufferIn.readLine()); 
            switch (opcion) { 
                case 1: insertaDatos();
                        break; 
                case 2: mostrarAlumnos(); 
                        break; 
                case 3: buscarPorNombre(); 
                        break; 
                case 4: buscarPorApellidos(); 
                        break; 
                case 5: break; 
                default: System.out.println("Opción incorrecta."); 
             } 
        } catch (SQLException se) { 
        // Gestiona errores de SQL 
            se.printStackTrace(); 
        } catch (IOException e) { 
        //Gestiona errores de la captura de datos 
            e.printStackTrace(); 
        } finally { 
            // Liberación de recursos 
            try { 
                if (connection != null) { 
                    connection.close();
                } 
            }catch (SQLException se) { 
                se.printStackTrace();
            } 
        } 
    }
    
    public static void muestraMenu() { 
        System.out.println("Selecciona una opción"); 
        System.out.println("1.- Nuevo alumno."); 
        System.out.println("2.- Mostrar todos los alumnos."); 
        System.out.println("3.- Buscar alumno por nombre."); 
        System.out.println("4.- Buscar alumno por apellidos."); 
        System.out.println("5.- Salir."); 
    } 
    
    public static void insertaDatos() throws SQLException, IOException { 
        BufferedReader bufferIn;
        System.out.println("Introduce el DNI del alumno"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        String dni = bufferIn.readLine(); 
        System.out.println("Introduce su nombre"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        String nombre = bufferIn.readLine(); 
        System.out.println("Introduce sus apellidos"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        String apellidos = bufferIn.readLine(); 
        System.out.println("Introduce la nota del trabajo de la Parte 1"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        float trabajo1 = Float.parseFloat(bufferIn.readLine()); 
        System.out.println("Introduce la nota del trabajo de la Parte 2"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        float trabajo2 = Float.parseFloat(bufferIn.readLine()); 
        System.out.println("Introduce la nota del trabajo de la Parte 3"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        float trabajo3 = Float.parseFloat(bufferIn.readLine()); 
        System.out.println("Introduce la nota del examen de la Parte 1"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        float examen1 = Float.parseFloat(bufferIn.readLine()); 
        System.out.println("Introduce la nota del examen de la Parte 2"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        float examen2 = Float.parseFloat(bufferIn.readLine()); 
        System.out.println("Introduce la nota del examen de la Parte 3"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        float examen3 = Float.parseFloat(bufferIn.readLine()); 
        System.out.println("Introduce el número de ausencias del alumno"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        int ausencias = Integer.parseInt(bufferIn.readLine()); 
        System.out.println("Introduce el número de amonestaciones"); 
        bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        int comportamiento = Integer.parseInt(bufferIn.readLine()); 
        insertaAlumno(dni, nombre, apellidos, trabajo1, trabajo2, trabajo3, 
                examen1, examen2, examen3, ausencias, comportamiento); 
    } 
    
    public static void mostrarAlumnos() throws SQLException { 
        String SQL_SELECT_ALL = "SELECT * FROM GestionNotas";
        String dni, nombre, apellidos; 
        float trabajo1, trabajo2, trabajo3, examen1, examen2, examen3; 
        int ausencias, comportamiento; 
        Statement stmt = connection.createStatement(); 
        ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL); 
        System.out.println("LISTADO DE ALUMNOS DEL CURSO"); 
        System.out.println(" DNI \t\t NOMBRE \t APELLIDOS \t TRABAJO1 \t "
                + "TRABAJO2 \t TRABAJO3 \t EXAMEN1 \t EXAMEN2 \t EXAMEN3 "
                + "\t AUSENCIAS \t AMONESTACIONES"); 
        while (rs.next()) { 
            dni = rs.getString(1);
            nombre = rs.getString(2); 
            apellidos = rs.getString(3); 
            trabajo1 = rs.getFloat(4); 
            trabajo2 = rs.getFloat(5); 
            trabajo3 = rs.getFloat(6); 
            examen1 = rs.getFloat(7); 
            examen2 = rs.getFloat(8); 
            examen3 = rs.getFloat(9); 
            ausencias = rs.getInt(10); 
            comportamiento = rs.getInt(11); 
            System.out.println(dni + "\t" + nombre + "\t\t" + apellidos + "\t" 
                    + trabajo1 + "\t\t" + trabajo2 + "\t\t" + trabajo3 + "\t\t" 
                    + examen1 + "\t\t" + examen2 + "\t\t" + examen3 + "\t\t" 
                    + ausencias + "\t\t" + comportamiento); 
        } 
    }
    public static void buscarPorNombre() throws SQLException, IOException { 
        String dni, nombre, apellidos;
        float trabajo1, trabajo2, trabajo3, examen1, examen2, examen3; 
        int ausencias, comportamiento; 
        System.out.println("Introduzca el nombre del alumno:"); 
        BufferedReader bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        String param = bufferIn.readLine(); 
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM GestionNotas WHERE nombre = ?"); 
        ps.setString(1, param); 
        ResultSet rs = ps.executeQuery(); 
        if (rs.getRow() == 0) { 
            System.out.println("No se han encontrado el alumno");
        } else { 
            System.out.println("Los datos de los alumno son:");
            System.out.println(" DNI \t\t NOMBRE \t APELLIDOS \t TRABAJO1 \t "
                    + "TRABAJO2 \t TRABAJO3 \t EXAMEN1 \t EXAMEN2 \t EXAMEN3 \t "
                    + "AUSENCIAS \t AMONESTACIONES"); 
            while (rs.next()) { 
                dni = rs.getString(1);
                nombre = rs.getString(2); 
                apellidos = rs.getString(3); 
                trabajo1 = rs.getFloat(4); 
                trabajo2 = rs.getFloat(5); 
                trabajo3 = rs.getFloat(6); 
                examen1 = rs.getFloat(7); 
                examen2 = rs.getFloat(8); 
                examen3 = rs.getFloat(9); 
                ausencias = rs.getInt(10); 
                comportamiento = rs.getInt(11); 
                System.out.println(dni + "\t" + nombre + "\t\t" + apellidos + 
                        "\t" + trabajo1 + "\t\t" + trabajo2 + "\t\t" + trabajo3 + 
                        "\t\t" + examen1 + "\t\t" + examen2 + "\t\t" + examen3 + 
                        "\t\t" + ausencias + "\t\t" + comportamiento); 
            } 
        } 
    } 
    
    public static void buscarPorApellidos() throws SQLException, IOException { 
        String dni, nombre, apellidos;
        float trabajo1, trabajo2, trabajo3, examen1, examen2, examen3; 
        int ausencias, comportamiento; 
        System.out.println("Introduzca los apellidos del alumno que desea buscar"); 
        BufferedReader bufferIn = new BufferedReader(new InputStreamReader(System.in)); 
        String param = bufferIn.readLine(); 
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM GestionNotas WHERE apellidos = ?"); 
        ps.setString(1, param); 
        ResultSet rs = ps.executeQuery(); 
        if (rs.getRow() == 0) { 
            System.out.println("No se han encontrado el alumno");
        } else { 
            System.out.println("Los datos de los alumno son");
            System.out.println(" DNI \t\t NOMBRE \t APELLIDOS \t TRABAJO1 \t "
                    + "TRABAJO2 \t TRABAJO3 \t EXAMEN1 \t EXAMEN2 \t EXAMEN3 \t "
                    + "AUSENCIAS \t AMONESTACIONES"); 
            while (rs.next()) { 
                dni = rs.getString(1);
                nombre = rs.getString(2); 
                apellidos = rs.getString(3); 
                trabajo1 = rs.getFloat(4); 
                trabajo2 = rs.getFloat(5); 
                trabajo3 = rs.getFloat(6); 
                examen1 = rs.getFloat(7); 
                examen2 = rs.getFloat(8); 
                examen3 = rs.getFloat(9); 
                ausencias = rs.getInt(10); 
                comportamiento = rs.getInt(11); 
                System.out.println(dni + "\t" + nombre + "\t\t" + apellidos + 
                        "\t" + trabajo1 + "\t\t" + trabajo2 + "\t\t" + trabajo3 + 
                        "\t\t" + examen1 + "\t\t" + examen2 + "\t\t" + examen3 + 
                        "\t\t" + ausencias + "\t\t" + comportamiento); 
            } 
        } 
    } 
    
    public static void insertaAlumno(String dni, String nombre, String apellidos, 
            float trabajo1, float trabajo2, float trabajo3, float examen1, 
            float examen2, float examen3, int ausencias, int comportamiento) { 
        try { 
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO GestionNotas VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, dni); 
            ps.setString(2, nombre); 
            ps.setString(3, apellidos); 
            ps.setFloat(4, trabajo1); 
            ps.setFloat(5, trabajo2); 
            ps.setFloat(6, trabajo3); 
            ps.setFloat(7, examen1); 
            ps.setFloat(8, examen2); 
            ps.setFloat(9, examen3); 
            ps.setInt(10, ausencias); 
            ps.setInt(11, comportamiento); 
            int resultado = ps.executeUpdate();    
            System.out.println("Los datos del alumno han sido añadidos con éxito"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
}