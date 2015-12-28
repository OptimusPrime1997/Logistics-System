/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.courierui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import main.MainFrame;
import ui.Img;
import ui.receiptui.Order;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyFrame;
import util.CurrentCity;
import util.CurrentTime;
import util.enumData.City;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import VO.LogVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.goodsblservice.GoodsFindBLService;
import blservice.logblservice.LogBLService;
import blservice.loginblservice.LoginBLService;

public class courier_main extends JPanel {
	static int NUM_OF_DAYS=7;
	GoodsFindBLService goodsController = ControllerFactoryImpl
			.getInstance().getGoodsFindController();

	public courier_main() {
		ctr_login=ControllerFactoryImpl.getInstance().getLoginController();
		ctr_log=ControllerFactoryImpl.getInstance().getLogController();
		initComponents();
		frame=new MyFrame(this);
		
	}
	public static void main(String[] args) {
		new courier_main();
	}
	/**
	 * 给main的子界面调用~反馈给用户操作成功的message
	 * @param msg
	 */
	public void setFeedBack(ResultMessage msg){
		feedBack_text.setText(ResultMessage.toFriendlyString(msg));
	}
	private void initComponents() {
		initLabel();
		for(int i=0;i<NUM_OF_DAYS;i++){
			createJProgressBar();
		}
		initProBar();
		initbtn();
		initText();
		initLayOut();
	}
	/**
	 * 给进度条赋值
	 */
	public void initProBar() {
		for(int i=0;i<bars.size();i++) {
			bars.get(i).setValue(0);
		}
		//赋值
		int[]values=goodsController.getdaysNumOfGoods(NUM_OF_DAYS);
		for(int i=0;i<bars.size();i++) {
			bars.get(i).setValue(values[i]);
			System.out.println(values[i]);
		}
	}
	/*
	 * 初始化布局
	 */
	private void initLayOut() {
		this.setLayout(null);
		this.add(exit_btn);
		this.add(account_label1);
		this.add(newGoodsbtn);
		this.add(signedGoodsbtn);
		this.add(businessOffice_label);
		this.add(businessOfficeNum_label);
		this.add(recentDays_label);
		this.add(account_label0);
		this.add(feedBack_text);
		for(JLabel label:labels){
			this.add(label);
		}
		for(JProgressBar bar:bars){
			this.add(bar);
		}
	}

	private void initText() {
		// TODO 显示  新订单创建成功~~的反馈信息！
		feedBack_text=new JTextField();
		feedBack_text.setEditable(false);
		
	}
	private void initbtn() {
		newGoodsbtn = new MyButton(50,150,ButtonType.BIG);
		signedGoodsbtn = new MyButton(50,300,ButtonType.BIG);
		exit_btn = new MyButton(790, 10, ButtonType.EXIT);
		signedGoodsbtn.setText("已签收");
		newGoodsbtn.setText("新订单");
		
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
		
		exit_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exit_btnActionPerformed(evt);
			}
		});
	}

	
	private void initLabel() {
		String Cdate=CurrentTime.getDate();
		account_label1=new JLabel();
		businessOffice_label = new JLabel();
		account_label0 = new JLabel();
		recentDays_label = new JLabel();
		businessOfficeNum_label = new JLabel();
		recentDays_label.setText("最近7天业绩（收派件数）");
		businessOffice_label.setText("营业厅：");
		String officeNum="",city="";
		try {
			account_label1.setText(ctr_login.getCurrentName());
			officeNum=ctr_login.getCurrentOptorId().substring(0, 6);
			city=City.toString(CurrentCity.getCurrentCity());
		} catch (RemoteException e) {
		}
		
		businessOfficeNum_label.setText(city+" "+officeNum);
		account_label0.setText("账户：");
		JLabel date=new JLabel();
		for(int i=0;i<NUM_OF_DAYS;i++)creatLabels(date);
		for(int i=0;i<NUM_OF_DAYS;i++) 
			labels.get(i).setText(CurrentTime.minusDate(Cdate, i).substring(5, 10));
	}
	private void creatLabels(JLabel date) {
		date=new JLabel();
		labels.add(date);
	}
	private void createJProgressBar() {
		JProgressBar bar=new JProgressBar();
		bars.add(bar);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(Img.getBackground_main(), 0, 0, null);
	}
	/*
	 * 监听们～
	 */
	private void signedGoodsbtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_signedGoodsbtnMouseClicked
		try {
			LogVO vo = new LogVO(LogType.END_A_GOODS, ctr_login.getCurrentOptorId(), CurrentTime.getDate());
			ctr_log.add(vo);
		} catch (RemoteException e) {
		}
		
		new courier_signed(this);
	}
	private void newGoodsbtnMouseClicked(MouseEvent evt) {
		try {
			LogVO vo = new LogVO(LogType.ADD_A_GOODS, ctr_login.getCurrentOptorId(), CurrentTime.getDate());
			ctr_log.add(vo);
		} catch (RemoteException e) {
		}
		
		new Order(this);
	}
	
	private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exit_btnActionPerformed
		if (evt.getSource() == exit_btn) {
			Object[] options = { "取消", "确定" };
			int result = JOptionPane.showOptionDialog(null, "您确定要退出系统？",
					"是否退出", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (result == JOptionPane.NO_OPTION) {
				frame.dispose();
				new MainFrame();
			}
		}
	}
	// Variables declaration
	private MyButton newGoodsbtn,signedGoodsbtn,exit_btn;
	private JLabel businessOfficeNum_label, businessOffice_label,
	        account_label0,account_label1,recentDays_label;
	private ArrayList<JLabel> labels=new ArrayList<JLabel>();//近日的日期
	private ArrayList<JProgressBar> bars=new ArrayList<JProgressBar>();//近日业绩的进度条
	private JTextField feedBack_text;
	private MyFrame frame;
	private LoginBLService ctr_login;
	private LogBLService ctr_log;
	
	// End of variables declaration
}
