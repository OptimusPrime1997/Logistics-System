package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Img {
	private static Image background_login = new ImageIcon("pic/background/background_login.png")
			.getImage();
	private static Image background_main=new ImageIcon("pic/background/background_main.png").getImage();
	private static Image background_searchState=new ImageIcon("pic/background/background_searchState.png").getImage();
	private static Image background_business=new ImageIcon("pic/background/business_background.png").getImage();
	

	private static ImageIcon ok_btn=new ImageIcon("pic/btn/btn_ok.png");
	private static ImageIcon ok_btn_pressed=new ImageIcon("pic/btn/btn_ok_pressed.png");
	
	private static ImageIcon cancel_btn=new ImageIcon("pic/btn/btn_cancel.png");
	private static ImageIcon cancel_btn_pressed=new ImageIcon("pic/btn/btn_cancel_pressed.png");
	
	
	private static ImageIcon button0=new ImageIcon("pic/btn/btn_all.png");
	private static ImageIcon button_over=new ImageIcon("pic/btn/btn_all_pressed.png");
	
	private static ImageIcon btn_search=new ImageIcon("pic/btn/btn_search.png");
	private static ImageIcon btn_search_pressed=new ImageIcon("pic/btn/btn_search_pressed.png");
	private static ImageIcon btn_login=new ImageIcon("pic/btn/btn_login.png");
	private static ImageIcon btn_login_pressed=new ImageIcon("pic/btn/btn_login_pressed.png");
	
	private static ImageIcon buttonBig=new ImageIcon("pic/btn/btn_big.png");
	private static ImageIcon buttonBig_p=new ImageIcon("pic/btn/btn_big_pressed.png");
	
	private static ImageIcon exit_btn=new ImageIcon("pic/btn/btn_exit0.png");
	private static ImageIcon exit_btn_pressed=new ImageIcon("pic/btn/btn_exit1.png");
	
	private static ImageIcon newGoods_btn=new ImageIcon("pic/btn/newGoods_btn.png");
	private static ImageIcon newGoods_btn_pressed=new ImageIcon("pic/btn/newGoods_btn_pressed.png");
	
	private static ImageIcon signed_btn=new ImageIcon("pic/btn/signed_btn.png");
	private static ImageIcon signed_btn_pressed=new ImageIcon("pic/btn/signed_btn_pressed.png");
	
	private static ImageIcon to_both_btn=new ImageIcon("pic/btn/to_both_btn.png");
	private static ImageIcon to_both_btn_pressed=new ImageIcon("pic/btn/to_both_btn_pressed.png");
	
	private static ImageIcon to_transferCtr_btn=new ImageIcon("pic/btn/to_transferCtr_btn.png");
	private static ImageIcon to_transferCtr_btn_pressed=new ImageIcon("pic/btn/to_transferCtr_btn_pressed.png");
	
	private static ImageIcon to_yyt_btn=new ImageIcon("pic/btn/to_yyt_btn.png");
	private static ImageIcon to_yyt_btn_pressed=new ImageIcon("pic/btn/to_yyt_btn_pressed.png");
	
	private static ImageIcon deliver_btn=new ImageIcon("pic/btn/deliver_btn.png");
	private static ImageIcon deliver_pressed=new ImageIcon("pic/btn/deliver_btn_pressed.png");
	
	private static ImageIcon arrive_btn=new ImageIcon("pic/btn/arrive_btn.png");
	private static ImageIcon arrive_pressed=new ImageIcon("pic/btn/arrive_btn_pressed.png");
	
	private static ImageIcon arriveBig_btn=new ImageIcon("pic/btn/arriveBig_btn.png");
	private static ImageIcon arriveBig_btn_pressed=new ImageIcon("pic/btn/arriveBig_btn_pressed.png");
	
	
	private static ImageIcon carManage_btn=new ImageIcon("pic/btn/carManage_btn.png");
	private static ImageIcon carManage_btn_pressed=new ImageIcon("pic/btn/carManage_btn_pressed.png");
	
	private static ImageIcon driverManage_btn=new ImageIcon("pic/btn/driverManage_btn.png");
	private static ImageIcon driverManage_btn_pressed=new ImageIcon("pic/btn/driverManage_btn_pressed.png");
	
	private static ImageIcon moneyIn_btn=new ImageIcon("pic/btn/moneyIn_btn.png");
	private static ImageIcon moneyIn_btn_pressed=new ImageIcon("pic/btn/moneyIn_btn_pressed.png");
	
	private static ImageIcon inputStock_btn=new ImageIcon("pic/btn/btn_inputStock.png");
	private static ImageIcon inputStock_btn_pressed=new ImageIcon("pic/btn/btn_inputStock.png");
	
	
	
	
	public static ImageIcon getInputStock_btn() {
		return inputStock_btn;
	}

	public static ImageIcon getInputStock_btn_pressed() {
		return inputStock_btn_pressed;
	}

	public static ImageIcon getCancel_btn() {
		return cancel_btn;
	}

	public static ImageIcon getCancel_btn_pressed() {
		return cancel_btn_pressed;
	}



	public static ImageIcon getArriveBig_btn() {
		return arriveBig_btn;
	}

	public static ImageIcon getArriveBig_btn_pressed() {
		return arriveBig_btn_pressed;
	}

	public static ImageIcon getMoneyIn_btn() {
		return moneyIn_btn;
	}

	public static ImageIcon getMoneyIn_btn_pressed() {
		return moneyIn_btn_pressed;
	}

	public static ImageIcon getDeliver_btn() {
		return deliver_btn;
	}

	public static ImageIcon getDeliver_pressed() {
		return deliver_pressed;
	}

	public static ImageIcon getTo_both_btn() {
		return to_both_btn;
	}

	public static ImageIcon getTo_both_btn_pressed() {
		return to_both_btn_pressed;
	}

	public static Image getBackground_business() {
		return background_business;
	}

	public static ImageIcon getTo_transferCtr_btn() {
		return to_transferCtr_btn;
	}

	public static ImageIcon getTo_transferCtr_btn_pressed() {
		return to_transferCtr_btn_pressed;
	}

	public static ImageIcon getTo_yyt_btn() {
		return to_yyt_btn;
	}

	public static ImageIcon getTo_yyt_btn_pressed() {
		return to_yyt_btn_pressed;
	}

	public static ImageIcon getCarManage_btn() {
		return carManage_btn;
	}

	public static ImageIcon getCarManage_btn_pressed() {
		return carManage_btn_pressed;
	}

	public static ImageIcon getDriverManage_btn() {
		return driverManage_btn;
	}

	public static ImageIcon getDriverManage_btn_pressed() {
		return driverManage_btn_pressed;
	}

	public static ImageIcon getBtn_search_pressed() {
		return btn_search_pressed;
	}

	public static ImageIcon getBtn_login_pressed() {
		return btn_login_pressed;
	}

	public static ImageIcon getArrive_btn() {
		return arrive_btn;
	}

	public static ImageIcon getArrive_pressed() {
		return arrive_pressed;
	}


	public static ImageIcon getSigned_btn() {
		return signed_btn;
	}

	public static ImageIcon getSigned_btn_pressed() {
		return signed_btn_pressed;
	}

	public static ImageIcon getNewGoods_btn() {
		return newGoods_btn;
	}

	public static ImageIcon getNewGoods_btn_pressed() {
		return newGoods_btn_pressed;
	}

	public static ImageIcon getExit_btn() {
		return exit_btn;
	}

	public static ImageIcon getBtn_search() {
		return btn_search;
	}

	public static ImageIcon getBtn_login() {
		return btn_login;
	}

	

	public static ImageIcon getOk_btn() {
		return ok_btn;
	}

	public static ImageIcon getOk_btn_pressed() {
		return ok_btn_pressed;
	}

	public static ImageIcon getButtonBig() {
		return buttonBig;
	}

	public static ImageIcon getButtonBig_p() {
		return buttonBig_p;
	}


	public static Image getBackground_main() {
		return background_main;
	}

	public static Image getBackground_searchState() {
		return background_searchState;
	}

	public static ImageIcon getExit_btn_pressed() {
		return exit_btn_pressed;
	}

	public static ImageIcon getButton_over() {
		return button_over;
	}

	public static Image getBackground_login() {
		return background_login;
	}

	public static ImageIcon getButton0() {
		return button0;
	}

//	public static void main(String[] args) {
//		JPanel panel = new JPanel() {
//			public void paint(Graphics g) {
//				g.drawImage(Img.background_login, 0,0, 100, 100, null);
//			}
//		};
//		JFrame frame = new JFrame();
//		frame.setContentPane(panel);
//		frame.setSize(1000, 600);
//		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}

}
