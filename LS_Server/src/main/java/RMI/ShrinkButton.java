package RMI;

import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ShrinkButton extends JButton {
	public ShrinkButton(int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		Image image0 = (new ImageIcon("pic/shrink_btn.png")).getImage()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		Image image1 = new ImageIcon("pic/shrink_btn_pressed.png").getImage()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		ImageIcon icon0 = new ImageIcon(image0);
		ImageIcon icon1 = new ImageIcon(image1);
		setIcon(icon0);
		setRolloverIcon(icon1);

	}
}
