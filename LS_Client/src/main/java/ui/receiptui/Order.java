/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ui.util.MyFrame;
import util.CurrentTime;
import util.enumData.GoodsExpressType;
import util.enumData.GoodsLogisticState;
import util.enumData.ResultMessage;
import VO.GoodsVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.goodsblservice.GoodsInitBLService;
import blservice.loginblservice.LoginBLService;

/**
 *
 * @author apple
 */
public class Order extends javax.swing.JPanel {

	/**
     * Creates new form Order
     */
    public Order() {
    	ctr_account=ControllerFactoryImpl.getInstance().getLoginController();
    	ctr_newgoods=ControllerFactoryImpl.getInstance().getGoodsInitController();
        startTime=CurrentTime.getDate();
    	try {
			getCourierAccount=ctr_account.getCurrentOptorId();
			officeNum=getCourierAccount.substring(3,6);
		} catch (RemoteException e) {
		}
    	initComponents();
    }
    public static void main(String[] args) {
		new MyFrame(600, 600,new Order() );
	}
    private void initComponents() {
        setBackground(new java.awt.Color(255, 255, 255));
    	initTxt();
		initbtn();
		initLabel();
		initBox();
		initLayout();
    }
    private void initLayout() {
    	 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
         this.setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(officeLabel)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(dateLabel)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
             .addGroup(layout.createSequentialGroup()
                 .addGap(26, 26, 26)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addGap(6, 6, 6)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                             .addComponent(receiverLabel)
                             .addComponent(sumLabel)
                             .addComponent(pkgLabel)
                             .addComponent(itemNameLabel)
                             .addComponent(measureLabel)
                             .addComponent(weightLabel)
                             .addComponent(itemNumLabel)
                             .addComponent(typeLabel)
                             .addComponent(senderLabel)
                             .addComponent(senderAddLabel)
                             .addComponent(receiverAddLabel))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(layout.createSequentialGroup()
                                 .addGap(29, 29, 29)
                                 .addComponent(cancelButton)
                                 .addGap(64, 64, 64)
                                 .addComponent(okButton))
                             .addComponent(receiverAddText, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(itemNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addGroup(layout.createSequentialGroup()
                                 .addComponent(receiverText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(18, 18, 18)
                                 .addComponent(receiverPhoneNumLabel)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(receiverPhoneNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addComponent(senderAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addGroup(layout.createSequentialGroup()
                                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                     .addComponent(pkgBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(30, 30, 30)
                                 .addComponent(sumButton))
                             .addGroup(layout.createSequentialGroup()
                                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                     .addComponent(sumText, javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(sender_nameText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(18, 18, 18)
                                 .addComponent(senderPhoneNumLabel)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(senderPhoneNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                 .addComponent(measureText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                 .addComponent(weightText, javax.swing.GroupLayout.Alignment.LEADING)
                                 .addComponent(itemNumText, javax.swing.GroupLayout.Alignment.LEADING))))
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(numLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addContainerGap(23, Short.MAX_VALUE))
             .addComponent(resultMsgText)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(dateLabel)
                     .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(officeLabel))
                 .addGap(21, 21, 21)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(numLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(itemNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(itemNumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(weightLabel)
                     .addComponent(weightText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(measureLabel)
                     .addComponent(measureText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(itemNameLabel)
                     .addComponent(itemNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(pkgBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(pkgLabel))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(typeLabel)
                     .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(sumButton))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(sumLabel)
                     .addComponent(sumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(senderLabel)
                     .addComponent(sender_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(senderPhoneNumLabel)
                     .addComponent(senderPhoneNumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(senderAddLabel)
                     .addComponent(senderAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addGap(18, 18, 18)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(receiverLabel)
                             .addComponent(receiverText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(receiverPhoneNumLabel)
                             .addComponent(receiverPhoneNumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(layout.createSequentialGroup()
                         .addGap(55, 55, 55)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(receiverAddText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(receiverAddLabel))))
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(okButton)
                     .addComponent(cancelButton))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                 .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         );
	}
	private void initBox() {
    	pkgBox = new javax.swing.JComboBox<String>();
		typeBox = new javax.swing.JComboBox<String>();
        pkgBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "快递袋", "纸箱", "木箱" }));
        pkgBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pkgBoxActionPerformed(evt);
            }
        });
        typeBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "标准", "经济", "特快" }));
        typeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeBoxActionPerformed(evt);
            }
        });
	}
	private void initbtn() {
    	sumButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        sumButton.setText("确定");
        sumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumButtonActionPerformed(evt);
            }
        });
        cancelButton.setText("取消");
        okButton.setText("确认");
        okButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		okBtnMouseClicked();
        	}
		});

	}
	private void initLabel() {
    	numLabel = new javax.swing.JLabel();
		itemNumLabel = new javax.swing.JLabel();
		weightLabel = new javax.swing.JLabel();
		measureLabel = new javax.swing.JLabel();
        pkgLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        sumLabel = new javax.swing.JLabel();
		itemNameLabel = new javax.swing.JLabel();
        senderLabel = new javax.swing.JLabel();
		senderAddLabel = new javax.swing.JLabel();
		senderPhoneNumLabel = new javax.swing.JLabel();
		receiverLabel = new javax.swing.JLabel();
		receiverPhoneNumLabel = new javax.swing.JLabel();
		receiverAddLabel = new javax.swing.JLabel();
		dateLabel = new javax.swing.JLabel();
		officeLabel = new javax.swing.JLabel();  
		
		numLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        numLabel.setText("订单号:");

        itemNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        itemNumLabel.setText("原件数:");

        weightLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        weightLabel.setText("重量:");

        measureLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        measureLabel.setText("尺寸:");

        itemNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        itemNameLabel.setText("内件品名:");

        pkgLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pkgLabel.setText("包装形式:");
        
        typeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typeLabel.setText("快递类型:");
        
        sumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sumLabel.setText("总计:");

        senderLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        senderLabel.setText("寄件人:");

        senderAddLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        senderAddLabel.setText("住址:");

        senderPhoneNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        senderPhoneNumLabel.setText("手机:");

        receiverLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        receiverLabel.setText("收件人:");

        receiverPhoneNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        receiverPhoneNumLabel.setText("手机:");

        receiverAddLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        receiverAddLabel.setText("住址:");

        dateLabel.setText("日期:");
        officeLabel.setText("营业厅");

	}
	private void initTxt() {
    	officeText = new javax.swing.JTextField();
		sender_nameText = new javax.swing.JTextField();
		itemNumText = new javax.swing.JTextField();
		itemNameText = new javax.swing.JTextField();
		weightText = new javax.swing.JTextField();
		sumText = new javax.swing.JTextField();
		measureText = new javax.swing.JTextField();
		receiverAddText = new javax.swing.JTextField();
		receiverText = new javax.swing.JTextField();
		senderAddressText = new javax.swing.JTextField();
		senderPhoneNumText = new javax.swing.JTextField();
		receiverPhoneNumText = new javax.swing.JTextField();
		dateText = new javax.swing.JTextField();
		numText = new javax.swing.JTextField();
		resultMsgText = new javax.swing.JTextField();

		officeText.setEditable(false);
		
		officeText.setText(officeNum);//TODO
		sumText.setEditable(false);
		sumText.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sumTextActionPerformed(evt);
			}
		});

		dateText.setEditable(false);
		dateText.setText(CurrentTime.getDate());
		numText.setEditable(false);
		resultMsgText.setEditable(false);
	}
	 /**
     * 弹出对话框提示输入信息有误或订单不存在
     * @param msg
     */
	private void showFeedBack(ArrayList<ResultMessage> messages) {
		String feedback="";		
		for(ResultMessage msg:messages){
			feedback=feedback+ResultMessage.toFriendlyString(msg)+";   ";
		}
		resultMsgText.setText(feedback);
	}
	/**
	 * 监听们
	 * @param evt
	 */
	private void pkgBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pkgBoxActionPerformed
    }//GEN-LAST:event_pkgBoxActionPerformed

    private void typeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeBoxActionPerformed
    }//GEN-LAST:event_typeBoxActionPerformed

    private void sumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumButtonActionPerformed
    }//GEN-LAST:event_sumButtonActionPerformed

    private void sumTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumTextActionPerformed
    }//GEN-LAST:event_sumTextActionPerformed
    private void okBtnMouseClicked() {
    	this.senderName=sender_nameText.getText();
    	this.senderAddress=senderAddressText.getText();
    	this.senderPhone=senderPhoneNumText.getText();
    	/*
    	 * destinationCity,
			senderName, senderAddress, senderCompany, senderPhone,
			receiverName, receiverAddress, receiverCompany, receiverPhone,
			nameOfInside;
    	 */
    	
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel dateLabel, itemNameLabel, itemNumLabel,
			measureLabel, numLabel, officeLabel, pkgLabel, receiverAddLabel,
			senderLabel, senderPhoneNumLabel, receiverLabel,
			receiverPhoneNumLabel, senderAddLabel, sumLabel, typeLabel,
			weightLabel;
	private javax.swing.JTextField itemNumText, measureText, numText,
			officeText, dateText, itemNameText, receiverAddText,
			receiverPhoneNumText, receiverText, resultMsgText, senderAddressText,
			senderPhoneNumText, sender_nameText, sumText, weightText;
	private javax.swing.JComboBox<String> pkgBox, typeBox;
	private javax.swing.JButton okButton, sumButton, cancelButton;
	private String officeNum,getCourierAccount, startTime, destinationCity,
			senderName, senderAddress, senderCompany, senderPhone,
			receiverName, receiverAddress, receiverCompany, receiverPhone,
			nameOfInside;
	private Boolean ifExaminePassed = false;
    private int numOfGoods;
    private double  weight, volume, moneyOfPackage, moneyTotal, moneyFare;
	private LoginBLService ctr_account;
	private GoodsInitBLService ctr_newgoods;
	private GoodsExpressType expressType;
	private GoodsLogisticState logisticState;
	private static final long serialVersionUID = 1L;
    // End of variables declaration//GEN-END:variables
}
