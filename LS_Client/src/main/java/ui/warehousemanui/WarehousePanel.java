/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.warehousemanui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import main.MainFrame;
import ui.Img;
import ui.receiptui.generalUI.InStockRep;
import ui.receiptui.generalUI.OutStockRep;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyLabel;
import bl.controllerfactorybl.ControllerFactoryImpl;
import bl.loginbl.LoginblController;
import blservice.stockblservice.StockBLService;

/**
 *
 * @author G
 */
public class WarehousePanel extends javax.swing.JFrame {
	
	

    /**
     * Creates new form NewJFrame
     */
    public WarehousePanel() {
    	try {
			username = new LoginblController().getCurrentName();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	panel=new JPanel(){
			/* (non-Javadoc)
			 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
			 */
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(Img.getBackground_main(),0, 0, null);
			}
		};
    	
		panel.setLayout(null);
	
        initComponents();
        this.setContentPane(panel);
        
      
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
		
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));        
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	/**
    	 * 设置窗体大小为不可变
    	 */
    	this.setResizable(false);
    	/**
    	 * 设置窗体在中部出现
    	 */
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	Dimension screensize = tk.getScreenSize();
    	int screenh = screensize.height;
    	int screenw = screensize.width;
    	this.setSize(800, 500);
    	this.setLocation(screenw/2-this.getWidth()/2, screenh/2-this.getHeight()/2);
    	/**
    	 * 关闭窗口
    	 */
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
   

        Peking1 = new javax.swing.JProgressBar();      
        Peking1Label = new MyLabel("北京01", 50, 65, 50, 10);
        Peking2Label = new MyLabel("北京02", 230, 65, 50, 10);
        Peking2 = new javax.swing.JProgressBar();
        Shanghai1Label = new MyLabel("上海01", 410, 65, 50, 10);
        Shanghai1 = new javax.swing.JProgressBar();
        Shanghai2Label = new MyLabel("上海02", 590, 65, 50, 10);
        Shanghai2 = new javax.swing.JProgressBar();
        Nanjing1Label = new MyLabel("南京01", 50, 110, 50, 10);
        Nanjing1 = new javax.swing.JProgressBar();
        Nanjing2Label = new MyLabel("南京02", 230, 110, 50, 10);
        Nanjing2 = new javax.swing.JProgressBar();
        Guangzhou1Label = new MyLabel("广州01", 410, 110, 50, 10);
        Guangzhou1 = new JProgressBar();
        Guangzhou2Label = new MyLabel("广州02", 590, 110, 50, 10);
        Guangzhou2 = new javax.swing.JProgressBar();
        outRepButton = new MyButton(80, 300, ButtonType.STOCK_OUT);
        inRepButton = new MyButton(80, 200, ButtonType.STOCK_IN);
        exit = new MyButton(750, 10, ButtonType.EXIT);
        userLabel = new MyLabel("当前账户: "+username ,  590, 20, 300, 10);
        divisionChangeButton = new MyButton(300, 300, ButtonType.STOCK_CHANGE);
        iniNumButton = new MyButton(520, 300, ButtonType.STOCK_INPUT);
        showButton = new MyButton(520, 200, ButtonType.STOCK_SHOW);
        checkButton = new MyButton(300, 200, ButtonType.STOCK_CHECK);

  
        panel.add(Guangzhou1);
        Guangzhou1.setBounds(470, 105, 100, 20);
        panel.add(Guangzhou2);
        Guangzhou2.setBounds(650, 105, 100, 20);
        panel.add(Nanjing1);
        Nanjing1.setBounds(110, 105, 100, 20);
        panel.add(Nanjing2);
        Nanjing2.setBounds(290, 105, 100, 20);
        panel.add(Peking1);
        Peking1.setBounds(110, 60, 100, 20);
        panel.add(Peking2);
        Peking2.setBounds(290, 60, 100, 20);
        panel.add(Shanghai1);
        Shanghai1.setBounds(470, 60, 100, 20);
        panel.add(Shanghai2);
        Shanghai2.setBounds(650, 60, 100, 20);
        panel.add(exit);
        panel.add(outRepButton);
        
        panel.add(inRepButton);
        panel.add(divisionChangeButton);
        panel.add(iniNumButton);
        panel.add(showButton);
        panel.add(checkButton);
        panel.add(Peking1Label);
        panel.add(Peking2Label);
        panel.add(Shanghai1Label);
        panel.add(Shanghai2Label);
        panel.add(Nanjing1Label);
        panel.add(Nanjing2Label);
        panel.add(Guangzhou1Label);
        panel.add(Guangzhou2Label);
        panel.add(userLabel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //TODO to show, 1000--->10  
        showProgressBar(Peking1, 10, Color.PINK);
        showProgressBar(Peking2, 10, Color.PINK);
        showProgressBar(Shanghai1, 10, Color.BLUE);
        showProgressBar(Shanghai2, 10, Color.BLUE);
        showProgressBar(Nanjing1, 10, Color.BLUE);
        showProgressBar(Nanjing2, 10, Color.BLUE);
        showProgressBar(Guangzhou1, 10, Color.BLUE);
        showProgressBar(Guangzhou2, 10, Color.BLUE);

      

        showProcess();
        
        outRepButton.setText("出库单填写");
        outRepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outRepButtonActionPerformed(evt);
            }
        });

        inRepButton.setText("入库单填写");
        inRepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inRepButtonActionPerformed(evt);
            }
        });


        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });


        divisionChangeButton.setText("调整分区");
        
        divisionChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divisionChangeButtonActionPerformed(evt);
            }
        });

        iniNumButton.setText("输入最初库存数量");
        iniNumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniNumButtonActionPerformed(evt);
            }
        });

        showButton.setText("盘点仓库所有货物");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					showButtonActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (NotBoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        checkButton.setText("库存查看");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

    }
    

    
  

	private void outRepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	JFrame frame = new JFrame();
    	
    	frame.setResizable(false);
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	Dimension screensize = tk.getScreenSize();
    	int screenh = screensize.height;
    	int screenw = screensize.width;
    	frame.setSize(600, 600);
    	frame.setLocation(screenw/2-this.getWidth()/2, screenh/2-this.getHeight()/2);	
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
		OutStockRep out = new OutStockRep(frame);
    	frame.setContentPane(out);
    	frame.setVisible(true);
    	this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inRepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed    	
    	JFrame frame = new JFrame();
    	
    	frame.setResizable(false);
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	Dimension screensize = tk.getScreenSize();
    	int screenh = screensize.height;
    	int screenw = screensize.width;
    	frame.setSize(500, 600);
    	frame.setLocation(screenw/2-this.getWidth()/2, screenh/2-this.getHeight()/2);	
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
		InStockRep in = new InStockRep(frame);
    	frame.setContentPane(in);
    	frame.setVisible(true);
    	
    	this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    	this.dispose();
    	new MainFrame();
    	
    }//GEN-LAST:event_jButton3ActionPerformed

    private void divisionChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    	DivisionChangePanel dc = new DivisionChangePanel();
    	dc.setVisible(true);
    	this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void iniNumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    	
    	InitialStockNumPanel ini = new InitialStockNumPanel();
    	ini.setVisible(true);
    	this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    StockBLService s = ControllerFactoryImpl.getInstance().getStockController();
    
    /**
  	 * 
  	 */
    //TODO 

  	public void showProcess() {
  		try {

			Peking1.setValue(s.checkPresentStockQuantity(1));
			System.out.println("block1 "+s.checkPresentStockQuantity(1));
			Peking2.setValue(s.checkPresentStockQuantity(2));
			System.out.println("block2 "+s.checkPresentStockQuantity(2));
			Nanjing1.setValue(s.checkPresentStockQuantity(3));
			System.out.println("block3 "+s.checkPresentStockQuantity(3));
			Nanjing2.setValue(s.checkPresentStockQuantity(4));
			System.out.println("block4 "+s.checkPresentStockQuantity(4));
			Shanghai1.setValue(s.checkPresentStockQuantity(5));
			System.out.println("block5 "+s.checkPresentStockQuantity(5));
			Shanghai2.setValue(s.checkPresentStockQuantity(6));
			System.out.println("block6 "+s.checkPresentStockQuantity(6));
			Guangzhou1.setValue(s.checkPresentStockQuantity(7));
			System.out.println("block7 "+s.checkPresentStockQuantity(7));
			Guangzhou2.setValue(s.checkPresentStockQuantity(8));
			System.out.println("block8 "+s.checkPresentStockQuantity(8));
		
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			//
			e.printStackTrace();
			System.out.println("进度条显示崩了");
			
		}
  		
  	}
    
    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, NotBoundException, IOException {//GEN-FIRST:event_jButton6ActionPerformed
    	
    	StockShowPanel ss = new StockShowPanel();
    	ss.setVisible(true);
    	this.dispose();
    	
    	
    }//GEN-LAST:event_jButton6ActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    	StockCheckPanel sc = new StockCheckPanel();
    	sc.setVisible(true);
    	this.dispose();
    	
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new WarehousePanel();
        
    }
    
    private void showProgressBar(JProgressBar bar, int max, Color color) {
    	bar.setMaximum(max);
    	bar.setForeground(color);
    	bar.setOpaque(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MyButton outRepButton;
    private MyButton inRepButton;
    private MyButton exit;
    private MyButton divisionChangeButton;
    private MyButton iniNumButton;
    private MyButton showButton;
    private MyButton checkButton;
    private MyButton back;//返回
    private MyLabel Peking1Label;
    private MyLabel Peking2Label;
    private MyLabel Shanghai1Label;
    private MyLabel Shanghai2Label;
    private MyLabel Nanjing1Label;
    private MyLabel Nanjing2Label;
    private MyLabel Guangzhou1Label;
    private MyLabel Guangzhou2Label;
    private MyLabel userLabel;
    private javax.swing.JProgressBar Peking2;
    private JProgressBar Peking1;
    private JProgressBar Shanghai1;
    private JProgressBar Shanghai2;
    private JProgressBar Nanjing1;
    private JProgressBar Nanjing2;
    private JProgressBar Guangzhou1;
    private JProgressBar Guangzhou2;
    private String username;
    private int mousePressedX;
	private int mousePressedY;
	private JPanel panel;

    // End of variables declaration//GEN-END:variables
}
