/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.businessOfficerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import VO.ManagementVO.DriverVO;
import ui.componentfactory.ComponentFactory;
import util.enumData.ResultMessage;
import util.enumData.Sex;

/**
 *
 * @author Administrator
 */
public class driver_detail extends JFrame {
	/**
	 * 监听
	 * 
	 * @param evt
	 */
	private void IDnum_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_IDnum_textActionPerformed
	}

	private void validTime_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_validTime_textActionPerformed
	}

	private void day_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_day_comboBoxActionPerformed
	}

	private void driverNum_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_driverNum_textActionPerformed
	}

	private void name_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_name_textActionPerformed
	}

	private void ok_btnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private void cancel_btnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

	/**
	 * @param n
	 * @return
	 */
	private DriverVO getViewdriverVO(int n) {
		// TODO Auto-generated method stub
		String driverNum = null;
		String name = null;
		Sex sex = null;
		String id = null;
		String phoneNum = null;
		String licensedTime = null;
		try {
			driverNum = driverNum_text.getText();
			name = (String) name_text.getText();
			sex = (Sex) sex_comboBox.getSelectedItem();
			id = (String) IDnum_text.getText();
			phoneNum = phoneNum_text.getText();
			licensedTime = year_comboBox.getSelectedItem() + ""
					+ month_comboBox.getSelectedItem() + ""
					+ day_comboBox.getSelectedItem();
			assert (name != null && driverNum != null && id != null) : ("您输入的机构信息不完整！");
		} catch (ClassCastException e) {
			e.printStackTrace();
			ComponentFactory.setState("您输入的值类型不正确：(",
					ComponentFactory.DISPLAY_TIME, parent.feedback_text);
		} catch (AssertionError e) {
			ComponentFactory.setState("您输入的机构信息不完整！",
					ComponentFactory.DISPLAY_TIME, parent.feedback_text);
			System.out.println(e.getMessage());
		}
		return new DriverVO(driverNum, name, sex,id,phoneNum,licensedTime);
	}

	/**
	 * Creates new form driver_detail
	 */
	public driver_detail(driver_management panel, int selected) {
		this.parent = panel;
		this.selectedN = selected;
		this.driverVOs = parent.conveyDriverVOs();
		this.driverVO = driverVOs.get(selected);
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
		setData();
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

		ok_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ok_btnActionPerformed(e);
			}

		});
		cancel_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cancel_btnActionPerformed(e);
			}

		});
	}

	private void initLayout(GroupLayout layout) {
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jLabel7)
																				.addComponent(
																						jLabel8)
																				.addComponent(
																						jLabel9)
																				.addComponent(
																						jLabel5))
																.addGap(10, 10,
																		10)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING,
																				false)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																												.addComponent(
																														sex_comboBox,
																														GroupLayout.PREFERRED_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														name_text,
																														GroupLayout.PREFERRED_SIZE,
																														112,
																														GroupLayout.PREFERRED_SIZE))
																								.addContainerGap(
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																												.addComponent(
																														phoneNum_text,
																														GroupLayout.PREFERRED_SIZE,
																														100,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														driverNum_text,
																														GroupLayout.PREFERRED_SIZE,
																														112,
																														GroupLayout.PREFERRED_SIZE)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		birthday_text,
																																		GroupLayout.PREFERRED_SIZE,
																																		33,
																																		GroupLayout.PREFERRED_SIZE)
																																.addPreferredGap(
																																		LayoutStyle.ComponentPlacement.UNRELATED))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		year_comboBox,
																																		GroupLayout.PREFERRED_SIZE,
																																		GroupLayout.DEFAULT_SIZE,
																																		GroupLayout.PREFERRED_SIZE)
																																.addPreferredGap(
																																		LayoutStyle.ComponentPlacement.UNRELATED)
																																.addComponent(
																																		jLabel6)
																																.addGap(18,
																																		18,
																																		18)
																																.addComponent(
																																		month_comboBox,
																																		GroupLayout.PREFERRED_SIZE,
																																		38,
																																		GroupLayout.PREFERRED_SIZE)
																																.addPreferredGap(
																																		LayoutStyle.ComponentPlacement.UNRELATED)
																																.addComponent(
																																		jLabela)
																																.addPreferredGap(
																																		LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(
																																		day_comboBox,
																																		GroupLayout.PREFERRED_SIZE,
																																		GroupLayout.DEFAULT_SIZE,
																																		GroupLayout.PREFERRED_SIZE)
																																.addPreferredGap(
																																		LayoutStyle.ComponentPlacement.UNRELATED)
																																.addComponent(
																																		jLabelb))
																												.addComponent(
																														IDnum_text,
																														GroupLayout.PREFERRED_SIZE,
																														170,
																														GroupLayout.PREFERRED_SIZE))
																								.addContainerGap(
																										50,
																										Short.MAX_VALUE))))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel4)
																.addContainerGap(
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(191, 191, 191)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addComponent(delete_btn)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		cancel_btn)
																.addGap(27, 27,
																		27)
																.addComponent(
																		ok_btn)))
								.addGap(0, 15, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel4)
								.addGap(12, 12, 12)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(
														driverNum_text,
														GroupLayout.Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel1,
														GroupLayout.Alignment.TRAILING))
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						name_text,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						sex_comboBox,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(11, 11,
																		11)
																.addComponent(
																		delete_btn,
																		GroupLayout.PREFERRED_SIZE,
																		60,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(5, 5, 5)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(
														IDnum_text,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(12, 12, 12)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel8)
												.addComponent(
														year_comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel6)
												.addComponent(
														month_comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabela)
												.addComponent(
														day_comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelb))
								.addGap(10, 10, 10)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														phoneNum_text,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel9))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(jLabel5)
												.addGroup(
														layout.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
																.addComponent(
																		birthday_text,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(cancel_btn)
												.addComponent(ok_btn))
								.addGap(5, 5, 5)));

		pack();

	}

	private void initTxt() {
		IDnum_text = new JTextField();
		phoneNum_text = new JTextField();
		birthday_text = new JTextField();

		birthday_text.setVisible(false);

		driverNum_text = new JTextField();
		name_text = new JTextField();

		driverNum_text.setEditable(false);
		IDnum_text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				IDnum_textActionPerformed(evt);
			}
		});
		birthday_text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				validTime_textActionPerformed(evt);
			}
		});
		name_text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				name_textActionPerformed(evt);
			}
		});

	}

	private void setData() {
		driverNum_text.setText(driverCode);
		sex_comboBox.setSelectedItem(driverVO.sex);
		name_text.setText(driverVO.name);
		IDnum_text.setText(driverVO.id);
		birthday_text.setText(driverVO.id.substring(6, 14));
		phoneNum_text.setText(driverVO.phoneNum);
		String licensedTime = driverVO.licensedTime;
		int y = Integer.parseInt(licensedTime.substring(0, 4));
		int m = Integer.parseInt(licensedTime.substring(4, 6));
		int d = Integer.parseInt(licensedTime.substring(6, 8));
		year_comboBox.setSelectedItem(y);
		month_comboBox.setSelectedItem(m);
		day_comboBox.setSelectedItem(d);
	}

	private void initComboBox() {
		sex_comboBox = ComponentFactory.getSexJComboBox();
		year_comboBox = ComponentFactory.getYearJComboBox(1960, 2000);
		month_comboBox = ComponentFactory.getMonthJComboBox();
		day_comboBox = ComponentFactory.getDayJComboBox();
		day_comboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				day_comboBoxActionPerformed(evt);
			}
		});
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
		jLabel5.setText("生日");

		jLabel5.setVisible(false);

		jLabel6.setText("年");
		jLabel7.setText("身份证号");
		jLabel8.setText("行驶证期限");
		jLabel9.setText("手机号");
		jLabela.setText("月");
		jLabelb.setText("日");

	}

	private DriverVO driverVO = null;
	private int selectedN = 0;
	private ArrayList<DriverVO> driverVOs = null;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JTextField IDnum_text, driverNum_text, name_text, phoneNum_text,
			birthday_text;
	private JButton cancel_btn;
	private JComboBox<Integer> year_comboBox, month_comboBox, day_comboBox;
	private JComboBox<Sex> sex_comboBox;
	private JButton delete_btn, ok_btn;
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6,
			jLabel7, jLabel8, jLabel9, jLabela, jLabelb;
	private driver_management parent;
	private String driverCode, driverName, phone, IDnum;
	// End of variables declaration//GEN-END:variables
}
