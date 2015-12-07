package ui.transferCtrOfficerui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import ui.mainFrame.MainFrame;
import ui.receiptui.GetRep;
import ui.receiptui.ShippingRep;
import ui.receiptui.TransferRep;
import ui.util.MyFrame;
import util.enumData.ResultMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class transferCtrOfficer_main extends JPanel {

    public transferCtrOfficer_main() {
        initComponents();
    }
    /**
	 * 给main的子界面调用~反馈给用户操作成功的message
	 * @param msg
	 */
	public void setFeedback(ResultMessage msg){
		feedback_text.setText(ResultMessage.toFriendlyString(msg));
	}
    private void initComponents() {
    	initLabel();
		initProBar();
		initbtn();
		initText();
		initLayOut();
    }
    private void initLayOut() {
    	GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(feedback_text)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transferOfficeNum_label)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(account_btn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(toTransferCTR_btn, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(toBusinessOffice_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(arrival_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(outByTrain_progressBar, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(outByCar_progressBar, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(outByPlane_progressBar, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(outByTrain_label)
                            .addGap(84, 84, 84))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(exit_btn)
                            .addGap(26, 26, 26)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(outByCar_label, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(outByPlane_label))
                        .addGap(57, 57, 57))))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(exit_btn)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(account_btn)
                            .addComponent(jLabel3)
                            .addComponent(transferOfficeNum_label))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(outByTrain_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(outByTrain_label)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(toTransferCTR_btn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(toBusinessOffice_btn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(outByCar_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(outByCar_label))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(outByPlane_progressBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(outByPlane_label)
                            .addComponent(jLabel6))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(arrival_btn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(feedback_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
	}
	private void initText() {
        feedback_text = new JTextField();
        feedback_text.setEditable(false);
	}
	private void initbtn() {
    	exit_btn = new JButton(); 
        account_btn = new JButton();
        arrival_btn = new JButton();
        toBusinessOffice_btn = new JButton();
        toTransferCTR_btn = new JButton();

		exit_btn.setText("退出系统");
		arrival_btn.setText("货物到达");
		toBusinessOffice_btn.setText("发往营业厅");
		account_btn.setText("老张（包括更改密码、退出登录）");
		toTransferCTR_btn.setText("发往中转中心");
		
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        account_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_btnActionPerformed(evt);
            }
        });
        toBusinessOffice_btn.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		toBusinessOffice_btnMouseClicked();
        	}
		});
        arrival_btn.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		arrival_btnMouseClicked();
        	}
		});
        toTransferCTR_btn.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		toTransferCTR_btnMouseClicked();
        	}
		});

	}
	private void initProBar() {
    	 outByTrain_progressBar = new JProgressBar();
         outByCar_progressBar = new JProgressBar();
         outByPlane_progressBar = new JProgressBar();
         outByTrain_progressBar.setValue(20);
         outByCar_progressBar.setValue(60); 
         outByPlane_progressBar.setValue(5);
	}
	private void initLabel() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		transferOfficeNum_label = new JLabel();
		outByTrain_label = new JLabel();
		outByCar_label = new JLabel();
		outByPlane_label = new JLabel();
		jLabel1.setText("今日流水（派出数量）");
		jLabel2.setText("中转中心：");
		jLabel3.setText("账户：");
		jLabel4.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel4.setText("火车");
		jLabel5.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel5.setText("汽车");
		jLabel6.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
		jLabel6.setText("飞机");
		transferOfficeNum_label.setText("南京 001");
		outByTrain_label.setText("10");
		outByCar_label.setText("26");
		outByPlane_label.setText("2");
		outByTrain_label.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
		outByCar_label.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
		outByPlane_label.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
	}
	private void account_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_account_btnActionPerformed
	}
	private void toBusinessOffice_btnMouseClicked() {
		System.out.println("中转中心装车单");
		new MyFrame(800,600,new ShippingRep());
	}
	private void arrival_btnMouseClicked() {
		System.out.println("中转中心到达单");
		new MyFrame(800,600,new GetRep());
	}
	private void toTransferCTR_btnMouseClicked() {
		System.out.println("中转单");
		new MyFrame(800, 600, new TransferRep());
	}
    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton account_btn;
    private JButton arrival_btn;
    private JButton exit_btn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel outByCar_label;
    private JProgressBar outByCar_progressBar;
    private JLabel outByPlane_label;
    private JProgressBar outByPlane_progressBar;
    private JLabel outByTrain_label;
    private JProgressBar outByTrain_progressBar;
    private JTextField feedback_text;
    private JButton toBusinessOffice_btn;
    private JButton toTransferCTR_btn;
    private JLabel transferOfficeNum_label;
    // End of variables declaration//GEN-END:variables
    
    
    /**
     * for test~~
     * @param args
     */
    public static void main(String[] args) {
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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	JFrame frame = new JFrame();
        		frame.setSize(830, 590);
        		frame.setVisible(true);
        		frame.setContentPane(new transferCtrOfficer_main());
        		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
            }
        });

	}
}
