/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.businessOfficerui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import ui.Img;
import ui.componentfactory.ComponentFactory;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyFrame;
import util.CurrentCity;
import util.InputCheck;
import util.enumData.City;
import util.enumData.ResultMessage;
import VO.ManagementVO.DriverVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.controllerfactoryblservice.ControllerFactoryblService;
import blservice.loginblservice.LoginBLService;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;

/**
 *
 * @author Administrator
 */
public class driver_management extends JPanel {

	
	/**
	 * Creates new form yytywyCar_DriverManagement
	 */
	public driver_management() {
		ctr_login = ControllerFactoryImpl.getInstance().getLoginController();
		try {
			officeNum = ctr_login.getCurrentOptorId().substring(0, 6);
			city = City.toString(CurrentCity.getCurrentCity());
			name=ctr_login.getCurrentName();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		setDriverVOs();
		initComponents();
		this.frame=new MyFrame(this);
	}

	public static void main(String[] args) {
		new driver_management();
	}

	/**
	 * 给子界面提供的 向用户反馈信息的方法
	 * 
	 * @param msg
	 */
	public void setFeedBack(ResultMessage msg) {
		feedback_text.setText(ResultMessage.toFriendlyString(msg));
	}
@Override
protected void paintComponent(Graphics g) {
	g.drawImage(Img.getBackground_main(), 0, 0, null);
}
	private void initComponents() {
		GroupLayout layout = new GroupLayout(this);
		driverjTable = new JTable();
		jScrollPane2 = new JScrollPane();
		initLabel();
		initbtn();
		initialDriverJTable(driverVOs, 0);
		initTxt();
		initLayout(layout);
	}

	/**
	 * @param layout
	 */
	private void initLayout(GroupLayout layout) {

		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGap(32, 32,
																		32)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel1)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										add_btn)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.RELATED,
																										144,
																										Short.MAX_VALUE)
																								.addComponent(
																										jLabel3)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										BusinessOfficeNum_label)
																								.addGap(26,
																										26,
																										26)
																								.addComponent(
																										jLabel2)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										account_label,
																										GroupLayout.PREFERRED_SIZE,
																										82,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(58,
																										58,
																										58)
																								.addComponent(
																										exit_btn))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jScrollPane2,
																										GroupLayout.PREFERRED_SIZE,
																										0,
																										Short.MAX_VALUE)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																												.addGroup(
																														GroupLayout.Alignment.TRAILING,
																														layout.createSequentialGroup()
																																.addComponent(
																																		search_text,
																																		GroupLayout.PREFERRED_SIZE,
																																		120,
																																		GroupLayout.PREFERRED_SIZE)
																																.addGap(31,
																																		31,
																																		31)
																																.addComponent(
																																		search_btn,
																																		GroupLayout.PREFERRED_SIZE,
																																		65,
																																		GroupLayout.PREFERRED_SIZE)
																																.addGap(43,
																																		43,
																																		43))
																												.addGroup(
																														GroupLayout.Alignment.TRAILING,
																														layout.createSequentialGroup()
																																.addComponent(
																																		back_btn,
																																		GroupLayout.PREFERRED_SIZE,
																																		90,
																																		GroupLayout.PREFERRED_SIZE)
																																.addGap(58,
																																		58,
																																		58))))))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		feedback_text)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						add_btn,
																						GroupLayout.PREFERRED_SIZE,
																						31,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						BusinessOfficeNum_label)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						account_label)))
												.addComponent(exit_btn))
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(62, 62,
																		62)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						search_text,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						search_btn,
																						GroupLayout.PREFERRED_SIZE,
																						35,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED,
																		252,
																		Short.MAX_VALUE)
																.addComponent(
																		back_btn,
																		GroupLayout.PREFERRED_SIZE,
																		39,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane2,
																		GroupLayout.PREFERRED_SIZE,
																		0,
																		Short.MAX_VALUE)))
								.addGap(43, 43, 43)
								.addComponent(feedback_text,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(27, 27, 27)));
	}

	/**
	 * 
	 */
	private void initTxt() {
		feedback_text = new JLabel();
		search_text = new JTextField();
		search_text.setText("输入姓名或编号");
		search_text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				search_text.setText("");
			}
		});
		feedback_text.setFocusable(false);

	}
	/**
	 * @param vos
	 * @param n
	 */
	private void initialDriverJTable(ArrayList<DriverVO> vos, int n) {
		assert (vos != null) : ("表格获得的账户信息为空");
		Object[][] DriverObjects = null;
		DriverObjects = new Object[vos.size()][4];
		int i = 0;
		for (java.util.Iterator<DriverVO> t = vos.iterator(); t.hasNext(); i++) {
			DriverVO vo = t.next();
			DriverObjects[i][0] = vo.driverNum;
			DriverObjects[i][1] = vo.name;
			DriverObjects[i][2] = vo.phoneNum;
			DriverObjects[i][3] = "X";
		}

		driverjTable.setModel(new javax.swing.table.DefaultTableModel(
				DriverObjects, new String[] { "编号", "姓名", "手机号", "删除" }) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		driverjTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		if (driverjTable.getColumnModel().getColumnCount() >= 3) {
			driverjTable.getColumnModel().getColumn(3).setPreferredWidth(5);
		}
		ComponentFactory.setJTableTextCenter(driverjTable);
		driverjTable.setRowSelectionInterval(n, n);
		jScrollPane2.setViewportView(driverjTable);
	}
	/**
	 * 
	 */
	public void initTable(){
		setDriverVOs();
		initialDriverJTable(driverVOs, driverVOs.size()-1);
	}
	public void removeDriverVO(DriverVO v){
		driverVOs.remove(v);
	}
	/**
	 * 
	 */
	private void initbtn() {
		add_btn = new MyButton(ButtonType.ADD);
		search_btn = new MyButton(ButtonType.SEARCH);
		exit_btn = new MyButton(ButtonType.EXIT);
		back_btn = new MyButton(ButtonType.BACK);

		search_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				search_btnActionPerformed(e);
			}

		});
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

	/**
	 * 
	 */
	private void initLabel() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		account_label=new JLabel();
		BusinessOfficeNum_label = new JLabel();

		jLabel1.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setText("司机管理");
		jLabel2.setText("账户：");
		jLabel3.setText("营业厅：");
		account_label.setText(name);
		BusinessOfficeNum_label.setText(city + officeNum);
	}

	/**
	 * 监听们~
	 * 
	 * @param evt
	 */

	/**
	 * @param e
	 */
	private void search_btnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == search_btn) {
			String tofindVNum = search_text.getText();
			DriverVO v = null;
			int i = 0;
			boolean found=false;
			if (InputCheck.checkInputNum(tofindVNum, 11) == ResultMessage.VALID) {
				Iterator<DriverVO> t = driverVOs.iterator();
				
				for (; t.hasNext(); i++) {
					v = t.next();
					if (v.driverNum.equals(tofindVNum)) {
						driverjTable.setRowSelectionInterval(i, i);
						ComponentFactory.setState("该司机在第" + (i + 1) + "行",
								ComponentFactory.DISPLAY_TIME, feedback_text);
						;
						found=true;
						break;
					}
				}
				if (!found) {
					ComponentFactory.setState("系统未找该编号的司机",
							ComponentFactory.DISPLAY_TIME, feedback_text);
				}

			} else if (InputCheck.checkInputName(tofindVNum) == ResultMessage.VALID) {
				Iterator<DriverVO> t = driverVOs.iterator();
				for (; t.hasNext(); i++) {
					v = t.next();
					if (v.name.equals(tofindVNum)) {
						driverjTable.setRowSelectionInterval(i, i);
						ComponentFactory.setState("该司机在第" + (i + 1) + "行",
								ComponentFactory.DISPLAY_TIME, feedback_text);
						;
						found=true;
						 break;
					}
				}
				if (!found) {
					ComponentFactory.setState("系统未找到" + tofindVNum + "司机",
							ComponentFactory.DISPLAY_TIME, feedback_text);
				}
			} else {
				ComponentFactory.setState("搜索信息格式错误",
						ComponentFactory.DISPLAY_TIME, feedback_text);
			}
		}
	}

	/**
	 * @param evt
	 */
	private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exit_btnActionPerformed
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
	 * 
	 * @param e
	 */
	public void tableMouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		int row = driverjTable.rowAtPoint(p);
		int column = driverjTable.columnAtPoint(p);
		// 编号 姓名 手机号
		String driverCode, driverName, phone;
		// 点了删除
		if (e.getClickCount() == 1 && column == 3) {
			System.out.println("删除第" + row + "行");
			deleteDriver();
		}
		if (e.getClickCount() == 2) {
			driverCode = driverjTable.getValueAt(row, 0).toString();
			driverName = driverjTable.getValueAt(row, 1).toString();
			phone = driverjTable.getValueAt(row, 2).toString();
			System.out.print("坐标 " + row + "  " + column + "   ");
			new driver_detail(this,driverjTable.getSelectedRow());
		}
	}
public ResultMessage deleteDriver(int selected){

	// TODO Auto-generated method stub
	int tempN = 0;
	ResultMessage rmsg = null;
	DriverVO VO = driverVOs.get(selected);
		try {
			rmsg = driverblController.deleteDriver(VO);
			if (rmsg == ResultMessage.SUCCESS) {
				ComponentFactory.setState("删除成功",
						ComponentFactory.DISPLAY_TIME, feedback_text);
				driverVOs.remove(selected);
				tempN = 0;
				if (selected == 0) {
					tempN = 0;
				} else {
					tempN = selected - 1;
				}
				initialDriverJTable(driverVOs, tempN);
			} else {
				ComponentFactory.setState(
						ResultMessage.toFriendlyString(rmsg),
						ComponentFactory.DISPLAY_TIME, feedback_text);
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ComponentFactory.setState(ComponentFactory.REMOTEFAILD,
					ComponentFactory.DISPLAY_TIME, feedback_text);
		}
	return rmsg;

}
	/**
	 * 
	 */
	private void deleteDriver() {
		// TODO Auto-generated method stub
		int tempN = 0;
		ResultMessage rmsg = null;
		int n1 = driverjTable.getSelectedRow();
		DriverVO VO = driverVOs.get(n1);
		Object[] options = { "取消", "删除" };
		int result = JOptionPane.showOptionDialog(null, "您确定要删除系统该司机？", "是否删除",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);
		if (result == JOptionPane.NO_OPTION) {
			try {
				rmsg = driverblController.deleteDriver(VO);
				if (rmsg == ResultMessage.SUCCESS) {
					ComponentFactory.setState("删除成功",
							ComponentFactory.DISPLAY_TIME, feedback_text);
					driverVOs.remove(n1);
					tempN = 0;
					if (n1 == 0) {
						tempN = 0;
					} else {
						tempN = n1 - 1;
					}
					initialDriverJTable(driverVOs, tempN);
				} else {
					ComponentFactory.setState(
							ResultMessage.toFriendlyString(rmsg),
							ComponentFactory.DISPLAY_TIME, feedback_text);
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				ComponentFactory.setState(ComponentFactory.REMOTEFAILD,
						ComponentFactory.DISPLAY_TIME, feedback_text);
			}
		}
	}

	private void add_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_add_btnMouseClicked
		new driver_add(this).setVisible(true);
	}

	/**
	 * 
	 */
	private void back_btnMouseClicked() {
		new businessOfficer_main();
		this.frame.dispose();
	}

	/**
	 * 
	 */
	private void setDriverVOs() {
		// TODO Auto-generated method stubs
		driverVOs = getDriverVOs();
		driverVOs.sort(null);
	}

	/**
	 * @return
	 */
	private ArrayList<DriverVO> getDriverVOs() {
		ArrayList<DriverVO> vos = null;
		try {
			vos = driverblController.showDriver(City.getCityByNum(officeNum.substring(0, 3)));
			vos.sort(null);
			System.out.println("获得driver的个数为+vos.size()");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接失败");
			ComponentFactory.setState("远程连接失败", ComponentFactory.DISPLAY_TIME,
					feedback_text);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("程序错误");
			ComponentFactory.setState("程序错误", ComponentFactory.DISPLAY_TIME,
					feedback_text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
			ComponentFactory.setState("读取文件失败", ComponentFactory.DISPLAY_TIME,
					feedback_text);
		}

		assert (vos != null) : ("远程获取账户信息失败");
		vos.sort(null);
		return vos;
	}

	/**
	 * @return
	 */
	public DriverBLService getDriverblController() {
		return driverblController;
	}

	/**
	 * @return
	 */
	public String getOfficeNum() {
		return officeNum;
	}
	public ArrayList<DriverVO> conveyDriverVOs(){
		return driverVOs;
	}
//	public JTable getDriverJTable(){
//		return driverjTable;
//	}

	private ArrayList<DriverVO> driverVOs = null;
	private ControllerFactoryblService controllerFactoryblService = ControllerFactoryImpl
			.getInstance();
	private DriverBLService driverblController = controllerFactoryblService
			.getDriverController();

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JLabel BusinessOfficeNum_label, jLabel1, jLabel2, jLabel3;
	private JTable driverjTable;
	private MyButton  add_btn, back_btn, exit_btn, search_btn;
	private JScrollPane jScrollPane2;
	private JTextField search_text;
	public  JLabel account_label,feedback_text;
	private MyFrame frame;
	private LoginBLService ctr_login;
	private String officeNum = "", city = "",name="";
	// End of variables declaration//GEN-END:variables
}
