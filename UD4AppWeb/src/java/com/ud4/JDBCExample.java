/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ud4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Raquel Burgos Plaza
 */
public class JDBCExample {
    static final String DRIVER_JDBC = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ud4";
    static final String USER = "root";
    static final String PASS = "root";

    static Connection conn = null;
    
    public static void main(String[] args){
	try{
        	System.out.println("Conectando con la BBDD...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Conexion establecida OK...");
	}catch(SQLException se){
		se.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
                	if(conn!=null){
			conn.close();
		}
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	System.out.println("Hasta pronto!");
 }
	
    public static void insertarPreparedStatement(int id, String nombre, 
                String apellido1, String apellido2, int edad, String sexo, 
                int estudios, byte java, byte c, byte cplus, byte csharp, 
                byte objetivec, byte cobol, byte php, int satisfaccion,
                int valoracion, String comentarios){
	try{
        	PreparedStatement ps = conn.prepareStatement("INSERT INTO alumnos VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, apellido1);
		ps.setString(4, apellido2);
		ps.setInt(5, edad);
		ps.setString(6, sexo);
		ps.setInt(7, estudios);
		ps.setByte(8, java);
		ps.setByte(9, c);
		ps.setByte(10, cplus);
		ps.setByte(11, csharp);
		ps.setByte(12, objetivec);
		ps.setByte(13, cobol);
		ps.setByte(14, php);
		ps.setInt(15, satisfaccion);
		ps.setInt(16, valoracion);
		ps.setString(17, comentarios);
		
		ps.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}
	}
	
	public static void ejecutaConsulta() throws SQLException{
		String SQL_SELECT_HOMBRES = "SELECT nombre, apellido1 FROM alumnos WHERE sexo='H'";
		String SQL_SELECT_MUJERES = "SELECT nombre, apellido1 FROM alumnos WHERE sexo='M'";
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_HOMBRES);
			String nombre = "";
			String apellido1 = "";
			System.out.println("ALUMNOS HOMBRES");
			while(rs.next()){
				nombre = rs.getString(1);
				apellido1 = rs.getString(2);
				System.out.println("Alumno: "+nombre+" "+apellido1);
			}
			rs = stmt.executeQuery(SQL_SELECT_MUJERES);
			System.out.println("ALUMNAS MUJERES");
			while(rs.next()){
				nombre = rs.getString(1);
				apellido1 = rs.getString(2);
				System.out.println("Alumna "+nombre+" "+apellido1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
