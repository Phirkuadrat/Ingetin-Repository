package com.ingetin.control;

import com.ingetin.model.Akun;
import com.ingetin.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlAkun {
    private Akun akun = new Akun();
    private int idUser;
    
    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.connect();

    public int login(String username, String password) throws SQLException {
        int stat = 0;
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM user WHERE username ='" 
                    + username + "' AND password ='" + password + "'");
            if (rs.next()) {
                akun.setUsername(username);
                akun.setIdUser(rs.getInt("idUser"));
                stat = 1;
            } else {
                stat = 0;
            }

            return stat;
        } catch (SQLException e) {
            e.printStackTrace();
            return stat;
        }
    }

    public boolean register(String username, String password, String email) throws SQLException{
        String query = "INSERT INTO user values (null, '" + username + "', '" + password + "', '" + email + "')";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean checkEmail(String email) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = null;
        ResultSet r = null;

        try {
            p = con.prepareStatement("SELECT username FROM user WHERE email = ?");
            p.setString(1, email);
            r = p.executeQuery();

            if (r.next()) {
                duplicate = true;
            }
        } finally {
            if (r != null) {
                r.close();
            }
            if (p != null) {
                p.close();
            }
        }

        return duplicate;
    }

    public boolean checkUsername(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = null;
        ResultSet r = null;

        try {
            p = con.prepareStatement("SELECT username FROM user WHERE username = ?");
            p.setString(1, user);
            r = p.executeQuery();

            if (r.next()) {
                duplicate = true;
            }
        } finally {
            if (r != null) {
                r.close();
            }
            if (p != null) {
                p.close();
            }
        }
        return duplicate;
    }

    public int getIdUser(String username, String password){
        int stat = 0;
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM user WHERE username ='" 
                    + username + "' AND password ='" + password + "'");
            if (rs.next()) {
                idUser = (rs.getInt("idUser"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUser;
    }
}
