
package com.ingetin.view.panel;

import com.ingetin.model.Akun;
import com.ingetin.view.component.Button;
import com.ingetin.view.component.MyPasswordField;
import com.ingetin.view.component.MyTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLoginRegister extends javax.swing.JLayeredPane {
    
    private Akun akun = new Akun();
    
    public PanelLoginRegister() {
    }
    
    public PanelLoginRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        register.setVisible(false);
        login.setVisible(true);
    }
    
    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Buat Akun");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(25, 23, 23));
        register.add(label);
        
        MyTextField txtUsername = new MyTextField();
        txtUsername.setPrefixIcon(new ImageIcon(getClass().getResource("/com/ingetin/image/user.png")));
        txtUsername.setHint("Username");
        register.add(txtUsername, "w 60%");
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/ingetin/image/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/ingetin/image/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");
        
        Button cmd = new Button();
        cmd.setBackground(new Color(25, 23, 23));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("DAFTAR");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                akun.setUsername(txtUsername.getText().trim());
                akun.setEmail(txtEmail.getText().trim());
                akun.setPassword(String.valueOf(txtPass.getPassword()));
                txtUsername.setText(null);
                txtEmail.setText(null);
                txtPass.setText(null);
            }
        });
    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Masuk");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(25, 23, 23));
        login.add(label);
        MyTextField txtUsername = new MyTextField();
        txtUsername.setPrefixIcon(new ImageIcon(getClass().getResource("/com/ingetin/image/user.png")));

        txtUsername.setHint("Username");
        login.add(txtUsername, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/ingetin/image/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        
        JCheckBox cbShowPass = new JCheckBox("Tampilkan Password", false);
        login.add(cbShowPass);
        cbShowPass.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbShowPass.isSelected()){
                    txtPass.setEchoChar((char)0);
                } else{
                    txtPass.setEchoChar('*');
                }
            }
        });
        
        Button cmd = new Button();
        cmd.setBackground(new Color(25, 23, 23));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("MASUK");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                akun.setUsername(txtUsername.getText().trim());
                akun.setPassword(String.valueOf(txtPass.getPassword()));
            }
        });
    }
 
    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(false);
            login.setVisible(true);
        } else {
            register.setVisible(true);
            login.setVisible(false);
        }
    }

    public Akun getAkun() {
        return akun;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JPanel();
        login = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        register.setBackground(new java.awt.Color(241, 239, 239));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");

        login.setBackground(new java.awt.Color(241, 239, 239));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
