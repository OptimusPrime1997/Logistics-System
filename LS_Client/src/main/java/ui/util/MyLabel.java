package ui.util;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	public MyLabel(String content,int x,int y,int width,int height){
		setBounds(x, y, width, height);
		setText(content);
		
	}
}
