package ui.transferCtrOfficerui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import main.MainFrame;
import ui.receiptui.generalUI.GetRep;
import ui.receiptui.generalUI.ShippingRep;
import ui.receiptui.generalUI.TransferRep;
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
import blservice.receiptblservice.ReceiptblService;
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
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transferOfficeNum_label)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(account_btn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(outByTrain_progressBar, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(outByShip_progressBar, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(exit_btn)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(account_btn)
                            .addComponent(jLabel3)
                            .addComponent(transferOfficeNum_label))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(outByTrain_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
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
                                .addComponent(outByShip_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(outByShip_label))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(outByPlane_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(outByPlane_label)
                            .addComponent(jLabel6))))
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
	}
	private void initbtn() {
    	exit_btn = new JButton(); 
        account_btn = new JButton();
        arrival_btn = new JButton();
        toBusinessOffice_btn = new JButton();
        toTransferCTR_btn = new JButton();

		exit_btn.setText("退出系统");
		arrival_btn.setText("货物到达");
		toBusinessOffice_btn.setText("发往营业厅");
		account_btn.setText("老张（包括更改密码、退出登录）");
		toTransferCTR_btn.setText("发往中转中心");
		
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
         outByShip_progressBar = new JProgressBar();
         outByPlane_progressBar = new JProgressBar();
//         ArrayList<TransferRepVO> vos=ctr_trans.getByTransNum(officeNum, CurrentTime.getDate());         
//         for(TransferRepVO vo:vos){
//        	 if(vo.form==ShipForm.TRAIN) train++;
//        	 if(vo.form==ShipForm.SHIP) ship++;
//        	 if(vo.form==ShipForm.PLANE) plane++;
//         }
         outByTrain_progressBar.setValue(train);
         outByShip_progressBar.setValue(ship); 
         outByPlane_progressBar.setValue(plane);
	}
	private void initLabel() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		transferOfficeNum_label = new JLabel();
		outByTrain_label = new JLabel();
		outByShip_label = new JLabel();
		outByPlane_label = new JLabel();
		jLabel1.setText("今日流水（派出数量）");
		jLabel2.setText("中转中心：");
		jLabel3.setText("账户：");
		jLabel4.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel4.setText("火车");
		jLabel5.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel5.setText("轮船");
		jLabel6.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel6.setText("飞机");
		try {
			officeNum=ctr_login.getCurrentOptorId().substring(0, 3);
			transferOfficeNum_label.setText(City.toString(CurrentCity.getCurrentCity())
					+ officeNum);
		} catch (RemoteException e) {
		}
		outByTrain_label.setText(train+"");
		outByShip_label.setText(ship+"");
		outByPlane_label.setText(plane+"");
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
		new  GetRep();
	}
	private void toTransferCTR_btnMouseClicked() {
		System.out.println("中转单");
		new TransferRep();
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
    private JButton account_btn;
    private JButton arrival_btn;
    private JButton exit_btn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel outByShip_label;
    private JProgressBar outByShip_progressBar;
    private JLabel outByPlane_label;
    private JProgressBar outByPlane_progressBar;
    private JLabel outByTrain_label;
    private JProgressBar outByTrain_progressBar;
    private JTextField feedback_text;
    private JButton toBusinessOffice_btn;
    private JButton toTransferCTR_btn;
    private JLabel transferOfficeNum_label;
    private String officeNum="025";
    private LoginBLService ctr_login;
    private LogBLService ctr_log;
    private TransferRepblService ctr_trans;
    private int train=0,ship=0,plane=0;
    MyFrame frame;
    // End of variables declaration//GEN-END:variables
    
   
}
