package util;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import util.enumData.ResultMessage;

public class CreateDialog {
	public static void creatDialog(ResultMessage msg,int width,int height){
		creatDialog(msg.toString(), width, height);
	}
	public static void creatDialog(String msg,int width,int height){
		JDialog dialog= new JDialog();
		JPanel panel=new JPanel();
		JLabel label=new JLabel(msg);
		panel.add(label);
		dialog.setSize(width, height);
		dialog.setContentPane(panel);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	}
	public static void creatDialog(ArrayList messages,int width,int height){
		JDialog dialog= new JDialog();
		JPanel panel=new JPanel();
		for(Object msg:messages){
			JLabel label=new JLabel(msg.toString());
			panel.add(label);
		}
		dialog.setSize(width, height);
		dialog.setContentPane(panel);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		CreateDialog.creatDialog(ResultMessage.SUCCESS, 200,200);
	}
}
