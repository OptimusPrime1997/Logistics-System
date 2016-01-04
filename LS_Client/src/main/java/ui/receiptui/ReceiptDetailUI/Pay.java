/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.ReceiptDetailUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Exception.ExceptionPrint;
import Exception.NumNotFoundException;
import VO.Receipt.PayRepVO;
import bl.receiptbl.PayRepbl.PayRepController;
import blservice.receiptblservice.PayRepblService;
import ui.util.MyFrame;

/**
 *
 * @author apple
 */
public class Pay extends javax.swing.JPanel {
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MyFrame myFrame;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField resultMsgText;
    private javax.swing.JLabel sumLabel;
    private javax.swing.JTextField sumText;
    private PayRepblService control;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    private String num;
    PayRepVO payRepVO = null;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form pay
     */
    public Pay(String oriNum) {
    	num = oriNum;
        initComponents();
        myFrame = new MyFrame(706, 397, this);
        myFrame.setTitle("付款单详细信息查看");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        numLabel = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();
        sumLabel = new javax.swing.JLabel();
        sumText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        control = new PayRepController();
        columnIdentifiers = new Vector<String>();
        dataVector = new Vector<Object>();
		model = new DefaultTableModel(dataVector, columnIdentifiers) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

        setBackground(new java.awt.Color(255, 255, 255));

        dateLabel.setText("日期:");

        dateText.setEditable(false);

        numLabel.setText("编号:");

        numText.setEditable(false);

        sumLabel.setText("总计:");

        sumText.setEditable(false);
        
        okButton.setText("完成");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        resultMsgText.setEditable(false);
        
		columnIdentifiers.add("付款项");
		columnIdentifiers.add("金额");
		columnIdentifiers.add("付款账户");
		columnIdentifiers.add("备注");
		columnIdentifiers.add("查看");
        try {
			payRepVO = control.getRepByNum(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        dateText.setText(payRepVO.date);
        numText.setText(num);
        sumText.setText(payRepVO.sum+"");
        try {
			dataVector = control.initShow(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        model.setDataVector(dataVector, columnIdentifiers);
        jTable.setModel(model);
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);
        
    	setColumn();
    	
    	jTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = jTable.getSelectedRow();
				int col = jTable.getSelectedColumn();
				if(col==4){
					String payThing = (String)jTable.getValueAt(row, 0);
					switch (payThing) {
					case "奖金":
						new PayBonus(payRepVO);
						break;
					case "快递员工资":
						new PayCourier(payRepVO);
						break;
					case "司机工资":
						new PayDriver(payRepVO);
						break;
					case "运费":
						new PayFreight(payRepVO);
						break;
					case "租金":
						new PayRent(payRepVO);
						break;
					case "人员工资":
						new PayStaff(payRepVO);
						break;
					default:
						String date = payThing.substring(3, 13);	//付款(2015-01-01)
						new PayRefund(date, payRepVO);
						break;
					}
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sumLabel)
                                    .addComponent(numLabel)
                                    .addComponent(dateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sumText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(okButton)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(resultMsgText)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLabel)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sumLabel)
                    .addComponent(sumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
	private void setColumn() {
		TableColumn column1 = jTable.getColumnModel().getColumn(0);
		column1.setPreferredWidth(100);
		TableColumn column2 = jTable.getColumnModel().getColumn(1);
		column2.setPreferredWidth(80);
		TableColumn column3 = jTable.getColumnModel().getColumn(2);
		column3.setPreferredWidth(180);
		TableColumn column4 = jTable.getColumnModel().getColumn(3);
		column4.setPreferredWidth(200);
	}

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	myFrame.dispose();
    }

}
