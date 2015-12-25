/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.ReceiptDetailUI;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Exception.ExceptionPrint;
import Exception.NumNotFoundException;
import VO.Receipt.ShipmentRepVO;
import bl.receiptbl.ShipmentRepbl.ShipmentRepController;
import blservice.receiptblservice.ShipmentRepblServce;
import ui.util.MyFrame;

/**
 *
 * @author apple
 */
public class Shipment extends javax.swing.JPanel {
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MyFrame myFrame;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel driverLabel;
    private javax.swing.JTextField driverText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel plateLabel;
    private javax.swing.JTextField plateText;
    private javax.swing.JTextField resultMsgText;
    private ShipmentRepblServce control;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    private String num;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form Shipment
     */
    public Shipment(String oriNum) {
    	num = oriNum;
        initComponents();
        myFrame = new MyFrame(457, 337, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numText = new javax.swing.JTextField();
        numLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        plateLabel = new javax.swing.JLabel();
        plateText = new javax.swing.JTextField();
        driverLabel = new javax.swing.JLabel();
        driverText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        control = new ShipmentRepController();
        columnIdentifiers = new Vector<String>();
        dataVector = new Vector<Object>();
		model = new DefaultTableModel(dataVector, columnIdentifiers) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

        setBackground(new java.awt.Color(255, 255, 255));

        numText.setEditable(false);

        numLabel.setText("编号:");

        dateText.setEditable(false);

        dateLabel.setText("日期:");

        plateLabel.setText("车牌号:");

        plateText.setEditable(false);

        driverLabel.setText("司机编号:");

        driverText.setEditable(false);

        okButton.setText("完成");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        resultMsgText.setEditable(false);
        
        ShipmentRepVO shipmentRepVO = null;
        try {
			shipmentRepVO = control.getRepByNum(num);
		} catch (ClassNotFoundException | NotBoundException | IOException | NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        dateText.setText(shipmentRepVO.date);
        numText.setText(num);
        plateText.setText(shipmentRepVO.plateNum);
        driverText.setText(shipmentRepVO.driverNum);
        columnIdentifiers.add("订单号");
        try {
			dataVector = control.initShow(num);
		} catch (ClassNotFoundException | NotBoundException | IOException | NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        model.setDataVector(dataVector, columnIdentifiers);
        jTable.setModel(model);
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(driverLabel)
                    .addComponent(plateLabel)
                    .addComponent(numLabel)
                    .addComponent(dateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(driverText, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(resultMsgText)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLabel)
                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numLabel)
                            .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plateLabel)
                            .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(driverLabel)
                            .addComponent(driverText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(okButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	myFrame.dispose();
    }

}
