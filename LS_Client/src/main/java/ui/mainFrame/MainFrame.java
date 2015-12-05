/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.mainFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;

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
public class MainFrame extends javax.swing.JFrame {
	/**
	 * 对用户输入的订单号进行检查和寻找
	 */
	private void search_btnMouseClicked() {
		ResultMessage msg=null;
		msg=ctr_checkValid.checkifWritten(goodsNum_text.getText());
		//没填 反馈用户请填写
		if(msg==ResultMessage.NOT_COMPLETED){
			creatDialog(msg);
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
					creatDialog(ResultMessage.NOT_FOUND);
				}
			}else{//不合法  反馈用户哪里不合法
				creatDialog(msg);
			}
			
		}
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
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
    	ctr_checkValid = ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	ctr_find=ControllerFactoryImpl.getInstance().getGoodsFindController();
    	this.setVisible(true);
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }
     private void initComponents() {
	 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());	
	 initTxt();
	 initbtn();
	 initLabel();
	 initLayout(layout);        
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
		 search_btn.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				 search_btnMouseClicked();
			}
		});
}
	private void initLayout(GroupLayout layout) {
		getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(account_text, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(goodsNum_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(search_btn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(login_btn)
                        .addGap(98, 98, 98)))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(goodsNum_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_btn)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(account_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(32, 32, 32)
                .addComponent(login_btn)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        pack();
	
}
	private void initTxt() {
		goodsNum_text = new javax.swing.JTextField();
		account_text = new javax.swing.JTextField();
		password_text = new javax.swing.JTextField();
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
	private void creatDialog(ResultMessage msg) {
		System.out.println(msg);
	}
	public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JTextField account_text,goodsNum_text,password_text;
    private javax.swing.JButton search_btn,login_btn;
    private javax.swing.JLabel jLabel1,jLabel2,jLabel3;
    private final String password="密码",goodsNum="输入订单号10位",account="账号";
    private GoodsCheckValidBLService ctr_checkValid;
    private GoodsFindBLService ctr_find;
    private GoodsVO vo;
    // End of variables declaration//GEN-END:variables
}
