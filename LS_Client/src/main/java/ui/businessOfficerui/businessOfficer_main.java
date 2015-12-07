package ui.businessOfficerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import ui.receiptui.generalUI.CashRep;
import ui.receiptui.generalUI.DeliverRep;
import ui.receiptui.generalUI.GetRep;
import ui.receiptui.generalUI.ShipmentRep;
import ui.util.MyFrame;
import util.enumData.ResultMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class businessOfficer_main extends JPanel {
	 /**
     * 初始化界面
     */
    public businessOfficer_main() {
    	initComponents();
    	
    	this.frame=new MyFrame(this);    	   	
              
    }
    /**
     * 给子界面提供的   向用户反馈信息的方法
     * @param msg
     */
    public void setFeedBack(ResultMessage msg){
    	feedback_text.setText(ResultMessage.toFriendlyString(msg));
    }
	
   
    private void initComponents() {
        initPanel();       
    	initbtn();
    	initLabel();
    	initTxt();
    	initLayout();      
    }
    private void initPanel() {
    	panel1=new JPanel();
    	panel_car=new car_management(this);
    	panel_driver=new driver_management(this);
    	 initNumPanel();
	}
	private void initNumPanel() {
    	num_panel = new JPanel();
    	
    	GroupLayout num_panelLayout = new GroupLayout(num_panel);
    	num_panel.setBackground(new java.awt.Color(240, 40, 240));
    	num_panel.setForeground(new java.awt.Color(240, 240, 240));
        // num_panel.setToolTipText("");
        /*
         *  initNumlabel
         */
    	num_label = new JLabel();
    	num_label.setFont(new java.awt.Font("宋体", 1, 48));
    	num_label.setForeground(new java.awt.Color(240, 240, 240));
    	num_label.setText("50");//TODO 数字 获取
         initNumLayout(num_panelLayout);
	}

	private void initTxt() {
		feedback_text = new JTextField();
		feedback_text.setEditable(false);
	}

	private void initLayout(){
		GroupLayout layoutPanel1 = new GroupLayout(panel1);
    	  panel1.setLayout(layoutPanel1);
          layoutPanel1.setHorizontalGroup(
              layoutPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(layoutPanel1.createSequentialGroup()
                  .addGroup(layoutPanel1.createParallelGroup(GroupLayout.Alignment.TRAILING)
                      .addGroup(GroupLayout.Alignment.LEADING, layoutPanel1.createSequentialGroup()
                          .addGroup(layoutPanel1.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                              .addComponent(arrival_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(deliver_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(recordMoney_btn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(carManagement_btn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(send_btn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(driverManagement_btn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                          .addGap(160, 160, 160)
                          .addGroup(layoutPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                              .addComponent(num_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                      .addGroup(GroupLayout.Alignment.LEADING, layoutPanel1.createSequentialGroup()
                          .addGap(220, 220, 220)
                          .addComponent(jLabel6)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(businessOfficeNum_label)
                          .addGap(26, 26, 26)
                          .addComponent(jLabel5)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(account_btn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
                  .addGap(65, 65, 65)
                  .addComponent(exit_btn))
              .addGroup(layoutPanel1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(feedback_text)
                  .addContainerGap())
          );
          layoutPanel1.setVerticalGroup(
              layoutPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(layoutPanel1.createSequentialGroup()
                  .addGroup(layoutPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(layoutPanel1.createSequentialGroup()
                          .addGroup(layoutPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                              .addGroup(layoutPanel1.createSequentialGroup()
                                  .addGroup(layoutPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                      .addComponent(exit_btn)
                                      .addGroup(layoutPanel1.createSequentialGroup()
                                          .addGap(16, 16, 16)
                                          .addGroup(layoutPanel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                              .addComponent(jLabel6)
                                              .addComponent(businessOfficeNum_label)
                                              .addComponent(jLabel5)
                                              .addComponent(account_btn))))
                                  .addGap(4, 4, 4)
                                  .addComponent(arrival_btn, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                  .addComponent(deliver_btn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                              .addGroup(layoutPanel1.createSequentialGroup()
                                  .addGap(75, 75, 75)
                                  .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(recordMoney_btn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(send_btn, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(carManagement_btn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                      .addGroup(layoutPanel1.createSequentialGroup()
                          .addGap(131, 131, 131)
                          .addComponent(num_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(driverManagement_btn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                  .addComponent(feedback_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())
          );
         this.add(panel1);
	}

	/**
     * 初始化数字panel的布局
     * @param num_panelLayout
     */
	private void initNumLayout(GroupLayout num_panelLayout) {
		 num_panel.setLayout(num_panelLayout);
	        num_panelLayout.setHorizontalGroup(
	            num_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, num_panelLayout.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(num_label)
	                .addGap(63, 63, 63))
	        );
	        num_panelLayout.setVerticalGroup(
	            num_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(num_panelLayout.createSequentialGroup()
	                .addGap(50, 50, 50)
	                .addComponent(num_label)
	                .addContainerGap(64, Short.MAX_VALUE))
	        );
		
	}

	private void initLabel() {
		jLabel1 = new JLabel();
    	jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        businessOfficeNum_label = new JLabel();
        jLabel1.setText("今日流水（派出的车辆数）");
        jLabel5.setText("账户：");
        jLabel6.setText("营业厅：");
        businessOfficeNum_label.setText("南京 025001");        
	}

	private void initbtn() {
		exit_btn = new JButton();
		account_btn = new JButton();
		arrival_btn = new JButton();
		deliver_btn = new JButton();
		carManagement_btn = new JButton();
		recordMoney_btn = new JButton();
		driverManagement_btn = new JButton();
		send_btn = new JButton();
		exit_btn.setText("退出系统");
		account_btn.setText("老李（包括更改密码、退出登录）");
		arrival_btn.setText("快件到达");
		deliver_btn.setText("派件");
		carManagement_btn.setText("车辆管理");
		recordMoney_btn.setText("记账");
		send_btn.setText("发往中转中心/营业厅");
		driverManagement_btn.setText("司机管理");
		arrival_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arrival_btnMouseClicked(e);
			}
		});
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exit_btnActionPerformed(evt);
			}
		});
		deliver_btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				deliver_btnMouseClicked(evt);
			}
		});
		carManagement_btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				carManagement_btnMouseClicked(evt);
			}
		});
		driverManagement_btn
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						driverManagement_btnMouseClicked(evt);
					}
				});
		recordMoney_btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				recordMoney_btnMouseClicked(evt);
			}
		});
		send_btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				send_btnMouseClicked(evt);
			}
		});
	}
	/**
	 * 监听们~~
	 * @param e
	 */
	private void arrival_btnMouseClicked(MouseEvent e) {
		System.out.println("到达单");		
		new MyFrame(800, 600, new GetRep());
	}	
    private void carManagement_btnMouseClicked(MouseEvent evt) {    	
    	System.out.println("车辆管理");
    	this.remove(panel1);
     	this.add(panel_car);
    	this.revalidate();
    	this.repaint();
    }
    private void driverManagement_btnMouseClicked(MouseEvent evt) {
    	System.out.println("司机管理");
    	this.remove(panel1);
     	this.add(panel_driver);
    	this.revalidate();
    	this.repaint();
    }
    private void deliver_btnMouseClicked(MouseEvent evt) {
    	System.out.println("派件单");
    	new MyFrame(800, 600, new DeliverRep());
        
    }
    private void send_btnMouseClicked(MouseEvent evt) {
    	System.out.println("营业厅装车单");
    	new MyFrame(800, 600, new ShipmentRep());
//    	this.getFrame().setContentPane(new car_management());        
    }
    private void recordMoney_btnMouseClicked(MouseEvent evt) {
    	System.out.println("收款单");
    	new MyFrame(800, 600, new CashRep());
//    	this.getFrame().setContentPane(new car_management());
        
    }
    
    private void exit_btnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
    	if (evt.getSource() == exit_btn) {
			Object[] options = { "取消", "确定" };
			int result = JOptionPane.showOptionDialog(null, "您确定要退出系统？",
					"是否退出", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (result == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}
	}
	public JPanel getPanel1() {
		return panel1;
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
//	private 
	
    private MyFrame frame;
	private car_management panel_car;
    private driver_management panel_driver;
    private JButton account_btn,arrival_btn, deliver_btn,exit_btn,
    carManagement_btn,driverManagement_btn,recordMoney_btn,send_btn;
    private JLabel jLabel1,jLabel5,jLabel6,num_label,businessOfficeNum_label;
    private JTextField feedback_text;//给用户反馈信息的信息栏
    private JPanel num_panel,panel1;//元件都放在panel1上   然后panel1放在this上
    
    // End of variables declaration//GEN-END:variables
   
}
