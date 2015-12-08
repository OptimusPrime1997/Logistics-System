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

/**
 *
 * @author Administrator
 */
public class driver_detail extends JFrame {
	/**
	 * 监听
	 * @param evt
	 */
	private void IDnum_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDnum_textActionPerformed
	}
    private void validTime_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validTime_textActionPerformed
    }
    private void day_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day_comboBoxActionPerformed
    }
    private void driverNum_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverNum_textActionPerformed
    }

    private void name_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_textActionPerformed
    }
    
    /**
     * Creates new form driver_detail
     */
	public driver_detail() {
		this.setVisible(true);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initComponents();
	}

	private void initComponents() {
	  GroupLayout layout = new GroupLayout(getContentPane());
	  initLabel();
	  initComboBox();
	  initTxt();
	  initbtn();	  
	  initLayout(layout);
    }
    private void initbtn() {
    	cancel_btn = new JButton();
        ok_btn = new JButton();
        delete_btn = new JButton();
        cancel_btn.setText("取消");
        ok_btn.setText("保存");
        delete_btn.setText("X删除");
        delete_btn.setBackground(new java.awt.Color(255, 0, 0));
        delete_btn.setForeground(new java.awt.Color(255, 0, 0));
       
}
	private void initLayout(GroupLayout layout) {
    	  getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel1)
                              .addComponent(jLabel2)
                              .addComponent(jLabel3)
                              .addComponent(jLabel7)
                              .addComponent(jLabel8)
                              .addComponent(jLabel9)
                              .addComponent(jLabel5))
                          .addGap(10, 10, 10)
                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                              .addGroup(layout.createSequentialGroup()
                                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                      .addComponent(sex_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                      .addComponent(name_text, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                              .addGroup(layout.createSequentialGroup()
                                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                      .addComponent(phoneNum_text, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                      .addComponent(driverNum_text, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                      .addGroup(layout.createSequentialGroup()
                                          .addComponent(validTime_text, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                      .addGroup(layout.createSequentialGroup()
                                          .addComponent(year_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(jLabel6)
                                          .addGap(18, 18, 18)
                                          .addComponent(month_comboBox, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(jLabela)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(day_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(jLabelb))
                                      .addComponent(IDnum_text, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                  .addContainerGap(50, Short.MAX_VALUE))))
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(jLabel4)
                          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
              .addGroup(layout.createSequentialGroup()
                  .addGap(191, 191, 191)
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                      .addComponent(delete_btn)
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(cancel_btn)
                          .addGap(27, 27, 27)
                          .addComponent(ok_btn)))
                  .addGap(0, 15, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jLabel4)
                  .addGap(12, 12, 12)
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addComponent(driverNum_text, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel1, GroupLayout.Alignment.TRAILING))
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel2)
                              .addComponent(name_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel3)
                              .addComponent(sex_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                      .addGroup(layout.createSequentialGroup()
                          .addGap(11, 11, 11)
                          .addComponent(delete_btn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                  .addGap(5, 5, 5)
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel7)
                      .addComponent(IDnum_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                  .addGap(12, 12, 12)
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel8)
                      .addComponent(year_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel6)
                      .addComponent(month_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabela)
                      .addComponent(day_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabelb))
                  .addGap(10, 10, 10)
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(phoneNum_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel9))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel5)
                      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                          .addComponent(validTime_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                          .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(cancel_btn)
                      .addComponent(ok_btn))
                  .addGap(5, 5, 5))
          );

          pack();
	
}
	private void initTxt() {
		IDnum_text = new JTextField();
		phoneNum_text = new JTextField();
		validTime_text = new JTextField();
		driverNum_text = new JTextField();
		name_text = new JTextField();

		IDnum_text.setText("有初始值");
		phoneNum_text.setText("有初始值");
		validTime_text.setText("3");
		driverNum_text.setText("02500107001");
		name_text.setText("有初始值");
		
		IDnum_text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				IDnum_textActionPerformed(evt);
			}
		});
		validTime_text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				validTime_textActionPerformed(evt);
			}
		});
		driverNum_text.setEditable(false);		
		driverNum_text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				driverNum_textActionPerformed(evt);
			}
		});		
		name_text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				name_textActionPerformed(evt);
			}
		});
	
}
	private void initComboBox() {
		sex_comboBox = new JComboBox<String>();
		year_comboBox = new JComboBox<String>();
		month_comboBox = new JComboBox<String>();
        day_comboBox = new JComboBox<String>();
        jComboBox6 = new JComboBox<String>();        
		sex_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"男", "女" }));
		year_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967",
				"1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975",
				"1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983",
				"1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991",
				"1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
				"2000" }));
		month_comboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		day_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		day_comboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				day_comboBoxActionPerformed(evt);
			}
		});
		jComboBox6.setModel(new DefaultComboBoxModel<String>(new String[] {
				"年", "月", "天" }));

}
	private void initLabel() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		jLabel9 = new JLabel();
		jLabela = new JLabel();
		jLabelb = new JLabel();

		jLabel1.setText("司机编号");
		jLabel2.setText("姓名");
		jLabel3.setText("性别");
		jLabel4.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(0, 102, 255));
		jLabel4.setText("司机详细信息");
		jLabel5.setText("行驶证期限");
		jLabel6.setText("年");
		jLabel7.setText("身份证号");
		jLabel8.setText("生日");
		jLabel9.setText("手机号");
		jLabela.setText("月");
		jLabelb.setText("日");
	
}
	
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(driver_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(driver_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(driver_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(driver_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new driver_detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField IDnum_text,driverNum_text,name_text,phoneNum_text,validTime_text;
    private JButton cancel_btn;
    private JComboBox<String> day_comboBox,jComboBox6,month_comboBox,
    sex_comboBox,year_comboBox;
    private JButton delete_btn,ok_btn;
    private JLabel jLabel1,jLabel2,jLabel3,jLabel4,
    jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,jLabela,jLabelb;
    
    // End of variables declaration//GEN-END:variables
}
