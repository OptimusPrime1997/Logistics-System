package ui.businessOfficerui;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import ui.businessOfficerui.businessOfficer_main;
import util.enumData.ResultMessage;
import Exception.GoodsNotFound;
import VO.GoodsVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.goodsblservice.GoodsCheckValidBLService;
import blservice.goodsblservice.GoodsFindBLService;

/**
 *
 * @author Administrator
 */
public class MockLoginFrame extends JFrame {

    /**
     * Creates new form MockLoginFrame
     */
    public MockLoginFrame() {
    	panelMain=new businessOfficer_main();
    	ctr_checkValid = ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	ctr_find=ControllerFactoryImpl.getInstance().getGoodsFindController();
    	this.setVisible(true);
    	 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents();
    }
    
    /**
     * 监听们
     */
    /**
	 * 对用户输入的订单号进行检查和寻找
	 */
	private void search_btnMouseClicked() {
		ResultMessage msg=null;
		msg=ctr_checkValid.checkifWritten(goodsNum_text.getText());
		//没填 反馈用户请填写
		if(msg==ResultMessage.NOT_COMPLETED){
			createDialog(msg);
		}else{
			/*
			 * 填写了 
			 */
			//检查是否合法
			msg=ctr_checkValid.checkListNum(goodsNum_text.getText());
			//合法  则寻找
			if(msg==ResultMessage.VALID){
				try {
					vo=ctr_find.findByGoods(goodsNum_text.getText());
				} catch (GoodsNotFound e1) {
					createDialog(ResultMessage.NOT_FOUND);
				}
			}else{//不合法  反馈用户哪里不合法
				createDialog(msg);
			}
			
		}
	}
	private void login_btnMouseClicked() {
         contentPane.add(panelMain);
         contentPane.revalidate();
         contentPane.repaint();
		
//		this.setContentPane(panelMain);
	}
	private void goodsNum_textMouseClicked(java.awt.event.MouseEvent evt) {
    	if(goodsNum_text.getText().equals(goodsNum)){
    		goodsNum_text.setText(null);
    	}
    }
    private void account_textMouseClicked(java.awt.event.MouseEvent evt) {
    	if(account_text.getText().equals(account)){
    		account_text.setText(null);
    	}    	
    }
    private void password_textMouseClicked(java.awt.event.MouseEvent evt) {
    	if(password_text.getText().equals(password)){
    		password_text.setText(null);
    	}    	
    }    

     private void initComponents() {
    	GroupLayout layout =new GroupLayout(getContentPane());
    	 initTxt();
    	 initbtn();
    	 initLabel(); 
        contentPane = new JPanel();
        initLayout(layout);
      
    }
     private void initLabel() {
 		jLabel2 = new javax.swing.JLabel();
 		jLabel3 = new javax.swing.JLabel();
 		jLabel1 = new javax.swing.JLabel();
 		jLabel2.setText("账号");
 		jLabel3.setText("密码");
 		jLabel1.setFont(new java.awt.Font("华文行楷", 1, 48));
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
		goodsNum_text.setText(goodsNum);
		password_text.setText(password);
		account_text.setText(account);
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
    private void initLayout(GroupLayout layout) {
    	  GroupLayout jPanel1Layout = new GroupLayout(contentPane);
          contentPane.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
              jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addGroup(jPanel1Layout.createSequentialGroup()
                          .addGap(34, 34, 34)
                          .addComponent(feedback_text, GroupLayout.PREFERRED_SIZE, 771, GroupLayout.PREFERRED_SIZE))
                      .addGroup(jPanel1Layout.createSequentialGroup()
                          .addGap(72, 72, 72)
                          .addComponent(goodsNum_text, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                          .addGap(18, 18, 18)
                          .addComponent(search_btn)
                          .addGap(178, 178, 178)
                          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                              .addGroup(jPanel1Layout.createSequentialGroup()
                                  .addComponent(jLabel2)
                                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                  .addComponent(account_text, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanel1Layout.createSequentialGroup()
                                  .addComponent(jLabel3)
                                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                      .addComponent(login_btn)
                                      .addComponent(password_text, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))))
                      .addGroup(jPanel1Layout.createSequentialGroup()
                          .addGap(171, 171, 171)
                          .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)))
                  .addContainerGap(25, Short.MAX_VALUE))
          );
          jPanel1Layout.setVerticalGroup(
              jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(109, 109, 109)
                  .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                  .addGap(91, 91, 91)
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(account_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel2))
                  .addGap(16, 16, 16)
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(password_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel3)
                      .addComponent(goodsNum_text, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                      .addComponent(search_btn))
                  .addGap(32, 32, 32)
                  .addComponent(login_btn)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                  .addComponent(feedback_text, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                  .addGap(31, 31, 31))
          );
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(contentPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(contentPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );

          pack();
	}

	
    private void createDialog(ResultMessage msg) {
		System.out.println(msg);
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	System.out.println("工作台呢");
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
            java.util.logging.Logger.getLogger(MockLoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MockLoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MockLoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MockLoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MockLoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private businessOfficer_main panelMain;
    private JTextField account_text;
    private JTextField goodsNum_text;
    private final String password="密码",goodsNum="输入订单号10位",account="账号";
    private JButton search_btn,login_btn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel contentPane;
    private JTextField feedback_text;
    private JTextField password_text;
    private GoodsVO vo;
    private GoodsCheckValidBLService ctr_checkValid;
    private GoodsFindBLService ctr_find;
    // End of variables declaration//GEN-END:variables
}
