package util;

import .JFrame;
import .JPanel;
import .WindowConstants;

public class MyFrame extends JFrame{
	public MyFrame(int width,int height,JPanel panel){
		this.setSize(width, height);
		this.setVisible(true);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	}
}
