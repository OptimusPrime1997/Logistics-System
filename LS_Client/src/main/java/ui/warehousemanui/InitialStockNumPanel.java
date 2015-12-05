/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.warehousemanui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import .GroupLayout;
import .JFrame;

import ui.mainFrame.MainFrame;
import util.enumData.ResultMessage;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.stockblservice.StockNumBLService;


/**
 *
 * @author G
 */
public class InitialStockNumPanel extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form InitialStockNumPanel
     */
    public InitialStockNumPanel() {
        initComponents();
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
    	 * 设置窗体大小
    	 */
    	this.setSize(400, 330);
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
    	this.setLocation(screenw/2-this.getWidth()/2, screenh/2-this.getHeight()/2);
    	/**
    	 * 关闭窗口
    	 */
    	setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLabel9 = new .JLabel();
        jButton3 = new .JButton();
        jLabel1 = new .JLabel();
        jTextField1 = new .JTextField();
        jButton1 = new .JButton();
        jButton2 = new .JButton();

        
       
        jLabel9.setText("当前账户：大玉儿");

        jButton3.setText("退出");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("本仓库初始的库存数量：");

        jTextField1.setText("初始库存数量");

        jTextField1.addFocusListener(new FocusAdapter() {
        	
        	public void focusGained(FocusEvent e) {
        		jTextField1.setText("");
        	}
        
        	
		});
        
        jButton1.setText("确定");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("返回");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(.GroupLayout.Alignment.LEADING)
            .addGroup(.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(.GroupLayout.Alignment.LEADING, false)
                    .addGroup(.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(21, 21, 21)
                        .addComponent(jButton3))
                    .addGroup(.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(.LayoutStyle.ComponentPlacement.RELATED, .GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jTextField1, .GroupLayout.PREFERRED_SIZE, .GroupLayout.DEFAULT_SIZE, .GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 252, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton3))
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, .GroupLayout.PREFERRED_SIZE, .GroupLayout.DEFAULT_SIZE, .GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(106, 106, 106))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    StockNumBLService sc = ControllerFactoryImpl.getInstance().getStockNumController();
    /**
	 * @param evt
	 * 返回
	 */
	private void jButton2ActionPerformed(ActionEvent evt) {
		WarehousePanel w = new WarehousePanel();
		w.setVisible(true);
		this.dispose();
		
	}

	/**
	 * @param evt
	 * 
	 * 确定
	 */
	private void jButton1ActionPerformed(ActionEvent evt) {
		
		String s = jTextField1.getText().trim();
		ResultMessage r = sc.initial(s);
		//TODO 为了不同的界面都可以用一个状态栏类，那么可以将状态栏做成一个小frame显示在最底下，然后关联一个状态栏对象，然后调用其中的set方法
		
		
		
		
	}

	/**
	 * 
	 * @param evt
	 * 退出
	 */
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		MainFrame mf = new MainFrame();
    	mf.setVisible(true);
    	this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private .JButton jButton1;
    private .JButton jButton2;
    private .JButton jButton3;
    private .JLabel jLabel1;
    private .JLabel jLabel9;
    private .JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
