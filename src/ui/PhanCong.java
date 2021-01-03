package ui;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import connectDB.ConnectDB;

/**
 *
 * @author WIN10
 */
public class PhanCong extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	// Date format
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public PhanCong() {
		initComponents();
		setTitle("Phân Công");
	}

	private void initComponents() {

		pn_PhanCong = new javax.swing.JPanel();
		lbl_TongNhanVien = new javax.swing.JLabel();
		txt_TongNhanVien = new javax.swing.JTextField();
		lbl_ChonCongViec = new javax.swing.JLabel();
		cbb_ChonCongViec = new javax.swing.JComboBox<>();
		btn_DongY = new javax.swing.JButton();
		btn_HuyBo = new javax.swing.JButton();
		pc_NgayBatDau = new com.toedter.calendar.JDateChooser();
		pc_NgayKetThuc = new com.toedter.calendar.JDateChooser();
		lbl_ChonCongViec1 = new javax.swing.JLabel();
		lbl_ChonCongViec2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lbl_TongNhanVien.setText("Tổng nhân viên:");

		lbl_ChonCongViec.setText("Chọn công việc:");

		cbb_ChonCongViec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Công Việc" }));
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT tenCongViec FROM tbl_CongViec";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cbb_ChonCongViec.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		AutoCompleteDecorator.decorate(cbb_ChonCongViec);

		btn_DongY.setBackground(new java.awt.Color(102, 204, 0));
		btn_DongY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check.png"))); // NOI18N
		btn_DongY.setText("Đồng Ý");
		btn_DongY.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_DongYActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btn_HuyBo.setBackground(new java.awt.Color(204, 0, 51));
		btn_HuyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
		btn_HuyBo.setText("Hủy Bỏ");
		btn_HuyBo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_HuyBoActionPerformed(evt);
			}
		});

		lbl_ChonCongViec1.setText("Ngày Bắt Đầu:");

		lbl_ChonCongViec2.setText("Ngày Kết Thúc");

		javax.swing.GroupLayout pn_PhanCongLayout = new javax.swing.GroupLayout(pn_PhanCong);
		pn_PhanCong.setLayout(pn_PhanCongLayout);
		pn_PhanCongLayout
				.setHorizontalGroup(pn_PhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_PhanCongLayout.createSequentialGroup().addContainerGap().addGroup(pn_PhanCongLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(pn_PhanCongLayout.createSequentialGroup().addComponent(lbl_TongNhanVien)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txt_TongNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(pn_PhanCongLayout.createSequentialGroup()
										.addGroup(pn_PhanCongLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_ChonCongViec).addComponent(lbl_ChonCongViec1)
												.addComponent(lbl_ChonCongViec2))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(pn_PhanCongLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(pc_NgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(cbb_ChonCongViec, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(pc_NgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								pn_PhanCongLayout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btn_DongY).addGap(18, 18, 18).addComponent(btn_HuyBo)
										.addGap(43, 43, 43)));
		pn_PhanCongLayout.setVerticalGroup(pn_PhanCongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_PhanCongLayout.createSequentialGroup().addGap(30, 30, 30)
						.addGroup(pn_PhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_TongNhanVien).addComponent(txt_TongNhanVien,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(24, 24, 24)
						.addGroup(pn_PhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_ChonCongViec)
								.addComponent(cbb_ChonCongViec, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(
								pn_PhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(lbl_ChonCongViec1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(pc_NgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(pn_PhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pc_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_ChonCongViec2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(pn_PhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_DongY).addComponent(btn_HuyBo))
						.addGap(21, 21, 21)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pn_PhanCong,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pn_PhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
		setLocationRelativeTo(null);

	}// </editor-fold>//GEN-END:initComponents

	public void btn_DongYActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {// GEN-FIRST:event_btn_DongYActionPerformed
		dispose();
	}

	private void btn_HuyBoActionPerformed(ActionEvent evt) {
		dispose();
	}

	public javax.swing.JButton getBtn_DongY() {
		return btn_DongY;
	}

	public void setBtn_DongY(javax.swing.JButton btn_DongY) {
		this.btn_DongY = btn_DongY;
	}

	public javax.swing.JComboBox<String> getCbb_ChonCongViec() {
		return cbb_ChonCongViec;
	}

	public void setCbb_ChonCongViec(javax.swing.JComboBox<String> cbb_ChonCongViec) {
		this.cbb_ChonCongViec = cbb_ChonCongViec;
	}

	public String getPc_NgayBatDau() {
		return dateFormat.format(pc_NgayBatDau.getDate());
	}

	public void setPc_NgayBatDau(com.toedter.calendar.JDateChooser pc_NgayBatDau) {
		this.pc_NgayBatDau = pc_NgayBatDau;
	}

	public String getPc_NgayKetThuc() {
		return dateFormat.format(pc_NgayKetThuc.getDate());
	}

	public void setPc_NgayKetThuc(com.toedter.calendar.JDateChooser pc_NgayKetThuc) {
		this.pc_NgayKetThuc = pc_NgayKetThuc;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PhanCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PhanCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PhanCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PhanCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PhanCong().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_DongY;
	private javax.swing.JButton btn_HuyBo;
	private javax.swing.JComboBox<String> cbb_ChonCongViec;
	private javax.swing.JLabel lbl_ChonCongViec;
	private javax.swing.JLabel lbl_ChonCongViec1;
	private javax.swing.JLabel lbl_ChonCongViec2;
	private javax.swing.JLabel lbl_TongNhanVien;
	private com.toedter.calendar.JDateChooser pc_NgayBatDau;
	private com.toedter.calendar.JDateChooser pc_NgayKetThuc;
	private javax.swing.JPanel pn_PhanCong;
	private javax.swing.JTextField txt_TongNhanVien;
	// End of variables declaration//GEN-END:variables

}
