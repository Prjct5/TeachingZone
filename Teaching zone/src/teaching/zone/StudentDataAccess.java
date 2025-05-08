/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teaching.zone;

import backend.student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import static teaching.zone.DatabaseConnection.connect;

public class StudentDataAccess {

    static ObservableList<student> getStudents() {
    ObservableList<student> students = FXCollections.observableArrayList();
    String query = "SELECT * FROM students"; // جدول الطلاب

    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            student s = new student();
            s.setStudentid(rs.getInt("studentid"));
            s.setOrganisition(rs.getString("organisition"));
            s.setLevel(rs.getString("level"));
            s.setGpa(rs.getDouble("gpa"));
            s.setDepartment(rs.getString("department"));

            students.add(s);
        }

    } catch (Exception e) {
        e.getMessage();
    }
    System.out.println("Students size: " + students.size());
    return students;
    }
}
   
   


   