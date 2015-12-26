
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.Img;
import ui.administratorui.AdministratorPanel;
import ui.businessOfficerui.businessOfficer_main;
import ui.courierui.courier_main;
import ui.financialstaffui.FinancialStaffJFrame;
import ui.managerui.ManagerJFrame;
import ui.transferCtrOfficerui.transferCtrOfficer_main;
import ui.util.MyButton;
import ui.util.NumOnlyDocument;
import ui.warehousemanui.WarehousePanel;
import util.InputCheck;
import util.enumData.ResultMessage;
import Exception.GoodsNotFound;
import VO.GoodsVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
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
    	ctr_checkValid = ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	ctr_find=ControllerFactoryImpl.getInstance().getGoodsFindController();
        ctr_login=ControllerFactoryImpl.getInstance().getLoginController();
    	this.setResizable(false);
    	this.setSize(width,height);
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
		this.setVisible(true);
    }
	private void initComponents() {
		contentPane=new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(Img.getBackground0(), 0, 0, width,height,null);
			}
		};
		contentPane.setLayout(null);
		initTxt();
		initbtn();
		initLabel();
		initLayout();
	}
	private void initLabel() {
 		account_label = new javax.swing.JLabel();
 		key_label = new javax.swing.JLabel();
 		account_label.setText("账号");
 		account_label.setBounds(260, 150, 30, 15);
 		key_label.setText("密码");
 		key_label.setBounds(260, 180, 30, 15);
 		loginLABLEBTN=new JLabel();
 		loginLABLEBTN.setBounds(50, 50, 50, 50);
	}
	private void initTxt() {
		goodsNum_text = new javax.swing.JTextField();
		account_text = new javax.swing.JTextField(11);
		
		account_text.setDocument(new NumOnlyDocument());
		
		password_text = new javax.swing.JPasswordField(6);
	    feedback_text = new JTextField();
	    
	    account_text.setBounds(290, 145, 100, 20);
	    password_text.setBounds(290, 180, 100, 20);
	    feedback_text.setBounds(20,265,400, 20);
	    feedback_text.setEditable(false);
	    feedback_text.setForeground(Color.MAGENTA);//TODO 其他的颜色都改成这个
		goodsNum_text.setText(standard_goodsNum);
		goodsNum_text.setBounds(40, 145, 100, 20);
		goodsNum_text.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				goodsNum_textMouseClicked(evt);
			}
		});
		account_text.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				account_textMouseClicked(evt);
			}
		});
		password_text.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				password_textMouseClicked(evt);
			}
		});
		
	}
	private void initbtn() {
		search_btn = new MyButton(150, 140,0);
		login_btn = new MyButton(320, 210,0);
		exit_btn=new MyButton(410,7,1);

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
		exit_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit_btnMouseClicked();
			}
		});
	}
	
	
    /**
     * 监听们
     */

	private void exit_btnMouseClicked() {
		System.exit(0);
	}
    /**
	 * 对用户输入的订单号进行检查和寻找
	 */
	private void search_btnMouseClicked() {
		goodsNum=goodsNum_text.getText();
		ResultMessage msg=null;
		msg=ctr_checkValid.checkifWritten(goodsNum);
		//没填 反馈用户请填写
		if(msg==ResultMessage.NOT_COMPLETED){
			showFeedback(msg);
		}else{
			/*
			 * 填写了 
			 */
			//检查是否合法
			msg=ctr_checkValid.checkListNum(goodsNum);
			//合法  则寻找
			if(msg==ResultMessage.VALID){
				try {
					vo=ctr_find.findByGoods(goodsNum);
					System.out.println("MAinFrame.search "+vo.listNum);
					new LogisticStateUI(vo);
				} catch (GoodsNotFound e1) {
					System.out.println("not found");
					showFeedback(ResultMessage.NOT_FOUND);
				}
			}else{//不合法  反馈用户哪里不合法
				showFeedback(msg);
			}
			
		}
	}
	private void login_btnMouseClicked() {
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
				int job = Integer.parseInt(account.substring(6, 8));
				this.setVisible(false);
				switch (job) {
				case 1:
					new ManagerJFrame();
					break;
				case 2:
					new FinancialStaffJFrame();
					break;
				case 3:
					new businessOfficer_main();
					break;
				case 4:
					new transferCtrOfficer_main();
					break;
				case 5:
					new WarehousePanel();
					break;
				case 6:
					new courier_main();
					break;
				case 8:
					new AdministratorPanel();
					break;
				case 9:
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
		this.feedback_text.setText(null);//TODO  还有鼠标拖拽 选中一堆字符~也要清空
		//TODO 还要实现 回车就可以查询
    	if(goodsNum_text.getText().equals(standard_goodsNum)){
    		goodsNum_text.setText(null);
    	}
    }
    private void account_textMouseClicked(java.awt.event.MouseEvent evt) {
    	  	
    }
    private void password_textMouseClicked(java.awt.event.MouseEvent evt) {
    	  	
    }  
	
    private void initLayout() {
    	contentPane.setLayout(null);
    	
    	contentPane.add(account_label);
    	contentPane.add(key_label);
    	contentPane.add(search_btn);
    	contentPane.add(login_btn);
    	contentPane.add(feedback_text);
    	contentPane.add(password_text);
    	contentPane.add(account_text);
    	contentPane.add(goodsNum_text);
    	contentPane.add(loginLABLEBTN);
    	contentPane.add(exit_btn);
    	this.setContentPane(contentPane);
	}

	
    private void showFeedback(ResultMessage msg) {
    	this.feedback_text.setText(ResultMessage.toFriendlyString(msg));
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	MainFrame mainFrame=new MainFrame();
//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                MainFrame mainFrame=new MainFrame();
//               
//            }
//        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField account_text,
    feedback_text,goodsNum_text;
    private JPasswordField password_text;
    final String standard_goodsNum="输入订单号10位";
    private String	password,goodsNum,account;
    private MyButton search_btn,login_btn,exit_btn;
    private JLabel loginLABLEBTN;
    private JLabel account_label;
    private JLabel key_label;
    private JPanel contentPane;
    private GoodsVO vo;
    private GoodsCheckValidBLService ctr_checkValid;
    private GoodsFindBLService ctr_find;
    private LoginBLService ctr_login;
    private final int width=450,height=300;
    // End of variables declaration//GEN-END:variables
}
