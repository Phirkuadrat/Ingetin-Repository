package com.ingetin.view.panel;

import com.ingetin.model.Kegiatan;
import java.awt.Dialog;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;

public class PanelKegiatan extends javax.swing.JPanel {

    Kegiatan kegiatanInfo = new Kegiatan();
    
    public PanelKegiatan() {
        initComponents();
    }
    
    public void setKegiatanInfo (Kegiatan kegiatan){
        kegiatanInfo = kegiatan;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        namaKegiatan.setText(kegiatanInfo.getNama());
        jenisKegiatan.setText(kegiatanInfo.getJenis());
        tanggalKegiatan.setText(dateFormat.format(kegiatanInfo.getTanggal()));
        catatan.setText(kegiatanInfo.getCatatan());
        statusKegiatan.setText(kegiatanInfo.getStatus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namaKegiatan = new javax.swing.JLabel();
        statusKegiatan = new javax.swing.JLabel();
        jenisKegiatan = new javax.swing.JLabel();
        tanggalKegiatan = new javax.swing.JLabel();
        catatan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(241, 239, 239));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        namaKegiatan.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        namaKegiatan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaKegiatan.setLabelFor(namaKegiatan);

        statusKegiatan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        statusKegiatan.setLabelFor(namaKegiatan);

        jenisKegiatan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jenisKegiatan.setLabelFor(namaKegiatan);

        tanggalKegiatan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tanggalKegiatan.setLabelFor(namaKegiatan);

        catatan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        catatan.setForeground(new java.awt.Color(0, 0, 0));
        catatan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        catatan.setLabelFor(namaKegiatan);
        catatan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Jenis Kegiatan");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tanggal Kegiatan");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Catatan Kegiatan");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Status Kegiatan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(namaKegiatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jenisKegiatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tanggalKegiatan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusKegiatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(catatan, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(namaKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenisKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(catatan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        PanelKegiatanSelected select = new PanelKegiatanSelected();
        JDialog dialog = new JDialog();
        select.setInfoKegiatan(kegiatanInfo);
        
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
        dialog.getContentPane().add(select);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel catatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jenisKegiatan;
    private javax.swing.JLabel namaKegiatan;
    private javax.swing.JLabel statusKegiatan;
    private javax.swing.JLabel tanggalKegiatan;
    // End of variables declaration//GEN-END:variables
}
