package com.ingetin.view.panel;

import com.ingetin.control.ControlKegiatan;
import com.ingetin.model.Kegiatan;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import javax.swing.JDialog;


public class PanelHome extends javax.swing.JPanel {

    ControlKegiatan conKegiatan = new ControlKegiatan();
    
    public PanelHome() {
        initComponents();
        showKegiatan();
    }
    
    
    private String getSelectedFilterJenis() {
        return cbTampilkan.getSelectedItem().toString();
    }
    
    private String getSelectedFilterStatus() {
        return cbTampilkan1.getSelectedItem().toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTambah = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlKegiatan = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbTampilkan = new javax.swing.JComboBox<>();
        cbTampilkan1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 200, 170));

        btnTambah.setForeground(new java.awt.Color(0, 0, 0));
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ingetin/image/add (2).png"))); // NOI18N
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");

        pnlKegiatan.setBackground(new java.awt.Color(204, 200, 170));
        pnlKegiatan.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(pnlKegiatan);

        btnRefresh.setForeground(new java.awt.Color(0, 0, 0));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ingetin/image/refresh.png"))); // NOI18N
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tampilkan:");

        cbTampilkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Tugas", "Acara" }));

        cbTampilkan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Selesai", "Belum Selesai" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbTampilkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbTampilkan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRefresh)
                            .addGap(18, 18, 18)
                            .addComponent(btnTambah))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTampilkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTampilkan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        PanelAdd add = new PanelAdd();
        JDialog dialog = new JDialog();
 
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.getContentPane().add(add);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        
        dialog.setVisible(true);
        showKegiatan();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        showKegiatan();
    }//GEN-LAST:event_btnRefreshMouseClicked

    public void showKegiatan(){
        String filter = getSelectedFilterJenis();
        String filter2 = getSelectedFilterStatus();
        List<Kegiatan> kegiatanList = conKegiatan.getListKegiatan(filter, filter2);
        pnlKegiatan.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        for (Kegiatan kegiatan : kegiatanList) {
            PanelKegiatan kotakKegiatan = new PanelKegiatan();
            kotakKegiatan.setKegiatanInfo(kegiatan);
            pnlKegiatan.add(kotakKegiatan, gbc);
            gbc.gridx++;
            if (gbc.gridx >= 3) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }
        pnlKegiatan.revalidate();
        pnlKegiatan.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnRefresh;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JComboBox<String> cbTampilkan;
    private javax.swing.JComboBox<String> cbTampilkan1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlKegiatan;
    // End of variables declaration//GEN-END:variables
}
