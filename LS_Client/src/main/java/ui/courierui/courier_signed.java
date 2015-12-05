/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.courierui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;

import util.CreateDialog;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsExpressType;
import util.enumData.GoodsLogisticState;
import util.enumData.ResultMessage;
import Exception.ExistException;
import VO.GoodsVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.goodsblservice.GoodsCheckValidBLService;
import blservice.goodsblservice.GoodsEndBLService;
import blservice.goodsblservice.GoodsFindBLService;
import blservice.goodsblservice.GoodsInitBLService;

/**
 *
 * @author Administrator
 */
public class Courier_signed extends javax.swing.JFrame {
	/*
	 * Listeners~~
	 */
    private void year_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void month_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
    }
   
    private void day_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day_ComboBoxActionPerformed
       
    }
    private void getterPhone_textMouseClicked(MouseEvent e) {
		getterPhone_text.setText(null);
	}
    private void cancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_btnMouseClicked
        this.setVisible(false);
    }
    //DONE!
    private void ok_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok_btnMouseClicked
        
        /*
         * msg_check_listNum:检查用户输入的数据是否合法的结果
         * msg_check_name:检查用户输入的收件人名字是否合法  
         * msg:收件信息输入的返回结果
         */
        /*
         * 获取用户的输入
         */
        ArrayList<ResultMessage> messages=new ArrayList<ResultMessage>();
        ResultMessage msg=null,msg_check_listNum,msg_check_name;
        listNum=goodsNum_text.getText();
        getterName=getterName_text.getText();
        getterPhone=getterPhone_text.getText();
        /*
         * 检查是否合法
         */
        msg_check_listNum=controller_check.checkListNum(listNum);
        msg_check_name=controller_check.checkifWritten(getterName);
        /*
         * 若非法则创建dialog窗口向用户反馈
         */
        if(msg_check_listNum==ResultMessage.VALID&&msg_check_name==ResultMessage.VALID){
        	msg=controller_end.end(listNum, getterName, getterPhone);
            if(msg==ResultMessage.NOT_FOUND){
            	messages.add(msg);            	
            }	
        }
        if(msg_check_name!=ResultMessage.VALID) messages.add(msg_check_name);
        if(msg_check_listNum!=ResultMessage.VALID){
        	messages.add(msg_check_listNum);
        }
        //若不成功  将反馈信息传给dialog
		if (!(msg == ResultMessage.SUCCESS
				&& msg_check_listNum == ResultMessage.VALID && msg_check_name == ResultMessage.VALID)) {
			createDialog(messages);
        }else{//成功窗体才消失
        	this.setVisible(false);
        }
    }
   
	/**
     * Creates new form courier_signed
     */
	public Courier_signed() {
    	controller_end=ControllerFactoryImpl.getInstance().getGoodsEndController();
    	controller_check=ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  
    private void initComponents() {
        panel = new javax.swing.JPanel();
        javax.swing.GroupLayout layout0 = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout0);
        initLabel();
        initText();
        initComboBox();
        initbtn();
        initLayout(layout0);

    }
    private void initbtn() {
        cancel_btn = new javax.swing.JButton();
        ok_btn = new javax.swing.JButton();
        cancel_btn.setText("取消");
        ok_btn.setText("确认");
        /**
         * add listeners
         */
        cancel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_btnMouseClicked(evt);
            }
        });
        
        ok_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ok_btnMouseClicked(evt);
            }
        });
	}
	private void initComboBox() {
    	 year_ComboBox = new javax.swing.JComboBox<String>();
         month_ComboBox = new javax.swing.JComboBox<String>();
         day_ComboBox = new javax.swing.JComboBox<String>();
		year_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { "2015", "2016", "2014", "2013" }));
		month_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
						"10", "11", "12" }));
		day_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
						"10", "11", "12", "13", "14", "15", "16", "17", "18",
						"19", "20", "21", "22", "23", "24", "25", "26", "27",
						"28", "29", "30", "31" }));
		/*
		 * add listener
		 */
         year_ComboBox.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 year_ComboBoxActionPerformed(evt);
             }
         });
         month_ComboBox.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 month_ComboBoxActionPerformed(evt);
             }
         });
         day_ComboBox.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 day_ComboBoxActionPerformed(evt);
             }
         }); 
	}
	private void initLayout(GroupLayout layout0) {

		layout0.setHorizontalGroup(
	            layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout0.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(55, 55, 55)
	                .addComponent(ok_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(54, 54, 54))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout0.createSequentialGroup()
	                .addGap(44, 44, 44)
	                .addComponent(jLabel9)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout0.createSequentialGroup()
	                .addGap(66, 66, 66)
	                .addGroup(layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout0.createSequentialGroup()
	                        .addComponent(jLabel10)
	                        .addGap(21, 21, 21)
	                        .addGroup(layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(getterPhone_text, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(getterName_text, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(goodsNum_text, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                        .addComponent(jLabel4)
	                        .addComponent(jLabel1))
	                    .addGroup(layout0.createSequentialGroup()
	                        .addComponent(jLabel5)
	                        .addGap(27, 27, 27)
	                        .addComponent(year_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel6)
	                        .addGap(18, 18, 18)
	                        .addComponent(month_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel7)
	                        .addGap(13, 13, 13)
	                        .addComponent(day_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel8)))
	                .addContainerGap(202, Short.MAX_VALUE))
	        );
	        layout0.setVerticalGroup(
	            layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout0.createSequentialGroup()
	                .addGap(30, 30, 30)
	                .addComponent(jLabel9)
	                .addGap(37, 37, 37)
	                .addGroup(layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(goodsNum_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel1))
	                .addGap(14, 14, 14)
	                .addGroup(layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(getterName_text, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4))
	                .addGap(14, 14, 14)
	                .addGroup(layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel10)
	                    .addComponent(getterPhone_text, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel5)
	                    .addComponent(year_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(month_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(day_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel6)
	                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
	                .addGroup(layout0.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(ok_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(51, 51, 51))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 0, Short.MAX_VALUE))
	        );

	        pack();
	}
	private void initText() {
    	 goodsNum_text = new javax.swing.JTextField();
         getterName_text = new javax.swing.JTextField();
         getterPhone_text = new javax.swing.JTextField();
         getterPhone_text.setText("选填");
         /*
  		 * add listener
  		 */
         
         getterPhone_text.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		getterPhone_textMouseClicked(e);
        	}
		});
         
	}
	private void initLabel() {
    	 jLabel1 = new javax.swing.JLabel();
         jLabel4 = new javax.swing.JLabel();
         jLabel5 = new javax.swing.JLabel();
         jLabel6 = new javax.swing.JLabel();
         jLabel7 = new javax.swing.JLabel();
         jLabel8 = new javax.swing.JLabel();
         jLabel9 = new javax.swing.JLabel();
         jLabel10 = new javax.swing.JLabel();
         jLabel1.setText("订单号");
         jLabel4.setText("收件人");
         jLabel5.setText("收件日期");
         jLabel6.setText("年");
         jLabel7.setText("月");
         jLabel8.setText("日");
         jLabel9.setText("快件签收");
         jLabel10.setText("收件人手机");
//         jLabel9.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
//         jLabel9.setForeground(new java.awt.Color(51, 0, 204));
         
}
	
	 /**
     * 弹出对话框提示输入信息有误或订单不存在
     * @param msg
     */
	private void createDialog(ArrayList<ResultMessage> messages) {
		System.out.println("我是弹窗！~   ");
		String feedback="";		
		for(ResultMessage msg:messages){
			feedback=feedback+msg.toString()+"\n";
		}
		System.out.println(feedback);
		CreateDialog.creatDialog(messages, 200, 200);
		System.out.println();
		// TODO 
		
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GoodsEndBLService controller_end;
    private GoodsCheckValidBLService controller_check;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JButton ok_btn;
    private javax.swing.JComboBox<String> day_ComboBox;
    private javax.swing.JComboBox<String> month_ComboBox;
    private javax.swing.JComboBox<String> year_ComboBox;
    private javax.swing.JTextField getterName_text;
    private javax.swing.JTextField goodsNum_text;
    private javax.swing.JTextField getterPhone_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel panel;  
    private String listNum,getterName,getterPhone;
    
    private static final long serialVersionUID = 1L;    
    // End of variables declaration//GEN-END:variables
}
