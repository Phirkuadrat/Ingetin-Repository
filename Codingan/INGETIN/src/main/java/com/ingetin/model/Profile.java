/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingetin.model;

import java.util.Date;

/**
 *
 * @author Dwina
 */
public class Profile {
    private int idProfil;
    private String nama;
    private String bio;
    private Date tanggalLahir;
    private String gender;
    private String kota;

    public Profile() {
    }

    public Profile(int idProfil, String nama, String bio, Date tanggalLahir, String gender, String kota) {
        this.idProfil = idProfil;
        this.nama = nama;
        this.bio = bio;
        this.tanggalLahir = tanggalLahir;
        this.gender = gender;
        this.kota = kota;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
