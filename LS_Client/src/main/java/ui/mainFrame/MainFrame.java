
package ui.mainFrame;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import ui.businessOfficerui.businessOfficer_main;
import ui.courierui.courier_main;
import ui.financialstaffui.FinancialStaffJFrame1;
import ui.managerui.ManagerJFrame1;
import ui.transferCtrOfficerui.transferCtrOfficer_main;
import ui.warehousemanui.WarehousePanel;
import util.InputCheck;
import util.enumData.ResultMessage;
import Exception.GoodsNotFound;
import VO.GoodsVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.goodsblservice.GoodsCheckValidBLService;
import blservice.goodsblservice.GoodsFindBLService;
import blservice.managementblservice.accountblservice.AccountBLService;

/**
 *
 * @author Administrator
 */
public class MainFrame extends JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
    	ctr_checkValid = ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	ctr_find=ControllerFactoryImpl.getInstance().getGoodsFindController();
        ctr_account=ControllerFactoryImpl.getInstance().getAccountController();
    	this.setVisible(true);
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	this.setResizable(false);
        initComponents();
    }
	private void initComponents() {
		contentPane=new JPanel();
		initTxt();
		initbtn();
		initLabel();
		initLayout();
	}
	private void initLabel() {
 		jLabel2 = new javax.swing.JLabel();
 		jLabel3 = new javax.swing.JLabel();
 		jLabel1 = new javax.swing.JLabel();
 		jLabel2.setText("账号");
 		jLabel3.setText("密码");
 		jLabel1.setFont(new java.awt.Font("华文行楷", 1, 24));
		jLabel1.setText("LS  快递物流系统");
	}
	private void initbtn() {
		search_btn = new javax.swing.JButton();
		login_btn = new javax.swing.JButton();
		search_btn.setText("查询");
		login_btn.setText("登录");

		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("登录");
				login_btnMouseClicked();
			}
		});
		search_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search_btnMouseClicked();
			}
		});
	}
	private void initTxt() {
		goodsNum_text = new javax.swing.JTextField();
		account_text = new javax.swing.JTextField();
		password_text = new javax.swing.JTextField();
	    feedback_text = new JTextField();
		
	    feedback_text.setEditable(false);
	    feedback_text.setForeground(Color.red);
		goodsNum_text.setText(standard_goodsNum);
		password_text.setText(standard_password);
		account_text.setText(standard_account);
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
	
    /**
     * 监听们
     */
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
				} catch (GoodsNotFound e1) {
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
		 *  3位城市
	     *（01总经理、02财务人员、03营业厅业务员、
         *04中转中心业务员、05中转中心仓库管理员、
         *06快递员、07司机）+3位顺序编号 
         *
         *
		 */
		ResultMessage msgAcc_ifValid,msgKey_ifValid,
		              msgMatch=ResultMessage.NOT_FOUND_ACCOUNTNUM;
         password=password_text.getText();
         account=account_text.getText(); 
         msgAcc_ifValid=InputCheck.checkAccount(account);
         msgKey_ifValid=InputCheck.keyIfWritten(password);
         //输入合法 调用数据层检查账号与密码是否匹配
         if(msgAcc_ifValid==ResultMessage.VALID&&msgKey_ifValid==ResultMessage.VALID){
        	  try {
				msgMatch=ctr_account.login(account,password);
			} catch (RemoteException e) {
			}
//        	  if()
        	  int job=Integer.parseInt(account.substring(6, 8));
              this.setVisible(false);
          
              switch (job) {
     		case 1:new ManagerJFrame1();
     			break;
     		case 2:new FinancialStaffJFrame1();
     			break;
     		case 3:new businessOfficer_main();   
     			break;
     		case 4:new transferCtrOfficer_main();   
     			break;
     		case 5:new WarehousePanel();
     			break;
     		case 6:new courier_main();
     			break;
     		default:showFeedback(ResultMessage.NOT_FOUND_ACCOUNTNUM);
     			break;
     		}
              
         }
       
          
         //TODO 先不判断   账号 密码的正确性
         
         
	}
	private void goodsNum_textMouseClicked(java.awt.event.MouseEvent evt) {
		this.feedback_text.setText(null);//TODO  还有鼠标拖拽 选中一堆字符~也要清空
		//TODO 还要实现 回车就可以查询
    	if(goodsNum_text.getText().equals(standard_goodsNum)){
    		goodsNum_text.setText(null);
    	}
    }
    private void account_textMouseClicked(java.awt.event.MouseEvent evt) {
    	if(account_text.getText().equals(standard_account)){
    		account_text.setText(null);
    	}    	
    }
    private void password_textMouseClicked(java.awt.event.MouseEvent evt) {
    	if(password_text.getText().equals(standard_password)){
    		password_text.setText(null);
    	}    	
    }  
	
    private void initLayout() {
    	 javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(contentPane);
         contentPane.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(32, 32, 32)
                         .addComponent(goodsNum_text, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(search_btn)
                         .addGap(66, 66, 66)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(login_btn)
                             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                     .addComponent(jLabel2)
                                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                     .addComponent(account_text, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                     .addComponent(jLabel3)
                                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                     .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(68, 68, 68)
                         .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(feedback_text, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addContainerGap(50, Short.MAX_VALUE))
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(20, 20, 20)
                 .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(28, 28, 28)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(account_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel2))
                 .addGap(15, 15, 15)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel3)
                     .addComponent(goodsNum_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(search_btn))
                 .addGap(18, 18, 18)
                 .addComponent(login_btn)
                 .addGap(55, 55, 55)
                 .addComponent(feedback_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(0, 0, Short.MAX_VALUE))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
         );

         pack();
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
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField account_text,password_text,feedback_text,goodsNum_text;
    private final String standard_password="密码",standard_goodsNum="输入订单号10位",standard_account="账号";
    private String	password,goodsNum,account;
    private JButton search_btn,login_btn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel contentPane;
    private GoodsVO vo;
    private GoodsCheckValidBLService ctr_checkValid;
    private GoodsFindBLService ctr_find;
    private AccountBLService ctr_account;
    // End of variables declaration//GEN-END:variables
}
