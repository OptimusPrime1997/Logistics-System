/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.businessOfficerui;

import java.awt.Color;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import ui.util.MyFrame;
import util.InputCheck;
import util.enumData.ResultMessage;
import VO.ManagementVO.VehicleVO;
import blservice.managementblservice.vehicleanddriverblservice.VehicleBLService;

/**
 *
 * @author Administrator
 */
/**
 * @author 1
 *
 */
/**
 * @author 1
 *
 */
public class car_add extends JFrame {
	// public static void main(String[] args) {
	// new car_add();
	// }
	/**
	 * Creates new form car_add
	 */
	public car_add(car_management parent) {
		MyFrame.changeLook();
		this.parent = parent;
		this.vehicleblController = parent.getVehicleblController();
		this.setVisible(true);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		initComponents();
	}

	/**
	 * 监听们~
	 * 
	 * @param evt
	 */
	private void carCodeNum_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_carCodeNum_textActionPerformed
		// TODO add your handling code here:
		carCodeNum_text.setText("");
	}// GEN-LAST:event_carCodeNum_textActionPerformed

	private void carLicenseNum_textActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_carLicenseNum_textActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_carLicenseNum_textActionPerformed

	private void cancel_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cancel_btnMouseClicked
		this.dispose();
	}// GEN-LAST:event_cancel_btnMouseClicked

	private void ok_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ok_btnMouseClicked
		String vehicleNum = parent.getOfficeNum() + "000";
		String licenseNum = carLicenseNum_text.getText();
		String startTime = timeText.getText();
		ResultMessage[] rmsg = new ResultMessage[3];
		rmsg[0] = InputCheck.checkInputNum(vehicleNum, 9);
		rmsg[1] = InputCheck.checkLicenseNum(licenseNum);
		rmsg[2] = InputCheck.checkInputDate(startTime);
		if (rmsg[0] == ResultMessage.VALID && rmsg[0] == ResultMessage.VALID
				&& rmsg[0] == ResultMessage.VALID) {
			VehicleVO v = new VehicleVO(vehicleNum, licenseNum, startTime);
			try {
				ResultMessage r = vehicleblController.insertVehicle(v);
				ResultMessage.postCheck(ResultMessage.SUCCESS, r);
				if(r==ResultMessage.SUCCESS){
					parent.initTable();
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("远程连接失败");
			}
		}else{
			System.out.println(ResultMessage.toFriendlyString(rmsg[0])+";"
					+ResultMessage.toFriendlyString(rmsg[1])+";"
					+ResultMessage.toFriendlyString(rmsg[2])+";");
		}
		this.dispose();

	}

	private void initComponents() {
		GroupLayout layout = new GroupLayout(getContentPane());
		initText();
		initLabel();
		initbtn();
		initLayout(layout);
	}

	/**
	 * @param layout
	 */
	private void initLayout(GroupLayout layout) {
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(37, 37,
																		37)
																.addComponent(
																		jLabel4))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(86, 86,
																		86)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jLabel1)
																												.addComponent(
																														jLabel2))
																								.addGap(18,
																										18,
																										18)
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																												.addComponent(
																														carLicenseNum_text,
																														GroupLayout.PREFERRED_SIZE,
																														112,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														carCodeNum_text,
																														GroupLayout.PREFERRED_SIZE,
																														112,
																														GroupLayout.PREFERRED_SIZE)))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel3)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										timeText,
																										GroupLayout.PREFERRED_SIZE,
																										54,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(18,
																										18,
																										18)))))
								.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(cancel_btn).addGap(54, 54, 54)
								.addComponent(ok_btn).addGap(20, 20, 20)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addComponent(jLabel4)
						.addGap(20, 20, 20)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(carCodeNum_text,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(15, 15, 15)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(carLicenseNum_text,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3)
										.addComponent(timeText,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(cancel_btn)
										.addComponent(ok_btn))
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pack();
	}

	/**
	 * 
	 */
	private void initbtn() {
		ok_btn = new JButton();
		cancel_btn = new JButton();
		cancel_btn.setText("取消");
		ok_btn.setText("确定");
		cancel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				cancel_btnMouseClicked(evt);
			}
		});
		ok_btn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ok_btnMouseClicked(evt);
			}
		});
	}

	private void initLabel() {// TODO
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();

		jLabel1.setText("车辆代号");
		jLabel1.setVisible(false);
		jLabel2.setText("车牌号");
		jLabel4.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
		jLabel3.setText("服役时间");
		jLabel4.setForeground(new java.awt.Color(0, 102, 255));
		jLabel4.setText("车辆增加");
	}

	private void initText() {
		// TODO
		carCodeNum_text = new JTextField();
		carLicenseNum_text = new JTextField();
		timeText = new JTextField();

		carCodeNum_text.setEditable(false);
		carCodeNum_text.setText("025001014");
		carCodeNum_text.setVisible(false);
		carCodeNum_text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				carCodeNum_textActionPerformed(evt);
			}
		});

		carLicenseNum_text
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						carLicenseNum_textActionPerformed(evt);
					}
				});
	}

	private VehicleBLService vehicleblController;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private car_management parent;
	private JButton cancel_btn;
	private JTextField carCodeNum_text;
	private JTextField carLicenseNum_text;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JButton ok_btn;
	private JTextField timeText;
	// End of variables declaration//GEN-END:variables
}
