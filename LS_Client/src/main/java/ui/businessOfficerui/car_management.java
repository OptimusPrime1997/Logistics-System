/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.businessOfficerui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.MouseInputListener;

import main.MainFrame;
import ui.Img;
import ui.componentfactory.ComponentFactory;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyFrame;
import ui.util.MyLabel;
import ui.util.MyTextField;
import ui.util.TextType;
import util.CurrentCity;
import util.InputCheck;
import util.enumData.City;
import util.enumData.ResultMessage;
import VO.ManagementVO.VehicleVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.controllerfactoryblservice.ControllerFactoryblService;
import blservice.loginblservice.LoginBLService;
import blservice.managementblservice.vehicleanddriverblservice.VehicleBLService;

/**
 *
 * @author Administrator
 */
public class car_management extends javax.swing.JPanel {
	public static void main(String[] args) {
		new car_management();
	}
	
	//TODO
	public car_management() {
		ctr_login = ControllerFactoryImpl.getInstance().getLoginController();
		initComponents();
		frame=new MyFrame(this);
		
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
		
		initLabel();
		initbtn();
		initTxt();
		initTable();
		initlayout();
	}
	public void initTable() {
		vehiclejTable = new javax.swing.JTable();
		jScrollPane1 = new javax.swing.JScrollPane();
		
		jScrollPane1.setBounds(450, 100, 20, 300);
		setVehicleVOs();
		initialVehicleJTable(vehicleVOs, 0);
		
		vehiclejTable.setBounds(50, 100, 400, 300);
	}
	private void initlayout() {
		this.setLayout(null);
		this.add(account_label);
		this.add(label01);
		this.add(label02);
		this.add(label03);
		this.add(jLabel4);
		this.add(businessOffNum_label);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(search_btn);
		this.add(exit_btn);
		this.add(add_btn);
		this.add(back_btn);
		this.add(jScrollPane1);
		this.add(feedback_text);
		this.add(search_text);
		this.add(vehiclejTable);
		
		//TODO
		
	}
	private void initTxt() {
		search_text = new MyTextField(TextType.INPUT, 500, 100, 120, 30);
		feedback_text.setText("空闲");
		search_text.setText("输入车牌号或编号");
		search_text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search_textMouseClicked(e);
			}

		});
		feedback_text.setFocusable(false);
	}
	private void initbtn() {
		add_btn = new MyButton(110,30,ButtonType.ADD);
		search_btn = new MyButton(640,100,ButtonType.SEARCH);
		back_btn = new MyButton(600,400,ButtonType.BACK);
		exit_btn = new MyButton(790,5,ButtonType.EXIT);
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
		if (evt.getSource() == search_btn) {
			
			boolean  found=false;
			String tofindVNum = search_text.getText();
			VehicleVO v = null;
			int i = 0;
			if (InputCheck.checkLicenseNum(tofindVNum) == ResultMessage.VALID) {
				Iterator<VehicleVO> t = vehicleVOs.iterator();
				for (; t.hasNext(); i++) {
					v = t.next();
					if (v.licenseNum.equals(tofindVNum)) {
						found=true;
						vehiclejTable.setRowSelectionInterval(i, i);
						ComponentFactory.setState("该车辆在第" + (i + 1) + "行",
								ComponentFactory.DISPLAY_TIME, feedback_text);
						;
						break;
					}
				}
				if (!found) {
					ComponentFactory.setState("系统未找到该车牌号的车辆",
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
				if (!found) {
					ComponentFactory.setState("系统未找该编号的车辆",
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
		search_text.setText("");
	}

	private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exit_btnActionPerformed
		if (evt.getSource() == exit_btn) {
			Object[] options = { "取消", "确定" };
			int result = JOptionPane.showOptionDialog(null, "您确定要退出系统？",
					"是否退出", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (result == JOptionPane.NO_OPTION) {
				new MainFrame();
				this.frame.dispose();
			}
		}
	}

	private void add_btnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_add_btnMouseClicked
		new car_add(this);
	}

	private void back_btnMouseClicked() {
		new businessOfficer_main();
		frame.dispose();
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

		ComponentFactory.setJTableTextCenter(vehiclejTable);
		vehiclejTable.setRowSelectionInterval(n, n);
		final JPopupMenu vehiclejPop = new JPopupMenu();
		final JMenuItem vehicleSubmitjItem = new JMenuItem("提交");
		final JMenuItem vehicleDeljItem = new JMenuItem("删除");
		vehicleSubmitjItem.addMouseListener(/**
		 * @author 1 监听vehicle的弹出菜单中的“提交”
		 */
		new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
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
							e1.printStackTrace();
							ComponentFactory.setState(
									ComponentFactory.REMOTEFAILD,
									ComponentFactory.DISPLAY_TIME,
									feedback_text);
						}
					}
				}

			}
		});
		vehicleDeljItem.addMouseListener(/**
		 * @author 1 监听vehiclejTable上弹出菜单的“删除”
		 */
		new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
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
							e1.printStackTrace();
							ComponentFactory.setState(
									ComponentFactory.REMOTEFAILD,
									ComponentFactory.DISPLAY_TIME,
									feedback_text);
						}
					}
				}
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
		jLabel4 = new MyLabel("车辆管理",20,20,100,50);
		jLabel5 = new MyLabel("账户：",460,20,50,30);
		jLabel6 = new MyLabel("营业厅：",300,20,70,30);
		businessOffNum_label=new MyLabel("", 355, 20,90, 30);
		account_label=new MyLabel("",500,20,100,30);
		label01=new MyLabel("车辆编号", 80, 70, 100, 30);
		label02=new MyLabel("车牌号", 230, 70, 100, 30);
		label03=new MyLabel("开始服役时间", 330, 70, 200, 30);
		//vehiclejTable.setBounds(50, 100, 400, 300);
		jLabel4.setFont(new java.awt.Font("宋体", 1, 18));
		jLabel4.setForeground(Color.WHITE);
		try {
			officeNum = ctr_login.getCurrentOptorId().substring(0, 6);
			name=ctr_login.getCurrentName();
			System.out.println(ctr_login.getCurrentOptorId());
			city = City.toString(CurrentCity.getCurrentCity());
			businessOffNum_label.setText(city +" "+ officeNum);
			account_label.setText(name);
		} catch (RemoteException e) {
		}
	}

	private void setVehicleVOs() {
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
			e.printStackTrace();
			System.out.println("远程连接失败");
			ComponentFactory.setState("远程连接失败", ComponentFactory.DISPLAY_TIME,
					feedback_text);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("程序错误");
			ComponentFactory.setState("程序错误", ComponentFactory.DISPLAY_TIME,
					feedback_text);
		} catch (IOException e) {
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
@Override
protected void paintComponent(Graphics g) {
	g.drawImage(Img.getBackground_main(), 0, 0, null);
}
	private ArrayList<VehicleVO> vehicleVOs = null;
	private ControllerFactoryblService controllerFactoryblService = ControllerFactoryImpl
			.getInstance();
	private VehicleBLService vehicleblController = controllerFactoryblService
			.getVehicleController();

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private MyButton add_btn, back_btn, exit_btn,search_btn;
	private MyLabel businessOffNum_label, jLabel4, jLabel5,
			jLabel6,account_label,label01,label02,label03;
	private javax.swing.JTable vehiclejTable;
	final private MyLabel feedback_text=new MyLabel("空闲", 30, 500, 450, 30);
	private javax.swing.JScrollPane jScrollPane1;
	private MyTextField search_text;
	private MyFrame frame;
	private String officeNum = "", city = "",name="";
	private LoginBLService ctr_login;
	private static final long serialVersionUID = 1L;// TODO 这是干啥的呀
	// End of variables declaration//GEN-END:variables

	//
}
