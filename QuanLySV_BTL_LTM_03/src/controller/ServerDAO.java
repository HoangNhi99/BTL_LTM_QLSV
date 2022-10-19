/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Student;

/**
 *
 * @author admin
 */
public class ServerDAO {
    
    private Connection conn;
    public static final String URL = "jdbc:mysql://localhost:3306/qlsv_data";
    public static final String USER = "root";
    public static final String PASS = "123456";
    
    public ServerDAO() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
    public boolean addStudent(Student s){
        String sql = "INSERT INTO tblstudent(id, name, dob, year, address) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setDate(3, new java.sql.Date(s.getDob().getTime()));
            ps.setInt(4, s.getYear());
            ps.setString(5, s.getAddress());
            ps.executeUpdate();
            return true; //thanh cong
        } catch (SQLException e) {
        }
        return false;
    }
    
}
