/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.businessOfficerui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import ui.mainFrame.MainFrame;
import ui.util.MyFrame;

/**
 *
 * @author Administrator
 */
public class car_detail extends JFrame {
    /**
     * @param code 车辆代号
     * @param licenseNum 车牌号
     * @param time 车的  服役年限
     * @param type 服役年限的时间单位  仅限“年”，“月”，“天”
     */
	 public car_detail(String code,String licenseNum,String time,String type) {
	    	this.setVisible(true);
	        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	        this.carCode=code;
	        this.carLicence=licenseNum;
	        this.carTime=time;
	        this.carTimeType=type;
	        initComponents();
	    }
	private void carCodeNum_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_carCodeNum_textActionPerformed
	}

	private void timeTextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_timeTextActionPerformed
	}

	private void back_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_back_btnMouseClicked
		this.setVisible(false);
	}

	private void ok_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ok_btnMouseClicked
		this.setVisible(false);
	}
    private void initComponents() {
		GroupLayout layout = new GroupLayout(getContentPane());
		initLabel();
		initTxt();
		initbtn();
		initComboBox();       
        initLayout(layout);
    }
    private void initComboBox() {
    	int i=0;//给类型编号
    	switch (carTimeType) {
		case "月":i=1;
			break;
		case "天":i=2;
		    break;
		default:
			break;
		}
    	 combobox = new JComboBox<String>();
         combobox.setModel(new DefaultComboBoxModel<String>(
        		 new String[] { "年", "月", "天" }));         
         combobox.setSelectedIndex(i);
	}
	private void initbtn() {
    	 delete_btn = new JButton();
         back_btn = new JButton();
         ok_btn = new JButton();
         delete_btn.setBackground(new java.awt.Color(255, 0, 0));
         delete_btn.setForeground(new java.awt.Color(255, 0, 0));
         delete_btn.setText("X删除");
         back_btn.setText("返回");
         ok_btn.setText("保存");
         back_btn.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 back_btnMouseClicked(evt);
             }
         });
         ok_btn.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 ok_btnMouseClicked(evt);
             }
         });        
	}
	private void initLayout(GroupLayout layout) {
    	getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(carCodeNum_text, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addComponent(carLicenseNum_text, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(delete_btn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15)
                                .addComponent(timeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(back_btn)
                                        .addGap(18, 18, 18)
                                        .addComponent(ok_btn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(combobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 43, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(feedback_text)
                 .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(carCodeNum_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(carLicenseNum_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(timeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(ok_btn))
                    .addComponent(feedback_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
	}
	private void initTxt() {
    	  carCodeNum_text = new JTextField();          
          carLicenseNum_text = new JTextField();
          timeText = new JTextField();
          feedback_text=new JTextField();
          
          carCodeNum_text.setText(carCode);//TODO
          carLicenseNum_text.setText(carLicence);
          timeText.setText(carTime);
          
          feedback_text.setEditable(false);          
          carCodeNum_text.setEditable(false);
         
          carCodeNum_text.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  carCodeNum_textActionPerformed(evt);
              }
          });
          timeText.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  timeTextActionPerformed(evt);
              }
          });
	}
	private void initLabel() {
		 jLabel1 = new JLabel();
    	 jLabel2 = new JLabel();
    	 jLabel3 = new JLabel();
    	 jLabel4 = new JLabel();
    	 
    	 jLabel4.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
         jLabel4.setForeground(new java.awt.Color(0, 102, 255));
         jLabel4.setText("车辆详细信息");
         jLabel1.setText("车辆代号");
         jLabel2.setText("车牌号");
         jLabel3.setText("服役时间");
	}
	
	public void setCarLicenseNum_text(String carLicenseNum) {
		this.carLicenseNum_text.setText(carLicenseNum);
		this.carLicence=carLicenseNum;
	}
	public void setTimeText(String time) {
		this.timeText.setText(time);
		this.carTime=time;
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton back_btn,ok_btn,delete_btn;
    private JTextField carCodeNum_text,carLicenseNum_text,timeText;
    private String carCode,carLicence,carTime,carTimeType;//车辆代号，车牌号，服役时间,服役时间单位
    private JTextField feedback_text;//给用户反馈信息的信息栏
    private JComboBox<String> combobox;
    private JLabel jLabel1,jLabel2,jLabel3,jLabel4;
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
            	new car_detail("025001001","江A 8888M","5","年").setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            	
            }
        });
	}
}
