/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.courierui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import ui.Img;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyLabel;
import ui.util.MyTextField;
import ui.util.TextType;
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
	//TODO
	public static void main(String[] args) {
		new courier_signed();
	}
	
	public courier_signed() {
		setSize(650, 380);
    	controller_end=ControllerFactoryImpl.getInstance().getGoodsEndController();
    	controller_check=ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	initComponents();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
    }
	public courier_signed(courier_main panel) {
		setSize(width,height);
		this.parentPanel=panel;
    	controller_end=ControllerFactoryImpl.getInstance().getGoodsEndController();
    	controller_check=ControllerFactoryImpl.getInstance().getGoodsCheckController();
    	initComponents();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
    }
	
	/**
     * Creates new form courier_signed
     */
	

    private void initComponents() {
    	this.setLocationRelativeTo(null);
        panel = new JPanel(){
        	@Override
        	protected void paintComponent(Graphics g) {
        		g.drawImage(Img.getBackground_main(), 0,0,width,height,null);
        	}
        };
        this.setContentPane(panel);
        initLabel();
        initText();
        initComboBox();
        initbtn();
        initLayout();
    }
    private void initbtn() {
        cancel_btn = new MyButton(120, 280, ButtonType.CANCEL);
        ok_btn = new MyButton(350, 280, ButtonType.OK);
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
         
        /*
         *  getDate_label = new MyLabel("收件日期",50, 230, 60, 20);
         year_label = new MyLabel("年",200, 230, 15, 20);
         month_label = new MyLabel("月",300, 230, 15, 20);
         day_label = new MyLabel("日",400, 230, 15, 20);
         
         */
         year_ComboBox.setBounds(150, 232, 80, 20);
         month_ComboBox.setBounds(270,232,60,20);
         day_ComboBox.setBounds(370, 232, 60, 20);
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
	private void initLayout() {
		panel.setLayout(null);
		panel.add(cancel_btn);
		panel.add(ok_btn);
		panel.add(day_ComboBox);
		panel.add(month_ComboBox);
		panel.add(year_ComboBox);
		panel.add(getterName_text);
		panel.add(goodsNum_text);
		panel.add(getterPhone_text);
		panel.add(feedback_text);
		panel.add(listNum_label);
		panel.add(getter_label);
		panel.add(getDate_label);
		panel.add(year_label);
		panel.add(month_label);
		panel.add(day_label);
		panel.add(title_label);
		panel.add(getterPhone_label);
		//TODO

	}
	private void initText() {
		//listNum_label = new MyLabel("订单号",50, 100, 40, 20);
    	 goodsNum_text = new MyTextField(TextType.INPUT, 150, 80, 120,30);
         getterName_text = new MyTextField(TextType.INPUT, 150, 130, 120,30);
         getterPhone_text = new MyTextField(TextType.INPUT, 150, 180, 120,30);
         feedback_text=new MyTextField(TextType.FEEDBACK, 50, 345, 550,25);
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
    	 listNum_label = new MyLabel("订单号",50, 80, 50, 20);
         getter_label = new MyLabel("收件人",50, 130, 50, 20);
         getterPhone_label = new MyLabel("收件人手机",50,180,80,20);
         getDate_label = new MyLabel("收件日期",50, 230, 60, 20);
         year_label = new MyLabel("年",235, 230, 15, 20);
         month_label = new MyLabel("月",340, 230, 15, 20);
         day_label = new MyLabel("日",440, 230, 15, 20);
         title_label = new MyLabel("快件签收",40,20,120,50);
         title_label.setFont(new java.awt.Font("宋体", 1, 20)); // NOI18N
         title_label.setForeground(Color.white);
}
	/*
	 * Listeners~~
	 */
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
        String date=year_ComboBox.getSelectedItem().toString()+"-"+
        		month_ComboBox.getSelectedItem().toString()+"-"+    
        		day_ComboBox.getSelectedItem().toString();
        System.out.println("签收 "+date);
        if(msg_check_listNum==ResultMessage.VALID&&msg_check_name==ResultMessage.VALID){
        	msg=controller_end.end(listNum,date, getterName, getterPhone);
            if(msg!=ResultMessage.SUCCESS){
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
        	parentPanel.initProBar();
        }
    }
   
	 /**
     * 弹出对话框提示输入信息有误或订单不存在
     * @param msg
     */
	private void showFeedBack(ArrayList<ResultMessage> messages) {
		String feedback="";		
		for(ResultMessage msg:messages){
			if(msg==ResultMessage.WRONG_LOGISTIC_STATE){
				feedback=feedback+"该快件还没被派件呢~";
				continue;
			}
			feedback=feedback+ResultMessage.toFriendlyString(msg)+";   ";
		}
		feedback_text.setText(feedback);
		
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GoodsEndBLService controller_end;
    private GoodsCheckValidBLService controller_check;
    private MyButton cancel_btn,ok_btn;
    private JComboBox<String> day_ComboBox,month_ComboBox,year_ComboBox;
    private MyTextField getterName_text, goodsNum_text,
                       getterPhone_text,feedback_text;
    private MyLabel listNum_label,getter_label,getDate_label,year_label
                   ,month_label,day_label,title_label,getterPhone_label;
    
    private JPanel panel;  
    private String listNum,getterName,getterPhone;
    private static final String phone_="选填";
    
    private courier_main parentPanel;
    private static final long serialVersionUID = 1L;    
    private int mousePressedX,mousePressedY;
    private final int width=650, height=420;
    // End of variables declaration//GEN-END:variables
}
