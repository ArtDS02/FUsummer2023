package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;

public class AccountDAO {

    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;

    public static ArrayList<Account> getListAccounts() {
        try {
            String query = "select * from Account";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Account> list = new ArrayList<>();
            while (rs.next()) {
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertAccount(String FirstName, String LastName, String username, String password, String phone, String Email, String DOB, int Role) {
        String query = "INSERT INTO Account (FirstName, LastName, UserName, Password, Phone, Email, DOB, Role) VALUES (?,?,?,?,?,?,?,?);";
        try {
            conn = new DBContext().getConnection();
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setString(1, FirstName);
            ps.setString(2, LastName);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, phone);
            ps.setString(6, Email);
            ps.setString(7, DOB);
            ps.setInt(8, Role);
            System.out.println("Success");
            ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public static void deleteAccount(String id) {
        String query = "DELETE  FROM Account  WHERE AccountID=?";
        try {
            conn = new DBContext().getConnection();
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            System.out.println("Thanh cong");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static Account getAccountByName(String name) {
        String query = "select * from Account where UserName=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return new Account();
    }

    public static void updateAccount(String AccountID, String FirstName, String LastName, String username, String password, String phone, String Email, String DOB, int Role) {
        String query = "UPDATE Account SET FirstName =?, LastName =?, UserName =?, Password =?, Phone =?, Email =?, DOB =?, Role = ? WHERE AccountID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, FirstName);
            ps.setString(2, LastName);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, phone);
            ps.setString(6, Email);
            ps.setString(7, DOB);
            ps.setInt(8, Role);
            ps.setInt(9, Integer.parseInt(AccountID));
            System.out.println("Success");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
//        System.out.println(getListAccounts().get(1).toString()); 
//        insertAccount("1", "1", "1", "1", "1", "1", "1", 1); 
//        deleteAccount("10"); 
//            System.out.println(getAccountByName("thinhta").toString());
            updateAccount("11","11","11","11","11","11","11","11",11);
    }
}
