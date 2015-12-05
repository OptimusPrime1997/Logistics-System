/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.courierui;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import .GroupLayout;
import .JFrame;
import .JLabel;
import .JProgressBar;

import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.goodsblservice.GoodsFindBLService;
import ui.mainFrame.MainFrame;
import ui.receiptui.Order;
import util.CurrentTime;
import util.MyFrame;

public class courier_main extends .JPanel {
	static int NUM_OF_DAYS=7;
	GoodsFindBLService goodsController = ControllerFactoryImpl
			.getInstance().getGoodsFindController();

	public courier_main() {
		initComponents();
	}
	private void initComponents() {
		.GroupLayout layout = new .GroupLayout(this);
		this.setLayout(layout);
		initLabel();
		initProBar();
		initbtn();
		initLayOut(layout);
		initText();
		
	}
	
	/*
	 * 初始化布局
	 */
	private void initLayOut(GroupLayout layout) {

		layout.setHorizontalGroup(layout
				.createParallelGroup(.GroupLayout.Alignment.LEADING)
				.addGroup(
						.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(44, 44, 44)
								.addGroup(
										layout.createParallelGroup(
												.GroupLayout.Alignment.LEADING)
												.addComponent(
														signedGoodsbtn,
														.GroupLayout.PREFERRED_SIZE,
														101,
														.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														newGoodsbtn,
														.GroupLayout.PREFERRED_SIZE,
														99,
														.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(124,
																		124,
																		124)
																.addComponent(
																		businessOffice_label)
																.addPreferredGap(
																		.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		businessOfficeNum_label)))
								.addGap(28, 28, 28)
								.addGroup(
										layout.createParallelGroup(
												.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(31,
																										31,
																										31)
																								.addGroup(
																										layout.createParallelGroup(
																												.GroupLayout.Alignment.TRAILING)
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
																										.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												.GroupLayout.Alignment.LEADING)
																												.addGroup(
																														layout.createParallelGroup(
																																.GroupLayout.Alignment.TRAILING,
																																false)
																																.addComponent(
																																		bars.get(3),
																																		.GroupLayout.Alignment.LEADING,
																																		.GroupLayout.DEFAULT_SIZE,
																																		.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		bars.get(4),
																																		.GroupLayout.Alignment.LEADING,
																																		.GroupLayout.PREFERRED_SIZE,
																																		.GroupLayout.DEFAULT_SIZE,
																																		.GroupLayout.PREFERRED_SIZE))
																												.addGroup(
																														layout.createParallelGroup(
																																.GroupLayout.Alignment.TRAILING,
																																false)
																																.addComponent(
																																		bars.get(0),
																																		.GroupLayout.Alignment.LEADING,
																																		.GroupLayout.DEFAULT_SIZE,
																																		.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		bars.get(1),
																																		.GroupLayout.Alignment.LEADING,
																																		.GroupLayout.DEFAULT_SIZE,
																																		.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		bars.get(2),
																																		.GroupLayout.Alignment.LEADING,
																																		.GroupLayout.PREFERRED_SIZE,
																																		.GroupLayout.DEFAULT_SIZE,
																																		.GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		bars.get(5),
																																		.GroupLayout.Alignment.LEADING,
																																		.GroupLayout.DEFAULT_SIZE,
																																		.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		bars.get(6),
																																		.GroupLayout.Alignment.LEADING,
																																		.GroupLayout.PREFERRED_SIZE,
																																		.GroupLayout.DEFAULT_SIZE,
																																		.GroupLayout.PREFERRED_SIZE))))
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
																		.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		account_btn,
																		.GroupLayout.PREFERRED_SIZE,
																		85,
																		.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		.LayoutStyle.ComponentPlacement.RELATED,
																		114,
																		Short.MAX_VALUE)
																.addComponent(
																		exit_btn)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																.GroupLayout.Alignment.BASELINE)
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
										.GroupLayout.PREFERRED_SIZE,
										25,
										.GroupLayout.PREFERRED_SIZE)
								.addGap(11, 11, 11)
								.addGroup(
										layout.createParallelGroup(
												.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										bars.get(6),
																										.GroupLayout.PREFERRED_SIZE,
																										.GroupLayout.DEFAULT_SIZE,
																										.GroupLayout.PREFERRED_SIZE)
																								.addGap(18,
																										18,
																										18)
																								.addGroup(
																										layout.createParallelGroup(
																												.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														labels.get(5))
																												.addComponent(
																														bars.get(5),
																														.GroupLayout.PREFERRED_SIZE,
																														.GroupLayout.DEFAULT_SIZE,
																														.GroupLayout.PREFERRED_SIZE))
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										labels.get(4)))
																				.addComponent(
																						newGoodsbtn,
																						.GroupLayout.PREFERRED_SIZE,
																						56,
																						.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18,
																		18)
																.addComponent(
																		labels.get(3)))
												.addGroup(
														layout.createParallelGroup(
																.GroupLayout.Alignment.TRAILING)
																.addGroup(
																		.GroupLayout.Alignment.LEADING,
																		layout.createSequentialGroup()
																				.addGap(63,
																						63,
																						63)
																				.addComponent(
																						bars.get(4),
																						.GroupLayout.PREFERRED_SIZE,
																						.GroupLayout.DEFAULT_SIZE,
																						.GroupLayout.PREFERRED_SIZE)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						bars.get(3),
																						.GroupLayout.PREFERRED_SIZE,
																						.GroupLayout.DEFAULT_SIZE,
																						.GroupLayout.PREFERRED_SIZE))
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
												.GroupLayout.Alignment.TRAILING)
												.addComponent(
														labels.get(2))
												.addComponent(
														bars.get(2),
														.GroupLayout.PREFERRED_SIZE,
														.GroupLayout.DEFAULT_SIZE,
														.GroupLayout.PREFERRED_SIZE))
								.addGroup(
										layout.createParallelGroup(
												.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(15, 15,
																		15)
																.addGroup(
																		layout.createParallelGroup(
																				.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						bars.get(1),
																						.GroupLayout.PREFERRED_SIZE,
																						.GroupLayout.DEFAULT_SIZE,
																						.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						signedGoodsbtn,
																						.GroupLayout.PREFERRED_SIZE,
																						59,
																						.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						bars.get(0),
																						.GroupLayout.PREFERRED_SIZE,
																						.GroupLayout.DEFAULT_SIZE,
																						.GroupLayout.PREFERRED_SIZE)
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

	private void initText() {
		// TODO 显示  新订单创建成功~~的反馈信息！
		
	}
	private void initbtn() {
		signedGoodsbtn = new .JButton();
		newGoodsbtn = new .JButton();
		account_btn = new .JButton();
		exit_btn = new .JButton();
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
		 .JProgressBar bar=new JProgressBar();;//bars[0]==today,bars[i]=i days ago
		for(int i=0;i<NUM_OF_DAYS;i++)createJProgressBar(bar);
		//赋值
//		int[]values=goodsController.getdaysNumOfGoods(NUM_OF_DAYS);
		int[]values=new int[]{10,20,30,40,10,50,45};//TODO 获取数据		
		for(int i=0;i<bars.size();i++) bars.get(i).setValue(values[i]);
	}
	private void initLabel() {
		String Cdate=CurrentTime.getDate();
		businessOffice_label = new .JLabel();
		account_label = new .JLabel();
		recentDays_label = new .JLabel();
		businessOfficeNum_label = new .JLabel();
		recentDays_label.setText("最近7天业绩（收派件数）");
		businessOffice_label.setText("营业厅：");
		businessOfficeNum_label.setText("南京 025001");
		account_label.setText("账户：");
		JLabel date=new JLabel();
		for(int i=0;i<NUM_OF_DAYS;i++)creatLabels(date);
		for(int i=0;i<NUM_OF_DAYS;i++) 
			labels.get(i).setText(CurrentTime.minusDate(Cdate, i).substring(5, 10));
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
		MyFrame frame=new MyFrame(500, 600, new Order());
	}
	private void account_btnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_account_btnActionPerformed

	}
	private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exit_btnActionPerformed
		System.exit(0);
	}
	// Variables declaration
	private .JButton account_btn;
	private .JLabel businessOfficeNum_label;
	private .JButton exit_btn;
	private ArrayList<JLabel> labels=new ArrayList<JLabel>();//近日的日期
	private ArrayList<JProgressBar> bars=new ArrayList<JProgressBar>();//近日业绩的进度条
	
	private .JLabel businessOffice_label;
	private .JLabel account_label;
	private .JLabel recentDays_label;
	private .JButton newGoodsbtn;
	private .JButton signedGoodsbtn;

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
			for (.UIManager.LookAndFeelInfo info : .UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					.UIManager.setLookAndFeel(info.getClassName());
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
		} catch (.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				MyFrame frame=new MyFrame(830, 590, new courier_main());
				frame.setDefaultCloseOperation(.WindowConstants.EXIT_ON_CLOSE);
			}
		});
	}
}
