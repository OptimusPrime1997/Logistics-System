/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui;

import VO.ProfitFormVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.formblservice.ProfitFormBLService;
import ui.util.MyFrame;
import util.CurrentTime;
import util.enumData.ResultMessage;

/**
 *
 * @author apple
 */
public class ProfitForm extends javax.swing.JPanel {

   public static void main(String[] args) {
	new ProfitForm();}
   

    /**
     * Creates new form 成本收益表
     */
    public ProfitForm() {
    	ctr=ControllerFactoryImpl.getInstance().getProfitFormController();
        initComponents();
        frame=new MyFrame(415,280,this);
        
    }

   private void initComponents() {
        startDateLabel = new javax.swing.JLabel();
        startDateText = new javax.swing.JTextField();
        costLabel = new javax.swing.JLabel();
        costText = new javax.swing.JTextField();
        incomeLabel = new javax.swing.JLabel();
        incomeText = new javax.swing.JTextField();
        realIncomeLabel = new javax.swing.JLabel();
        realIncomeText = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();

        startDateText.setText(CurrentTime.getDate());
        startDateText.setEditable(false);
        setBackground(new java.awt.Color(255, 255, 255));
        incomeText.setText("0");
		realIncomeText.setText("0");
		costText.setText("0");
			vo=ctr.show();
			System.out.println("显示"+vo.totalIn);
			incomeText.setText(vo.totalIn+"");
			realIncomeText.setText(vo.totalProfit+"");
			costText.setText(vo.totalOut+"");
		
        
        startDateLabel.setText("今日日期:");

        costLabel.setText("成本:");

        costText.setEditable(false);

        incomeLabel.setText("总收入:");

        incomeText.setEditable(false);

        realIncomeLabel.setText("净收入:");

        realIncomeText.setEditable(false);

        okButton.setText("确定");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        resultMsgText.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(realIncomeLabel)
                    .addComponent(costLabel)
                    .addComponent(startDateLabel)
                    .addComponent(incomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(realIncomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(costText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(incomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        ))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56)
                .addComponent(okButton)
                .addGap(93, 93, 93))
            .addComponent(resultMsgText)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateLabel)
                    .addComponent(startDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   )
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costLabel)
                    .addComponent(costText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(incomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(incomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realIncomeLabel)
                    .addComponent(realIncomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        frame.setVisible(false);
    }
    private void showFeedback(ResultMessage msg) {
		resultMsgText.setText(ResultMessage.toFriendlyString(msg));
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel costLabel;
    private javax.swing.JTextField costText;
    private javax.swing.JLabel incomeLabel;
    private javax.swing.JTextField incomeText;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel realIncomeLabel;
    private javax.swing.JTextField realIncomeText;
    private javax.swing.JTextField resultMsgText;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateText;
    private MyFrame frame;
    private ProfitFormBLService ctr;
    private ProfitFormVO vo;
    // End of variables declaration//GEN-END:variables
}
