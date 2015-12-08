/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.courierui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import util.CurrentTime;
import util.enumData.ResultMessage;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.goodsblservice.GoodsCheckValidBLService;
import blservice.goodsblservice.GoodsEndBLService;

/**
 *
 * @author Administrator
 */
public class courier_signed extends JFrame {
	public courier_signed() {
    	controller_end=ControllerFactoryImpl.getInstance().getGoodsEndController();
    	controller_check=ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	initComponents();
    	this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
	public courier_signed(courier_main panel) {
		this.parentPanel=panel;
    	controller_end=ControllerFactoryImpl.getInstance().getGoodsEndController();
    	controller_check=ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	initComponents();
    	this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
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
    	if(getterPhone_text.getText().equals(phone_)){
    		getterPhone_text.setText(null);
    	}		
	}
    private void cancel_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_btnMouseClicked
        this.setVisible(false);
    }
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
        if(!getterPhone_text.getText().equals(phone_)){
        	getterPhone=getterPhone_text.getText();
        }else {
        	getterPhone="";
        }
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
        if(msg_check_listNum!=ResultMessage.VALID){
        	messages.add(msg_check_listNum);
        }
        if(msg_check_name!=ResultMessage.VALID) {
        	messages.add(msg_check_name);
        }
        
        //若不成功  将反馈信息传给dialog
		if (!(msg == ResultMessage.SUCCESS
				&& msg_check_listNum == ResultMessage.VALID && msg_check_name == ResultMessage.VALID)) {
			showFeedBack(messages);
        }else{//成功窗体才消失
        	this.setVisible(false);
        	parentPanel.setFeedBack(ResultMessage.SIGNED_SUCCESS);
        }
    }
   
	/**
     * Creates new form courier_signed
     */
	

    private void initComponents() {
    	this.setLocationRelativeTo(null);
        panel = new JPanel();
        GroupLayout layout0 = new GroupLayout(panel);
        panel.setLayout(layout0);
        initLabel();
        initText();
        initComboBox();
        initbtn();
        initLayout(layout0);

    }
    private void initbtn() {
        cancel_btn = new JButton();
        ok_btn = new JButton();
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
    	 year_ComboBox = new JComboBox<String>();
         month_ComboBox = new JComboBox<String>();
         day_ComboBox = new JComboBox<String>();
		year_ComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "2015", "2016", "2017", "2018" ,"2019","2020"}));
		month_ComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
						"10", "11", "12" }));
		day_ComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
						"10", "11", "12", "13", "14", "15", "16", "17", "18",
						"19", "20", "21", "22", "23", "24", "25", "26", "27",
						"28", "29", "30", "31" }));
		setTodayDate();
		
		
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
	private void setTodayDate() {
		String date=CurrentTime.getDate();		
		int year=Integer.parseInt(date.substring(0, 4));
		int month=Integer.parseInt(date.substring(5, 7));
		int day=Integer.parseInt(date.substring(8, 10));
		year_ComboBox.setSelectedIndex(year-2015);
		month_ComboBox.setSelectedIndex(month-1);
		day_ComboBox.setSelectedIndex(day-1);
	}
	private void initLayout(GroupLayout layout0) {

		layout0.setHorizontalGroup(
	            layout0.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, layout0.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(cancel_btn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
	                .addGap(55, 55, 55)
	                .addComponent(ok_btn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
	                .addGap(54, 54, 54))
	            .addGroup(GroupLayout.Alignment.TRAILING, layout0.createSequentialGroup()
	                .addGap(44, 44, 44)
	                .addComponent(jLabel9)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout0.createSequentialGroup()
	                .addGap(66, 66, 66)
	                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout0.createSequentialGroup()
	                        .addComponent(jLabel10)
	                        .addGap(21, 21, 21)
	                        .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(getterPhone_text, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(getterName_text, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(goodsNum_text, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                        .addComponent(jLabel4)
	                        .addComponent(jLabel1))
	                    .addGroup(layout0.createSequentialGroup()
	                        .addComponent(jLabel5)
	                        .addGap(27, 27, 27)
	                        .addComponent(year_ComboBox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel6)
	                        .addGap(18, 18, 18)
	                        .addComponent(month_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel7)
	                        .addGap(13, 13, 13)
	                        .addComponent(day_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel8)))
	                .addContainerGap(202, Short.MAX_VALUE))
	                .addGroup(layout0.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(feedback_text)
                         .addContainerGap())
	        );
	        layout0.setVerticalGroup(
	            layout0.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout0.createSequentialGroup()
	                .addGap(30, 30, 30)
	                .addComponent(jLabel9)
	                .addGap(37, 37, 37)
	                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(goodsNum_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel1))
	                .addGap(14, 14, 14)
	                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(getterName_text, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4))
	                .addGap(14, 14, 14)
	                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel10)
	                    .addComponent(getterPhone_text, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel5)
	                    .addComponent(year_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(month_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(day_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel6)
	                    .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
	                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(cancel_btn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(ok_btn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
	                     .addComponent(feedback_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	               
	                .addGap(15, 15, 15))
	                
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 0, Short.MAX_VALUE))
	        );

	        pack();
	}
	private void initText() {
    	 goodsNum_text = new JTextField();
         getterName_text = new JTextField();
         getterPhone_text = new JTextField();
         feedback_text=new JTextField();
         
         feedback_text.setEditable(false);
         feedback_text.setForeground(Color.RED);
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
    	 jLabel1 = new JLabel();
         jLabel4 = new JLabel();
         jLabel5 = new JLabel();
         jLabel6 = new JLabel();
         jLabel7 = new JLabel();
         jLabel8 = new JLabel();
         jLabel9 = new JLabel();
         jLabel10 = new JLabel();
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
	private void showFeedBack(ArrayList<ResultMessage> messages) {
		String feedback="";		
		for(ResultMessage msg:messages){
			feedback=feedback+ResultMessage.toFriendlyString(msg)+";   ";
		}
		feedback_text.setText(feedback);
		
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GoodsEndBLService controller_end;
    private GoodsCheckValidBLService controller_check;
    private JButton cancel_btn;
    private JButton ok_btn;
    private JComboBox<String> day_ComboBox;
    private JComboBox<String> month_ComboBox;
    private JComboBox<String> year_ComboBox;
    private JTextField getterName_text, goodsNum_text,
    getterPhone_text,feedback_text;
    private courier_main parentPanel;
    private JLabel jLabel1;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JPanel panel;  
    private String listNum,getterName,getterPhone;
    private static final String phone_="选填";
    private static final long serialVersionUID = 1L;    
    // End of variables declaration//GEN-END:variables
}
