package ui.util;

import java.awt.Color;

import javax.swing.JTextField;

public class MyTextField extends JTextField{
	
	public MyTextField(TextType type,int x,int y,int width, int height){
		setBounds(x, y, width, height);
		
		switch(type){
		case FEEDBACK:
			setHorizontalAlignment(JTextField.CENTER);
			setForeground(Color.magenta);
			setEditable(false);
			break;
		case INPUT:
			setForeground(Color.black);
			break;
		case UNCHANGEBAL:
			setHorizontalAlignment(JTextField.CENTER);
			setForeground(Color.black);
			setEditable(false);
			break;
		default:
			break;
		}
		
	}

}
