/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Question;

/**
 *
 * @author Thinh
 */
public class QuestionDAO {
    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;
    
    public static ArrayList<Question> getListQuestionsByID(String collectionID) {
        try {
            String query = "select * from Question where CollectionID=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(collectionID));
            rs = ps.executeQuery();
            ArrayList<Question> list = new ArrayList<>();
            while (rs.next()) {
                Question a = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getInt(8));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static void insertQuestion(String username, String password, String email, String phone) {
        String query = "INSERT INTO Question([username],[passwords],[email],[phone]) VALUES(?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.executeQuery();

        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
//        System.out.println(getListQuestionsByID("1").get(1).toString()); 
    }
}
