/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author drash
 */
//File Name :- StudentDAO.java
package com.mycompany.academicwebapp;

import java.sql.*;
import java.util.Scanner;
public class StudentDAO {

    public void insertStudent() {

        try {
            
            Scanner sc = new Scanner(System.in);
            Connection con = ACDBConnection.getConnection();
            
            

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Email: ");
            String email = sc.next();

            System.out.print("Enter Department: ");
            String dept = sc.next();

            System.out.print("Enter Semester: ");
            int sem = sc.nextInt();

            String sql;
            sql = "INSERT INTO students (name,email,department,semester) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, dept);
            ps.setInt(4, sem);

            ps.executeUpdate();
            System.out.println("Student Added Successfully");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void viewStudents() {

        try {
            Connection con = ACDBConnection.getConnection();

            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

           // System.out.println("ID  NAME  EMAIL  DEPT  SEM");
           System.out.printf("%-5s %-12s %-25s %-12s %-5s\n",
                  "ID","NAME","EMAIL","DEPT","SEM");


            while (rs.next()) {
               /* System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4) + " " +
                        rs.getInt(5)
                );*/
                  System.out.printf("%-5d %-12s %-25s %-12s %-5d\n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                  );

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStudent() {

        try {
            Scanner sc = new Scanner(System.in);
            Connection con = ACDBConnection.getConnection();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Name: ");
            String name = sc.next();

            String sql =
            "UPDATE students SET name=? WHERE student_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Student Updated");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteStudent() {

        try {
            Scanner sc = new Scanner(System.in);
            Connection con = ACDBConnection.getConnection();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM students WHERE student_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            CallableStatement cs=con.prepareCall("Call getstudents()");

            ps.executeUpdate();
            System.out.println("Student Deleted");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}








