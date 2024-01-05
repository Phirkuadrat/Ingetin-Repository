/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingetin.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dwina
 */
public class ConnectionManager {
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_ingetin";
    private String username;
    private String password;
    Connection connection;
    
    public ConnectionManager(){
        this.username = "root";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Connection connect(){
        if (connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection  = DriverManager.
                        getConnection(DB_URL, getUsername(), getPassword());
            } catch (SQLException | ClassNotFoundException e){
                Logger.getLogger(ConnectionManager.class.getName()).
                        log(Level.SEVERE, null, e);
            }
        }
        return connection;
    }
    
    public Connection disconnect() {
        try{
             connection.close();
        } catch (SQLException e){
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
    

}
