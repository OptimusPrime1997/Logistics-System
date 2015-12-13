/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.warehousemanui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.MainFrame;
import VO.StockVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.stockblservice.StockBLService;
import util.enumData.City;
import util.enumData.ResultMessage;

import java.awt.*;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

/**
 *
 * @author G
 */
public class StockShowPanel extends JFrame {

    /**
     * Creates new form StockShow
     * @throws IOException 
     * @throws NotBoundException 
     * @throws ClassNotFoundException 
     */
    public StockShowPanel() throws ClassNotFoundException, NotBoundException, IOException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws IOException 
     * @throws NotBoundException 
     * @throws ClassNotFoundException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	/**
    	 * 设置窗体大小
    	 */
    	this.setSize(600, 330);
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
    	
        jScrollPane1 = new javax.swing.JScrollPane();
       
        jLabel9 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        show = new javax.swing.JButton();
        export = new javax.swing.JButton();
        jTable1 = new JTable();
        resultMessage = new JLabel();


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [12][] 
                ,
            new String [] {
                "货物编号", "入库单号", "入库日期", "目的地", "区号", "位号"
            }
        ) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        
        
        
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setText("当前账户：大玉儿");

        exit.setText("退出");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        back.setText("返回");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        show.setText("盘点");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					showActionPerformed(evt);
				} catch (ClassNotFoundException | NotBoundException
						| IOException e) {
					e.printStackTrace();
				}
            }
        });

        export.setText("导出excel");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(

            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                .addContainerGap(284, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                        .addComponent(jLabel9)

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                        .addComponent(exit)

                        .addGap(3, 3, 3))

                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                        .addComponent(back)

                        .addGap(33, 33, 33)

                        .addComponent(show)

                        .addContainerGap())))

            .addGroup(layout.createSequentialGroup()

                .addGap(22, 22, 22)

                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addGap(0, 0, Short.MAX_VALUE))

            .addGroup(layout.createSequentialGroup()

                .addContainerGap()

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addComponent(resultMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                        .addGap(0, 0, Short.MAX_VALUE)

                        .addComponent(export, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))

                .addContainerGap())

        );

        layout.setVerticalGroup(

            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                .addContainerGap()

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                    .addComponent(jLabel9)

                    .addComponent(exit))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                        .addComponent(export)

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                        .addComponent(show))

                    .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                .addComponent(resultMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))

        );

    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    	MainFrame mf = new MainFrame();
    	mf.setVisible(true);
    	this.dispose();	
		
    }//GEN-LAST:event_jButton3ActionPerformed

    
    StockBLService s = ControllerFactoryImpl.getInstance().getStockController();
    
    /**
     * 盘点货物
     * @param evt
     * @throws ClassNotFoundException
     * @throws NotBoundException
     * @throws IOException
     */
    private void showActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, NotBoundException, IOException {//GEN-FIRST:event_jButton5ActionPerformed
    	ArrayList<StockVO> list = s.showToday();

    	int length = list.size();
    	
    	if (length == 0) {
    		showFeedback(null, "今天还没有货物入库~");
		}
    	
    	Object[][] showObjects = new Object[length][6];
    	
    	
    	int count = 0;
    	for (StockVO vo : list) {

	    	String listNum = vo.listNum;
	    	String repNum = vo.inStockRepNum;
	    	String date = vo.inStockDate;
	    	City des = vo.destination;
	    	int block = vo.block;
	    	int place = vo.place;

	    	showObjects[count][0] = listNum;
	    	showObjects[count][1] = repNum;
	    	showObjects[count][2] = date;
	    	showObjects[count][3] = des.toString(des);
	    	showObjects[count][4] = block;
	    	showObjects[count][5] = place;
	    	
	    	++count;

    	}
    	
    	
    	jTable1.setModel(new DefaultTableModel(
               showObjects
                    ,
                new String [] {
                    "货物编号", "入库单号", "入库日期", "目的地", "区号", "位号"
                }
            ) {
                /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
    	
    	
    	
    }//GEN-LAST:event_jButton5ActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    	String operation = "导出库存快照excel";
    	try {
			ResultMessage rm = s.exportExcel();

			
			showFeedback(rm, operation);
		} catch (ClassNotFoundException e) {
			showFeedback(ResultMessage.FAILED, operation);
		} catch (NotBoundException e) {
			showFeedback(ResultMessage.FAILED, operation);
		} catch (IOException e) {
			showFeedback(ResultMessage.FAILED, operation);
		}
    	
    	
    	
    }//GEN-LAST:event_jButton6ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        WarehousePanel w = new WarehousePanel();
        w.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


    private void showFeedback(ResultMessage msg, String operation) {
    	
    	if (msg.equals(ResultMessage.SUCCESS)) {
    		this.resultMessage.setForeground(Color.GREEN);
		} else {
			this.resultMessage.setForeground(Color.RED);
		}
    	
    	this.resultMessage.setText(operation + ResultMessage.toFriendlyString(msg));
	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JButton back;
    private javax.swing.JButton show;
    private javax.swing.JButton export;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JLabel resultMessage;
    // End of variables declaration//GEN-END:variables
}
