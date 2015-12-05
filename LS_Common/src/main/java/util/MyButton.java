package util;

import .JButton;

public class MyButton extends JButton{
	public MyButton(String text,int x,int y,int w,int h){
		this.setText(text);
		this.setBounds(x, y, w,h);
	}
}
