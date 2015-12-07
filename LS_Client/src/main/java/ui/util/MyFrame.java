package ui.util;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MyFrame extends JFrame{
	public MyFrame(int width,int height,JPanel panel){
		this.setSize(width, height);
		this.setVisible(true);
		this.setContentPane(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	}
	public MyFrame(JPanel panel){
		this.setSize(830,590);
		this.setVisible(true);
		this.setContentPane(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
