/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.managerui;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import main.MainFrame;
import ui.componentfactory.ComponentFactory;
import ui.receiptui.BusinessForm;
import ui.receiptui.ProfitForm;
import ui.util.StrToLogType;
import util.InputCheck;
import util.enumData.Authority;
import util.enumData.LogType;
import util.enumData.ModifyState;
import util.enumData.Rep;
import util.enumData.ResultMessage;
import util.enumData.SalaryPolicy;
import util.enumData.Sex;
import VO.LogVO;
import VO.ManagementVO.AccountVO;
import VO.ManagementVO.ConstVO;
import VO.ManagementVO.ConstVOPlus;
import VO.ManagementVO.InstitutionVO;
import VO.ManagementVO.InstitutionVOPlus;
import VO.ManagementVO.SalaryPolicyVO;
import VO.ManagementVO.SalaryPolicyVOPlus;
import bl.controllerfactorybl.ControllerFactoryImpl;
import bl.loginbl.Loginbl;
import bl.receiptbl.DocumentCheckbl.DocumentCheckbl;
import blservice.controllerfactoryblservice.ControllerFactoryblService;
import blservice.logblservice.LogBLService;
import blservice.managementblservice.accountblservice.AccountBLService;
import blservice.managementblservice.constblservice.ConstBLService;
import blservice.managementblservice.institutionblservice.InstitutionBLService;
import blservice.managementblservice.salarypolicyblservice.SalaryPolicyBLService;

/**
 *
 * @author 1
 */
public class ManagerJFrame extends javax.swing.JFrame {

	/**
	 * Creates new form ManagerJFrame
	 */

	public ManagerJFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			throw new RuntimeException();
		}
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ManagerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ManagerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ManagerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ManagerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		initComponents();

		this.setResizable(false);
		// managerFrame.setUndecorated(false);
		this.setVisible(true);
	}

	private void setInstitutionVOs() {
		// TODO Auto-generated method stub
		institutionVOPlus = new ArrayList<InstitutionVOPlus>();
		InstitutionVO vo = null;
		InstitutionVOPlus voplus = null;
		ArrayList<InstitutionVO> vos = getInstitutionVOs();
		for (Iterator<InstitutionVO> t = vos.iterator(); t.hasNext();) {
			vo = t.next();
			voplus = new InstitutionVOPlus(vo, ModifyState.SYNC);
			institutionVOPlus.add(voplus);
		}
		institutionVOPlus.sort(null);
	}

	private void setSalaryPolicyVOs() {
		// TODO Auto-generated method stub
		salaryPolicyVOPlus = new ArrayList<SalaryPolicyVOPlus>();
		SalaryPolicyVO vo = null;
		SalaryPolicyVOPlus voplus = null;
		ArrayList<SalaryPolicyVO> vos = getSalaryPolicyVOs();
		for (Iterator<SalaryPolicyVO> t = vos.iterator(); t.hasNext();) {
			vo = t.next();
			voplus = new SalaryPolicyVOPlus(vo, ModifyState.SYNC);
			salaryPolicyVOPlus.add(voplus);
		}
		salaryPolicyVOPlus.sort(null);
	}

	private void setConstVOs() {
		// TODO Auto-generated method stub
		constVOPlus = new ArrayList<ConstVOPlus>();
		ConstVO vo = null;
		ConstVOPlus voplus = null;
		for (Iterator<ConstVO> t = getConstVOs().iterator(); t.hasNext();) {
			vo = t.next();
			voplus = new ConstVOPlus(vo, ModifyState.SYNC);
			constVOPlus.add(voplus);
		}
		constVOPlus.sort(null);
	}

	private void setAccountVOs() {
		// TODO Auto-generated method stub
		accountVOs = getAccountVOs();
		accountVOs.sort(null);
	}

	private void setLogVOs(String startTime, String endTime, LogType type) {
		logVOs = getLogVOs(startTime, endTime, type);
		if (logVOs != null) {
			System.out.println("得到的log数据：" + logVOs.size());
		} else {
			System.out.println("得到的log数据为空!");
		}
		logVOs.sort(null);
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

		setDocumentVector();
		setAccountVOs();
		setConstVOs();
		setSalaryPolicyVOs();
		setInstitutionVOs();
		initialVariables();

		setAllLayout();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		managerjPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(""));
		managerjPanel.setToolTipText("总经理");
		managerjTabbedPane.setPreferredSize(new java.awt.Dimension(830, 560));

		jButton3.setText("jButton2");

		jButton5.setText("jButton4");

		initialConstjPanel();
		initialSalayPolicyjPanel();
		initialCheckjPanel();
		initialInstitutionjPanel();
		initialAccountjPanel();
		initialFormjPanel();

		initialLogjPaenl();
		jLabel6.setFont(new Font("宋体", Font.BOLD, 12));
		jLabel6.setText("总经理");
		jLabel6.setToolTipText("");
		String currentOptorId = Loginbl.getCurrentOptorId();
		currentAccountNamejLabel.setText(currentOptorId);

		currentAuthorityjLabel.setText(Loginbl.getCurrentOptorName());

		// currentAccoutNamejLabel.setText("12345");

		jLabel48.setText("状态：");

		statejLabel.setText("空闲");

		exitjButton.setText("退出系统");
		exitjButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitjButtonActionPerformed(evt);
			}

			/**
			 * 退出系统按钮的监听
			 * 
			 * @param evt
			 */

		});

	}// </editor-fold>//GEN-END:initComponents

	/**
	 * 初始化日志面板
	 */
	private void initialLogjPaenl() {

		logjPanel.setName("logView"); // NOI18N

		logjPanel.setPreferredSize(new java.awt.Dimension(830, 460));

		findLogjButton.setText("查找");
		findLogjButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				findLogjButtonActionPerformed(evt);
			}
		});

		jLabel36.setText("开始日期：");

		jLabel37.setText("年");

		jLabel38.setText("月");

		jLabel39.setText("日");

		jLabel40.setText("操作类型：");

		// logTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		// new String[] { "所有操作", "决策制定", "审批单据", "用户账户管理", "银行账户管理",
		// "人员机构管理" }));
		logTypejComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logTypejComboBoxActionPerformed(evt);
			}
		});

		// logSYearjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		// new String[] { "2000", "2001", "2002", "2003", "2004", "2005",
		// "2006", "2007", "2008", "2009", "2010", "2011", "2012",
		// "2013", "2014", "2015" }));
		logSYearjComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						logSYearjComboBoxActionPerformed(evt);
					}
				});

		// logSDatejComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		// new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
		// "10", "11", "12", "13", "14", "15", "16", "17", "18",
		// "9", "20", "21", "22", "23", "24", "25", "26", "27",
		// "28", "29", "30", "31" }));
		logSDatejComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						logSDatejComboBoxActionPerformed(evt);
					}
				});

		// logSMonthjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		// new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
		// "10", "11", "12" }));
		logSMonthjComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						logSMonthjComboBoxActionPerformed(evt);
					}
				});

		jLabel41.setText("年");

		jLabel42.setText("月");

		jLabel43.setText("日");

		// logEYearjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		// new String[] { "2000", "2001", "2002", "2003", "2004", "2005",
		// "2006", "2007", "2008", "2009", "2010", "2011", "2012",
		// "2013", "2014", "2015" }));
		logEYearjComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						logEYearjComboBoxActionPerformed(evt);
					}
				});

		// logEDatejComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		// new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
		// "10", "11", "12", "13", "14", "15", "16", "17", "18",
		// "19", "20", "21", "22", "23", "24", "25", "26", "27",
		// "28", "29", "30", "31" }));
		logEDatejComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						logEDatejComboBoxActionPerformed(evt);
					}
				});

		// logEMonthjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		// new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
		// "10", "11", "12" }));
		logEMonthjComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						logEYearjComboBox1ActionPerformed(evt);
					}
				});

		jLabel44.setText("截止日期：");

		jLabel47.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel47.setText("系统日志");

		// initialLogJTable(logVOs);

		managerjTabbedPane.addTab("日志查看", logjPanel);
	}

	/**
	 * 初始化日志查看列表
	 */
	private void initialLogJTable(ArrayList<LogVO> vos) {
		// TODO Auto-generated method stub

		assert (vos != null) : ("表格获得的日志信息为空");
		authorityjComboBox.setEditable(false);
		Object[][] logObjects = null;
		logObjects = new Object[vos.size()][4];
		int i = 0;
		for (java.util.Iterator<LogVO> t = vos.iterator(); t.hasNext(); i++) {
			LogVO vo = t.next();
			System.out.println("得到的log信息：" + vo.time);
			logObjects[i][0] = vo.time;
			logObjects[i][1] = vo.operationName;
			logObjects[i][2] = authorityjComboBox.getItemAt(Integer
					.parseInt(vo.operatorID.substring(7, 8)));
			logObjects[i][3] = vo.operatorID;

		}

		logjTable.setModel(new javax.swing.table.DefaultTableModel(logObjects,
				new String[] { "日期", "操做类型", "操作人员职位", "操作人员编号" }) {
			Class[] types = new Class[] { java.lang.String.class,
					JComboBox.class, JComboBox.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		logjTable.getColumnModel().getColumn(1)
				.setCellEditor(new DefaultCellEditor(logTypejComboBox));
		logjTable.getColumnModel().getColumn(2)
				.setCellEditor(new DefaultCellEditor(authorityjComboBox));

		// logjTable.setRowSelectionInterval(0, 0);// 设置哪几行被选中

		logjTable.setGridColor(new java.awt.Color(0, 0, 0));
		logjTable.setName("123"); // NOI18N
		logjTable.getTableHeader().setReorderingAllowed(false);

		ComponentFactory.setJTableTextCenter(logjTable);
		jScrollPane11.setViewportView(logjTable);

		setJTableTextCenter(logjTable);
	}

	/**
	 * 初始化报表查看面板
	 */
	private void initialFormjPanel() {
		// TODO Auto-generated method stub

		formjPanel.setName("formView"); // NOI18N
		formjPanel.setPreferredSize(new java.awt.Dimension(830, 460));

		profitFormjButton.setText("成本收益表");
		profitFormjButton.setToolTipText("");
		profitFormjButton.setName("profitFrom"); // NOI18N
		profitFormjButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						profitFormjButtonActionPerformed(evt);
					}
				});

		manageStateFormjButton.setText("经营情况表");
		manageStateFormjButton.setName("businessFrom"); // NOI18N
		manageStateFormjButton
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseReleased(java.awt.event.MouseEvent evt) {
						manageStateFormjButton1MouseReleased(evt);
					}
				});

		jLabel30.setText("年");
		jLabel31.setText("月");
		jLabel32.setText("日");
		formEYearjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "2000", "2001", "2002", "2003", "2004", "2005",
						"2006", "2007", "2008", "2009", "2010", "2011", "2012",
						"2013", "2014", "2015" }));
		formEYearjComboBox.setName("yearComBox"); // NOI18N
		formEYearjComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						formEYearjComboBoxActionPerformed(evt);
					}
				});
		formEDatejComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
						"10", "11", "12", "13", "14", "15", "16", "17", "18",
						"9", "20", "21", "22", "23", "24", "25", "26", "27",
						"28", "29", "30", "31" }));
		formEDatejComboBox.setName("dataComBox"); // NOI18N
		formEDatejComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						formEDatejComboBoxActionPerformed(evt);
					}
				});
		formEMonthjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
						"10", "11", "12" }));
		formEMonthjComboBox.setName("monthComBox"); // NOI18N
		formEMonthjComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						formEMonthjComboBoxActionPerformed(evt);
					}
				});
		jLabel33.setText("截止日期：");

		jLabel33.setVisible(false);
		jLabel30.setVisible(false);
		jLabel31.setVisible(false);
		jLabel32.setVisible(false);

		formEYearjComboBox.setVisible(false);
		formEMonthjComboBox.setVisible(false);
		formEDatejComboBox.setVisible(false);

		outputFormjButton.setText("导出报表");
		outputFormjButton.setName("outFormButton"); // NOI18N
		outputFormjButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				outputFormjButtonMouseReleased(evt);
			}
		});

		managerjTabbedPane.addTab("报表查看", formjPanel);

	}

	/**
	 * 初始化账户查看面板
	 */
	private void initialAccountjPanel() {
		// TODO Auto-generated method stub
		accountjPanel.setName("personnelView"); // NOI18N
		accountjPanel.setPreferredSize(new java.awt.Dimension(930, 460));

		jLabel19.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel19.setText("人员信息");

		accountNamejTextField.setText("请输入人员姓名");
		accountNamejTextField
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						accountNamejTextFieldMouseClicked(evt);
					}
				});

		findAccountNamejButton.setText("姓名查找");
		findAccountNamejButton
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseReleased(java.awt.event.MouseEvent evt) {
						findAccountNamejButtonMouseReleased(evt);
					}
				});

		jLabel9.setText("账号：");

		accountNumjTextField.setText("请输入人员编号");
		accountNumjTextField
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						accountNumjTextFieldMouseClicked(evt);
					}
				});
		accountNumjTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						accountNumjTextFieldActionPerformed(evt);
					}
				});

		findAccountNumjButton.setText("账号查找");
		findAccountNumjButton
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseReleased(java.awt.event.MouseEvent evt) {
						findAccountNumjButtonMouseReleased(evt);
					}
				});
		findAccountNumjButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						findAccountNumjButtonActionPerformed(evt);
					}
				});

		jLabel11.setText("姓名：");
		initialAccountJTable(accountVOs);

		managerjTabbedPane.addTab("人员信息查看", accountjPanel);

	}

	/**
	 * 初始化机构管理面板
	 */
	private void initialInstitutionjPanel() {
		// TODO Auto-generated method stub
		institutionjPanel.setName("institutionManagement"); // NOI18N
		institutionjPanel.setPreferredSize(new java.awt.Dimension(830, 460));

		jLabel12.setText("机构编号：");

		institutionNumjTextField.setText("请输入机构编号（6位数字）");
		institutionNumjTextField
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						institutionNamejTextFieldMouseClicked(evt);
					}
				});

		findInstitutionNumjButton.setText("编号查找");
		findInstitutionNumjButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						findInstitutionNumjButtonActionPerformed(evt);
					}
				});

		jLabel13.setText("机构名称：");

		findInstitutionNamejTextField.setText("请输入机构的完整名称");
		findInstitutionNamejTextField
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						findInstitutionNamejTextFieldMouseClicked(evt);
					}
				});

		findInstitutionNamejButton.setText("名称查找");
		findInstitutionNamejButton.setToolTipText("");
		findInstitutionNamejButton
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseReleased(java.awt.event.MouseEvent evt) {
						findInstitutionNamejButtonMouseReleased(evt);
					}
				});

		jLabel15.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel15.setText("机构信息");
		jLabel15.setToolTipText("");

		initialInstitutionJTable(institutionVOPlus, 0);
		addInstitutionjButton.setText("添加新机构");
		addInstitutionjButton.setToolTipText("");
		addInstitutionjButton
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseReleased(java.awt.event.MouseEvent evt) {
						addInstitutionjButtonMouseReleased(evt);
					}
				});

		submitInstitutionjButton.setText("提交");
		submitInstitutionjButton.setToolTipText("");
		submitInstitutionjButton
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseReleased(java.awt.event.MouseEvent evt) {
						submitInstitutionjButtonMouseReleased(evt);
					}
				});

		managerjTabbedPane.addTab("机构管理", institutionjPanel);

	}

	/**
	 * 初始化审批单据面板
	 */
	private void initialCheckjPanel() {
		// TODO Auto-generated method stub
		checkjPane.setName("documentCheck"); // NOI18N
		checkjPane.setPreferredSize(new java.awt.Dimension(830, 460));

		jLabel16.setText("状态：");

		jLabel22.setText("jLabel13");

		jLabel23.setToolTipText("");

		jLabel29.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel29.setText("单据信息列表");

		initialCheckJTable();

		managerjTabbedPane.addTab("审批单据", checkjPane);

	}

	private void setAllLayout() {
		// TODO Auto-generated method stub
		javax.swing.GroupLayout checkjPaneLayout = new javax.swing.GroupLayout(
				checkjPane);
		checkjPane.setLayout(checkjPaneLayout);
		checkjPaneLayout
				.setHorizontalGroup(checkjPaneLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								checkjPaneLayout
										.createSequentialGroup()
										.addGroup(
												checkjPaneLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																checkjPaneLayout
																		.createSequentialGroup()
																		.addGap(41,
																				41,
																				41)
																		.addComponent(
																				jLabel22))
														.addGroup(
																checkjPaneLayout
																		.createSequentialGroup()
																		.addGap(194,
																				194,
																				194)
																		.addComponent(
																				jLabel23)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								checkjPaneLayout
										.createSequentialGroup()
										.addContainerGap(212, Short.MAX_VALUE)
										.addGroup(
												checkjPaneLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																checkjPaneLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel29)
																		.addGap(435,
																				435,
																				435))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																checkjPaneLayout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				562,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(192,
																				192,
																				192))))
						.addGroup(
								checkjPaneLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												checkjPaneLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(jLabel16)
														.addContainerGap(920,
																Short.MAX_VALUE))));
		checkjPaneLayout
				.setVerticalGroup(checkjPaneLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								checkjPaneLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel29)
										.addGap(18, 18, 18)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												377,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(513, 513, 513)
										.addComponent(jLabel23)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jLabel22))
						.addGroup(
								checkjPaneLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												checkjPaneLayout
														.createSequentialGroup()
														.addContainerGap(932,
																Short.MAX_VALUE)
														.addComponent(
																jLabel16,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																21,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(1, 1, 1))));

		javax.swing.GroupLayout salaryPolicyjPane1Layout = new javax.swing.GroupLayout(
				salaryPolicyjPane1);
		salaryPolicyjPane1.setLayout(salaryPolicyjPane1Layout);
		salaryPolicyjPane1Layout
				.setHorizontalGroup(salaryPolicyjPane1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								salaryPolicyjPane1Layout
										.createSequentialGroup()
										.addGap(453, 453, 453)
										.addComponent(salaryPolicyTitlejLabel)
										.addGap(197, 197, 197)
										.addComponent(
												jSeparator9,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(56, 56, 56)
										.addComponent(
												jSeparator8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(82, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								salaryPolicyjPane1Layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												salaryPolicyjPane1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																salaryPolicyjPane1Layout
																		.createSequentialGroup()
																		.addComponent(
																				addSalaryPolicyjButton)
																		.addGap(46,
																				46,
																				46)
																		.addComponent(
																				submitSalaryPolicyjButton)
																		.addGap(393,
																				393,
																				393))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																salaryPolicyjPane1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				743,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(106,
																				106,
																				106)))));
		salaryPolicyjPane1Layout
				.setVerticalGroup(salaryPolicyjPane1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								salaryPolicyjPane1Layout
										.createSequentialGroup()
										.addGroup(
												salaryPolicyjPane1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																salaryPolicyjPane1Layout
																		.createSequentialGroup()
																		.addContainerGap(
																				14,
																				Short.MAX_VALUE)
																		.addGroup(
																				salaryPolicyjPane1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jSeparator9,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jSeparator8,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(24,
																				24,
																				24))
														.addGroup(
																salaryPolicyjPane1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				salaryPolicyTitlejLabel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				25,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(
												jScrollPane5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												400,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												39, Short.MAX_VALUE)
										.addGroup(
												salaryPolicyjPane1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																submitSalaryPolicyjButton)
														.addComponent(
																addSalaryPolicyjButton))
										.addGap(19, 19, 19)));

		javax.swing.GroupLayout constjPanel1Layout = new javax.swing.GroupLayout(
				constjPanel);
		constjPanel.setLayout(constjPanel1Layout);
		constjPanel1Layout
				.setHorizontalGroup(constjPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								constjPanel1Layout
										.createSequentialGroup()
										.addContainerGap(112, Short.MAX_VALUE)
										.addGroup(
												constjPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																constjPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				addConstjButton)
																		.addGap(54,
																				54,
																				54)
																		.addComponent(
																				submitConstjButton)
																		.addGap(385,
																				385,
																				385))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																constjPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				constTitlejLabel)
																		.addGap(437,
																				437,
																				437))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																constjPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				765,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(89,
																				89,
																				89)))));
		constjPanel1Layout
				.setVerticalGroup(constjPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								constjPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(constTitlejLabel)
										.addGap(18, 18, 18)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												398,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												30, Short.MAX_VALUE)
										.addGroup(
												constjPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																submitConstjButton)
														.addComponent(
																addConstjButton))
										.addGap(27, 27, 27)));

		javax.swing.GroupLayout logjPanelLayout = new javax.swing.GroupLayout(
				logjPanel);
		logjPanel.setLayout(logjPanelLayout);
		logjPanelLayout
				.setHorizontalGroup(logjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								logjPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel36)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												logSYearjComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel37)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												logSMonthjComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel38)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												logSDatejComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel39)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												68, Short.MAX_VALUE)
										.addComponent(jLabel44)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												logEYearjComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel41)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												logjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																logjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel47)
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																logjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				logEMonthjComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel42)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				logEDatejComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel43)
																		.addGap(47,
																				47,
																				47)
																		.addComponent(
																				jLabel40)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				logTypejComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				68,
																				Short.MAX_VALUE)
																		.addComponent(
																				findLogjButton)
																		.addGap(60,
																				60,
																				60))))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								logjPanelLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												jScrollPane11,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												755,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(91, 91, 91))
						.addGroup(
								logjPanelLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												logjPanelLayout
														.createSequentialGroup()
														.addGap(0, 747,
																Short.MAX_VALUE)
														.addComponent(
																jSeparator7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																160,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(59, 59, 59))));
		logjPanelLayout
				.setVerticalGroup(logjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								logjPanelLayout
										.createSequentialGroup()
										.addContainerGap(20, Short.MAX_VALUE)
										.addGroup(
												logjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel36)
														.addComponent(jLabel37)
														.addComponent(jLabel38)
														.addComponent(jLabel39)
														.addComponent(
																logSYearjComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																logSMonthjComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																logSDatejComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel44)
														.addComponent(jLabel41)
														.addComponent(jLabel42)
														.addComponent(jLabel43)
														.addComponent(
																logEYearjComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																logEMonthjComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																logEDatejComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel40)
														.addComponent(
																logTypejComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																findLogjButton))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												15, Short.MAX_VALUE)
										.addComponent(jLabel47)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane11,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												384,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(54, 54, 54))
						.addGroup(
								logjPanelLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												logjPanelLayout
														.createSequentialGroup()
														.addContainerGap(314,
																Short.MAX_VALUE)
														.addComponent(
																jSeparator7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(205, 205, 205))));

		javax.swing.GroupLayout formjPanelLayout = new javax.swing.GroupLayout(
				formjPanel);
		formjPanel.setLayout(formjPanelLayout);
		formjPanelLayout
				.setHorizontalGroup(formjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								formjPanelLayout
										.createSequentialGroup()
										.addGroup(
												formjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																formjPanelLayout
																		.createSequentialGroup()
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel33)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				formEYearjComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel30)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				formEMonthjComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel31)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				formEDatejComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																formjPanelLayout
																		.createSequentialGroup()
																		.addGap(218,
																				218,
																				218)
																		.addComponent(
																				profitFormjButton)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				294,
																				Short.MAX_VALUE)))
										.addGroup(
												formjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																formjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel32)
																		.addGap(258,
																				258,
																				258)
																		.addComponent(
																				outputFormjButton))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																formjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				manageStateFormjButton)
																		.addGap(195,
																				195,
																				195)))
										.addContainerGap())
						.addGroup(
								formjPanelLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												formjPanelLayout
														.createSequentialGroup()
														.addGap(0, 801,
																Short.MAX_VALUE)
														.addGroup(
																formjPanelLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				formjPanelLayout
																						.createSequentialGroup()
																						.addComponent(
																								jSeparator5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								50,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(56,
																								56,
																								56)
																						.addComponent(
																								jSeparator2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								50,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addComponent(
																				jSeparator6,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				160,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(5, 5, 5))));
		formjPanelLayout
				.setVerticalGroup(formjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								formjPanelLayout
										.createSequentialGroup()
										.addGap(21, 21, 21)
										.addGroup(
												formjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel33)
														.addComponent(
																formEYearjComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																formEMonthjComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																formEDatejComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel31)
														.addComponent(jLabel30)
														.addComponent(jLabel32)
														.addComponent(
																outputFormjButton))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												345, Short.MAX_VALUE)
										.addGroup(
												formjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																profitFormjButton)
														.addComponent(
																manageStateFormjButton))
										.addGap(109, 109, 109))
						.addGroup(
								formjPanelLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												formjPanelLayout
														.createSequentialGroup()
														.addGap(31, 31, 31)
														.addGroup(
																formjPanelLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				jSeparator5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jSeparator2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																281,
																Short.MAX_VALUE)
														.addComponent(
																jSeparator6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(205, 205, 205))));

		javax.swing.GroupLayout accountjPanelLayout = new javax.swing.GroupLayout(
				accountjPanel);
		accountjPanel.setLayout(accountjPanelLayout);
		accountjPanelLayout
				.setHorizontalGroup(accountjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								accountjPanelLayout
										.createSequentialGroup()
										.addContainerGap(140, Short.MAX_VALUE)
										.addGroup(
												accountjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																accountjPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				accountjPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								accountjPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel11)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												accountNamejTextField,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												321,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												findAccountNamejButton))
																						.addGroup(
																								accountjPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel9)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												accountNumjTextField,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												321,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												findAccountNumjButton)))
																		.addGap(224,
																				224,
																				224))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																accountjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel19)
																		.addGap(450,
																				450,
																				450))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																accountjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane6,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				707,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(119,
																				119,
																				119)))));
		accountjPanelLayout
				.setVerticalGroup(accountjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								accountjPanelLayout
										.createSequentialGroup()
										.addGap(19, 19, 19)
										.addGroup(
												accountjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9)
														.addComponent(
																accountNumjTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																findAccountNumjButton))
										.addGap(17, 17, 17)
										.addGroup(
												accountjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel11)
														.addComponent(
																accountNamejTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																findAccountNamejButton))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabel19)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												394,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		javax.swing.GroupLayout institutionjPanelLayout = new javax.swing.GroupLayout(
				institutionjPanel);
		institutionjPanel.setLayout(institutionjPanelLayout);
		institutionjPanelLayout
				.setHorizontalGroup(institutionjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								institutionjPanelLayout
										.createSequentialGroup()
										.addGap(0, 252, Short.MAX_VALUE)
										.addGroup(
												institutionjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																institutionjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel12)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				institutionNumjTextField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				321,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				findInstitutionNumjButton))
														.addGroup(
																institutionjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel13)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				findInstitutionNamejTextField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				321,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				findInstitutionNamejButton)))
										.addGap(230, 230, 230))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								institutionjPanelLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												institutionjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																institutionjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel15)
																		.addGap(454,
																				454,
																				454))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																institutionjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane8,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				729,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(112,
																				112,
																				112))))
						.addGroup(
								institutionjPanelLayout.createSequentialGroup()
										.addGap(359, 359, 359)
										.addComponent(addInstitutionjButton)
										.addGap(75, 75, 75)
										.addComponent(submitInstitutionjButton)
										.addGap(0, 0, Short.MAX_VALUE)));
		institutionjPanelLayout
				.setVerticalGroup(institutionjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								institutionjPanelLayout
										.createSequentialGroup()
										.addGap(21, 21, 21)
										.addGroup(
												institutionjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel12)
														.addComponent(
																institutionNumjTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																findInstitutionNumjButton))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												institutionjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel13)
														.addComponent(
																findInstitutionNamejTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																findInstitutionNamejButton))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel15)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												352,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												institutionjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																addInstitutionjButton)
														.addComponent(
																submitInstitutionjButton))
										.addGap(0, 20, Short.MAX_VALUE)));

		javax.swing.GroupLayout managerjPanelLayout = new javax.swing.GroupLayout(
				managerjPanel);
		managerjPanel.setLayout(managerjPanelLayout);
		managerjPanelLayout
				.setHorizontalGroup(managerjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								managerjPanelLayout
										.createSequentialGroup()
										.addComponent(jLabel48)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												statejLabel,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								managerjPanelLayout
										.createSequentialGroup()
										.addGap(0, 471, Short.MAX_VALUE)
										.addGroup(
												managerjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																managerjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel6)
																		.addGap(464,
																				464,
																				464))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																managerjPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				currentAccountNamejLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				currentAuthorityjLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				currentAccoutNamejLabel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				32,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				exitjButton))))
						.addComponent(managerjTabbedPane,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE));
		managerjPanelLayout
				.setVerticalGroup(managerjPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								managerjPanelLayout
										.createSequentialGroup()
										.addComponent(
												jLabel6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												15,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												16, Short.MAX_VALUE)
										.addGroup(
												managerjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																currentAuthorityjLabel)
														.addComponent(
																currentAccountNamejLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																24,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																currentAccoutNamejLabel)
														.addComponent(
																exitjButton))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												managerjTabbedPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												550,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												managerjPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel48,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																21,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																statejLabel))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(managerjPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				managerjPanel, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		this.setLocationRelativeTo(null);

	}

	/**
	 * 初始化单据审批列表
	 */
	private void initialCheckJTable() {
		// TODO Auto-generated method stub
		assert (documents != null) : ("表格获得机构信息为空");
		Vector<String> colums = new Vector<String>();
		colums.add("日期");
		colums.add("编号");
		colums.add("单据类型");
		colums.add("通过审批");

		documentCheckjTable.setModel(new javax.swing.table.DefaultTableModel(
				documents, colums) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.Boolean.class };

			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		documentCheckjTable.setColumnSelectionAllowed(true);
		documentCheckjTable.setPreferredSize(new java.awt.Dimension(300, 630));
		documentCheckjTable.getTableHeader().setReorderingAllowed(false);

		documentCheckjTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				documentCheckjTableMouseClicked(evt);
			}

		});
		final JPopupMenu documentjPop = new JPopupMenu();
		final JMenuItem documentSubmitjItem = new JMenuItem("全部提交");
		documentSubmitjItem.addMouseListener(/**
		 * @author 1 监听document的弹出菜单中的“提交”
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
					// ResultMessage rmsg = null;
					// int n = documentCheckjTable.getSelectedRow();
					// Object vo = documents.get(n);
					// ModifyState state = vo.isModify;
					// DocumentVO v = getViewDocumentVO(n);
					// if (state == ModifyState.NEW) {
					// try {
					// rmsg = documentblController.insert(v);
					// setState(
					// "提交" + ResultMessage.toFriendlyString(rmsg),
					// DISPLAY_TIME);
					// if (rmsg == ResultMessage.SUCCESS) {
					// // documentVOPlus.remove(n);
					// // documentVOPlus.add(n, new DocumentVOPlus(
					// // v, ModifyState.SYNC));
					// setDocumentVOs();
					// initialDocumentJTable(documents, n);
					// }
					// } catch (RemoteException e1) {
					// // TODO Auto-generated catch block
					// e1.printStackTrace();
					// setState(REMOTEFAILD, DISPLAY_TIME);
					// }
					// } else {
					// if (v.equals(vo.getDocumentVO())) {
					// setState("您未对该行进行修改！", DISPLAY_TIME);
					// } else {
					// try {
					// rmsg = documentblController.update(v);
					// setState(ResultMessage.toFriendlyString(rmsg),
					// DISPLAY_TIME);
					// if (rmsg == ResultMessage.SUCCESS) {
					// documents.remove(n);
					// documents.add(n, new DocumentVOPlus(v,
					// ModifyState.SYNC));
					// }
					// } catch (RemoteException e1) {
					// // TODO Auto-generated catch block
					// e1.printStackTrace();
					// setState(REMOTEFAILD, DISPLAY_TIME);
					// }
					// }
					// }
					// }
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
		documentjPop.add(documentSubmitjItem);
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
					documentjPop.show(documentCheckjTable, e.getX(), e.getY());
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
					documentCheckjTable.dispatchEvent(ne);
				}
			}
		};
		documentCheckjTable.addMouseListener(mil);
		documentCheckjTable.putClientProperty("terminateEditOnFocusLost",
				Boolean.TRUE);

		ComponentFactory.setJTableTextCenter(documentCheckjTable);
		jScrollPane1.setViewportView(documentCheckjTable);
		documentCheckjTable
				.getColumnModel()
				.getSelectionModel()
				.setSelectionMode(
						javax.swing.ListSelectionModel.SINGLE_SELECTION);

	}

	private void documentCheckjTableMouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int column = documentCheckjTable.getSelectedColumn();
		if (e.getClickCount() == 1 && column == 3) {
			// TODO Auto-generated method stub
			if (e.getButton() == MouseEvent.BUTTON1) {
				int row =documentCheckjTable.getSelectedRow();
				// 代号、车牌号
				String num = (String) documentCheckjTable.getValueAt(row, 1);
				String repMsg = (String) documentCheckjTable.getValueAt(row, 2);
				Rep rep = Rep.getRep(repMsg);
				if (num != null && rep != null) {
					try {
						documentCheckbl.submitSaveRep(num, rep);
						documents.remove(row);

						documentCheckjTable.repaint();
						documentCheckjTable.updateUI();

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						ComponentFactory.setState("程序错误",
								ComponentFactory.DISPLAY_TIME, statejLabel);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						ComponentFactory.setState(ComponentFactory.REMOTEFAILD,
								ComponentFactory.DISPLAY_TIME, statejLabel);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						ComponentFactory.setState("程序错误",
								ComponentFactory.DISPLAY_TIME, statejLabel);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						ComponentFactory.setState("读写文件错误",
								ComponentFactory.DISPLAY_TIME, statejLabel);
					} catch (NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						ComponentFactory.setState("数据越界",
								ComponentFactory.DISPLAY_TIME, statejLabel);
					}
				}
				// 点了删除

			}
		}
	}

	/**
	 * 初始化薪水策略面板
	 */
	private void initialSalayPolicyjPanel() {
		// TODO Auto-generated method stub
		submitSalaryPolicyjButton.setText("提交");
		submitSalaryPolicyjButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						submitSalaryPolicyjButtonActionPerformed(evt);
					}
				});

		initialSalaryPolicyJTable(salaryPolicyVOPlus, 0);

		addSalaryPolicyjButton.setText("添加薪水策略");
		addSalaryPolicyjButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						addSalaryPolicyjButtonActionPerformed(evt);
					}
				});

		salaryPolicyTitlejLabel.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		salaryPolicyTitlejLabel.setText("薪水策略列表");

		managerjTabbedPane.addTab("薪水策略", salaryPolicyjPane1);

	}

	/**
	 * 初始化常量制定面板
	 */
	private void initialConstjPanel() {
		// TODO Auto-generated method stub
		addConstjButton.setText("添加距离常量");
		addConstjButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				addConstjButton1MouseReleased(evt);
			}
		});

		submitConstjButton.setText("提交");
		submitConstjButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						submitConstjButtonActionPerformed(evt);
					}
				});
		initialConstJTable(constVOPlus);
		jScrollPane2.setViewportView(constjTable);
		accountjTable.getTableHeader().setReorderingAllowed(false);
		jScrollPane6.setViewportView(accountjTable);

		constTitlejLabel.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		constTitlejLabel.setText("距离常量列表");

		managerjTabbedPane.addTab("距离常量", constjPanel);

		jButton6.setText("jButton1");

	}

	private void addConstjButton1ActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addConstjButton) {
			constVOPlus.add(new ConstVOPlus("-", 0, 0, ModifyState.NEW));
			initialConstJTable(constVOPlus);
		}
	}

	private void initialVariables() {
		// TODO Auto-generated method stub
		// 增加变量
		sexjComboBox = new JComboBox<Sex>();
		sexjComboBox.addItem(Sex.Sex_MALE);
		sexjComboBox.addItem(Sex.Sex_FAMALE);

		authorityjComboBox = ComponentFactory.getAuthorityJComboBox();
		repjComboBox = ComponentFactory.getRepJComboBox();

		salaryPolicyjComboBox = new JComboBox<SalaryPolicy>();
		SalaryPolicy salaryPolicy = null;
		for (int i = 0; i < SalaryPolicy.SALARYPOLICY_NUM; i++) {
			salaryPolicy = null;
			salaryPolicy = SalaryPolicy.getSalaryPolicy(i);
			if (salaryPolicy != null) {
				salaryPolicyjComboBox.addItem(salaryPolicy);
			}
		}

		managerjPanel = new javax.swing.JPanel();
		managerjTabbedPane = new javax.swing.JTabbedPane();
		constjPanel = new javax.swing.JPanel();
		jButton3 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		addConstjButton = new javax.swing.JButton();
		submitConstjButton = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		// try {
		// constjTable = (javax.swing.JTable) java.beans.Beans.instantiate(
		// getClass().getClassLoader(),
		// "ui/managerui.ManagerJFrame_constjTable1");
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// } catch (java.io.IOException e) {
		// e.printStackTrace();
		// }
		constjTable = new JTable();
		constTitlejLabel = new javax.swing.JLabel();
		salaryPolicyjPane1 = new javax.swing.JPanel();
		jSeparator8 = new javax.swing.JSeparator();
		jSeparator9 = new javax.swing.JSeparator();
		jButton6 = new javax.swing.JButton();
		submitSalaryPolicyjButton = new javax.swing.JButton();
		jScrollPane5 = new javax.swing.JScrollPane();
		salaryPolicyjTable = new javax.swing.JTable();
		addSalaryPolicyjButton = new javax.swing.JButton();
		salaryPolicyTitlejLabel = new javax.swing.JLabel();
		checkjPane = new javax.swing.JPanel();
		jLabel16 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel29 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		documentCheckjTable = new javax.swing.JTable();
		institutionjPanel = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		institutionNumjTextField = new javax.swing.JTextField();
		findInstitutionNumjButton = new javax.swing.JButton();
		jLabel13 = new javax.swing.JLabel();
		findInstitutionNamejTextField = new javax.swing.JTextField();
		findInstitutionNamejButton = new javax.swing.JButton();
		jLabel15 = new javax.swing.JLabel();
		jScrollPane8 = new javax.swing.JScrollPane();
		institutionjTable = new javax.swing.JTable();
		addInstitutionjButton = new javax.swing.JButton();
		submitInstitutionjButton = new javax.swing.JButton();
		accountjPanel = new javax.swing.JPanel();
		jLabel19 = new javax.swing.JLabel();
		accountNamejTextField = new javax.swing.JTextField();
		findAccountNamejButton = new javax.swing.JButton();
		jLabel9 = new javax.swing.JLabel();
		accountNumjTextField = new javax.swing.JTextField();
		findAccountNumjButton = new javax.swing.JButton();
		jLabel11 = new javax.swing.JLabel();
		jScrollPane6 = new javax.swing.JScrollPane();
		accountjTable = new javax.swing.JTable();
		formjPanel = new javax.swing.JPanel();
		profitFormjButton = new javax.swing.JButton();
		manageStateFormjButton = new javax.swing.JButton();
		jLabel30 = new javax.swing.JLabel();
		jLabel31 = new javax.swing.JLabel();
		jLabel32 = new javax.swing.JLabel();
		formEYearjComboBox = new javax.swing.JComboBox();
		formEDatejComboBox = new javax.swing.JComboBox();
		formEMonthjComboBox = new javax.swing.JComboBox();
		jLabel33 = new javax.swing.JLabel();
		outputFormjButton = new javax.swing.JButton();
		jSeparator5 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		jSeparator6 = new javax.swing.JSeparator();
		logjPanel = new javax.swing.JPanel();
		findLogjButton = new javax.swing.JButton();
		jLabel36 = new javax.swing.JLabel();
		jLabel37 = new javax.swing.JLabel();
		jLabel38 = new javax.swing.JLabel();
		jLabel39 = new javax.swing.JLabel();
		jLabel40 = new javax.swing.JLabel();
		logTypejComboBox = ComponentFactory.getLogTypeJComboBox();

		logTypejComboBox.setEditable(false);

		logSYearjComboBox = ComponentFactory.getYearJComboBox(2015, 2050);
		logSDatejComboBox = ComponentFactory.getDayJComboBox();
		logSMonthjComboBox = ComponentFactory.getMonthJComboBox();
		jLabel41 = new javax.swing.JLabel();
		jLabel42 = new javax.swing.JLabel();
		jLabel43 = new javax.swing.JLabel();
		logEYearjComboBox = ComponentFactory.getYearJComboBox(2015, 2050);
		logEDatejComboBox = ComponentFactory.getDayJComboBox();
		logEMonthjComboBox = ComponentFactory.getMonthJComboBox();
		jLabel44 = new javax.swing.JLabel();
		jSeparator7 = new javax.swing.JSeparator();
		jLabel47 = new javax.swing.JLabel();
		jScrollPane11 = new javax.swing.JScrollPane();
		logjTable = new javax.swing.JTable();
		jLabel6 = new javax.swing.JLabel();
		currentAccountNamejLabel = new javax.swing.JLabel();
		currentAuthorityjLabel = new javax.swing.JLabel();
		currentAccoutNamejLabel = new javax.swing.JLabel();
		jLabel48 = new javax.swing.JLabel();
		statejLabel = new javax.swing.JLabel();
		exitjButton = new javax.swing.JButton();
		viewChecked = new JButton();

	}

	private void findAccountNumjButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_findAccountNumjButtonActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_findAccountNumjButtonActionPerformed

	private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox2ActionPerformed

	private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox3ActionPerformed

	private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox4ActionPerformed

	private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox5ActionPerformed

	private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox6ActionPerformed

	private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox7ActionPerformed

	private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox8ActionPerformed

	private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox9ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox9ActionPerformed

	private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox10ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox10ActionPerformed

	private void findLogjButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_findLogjButtonActionPerformed
		// GEN-FIRST:event_findLogjButtonMouseReleased
		if (evt.getSource() == findLogjButton) {
			String startT = logSYearjComboBox.getSelectedItem() + "-"
					+ logSMonthjComboBox.getSelectedItem() + "-"
					+ logSDatejComboBox.getSelectedItem();
			String endT = logEYearjComboBox.getSelectedItem() + "-"
					+ logEMonthjComboBox.getSelectedItem() + "-"
					+ logEDatejComboBox.getSelectedItem();
			if (startT.compareTo(endT) <= 0) {
				LogType type = (LogType) logTypejComboBox.getSelectedItem();
				logVOs = logblController.show(startT, endT, type);
				if (logVOs != null) {
					if (logVOs.size() == 0) {
						ComponentFactory.setState("该时间段无日志",
								ComponentFactory.DISPLAY_TIME, statejLabel);
					} else {
						setLogVOs(startT, endT, type);
						initialLogJTable(logVOs);
					}
				} else {
					ComponentFactory.setState("系统程序错误",
							ComponentFactory.DISPLAY_TIME, statejLabel);
				}

			} else {
				ComponentFactory.setState("截止日期早于开始日期",
						ComponentFactory.DISPLAY_TIME, statejLabel);
			}
		}
		// TODO add your handling code here:
	}// GEN-LAST:event_findLogjButtonActionPerformed

	private void logTypejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logTypejComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_logTypejComboBoxActionPerformed

	private void logSMonthjComboBoxActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logSMonthjComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_logSMonthjComboBoxActionPerformed

	private void logEYearjComboBox1ActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logEYearjComboBox1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_logEYearjComboBox1ActionPerformed

	private void profitFormjButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_profitFormjButtonActionPerformed
		// TODO add your handling code here:
		new ProfitForm();
	}// GEN-LAST:event_profitFormjButtonActionPerformed

	private void formEDatejComboBoxActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_formEDatejComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_formEDatejComboBoxActionPerformed

	private void formEMonthjComboBoxActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_formEMonthjComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_formEMonthjComboBoxActionPerformed

	private void submitSalaryPolicyjButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addSalaryPolicyjButton1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_addSalaryPolicyjButton1ActionPerformed

	/**
	 * findAccountNumJButton的监听方法 查找输入的accountnum
	 * 
	 * @param evt
	 */
	private void findAccountNumjButtonMouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_findAccountNumjButtonMouseReleased
		// TODO add your handling code here:
		if (evt.getSource() == findAccountNamejButton) {
			String findAccountNum = accountNumjTextField.getText();
			ResultMessage rmsg = InputCheck.checkInputNum(findAccountNum, 11);
			if (rmsg == ResultMessage.VALID) {
				int i = 0;
				AccountVO tempVO = null;
				for (Iterator<AccountVO> t = accountVOs.iterator(); t.hasNext(); i++) {
					tempVO = t.next();
					if (tempVO.accountNum.equals(findAccountNum)) {
						break;
					}
				}
				if (i < accountVOs.size()) {
					accountjTable.setRowSelectionInterval(i, i);// 设置哪几行被选中
					setState("该账户在第" + (i + 1) + "行", DISPLAY_TIME);
				} else {
					setState("系统中无该机构", DISPLAY_TIME);
				}
			} else {
				String msg = ResultMessage.toFriendlyString(rmsg);
				setState("账号" + msg, ComponentFactory.DISPLAY_TIME);
			}

		}

	}// GEN-LAST:event_findAccountNumjButtonMouseReleased

	/**
	 * findAccountnum
	 * 
	 * @param evt
	 */
	private void findAccountNamejButtonMouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_findAccountNamejButtonMouseReleased
		// TODO add your handling code here:
		if (evt.getSource() == findAccountNamejButton) {
			String findAccountName = accountNamejTextField.getText();
			ResultMessage rmsg = InputCheck.checkInputName(findAccountName);
			if (rmsg == ResultMessage.VALID) {
				int i = 0;
				AccountVO tempVO = null;
				for (Iterator<AccountVO> t = accountVOs.iterator(); t.hasNext(); i++) {
					tempVO = t.next();
					if (tempVO.accountName.equals(findAccountName)) {
						break;
					}
				}
				if (i < accountVOs.size()) {
					accountjTable.setRowSelectionInterval(i, i);// 设置哪几行被选中
					setState("该账户在第" + (i + 1) + "行", 5);
				} else {
					setState("系统中无该账户", DISPLAY_TIME);
				}
			} else {
				String msg = ResultMessage.toFriendlyString(rmsg);
				setState("账户名称" + msg, DISPLAY_TIME);
			}
		}

	}// GEN-LAST:event_findAccountNamejButtonMouseReleased

	private void accountNumjTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_accountNumjTextFieldActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_accountNumjTextFieldActionPerformed

	private void accountNumjTextFieldMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_accountNumjTextFieldMouseClicked
		// TODO add your handling code here:
		accountNumjTextField.setText("");
	}// GEN-LAST:event_accountNumjTextFieldMouseClicked

	private void accountNamejTextFieldMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_accountNamejTextFieldMouseClicked
		// TODO add your handling code here:
		accountNamejTextField.setText("");
	}// GEN-LAST:event_accountNamejTextFieldMouseClicked

	private void logEDatejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logEDatejComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_logEDatejComboBoxActionPerformed

	private void logEYearjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logEYearjComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_logEYearjComboBoxActionPerformed

	private void logSDatejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logSDatejComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_logSDatejComboBoxActionPerformed

	private void logSYearjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logSYearjComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_logSYearjComboBoxActionPerformed

	private void formEYearjComboBoxActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_formEYearjComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_formEYearjComboBoxActionPerformed

	private void outputFormjButtonMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_outputFormjButtonMouseReleased
		// TODO add your handling code here:
	}// GEN-LAST:event_outputFormjButtonMouseReleased

	private void manageStateFormjButton1MouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_manageStateFormjButton1MouseReleased
		// TODO add your handling code here:
		new BusinessForm();
	}// GEN-LAST:event_manageStateFormjButton1MouseReleased

	private void submitInstitutionjButtonMouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_submitInstitutionjButtonMouseReleased
		// TODO add your handling code here:
	}// GEN-LAST:event_submitInstitutionjButtonMouseReleased

	private void addInstitutionjButtonMouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addInstitutionjButton2ActionPerformed
		// TODO add your handling code here:
		if (evt.getSource() == addInstitutionjButton) {
			// 编号应为城市代号+000
			institutionVOPlus.add(new InstitutionVOPlus("025000", "", "", "",
					"", ModifyState.NEW));
			initialInstitutionJTable(institutionVOPlus,
					institutionVOPlus.size() - 1);
		}
	}// GEN-LAST:event_addInstitutionjButtonMouseReleased

	private void findInstitutionNamejButtonMouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_findInstitutionNamejButtonMouseReleased
		// TODO add your handling code here:
		if (evt.getSource() == findInstitutionNamejButton) {
			String findInstitutionName = findInstitutionNamejTextField
					.getText();
			ResultMessage rmsg = InputCheck.checkInputName(findInstitutionName);
			if (rmsg == ResultMessage.VALID) {
				int i = 0;
				InstitutionVO tempVO = null;
				for (Iterator<InstitutionVOPlus> t = institutionVOPlus
						.iterator(); t.hasNext(); i++) {
					tempVO = t.next();
					if (tempVO.institutionName.equals(findInstitutionName)) {
						break;
					}
				}
				if (i < institutionVOPlus.size()) {
					institutionjTable.setRowSelectionInterval(i, i);// 设置哪几行被选中
					setState("该账户在第" + (i + 1) + "行", 5);
				} else {
					setState("系统中无该机构", 5);
				}
			} else {
				String msg = ResultMessage.toFriendlyString(rmsg);
				setState("机构" + msg, 5);
			}
		}

	}// GEN-LAST:event_findInstitutionNamejButtonMouseReleased

	private void findInstitutionNamejTextFieldMouseClicked(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTextField4MouseClicked
		// TODO add your handling code here:
		findInstitutionNamejTextField.setText("");
	}// GEN-LAST:event_jTextField4MouseClicked

	private void findInstitutionNumjButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_findInstitutionNumjButtonMouseReleased
		// TODO add your handling code here:
		if (evt.getSource() == findInstitutionNumjButton) {
			String findInstitutionNum = institutionNumjTextField.getText();
			ResultMessage rmsg = InputCheck
					.checkInputNum(findInstitutionNum, 6);
			if (rmsg == ResultMessage.VALID) {
				int i = 0;
				InstitutionVO tempVO = null;
				for (Iterator<InstitutionVOPlus> t = institutionVOPlus
						.iterator(); t.hasNext(); i++) {
					tempVO = t.next();
					if (tempVO.institutionNum.equals(findInstitutionNum)) {
						break;
					}
				}
				if (i < institutionVOPlus.size()) {
					institutionjTable.setRowSelectionInterval(i, i);// 设置哪几行被选中
					setState("该账户在第" + (i + 1) + "行", 5);
				} else {
					setState("系统中无该机构", 5);
				}
			} else {
				String msg = ResultMessage.toFriendlyString(rmsg);
				setState("机构" + msg, 5);
			}
		}

	}// GEN-LAST:event_findInstitutioNamejButtonActionPerformed

	private void institutionNamejTextFieldMouseClicked(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_institutionNamejTextFieldMouseClicked
		// TODO add your handling code here:
		institutionNumjTextField.setText("");
	}// GEN-LAST:event_institutionNamejTextFieldMouseClicked

	private void submitConstjButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_submitConstjButtonActionPerformed
		// TODO add your handling code here:
		// if (evt.getSource() == submitConstjButton) {
		// ConstVOPlus voplus = null;
		// boolean needSubmit = false;
		// ResultMessage rmsg = null;
		// for (Iterator<ConstVOPlus> t = constVOPlus.iterator(); t.hasNext();)
		// {
		// voplus = t.next();
		// rmsg = null;
		// if (voplus.isModify == ModifyState.CHANGED) {
		// needSubmit = true;
		// try {
		// rmsg = constblController.update(voplus.getConstVO());
		// } catch (RemoteException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// setState("远程连接错误", DISPLAY_TIME);
		// }
		// } else if (voplus.isModify == ModifyState.NEW) {
		// needSubmit = true;
		// try {
		// rmsg = constblController.insert(voplus.getConstVO());
		// if (rmsg == ResultMessage.OVERRIDE_DATA) {
		// Object[] options = { "取消", "覆盖" };
		// int result = JOptionPane.showOptionDialog(null,
		// "您确定要覆盖" + voplus.twoCities + "的数据？",
		// "是否覆数据", JOptionPane.DEFAULT_OPTION,
		// JOptionPane.QUESTION_MESSAGE, null,
		// options, options[0]);
		// if (result == JOptionPane.NO_OPTION) {
		// rmsg = constblController.update(voplus
		// .getConstVO());
		// }
		// }
		// } catch (RemoteException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// setState(ResultMessage.toFriendlyString(rmsg), DISPLAY_TIME);
		// }
		// if (needSubmit == false) {
		// setState("您未修改或新增，不需要提交", DISPLAY_TIME);
		// }
		// }
	}// GEN-LAST:event_submitConstjButtonActionPerformed

	/**
	 * 监听添加薪水策略按钮
	 * 
	 * @param evt
	 */
	private void addSalaryPolicyjButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addSalaryPolicyjButton2ActionPerformed
		// TODO add your handling code here:
		if (evt.getSource() == addSalaryPolicyjButton) {
			salaryPolicyVOPlus.add(new SalaryPolicyVOPlus(Authority.MANAGER,
					SalaryPolicy.BASE_SALARY, 0, ModifyState.NEW));
			initialSalaryPolicyJTable(salaryPolicyVOPlus,
					salaryPolicyVOPlus.size() - 1);
		}
	}// GEN-LAST:event_addSalaryPolicyjButton2ActionPerformed

	/**
	 * 监听“添加常量按钮”
	 * 
	 * @param evt
	 */
	private void addConstjButton1MouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addConstjButton1MouseReleased
		// TODO add your handling code here:
		if (evt.getSource() == addConstjButton) {
			constVOPlus.add(new ConstVOPlus("-", 0, 0, ModifyState.NEW));
			initialConstJTable(constVOPlus);
		}
	}// GEN-LAST:event_addConstjButton1MouseReleased

	// 其他方法
	/**
	 * 从服务器获得Account数据
	 * 
	 * @return
	 */
	private ArrayList<AccountVO> getAccountVOs() {
		ArrayList<AccountVO> vos = null;
		try {
			vos = accountblController.show();
			vos.sort(null);
			System.out.println(vos.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接失败");
			setState("远程连接失败", DISPLAY_TIME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("程序错误");
			setState("程序错误", DISPLAY_TIME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
			setState("读取文件失败", DISPLAY_TIME);
		}

		assert (vos != null) : ("远程获取账户信息失败");
		return vos;
	}

	/**
	 * 获得
	 * 
	 * @return
	 */
	private ArrayList<LogVO> getLogVOs(String startTime, String endTime,
			LogType type) {
		ArrayList<LogVO> vos = null;
		vos = logblController.show(startTime, endTime, type);
		assert (vos != null) : ("远程获取账户信息失败");
		vos.sort(null);
		assert (vos != null) : ("获取日志失败");
		return vos;
	}

	/**
	 * 从服务器获得salarypolicy数据
	 * 
	 * @return
	 */
	private ArrayList<SalaryPolicyVO> getSalaryPolicyVOs() {
		// TODO Auto-generated method stub
		ArrayList<SalaryPolicyVO> vos = null;
		try {
			vos = salaryPolicyblController.show();
			if (vos != null) {
				vos.sort(null);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接失败");
			setState("远程连接失败", DISPLAY_TIME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("程序错误");
			setState("程序错误", DISPLAY_TIME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
			setState("读取文件失败", DISPLAY_TIME);
		}
		assert (vos != null) : ("远程获取常量信息失败");
		return vos;
	}

	/**
	 * 从服务器获得Institution数据
	 * 
	 * @return
	 */
	private ArrayList<InstitutionVO> getInstitutionVOs() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		ArrayList<InstitutionVO> vos = null;
		try {
			vos = institutionblController.show();
			if (vos != null) {
				vos.sort(null);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接失败");
			setState("远程连接失败", DISPLAY_TIME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("程序错误");
			setState("程序错误", DISPLAY_TIME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
			setState("读取文件失败", DISPLAY_TIME);
		}
		assert (vos != null) : ("远程获取常量信息失败");
		return vos;

	}

	/**
	 * 从服务器获得const数据
	 * 
	 * @return
	 */
	private ArrayList<ConstVO> getConstVOs() {
		// TODO Auto-generated method stub
		ArrayList<ConstVO> vos = null;
		try {
			System.out.println(constblController.getClass().getName());
			vos = constblController.show();
			if (vos != null) {
				vos.sort(null);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接失败");
			setState("远程连接失败", DISPLAY_TIME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("程序错误");
			setState("程序错误", DISPLAY_TIME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
			setState("读取文件失败", DISPLAY_TIME);
		}
		assert (vos != null) : ("远程获取常量信息失败");
		return vos;
	}

	/**
	 * 初始化AccountJTable
	 */
	private void initialAccountJTable(ArrayList<AccountVO> vos) {
		assert (vos != null) : ("表格获得的账户信息为空");
		Object[][] accountObjects = null;
		accountObjects = new Object[vos.size()][6];
		int i = 0;
		for (java.util.Iterator<AccountVO> t = vos.iterator(); t.hasNext();) {
			AccountVO vo = t.next();
			accountObjects[i][0] = vo.accountNum;
			accountObjects[i][1] = vo.accountName;
			accountObjects[i][2] = sexjComboBox.getItemAt(Sex.toNum(vo.sex));
			accountObjects[i][3] = Authority.toString(vo.authority);
			accountObjects[i][4] = vo.institutionNum;
			accountObjects[i][5] = vo.phoneNum;
			i++;
		}
		accountjTable.setModel(new javax.swing.table.DefaultTableModel(
				accountObjects, new String[] { "用户账号", "姓名", "性别", "职位",
						"机构编号", "电话" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, JComboBox.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		accountjTable.getColumnModel().getColumn(2)
				.setCellEditor(new DefaultCellEditor(sexjComboBox));

		((DefaultTableCellRenderer) accountjTable.getTableHeader()
				.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// 设置表头居中
		accountjTable.setRowSelectionInterval(0, 0);// 设置哪几行被选中

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容-11
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 设置table内容居中-2
		accountjTable.setDefaultRenderer(Object.class, tcr);
	}

	/**
	 * 初始化薪水策略表
	 * 
	 * @param vos
	 * @param n
	 *            初始化后被选中的行
	 */
	private void initialSalaryPolicyJTable(ArrayList<SalaryPolicyVOPlus> vos,
			int n) {
		// TODO Auto-generated method stub
		assert (vos != null) : ("表格获得的薪水策略信息为空");

		authorityjComboBox.setEditable(false);

		Object[][] salaryPolicyObjects = null;
		salaryPolicyObjects = new Object[vos.size()][3];
		int i = 0;
		for (java.util.Iterator<SalaryPolicyVOPlus> t = vos.iterator(); t
				.hasNext(); i++) {
			SalaryPolicyVOPlus voplus = t.next();
			SalaryPolicyVO vo = voplus.getSalaryPolicyVO();
			if (vo != null && vo.salaryPolicy != null
					&& authorityjComboBox != null) {
				salaryPolicyObjects[i][0] = authorityjComboBox
						.getItemAt(vo.salaryPolicy.getIndex());
				salaryPolicyObjects[i][1] = salaryPolicyjComboBox
						.getItemAt(vo.salaryPolicy.getIndex());
				salaryPolicyObjects[i][2] = vo.value;
			} else {
				System.out.println("2519错误！");
			}
		}

		salaryPolicyjTable.setModel(new javax.swing.table.DefaultTableModel(
				salaryPolicyObjects, new String[] { "职位", "薪水策略", "内容" }) {
			Class[] types = new Class[] { JComboBox.class, JComboBox.class,
					java.lang.Double.class };
			boolean[] canEdit = new boolean[] { true, true, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		// 添加jcombobox
		salaryPolicyjTable.getColumnModel().getColumn(0)
				.setCellEditor(new DefaultCellEditor(authorityjComboBox));
		salaryPolicyjTable.getColumnModel().getColumn(1)
				.setCellEditor(new DefaultCellEditor(salaryPolicyjComboBox));

		salaryPolicyjTable.setGridColor(new java.awt.Color(0, 0, 0));
		salaryPolicyjTable.setPreferredSize(new java.awt.Dimension(300, 630));
		salaryPolicyjTable.getTableHeader().setReorderingAllowed(false);
		jScrollPane5.setViewportView(salaryPolicyjTable);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		salaryPolicyjTable.setDefaultRenderer(Object.class, tcr);

		((DefaultTableCellRenderer) salaryPolicyjTable.getTableHeader()
				.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// 设置表头居中
		salaryPolicyjTable.setRowSelectionInterval(n, n);// 设置哪几行被选中
		final JPopupMenu salaryPolicyjPop = new JPopupMenu();
		final JMenuItem salaryPolicySubmitjItem = new JMenuItem("提交");
		final JMenuItem salaryPolicyDeljItem = new JMenuItem("删除");
		salaryPolicySubmitjItem.addMouseListener(/**
		 * @author 1
		 *         监听salaryPolicy的弹出菜单中的“提交”
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
					int n = salaryPolicyjTable.getSelectedRow();
					SalaryPolicyVOPlus voPlus = salaryPolicyVOPlus.get(n);
					ModifyState state = voPlus.isModify;
					SalaryPolicyVO v = getViewSalaryPolicyVO(n);
					if (state == ModifyState.NEW) {
						try {
							rmsg = salaryPolicyblController.insert(v);
							setState(
									"提交" + ResultMessage.toFriendlyString(rmsg),
									DISPLAY_TIME);
							if (rmsg == ResultMessage.SUCCESS) {
								salaryPolicyVOPlus.remove(n);
								salaryPolicyVOPlus.add(n,
										new SalaryPolicyVOPlus(v,
												ModifyState.SYNC));
							}
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							setState(REMOTEFAILD, DISPLAY_TIME);
						}
					} else {
						if (v.equals(voPlus.getSalaryPolicyVO())) {
							setState("您未对该行进行修改！", DISPLAY_TIME);
						} else {
							try {
								rmsg = salaryPolicyblController.update(v);
								setState(ResultMessage.toFriendlyString(rmsg),
										DISPLAY_TIME);
								if (rmsg == ResultMessage.SUCCESS) {
									salaryPolicyVOPlus.remove(n);
									salaryPolicyVOPlus.add(n,
											new SalaryPolicyVOPlus(v,
													ModifyState.SYNC));
								}
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								setState(REMOTEFAILD, DISPLAY_TIME);
							}
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
		salaryPolicyDeljItem.addMouseListener(/**
		 * @author 1
		 *         监听SalaryPolicyjTable上弹出菜单的“删除”
		 */
		new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					int tempN = 0;
					ResultMessage rmsg = null;
					int n = salaryPolicyjTable.getSelectedRow();
					SalaryPolicyVOPlus voPlus = salaryPolicyVOPlus.get(n);
					ModifyState state = voPlus.isModify;
					if (state == ModifyState.NEW) {
						salaryPolicyVOPlus.remove(n);
						if (n == 0) {
							tempN = 0;
						} else {
							tempN = n - 1;
						}
						initialSalaryPolicyJTable(salaryPolicyVOPlus, tempN);
					} else {
						Object[] options = { "取消", "删除" };
						int result = JOptionPane.showOptionDialog(null,
								"您确定要删除系统该薪水策略？", "是否删除",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);
						if (result == JOptionPane.NO_OPTION) {
							try {
								rmsg = salaryPolicyblController.delete(voPlus
										.getSalaryPolicyVO());
								if (rmsg == ResultMessage.SUCCESS) {
									setState("删除成功:)", DISPLAY_TIME);
									salaryPolicyVOPlus.remove(n);
									tempN = 0;
									if (n == 0) {
										tempN = 0;
									} else {
										tempN = n - 1;
									}
									initialSalaryPolicyJTable(
											salaryPolicyVOPlus, tempN);
								} else {
									setState(ResultMessage
											.toFriendlyString(rmsg),
											DISPLAY_TIME);
								}
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								setState(REMOTEFAILD, DISPLAY_TIME);
							}
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
		salaryPolicyjPop.add(salaryPolicySubmitjItem);
		salaryPolicyjPop.add(salaryPolicyDeljItem);
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
					salaryPolicyjPop.show(salaryPolicyjTable, e.getX(),
							e.getY());
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
					salaryPolicyjTable.dispatchEvent(ne);
				}
			}
		};
		salaryPolicyjTable.addMouseListener(mil);
		salaryPolicyjTable.putClientProperty("terminateEditOnFocusLost",
				Boolean.TRUE);

	}

	/**
	 * 初始化常量表
	 * 
	 * @param vos
	 */
	private void initialConstJTable(ArrayList<ConstVOPlus> vos) {
		constjTable.setGridColor(new java.awt.Color(0, 0, 0));
		constjTable.getTableHeader().setReorderingAllowed(false);
		jScrollPane2.setViewportView(constjTable);

		assert (vos != null) : ("表格获得的常量信息为空");
		Object[][] constObjects = null;
		constObjects = new Object[vos.size()][4];
		int i = 0;
		String[] str = new String[2];
		for (java.util.Iterator<ConstVOPlus> t = vos.iterator(); t.hasNext(); i++) {
			ConstVO vo = t.next();
			if (vo.twoCities.length() <= 1) {
				constObjects[i][0] = "";
				constObjects[i][1] = "";
			} else {
				str = vo.twoCities.split("-");
				constObjects[i][0] = str[0];
				constObjects[i][1] = str[1];
			}
			constObjects[i][2] = vo.distanceConst;
			constObjects[i][3] = vo.priceConst;

		}

		TableModel constTableModel = new javax.swing.table.DefaultTableModel(
				constObjects, new String[] { "城市一", "城市二", "距离(千米)",
						"单价(元/(千千米*公斤））" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Double.class,
					java.lang.Double.class };
			boolean[] canEdit = new boolean[] { true, true, true, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};
		constjTable.setModel(constTableModel);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		constjTable.setDefaultRenderer(Object.class, tcr);

		((DefaultTableCellRenderer) constjTable.getTableHeader()
				.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// 设置表头居中
		final JPopupMenu constjPop = new JPopupMenu();
		final JMenuItem constSubmitjItem = new JMenuItem("提交");
		final JMenuItem constDeljItem = new JMenuItem("删除");
		constSubmitjItem.addMouseListener(new MouseListener() {

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
					int n = constjTable.getSelectedRow();
					ConstVOPlus voPlus = constVOPlus.get(n);
					ModifyState state = voPlus.isModify;
					ConstVO v = getViewConstVO(n);
					if (state == ModifyState.NEW) {
						try {
							rmsg = constblController.insert(v);
							setState(ResultMessage.toFriendlyString(rmsg),
									DISPLAY_TIME);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							setState(REMOTEFAILD, DISPLAY_TIME);
						}
						constVOPlus.remove(n);
						constVOPlus
								.add(n, new ConstVOPlus(v, ModifyState.SYNC));
					} else {
						if (v.equals(voPlus.getConstVO())) {
							setState("您未进行修改！", DISPLAY_TIME);
						} else {
							try {
								rmsg = constblController.update(v);
								setState(ResultMessage.toFriendlyString(rmsg),
										DISPLAY_TIME);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								setState(REMOTEFAILD, DISPLAY_TIME);
							}
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
		constDeljItem.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					int n = constjTable.getSelectedRow();
					ConstVOPlus voPlus = constVOPlus.get(n);
					ModifyState state = voPlus.isModify;
					if (state == ModifyState.NEW) {
						constVOPlus.remove(n);
						initialConstJTable(constVOPlus);
					} else {
						Object[] options = { "取消", "删除" };
						int result = JOptionPane.showOptionDialog(null,
								"您确定要删除系统该常量？", "是否删除",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);
						if (result == JOptionPane.NO_OPTION) {
							try {
								ResultMessage rmsg = constblController
										.delete(voPlus.getConstVO());
								if (rmsg == ResultMessage.SUCCESS) {
									setState("删除成功:)", DISPLAY_TIME);
									constVOPlus.remove(n);
									initialConstJTable(constVOPlus);
								} else {
									setState(ResultMessage
											.toFriendlyString(rmsg),
											DISPLAY_TIME);
								}
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								setState("删除失败:(", DISPLAY_TIME);
							}
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
		constjPop.add(constSubmitjItem);
		constjPop.add(constDeljItem);
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
					constjPop.show(constjTable, e.getX(), e.getY());
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
					constjTable.dispatchEvent(ne);
				}
			}
		};
		constjTable.addMouseListener(mil);
		constjTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
	}

	/**
	 * 初始化机构管理列表
	 * 
	 * @param n
	 * 
	 * @param ivs
	 */
	private void initialInstitutionJTable(ArrayList<InstitutionVOPlus> vos,
			int n) {
		// TODoO Auto-generated method stub
		assert (vos != null) : ("表格获得机构信息为空");
		Object[][] institutionObjects = null;
		institutionObjects = new Object[vos.size()][5];
		int i = 0;
		for (java.util.Iterator<InstitutionVOPlus> t = vos.iterator(); t
				.hasNext(); i++) {
			InstitutionVO vo = t.next();
			institutionObjects[i][0] = vo.institutionNum;
			institutionObjects[i][1] = vo.institutionName;
			institutionObjects[i][2] = vo.contactInfo;
			institutionObjects[i][3] = vo.address;
			institutionObjects[i][4] = vo.manning;
		}

		institutionjTable.setModel(new javax.swing.table.DefaultTableModel(
				institutionObjects, new String[] { "机构编号", "机构名称", "机构联系方式",
						"机构地址", "人员组成" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { true, true, true, true, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		institutionjTable.setDefaultRenderer(Object.class, tcr);

		((DefaultTableCellRenderer) institutionjTable.getTableHeader()
				.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// 设置表头居中
		institutionjTable.setRowSelectionInterval(n, n);// 设置哪几行被选中
		final JPopupMenu institutionjPop = new JPopupMenu();
		final JMenuItem institutionSubmitjItem = new JMenuItem("提交");
		final JMenuItem institutionDeljItem = new JMenuItem("删除");
		institutionSubmitjItem.addMouseListener(/**
		 * @author 1
		 *         监听institution的弹出菜单中的“提交”
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
					int n = institutionjTable.getSelectedRow();
					InstitutionVOPlus voPlus = institutionVOPlus.get(n);
					ModifyState state = voPlus.isModify;
					InstitutionVO v = getViewInstitutionVO(n);
					if (state == ModifyState.NEW) {
						try {
							rmsg = institutionblController.insert(v);
							setState(
									"提交" + ResultMessage.toFriendlyString(rmsg),
									DISPLAY_TIME);
							if (rmsg == ResultMessage.SUCCESS) {
								// institutionVOPlus.remove(n);
								// institutionVOPlus.add(n, new
								// InstitutionVOPlus(
								// v, ModifyState.SYNC));
								setInstitutionVOs();
								initialInstitutionJTable(institutionVOPlus, n);
							}
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							setState(REMOTEFAILD, DISPLAY_TIME);
						}
					} else {
						if (v.equals(voPlus.getInstitutionVO())) {
							setState("您未对该行进行修改！", DISPLAY_TIME);
						} else {
							try {
								rmsg = institutionblController.update(v);
								setState(ResultMessage.toFriendlyString(rmsg),
										DISPLAY_TIME);
								if (rmsg == ResultMessage.SUCCESS) {
									institutionVOPlus.remove(n);
									institutionVOPlus.add(n,
											new InstitutionVOPlus(v,
													ModifyState.SYNC));
								}
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								setState(REMOTEFAILD, DISPLAY_TIME);
							}
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
		institutionDeljItem.addMouseListener(/**
		 * @author 1
		 *         监听institutionjTable上弹出菜单的“删除”
		 */
		new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					int tempN = 0;
					ResultMessage rmsg = null;
					int n = institutionjTable.getSelectedRow();
					InstitutionVOPlus voPlus = institutionVOPlus.get(n);
					ModifyState state = voPlus.isModify;
					if (state == ModifyState.NEW) {
						institutionVOPlus.remove(n);
						if (n == 0) {
							tempN = 0;
						} else {
							tempN = n - 1;
						}
						initialInstitutionJTable(institutionVOPlus, tempN);
					} else {
						Object[] options = { "取消", "删除" };
						int result = JOptionPane.showOptionDialog(null,
								"您确定要删除系统该薪水策略？", "是否删除",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);
						if (result == JOptionPane.NO_OPTION) {
							try {
								rmsg = institutionblController.delete(voPlus
										.getInstitutionVO());
								if (rmsg == ResultMessage.SUCCESS) {
									setState("删除成功:)", DISPLAY_TIME);
									institutionVOPlus.remove(n);
									tempN = 0;
									if (n == 0) {
										tempN = 0;
									} else {
										tempN = n - 1;
									}
									initialInstitutionJTable(institutionVOPlus,
											tempN);
								} else {
									setState(ResultMessage
											.toFriendlyString(rmsg),
											DISPLAY_TIME);
								}
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								setState(REMOTEFAILD, DISPLAY_TIME);
							}
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
		institutionjPop.add(institutionSubmitjItem);
		institutionjPop.add(institutionDeljItem);
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
					institutionjPop.show(institutionjTable, e.getX(), e.getY());
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
					institutionjTable.dispatchEvent(ne);
				}
			}
		};
		institutionjTable.addMouseListener(mil);
		institutionjTable.putClientProperty("terminateEditOnFocusLost",
				Boolean.TRUE);

		institutionjTable.setGridColor(new java.awt.Color(0, 0, 0));
		institutionjTable.setName("123"); // NOI18N
		institutionjTable.getTableHeader().setReorderingAllowed(false);
		jScrollPane8.setViewportView(institutionjTable);
	}

	/**
	 * 得到当前表格第n行的SalaryPolicyVO
	 * 
	 * @param n
	 * @return
	 */
	protected SalaryPolicyVO getViewSalaryPolicyVO(int n) {
		// TODO Auto-generated method stub
		Authority authority = null;
		SalaryPolicy salaryPolicy = null;
		double value = 0;
		try {
			authority = (Authority) salaryPolicyjTable.getValueAt(n, 0);
			salaryPolicy = (SalaryPolicy) salaryPolicyjTable.getValueAt(n, 1);
			value = (double) salaryPolicyjTable.getValueAt(n, 2);
		} catch (ClassCastException e) {
			e.printStackTrace();
			setState("您输入的值类型不正确：(", DISPLAY_TIME);
		}
		return new SalaryPolicyVO(authority, salaryPolicy, value);
	}

	/**
	 * 得到当前表格第n行的InstitutionVO
	 * 
	 * @param n
	 * @return
	 */
	protected InstitutionVO getViewInstitutionVO(int n) {
		// TODO Auto-generated method stub
		String institutionNum = null;
		String institutionName = null;
		String contactInfo = null;
		String address = null;
		String manning = null;
		try {
			institutionNum = (String) institutionjTable.getValueAt(n, 0);
			institutionName = (String) institutionjTable.getValueAt(n, 1);
			contactInfo = (String) institutionjTable.getValueAt(n, 2);
			address = (String) institutionjTable.getValueAt(n, 3);
			manning = (String) institutionjTable.getValueAt(n, 4);
			assert (institutionName != null && institutionNum != null
					&& contactInfo != null && address != null && manning != null) : ("您输入的机构信息不完整！");
		} catch (ClassCastException e) {
			e.printStackTrace();
			setState("您输入的值类型不正确：(", DISPLAY_TIME);
		} catch (AssertionError e) {
			setState("您输入的机构信息不完整！", DISPLAY_TIME);
			System.out.println(e.getMessage());
		}
		return new InstitutionVO(institutionNum, institutionName, contactInfo,
				address, manning);
	}

	public void exitjButtonActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getSource() == exitjButton) {
			Object[] options = { "取消", "确定" };
			int result = JOptionPane.showOptionDialog(null, "您确定要退出系统？",
					"是否退出", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (result == JOptionPane.NO_OPTION) {
				this.dispose();
				new MainFrame();
			}
		}
	}

	/**
	 * 得到当前表格第n行的ConstVO
	 * 
	 * @param n
	 * @return
	 */
	private ConstVO getViewConstVO(int n) {
		// TODO Auto-generated method stub
		String[] cities = new String[2];
		double distanceConst = 0;
		double priceConst = 0;
		try {
			cities[0] = (String) constjTable.getValueAt(n, 0);
			cities[1] = (String) constjTable.getValueAt(n, 1);
			distanceConst = (double) constjTable.getValueAt(n, 2);
			priceConst = (double) constjTable.getValueAt(n, 3);
		} catch (ClassCastException e) {
			e.printStackTrace();
			setState("您输入的值类型不正确：(", DISPLAY_TIME);
		}
		Comparator cmp = Collator.getInstance(java.util.Locale.CHINA); // 使根据指定比较器产生的顺序对指定对象数组进行排序。
		Arrays.sort(cities, cmp);
		return new ConstVO(cities[0] + "-" + cities[1], distanceConst,
				priceConst);
	}

	/**
	 * 改变statejlabel的提示信息，并在五秒后改回"空闲"
	 * 
	 * @param str
	 */
	public void setState(String str, long time) {
		statejLabel.setText(str);
		final Runnable setSateTextFieldText = new Runnable() {
			public void run() {
				statejLabel.setText("空闲");
			}
		};
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(
				setSateTextFieldText, time, time, TimeUnit.SECONDS);
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			}
		}, time, TimeUnit.SECONDS);
	}

	/**
	 * 设置表格文字居中显示
	 * 
	 * @param jTable
	 */
	public void setJTableTextCenter(JTable jTable) {
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容-11
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 设置table内容居中-2
		jTable.setDefaultRenderer(Object.class, tcr);
		((DefaultTableCellRenderer) jTable.getTableHeader()
				.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// 设置表头居中
		jTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

	}

	private void setDocumentVector() {
		try {
			documents = documentCheckbl.initTable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ComponentFactory.setState("程序错误", DISPLAY_TIME, statejLabel);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ComponentFactory.setState(ComponentFactory.REMOTEFAILD,
					DISPLAY_TIME, statejLabel);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ComponentFactory.setState("程序错误", DISPLAY_TIME, statejLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ComponentFactory.setState("文件读写错误", DISPLAY_TIME, statejLabel);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ComponentFactory.setState("网络连接错误", DISPLAY_TIME, statejLabel);
		}
	}

	/**
	 * managerui的启动方法
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			throw new RuntimeException();
		}
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ManagerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ManagerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ManagerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ManagerJFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ManagerJFrame managerFrame = new ManagerJFrame();

			}
		});
	}

	// 变量声明
	// Variables declaration - do not modify//GEN-BEGIN:variables
	// bl相关变量声明
	private DocumentCheckbl documentCheckbl = new DocumentCheckbl();
	private Vector<Object> documents = null;
	private ArrayList<AccountVO> accountVOs = null;
	private ArrayList<ConstVOPlus> constVOPlus = null;
	private ArrayList<SalaryPolicyVOPlus> salaryPolicyVOPlus = null;
	private ArrayList<InstitutionVOPlus> institutionVOPlus = null;
	private ArrayList<LogVO> logVOs = null;
	private ControllerFactoryblService controllerFactoryblService = ControllerFactoryImpl
			.getInstance();
	private AccountBLService accountblController = controllerFactoryblService
			.getAccountController();
	private ConstBLService constblController = controllerFactoryblService
			.getConstController();
	private SalaryPolicyBLService salaryPolicyblController = controllerFactoryblService
			.getSalaryPolicyController();
	private InstitutionBLService institutionblController = controllerFactoryblService
			.getInstitutionController();
	private LogBLService logblController = controllerFactoryblService
			.getLogController();

	private final ScheduledExecutorService scheduler = Executors
			.newScheduledThreadPool(1);

	// 界面变量声明
	/**
	 * 性别下拉框
	 */

	private JComboBox<Sex> sexjComboBox;
	private JComboBox<Authority> authorityjComboBox;
	private JComboBox<SalaryPolicy> salaryPolicyjComboBox;
	private JComboBox<Rep> repjComboBox;
	private JButton viewChecked;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField accountNamejTextField;
	private javax.swing.JTextField accountNumjTextField;
	private javax.swing.JTable accountjTable;
	private javax.swing.JPanel accountjPanel;
	private javax.swing.JButton addConstjButton;
	private javax.swing.JButton addInstitutionjButton;
	private javax.swing.JButton submitSalaryPolicyjButton;
	private javax.swing.JButton addSalaryPolicyjButton;
	private javax.swing.JPanel checkjPane;
	private javax.swing.JLabel constTitlejLabel;
	private javax.swing.JPanel constjPanel;
	private javax.swing.JTable constjTable;
	private javax.swing.JLabel currentAccountNamejLabel;
	private javax.swing.JLabel currentAccoutNamejLabel;
	private javax.swing.JLabel currentAuthorityjLabel;
	private javax.swing.JTable documentCheckjTable;
	private javax.swing.JButton findAccountNamejButton;
	private javax.swing.JButton findAccountNumjButton;
	private javax.swing.JButton findInstitutionNumjButton;
	private javax.swing.JButton findInstitutionNamejButton;
	private javax.swing.JButton findLogjButton;
	private javax.swing.JComboBox formEDatejComboBox;
	private javax.swing.JComboBox formEMonthjComboBox;
	private javax.swing.JComboBox formEYearjComboBox;
	private javax.swing.JPanel formjPanel;
	private javax.swing.JTextField institutionNumjTextField;
	private javax.swing.JPanel institutionjPanel;
	private javax.swing.JTable institutionjTable;
	private javax.swing.JButton exitjButton;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel36;
	private javax.swing.JLabel jLabel37;
	private javax.swing.JLabel jLabel38;
	private javax.swing.JLabel jLabel39;
	private javax.swing.JLabel jLabel40;
	private javax.swing.JLabel jLabel41;
	private javax.swing.JLabel jLabel42;
	private javax.swing.JLabel jLabel43;
	private javax.swing.JLabel jLabel44;
	private javax.swing.JLabel jLabel47;
	private javax.swing.JLabel jLabel48;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane11;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane8;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JSeparator jSeparator6;
	private javax.swing.JSeparator jSeparator7;
	private javax.swing.JSeparator jSeparator8;
	private javax.swing.JSeparator jSeparator9;
	private javax.swing.JTextField findInstitutionNamejTextField;
	private javax.swing.JComboBox<Integer> logEDatejComboBox;
	private javax.swing.JComboBox<Integer> logEYearjComboBox;
	private javax.swing.JComboBox<Integer> logEMonthjComboBox;
	private javax.swing.JComboBox<Integer> logSDatejComboBox;
	private javax.swing.JComboBox<Integer> logSMonthjComboBox;
	private javax.swing.JComboBox<Integer> logSYearjComboBox;
	private javax.swing.JComboBox<LogType> logTypejComboBox;
	private javax.swing.JPanel logjPanel;
	private javax.swing.JTable logjTable;
	private javax.swing.JButton manageStateFormjButton;
	private javax.swing.JPanel managerjPanel;
	private javax.swing.JTabbedPane managerjTabbedPane;
	private javax.swing.JButton outputFormjButton;
	private javax.swing.JButton profitFormjButton;
	private javax.swing.JLabel salaryPolicyTitlejLabel;
	private javax.swing.JPanel salaryPolicyjPane1;
	private javax.swing.JTable salaryPolicyjTable;
	private javax.swing.JLabel statejLabel;
	private javax.swing.JButton submitConstjButton;
	private javax.swing.JButton submitInstitutionjButton;
	// End of variables declaration//GEN-END:variables
	/**
	 * 远程连接失败！
	 */
	private final static String REMOTEFAILD = "远程连接失败！";
	private final static long DISPLAY_TIME = 5;
}
