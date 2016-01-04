package ui.businessOfficerui;

import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import ui.componentfactory.ComponentFactory;
import ui.util.MyFrame;
import util.InputCheck;
import util.enumData.ResultMessage;
import util.enumData.Sex;
import VO.ManagementVO.DriverVO;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;

public class driver_add extends JFrame {
	// public static void main(String[] args) {
	// new driver_add();
	// }

	/**
	 * Creates new form driver__add
	 */
	public driver_add(driver_management panel) {
		MyFrame.changeLook();
		parent = panel;
		this.driverblController = parent.getDriverblController();
		this.setVisible(true);
		initComponents();
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	private void day_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_day_comboBoxActionPerformed

	}

	private void cancel_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cancel_btnMouseClicked
		this.dispose();
	}

	private void ok_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ok_btnMouseClicked
		// GEN-FIRST:event_ok_btnMouseClicked
		String driverNum = parent.getOfficeNum() + "07"+"000";
		String name = name_text.getText();
		Sex sex = (Sex) sex_comboBox.getSelectedItem();
		String id = IDnum_text.getText();
		String phoneNum = phoneNum_text.getText();
		System.out.println("phoneNum_text is "+phoneNum);
		String licensedTime = id.substring(6, 14);
		ResultMessage[] rmsg = new ResultMessage[5];
		rmsg[0] = InputCheck.checkInputNum(driverNum, 11);
		rmsg[1] = InputCheck.checkInputName(name);
		rmsg[2] = InputCheck.checkInputNum(id, 18);
		rmsg[3] = InputCheck.checkInputPhoneNum(phoneNum);
		System.out.println(rmsg[3]);
		rmsg[4] = InputCheck.checkInputDate(licensedTime);
		if (rmsg[0] == ResultMessage.VALID && rmsg[1] == ResultMessage.VALID
				&& rmsg[2] == ResultMessage.VALID
				&& rmsg[3] == ResultMessage.VALID
				&& rmsg[4] == ResultMessage.VALID) {
			DriverVO v = new DriverVO(driverNum, name, sex, id, phoneNum,
					id.substring(6, 14),0);
			try {
				ResultMessage r = driverblController.insertDriver(v);
				ResultMessage.postCheck(ResultMessage.SUCCESS, r);
				if (r == ResultMessage.SUCCESS) {
					parent.initTable();
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("远程连接失败");
			}
		} else {
			String temp = ResultMessage.toFriendlyString(rmsg[0]) + ";"
					+ ResultMessage.toFriendlyString(rmsg[1]) + ";"
					+ ResultMessage.toFriendlyString(rmsg[2]) + ";"
					+ ResultMessage.toFriendlyString(rmsg[3]) + ";"
					+ ResultMessage.toFriendlyString(rmsg[4]) + ";";
			System.out.println(temp);
			ComponentFactory.setState(temp, ComponentFactory.DISPLAY_TIME,
					parent.feedback_text);
		}
		this.dispose();
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
		birthday_text = new JTextField();
		birthday_text.setVisible(false);
		driverNum_text.setEditable(false);
	}

	private void initLayout(GroupLayout layout1) {
		panel.setLayout(layout1);
		layout1.setHorizontalGroup(layout1
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout1.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(cancel_btn).addGap(39, 39, 39)
								.addComponent(ok_btn).addGap(15, 15, 15))
				.addGroup(
						layout1.createSequentialGroup()
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout1.createSequentialGroup()
																.addGap(41, 41,
																		41)
																.addGroup(
																		layout1.createParallelGroup(
																				GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						GroupLayout.Alignment.LEADING,
																						layout1.createSequentialGroup()
																								.addComponent(
																										jLabel0)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										birthday_text,
																										GroupLayout.PREFERRED_SIZE,
																										33,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.UNRELATED))
																				.addGroup(
																						layout1.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																								.addGroup(
																										layout1.createSequentialGroup()
																												.addGroup(
																														layout1.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																																.addComponent(
																																		jLabel1)
																																.addComponent(
																																		jLabel2)
																																.addComponent(
																																		jLabel3))
																												.addGap(29,
																														29,
																														29)
																												.addGroup(
																														layout1.createParallelGroup(
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
																																		GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		driverNum_text,
																																		GroupLayout.PREFERRED_SIZE,
																																		112,
																																		GroupLayout.PREFERRED_SIZE)))
																								.addGroup(
																										layout1.createSequentialGroup()
																												.addGroup(
																														layout1.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																																.addComponent(
																																		jLabel7)
																																.addComponent(
																																		jLabel8)
																																.addComponent(
																																		jLabel9))
																												.addGap(29,
																														29,
																														29)
																												.addGroup(
																														layout1.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																																.addComponent(
																																		phoneNum_text,
																																		GroupLayout.PREFERRED_SIZE,
																																		100,
																																		GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		IDnum_text,
																																		GroupLayout.PREFERRED_SIZE,
																																		170,
																																		GroupLayout.PREFERRED_SIZE)
																																.addGroup(
																																		layout1.createSequentialGroup()
																																				.addComponent(
																																						year_comboBox,
																																						GroupLayout.PREFERRED_SIZE,
																																						GroupLayout.DEFAULT_SIZE,
																																						GroupLayout.PREFERRED_SIZE)
																																				.addPreferredGap(
																																						LayoutStyle.ComponentPlacement.UNRELATED)
																																				.addComponent(
																																						jLabela)
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
																																						jLabel6)
																																				.addPreferredGap(
																																						LayoutStyle.ComponentPlacement.RELATED)
																																				.addComponent(
																																						day_comboBox,
																																						GroupLayout.PREFERRED_SIZE,
																																						GroupLayout.DEFAULT_SIZE,
																																						GroupLayout.PREFERRED_SIZE))))))
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jLabel5))
												.addGroup(
														layout1.createSequentialGroup()
																.addGap(22, 22,
																		22)
																.addComponent(
																		jLabel4)))
								.addContainerGap(49, Short.MAX_VALUE)));
		layout1.setVerticalGroup(layout1
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout1.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel4)
								.addGap(15, 15, 15)
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														driverNum_text,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														name_text,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														sex_comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(
														IDnum_text,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel8)
												.addComponent(
														year_comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabela)
												.addComponent(
														month_comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel6)
												.addComponent(
														day_comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel9)
												.addComponent(
														phoneNum_text,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel0)
												.addComponent(
														birthday_text,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(cancel_btn)
												.addComponent(ok_btn))
								.addGap(10, 10, 10)));
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE));

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

		jLabel0.setText("生日");
		jLabel0.setVisible(false);
		jLabel1.setText("司机编号");
		jLabel2.setText("姓名");
		jLabel3.setText("性别");
		jLabel4.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(0, 102, 255));
		jLabel4.setText("司机增加");
		jLabel5.setText("日");
		jLabel6.setText("月");
		jLabel7.setText("身份证号");
		jLabel8.setText("行驶证期限");
		jLabel9.setText("手机号");
		jLabela.setText("年");

	}

	private DriverBLService driverblController;
	private driver_management parent;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JTextField IDnum_text, driverNum_text, name_text, phoneNum_text,
			birthday_text;
	private JButton cancel_btn;
	private JComboBox<Integer> year_comboBox, month_comboBox, day_comboBox;
	private JComboBox<Sex> sex_comboBox;
	private JLabel jLabel0, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5,
			jLabel6, jLabel7, jLabel8, jLabel9, jLabela;
	private JPanel panel;
	private JButton ok_btn;
	// End of variables declaration//GEN-END:variables
}
