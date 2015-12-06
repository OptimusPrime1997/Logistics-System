package ui.businessOfficerui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import ui.mainFrame.MainFrame;
import ui.receiptui.CashRep;
import ui.receiptui.DeliverRep;
import ui.receiptui.GetRep;
import ui.receiptui.ReceptionRep;
import ui.receiptui.ShipmentRep;
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
    }
    /**
     * 给子界面提供的   向用户反馈信息的方法
     * @param msg
     */
    public void setFeedBack(ResultMessage msg){
    	feedBack_text.setText(ResultMessage.toFriendlyString(msg));
    }
	/**
	 * 监听们~~
	 * @param e
	 */
	private void arrival_btnMouseClicked(MouseEvent e) {
		System.out.println("到达单");
		//TODO 哪个是到达单。。。
		new MyFrame(800, 600, new GetRep());
	}	
    private void carManagement_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carManagement_btnMouseClicked
    	//TODO 跳转还不会。。
    	System.out.println("车辆管理");
//    	new Car_management().setFrame(frame);
//    	frame.remove(frame.getb);
//    	Car_management carPanel=new Car_management();
//    	frame.setContentPane(carPanel);
//    	frame.setContentPane(new Car_management());
//    	this.getFrame().setContentPane(new car_management());
    }
    private void driverManagement_btnMouseClicked(java.awt.event.MouseEvent evt) {
    	System.out.println("司机管理");
//    	this.getFrame().setContentPane(new car_management());
        
    }
    private void deliver_btnMouseClicked(java.awt.event.MouseEvent evt) {
    	System.out.println("派件单");
    	new MyFrame(800, 600, new DeliverRep());
//    	this.getFrame().setContentPane(new car_management());
        
    }
    private void send_btnMouseClicked(java.awt.event.MouseEvent evt) {
    	System.out.println("装车单");
    	new MyFrame(800, 600, new ShipmentRep());
//    	this.getFrame().setContentPane(new car_management());        
    }
    private void recordMoney_btnMouseClicked(java.awt.event.MouseEvent evt) {
    	System.out.println("收款单");
    	new MyFrame(800, 600, new CashRep());
//    	this.getFrame().setContentPane(new car_management());
        
    }
    
    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        System.exit(0);
    }
   
    public void setFrame(JFrame frame){
    	this.frame=frame;
    }
    private void initComponents() {
        GroupLayout layout = new GroupLayout(this);
        initNumPanel();
    	initbtn();
    	initLabel();
    	initTxt();
    	initLayout(layout);      
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
    	num_label.setText("50");//TODO 数字
         initNumLayout(num_panelLayout);
	}

	private void initTxt() {
		feedBack_text = new JTextField();
		feedBack_text.setEditable(false);
	}

	private void initLayout(GroupLayout layout) {
    	  this.setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                      .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                              .addComponent(arrival_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(deliver_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(recordMoney_btn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(carManagement_btn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(send_btn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(driverManagement_btn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                          .addGap(160, 160, 160)
                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                              .addComponent(num_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                      .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
              .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(feedBack_text)
                  .addContainerGap())
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                      .addComponent(exit_btn)
                                      .addGroup(layout.createSequentialGroup()
                                          .addGap(16, 16, 16)
                                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                              .addComponent(jLabel6)
                                              .addComponent(businessOfficeNum_label)
                                              .addComponent(jLabel5)
                                              .addComponent(account_btn))))
                                  .addGap(4, 4, 4)
                                  .addComponent(arrival_btn, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                  .addComponent(deliver_btn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createSequentialGroup()
                                  .addGap(75, 75, 75)
                                  .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(recordMoney_btn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(send_btn, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(carManagement_btn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                      .addGroup(layout.createSequentialGroup()
                          .addGap(131, 131, 131)
                          .addComponent(num_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(driverManagement_btn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                  .addComponent(feedBack_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())
          );
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
		// TODO 
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
         exit_btn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 exit_btnActionPerformed(evt);
             }
         });
         deliver_btn.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 deliver_btnMouseClicked(evt);
             }
         });
         carManagement_btn.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 carManagement_btnMouseClicked(evt);
             }
         });
         driverManagement_btn.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 driverManagement_btnMouseClicked(evt);
             }
         });
         recordMoney_btn.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordMoney_btnMouseClicked(evt);
             }
         });
         send_btn.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 send_btnMouseClicked(evt);
             }
         });
    }
	

    // Variables declaration - do not modify//GEN-BEGIN:variables
//	private 
	
    private JFrame frame;
    private JButton account_btn;
    private JButton arrival_btn;
    private JLabel businessOfficeNum_label;
    private JButton carManagement_btn;
    private JButton deliver_btn;
    private JButton driverManagement_btn;
    private JButton exit_btn;
    private JLabel jLabel1;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JTextField feedBack_text;//给用户反馈信息的信息栏
    private JLabel num_label;
    private JPanel num_panel;
    private JButton recordMoney_btn;
    private JButton send_btn;
    // End of variables declaration//GEN-END:variables
   

	/**
     * for test~~
     * @param args
     */
    public static void main(String[] args) {
    	/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	businessOfficer_main panel=new businessOfficer_main();
            	MyFrame frame = new MyFrame(830,590,panel);
            	panel.setFrame(frame);
        		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
            }
        });

	}
}
