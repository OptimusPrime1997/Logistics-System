package ui.goodsui;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsExpressType;
import bl.goodsbl.GoodsLogisticState;
import util.MyButton;
import util.MyTextField;

public class GoodsPanel extends JPanel{
	
/*
 *
	
 */	private MyButton okbtn;
	private JFrame frame;
	private MyTextField lisNumTxt;
	private MyTextField senderName;
	private MyTextField senderAddress;
	private MyTextField senderCompany;
	private MyTextField senderPhone;
	private MyTextField receiverName;
	private MyTextField receiverAddress;
	private MyTextField receiverCompany;
	private MyTextField receiverPhone;
	private MyTextField numOfGoods;
	private MyTextField weight;
	private MyTextField volume;
	private MyTextField nameOfInside;
	private MyTextField expressType;
	private MyTextField moneyOfPackage;
	
	public GoodsPanel(){
		frame = new JFrame();
		okbtn=new MyButton("提交", 220, 300, 20, 10);
		this.add(okbtn);
		
		frame.setVisible(true);
		frame.setContentPane(this);
		frame.setBounds(250, 80, 900, 600);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
	    
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
}
