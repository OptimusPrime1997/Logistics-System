package ui.businessOfficerui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
public class Driver_add extends JFrame {
	 public static void main(String[] args) {
			new Driver_add();
		}
	private void day_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day_comboBoxActionPerformed
	       
    }
    private void cancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_btnMouseClicked
        this.setVisible(false);
    }
    private void ok_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok_btnMouseClicked
        this.setVisible(false);
    }   
    /**
     * Creates new form driver__add
     */
    public Driver_add() {
    	this.setVisible(true);
        initComponents();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }   
    private void initComponents() {
    	panel = new JPanel();
    	GroupLayout layout1 = new GroupLayout(panel);    	
    	initLabel();
    	initTxt();
    	initbtn();
    	initComboBox();
    	initLayout(layout1);  
    }
    private void initComboBox() {
    	year_comboBox = new JComboBox<String>();
		sex_comboBox = new JComboBox<String>();
		month_comboBox = new JComboBox<String>();
		jComboBox6 = new JComboBox<String>();
		day_comboBox = new JComboBox<String>();
		year_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967",
				"1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975",
				"1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983",
				"1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991",
				"1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
				"2000" }));
		sex_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"男", "女" }));
		month_comboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		day_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		jComboBox6.setModel(new DefaultComboBoxModel<String>(new String[] {
				"年", "月", "天" }));
		day_comboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				day_comboBoxActionPerformed(evt);
			}
		});
	}
	private void initbtn() {
    	  cancel_btn = new JButton();          
          ok_btn = new JButton();
          
          ok_btn.setText("确定");
          cancel_btn.setText("取消");
          cancel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
              public void mouseClicked(java.awt.event.MouseEvent evt) {
                  cancel_btnMouseClicked(evt);
              }
          });
          
          ok_btn.addMouseListener(new java.awt.event.MouseAdapter() {
              public void mouseClicked(java.awt.event.MouseEvent evt) {
                  ok_btnMouseClicked(evt);
              }
          });
	}
	private void initTxt() {
    	driverNum_text = new JTextField();
        name_text = new JTextField();
        IDnum_text = new JTextField();
        phoneNum_text = new JTextField();        
        validTime_text = new JTextField();          
        driverNum_text.setEditable(false);
	}
	private void initLayout(GroupLayout layout1) {
		 panel.setLayout(layout1);
	        layout1.setHorizontalGroup(
	            layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, layout1.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(cancel_btn)
	                .addGap(39, 39, 39)
	                .addComponent(ok_btn)
	                .addGap(15, 15, 15))
	            .addGroup(layout1.createSequentialGroup()
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout1.createSequentialGroup()
	                        .addGap(41, 41, 41)
	                        .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                            .addGroup(GroupLayout.Alignment.LEADING, layout1.createSequentialGroup()
	                                .addComponent(jLabel0)
	                                .addGap(18, 18, 18)
	                                .addComponent(validTime_text, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                .addGroup(layout1.createSequentialGroup()
	                                    .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addComponent(jLabel1)
	                                        .addComponent(jLabel2)
	                                        .addComponent(jLabel3))
	                                    .addGap(29, 29, 29)
	                                    .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addComponent(sex_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(name_text, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(driverNum_text, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
	                                .addGroup(layout1.createSequentialGroup()
	                                    .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addComponent(jLabel7)
	                                        .addComponent(jLabel8)
	                                        .addComponent(jLabel9))
	                                    .addGap(29, 29, 29)
	                                    .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addComponent(phoneNum_text, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(IDnum_text, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
	                                        .addGroup(layout1.createSequentialGroup()
	                                            .addComponent(year_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                                            .addComponent(jLabela)
	                                            .addGap(18, 18, 18)
	                                            .addComponent(month_comboBox, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
	                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                                            .addComponent(jLabel6)
	                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                            .addComponent(day_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel5))
	                    .addGroup(layout1.createSequentialGroup()
	                        .addGap(22, 22, 22)
	                        .addComponent(jLabel4)))
	                .addContainerGap(49, Short.MAX_VALUE))
	        );
	        layout1.setVerticalGroup(
	            layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout1.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel4)
	                .addGap(15, 15, 15)
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(driverNum_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(name_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(sex_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel3))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel7)
	                    .addComponent(IDnum_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel8)
	                    .addComponent(year_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabela)
	                    .addComponent(month_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel6)
	                    .addComponent(day_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel5))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel9)
	                    .addComponent(phoneNum_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel0)
	                    .addComponent(validTime_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(cancel_btn)
	                    .addComponent(ok_btn))
	                .addGap(10, 10, 10))
	        );
	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	}
	private void initLabel() {
    	jLabel0 = new JLabel();
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
        
        jLabel0.setText("行驶证期限");
        jLabel1.setText("司机编号");
        jLabel2.setText("姓名");
        jLabel3.setText("性别");        
        jLabel4.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("司机增加");       
        jLabel5.setText("日");
        jLabel6.setText("月");
        jLabel7.setText("身份证号");
        jLabel8.setText("生日");
        jLabel9.setText("手机号");
        jLabela.setText("年");
        
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField IDnum_text,driverNum_text,name_text,
                       phoneNum_text,validTime_text;
    private JButton cancel_btn;
    private JComboBox<String> year_comboBox,month_comboBox,day_comboBox,
                              jComboBox6,sex_comboBox;
    private JLabel jLabel0,jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,
                   jLabel6,jLabel7,jLabel8,jLabel9,jLabela;
    private JPanel panel;
    private JButton ok_btn;
    // End of variables declaration//GEN-END:variables
}
