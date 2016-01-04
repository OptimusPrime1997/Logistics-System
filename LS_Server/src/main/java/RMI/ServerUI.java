/**
 * 服务器启动界面
 * @author Vboar
 * @date 2014/11/15
 */

package RMI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
//
//import data.datafactory.DataFactoryImpl;
//import dataservice.datafactoryservice.DataFactory;




@SuppressWarnings("serial")
public class ServerUI extends JFrame {

	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 800;

	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 500;
	/**
	 * 面板颜色
	 */
	public static final Color panelColor = new Color(200, 150, 190, 128);
	/**
	 * 按钮颜色
	 */
	public static final Color buttonColor = new Color(200, 150, 190, 60);
	/**
	 * 标签颜色
	 */
	public static final Color labelColor = new Color(200, 150, 190, 200);
	/**
	 * 透明颜色
	 */
	public static final Color transparent = new Color(200, 150, 190, 0);
	/**
	 * first title
	 */
	public static Font fTitle=new Font("宋体",Font.BOLD,16);
	/**
	 * second title
	 */
	public static Font sTitle=new Font("宋体",Font.PLAIN,14);
	/**
	 * common
	 */
	public static Font plain=new Font("宋体",Font.PLAIN,12);
	/**
	 * bold common
	 */
	public static Font pBlod=new Font("宋体",Font.BOLD,12);
	/**
	 * 面板
	 */
	private JPanel panel;
	/**
	 * 
	 */
	private JPanel panel0;

	/**
	 * 启动服务按钮
	 */
	private JButton btnStart;

	/**
	 * 停止服务按钮
	 */
	private JButton btnStop;

	/**
	 * 更改端口按钮
	 */
	private JButton btnChange;
	/**
	 * 退出btn
	 */
	private JButton btnExit;
/**
 * 缩小按钮
 */
	private JButton btnShrink;
	/**
	 * 输出区域
	 */
	private JTextArea outputArea;
	private JScrollPane js; 
	/**
	 * 服务器信息
	 */
	private JLabel labInfo;
	private JLabel labTitle;

	/**
	 * 服务器运行状态
	 */
	private JLabel runningInfo;

	/**
	 * 端口值
	 */
	public int port = 8888;

	/**
	 * IP地址
	 */
	public String address;

	/**
	 * 服务开启状态
	 */
	private boolean isOn;

	private Remote reg;

	/**
	 * 更改端口窗体
	 */
	private ChangeDialog dialog;

	/**
	 * 服务端主入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 解决输入法冲突
		System.setProperty("sun.java2d.noddraw", "true");
		// 更改默认字体
		ServerUI.changeFont();
		// 创建GUI窗体
		new ServerUI();
	}

	/**
	 * 创建MainUI
	 */
	public ServerUI() {
		this.setUndecorated(true);
		// 更改GUI样式
				ServerUI.changeLook();
		try {
			this.address = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		this.createUI();
		this.initPanel();
		this.initLabels();
		this.initButtons();
		this.addAll();
		panel0.add(panel);
		this.setBackground(new Color(0,0,0,0));
//		this.setClose();
		this.updateInfo();
		this.repaint();
	}
	private void initPanel(){
		panel=new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(getMainBackgroundIcon(), 0, 0, panel0.getWidth(), panel0.getHeight(), null);
			}
		};	
		panel.setLayout(null);
		panel.setBounds(0, 0, panel0.getWidth(),panel0.getHeight());
	}

	/**
	 * 更改默认字体
	 */
	private static void changeFont() {
		Font font = new Font("宋体", Font.PLAIN, 15);
		@SuppressWarnings("rawtypes")
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
	}

	/**
	 * 更改外观
	 */
	private static void changeLook() {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			// 关闭右上角设置
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
		}
		// try {
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// } catch (Exception e) {
		// throw new RuntimeException();
		// }
		// for (javax.swing.UIManager.LookAndFeelInfo info :
		// javax.swing.UIManager
		// .getInstalledLookAndFeels()) {
		// if ("Nimbus".equals(info.getName())) {
		// try {
		// javax.swing.UIManager.setLookAndFeel(info.getClassName());
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (InstantiationException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (UnsupportedLookAndFeelException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// break;
		// }
		// }

	}

	/**
	 * 创建窗体
	 */
	private void createUI() {

		this.setTitle("快递物流系统（LS）服务器端");
		this.setSize(WIDTH, HEIGHT);
		((JComponent) this.getContentPane()).setOpaque(true);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth - WIDTH) >> 1,
				(screenHeight - HEIGHT) >> 1);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setLayout(null);
		panel0 = (JPanel) this.getContentPane();
		panel0.setBackground(new Color(0, 0, 0, 0));
		panel0.setLayout(null);
	}

	/**
	 * 初始化按钮
	 */
	private void initButtons() {

		btnStart = new JButton("启动服务");
		btnStart.setFont(sTitle);
		btnStart.setBounds(570, 30, 80, 30);
		btnStart.setBackground(buttonColor);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!isOn) {
						reg = LocateRegistry.createRegistry(port);
						// DataFactory dataFactory = new DataFactoryImpl();
						// Naming.rebind("rmi://" + address + ":" + port
						// + "/DataFactory", dataFactory);
						ServerMain.setCurrentIP();
						ServerMain.startService();
						runningInfo.setText("服务运行中...");
						isOn = true;
					} else {
						JOptionPane.showMessageDialog(null, "服务正在运行中.....");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		
		btnStop = new JButton("停止服务");
		btnStop.setFont(sTitle);
		btnStop.setBounds(670, 30, 80, 30);
		btnStop.setBackground(buttonColor);
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (isOn) {
						UnicastRemoteObject.unexportObject(reg, true);
						runningInfo.setText("服务已停止...");
						isOn = false;
					} else {
						JOptionPane.showMessageDialog(null, "服务已经停止了！");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
//		btnChange = new JButton("更改端口");
//		btnChange.setBounds(360, 30, 70, 20);
//		btnChange.setVisible(false);
//		btnChange.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (isOn) {
//					JOptionPane.showMessageDialog(null, "请先停止服务！");
//				} else {
//					showChangeDialog();
//				}
//			}
//
//		});
//		panel.add(btnChange);
		
		btnExit=new ExitButton(30,30);
		btnShrink=new ShrinkButton(30, 30);
		btnShrink.setBounds(panel.getWidth()-80,0,30,30);
		btnExit.setBounds(panel.getWidth()-50,0,30,30);
		btnShrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShrinkAcion(e);
			}
		});
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = { "取消", "确定" };
				int result = JOptionPane
						.showOptionDialog(null, "您确定要退出服务器？", "是否退出",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);
				if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
			}
		});
		
	}
	
	private void btnShrinkAcion(ActionEvent e) {
		this.setExtendedState(JFrame.ICONIFIED);
	}
	/**
	 * 初始化标签
	 */
	private void initLabels() {
		labTitle=new JLabel("快递物流系统（LS）服务器");
		labTitle.setFont(new Font("宋体",Font.BOLD,16));
		int locatx=panel0.getWidth()/2-labTitle.getWidth()/2;
		labTitle.setBounds(locatx,0,labTitle.getWidth(),labTitle.getHeight());

		labInfo = new JLabel("服务器信息(IP:PORT)：" + this.address + ":" + this.port);
		labInfo.setFont(pBlod);
		labInfo.setBounds(20, 30, 250, 20);
		labInfo.setBackground(labelColor);
		
		
		runningInfo = new JLabel("服务未开启！");
		runningInfo.setFont(pBlod);
		runningInfo.setBounds(480, 30, 150, 25);
		runningInfo.setBackground(labelColor);

		outputArea = new JTextArea();
		outputArea.setBounds(20, 100, 750, 380);
		outputArea.setEditable(false);
		// 自动换行
		outputArea.setLineWrap(true);
		// 断行不断字
		outputArea.setWrapStyleWord(true);
		// 添加滚动条
		 js = new JScrollPane(outputArea);
		js.setBounds(20, 100, 750, 380);
		js.setBackground(panelColor);
		// 获取重定向流
		this.redirectSystemStreams();
		
	}
	private void addAll(){
		panel.add(labTitle);
		panel.add(btnStart);
		panel.add(btnStop);
		panel.add(btnShrink);
		panel.add(labInfo);
		panel.add(runningInfo);
		panel.add(btnExit);
		panel.add(js);
	}
	/**
	 * 设置关闭按钮
	 */
//	private void setClose() {
//		this.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				super.windowClosing(e);
//				// int result = JOptionPane.showConfirmDialog(MainUI.this,
//				// "确认退出？", "系统提示", JOptionPane.YES_NO_OPTION,
//				// JOptionPane.QUESTION_MESSAGE);
//				// if (result == JOptionPane.NO_OPTION) {
//				// System.exit(0);
//				// } else {
//				// return;
//				// }
//				Object[] options = { "取消", "确定" };
//				int result = JOptionPane
//						.showOptionDialog(null, "您确定要退出服务器？", "是否退出",
//								JOptionPane.DEFAULT_OPTION,
//								JOptionPane.QUESTION_MESSAGE, null, options,
//								options[0]);
//				if (result == JOptionPane.NO_OPTION) {
//					System.exit(0);
//				}
//			}
//		});
//	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * 显示改变端口框体
	 */
//	private void showChangeDialog() {
//		dialog = new ChangeDialog(this, panel);
//		dialog.setVisible(true);
//	}

	/**
	 * 更新服务器信息
	 */
	public void updateInfo() {
		labInfo.setText("服务器信息(IP:PORT)：" + this.address + "\n");
		outputArea.append("===============我是分割线===============\n");
		outputArea.append("本服务器回送地址为：127.0.0.1" + "\n");
		outputArea.append("本服务器内网地址为：" + this.address + "\n");
		outputArea.append("===============我是分割线===============\n");
	}

	/**
	 * 更新输出区域线程
	 * 
	 * @param text
	 */
	private void updateTextArea(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				outputArea.append(text);
				// 强制到最后一行
				outputArea.selectAll();
			}
		});
	}

	/**
	 * 输出流重定向
	 */
	private void redirectSystemStreams() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				updateTextArea(String.valueOf((char) b));
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				updateTextArea(new String(b, off, len));
			}

			@Override
			public void write(byte[] b) throws IOException {
				write(b, 0, b.length);
			}
		};

		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}
	
	public Image getMainBackgroundIcon(){
		return new ImageIcon("pic/background_main.png").getImage();
	}
}
