package ui.util;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	public MyLabel(String content,int x,int y,int width,int height){
		setBounds(x, y, width, height);
		setText(content);
		setFont(new Font("", 1, 14));
		
	}
}
