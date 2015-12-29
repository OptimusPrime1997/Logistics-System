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
	
	private static ImageIcon send_forYYT_btn=new ImageIcon("pic/btn/send_yyt_btn.png");
	private static ImageIcon send_forYYT_btn_pressed=new ImageIcon("pic/btn/send_yyt_btn_pressed.png");
	
	private static ImageIcon arrive_btn=new ImageIcon("pic/btn/arrive_btn.png");
	private static ImageIcon arrive_pressed=new ImageIcon("pic/btn/arrive_btn_pressed.png");
	
	private static ImageIcon toYYT_forZZZX_btn=new ImageIcon("pic/btn/sendToYYTForzzzx_btn.png");
	private static ImageIcon toYYT_forZZZX_btn_pressed=new ImageIcon("pic/btn/sendToYYTForzzzx_btn_pressed.png");
	
	private static ImageIcon toTransferCtr_forZZZX_btn=new ImageIcon("pic/btn/totransferctrForzzzx_btn.png");
	private static ImageIcon toTransferCtr_forZZZX_btn_pressed=new ImageIcon("pic/btn/totransferctrForzzzx_btn_pressed.png");
	

	
	public static ImageIcon getCancel_btn() {
		return cancel_btn;
	}

	public static ImageIcon getCancel_btn_pressed() {
		return cancel_btn_pressed;
	}

	public static ImageIcon getSend_forYYT_btn() {
		return send_forYYT_btn;
	}

	public static ImageIcon getSend_forYYT_btn_pressed() {
		return send_forYYT_btn_pressed;
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

	public static ImageIcon getToYYT_forZZZX_btn() {
		return toYYT_forZZZX_btn;
	}

	public static ImageIcon getToYYT_forZZZX_btn_pressed() {
		return toYYT_forZZZX_btn_pressed;
	}

	public static ImageIcon getToTransferCtr_forZZZX_btn() {
		return toTransferCtr_forZZZX_btn;
	}

	public static ImageIcon getToTransferCtr_forZZZX_btn_pressed() {
		return toTransferCtr_forZZZX_btn_pressed;
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
