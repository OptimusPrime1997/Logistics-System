package ui.goodsui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.MyButton;
import util.MyLabel;
import util.MyTextField;

public class GoodsPanel extends JPanel{
	
	private MyButton okbtn;
	private JFrame frame;
	private MyLabel nameOfThisPanel;
	private MyLabel senderNamelabel;
	private MyLabel senderAddresslabel;
	private MyLabel senderCompanylabel;
	private MyLabel senderPhonelabel;
	private MyLabel receiverNamelabel;
	private MyLabel receiverAddresslabel;
	private MyLabel receiverCompanylabel;
	private MyLabel receiverPhonelabel;
	private MyLabel numOfGoodslabel;
	private MyLabel weightlabel;
	private MyLabel volumelabel;
	private MyLabel nameOfInsidelabel;
	private MyLabel expressTypelabel;
	private MyLabel moneyOfPackagelabel;
	
	
	private MyTextField senderNametxt;
	private MyTextField senderAddresstxt;
	private MyTextField senderCompanytxt;
	private MyTextField senderPhonetxt;
	private MyTextField receiverNametxt;
	private MyTextField receiverAddresstxt;
	private MyTextField receiverCompanytxt;
	private MyTextField receiverPhonetxt;
	private MyTextField numOfGoodstxt;
	private MyTextField weighttxt;
	private MyTextField volumetxt;
	private MyTextField nameOfInsidetxt;
	private MyTextField expressTypetxt;
	private MyTextField moneyOfPackagetxt;
	
	public GoodsPanel(){
		this.setLayout(null);
		frame = new JFrame();
		frame.setBounds(250, 80, 900, 600);
		nameOfThisPanel = new MyLabel("订单", 350,10,80,25);
		okbtn=new MyButton("提交", 730,430,85,50);
		
		senderNamelabel = new MyLabel("寄件人姓名",10,40,80,25);
		senderNametxt = new MyTextField(100, 40, 80, 25); 
		senderAddresslabel = new MyLabel("寄件人地址", 10,70,80,25);
		senderAddresstxt = new MyTextField(100, 70, 480, 25); 
		senderCompanylabel = new MyLabel("寄件人公司", 10, 100, 80, 25);
		senderCompanytxt = new MyTextField(100, 100, 280, 25);
		
		
		this.add(nameOfThisPanel);
		this.add(okbtn);
		this.add(senderNametxt);
		this.add(senderNamelabel);
		this.add(senderAddresslabel);
		this.add(senderAddresstxt);
		this.add(senderCompanylabel);
		this.add(senderCompanytxt);
		frame.setVisible(true);
		frame.setContentPane(this);
		
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
	    
	}
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//	}
}
