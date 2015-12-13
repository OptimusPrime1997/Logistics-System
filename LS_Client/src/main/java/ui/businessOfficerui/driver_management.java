/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.businessOfficerui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import main.MainFrame;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.loginblservice.LoginBLService;
import util.CurrentCity;
import util.enumData.City;
import util.enumData.ResultMessage;

/**
 *
 * @author Administrator
 */
public class driver_management extends JPanel {
	
	/**
     * Creates new form yytywyCar_DriverManagement
     */
    public driver_management(businessOfficer_main panel) {
    	this.panel_parent=panel;
    	ctr_login=ControllerFactoryImpl.getInstance().getLoginController();
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
		GroupLayout layout = new GroupLayout(this);
		initLabel();
		initbtn();
		initTable();
		initScroll();
		initTxt();
		initLayout(layout);        
    }
    private void initLayout(GroupLayout layout) {

        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(add_btn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BusinessOfficeNum_label)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(account_btn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(exit_btn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(search_text, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(search_btn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(back_btn, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(feedback_text)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(add_btn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(BusinessOfficeNum_label)
                            .addComponent(jLabel2)
                            .addComponent(account_btn)))
                    .addComponent(exit_btn))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(search_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_btn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                        .addComponent(back_btn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(43, 43, 43)
                .addComponent(feedback_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
	}

	private void initTxt() {
    	  feedback_text = new JTextField();
          search_text = new JTextField();
          search_text.setText("输入姓名或编号");
          feedback_text.setEditable(false);

	}

	private void initScroll() {
    	 jScrollPane2 = new JScrollPane();
         jScrollPane2.setViewportView(drivers_table);
	}

	private void initTable() {
    	drivers_table = new JTable(); 
        drivers_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"00001", "大玉儿", "13522200011", "      X"},
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
                "编号", "姓名", "手机号", "删除"
            }
        ) {
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        drivers_table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tableMouseClicked(e);
        	}
		});
        if (drivers_table.getColumnModel().getColumnCount() > 0) {
            drivers_table.getColumnModel().getColumn(3).setPreferredWidth(5);
        }
	}

	private void initbtn() {
    	add_btn = new JButton();
        search_btn = new JButton();
        account_btn = new JButton();
        exit_btn = new JButton();
		back_btn = new JButton();

		account_btn.setText("老李（包括更改密码、退出登录）");
		back_btn.setText("返回");
		add_btn.setText("+");
		exit_btn.setText("退出系统");
		search_btn.setText("搜索");
		exit_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exit_btnActionPerformed(evt);
			}
        });
        add_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_btnMouseClicked(evt);
            }
        });
        back_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		back_btnMouseClicked();
        	}
		});
	}
	private void initLabel() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        BusinessOfficeNum_label=new JLabel();

        jLabel1.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("司机管理");
        jLabel2.setText("账户：");
        jLabel3.setText("营业厅：");
        try {
			officeNum = ctr_login.getCurrentOptorId().substring(0, 6);
			System.out.println(ctr_login.getCurrentOptorId());
			city = City.toString(CurrentCity.getCurrentCity());
			BusinessOfficeNum_label.setText(city + officeNum);
		} catch (RemoteException e) {
		}
	}
	/**
	 * 监听们~
	 * @param evt
	 */
	
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
    
    
    /**
     * 对表格的监听
     * @param e
     */
	public void tableMouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		int row = drivers_table.rowAtPoint(p);
	    int	column = drivers_table.columnAtPoint(p);
	    //编号 姓名  手机号
	    String driverCode,driverName,phone;
	    //点了删除
		if(e.getClickCount()==1&&column==3){
			System.out.println("删除第"+row+"行");
		}
		if (e.getClickCount() == 2) {
			driverCode=drivers_table.getValueAt(row, 0).toString();
			driverName=drivers_table.getValueAt(row, 1).toString();
			phone=drivers_table.getValueAt(row, 2).toString();
			System.out.print("坐标 "+row+"  "+column+"   ");
			new driver_detail(this, driverCode,driverName,phone);
		}
	}

    
    private void add_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_btnMouseClicked
        new driver_add().setVisible(true);
    }

	private void back_btnMouseClicked() {
		panel_parent.remove(this);
		panel_parent.add(panel_parent.getPanel1());
		panel_parent.revalidate();
		panel_parent.repaint();
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel BusinessOfficeNum_label, jLabel1,jLabel2,jLabel3;
    private businessOfficer_main panel_parent;
    private JTable drivers_table;
    private JButton account_btn,add_btn,back_btn,exit_btn,search_btn;
    private JScrollPane jScrollPane2;
    private JTextField search_text,feedback_text;
    private LoginBLService ctr_login;
    private String officeNum="",city="";
    // End of variables declaration//GEN-END:variables
}
