package ui.util;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ui.Img;

public class MyButton extends JButton{
	public MyButton(){
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(Img.getButton1());
		setRolloverIcon(Img.getButton1_p());
	}
	public MyButton(int x,int y,int type){
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		switch(type){
		case 0:
			setIcon(Img.getButton0());
			setBounds(x, y, Img.getButton0().getIconWidth(), Img.getButton0().getIconHeight());
			setRolloverIcon(Img.getButton_over());
			break;
		case 1:
			setIcon(Img.getExit_btn());
			setRolloverIcon(Img.getExit_btn_pressed());
			setBounds(x, y, Img.getExit_btn().getIconWidth(), Img.getExit_btn().getIconHeight());
			
			break;

		}
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		MyButton btn=new MyButton();
		btn.setBounds(0,0,20,20);
		panel.add(btn);
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(600, 800);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
