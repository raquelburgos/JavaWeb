/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ud4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Raquel
 */
public class JDBCExample {
    static final String DRIVER_JDBC = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ud4";
	static final String USER = "root";
	static final String PASS = "root";
	
	public static void main(String[] args){
		Connection conn = null;
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
}
