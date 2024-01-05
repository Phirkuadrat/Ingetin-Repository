package com.ingetin.view;

import com.ingetin.view.panel.Message;
import com.ingetin.view.panel.PanelDashboard;
import com.ingetin.view.panel.PanelHome;
import com.ingetin.view.panel.PanelProfil;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ViewHome extends javax.swing.JFrame {
    
    private boolean isClicked = true;
    private MigLayout layout;
    private final PanelProfil panelProfil = new PanelProfil();
    private final PanelHome panelHome = new PanelHome();
    private final PanelDashboard panelDashboard = new PanelDashboard();
    private JPanel panelSelected = new JPanel();
    
    public ViewHome() {
        initComponents();
        layout = new MigLayout("fill, insets 0");
        bg.setLayout(layout);
        showMessage(Message.MessageType.SUCCESS, "Berhasil Login");
        jPanelHome.setBackground(new Color(221, 219, 219));
        panelSelected = jPanelHome;
        bg.add(panelHome);
        bg.revalidate();
        bg.repaint();
    }
    
    public void showMessage(Message.MessageType messageType, String message) {
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30, gaptop 20", 0); //  Insert to bg fist index 0
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

        bg = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        Icon = new javax.swing.JPanel();
        btnMenu = new javax.swing.JLabel();
        jPanelProfil = new javax.swing.JPanel();
        btnProfil = new javax.swing.JLabel();
        jPanelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        jPanelDashboard = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setBackground(new java.awt.Color(204, 200, 170));
        bg.setMinimumSize(new java.awt.Dimension(1206, 600));
        bg.setPreferredSize(new java.awt.Dimension(1206, 600));
        bg.setLayout(new java.awt.CardLayout());

        sideBar.setBackground(new java.awt.Color(241, 239, 239));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Icon.setBackground(new java.awt.Color(241, 239, 239));

        btnMenu.setIcon(new javax.swing.ImageIcon("E:\\INGETIN\\Icon\\close.png")); // NOI18N
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
        });

        jPanelProfil.setBackground(new java.awt.Color(241, 239, 239));

        btnProfil.setBackground(new java.awt.Color(241, 239, 239));
        btnProfil.setIcon(new javax.swing.ImageIcon("E:\\INGETIN\\Icon\\user_5654521.png")); // NOI18N
        btnProfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfilMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProfilLayout = new javax.swing.GroupLayout(jPanelProfil);
        jPanelProfil.setLayout(jPanelProfilLayout);
        jPanelProfilLayout.setHorizontalGroup(
            jPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfilLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnProfil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelProfilLayout.setVerticalGroup(
            jPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfilLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnProfil)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelHome.setBackground(new java.awt.Color(241, 239, 239));

        btnHome.setBackground(new java.awt.Color(241, 239, 239));
        btnHome.setIcon(new javax.swing.ImageIcon("E:\\INGETIN\\Icon\\home1.png")); // NOI18N
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnHome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnHome)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelDashboard.setBackground(new java.awt.Color(241, 239, 239));

        btnDashboard.setBackground(new java.awt.Color(241, 239, 239));
        btnDashboard.setIcon(new javax.swing.ImageIcon("E:\\INGETIN\\Icon\\Statik1.png")); // NOI18N
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDashboardLayout = new javax.swing.GroupLayout(jPanelDashboard);
        jPanelDashboard.setLayout(jPanelDashboardLayout);
        jPanelDashboardLayout.setHorizontalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDashboardLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnDashboard)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelDashboardLayout.setVerticalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDashboardLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnDashboard)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(241, 239, 239));

        btnLogout.setBackground(new java.awt.Color(241, 239, 239));
        btnLogout.setIcon(new javax.swing.ImageIcon("E:\\INGETIN\\Icon\\logout1.png")); // NOI18N
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(btnLogout))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout IconLayout = new javax.swing.GroupLayout(Icon);
        Icon.setLayout(IconLayout);
        IconLayout.setHorizontalGroup(
            IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(IconLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(IconLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        IconLayout.setVerticalGroup(
            IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnMenu)
                .addGap(26, 26, 26)
                .addComponent(jPanelProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sideBar.add(Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1303, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // tombol sidebar//
    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        this.dispose();
        new ViewLoginRegistrasi().setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        changeColorMenuSelect(jPanelDashboard);
        panelDashboard.setData();
        bg.removeAll();
        bg.setLayout(new MigLayout("fill, insets 0")); 
        bg.add(panelDashboard);
        bg.revalidate();
        bg.repaint();
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        changeColorMenuSelect(jPanelHome);
        bg.removeAll();
        bg.setLayout(new MigLayout("fill, insets 0"));
        bg.add(panelHome);
        bg.revalidate();
        bg.repaint();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnProfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfilMouseClicked
        changeColorMenuSelect(jPanelProfil);
        bg.removeAll();
        bg.setLayout(new MigLayout("fill, insets 0")); 
        bg.add(panelProfil);
        bg.revalidate();
        bg.repaint();
    }//GEN-LAST:event_btnProfilMouseClicked

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        btnHome.setVisible(!isClicked);
        btnProfil.setVisible(!isClicked);
        btnDashboard.setVisible(!isClicked);
        if (isClicked){
            changeImage(btnMenu, "E:/INGETIN/Icon/menu.png");
            panelSelected.setBackground(new Color(241,239,239));
        } else {
            changeImage(btnMenu, "E:/INGETIN/Icon/close.png");
            panelSelected.setBackground(new Color(221, 219, 219));
        }
        isClicked = !isClicked;
    }//GEN-LAST:event_btnMenuMouseClicked

    public void changeImage (JLabel button, String lokasi){
        ImageIcon icon = new ImageIcon(lokasi);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(btnMenu.getWidth(), btnMenu.getHeight(), img.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        btnMenu.setIcon(icon);
    }
    
    public void changeColorMenuSelect(JPanel panel){
        panelSelected.setBackground(new Color(241,239,239));
        
        panel.setBackground(new Color(221, 219, 219));
        panelSelected = panel;
    }
    
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
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Icon;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnMenu;
    private javax.swing.JLabel btnProfil;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelDashboard;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JPanel jPanelProfil;
    private javax.swing.JPanel sideBar;
    // End of variables declaration//GEN-END:variables
}
