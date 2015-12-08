/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.mainFrame;

import javax.swing.WindowConstants;

import VO.GoodsVO;

/**
 *
 * @author Administrator
 */
public class LogisticStateUI extends javax.swing.JFrame {

    /**
     * Creates new form LogisticStateUI
     * @param vo 
     */
    public LogisticStateUI(GoodsVO vo) {
    	this.vo=vo;
        initComponents();
        this.setVisible(true);
    }
    private void initComponents() {
    	setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    	initLabel();
    	initbtn();
    	initScroll();
    	initTable();
    	initLayout();
    }

    private void initTable() {
    	state_table = new javax.swing.JTable();
        state_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "时间", "状态"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
	}
	private void initScroll() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(state_table);
	}
	private void initbtn() {
		// TODO Auto-generated method stub
		
	}
	private void initLayout() {
    	 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addContainerGap(46, Short.MAX_VALUE)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(38, 38, 38))
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addGap(35, 35, 35)
                 .addComponent(jLabel3)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(jLabel1)
                 .addGap(18, 18, 18)
                 .addComponent(listNum_label)
                 .addGap(84, 84, 84))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1)
                     .addComponent(listNum_label)
                     .addComponent(jLabel3))
                 .addGap(57, 57, 57)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(75, Short.MAX_VALUE))
         );

         pack();
		
	}
	private void initLabel() {
    	  jLabel1 = new javax.swing.JLabel();
          listNum_label = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          
          jLabel1.setText("订单号");
          jLabel3.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
          jLabel3.setText("物流信息");
          listNum_label.setText(vo.listNum);
          
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listNum_label;
    private javax.swing.JTable state_table;
    private GoodsVO vo;
    // End of variables declaration//GEN-END:variables
}
