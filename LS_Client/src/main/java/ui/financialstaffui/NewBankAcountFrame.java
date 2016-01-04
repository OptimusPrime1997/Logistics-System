package ui.financialstaffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.html.parser.ContentModel;

import ui.Img;
import ui.componentfactory.ComponentFactory;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyFrame;
import ui.util.MyLabel;
import ui.util.MyTextField;
import ui.util.NumOnlyDocument;
import ui.util.TextType;
import util.enumData.ResultMessage;

public class NewBankAcountFrame extends JFrame {
	private int mousePressedX;
	private int mousePressedY;

	/**
	 * Creates new form MainFrame
	 */

	 public NewBankAcountFrame(FinancialStaffJFrame parentFrame) {
//		MyFrame.changeLook();
		this.financialStaffJFrame=parentFrame;
		this.setResizable(false);
		setTitle("新增银行账户");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mousePressedX = e.getX();
				mousePressedY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = (int) getLocation().getX();
				int y = (int) getLocation().getY();
				setLocation(x + e.getX() - mousePressedX, y + e.getY()
						- mousePressedY);
			}
		});
		initComponents();
		this.setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		this.setVisible(true);
	}

	private void initComponents() {
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(Img.getBackground_main(), 0, 0, width, height,
						null);
			}
		};
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		initTxt();
		initbtn();
		initLabel();
		initLayout();
	}

	private void initLabel() {
		title_label=new MyLabel("新增银行账户", width/2-68, 27, 180, 30);
		title_label.setFont(new Font("宋体",Font.BOLD,20));
		num_label = new MyLabel("银行账号", 120, 98, 60, 15);
		name_label = new MyLabel("账户名称", 120, 143, 60, 15);
		balance_label=new MyLabel("余额", 120, 188, 30, 15);
	}

	private void initTxt() {
		// 创建对象
		num_text = new MyTextField(TextType.INPUT,185, 90, 150, 30);
		num_text.setDocument(new NumOnlyDocument());
		num_text.setText(bankAccountNumTip);
		num_text.addMouseListener(new MouseAdapter() {
			public void MouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				num_textMouseClicked(e);
			}
		});
		name_text=new MyTextField(TextType.INPUT, 185, 135, 150, 30);
		name_text.setText(bankAccountNameTip);
		name_text.addMouseListener(new MouseAdapter() {
			public void MouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				name_textMouseClicked(e);
			}
		});
		
		
		balance_text = new MyTextField(TextType.INPUT, 185, 180, 150, 30);
		balance_text.setText(balanceTip);
		balance_text.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				balance_textMouseClicked(evt);
			}
		});

		feedback_text = new MyTextField(TextType.FEEDBACK, 30, 300, 400, 30);
		this.feedback_text.setText("");
	}

	private void initbtn() {
		return_btn=new MyButton(120,230,ButtonType.BACK);
		return_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				return_btnMouseClicked();
			}
		});
		comfirm_btn = new MyButton(240, 230, ButtonType.OK);
		comfirm_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirm_btnMouseClicked();
			}
		});
		exit_btn = new MyButton(410, 7, ButtonType.EXIT);
		exit_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit_btnMouseClicked();
			}
		});

	}


	/**
	 * 监听们
	 */
	protected void confirm_btnMouseClicked() {
		// TODO Auto-generated method stub
		String bankAccountNum=num_text.getText();
		String bankAccountName=name_text.getText();
		double balance=Double.parseDouble(balance_text.getText());
		ResultMessage rmsg=financialStaffJFrame.addBankAccount(bankAccountNum, bankAccountName, balance);
		ComponentFactory.setState(ResultMessage.toFriendlyString(rmsg), ComponentFactory.DISPLAY_TIME, feedback_text);
		if(rmsg==ResultMessage.SUCCESS){
			financialStaffJFrame.setEnabled(true);
			this.dispose();
		}
	}

	private void return_btnMouseClicked() {
		// TODO Auto-generated method stub
		financialStaffJFrame.setEnabled(true);
		this.dispose();
	}
	private void exit_btnMouseClicked() {
		return_btnMouseClicked();
	}


	/**
	 * name_text listener
	 */

	private void num_textMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getButton()==MouseEvent.BUTTON1){
		if(num_text.getText().equals(bankAccountNumTip)){
			num_text.setText("");
		}
		}
	}
	private void name_textMouseClicked(MouseEvent evt) {
		if(name_text.getText().equals(bankAccountNameTip)){
			name_text.setText("");
		}
	}
	private void balance_textMouseClicked(java.awt.event.MouseEvent evt) {
		if(evt.getButton()==MouseEvent.BUTTON1){
			if (balance_text.getText().equals(balanceTip)) {
				balance_text.setText("");
			}
		}
	}


	private void initLayout() {
		contentPane.setLayout(null);
		contentPane.setSize(width, height);
		contentPane.add(title_label);
		contentPane.add(num_label);
		contentPane.add(name_label);
		contentPane.add(balance_label);
		
		contentPane.add(num_text);
		contentPane.add(name_text);
		contentPane.add(balance_text);
		
		contentPane.add(feedback_text);
		contentPane.add(return_btn);
		contentPane.add(comfirm_btn);
		contentPane.add(exit_btn);
		this.setContentPane(contentPane);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private FinancialStaffJFrame financialStaffJFrame;
	private MyTextField feedback_text, balance_text, num_text, name_text;
	final String bankAccountNumTip = "请输入19位银行账号", bankAccountNameTip = "请输入完整银行账户名称",balanceTip="请输入余额";
	private MyButton comfirm_btn,return_btn, exit_btn;
	private MyLabel num_label, name_label,balance_label,title_label;
	private JPanel contentPane;
	private final int width = 480, height = 350;
	// End of variables declaration//GEN-END:variables
}

