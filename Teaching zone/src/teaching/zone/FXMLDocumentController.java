/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package teaching.zone;
import java.sql.DriverManager;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import backend.student;
//import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import javax.management.Query;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField studentIdField;

    @FXML
    private TextField organisationField;

    @FXML
    private TextField levelField;

    @FXML
    private TextField gpaField;

    @FXML
    private TextField  department; 
    
     private student student;
     @FXML
     private TextField searchByid;


   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         student student = new student();
    }  
     @FXML
    private void showStudentData(ActionEvent event) {
        ObservableList<student> students = StudentDataAccess.getStudents();
        if (!students.isEmpty()) {
            student s = students.get(1);
            studentIdField.setText(String.valueOf(s.getStudentid()));
            organisationField.setText(s.getOrganisition());
            levelField.setText(s.getLevel());
            gpaField.setText(String.valueOf(s.getGpa()));
           department.setText(s.getDepartment());
        } else {
            label.setText("Not found");
        }
        // انا بستدعي اول طالب في القايمه ولكن لما الداتا بيز الكبيره تتكريت هنستدعي بيانات الطالب الاخير بحيث يكون هو لسه مضاف فا يبقا الاخير فا نستدعيه 

    }
}
   /* public student searchByID(int ID) {
        String sql = "SELECT * FROM Student where id=" + ID;
        java.sql.Connection conn=DriverManager.getConnection(sql);
        try {
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.excuteQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String o = rs.getString(2);
                double g = rs.getDouble(3);
                String d = rs.getString(4);
                student s = new student(id,o,g,d);
                searchByid.setText(String.valueOf(s.getStudentid()));
                return s;
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }*/


