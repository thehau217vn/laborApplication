/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
/**
 *
 * @author WIN10
 */
public class DoiMatKhau extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form DoiMatKhau
     */
    public DoiMatKhau() {
        initComponents();
    }

    private void initComponents() {

        pn_DoiMatKhau = new javax.swing.JPanel();
        txt_mkCu = new javax.swing.JTextField();
        mk_Cu = new javax.swing.JLabel();
        mk_Moi1 = new javax.swing.JLabel();
        txt_mkMoi = new javax.swing.JTextField();
        mk_Moi2 = new javax.swing.JLabel();
        txt_XacNhanMatKhau = new javax.swing.JTextField();
        btn_DongY = new javax.swing.JButton();
        btn_HuyBo = new javax.swing.JButton();
        lbl_DoiMK = new javax.swing.JLabel();
        pn_LogoDoiMK = new javax.swing.JPanel();
        lbl_logoDoiMK = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đổi mật khẩu");

        mk_Cu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mk_Cu.setText("Mật khẩu cũ");

        mk_Moi1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mk_Moi1.setText("Mật khẩu mới");

        mk_Moi2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mk_Moi2.setText("Xác nhận lại mật khẩu mới");

        btn_DongY.setBackground(new java.awt.Color(102, 204, 0));
        btn_DongY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check.png"))); // NOI18N
        btn_DongY.setText("Đồng ý");

        btn_HuyBo.setBackground(new java.awt.Color(204, 0, 51));
        btn_HuyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btn_HuyBo.setText("Hủy bỏ");

        lbl_DoiMK.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_DoiMK.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout pn_DoiMatKhauLayout = new javax.swing.GroupLayout(pn_DoiMatKhau);
        pn_DoiMatKhau.setLayout(pn_DoiMatKhauLayout);
        pn_DoiMatKhauLayout.setHorizontalGroup(
            pn_DoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_DoiMatKhauLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_DoiMK)
                .addGap(30, 30, 30))
            .addGroup(pn_DoiMatKhauLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_DoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_DoiMatKhauLayout.createSequentialGroup()
                        .addGroup(pn_DoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mkMoi)
                            .addComponent(txt_mkCu)
                            .addGroup(pn_DoiMatKhauLayout.createSequentialGroup()
                                .addGroup(pn_DoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mk_Cu)
                                    .addComponent(mk_Moi1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(13, 13, 13))
                    .addGroup(pn_DoiMatKhauLayout.createSequentialGroup()
                        .addComponent(mk_Moi2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_DoiMatKhauLayout.createSequentialGroup()
                        .addComponent(txt_XacNhanMatKhau)
                        .addGap(13, 13, 13))
                    .addGroup(pn_DoiMatKhauLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btn_DongY)
                        .addGap(18, 18, 18)
                        .addComponent(btn_HuyBo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pn_DoiMatKhauLayout.setVerticalGroup(
            pn_DoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_DoiMatKhauLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbl_DoiMK)
                .addGap(18, 18, 18)
                .addComponent(mk_Cu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_mkCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mk_Moi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_mkMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mk_Moi2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_XacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pn_DoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_DongY)
                    .addComponent(btn_HuyBo))
                .addGap(25, 25, 25))
        );

        pn_LogoDoiMK.setBackground(new java.awt.Color(255, 255, 255));

        lbl_logoDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N

        javax.swing.GroupLayout pn_LogoDoiMKLayout = new javax.swing.GroupLayout(pn_LogoDoiMK);
        pn_LogoDoiMK.setLayout(pn_LogoDoiMKLayout);
        pn_LogoDoiMKLayout.setHorizontalGroup(
            pn_LogoDoiMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_LogoDoiMKLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbl_logoDoiMK)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pn_LogoDoiMKLayout.setVerticalGroup(
            pn_LogoDoiMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_LogoDoiMKLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lbl_logoDoiMK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pn_LogoDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_DoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_DoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_LogoDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DongY;
    private javax.swing.JButton btn_HuyBo;
    private javax.swing.JLabel lbl_DoiMK;
    private javax.swing.JLabel lbl_logoDoiMK;
    private javax.swing.JLabel mk_Cu;
    private javax.swing.JLabel mk_Moi1;
    private javax.swing.JLabel mk_Moi2;
    private javax.swing.JPanel pn_DoiMatKhau;
    private javax.swing.JPanel pn_LogoDoiMK;
    private javax.swing.JTextField txt_XacNhanMatKhau;
    private javax.swing.JTextField txt_mkCu;
    private javax.swing.JTextField txt_mkMoi;
    // End of variables declaration//GEN-END:variables
}
