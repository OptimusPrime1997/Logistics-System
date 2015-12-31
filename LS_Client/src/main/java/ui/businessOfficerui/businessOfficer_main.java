package ui.businessOfficerui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import main.MainFrame;
import ui.Img;
import ui.componentfactory.ComponentFactory;
import ui.receiptui.generalUI.CashRep;
import ui.receiptui.generalUI.DeliverRep;
import ui.receiptui.generalUI.GetRep;
import ui.receiptui.generalUI.ShipmentRep;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyFrame;
import util.CurrentCity;
import util.CurrentTime;
import util.enumData.City;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import VO.LogVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.logblservice.LogBLService;
import blservice.loginblservice.LoginBLService;
import blservice.receiptblservice.ShipmentRepblServce;

public class businessOfficer_main extends JPanel {
	public static void main(String[] args) {
		new businessOfficer_main();
	}
	/**
	 * 初始化界面
	 */
	public businessOfficer_main() {
		ComponentFactory.setSystemLook();
		ctr_login = ControllerFactoryImpl.getInstance().getLoginController();
		ctr_ship = ControllerFactoryImpl.getInstance().getShipmentRepblServce();
		initComponents();
		this.frame = new MyFrame(this);

	}

	/**
	 * 给子界面提供的 向用户反馈信息的方法
	 * 
	 * @param msg
	 */
	public void setFeedBack(ResultMessage msg) {
		feedback_text.setText(ResultMessage.toFriendlyString(msg));
	}

	
	private void initComponents() {
		try {
			officeNum = ctr_login.getCurrentOptorId().substring(0, 6);
			city = City.toString(CurrentCity.getCurrentCity());
			name=ctr_login.getCurrentName();
		} catch (RemoteException e) {
		}
		initPanel();
		initbtn();
		initLabel();
		initTxt();
		initLayout();

	}

	private void initPanel() {
		panel1 = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(Img.getBackground_business(), 0, 0, null);
			}
		};
		initNumPanel();
	}

	private void initNumPanel() {
		num_panel = new JPanel();

		GroupLayout num_panelLayout = new GroupLayout(num_panel);
		num_panel.setBackground(new java.awt.Color(0,0,0,0));
		// num_panel.setToolTipText("");
		/*
		 * initNumlabel
		 */
		num_label = new JLabel();
		num_label.setFont(new java.awt.Font("宋体", 1, 48));
		num_label.setForeground(new java.awt.Color(240, 240, 240));
		refreshValue();
		initNumLayout(num_panelLayout);
	}

	/**
	 * 刷新营业厅发货的数量
	 */
	public void refreshValue() {
		// TODO 数字 获取
		try {
			System.out.println("数量  "
					+ ctr_ship.getTruckSum(CurrentTime.getDate() + "",
							officeNum));
			num_label.setText(ctr_ship.getTruckSum(CurrentTime.getDate() + "",
					officeNum));
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
		}
	}

	private void initTxt() {
		feedback_text = new JTextField();
		feedback_text.setForeground(Color.magenta);
		feedback_text.setEditable(false);
	}

	private void initLayout() {
		GroupLayout layoutPanel1 = new GroupLayout(panel1);
		panel1.setLayout(layoutPanel1);
		layoutPanel1
				.setHorizontalGroup(layoutPanel1
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layoutPanel1
										.createSequentialGroup()
										.addGroup(
												layoutPanel1
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																GroupLayout.Alignment.LEADING,
																layoutPanel1
																		.createSequentialGroup()
																		.addGroup(
																				layoutPanel1
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								arrival_btn,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								deliver_btn,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								recordMoney_btn,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								carManagement_btn,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								send_btn,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								driverManagement_btn,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(160,
																				160,
																				160)
																		.addGroup(
																				layoutPanel1
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								num_panel,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel1,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)))
														.addGroup(
																GroupLayout.Alignment.LEADING,
																layoutPanel1
																		.createSequentialGroup()
																		.addGap(220,
																				220,
																				220)
																		.addComponent(
																				jLabel6)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				businessOfficeNum_label)
																		.addGap(26,
																				26,
																				26)
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				account_label,
																				GroupLayout.PREFERRED_SIZE,
																				82,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(65, 65, 65)
										.addComponent(exit_btn))
						.addGroup(
								layoutPanel1.createSequentialGroup()
										.addContainerGap()
										.addComponent(feedback_text)
										.addContainerGap()));
		layoutPanel1
				.setVerticalGroup(layoutPanel1
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layoutPanel1
										.createSequentialGroup()
										.addGroup(
												layoutPanel1
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																layoutPanel1
																		.createSequentialGroup()
																		.addGroup(
																				layoutPanel1
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layoutPanel1
																										.createSequentialGroup()
																										.addGroup(
																												layoutPanel1
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																exit_btn)
																														.addGroup(
																																layoutPanel1
																																		.createSequentialGroup()
																																		.addGap(16,
																																				16,
																																				16)
																																		.addGroup(
																																				layoutPanel1
																																						.createParallelGroup(
																																								GroupLayout.Alignment.BASELINE)
																																						.addComponent(
																																								jLabel6)
																																						.addComponent(
																																								businessOfficeNum_label)
																																						.addComponent(
																																								jLabel5)
																																						.addComponent(
																																								account_label))))
																										.addGap(4,
																												4,
																												4)
																										.addComponent(
																												arrival_btn,
																												GroupLayout.PREFERRED_SIZE,
																												45,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												deliver_btn,
																												GroupLayout.PREFERRED_SIZE,
																												52,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								layoutPanel1
																										.createSequentialGroup()
																										.addGap(75,
																												75,
																												75)
																										.addComponent(
																												jLabel1,
																												GroupLayout.PREFERRED_SIZE,
																												25,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				recordMoney_btn,
																				GroupLayout.PREFERRED_SIZE,
																				50,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				send_btn,
																				GroupLayout.PREFERRED_SIZE,
																				56,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				carManagement_btn,
																				GroupLayout.PREFERRED_SIZE,
																				48,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layoutPanel1
																		.createSequentialGroup()
																		.addGap(131,
																				131,
																				131)
																		.addComponent(
																				num_panel,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(driverManagement_btn,
												GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED,
												50, Short.MAX_VALUE)
										.addComponent(feedback_text,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED,
												50, Short.MAX_VALUE)));
		this.add(panel1);
	}

	/**
	 * 初始化数字panel的布局
	 * 
	 * @param num_panelLayout
	 */
	private void initNumLayout(GroupLayout num_panelLayout) {
		num_panel.setLayout(num_panelLayout);
		num_panelLayout.setHorizontalGroup(num_panelLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				num_panelLayout
						.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(num_label)
						.addGap(63, 63, 63)));
		num_panelLayout.setVerticalGroup(num_panelLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				num_panelLayout.createSequentialGroup().addGap(50, 50, 50)
						.addComponent(num_label)
						.addContainerGap(64, Short.MAX_VALUE)));

	}

	private void initLabel() {
		jLabel1 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		account_label=new JLabel();
		account_label.setText(name);
		businessOfficeNum_label = new JLabel();
		businessOfficeNum_label.setText(city + officeNum);
		jLabel1.setText("今日流水（派出的车辆数）");
		jLabel5.setText("账户：");
		jLabel6.setText("营业厅：");
		refreshValue();
	}

	private void initbtn() {
		exit_btn = new MyButton(ButtonType.EXIT);
		arrival_btn = new MyButton(ButtonType.ARRIVE);
		deliver_btn = new MyButton(ButtonType.DELIVER);
		carManagement_btn = new MyButton(ButtonType.CAR_MANAGEMENT);
		recordMoney_btn = new MyButton(ButtonType.MONEY_IN_RECORD);
		driverManagement_btn = new MyButton(ButtonType.DRIVER_MANAGEMENT);
		send_btn = new MyButton(ButtonType.TO_TRS_CTR_OR_YYT);
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
		driverManagement_btn.addMouseListener(new MouseAdapter() {
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
	 * 
	 * @param e
	 */
	private void arrival_btnMouseClicked(MouseEvent e) {
		new GetRep();
	}

	private void carManagement_btnMouseClicked(MouseEvent evt) {
		new car_management();
		this.frame.dispose();
	}

	private void driverManagement_btnMouseClicked(MouseEvent evt) {
		new driver_management();
		this.frame.dispose();
	}

	private void deliver_btnMouseClicked(MouseEvent evt) {
		new DeliverRep();
	}

	private void send_btnMouseClicked(MouseEvent evt) {

		new ShipmentRep(this);
	}

	private void recordMoney_btnMouseClicked(MouseEvent evt) {
		new CashRep();

	}

	private void exit_btnActionPerformed(ActionEvent evt) {// GEN-FIRST:event_exit_btnActionPerformed
		if (evt.getSource() == exit_btn) {
			Object[] options = { "取消", "确定" };
			int result = JOptionPane.showOptionDialog(null, "您确定要退出系统？",
					"是否退出", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (result == JOptionPane.NO_OPTION) {
				frame.dispose();
				new MainFrame();
			}
		}
	}

	public JPanel getPanel1() {
		return panel1;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	// private

	private MyFrame frame;
	private MyButton arrival_btn, deliver_btn, exit_btn,
			carManagement_btn, driverManagement_btn, recordMoney_btn, send_btn;
	private JLabel jLabel1, jLabel5, jLabel6, num_label,
			businessOfficeNum_label,account_label;
	private JTextField feedback_text;// 给用户反馈信息的信息栏
	private JPanel num_panel, panel1;// 元件都放在panel1上 然后panel1放在this上
	private String officeNum = "", city,name="";
	private ShipmentRepblServce ctr_ship;
	private LoginBLService ctr_login;

	// End of variables declaration//GEN-END:variables

}
