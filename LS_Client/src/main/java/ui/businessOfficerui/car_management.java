/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.businessOfficerui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import ui.mainFrame.MainFrame;
import ui.util.MyFrame;
import util.enumData.ResultMessage;

/**
 *
 * @author Administrator
 */
public class car_management extends javax.swing.JPanel {
	 
    public car_management(businessOfficer_main panel_parent) {
    	this.panel_parent=panel_parent;
        initComponents();
    }
    /**
     * 给子界面提供的   向用户反馈信息的方法
     * @param msg
     */
    public void setFeedBack(ResultMessage msg){
    	feedback_text.setText(ResultMessage.toFriendlyString(msg));
    }
    private void initComponents() {
		GroupLayout layout = new javax.swing.GroupLayout(this);
		initLabel();
		initTable();
		initbtn();
		initTxt();
		initlayout(layout);		
    }
    private void initlayout(GroupLayout layout) {
    	 this.setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(add_btn)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(jLabel6)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(businessOffNum2_label)
                 .addGap(26, 26, 26)
                 .addComponent(jLabel5)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(account_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(52, 52, 52)
                 .addComponent(exit_btn))
             .addGroup(layout.createSequentialGroup()
                 .addGap(23, 23, 23)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addGap(66, 66, 66)
                         .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addGroup(layout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                         .addComponent(search_text, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(36, 36, 36)
                         .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(38, 38, 38))))
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(feedback_text)
                 .addContainerGap())
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(exit_btn)
                     .addGroup(layout.createSequentialGroup()
                         .addContainerGap()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(jLabel6)
                                 .addComponent(businessOffNum2_label)
                                 .addComponent(jLabel5)
                                 .addComponent(account_btn))
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(jLabel4)
                                 .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                         .addGap(21, 21, 21))
                     .addGroup(layout.createSequentialGroup()
                         .addGap(40, 40, 40)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(search_text, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                         .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(58, 58, 58)))
                 .addComponent(feedback_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(12, 12, 12))
         );
		
	}

	private void initTxt() {
		search_text = new javax.swing.JTextField();
		feedback_text = new javax.swing.JTextField();
		search_text.setText("输入车牌号或编号");
		search_text.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			search_textMouseClicked(e);//TODO
		}

		
		});
		feedback_text.setEditable(false);
		
	}

	private void initbtn() {
    	  add_btn = new javax.swing.JButton();
    	  search_btn = new javax.swing.JButton();
    	  back_btn = new javax.swing.JButton();
          account_btn = new javax.swing.JButton();
          exit_btn = new javax.swing.JButton();
          search_btn.setText("搜索");
          back_btn.setText("返回");
          account_btn.setText("老李（包括更改密码、退出登录）");
          exit_btn.setText("退出系统");
          add_btn.setText("+");
          add_btn.addMouseListener(new java.awt.event.MouseAdapter() {
              public void mouseClicked(java.awt.event.MouseEvent evt) {
                  add_btnMouseClicked(evt);
              }
          });
          add_btn.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  add_btnActionPerformed(evt);
              }
          });
          
          exit_btn.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  exit_btnActionPerformed(evt);
              }
          });
          back_btn.addMouseListener(new MouseAdapter() {
        	  @Override
        	public void mouseClicked(MouseEvent e) {
        		back_btnMouseClicked();
        	}
		});
	}

	/**
	 * 监听们
	 * @param evt
	 */
	private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
    
	}
	private void search_textMouseClicked(MouseEvent e) {
		search_textMouseClicked(e);
	}	
    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
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
    private void add_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_btnMouseClicked
        new car_add();
    }
    
    private void back_btnMouseClicked() {
		panel_parent.remove(this);
		panel_parent.add(panel_parent.getPanel1());
		panel_parent.revalidate();
		panel_parent.repaint();
		
		
	}
    private void cars_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cars_tableMouseClicked
        if(evt.getClickCount()==2){
        	//TODO 怎么实现只监听一行
        	System.out.println("双击哦~");
        }
    }

	private void initTable() {
    	cars_table = new javax.swing.JTable();
    	jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(cars_table);
        cars_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "编号", "车牌号", "是否在此营业厅", "删除"
            }
        ) {	private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            @SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cars_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cars_tableMouseClicked(evt);
            }
        });
        if (cars_table.getColumnModel().getColumnCount() > 0) {
            cars_table.getColumnModel().getColumn(3).setResizable(false);
            cars_table.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

	}

	private void initLabel() {
    	jLabel4 = new javax.swing.JLabel();
    	jLabel5 = new javax.swing.JLabel();
    	jLabel6 = new javax.swing.JLabel();
        businessOffNum2_label = new javax.swing.JLabel();
        
		jLabel4.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(0, 102, 255));
		jLabel4.setText("车辆管理");
		jLabel5.setText("账户：");
		jLabel6.setText("营业厅：");
		businessOffNum2_label.setText("南京 025001");
    	
		
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
    private businessOfficer_main panel_parent;
    private javax.swing.JButton account_btn,add_btn,back_btn,exit_btn,search_btn;
    private javax.swing.JLabel businessOffNum2_label,jLabel4,jLabel5,jLabel6;
    private javax.swing.JTable cars_table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField feedback_text,search_text;
    
    private static final long serialVersionUID = 1L;//TODO  这是干啥的呀
    // End of variables declaration//GEN-END:variables
    
//    
}
