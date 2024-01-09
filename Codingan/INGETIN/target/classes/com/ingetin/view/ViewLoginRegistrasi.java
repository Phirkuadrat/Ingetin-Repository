package com.ingetin.view;

import com.ingetin.control.ControlAkun;
import com.ingetin.control.ControlProfil;
import com.ingetin.view.panel.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import net.miginfocom.swing.MigLayout;
import com.ingetin.view.panel.PanelCover;
import com.ingetin.view.panel.PanelLoginRegister;
import java.sql.SQLException;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ViewLoginRegistrasi extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginRegister loginAndRegister;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private boolean isLogin;
    private final ControlAkun control = new ControlAkun();
    ControlProfil conProf = new ControlProfil();
    
    public ViewLoginRegistrasi() {
        initComponents();
        init();
    }
    
    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                register();
            }
        };
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                login();
            };  
        };
        loginAndRegister = new PanelLoginRegister(eventRegister, eventLogin);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = 40;
                if (fraction <= 0.5f) {
                    size += fraction * 30;
                } else {
                    size += 30 - fraction * 30;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%"); //  1al as 100%
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
    }
    
    private void login() {
        try {
            int status = control.login(loginAndRegister.getAkun().getUsername(), loginAndRegister.getAkun().getPassword());
            if (status == 1) {
                dispose();
                new ViewHome().setVisible(true);
            } else {
                showMessage(Message.MessageType.ERROR, "Username atau% Password Salah ");
            }
        } catch (SQLException e) {
            showMessage(Message.MessageType.ERROR, "Error Login");
        }
    }
    
    private void register() {
        String username = loginAndRegister.getAkun().getUsername();
        String password = String.valueOf(loginAndRegister.getAkun().getPassword());
        String email = loginAndRegister.getAkun().getEmail();
        try {
            if (username.isEmpty() || password.isEmpty() || email.isEmpty()){
                showMessage(Message.MessageType.ERROR, "Isi semua kolom");
            }else if (control.checkUsername(username)) {
                showMessage(Message.MessageType.ERROR, "Username sudah digunakan");
            } else if (control.checkEmail(email)) {
                showMessage(Message.MessageType.ERROR, "Email sudah digunakan");
            } else {
                control.register(username, password, email);
                int idUser = control.getIdUser(username, password);
                conProf.addProfile(idUser);
                showMessage(Message.MessageType.SUCCESS, "Akun berhasil dibuat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(Message.MessageType.ERROR, "Error Register");
        }
    }
    
    public void showMessage(Message.MessageType messageType, String message) {
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 600));

        bg.setBackground(new java.awt.Color(193, 216, 195));
        bg.setForeground(new java.awt.Color(193, 216, 195));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1403, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewLoginRegistrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLoginRegistrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLoginRegistrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLoginRegistrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLoginRegistrasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables

}
