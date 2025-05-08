/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.File;

/**
 *
 * @author dell
 */
public class student {
    private int studentid;
     private String organisition;
     private String level;
      private double gpa;
      private String department;
    private File assignmentFile;

    public student(int studentid, String organisition, String level, double gpa, String department) {
        this.studentid = studentid;
        this.organisition = organisition;
        this.level = level;
        this.gpa = gpa;
        this.department = department;
    }

    public student() {
    }

    public student(int id, String o, double g, String d) {
       this.gpa=g;
       this.department=d;
       this.studentid=id;
       this.organisition=o;
    }


    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getOrganisition() {
        return organisition;
    }

    public void setOrganisition(String organisition) {
        this.organisition = organisition;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public File getAssignmentFile() {
        return assignmentFile;
    }

    public void setAssignmentFile(File assignmentFile) {
        this.assignmentFile = assignmentFile;
    }
  
}
    
