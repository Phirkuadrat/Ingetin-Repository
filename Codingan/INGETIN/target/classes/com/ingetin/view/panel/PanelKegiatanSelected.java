package com.ingetin.view.panel;

import com.ingetin.control.ControlKegiatan;
import com.ingetin.model.Akun;
import com.ingetin.model.Kegiatan;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class PanelKegiatanSelected extends javax.swing.JPanel {
    ControlKegiatan controlKegiatan = new ControlKegiatan();
    Akun akun = new Akun();
    Kegiatan kegiatan = new Kegiatan();
    
    public PanelKegiatanSelected() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateAreaBean1 = new com.miginfocom.beans.DateAreaBean();
        bgStatus = new javax.swing.ButtonGroup();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtNamaKegiatan = new javax.swing.JTextField();
        cbJenisKegiatan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCatatanKegiatan = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dcTanggalKegiatan = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbStatus1 = new javax.swing.JRadioButton();
        rbStatus2 = new javax.swing.JRadioButton();
        btnUbah = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 239, 239));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setForeground(new java.awt.Color(0, 0, 0));

        btnHapus.setText("Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
        });

        cbJenisKegiatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tugas", "Acara" }));

        taCatatanKegiatan.setColumns(20);
        taCatatanKegiatan.setRows(5);
        jScrollPane1.setViewportView(taCatatanKegiatan);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nama Kegiatan");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Jenis Kegiatan");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Catatan Kegiatan");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tanggal Kegiatan");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Status Kegiatan");

        bgStatus.add(rbStatus1);
        rbStatus1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        rbStatus1.setForeground(new java.awt.Color(0, 0, 0));
        rbStatus1.setText("Belum Selesai");

        bgStatus.add(rbStatus2);
        rbStatus2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        rbStatus2.setForeground(new java.awt.Color(0, 0, 0));
        rbStatus2.setText("Selesai");

        btnUbah.setText("Ubah");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(txtNamaKegiatan)
                                .addComponent(cbJenisKegiatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dcTanggalKegiatan, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(rbStatus1)
                                .addGap(18, 18, 18)
                                .addComponent(rbStatus2)
                                .addGap(183, 183, 183))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbJenisKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcTanggalKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbStatus1)
                    .addComponent(rbStatus2))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(btnUbah))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof JDialog) {
            JDialog dialog = (JDialog) window;
            dialog.dispose();
        }
    }//GEN-LAST:event_btnBatalMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        try {
            int idKegiatan = controlKegiatan.getIdKegiatan(kegiatan.getNama(), kegiatan.getJenis(), kegiatan.getTanggal());
            //hapus
            controlKegiatan.hapusKegiatan(idKegiatan);
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JDialog) {
                JDialog dialog = (JDialog) window;
                dialog.dispose();
            }
            JOptionPane.showMessageDialog(null, 
                    "Kegiatan Berhasil Dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) { 
            e.printStackTrace();
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JDialog) {
                JDialog dialog = (JDialog) window;
                dialog.dispose();
            }
            JOptionPane.showMessageDialog(null, 
                    "Kegiatan Gagal Dihapus", "Pesan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        try {
            int IdKegiatan = controlKegiatan.getIdKegiatan(kegiatan.getNama(), kegiatan.getJenis(), kegiatan.getTanggal());
            String status = "";
            if (rbStatus1.isSelected()){
                status = "Belum Selesai";
            } else {
                status = "Selesai";
            }
            controlKegiatan.ubahKegiatan
        (txtNamaKegiatan.getText(), cbJenisKegiatan.getSelectedItem().toString(), dcTanggalKegiatan.getDate(), taCatatanKegiatan.getText(), status, IdKegiatan);
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JDialog) {
                JDialog dialog = (JDialog) window;
                dialog.dispose();
            }
            JOptionPane.showMessageDialog(null, 
                    "Kegiatan Berhasil Diubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {   
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JDialog) {
                JDialog dialog = (JDialog) window;
                dialog.dispose();
            }
            JOptionPane.showMessageDialog(null, 
                    "Kegiatan Gagal Diubah", "Pesan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUbahMouseClicked

    public void setInfoKegiatan(Kegiatan infoKegiatan){
        txtNamaKegiatan.setText(infoKegiatan.getNama());
        cbJenisKegiatan.setSelectedItem(infoKegiatan.getJenis());
        taCatatanKegiatan.setText(infoKegiatan.getCatatan());
        dcTanggalKegiatan.setDate(infoKegiatan.getTanggal());
        if (infoKegiatan.getStatus().equals("Belum Selesai")){
            rbStatus1.setSelected(true);
        } else {
            rbStatus2.setSelected(true);
        }
        kegiatan = infoKegiatan;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgStatus;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbJenisKegiatan;
    private com.miginfocom.beans.DateAreaBean dateAreaBean1;
    private com.toedter.calendar.JDateChooser dcTanggalKegiatan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbStatus1;
    private javax.swing.JRadioButton rbStatus2;
    private javax.swing.JTextArea taCatatanKegiatan;
    private javax.swing.JTextField txtNamaKegiatan;
    // End of variables declaration//GEN-END:variables
}
