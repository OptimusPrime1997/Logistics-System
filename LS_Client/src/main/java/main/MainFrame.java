package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.rmi.RemoteException;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import ui.Img;
import ui.administratorui.AdministratorPanel;
import ui.businessOfficerui.businessOfficer_main;
import ui.componentfactory.ComponentFactory;
import ui.courierui.courier_main;
import ui.financialstaffui.FinancialStaffJFrame;
import ui.managerui.ManagerJFrame;
import ui.transferCtrOfficerui.transferCtrOfficer_main;
import ui.util.ButtonType;
import ui.util.FormatedText;
import ui.util.MyButton;
import ui.util.MyFormattedTextFeild;
import ui.util.MyLabel;
import ui.util.MyTextField;
import ui.util.NumOnlyDocument;
import ui.util.TextType;
import ui.warehousemanui.WarehousePanel;
import util.InputCheck;
import util.enumData.Authority;
import util.enumData.ResultMessage;
import Exception.GoodsNotFound;
import VO.GoodsVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import bl.loginbl.Loginbl;
import blservice.goodsblservice.GoodsCheckValidBLService;
import blservice.goodsblservice.GoodsFindBLService;
import blservice.loginblservice.LoginBLService;

/*
 * msgAcc_ifValid-->检查账号是否合法
 * msgKey_ifValid-->检查密码是否输入了
 * msgMatch-->访问数据层，账号是否存在，账号与密码是否匹配
 *  
 *  02500106027
 *   025     001           01      027
 *  3位城市  3位营业厅编号     身份           序号
 *（01总经理、02财务人员、03营业厅业务员、
 *04中转中心业务员、05中转中心仓库管理员、
 *06快递员、07司机）+3位顺序编号 
 *
 *
 */
/**
 *
 * @author Administrator5
 */
public class MainFrame extends JFrame {
	private int mousePressedX;
	private int mousePressedY;

	/**
	 * Creates new form MainFrame
	 */

	public MainFrame() {
		
		ctr_checkValid = ControllerFactoryImpl.getInstance()
				.getGoodsCheckController();
		ctr_find = ControllerFactoryImpl.getInstance().getGoodsFindController();
		ctr_login = ControllerFactoryImpl.getInstance().getLoginController();
		this.setResizable(false);
		setTitle("快递物流系统");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mousePressedX = e.getX();
				mousePressedY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = (int) getLocation().getX();
				int y = (int) getLocation().getY();
				setLocation(x + e.getX() - mousePressedX, y + e.getY()
						- mousePressedY);
			}
		});
		initComponents();
		this.setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		this.setVisible(true);
	}

	private void initComponents() {
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(Img.getBackground_login(), 0, 0, width, height,
						null);
			}
		};
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		initTxt();
		initbtn();
		initLabel();
		initLayout();
		ComponentFactory.setSystemLook();
	}

	private void initLabel() {
		account_label = new MyLabel("账号", 255, 152, 30, 15);
		key_label = new MyLabel("密码", 255, 197, 30, 15);
	}

	private void initTxt() {
		// 创建对象
		goodsNum_text = new MyTextField(TextType.INPUT, 40, 135, 100, 30);
		IP_text = new MyFormattedTextFeild(FormatedText.IP, 40, 210, 100, 30);
		account_text = new MyTextField(TextType.INPUT,290, 145, 100, 30);
		password_text = new javax.swing.JPasswordField(6);
		password_text.setBounds(290, 190, 100, 30);
		account_text.setDocument(new NumOnlyDocument());
		
		account_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_btnMouseClicked();
			}
		});
		password_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_btnMouseClicked();
			}
		});
		feedback_text = new MyTextField(TextType.FEEDBACK, 30, 275, 400, 30);
		// 设为透明
		// goodsNum_text.setOpaque(false);
		// IP_text.setOpaque(false);
		// account_text.setOpaque(false);
		// password_text.setOpaque(false);
		// feedback_text.setOpaque(false);

		// 设置位置、大小
		
		IP_text.setText(standard_ip);
		goodsNum_text.setText(standard_goodsNum);
		IP_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ip_btnMouseClicked();
			}
		});
		goodsNum_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_btnMouseClicked();
			}
		});
		goodsNum_text.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				goodsNum_textMouseClicked(evt);
			}
		});
		account_text.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				account_textKeyPressed(e);
			}
		});
		IP_text.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				IP_textMouseClicked(evt);
			}
		});

	}
	//TODO
	private void shrink_btnAction(ActionEvent e) {
		this.setExtendedState(JFrame.ICONIFIED);
	}

	private void initbtn() {
		search_btn = new MyButton(150, 135, ButtonType.SEARCH);
		login_btn = new MyButton(320, 230, ButtonType.LOGIN);
		exit_btn = new MyButton(420, 7, ButtonType.EXIT);
		ip_btn = new MyButton(150, 210);
		shrink_btn=new MyButton(390, 7, ButtonType.SHRINK);
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_btnMouseClicked();
			}
		});
		search_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search_btnMouseClicked();
			}
		});
		shrink_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shrink_btnAction(e);
			}
		});
		exit_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit_btnMouseClicked();
			}
		});
		ip_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ip_btnMouseClicked();
			}

		});
	}

	/**
	 * 监听们
	 */

	private void exit_btnMouseClicked() {
		System.exit(0);
	}
	//输完账号后按“下”即可输密码
	private void account_textKeyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			password_text.requestFocusInWindow();
		}
	}
	private void ip_btnMouseClicked() {
		String ip = IP_text.getText();
		if (checkIP(ip)) {
			Loginbl.setIP(ip);
			ComponentFactory.setState("服务器ip设置成功", 3,
					feedback_text);
		}else{
			ComponentFactory.setState("ip地址不合法，请修改", ComponentFactory.DISPLAY_TIME,
					feedback_text);
		}
	}

	private boolean checkIP(String str) {
		Pattern pattern = Pattern
				.compile("^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]"
						+ "|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 对用户输入的订单号进行检查和寻找
	 */
	private void search_btnMouseClicked() {
		goodsNum = goodsNum_text.getText();
		ResultMessage msg = null;
		msg = ctr_checkValid.checkifWritten(goodsNum);
		// 没填 反馈用户请填写
		if (msg == ResultMessage.NOT_COMPLETED) {
			showFeedback(msg);
		} else {
			/*
			 * 填写了
			 */
			// 检查是否合法
			msg = ctr_checkValid.checkListNum(goodsNum);
			// 合法 则寻找
			if (msg == ResultMessage.VALID) {
				try {
					vo = ctr_find.findByGoods(goodsNum);
					System.out.println("MAinFrame.search " + vo.listNum);
					new LogisticStateUI(vo);
				} catch (GoodsNotFound e1) {
					System.out.println("not found");
					showFeedback(ResultMessage.NOT_FOUND_GOODS);
				}
			} else {// 不合法 反馈用户哪里不合法
				showFeedback(msg);
			}

		}
	}

	private void login_btnMouseClicked() {
		/*
		 * msgAcc_ifValid-->检查账号是否合法 msgKey_ifValid-->检查密码是否输入了
		 * msgMatch-->访问数据层，账号是否存在，账号与密码是否匹配
		 * 
		 * 02500106027 025 001 01 027 3位城市 3位营业厅编号 身份 序号（01总经理、02财务人员、03营业厅业务员、
		 * 04中转中心业务员、05中转中心仓库管理员、06快递员、07司机）+3位顺序编号
		 */
		ResultMessage msgAcc_ifValid, msgKey_ifValid, msgMatch = ResultMessage.NOT_FOUND_NUM;
		password = password_text.getText();
		account = account_text.getText();
		msgAcc_ifValid = InputCheck.checkAccount(account);
		msgKey_ifValid = InputCheck.keyIfWritten(password);
		// 输入合法 调用数据层检查账号与密码是否匹配
		if (msgAcc_ifValid == ResultMessage.VALID
				&& msgKey_ifValid == ResultMessage.VALID) {
			try {
				msgMatch = ctr_login.login(account, password);
			} catch (RemoteException e) {
			}
			if (msgMatch == ResultMessage.SUCCESS) {
				Authority job=Authority.COURIER;
				try {
					job = ctr_login.getCurrentAuthority();
				} catch (RemoteException e) {
				}
				this.setVisible(false);
				switch (job) {
				case MANAGER:
					new ManagerJFrame();
					break;
				case FINANCIALSTAFF_C:
					new FinancialStaffJFrame();
					break;
				case BUSSINESSOFFICER:
					new businessOfficer_main();
					break;
				case TRANSFERCTROFFICER:
					new transferCtrOfficer_main();
					break;
				case WAREHOUSEMAN:
					new WarehousePanel();
					break;
				case COURIER:
					new courier_main();
					break;
				case ADMINISTRATOR:
					new AdministratorPanel();
					break;
				case FINANCIALSTAFF_V:
					new FinancialStaffJFrame();
					break;
				default:
					showFeedback(ResultMessage.NOT_FOUND_NUM);
					break;
				}
			} else if (msgMatch == ResultMessage.NOT_COMPLETED_ACCOUNT
					|| msgMatch == ResultMessage.NOT_FOUND) {
				showFeedback(ResultMessage.NOT_FOUND_NUM);
			} else
				showFeedback(ResultMessage.WRONG_PASSWORD);
		} else {// 不合法 反馈
			if (msgKey_ifValid != ResultMessage.VALID) {
				showFeedback(msgKey_ifValid);
			}
			if (msgAcc_ifValid != ResultMessage.VALID) {
				showFeedback(msgAcc_ifValid);
			}
		}
	}

	private void goodsNum_textMouseClicked(java.awt.event.MouseEvent evt) {
		this.feedback_text.setText(null);// TODO 还有鼠标拖拽 选中一堆字符~也要清空
		// TODO 还要实现 回车就可以查询
		if (goodsNum_text.getText().equals(standard_goodsNum)) {
			goodsNum_text.setText(null);
		}
	}

	private void IP_textMouseClicked(MouseEvent evt) {
		IP_text.setText("");
	}

	private void initLayout() {
		contentPane.setLayout(null);
		contentPane.setSize(width, height);
		contentPane.add(account_label);
		contentPane.add(key_label);
		contentPane.add(search_btn);
		contentPane.add(login_btn);
		contentPane.add(feedback_text);
		contentPane.add(password_text);
		contentPane.add(account_text);
		contentPane.add(goodsNum_text);
		contentPane.add(exit_btn);
		contentPane.add(ip_btn);
		contentPane.add(shrink_btn);
		contentPane.add(IP_text);
		this.setContentPane(contentPane);
	}

	private void showFeedback(ResultMessage msg) {
		this.feedback_text.setText(ResultMessage.toFriendlyString(msg));
	}

	/**
	 * 整个程序的Main
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		new MainFrame();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private MyTextField feedback_text, goodsNum_text, account_text;
	private JPasswordField password_text;
	private MyFormattedTextFeild IP_text;
	final String standard_goodsNum = "输入订单号10位", standard_ip = "输入ip地址";
	String ip;
	private String password, goodsNum, account;
	private MyButton search_btn, login_btn, exit_btn, ip_btn,shrink_btn;
	private MyLabel account_label, key_label;
	private JPanel contentPane;
	private GoodsVO vo;
	private GoodsCheckValidBLService ctr_checkValid;
	private GoodsFindBLService ctr_find;
	private LoginBLService ctr_login;
	private final int width = 480, height = 350;
	// End of variables declaration//GEN-END:variables
}
