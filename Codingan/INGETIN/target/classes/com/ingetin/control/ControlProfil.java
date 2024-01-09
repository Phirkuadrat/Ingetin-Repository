/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingetin.control;

import com.ingetin.model.Akun;
import com.ingetin.model.Profile;
import com.ingetin.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dwina
 */
public class ControlProfil {
    
    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.connect();
    Akun akun = new Akun();
    
    public Profile getProfile(Profile profil){
        try {
            int id = akun.getIdUser();
            System.out.println(id);
            String nama = "";
            String query = "SELECT * FROM profil WHERE idUser = " + id;
            try (PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    profil.setNama(resultSet.getString("nama"));
                    profil.setBio(resultSet.getString("bio"));
                    profil.setTanggalLahir(resultSet.getDate("tanggalLahir"));
                    profil.setGender(resultSet.getString("gender"));
                    profil.setKota(resultSet.getString("kota"));
                }   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profil;
    }
    
    public void ubahProfil(String nama, String bio, Date tanggal, String gender, String kota, int idUser) {
        try {
            String query = "UPDATE profil SET nama = ?, bio = ?, tanggalLahir = ?, gender = ?, kota = ? WHERE idUser = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, bio);
            preparedStatement.setDate(3, new java.sql.Date(tanggal.getTime()));
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, kota);
            preparedStatement.setInt(6, idUser);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Profil Berhasil Diubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ada perubahan pada profil", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
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
