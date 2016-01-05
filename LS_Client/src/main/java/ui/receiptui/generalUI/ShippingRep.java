/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.generalUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Exception.ExceptionPrint;
import VO.Receipt.ShippingRepVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.receiptblservice.ShippingRepblService;
import ui.receiptui.ReceiptCheckUI.ShippingCheck;
import ui.util.MyFrame;
import util.CurrentCity;
import util.enumData.City;

/**
 *
 * @author apple
 */
public class ShippingRep extends javax.swing.JPanel {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private MyFrame myFrame;
	private javax.swing.JButton addButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton checkAllRepsButton;
	private javax.swing.JLabel dateLabel;
	private javax.swing.JTextField dateText;
	private javax.swing.JLabel destinationLabel;
	private javax.swing.JTextField destinationText;
	private javax.swing.JLabel driverLabel;
	private javax.swing.JTextField driverText;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable;
	private javax.swing.JLabel numLabel;
	private javax.swing.JTextField numText;
	private javax.swing.JLabel officeLabel;
	private javax.swing.JTextField officeText;
	private javax.swing.JButton okButton;
	private javax.swing.JLabel orderLabel;
	private javax.swing.JTextField orderText;
	private javax.swing.JLabel plateLabel;
	private javax.swing.JTextField plateText;
	private javax.swing.JTextField resultMsgText;
	private ShippingRepblService control;
	private DefaultTableModel model;
	private Vector<String> columnIdentifiers;
	private Vector<Object> dataVector;
	private String officeID;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form ShipmentRep
	 */
	public ShippingRep() {
		initComponents();
		myFrame = new MyFrame(437, 492, this);
		myFrame.setTitle("中转中心装车单");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		dateText = new javax.swing.JTextField();
		dateLabel = new javax.swing.JLabel();
		officeText = new javax.swing.JTextField();
		officeLabel = new javax.swing.JLabel();
		numLabel = new javax.swing.JLabel();
		numText = new javax.swing.JTextField();
		plateLabel = new javax.swing.JLabel();
		plateText = new javax.swing.JTextField();
		driverLabel = new javax.swing.JLabel();
		driverText = new javax.swing.JTextField();
		cancelButton = new javax.swing.JButton();
		okButton = new javax.swing.JButton();
		destinationLabel = new javax.swing.JLabel();
		addButton = new javax.swing.JButton();
		orderText = new javax.swing.JTextField();
		orderLabel = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable = new javax.swing.JTable();
		destinationText = new javax.swing.JTextField();
		resultMsgText = new javax.swing.JTextField();
		checkAllRepsButton = new javax.swing.JButton();
        control = ControllerFactoryImpl.getInstance().getShippingRepblService();
		columnIdentifiers = new Vector<String>();
		dataVector = new Vector<Object>();
		model = new DefaultTableModel(dataVector, columnIdentifiers) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		setBackground(new java.awt.Color(255, 255, 255));

		dateText.setEditable(false);
		dateText.setText(control.getDate());

		dateLabel.setText("日期:");

		officeText.setEditable(false);
		try {
			officeText.setText(City.toString(CurrentCity.getCurrentCity()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
		officeID = CurrentCity.getCurrentOptorID(officeText.getText());

		officeLabel.setText("中转中心:");

		numLabel.setText("编号:");

		numText.setEditable(false);
		String num = officeID + "000";
		num += control.getDateInNum(dateText.getText());
		num += "4";
		try {
			num += control.createNum(dateText.getText(), officeID);
			numText.setText(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}

		plateLabel.setText("车牌号:");

		driverLabel.setText("司机编号:");

		cancelButton.setText("取消");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		okButton.setText("确认");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		destinationLabel.setText("目的地:");

		addButton.setText("添加");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});

		orderLabel.setText("订单号:");

		columnIdentifiers.add("订单号");
		columnIdentifiers.add("删除");
		model.setDataVector(dataVector, columnIdentifiers);
		jTable.setModel(model);
		jTable.setGridColor(new java.awt.Color(0, 0, 0));
		jScrollPane2.setViewportView(jTable);

		resultMsgText.setEditable(false);

		checkAllRepsButton.setText("查看所有单据");
		checkAllRepsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkAllRepsButtonActionPerformed(evt);
			}
		});

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
				if (col == 1) {
					model.removeRow(row);
					jTable.setModel(model);
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
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plateLabel)
                    .addComponent(numLabel)
                    .addComponent(destinationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinationText, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(driverLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(driverText, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkAllRepsButton)
                .addGap(40, 40, 40)
                .addComponent(officeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateText)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(okButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addButton)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(orderLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(orderText, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(resultMsgText)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel)
                    .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(officeLabel)
                    .addComponent(checkAllRepsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numLabel))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plateLabel)
                    .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driverLabel)
                    .addComponent(driverText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationLabel)
                    .addComponent(destinationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderLabel))
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(cancelButton))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
	}// </editor-fold>//GEN-END:initComponents

	private void setColumn() {
		TableColumn column1 = jTable.getColumnModel().getColumn(0);
		column1.setPreferredWidth(105);
		TableColumn column2 = jTable.getColumnModel().getColumn(1);
		column2.setPreferredWidth(50);
	}

	private void checkAllRepsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new ShippingCheck(officeID);
	}

	private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		resultMsgText.setText("");
		String order = orderText.getText();
		if(order.equals("")){
			resultMsgText.setText("请填写订单号");
			return;
		}
    	if(checkRepeat(order)){
    		resultMsgText.setText("该订单号已填写");
    		return;
    	}
		String resultMessage = control.checkNum(order, 10, "编号");
		resultMsgText.setText(resultMessage);
		if (!resultMessage.equals("添加成功")) {
			return;
		}
		if (!control.isTrueOrder(order)) {
			resultMsgText.setText("未找到该订单");
			return;
		}
		Vector<String> arr = new Vector<String>();
		arr.add(order);
		dataVector.add(arr);
		model.setDataVector(dataVector, columnIdentifiers);
		setColumn();
		orderText.setText("");
	}

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		myFrame.dispose();
	}

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if(plateText.getText().equals("")){
			resultMsgText.setText("请填写车牌号");
			return;
		}
		String plate = plateText.getText();
		if(!control.checkVehicle(plate)){
			resultMsgText.setText("请填写本城市车辆");
			return;
		}
		if(driverText.getText().equals("")){
			resultMsgText.setText("请填写司机编号");
			return;
		}
		if(destinationText.getText().equals("")){
			resultMsgText.setText("请填写目的地");
			return;
		}
		String driverNum = driverText.getText();
		String resultMessage = control.checkNum(driverNum, 11, "司机编号");
		
		resultMsgText.setText(resultMessage);
		if (!resultMessage.equals("添加成功")) {
			return;
		}
		if (!control.isTrueAccount(driverNum)) {
			resultMsgText.setText("未找到该司机");
			return;
		}
		String num = numText.getText();
		String date = dateText.getText();
		ArrayList<String> orders = new ArrayList<String>();
		for (int i = 0; i < dataVector.size(); i++) {
			orders.add((String) jTable.getValueAt(i, 0));
		}
		ShippingRepVO shippingRepVO = new ShippingRepVO(num, date, officeText.getText(), plateText.getText(), driverNum,
				orders, destinationText.getText());
		try {
			control.submit(shippingRepVO);
		} catch (NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
			return;
		}
		myFrame.dispose();
	}
	
    private boolean checkRepeat(String num){
    	for(int i = 0;i < dataVector.size();i++){
    		if(((String)jTable.getValueAt(i, 0)).equals(num)){
    			return true;
    		}
    	}
    	return false;
    }

}
