/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.courierui;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.goodsblservice.GoodsGetByCouriersBLService;
import ui.mainFrame.MainFrame;
import ui.receiptui.Order;
import util.CurrentTime;

public class courier_main extends javax.swing.JPanel {
	static int NUM_OF_DAYS=7;
	GoodsGetByCouriersBLService goodsController = ControllerFactoryImpl
			.getInstance().getGoodsGetByCourierController();

	public courier_main() {
		initComponents();
	}
	private void initComponents() {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		initLabel();
		initProBar();
		initbtn();
		initLayOut(layout);
		
	}
	/*
	 * 初始化布局
	 */
	private void initLayOut(GroupLayout layout) {

		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(44, 44, 44)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														signedGoodsbtn,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														101,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														newGoodsbtn,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														99,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(124,
																		124,
																		124)
																.addComponent(
																		businessOffice_label)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		businessOfficeNum_label)))
								.addGap(28, 28, 28)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(31,
																										31,
																										31)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																												.addComponent(
																														labels.get(5))
																												.addComponent(
																														labels.get(4))
																												.addComponent(
																														labels.get(6))
																												.addComponent(
																														labels.get(3))
																												.addComponent(
																														labels.get(2))
																												.addComponent(
																														labels.get(1))
																												.addComponent(
																														labels.get(0)))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addGroup(
																														layout.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																false)
																																.addComponent(
																																		bars.get(3),
																																		javax.swing.GroupLayout.Alignment.LEADING,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		bars.get(4),
																																		javax.swing.GroupLayout.Alignment.LEADING,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.PREFERRED_SIZE))
																												.addGroup(
																														layout.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																false)
																																.addComponent(
																																		bars.get(0),
																																		javax.swing.GroupLayout.Alignment.LEADING,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		bars.get(1),
																																		javax.swing.GroupLayout.Alignment.LEADING,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		bars.get(2),
																																		javax.swing.GroupLayout.Alignment.LEADING,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		bars.get(5),
																																		javax.swing.GroupLayout.Alignment.LEADING,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		bars.get(6),
																																		javax.swing.GroupLayout.Alignment.LEADING,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.PREFERRED_SIZE))))
																				.addComponent(
																						recentDays_label))
																.addGap(0,
																		0,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		account_label)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		account_btn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		85,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		114,
																		Short.MAX_VALUE)
																.addComponent(
																		exit_btn)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		account_btn)
																.addComponent(
																		account_label)
																.addComponent(
																		businessOfficeNum_label)
																.addComponent(
																		businessOffice_label))
												.addComponent(exit_btn))
								.addGap(18, 18, 18)
								.addComponent(recentDays_label,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(11, 11, 11)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										bars.get(6),
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(18,
																										18,
																										18)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														labels.get(5))
																												.addComponent(
																														bars.get(5),
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										labels.get(4)))
																				.addComponent(
																						newGoodsbtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						56,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18,
																		18)
																.addComponent(
																		labels.get(3)))
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
																.addGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		layout.createSequentialGroup()
																				.addGap(63,
																						63,
																						63)
																				.addComponent(
																						bars.get(4),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						bars.get(3),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						labels.get(6))
																				.addGap(95,
																						95,
																						95))))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														labels.get(2))
												.addComponent(
														bars.get(2),
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(15, 15,
																		15)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						bars.get(1),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						signedGoodsbtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						59,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						bars.get(0),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										labels.get(1))
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										labels.get(0))))))
								.addContainerGap(78, Short.MAX_VALUE)));
		
	}

	private void initbtn() {
		signedGoodsbtn = new javax.swing.JButton();
		newGoodsbtn = new javax.swing.JButton();
		account_btn = new javax.swing.JButton();
		exit_btn = new javax.swing.JButton();
		signedGoodsbtn.setText("已签收");
		newGoodsbtn.setText("新订单");
		account_btn.setText("老王（包括更改密码、退出登录）");
		exit_btn.setText("退出系统");
		addListeners();
	}

	private void addListeners() {
		signedGoodsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				signedGoodsbtnMouseClicked(evt);
			}
		});
		newGoodsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				newGoodsbtnMouseClicked(evt);
			}			
		});
		account_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				account_btnActionPerformed(evt);
			}
		});
		exit_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exit_btnActionPerformed(evt);
			}
		});
	}

	private void initProBar() {
		 javax.swing.JProgressBar bar=new JProgressBar();;//bars[0]==today,bars[i]=i days ago
		for(int i=0;i<NUM_OF_DAYS;i++)createJProgressBar(bar);
		//赋值
		int[]values=goodsController.getdaysNumOfGoods(NUM_OF_DAYS);
//		int[]values=new int[]{10,20,30,40,10,50,45};//TODO 获取数据		
		for(int i=0;i<bars.size();i++) bars.get(i).setValue(values[i]);
	}
	private void initLabel() {
		String Cdate=CurrentTime.getDate();
		businessOffice_label = new javax.swing.JLabel();
		account_label = new javax.swing.JLabel();
		recentDays_label = new javax.swing.JLabel();
		businessOfficeNum_label = new javax.swing.JLabel();
		recentDays_label.setText("最近7天业绩（收派件数）");
		businessOffice_label.setText("营业厅：");
		businessOfficeNum_label.setText("南京 025001");
		account_label.setText("账户：");
		JLabel date=new JLabel();
		for(int i=0;i<NUM_OF_DAYS;i++)creatLabels(date);
		for(int i=0;i<NUM_OF_DAYS;i++) 
			labels.get(i).setText(CurrentTime.minus(Cdate, i).substring(5, 10));
	}
	private void creatLabels(JLabel date) {
		date=new JLabel();
		labels.add(date);
	}
	private void createJProgressBar(JProgressBar bar) {
		bar=new JProgressBar();
		bars.add(bar);
	}
	/*
	 * 监听们～
	 */
	private void signedGoodsbtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_signedGoodsbtnMouseClicked
		new courier_signed().setVisible(true);
	}
	private void newGoodsbtnMouseClicked(MouseEvent evt) {
		JFrame frame = new JFrame();
		frame.setSize(500, 600);
		frame.setContentPane(new Order());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
	}
	private void account_btnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_account_btnActionPerformed

	}
	private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exit_btnActionPerformed
		System.exit(0);
	}
	// Variables declaration
	private javax.swing.JButton account_btn;
	private javax.swing.JLabel businessOfficeNum_label;
	private javax.swing.JButton exit_btn;
	private ArrayList<JLabel> labels=new ArrayList<JLabel>();//近日的日期
	private ArrayList<JProgressBar> bars=new ArrayList<JProgressBar>();//近日业绩的进度条
	
	private javax.swing.JLabel businessOffice_label;
	private javax.swing.JLabel account_label;
	private javax.swing.JLabel recentDays_label;
	private javax.swing.JButton newGoodsbtn;
	private javax.swing.JButton signedGoodsbtn;

	// End of variables declaration
	/**
	 * for test~~
	 */
	public static void main(String[] args) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(830, 590);
				frame.setVisible(true);
				frame.setContentPane(new courier_main());
				frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			}
		});
	}
}
