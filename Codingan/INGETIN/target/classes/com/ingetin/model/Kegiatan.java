package com.ingetin.model;

import java.util.Date;

public class Kegiatan {
    private int id;
    private int idUser;
    private String nama;
    private String jenis;
    private Date tanggal;
    private String catatan;
    private String status;

    public Kegiatan() {
    }

    public Kegiatan(int id, int idUser, String nama, String jenis, Date tanggal, String catatan, String status) {
        this.id = id;
        this.idUser = idUser;
        this.nama = nama;
        this.jenis = jenis;
        this.tanggal = tanggal;
        this.catatan = catatan;
        this.status = status;
    }


    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Date getTanggal() {
        return tanggal;
    }
    
    
}
