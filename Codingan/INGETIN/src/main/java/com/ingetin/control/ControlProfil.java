/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingetin.control;

import com.ingetin.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dwina
 */
public class ControlProfil {
    
    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.connect();
    
    public void addProfile(int idUser){
        try {
            String query = "INSERT INTO profil (idUser) VALUES (?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, idUser);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
