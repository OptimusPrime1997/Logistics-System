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
import javax.swing.WindowConstants;

/**
 *
 * @author Administrator
 */
public class car_detail extends JFrame {
	public static void main(String[] args) {
		new car_detail();
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
	
    public car_detail() {
    	this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        initComponents();
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
    	 jComboBox6 = new JComboBox<String>();
         jComboBox6.setModel(new DefaultComboBoxModel<String>(
        		 new String[] { "年", "月", "天" }));
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
                                        .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 43, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(ok_btn))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
	}
	private void initTxt() {
    	  carCodeNum_text = new JTextField();          
          carLicenseNum_text = new JTextField();
          timeText = new JTextField();
          carCodeNum_text.setText("025001001");//TODO
          carLicenseNum_text.setText("有初始值");
          timeText.setText("有初始值");
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton back_btn;
    private JTextField carCodeNum_text;
    private JTextField carLicenseNum_text;
    private JButton delete_btn;
    private JComboBox<String> jComboBox6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JButton ok_btn;
    private JTextField timeText;
    // End of variables declaration//GEN-END:variables
}
