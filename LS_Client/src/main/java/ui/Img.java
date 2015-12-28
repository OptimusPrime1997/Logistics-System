package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Img {
	private static Image background_login = new ImageIcon("pic/background_login.png")
			.getImage();
	private static Image background_main=new ImageIcon("pic/background_main.png").getImage();
	private static Image background_searchState=new ImageIcon("pic/background_searchState.png").getImage();
	
	
	private static ImageIcon button0=new ImageIcon("pic/btn_all.png");
	private static ImageIcon button_over=new ImageIcon("pic/btn_all_pressed.png");
	
	private static ImageIcon btn_search=new ImageIcon("pic/btn_search0.png");
	private static ImageIcon btn_login=new ImageIcon("pic/btn_login.png");
	
	private static ImageIcon buttonBig=new ImageIcon("pic/btn_big.png");
	private static ImageIcon buttonBig_p=new ImageIcon("pic/btn_big_pressed.png");
	
	private static ImageIcon exit_btn=new ImageIcon("pic/btn_exit0.png");
	private static ImageIcon exit_btn_pressed=new ImageIcon("pic/btn_exit1.png");
	
	public static ImageIcon getExit_btn() {
		return exit_btn;
	}

	public static ImageIcon getBtn_search() {
		return btn_search;
	}

	public static ImageIcon getBtn_login() {
		return btn_login;
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

	public static void main(String[] args) {
		JPanel panel = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(Img.background_login, 0,0, 100, 100, null);
			}
		};
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
