/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingetin.model;

/**
 *
 * @author Dwina
 */
public class Akun {
    private static int idUser;
    private static String username;
    private String password;
    private String email;

    public Akun() {
    }

    public Akun(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public Akun(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public static void setIdUser(int idUser) {
        Akun.idUser = idUser;
    }
    
    public static int getIdUser() {
        return idUser;
    }
    
    public static void login(int userId) {
        idUser = userId;
    }

    public static void logout() {
        idUser = 0;
    }
}
