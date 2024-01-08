package com.ingetin.control;

import com.ingetin.model.Akun;
import com.ingetin.model.Kegiatan;
import com.ingetin.utilities.ConnectionManager;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ControlKegiatan {
    Akun akun = new Akun();
    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.connect();
    
    public void tambah(int idUser, String nama, String jenis, Date tanggal, String catatan){
        try {
            String query = "INSERT INTO kegiatan (idUser, nama, jenis, tanggal, catatan) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, idUser);
                preparedStatement.setString(2, nama);
                preparedStatement.setString(3, jenis);
                preparedStatement.setDate(4, new java.sql.Date(tanggal.getTime()));
                preparedStatement.setString(5, catatan);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }   
    
    public void hapusKegiatan(int idKegiatan){
        try {
            String query = "Delete From kegiatan WHERE idKegiatan = " + idKegiatan ;
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ubahKegiatan(String nama, String jenis, Date tanggal, String catatan,String status, int idKegiatan){
        try {
            String query = "UPDATE kegiatan SET nama=?, jenis=?, tanggal=?, catatan=?, status=? WHERE idKegiatan=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, jenis);
            preparedStatement.setDate(3, new java.sql.Date(tanggal.getTime()));
            preparedStatement.setString(4, catatan);
            preparedStatement.setString(5, status);
            preparedStatement.setInt(6, idKegiatan);
            preparedStatement.executeUpdate();
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int hitungSelesai() {
        int jumlahSelesai = 0;

        try {
            String query = "SELECT COUNT(*) AS total FROM kegiatan WHERE jenis = 'Tugas' AND status = 'Selesai'";
            
            try (PreparedStatement preparedStatement = con.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                
                if (resultSet.next()) {
                    jumlahSelesai = resultSet.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jumlahSelesai;
    }
    
    public int hitungBelumSelesai() {
        int belumSelesai = 0;

        try {
            String query = "SELECT COUNT(*) AS total FROM kegiatan WHERE jenis = 'Tugas' AND status = 'Belum Selesai'";
            
            try (PreparedStatement preparedStatement = con.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                
                if (resultSet.next()) {
                    belumSelesai = resultSet.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); //isi//
        }
        return belumSelesai;
    }
    
    public int hitungAkanDatang() {
        int akanDatang = 0;

        try {
            String query = "SELECT COUNT(*) AS total FROM kegiatan WHERE jenis = 'Acara' AND status = 'Belum Selesai'";
            
            try (PreparedStatement preparedStatement = con.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                
                if (resultSet.next()) {
                    akanDatang = resultSet.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); //isi//
        }
        return akanDatang;
    }
    
    public List<Kegiatan> getListKegiatan(String filter, String filter2) {
        List<Kegiatan> kegiatanList = new ArrayList<>();
        String query;
        if (filter.equals("Semua") && filter2.equals("Semua")) {
            query = "SELECT * FROM kegiatan WHERE idUser = " + akun.getIdUser();
        } else if (!filter.equals("Semua") && filter2.equals("Semua")) {
            query = "SELECT * FROM kegiatan WHERE idUser = " + akun.getIdUser() + " AND jenis = '" + filter + "'";
        } else if (filter.equals("Semua") && !filter2.equals("Semua")) {
            query = "SELECT * FROM kegiatan WHERE idUser = " + akun.getIdUser() + " AND status = '" + filter2 + "'";
        } else if (!filter.equals("Semua") && !filter2.equals("Semua")) {
            query = "SELECT * FROM kegiatan WHERE idUser = " + akun.getIdUser() + " AND jenis = '" + filter + "' AND status = '" + filter2 + "'";
        } else {
            query = "SELECT * FROM kegiatan WHERE idUser = " + akun.getIdUser();
        }   
        try (PreparedStatement preparedStatement = con.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idKegiatan");
                int idUser = resultSet.getInt("idUser");
                String nama = resultSet.getString("nama");
                String jenis = resultSet.getString("jenis");
                Date tanggal = resultSet.getDate("tanggal");
                String catatan = resultSet.getString("catatan");
                String status = resultSet.getString("status");

                Kegiatan kegiatan = new Kegiatan(id, idUser, nama, jenis, tanggal, catatan, status);
                kegiatanList.add(kegiatan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kegiatanList;
    }
    
    public int getIdKegiatan(String nama, String jenis, Date tanggal) {
        int idKegiatan = 0;

        try {
            String query = "SELECT idKegiatan FROM kegiatan WHERE nama = ? AND jenis = ? AND tanggal = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, nama);
                preparedStatement.setString(2, jenis);
                preparedStatement.setDate(3, new java.sql.Date(tanggal.getTime()));

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        idKegiatan = resultSet.getInt("idKegiatan");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idKegiatan;
    }
}