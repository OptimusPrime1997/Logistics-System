/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.administratorui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.PrivilegedActionException;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.MouseInputListener;

import ui.componentfactory.ComponentFactory;
import util.enumData.Authority;
import util.enumData.ModifyState;
import util.enumData.ResultMessage;
import util.enumData.Sex;
import blservice.managementblservice.accountblservice.AccountBLService;
import VO.ManagementVO.AccountVO;
import VO.ManagementVO.InstitutionVO;
import VO.ManagementVO.InstitutionVOPlus;
import main.MainFrame;

/**
 *
 * @author G
 */
public class AccountSearchPanel extends javax.swing.JFrame {

	/**
	 * Creates new form AccountSearch
	 */
	public AccountSearchPanel(AdministratorPanel panel) {
		this.administratorPanel = panel;
		this.accountblController = panel.getAccountblController();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		/**
		 * 设置窗体大小为不可变
		 */
		this.setResizable(false);
		/**
		 * 设置窗体在中部出现
		 */
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screensize = tk.getScreenSize();
		int screenh = screensize.height;
		int screenw = screensize.width;
		this.setSize(400, 400);
		this.setLocation(screenw / 2 - this.getWidth() / 2,
				screenh / 2 - this.getHeight() / 2);
		/**
		 * 关闭窗口
		 */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		sexjComboBox = ComponentFactory.getSexJComboBox();
		authorityjComboBox = ComponentFactory.getInstance()
				.getAuthorityJComboBox();
		jLabel9 = new javax.swing.JLabel();
		exit = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		accountjTable = new javax.swing.JTable();
		back = new javax.swing.JButton();
		jTabbedPane1 = new javax.swing.JTabbedPane();

		setAccountVOs();

		jLabel9.setText("当前账户：" + administratorPanel.getOptorName());

		exit.setText("退出");
		exit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});

		// TODO 显示需要的表格
		initialAccountJTable(accountVOs,0);
		back.setText("返回");
		back.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backActionPerformed(evt);
			}
		});

		jTabbedPane1.setToolTipText("");
		jTabbedPane1.setAutoscrolls(true);

		resultMsg.setText("空闲");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel9)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		exit)
																.addContainerGap())
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jTabbedPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										resultMsg,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										303,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										back)
																								.addContainerGap())
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										jScrollPane1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										366,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(15,
																										15,
																										15)))))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel9)
																				.addComponent(
																						exit))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		205,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jTabbedPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(76, 76,
																		76)))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		back)
																.addContainerGap(
																		29,
																		Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		resultMsg)
																.addGap(14, 14,
																		14)))));
	}// </editor-fold>//GEN-END:initComponents

	private void initialAccountJTable(ArrayList<AccountVO> vos,int row) {
		// TODO Auto-generated method stub
		Object[][] accountObjects = null;
		accountObjects = new Object[vos.size()][7];
		int i = 0;
		for (java.util.Iterator<AccountVO> t = vos.iterator(); t.hasNext();i++) {
			AccountVO vo = t.next();
			accountObjects[i][0] = vo.accountNum;
			accountObjects[i][1] = vo.accountName;
			accountObjects[i][2]=vo.password;
			accountObjects[i][3] = vo.sex;
			accountObjects[i][4] = vo.authority;
			accountObjects[i][5] = vo.institutionNum;
			accountObjects[i][6] = vo.phoneNum;
			
		}
		accountjTable.setModel(new javax.swing.table.DefaultTableModel(
				accountObjects, new String[] { "用户账号", "姓名", "性别", "职位",
						"机构编号", "电话" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, JComboBox.class, JComboBox.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, true, true, true, true,
					true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		accountjTable.getColumnModel().getColumn(3)
				.setCellEditor(new DefaultCellEditor(sexjComboBox));

		accountjTable.getColumnModel().getColumn(4)
				.setCellEditor(new DefaultCellEditor(authorityjComboBox));

		final JPopupMenu accountjPop = new JPopupMenu();
		final JMenuItem accountSubmitjItem = new JMenuItem("提交");
		final JMenuItem accountDeljItem = new JMenuItem("删除");
		accountSubmitjItem.addMouseListener(/**
		 * @author 1
		 *         监听account的弹出菜单中的“提交”
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
					int n = accountjTable.getSelectedRow();
					AccountVO vo = accountVOs.get(n);
					AccountVO v = getViewAccountVO(n);
						if (v.equals(vo)) {
							ComponentFactory.setState("您未对该行进行修改！", ComponentFactory.DISPLAY_TIME,resultMsg);
						} else {
							try {
								rmsg = accountblController.update(v);
								ComponentFactory.setState(ResultMessage.toFriendlyString(rmsg),
										ComponentFactory.DISPLAY_TIME,resultMsg);
								if (rmsg == ResultMessage.SUCCESS) {
									accountVOs.remove(n);
									accountVOs.add(n,v);
								}
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								ComponentFactory.setState(ComponentFactory.REMOTEFAILD, ComponentFactory.DISPLAY_TIME,resultMsg);
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
		accountDeljItem.addMouseListener(/**
		 * @author 1
		 *         监听accountjTable上弹出菜单的“删除”
		 */
		new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					int tempN = 0;
					ResultMessage rmsg = null;
					int n = accountjTable.getSelectedRow();
					AccountVO vo = accountVOs.get(n);
						Object[] options = { "取消", "删除" };
						int result = JOptionPane.showOptionDialog(null,
								"您确定要删除系统该账户？", "是否删除",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);
						if (result == JOptionPane.NO_OPTION) {
							try {
								rmsg = accountblController.delete(vo
										);
								if (rmsg == ResultMessage.SUCCESS) {
									ComponentFactory.setState("删除成功:)", ComponentFactory.DISPLAY_TIME,resultMsg);
									accountVOs.remove(n);
									tempN = 0;
									if (n == 0) {
										tempN = 0;
									} else {
										tempN = n - 1;
									}
									initialAccountJTable(accountVOs,
											tempN);
								} else {
									ComponentFactory.setState(ResultMessage
											.toFriendlyString(rmsg),
											ComponentFactory.DISPLAY_TIME,resultMsg);
								}
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								ComponentFactory.setState(ComponentFactory.REMOTEFAILD, ComponentFactory.DISPLAY_TIME,resultMsg);
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
		accountjPop.add(accountSubmitjItem);
		accountjPop.add(accountDeljItem);
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
					accountjPop.show(accountjTable, e.getX(), e.getY());
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
					accountjTable.dispatchEvent(ne);
				}
			}
		};
		accountjTable.addMouseListener(mil);
		accountjTable.putClientProperty("terminateEditOnFocusLost",
				Boolean.TRUE);
		
		
		
		accountjTable.setGridColor(new java.awt.Color(0, 0, 0));
		ComponentFactory.setJTableTextCenter(accountjTable);
		accountjTable.setRowSelectionInterval(row, row);
		jScrollPane1.setViewportView(accountjTable);
	}
	protected AccountVO getViewAccountVO(int n) {
		// TODO Auto-generated method stub
		String accountNum = null;
		String accountName = null;
		String password=null;
		Sex sex=null;
		Authority  authority = null;
		String institutionNum = null;
		String phoneNum = null;
		try {
			accountNum = (String) accountjTable.getValueAt(n, 0);
			accountName = (String) accountjTable.getValueAt(n, 1);
			password=(String)accountjTable.getValueAt(n, 2);
			sex = (Sex) accountjTable.getValueAt(n, 3);
			authority = (Authority) accountjTable.getValueAt(n, 4);
			institutionNum = (String) accountjTable.getValueAt(n, 5);
			phoneNum=(String) accountjTable.getValueAt(n, 6);
			
			assert (accountName != null && accountNum != null
					&& sex != null && authority != null && institutionNum != null
					&&phoneNum !=null) : ("您输入的机构信息不完整！");
		} catch (ClassCastException e) {
			e.printStackTrace();
			ComponentFactory.setState("您输入的值类型不正确：(", ComponentFactory.DISPLAY_TIME,resultMsg);
		} catch (AssertionError e) {
			ComponentFactory.setState("您输入的机构信息不完整！", ComponentFactory.DISPLAY_TIME,resultMsg);
			System.out.println(e.getMessage());
		}
		return new AccountVO(accountNum, accountName,password, sex,authority,
				institutionNum, phoneNum);
	}
	private void exitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jButton3ActionPerformed

	private void setAccountVOs() {
		// TODO Auto-generated method stub
		accountVOs = getAccountVOs();
		accountVOs.sort(null);
	}

	ArrayList<AccountVO> getAccountVOs() {
		ArrayList<AccountVO> vos = null;
		try {
			vos = accountblController.show();
			vos.sort(null);
			System.out.println(vos.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接失败");
			ComponentFactory.setState("远程连接失败", ComponentFactory.DISPLAY_TIME,
					resultMsg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("程序错误");
			ComponentFactory.setState("程序错误", ComponentFactory.DISPLAY_TIME,
					resultMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
			ComponentFactory.setState("读取文件失败", ComponentFactory.DISPLAY_TIME,
					resultMsg);
		}

		assert (vos != null) : ("远程获取账户信息失败");
		return vos;
	}

	private void backActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		UserAccountPanel ua = new UserAccountPanel(administratorPanel);
		ua.setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jButton4ActionPerformed

	private ArrayList<AccountVO> accountVOs = null;
	private AccountBLService accountblController = null;
	private AdministratorPanel administratorPanel;
	private JComboBox sexjComboBox;
	private JComboBox authorityjComboBox;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton exit;
	private javax.swing.JButton back;
	final private javax.swing.JLabel resultMsg = new javax.swing.JLabel();
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable accountjTable;
	// End of variables declaration//GEN-END:variables
}
