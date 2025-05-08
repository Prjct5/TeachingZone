/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teaching.zone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private static final String URL = "jdbc:sqlite:D:/Database/database.db";
  
  public static Connection connect() {
        Connection conn= null ;
        try {
            Class.forName("org.sqlite.JDBC"); // تحميل Driver
            conn = DriverManager.getConnection(URL);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
            // ممكن اختصر التوو كاتشيز دول في كاتش واحده 
        }
        return conn;
    }
 


  
}
