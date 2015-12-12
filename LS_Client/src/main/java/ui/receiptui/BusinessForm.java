/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import ui.util.MyFrame;
import util.CurrentTime;
import util.enumData.ResultMessage;
import Exception.NotFoundMoneyInAndOutException;
import VO.BusinessFormVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.PayVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.formblservice.BusinessFormBLService;

/**
 *
 * @author apple
 */
public class BusinessForm extends javax.swing.JPanel {

    /**
     * Creates new form 经营情况表
     */
    public BusinessForm() {    	
    	ctr=ControllerFactoryImpl.getInstance().getBusinessFromController();
    	initComponents();
        frame=new MyFrame(900, 600, this);
        
    }
    private void initComponents() {

        startTimeLabel = new javax.swing.JLabel();
        startTimeText = new javax.swing.JTextField();
        endTimeLabel = new javax.swing.JLabel();
        endTimeText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cashRepTable = new javax.swing.JTable();
        cashLabel = new javax.swing.JLabel();
        payLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        payRepTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        showText = new javax.swing.JTextField();
        resultMsgText = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        startTimeLabel.setText("开始日期:");

        endTimeLabel.setText("结束日期:");

        cashRepTable.setModel(new DefaultTableModel(
            new Object [][] {//TODO
                {null, null, null}
            },
            new String [] {
                "日期", "编号", "收款金额"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        cashRepTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(cashRepTable);

        cashLabel.setText("收款项");

        payLabel.setText("付款项");
//TODO 
        payRepTable.setModel(new DefaultTableModel(
            new Object [][] {//TODO 
                {null, null, null}
            },
            new String [] {
                "日期", "编号", "支付金额"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        payRepTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(payRepTable);

        backButton.setText("返回");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        showText.setEditable(false);
        showText.setText("示例:2015-11-2");

        resultMsgText.setEditable(false);

        findButton.setText("查看");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });
       initLayout();
    }

    private void initLayout() {
    	 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
         this.setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(resultMsgText)
             .addGroup(layout.createSequentialGroup()
                 .addGap(183, 183, 183)
                 .addComponent(cashLabel)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(payLabel)
                 .addGap(196, 196, 196))
             .addGroup(layout.createSequentialGroup()
                 .addGap(31, 31, 31)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(35, 35, 35)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(backButton))
                 .addContainerGap(22, Short.MAX_VALUE))
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                         .addComponent(startTimeLabel)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(startTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                         .addComponent(endTimeLabel)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(endTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addGap(33, 33, 33)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(findButton)
                     .addComponent(showText, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(274, 274, 274))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addGap(21, 21, 21)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(startTimeLabel)
                     .addComponent(startTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(showText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(endTimeLabel)
                     .addComponent(endTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(findButton))
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(cashLabel)
                     .addComponent(payLabel))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(backButton))
                 .addGap(18, 20, Short.MAX_VALUE)
                 .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         );
	}
	
    /*
     * 2015-11-2"
     */
    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
         resultMsgText.setText("");
    	//TODO 
    	String startT=startTimeText.getText();
    	String endT=endTimeText.getText();
    	ResultMessage msgt=datesIfValid(startT,endT);
    	
    	if(msgt==ResultMessage.VALID){
    		try {
				formVO=ctr.show(startT, endT);
				//表的行数
				int cashLength=0,payLength=0;
				ArrayList<ArrayList<CashRepVO>> cashrepvos=formVO.moneyInRecord;
				ArrayList<ArrayList<PayRepVO>> payrepvos=formVO.moneyOutRecord;
				for(ArrayList<CashRepVO>vos:cashrepvos){
					for(CashRepVO vo:vos){
						cashLength+=vo.cashVOs.size();
					}
				}
				for(ArrayList<PayRepVO>vos:payrepvos){
					for(PayRepVO vo:vos){
						payLength+=vo.payVOs.size();
					}
				}
				showObjectsCash=new Object[cashLength][3];
				showObjectsPay=new Object[payLength][3];
				int count=0;
				for(ArrayList<CashRepVO>vos:cashrepvos){
					for(CashRepVO vo:vos){
						for(CashVO o:vo.cashVOs){
							showObjectsCash[count][0]=vo.date;
							showObjectsCash[count][1]=vo.num;
							showObjectsCash[count][2]=o.money;
							count++;
						}
					}
				}System.out.println("表行数"+count);
				cashRepTable.setModel(new DefaultTableModel(
						showObjectsCash,
						new String []{"日期", "编号", "支付金额"}
						));
				count=0;
				for(ArrayList<PayRepVO>vos:payrepvos){
					for(PayRepVO vo:vos){
						for(PayVO o:vo.payVOs){
							showObjectsPay[count][0]=vo.date;
							showObjectsPay[count][1]=vo.num;
							showObjectsPay[count][2]=o.money;
							count++;
						}
					}
				}System.out.println("表行数"+count);
				payRepTable.setModel(new DefaultTableModel(
						showObjectsPay,
						new String []{"日期", "编号", "支付金额"}
						));
			} catch (NotFoundMoneyInAndOutException e) {
	     	    showFeedback(ResultMessage.NOT_FOUND_FINACIAL);
			}
		}else{
			showFeedback(msgt);
		}
    	
    }
    private void showFeedback(ResultMessage msg) {
		resultMsgText.setText(ResultMessage.toFriendlyString(msg));
	}
/**
 * 合法返回VALID
 * @param startT
 * @param endT
 * @return
 */
    public static ResultMessage datesIfValid(String startT,String endT){
    	if(startT.length()==0||endT.length()==0){
    		return ResultMessage.NOT_COMPLETED;
    	}
    	if(!(dtIfValid(startT)&&dtIfValid(endT))){
    		return ResultMessage.WRONG_FORMAT;
    	}else{
    		if(CurrentTime.ifearlier(startT, endT)){
    			return ResultMessage.VALID;
    		}else if((!CurrentTime.ifearlier(startT, endT))&&(!CurrentTime.ifearlier(endT, startT))){
    			return ResultMessage.VALID;
    		}else{
    			return ResultMessage.WRONG_ORDER_OF_DATE;
    		}
    	}
    }
	private static Boolean dtIfValid(String date) {
		ArrayList<Integer> loc=new ArrayList<Integer>(2);
		for(int i=0;i<date.length();i++){
			char c=date.charAt(i);
			if(c=='-'){
				loc.add(i);
			}else if(!(c>='0'&&c<='9')){
				return false;
			}
		}
		if(loc.size()!=2) {
			return false;
		}else{//有两个短线~
			//第一个短线前没数字   后一个短线后没数字  两短线间没数字
			if(loc.get(0)==0||
					loc.get(1)==date.length()-1||
					(loc.get(1)-loc.get(0))==1){
				return false;
			}
		}
		return true;
	}
	private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
	}
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
         frame.setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel cashLabel,startTimeLabel,endTimeLabel;
    private javax.swing.JTable cashRepTable,payRepTable;
    private javax.swing.JButton findButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel payLabel;
    private javax.swing.JTextField resultMsgText,showText;
    private javax.swing.JTextField startTimeText,endTimeText;
    private MyFrame frame;
    private BusinessFormBLService ctr;
    private BusinessFormVO formVO;
    private Object[][] showObjectsPay,showObjectsCash ;
    // End of variables declaration//GEN-END:variables

}
