package ui.util;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ui.Img;

public class MyButton extends JButton{
	/*
	 * 
	 * setIcon--->原始图片
	 * setRolloverIcon-->鼠标进入的
	 * setPressedIcon-->鼠标按下
	 * 
	 * selectedIcon
	 * disabledSelectedIcon
	 * disabledIcon
	 */
	public MyButton(int x,int y){
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(Img.getButton0());
		
		setRolloverIcon(Img.getButton_over());
		setBounds(x, y, Img.getButton0().getIconWidth(), Img.getButton0().getIconHeight());
	}
	public MyButton(ButtonType type){
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		switch(type){
		case OK:
			setIcon(Img.getOk_btn());
			setRolloverIcon(Img.getOk_btn_pressed());
			break;
		case SIGNED:
			setIcon(Img.getSigned_btn());
			setRolloverIcon(Img.getSigned_btn_pressed());
			break;
		case NEWGOODS:
			setIcon(Img.getNewGoods_btn());
			setRolloverIcon(Img.getNewGoods_btn_pressed());
			break;
		case BIG:
			setIcon(Img.getButtonBig());
			setRolloverIcon(Img.getButtonBig_p());
			break;
		case SEARCH:
			setIcon(Img.getBtn_search());
			setRolloverIcon(Img.getBtn_search_pressed());
			break;
		case EXIT:
			setIcon(Img.getExit_btn());
			setRolloverIcon(Img.getExit_btn_pressed());
	        break;
		case LOGIN:
			setIcon(Img.getBtn_login());
			setRolloverIcon(Img.getBtn_login_pressed());
			break;
		case CANCEL:
			setIcon(Img.getCancel_btn());
			setRolloverIcon(Img.getCancel_btn_pressed());
			break;
		case ARRIVE:
			setIcon(Img.getArrive_btn());
			setRolloverIcon(Img.getArrive_pressed());
			break;
		case CAR_MANAGEMENT:
			setIcon(Img.getCarManage_btn());
			setRolloverIcon(Img.getCarManage_btn_pressed());
			break;
		case DRIVER_MANAGEMENT:
			setIcon(Img.getDriverManage_btn());
			setRolloverIcon(Img.getDriverManage_btn_pressed());
			break;
		case DELIVER:
			setIcon(Img.getDeliver_btn());
			setRolloverIcon(Img.getDeliver_pressed());
			break;
		case MONEY_IN_RECORD://TODO
			setIcon(Img.getMoneyIn_btn());
			setRolloverIcon(Img.getMoneyIn_btn_pressed());
			break;
		case TO_TRANSFER_CTR:
			setIcon(Img.getTo_transferCtr_btn());
			setRolloverIcon(Img.getTo_transferCtr_btn_pressed());
			break;
		case TO_TRS_CTR_OR_YYT:
			setIcon(Img.getTo_both_btn());
			setRolloverIcon(Img.getTo_both_btn_pressed());
			break;
		case TO_YYT:
			setIcon(Img.getTo_yyt_btn());
			setRolloverIcon(Img.getTo_yyt_btn_pressed());
			break;
		case ARRIVE_BIG:
			setIcon(Img.getArriveBig_btn());
			setRolloverIcon(Img.getArriveBig_btn_pressed());
			break;
		}			
	}
	public MyButton(int x,int y,ButtonType type){
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		switch(type){
		case INPUT_STOCK:
			setIcon(Img.getInputStock_btn());
			setRolloverIcon(Img.getInputStock_btn_pressed());
			setBounds(x, y, Img.getInputStock_btn().getIconWidth(), Img.getInputStock_btn().getIconHeight());
			break;
		case OK:
			setIcon(Img.getOk_btn());
			setRolloverIcon(Img.getOk_btn_pressed());
			setBounds(x, y, Img.getOk_btn().getIconWidth(), Img.getOk_btn().getIconHeight());
			break;
		case SIGNED:
			setIcon(Img.getSigned_btn());
			setRolloverIcon(Img.getSigned_btn_pressed());
			setBounds(x, y, Img.getSigned_btn().getIconWidth(), Img.getSigned_btn().getIconHeight());
			break;
		case NEWGOODS:
			setIcon(Img.getNewGoods_btn());
			setRolloverIcon(Img.getNewGoods_btn_pressed());
			setBounds(x, y, Img.getNewGoods_btn().getIconWidth(), Img.getNewGoods_btn().getIconHeight());
			break;
		case BIG:
			setIcon(Img.getButtonBig());
			setBounds(x, y, Img.getButtonBig().getIconWidth(), Img.getButtonBig().getIconHeight());
			setRolloverIcon(Img.getButtonBig_p());
			break;
		case SEARCH:
			setIcon(Img.getBtn_search());
			setRolloverIcon(Img.getBtn_search_pressed());
			setBounds(x, y, Img.getBtn_search().getIconWidth(), Img.getBtn_search().getIconHeight());
			break;
		case EXIT:
			setIcon(Img.getExit_btn());
			setRolloverIcon(Img.getExit_btn_pressed());
			setBounds(x, y, Img.getExit_btn().getIconWidth(), Img.getExit_btn().getIconHeight());
	        break;
		case LOGIN:
			setIcon(Img.getBtn_login());
			setRolloverIcon(Img.getBtn_login_pressed());
			setBounds(x, y, Img.getBtn_login().getIconWidth(), Img.getBtn_login().getIconHeight());
			break;
		case CANCEL:
			setIcon(Img.getCancel_btn());
			setRolloverIcon(Img.getCancel_btn_pressed());
			setBounds(x, y, Img.getCancel_btn().getIconWidth(), Img.getCancel_btn().getIconHeight());
			break;
			

		}
	}
//	
//	public static void main(String[] args) {
//		JFrame frame=new JFrame();
//		JPanel panel=new JPanel();
//		MyButton btn=new MyButton(10,10);
//		btn.setBounds(0,0,20,20);
//		panel.add(btn);
//		frame.setContentPane(panel);
//		frame.setVisible(true);
//		frame.setSize(600, 800);
//		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//	}
}
