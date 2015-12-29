package ui.transferCtrOfficerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.NotBoundException;
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
import ui.receiptui.generalUI.ReceptionRep;
import ui.receiptui.generalUI.ShippingRep;
import ui.receiptui.generalUI.TransferRep;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyFrame;
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
    	GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(feedback_text)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trs_label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transferOfficeNum_label)
                        .addGap(18, 18, 18)
                        .addComponent(account0_label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(account_label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(toTransferCTR_btn, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(toBusinessOffice_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(arrival_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(train_label)
                                .addGap(18, 18, 18)
                                .addComponent(outByTrain_progressBar, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(plane_label)
                                    .addComponent(truck_label, GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(outByTruck_progressBar, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(outByPlane_progressBar, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(outByTrain_label)
                            .addGap(84, 84, 84))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(exit_btn)
                            .addGap(26, 26, 26)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(outByShip_label, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(outByPlane_label))
                        .addGap(57, 57, 57))))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(todayNum_label, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(exit_btn)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(trs_label)
                            .addComponent(account_label)
                            .addComponent(account0_label)
                            .addComponent(transferOfficeNum_label))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(todayNum_label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(outByTrain_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(train_label)
                            .addComponent(outByTrain_label)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(toTransferCTR_btn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(toBusinessOffice_btn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(outByTruck_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(truck_label))
                            .addComponent(outByShip_label))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(outByPlane_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(outByPlane_label)
                            .addComponent(plane_label))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(arrival_btn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(feedback_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
	}
	private void initText() {
        feedback_text = new JTextField();
        feedback_text.setEditable(false);
        feedback_text.setHorizontalAlignment(JTextField.CENTER);
        feedback_text.setForeground(Color.magenta);
	}
	private void initbtn() {
    	exit_btn = new MyButton(ButtonType.EXIT);
        arrival_btn = new MyButton(ButtonType.ARRIVE_BIG);
        toBusinessOffice_btn = new MyButton(ButtonType.TO_YYT);
        toTransferCTR_btn = new MyButton(ButtonType.TO_TRANSFER_CTR);

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
    	 outByTrain_progressBar = new JProgressBar();
         outByTruck_progressBar = new JProgressBar();
         outByPlane_progressBar = new JProgressBar();
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
		todayNum_label = new JLabel();
		trs_label = new JLabel();
		account0_label = new JLabel();
		train_label = new JLabel();
		truck_label = new JLabel();
		plane_label = new JLabel();
		account_label = new JLabel();
		transferOfficeNum_label = new JLabel();
		outByTrain_label = new JLabel();
		outByShip_label = new JLabel();
		outByPlane_label = new JLabel();
		todayNum_label.setText("今日流水（派出数量）");
		todayNum_label.setFont(new Font("黑体", 1, 18));
		trs_label.setText("中转中心：");
		account0_label.setText("账户：");
		train_label.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		train_label.setText("火车");
		truck_label.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		truck_label.setText("汽车");
		plane_label.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		plane_label.setText("飞机");
		try {
			officeNum=ctr_login.getCurrentOptorId().substring(0, 3);
			accountName=ctr_login.getCurrentName();
			account_label.setText(accountName);
			transferOfficeNum_label.setText(City.toString(CurrentCity.getCurrentCity()) + officeNum);
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
    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
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
    private JLabel todayNum_label,trs_label,account0_label,train_label,truck_label,plane_label,
    			   outByShip_label,transferOfficeNum_label,
    			   outByPlane_label,outByTrain_label,account_label;
    private JProgressBar outByTruck_progressBar, outByPlane_progressBar,
    		outByTrain_progressBar;
    private JTextField feedback_text;
    private String officeNum="025",accountName;
    private LoginBLService ctr_login;
    private LogBLService ctr_log;
    private TransferRepblService ctr_trans;
    private int train=0,truck=0,plane=0;
    MyFrame frame;
    // End of variables declaration//GEN-END:variables
    
   
}
