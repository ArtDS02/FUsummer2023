package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Collection;

public class CollectionDAO {

    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;

    public static ArrayList<Collection> getListCollections() {
        try {
            String query = "select * from Collection";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Collection> list = new ArrayList<>();
            while (rs.next()) {
                Collection a = new Collection(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertCollection(String AccountID, String Name, String NumberOfQuestion) {
        String query = "INSERT INTO Collection (AccountID, Name, NumberOfQuestion) VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(AccountID));
            ps.setString(2, Name);
            ps.setInt(3, Integer.parseInt(NumberOfQuestion));
            System.out.println("Success");
            ps.executeQuery();

        } catch (Exception e) {
        }
    }

    public static void deleteCollection(String CollectionID) {
        String query = "DELETE  FROM Collection  WHERE CollectionID=?";
        try {
            conn = new DBContext().getConnection();
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(CollectionID));
            System.out.println("Success");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static Collection getCollection(String id) {
        String query = "select * from Collection where CollectionID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Collection(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Hello");
        }
        return null;
    }

    public static Collection getCollectionByName(String name) {
        String query = "select * from Collection where Name = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Collection(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Hello");
        }
        return null;
    }


    public static void updateCollection(String CollectionID, String AccountID, String Name, String NumberOfQuestion) {
        String query = "UPDATE Collection SET AccountID = ?, Name = ?, NumberOfQuestion = ? WHERE CollectionID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(AccountID));
            ps.setString(2, Name);
            ps.setInt(3, Integer.parseInt(NumberOfQuestion));
            ps.setInt(4, Integer.parseInt(CollectionID));
            System.out.println("Success");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
//        System.out.println(getCollection("1").toString()); 
//            insertCollection("2","Nguyen Tien Thinh","60"); 
//        deleteCollection("7"); //Co loi o phan delete
//            System.out.println(getCollectionByName("History").toString());
//            updateCollection("8","6","1","111");
//        System.out.println(getCollectionByName("1").toString());
    }
}
