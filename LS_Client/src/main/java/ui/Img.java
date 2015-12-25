package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Img {
	private static Image background0 = new ImageIcon("pic/background0.png")
			.getImage();
	private static ImageIcon button=new ImageIcon("pic/btn0.png");
	private static ImageIcon button_over=new ImageIcon("pic/btn_over.png");
	public static ImageIcon getButton_over() {
		return button_over;
	}

	public static Image getBackground0() {
		return background0;
	}

	public static ImageIcon getButton() {
		return button;
	}

	public static void main(String[] args) {
		JPanel panel = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(Img.background0, 0,0, 100, 100, null);
			}
		};
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
