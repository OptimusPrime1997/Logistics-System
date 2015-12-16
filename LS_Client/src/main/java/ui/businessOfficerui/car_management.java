/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.businessOfficerui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import VO.ManagementVO.AccountVO;
import VO.ManagementVO.InstitutionVO;
import VO.ManagementVO.InstitutionVOPlus;
import VO.ManagementVO.VehicleVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.controllerfactoryblservice.ControllerFactoryblService;
import blservice.loginblservice.LoginBLService;
import blservice.managementblservice.vehicleanddriverblservice.VehicleBLService;
import ui.componentfactory.ComponentFactory;
import util.CurrentCity;
import util.InputCheck;
import util.enumData.City;
import util.enumData.ModifyState;
import util.enumData.ResultMessage;

/**
 *
 * @author Administrator
 */
public class car_management extends javax.swing.JPanel {
	public static void main(String[] args) {
		new car_management(new businessOfficer_main());
	}

	public car_management(businessOfficer_main panel_parent) {
		ctr_login = ControllerFactoryImpl.getInstance().getLoginController();
		this.panel_parent = panel_parent;
		initComponents();
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
		GroupLayout layout = new javax.swing.GroupLayout(this);
		vehiclejTable = new javax.swing.JTable();
		jScrollPane1 = new javax.swing.JScrollPane();
		initLabel();
		initbtn();
		initTxt();
		initTable();
		initlayout(layout);
	}

	public void initTable() {
		setVehicleVOs();
		initialVehicleJTable(vehicleVOs, 0);
	}

	private void initlayout(GroupLayout layout) {
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel4,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										93,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(add_btn)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jLabel6)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(businessOffNum2_label)
								.addGap(26, 26, 26)
								.addComponent(jLabel5)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(Vehicle_btn,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										82,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(52, 52, 52).addComponent(exit_btn))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(23, 23, 23)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										411,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(66, 66,
																		66)
																.addComponent(
																		back_btn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		77,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addContainerGap(
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		18,
																		Short.MAX_VALUE)
																.addComponent(
																		search_text,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		137,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(36, 36,
																		36)
																.addComponent(
																		search_btn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		75,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(38, 38,
																		38))))
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addComponent(feedback_text).addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(exit_btn)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										jLabel6)
																								.addComponent(
																										businessOffNum2_label)
																								.addComponent(
																										jLabel5)
																								.addComponent(
																										Vehicle_btn))
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										jLabel4)
																								.addComponent(
																										add_btn,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										31,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		0,
																		Short.MAX_VALUE)
																.addGap(21, 21,
																		21))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(40, 40,
																		40)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						search_text,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						34,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						search_btn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						34,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		255,
																		Short.MAX_VALUE)
																.addComponent(
																		back_btn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		43,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(58, 58,
																		58)))
								.addComponent(feedback_text,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(12, 12, 12)));

	}

	private void initTxt() {
		search_text = new javax.swing.JTextField();
		feedback_text.setText("空闲");
		search_text.setText("输入车牌号或编号");
		search_text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search_textMouseClicked(e);// TODO
			}

		});
		feedback_text.setEditable(false);

	}

	private void initbtn() {
		add_btn = new javax.swing.JButton();
		search_btn = new javax.swing.JButton();
		back_btn = new javax.swing.JButton();
		Vehicle_btn = new javax.swing.JButton();
		exit_btn = new javax.swing.JButton();
		search_btn.setText("搜索");
		back_btn.setText("返回");
		Vehicle_btn.setText("老李（包括更改密码、退出登录）");
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
		search_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				search_btnActionPerformed(evt);
			}
		});
	}

	/**
	 * 监听们
	 * 
	 * @param evt
	 */
	private void search_btnActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getSource() == search_btn) {
			String tofindVNum = search_text.getText();
			VehicleVO v = null;
			int i = 0;
			if (InputCheck.checkLicenseNum(tofindVNum) == ResultMessage.VALID) {
				Iterator<VehicleVO> t = vehicleVOs.iterator();
				for (; t.hasNext(); i++) {
					v = t.next();
					if (v.licenseNum.equals(tofindVNum)) {
						vehiclejTable.setRowSelectionInterval(i, i);
						ComponentFactory.setState("该车辆在第" + (i + 1) + "行",
								ComponentFactory.DISPLAY_TIME, feedback_text);
						;
						break;
					}
				}
				if (!t.hasNext()) {
					ComponentFactory.setState("系统无找该车牌号的车辆",
							ComponentFactory.DISPLAY_TIME, feedback_text);
				}

			} else if (InputCheck.checkInputNum(tofindVNum, 9) == ResultMessage.VALID) {
				Iterator<VehicleVO> t = vehicleVOs.iterator();
				for (; t.hasNext(); i++) {
					v = t.next();
					if (v.vehicleNum.equals(tofindVNum)) {
						vehiclejTable.setRowSelectionInterval(i, i);
						ComponentFactory.setState("该车辆在第" + (i + 1) + "行",
								ComponentFactory.DISPLAY_TIME, feedback_text);
						;
						break;
					}
				}
				if (!t.hasNext()) {
					ComponentFactory.setState("系统无找该编号的车辆",
							ComponentFactory.DISPLAY_TIME, feedback_text);
				}
			} else {
				ComponentFactory.setState("搜索信息格式错误",
						ComponentFactory.DISPLAY_TIME, feedback_text);
			}
		}
	}

	private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_add_btnActionPerformed

	}

	private void search_textMouseClicked(MouseEvent e) {
		// TODO
		search_text.setText("");
	}

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

	private void add_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_add_btnMouseClicked
		new car_add(this);
	}

	private void back_btnMouseClicked() {
		panel_parent.remove(this);
		panel_parent.add(panel_parent.getPanel1());
		panel_parent.revalidate();
		panel_parent.repaint();
	}

	private void cars_tableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cars_tableMouseClicked
		if (evt.getClickCount() == 2) {
			// TODO 怎么实现只监听一行
			System.out.println("双击哦~");
		}
	}

	/**
	 * 对表格的监听
	 * 
	 * @param e
	 */
	public void tableMouseClicked(MouseEvent e) {
		// Point p = e.getPoint();
		// int row = vehiclejTable.rowAtPoint(p);
		// int column = vehiclejTable.columnAtPoint(p);
		// // 代号、车牌号
		// String carCode, carLicence, startTime;
		// // 点了删除
		// if (e.getClickCount() == 1 && column == 3) {
		//
		// // TODO Auto-generated method stub
		// if (e.getButton() == MouseEvent.BUTTON1) {
		// int tempN = 0;
		// ResultMessage rmsg = null;
		// int n = vehiclejTable.getSelectedRow();
		// VehicleVO vo = vehicleVOs.get(n);
		// Object[] options = { "取消", "删除" };
		// int result = JOptionPane
		// .showOptionDialog(null, "您确定要删除系统该车辆？", "是否删除",
		// JOptionPane.DEFAULT_OPTION,
		// JOptionPane.QUESTION_MESSAGE, null, options,
		// options[0]);
		// if (result == JOptionPane.NO_OPTION) {
		// try {
		// rmsg = vehicleblController.deleteVehicle(vo);
		// if (rmsg == ResultMessage.SUCCESS) {
		// ComponentFactory.setState("删除成功:)",
		// ComponentFactory.DISPLAY_TIME,
		// feedback_text);
		// vehicleVOs.remove(n);
		// tempN = 0;
		// if (n == 0) {
		// tempN = 0;
		// } else {
		// tempN = n - 1;
		// }
		// initialVehicleJTable(vehicleVOs, tempN);
		// } else {
		// ComponentFactory.setState(
		// ResultMessage.toFriendlyString(rmsg),
		// ComponentFactory.DISPLAY_TIME,
		// feedback_text);
		// }
		// } catch (RemoteException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// ComponentFactory.setState(ComponentFactory.REMOTEFAILD,
		// ComponentFactory.DISPLAY_TIME, feedback_text);
		// }
		// }
		// }
		//
		// System.out.println("已删除删除第" + row + "行");
		// }
		// if (e.getClickCount() == 2) {
		// carCode = vehiclejTable.getValueAt(row, 0).toString();
		// carLicence = vehiclejTable.getValueAt(row, 1).toString();
		// startTime = vehicleVOs.get(row).startTime;
		// System.out.print("坐标 " + row + "  " + column + "   ");
		// System.out.println(carCode + "   " + carLicence);
		// new car_detail(this, carCode, carLicence, startTime);
		// }
	}

	private void initialVehicleJTable(ArrayList<VehicleVO> vos, int n) {
		assert (vos != null) : ("表格获得的账户信息为空");
		Object[][] VehicleObjects = null;
		VehicleObjects = new Object[vos.size()][3];
		int i = 0;
		for (java.util.Iterator<VehicleVO> t = vos.iterator(); t.hasNext(); i++) {
			VehicleVO vo = t.next();
			VehicleObjects[i][0] = vo.vehicleNum;
			VehicleObjects[i][1] = vo.licenseNum;
			VehicleObjects[i][2] = vo.startTime;
		}
		
	
		vehiclejTable.setModel(new javax.swing.table.DefaultTableModel(
				VehicleObjects, new String[] { "车辆编号", "车牌号", "开始服役时间" }) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class, };
			boolean[] canEdit = new boolean[] { false, true, true };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		vehiclejTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		if (vehiclejTable.getColumnModel().getColumnCount() > 0) {
			// vehiclejTable.getColumnModel().getColumn(2).setResizable(false);
			// vehiclejTable.getColumnModel().getColumn(2).setPreferredWidth(5);
		}
		ComponentFactory.setJTableTextCenter(vehiclejTable);
		vehiclejTable.setRowSelectionInterval(n, n);

		final JPopupMenu vehiclejPop = new JPopupMenu();
		final JMenuItem vehicleSubmitjItem = new JMenuItem("提交");
		final JMenuItem vehicleDeljItem = new JMenuItem("删除");
		vehicleSubmitjItem.addMouseListener(/**
		 * @author 1 监听vehicle的弹出菜单中的“提交”
		 */
		new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					ResultMessage rmsg = null;
					int n0 = vehiclejTable.getSelectedRow();
					VehicleVO VO = vehicleVOs.get(n0);
					VehicleVO v = getViewvehicleVO(n0);
					if (v.equals(VO)) {
						ComponentFactory.setState("您未对该车辆行进行修改！",
								ComponentFactory.DISPLAY_TIME, feedback_text);
					} else {
						try {
							rmsg = vehicleblController.updateVehicle(v);
							ComponentFactory.setState(
									ResultMessage.toFriendlyString(rmsg),
									ComponentFactory.DISPLAY_TIME,
									feedback_text);
							if (rmsg == ResultMessage.SUCCESS) {
								vehicleVOs.remove(n0);
								vehicleVOs.add(v);
							}
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							ComponentFactory.setState(
									ComponentFactory.REMOTEFAILD,
									ComponentFactory.DISPLAY_TIME,
									feedback_text);
						}
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		vehicleDeljItem.addMouseListener(/**
		 * @author 1 监听vehiclejTable上弹出菜单的“删除”
		 */
		new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					int tempN = 0;
					ResultMessage rmsg = null;
					int n1 = vehiclejTable.getSelectedRow();
					VehicleVO VO = vehicleVOs.get(n1);
					Object[] options = { "取消", "删除" };
					int result = JOptionPane.showOptionDialog(null,
							"您确定要删除系统该车辆？", "是否删除", JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					if (result == JOptionPane.NO_OPTION) {
						try {
							rmsg = vehicleblController.deleteVehicle(VO);
							if (rmsg == ResultMessage.SUCCESS) {
								ComponentFactory.setState("删除成功:)",
										ComponentFactory.DISPLAY_TIME,
										feedback_text);
								vehicleVOs.remove(n1);
								tempN = 0;
								if (n1 == 0) {
									tempN = 0;
								} else {
									tempN = n1 - 1;
								}
								initialVehicleJTable(vehicleVOs, tempN);
								repaint();
							} else {
								ComponentFactory.setState(
										ResultMessage.toFriendlyString(rmsg),
										ComponentFactory.DISPLAY_TIME,
										feedback_text);
							}
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							ComponentFactory.setState(
									ComponentFactory.REMOTEFAILD,
									ComponentFactory.DISPLAY_TIME,
									feedback_text);
						}
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		;
		vehiclejPop.add(vehicleSubmitjItem);
		vehiclejPop.add(vehicleDeljItem);
		MouseInputListener mil = new MouseInputListener() {

			public void mouseClicked(MouseEvent e) {
				processEvent(e);
			}

			public void mousePressed(MouseEvent e) {
				processEvent(e);
			}

			public void mouseReleased(MouseEvent e) {
				processEvent(e);
				if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0
						&& !e.isControlDown() && !e.isShiftDown()) {
					if (vehiclejTable.isShowing()) {
						vehiclejPop.show(vehiclejTable, e.getX(), e.getY());
					}
				}
			}

			public void mouseEntered(MouseEvent e) {
				processEvent(e);
			}

			public void mouseExited(MouseEvent e) {
				processEvent(e);
			}

			public void mouseDragged(MouseEvent e) {
				processEvent(e);
			}

			public void mouseMoved(MouseEvent e) {
				processEvent(e);
			}

			private void processEvent(MouseEvent e) {
				if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
					int modifiers = e.getModifiers();
					modifiers -= MouseEvent.BUTTON3_MASK;
					modifiers |= MouseEvent.BUTTON1_MASK;
					MouseEvent ne = new MouseEvent(e.getComponent(), e.getID(),
							e.getWhen(), modifiers, e.getX(), e.getY(),
							e.getClickCount(), false);
					vehiclejTable.dispatchEvent(ne);
				}
			}
		};
		vehiclejTable.addMouseListener(mil);
		vehiclejTable.putClientProperty("terminateEditOnFocusLost",
				Boolean.TRUE);
		jScrollPane1.setViewportView(vehiclejTable);
	}

	private VehicleVO getViewvehicleVO(int n) {
		// TODO Auto-generated method stub
		String vehicleNum = null;
		String vehicleLicenseNum = null;
		String startTime = null;
		try {
			vehicleNum = (String) vehiclejTable.getValueAt(n, 0);
			vehicleLicenseNum = (String) vehiclejTable.getValueAt(n, 1);
			startTime = (String) vehiclejTable.getValueAt(n, 2);
			assert (vehicleLicenseNum != null && vehicleNum != null && startTime != null) : ("您输入的机构信息不完整！");
		} catch (ClassCastException e) {
			e.printStackTrace();
			ComponentFactory.setState("您输入的值类型不正确：(",
					ComponentFactory.DISPLAY_TIME, feedback_text);
		} catch (AssertionError e) {
			ComponentFactory.setState("您输入的机构信息不完整！",
					ComponentFactory.DISPLAY_TIME, feedback_text);
			System.out.println(e.getMessage());
		}
		return new VehicleVO(vehicleNum, vehicleLicenseNum, startTime);
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
		try {
			officeNum = ctr_login.getCurrentOptorId().substring(0, 6);
			System.out.println(ctr_login.getCurrentOptorId());
			city = City.toString(CurrentCity.getCurrentCity());
			businessOffNum2_label.setText(city + officeNum);
		} catch (RemoteException e) {
		}
	}

	private void setVehicleVOs() {
		// TODO Auto-generated method stub
		vehicleVOs = getVehicleVOs();
		vehicleVOs.sort(null);
	}

	private ArrayList<VehicleVO> getVehicleVOs() {
		ArrayList<VehicleVO> vos = null;
		try {
			vos = vehicleblController.showVehicle();
			vos.sort(null);
			System.out.println(vos.size());
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
		return vos;
	}

	public VehicleBLService getVehicleblController() {
		return vehicleblController;
	}

	public String getOfficeNum() {
		return officeNum;
	}

	private ArrayList<VehicleVO> vehicleVOs = null;
	private ControllerFactoryblService controllerFactoryblService = ControllerFactoryImpl
			.getInstance();
	private VehicleBLService vehicleblController = controllerFactoryblService
			.getVehicleController();

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private businessOfficer_main panel_parent;
	private javax.swing.JButton Vehicle_btn, add_btn, back_btn, exit_btn,
			search_btn;
	private javax.swing.JLabel businessOffNum2_label, jLabel4, jLabel5,
			jLabel6;
	private javax.swing.JTable vehiclejTable;
	final private javax.swing.JTextField feedback_text = new JTextField();
	private javax.swing.JScrollPane jScrollPane1;
	private JTextField search_text;
	private String officeNum = "", city = "";
	private LoginBLService ctr_login;
	private static final long serialVersionUID = 1L;// TODO 这是干啥的呀
	// End of variables declaration//GEN-END:variables

	//
}
