package util;

import .JLabel;

public class MyLabel extends JLabel{
	public MyLabel(String text,int x,int y,int w,int h) {
		this.setText(text);
		this.setBounds(x, y, w, h);
	}
}
