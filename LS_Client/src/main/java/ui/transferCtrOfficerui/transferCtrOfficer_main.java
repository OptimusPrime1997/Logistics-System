package ui.transferCtrOfficerui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import main.MainFrame;
import ui.Img;
import ui.receiptui.generalUI.ReceptionRep;
import ui.receiptui.generalUI.ShippingRep;
import ui.receiptui.generalUI.TransferRep;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyFrame;
import ui.util.MyLabel;
import ui.util.MyTextField;
import ui.util.TextType;
import util.CurrentCity;
import util.CurrentTime;
import util.enumData.City;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import util.enumData.ShipForm;
import VO.LogVO;
import VO.Receipt.TransferRepVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.logblservice.LogBLService;
import blservice.loginblservice.LoginBLService;
import blservice.receiptblservice.TransferRepblService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class transferCtrOfficer_main extends JPanel {

	public static void main(String[] args) {
		new transferCtrOfficer_main();
	}
    public transferCtrOfficer_main() {
    	ctr_login=ControllerFactoryImpl.getInstance().getLoginController();
        ctr_log= ControllerFactoryImpl.getInstance().getLogController();
        ctr_trans=ControllerFactoryImpl.getInstance().getTransferRepblService();
    	initComponents();
       this.frame=new MyFrame(this);
    }
    /**
	 * 给main的子界面调用~反馈给用户操作成功的message
	 * @param msg
	 */
	public void setFeedback(ResultMessage msg){
		feedback_text.setText(ResultMessage.toFriendlyString(msg));
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(Img.getBackground_main(), 0, 0, null);
	}
    private void initComponents() {
    	initLabel();
		initProBar();
		initbtn();
		initText();
		initLayOut();
    }
    private void initLayOut() {
    	this.setLayout(null);
    	this.add(outByPlane_progressBar);
    	this.add(outByTrain_progressBar);
    	this.add(outByTruck_progressBar);
    	this.add(account_label);
    	this.add(account0_label);
    	this.add(outByPlane_label);
    	this.add(outByShip_label);
    	this.add(outByTrain_label);
    	this.add(plane_label);
    	this.add(train_label);
    	this.add(truck_label);
    	this.add(trs_label);
    	this.add(transferOfficeNum_label);
    	this.add(exit_btn);
    	this.add(toBusinessOffice_btn);
    	this.add(toTransferCTR_btn);
    	this.add(arrival_btn);
    	
	}
	private void initText() {
        feedback_text = new MyTextField(TextType.FEEDBACK,20,400,300,20);
	}
	private void initbtn() {
        arrival_btn = new MyButton(30,100,ButtonType.ARRIVE_BIG);
        toBusinessOffice_btn = new MyButton(30,250,ButtonType.TO_YYT);
        toTransferCTR_btn = new MyButton(30,400,ButtonType.TO_TRANSFER_CTR);
        exit_btn = new MyButton(790,10,ButtonType.EXIT);
		try {
			account_label.setText(ctr_login.getCurrentName());
		} catch (RemoteException e1) {
		}
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        
        toBusinessOffice_btn.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		toBusinessOffice_btnMouseClicked();
        	}
		});
        arrival_btn.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		arrival_btnMouseClicked();
        	}
		});
        toTransferCTR_btn.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		toTransferCTR_btnMouseClicked();
        	}
		});

	}
	private void initProBar() {
		/*
		 * train_label = new MyLabel("火车",400,150,30,20);
		truck_label = new MyLabel("汽车",400,250,30,20);
		plane_label = new MyLabel("飞机",400,350,30,20);
		 */
		//TODO
    	 outByTrain_progressBar = new JProgressBar();
         outByTruck_progressBar = new JProgressBar();
         outByPlane_progressBar = new JProgressBar();
         outByTrain_progressBar.setBounds(450, 150, 200, 30);
         outByTruck_progressBar.setBounds(450,250,200,30);
         outByPlane_progressBar.setBounds(450, 350, 200, 30);
		refreshValues();
	}

	public void refreshValues() {
		ArrayList<TransferRepVO> vos;
		try {
			vos = ctr_trans.getRepByDate(CurrentTime.getDate(), officeNum);
			if(vos!=null){
				for (TransferRepVO vo : vos) {
					if (vo.form == ShipForm.TRAIN)
						train++;
					if (vo.form == ShipForm.TRUCK)
						truck++;
					if (vo.form == ShipForm.PLANE)
						plane++;
				}
			}
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
		}
		outByTrain_progressBar.setValue(train);
		outByTruck_progressBar.setValue(truck);
		outByPlane_progressBar.setValue(plane);

		outByTrain_label.setText(train + "");
		outByShip_label.setText(truck + "");
		outByPlane_label.setText(plane + "");
	}
	private void initLabel() {
		todayNum_label = new MyLabel("今日流水（派出数量）",300,100,100,30);
		trs_label = new MyLabel("中转中心：",300,20,100,30);
		account0_label = new MyLabel("账户：",460,20,50,30);
		train_label = new MyLabel("火车",400,150,30,20);
		truck_label = new MyLabel("汽车",400,250,30,20);
		plane_label = new MyLabel("飞机",400,350,30,20);
		account_label = new MyLabel("",500,20,50,30);
		transferOfficeNum_label = new MyLabel("",370,20,100,30);
		outByTrain_label = new MyLabel("",680,150,30,20);
		outByShip_label = new MyLabel("",680,250,30,20);
		outByPlane_label =new MyLabel("",680,350,30,20);
		todayNum_label.setFont(new Font("黑体", 1, 18));
		train_label.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		truck_label.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		plane_label.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		try {
			officeNum=ctr_login.getCurrentOptorId().substring(0, 3);
			accountName=ctr_login.getCurrentName();
			account_label.setText(accountName);
			transferOfficeNum_label.setText(City.toString(CurrentCity.getCurrentCity()) +" "+ officeNum);
		} catch (RemoteException e) {
		}
		outByTrain_label.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
		outByShip_label.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
		outByPlane_label.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
	}
	
	private void toBusinessOffice_btnMouseClicked() {
		System.out.println("中转中心装车单");
		try {
			LogVO vo = new LogVO(LogType.TRANSFER_CTR_SHIP_MANAGEMENT, ctr_login.getCurrentOptorId(), CurrentTime.getDate());
			ctr_log.add(vo);
		} catch (RemoteException e1) {
		}
		new ShippingRep();
	}
	private void arrival_btnMouseClicked() {
		System.out.println("中转中心到达单");
		try {
			LogVO vo = new LogVO(LogType.TRANSFER_CTR_RECEPTION, ctr_login.getCurrentOptorId(), CurrentTime.getDate());
			ctr_log.add(vo);
		} catch (RemoteException e1) {
		}
		new  ReceptionRep();
	}
	private void toTransferCTR_btnMouseClicked() {
		System.out.println("中转单");
		new TransferRep(this);
	}
    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MyButton arrival_btn,exit_btn,
     				toBusinessOffice_btn,toTransferCTR_btn;
    private MyLabel todayNum_label,trs_label,account0_label,train_label,truck_label,plane_label,
    			   outByShip_label,transferOfficeNum_label,
    			   outByPlane_label,outByTrain_label,account_label;
    private JProgressBar outByTruck_progressBar, outByPlane_progressBar,
    		outByTrain_progressBar;
    private MyTextField feedback_text;
    private String officeNum="025",accountName;
    private LoginBLService ctr_login;
    private LogBLService ctr_log;
    private TransferRepblService ctr_trans;
    private int train=0,truck=0,plane=0;
    MyFrame frame;
    // End of variables declaration//GEN-END:variables
    
   
}
