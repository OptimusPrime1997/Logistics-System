/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import ui.Img;
import ui.util.MyButton;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsExpressType;
import util.enumData.GoodsLogisticState;
import VO.GoodsVO;

/**
 *
 * @author Administrator
 */
public class LogisticStateUI extends javax.swing.JFrame {
	private int mousePressedX;
	private int mousePressedY;
	public static void main(String[] args) {
		GoodsVO vo = new GoodsVO("0250000123", false, "02400100006014",
				"", "2015-12-23", "", "025", "李华",
				"上海市浦东新区张杨路500号", "上海华润时代广场", "87511426", "陆宏",
				"南京市栖霞区仙林大道和园12号", null, "15500001112", 1, 5, 8, "书",
				GoodsExpressType.NORMAL, 5, 0, 0, GoodsArrivalState.INTACT,
				GoodsLogisticState.SENDED, null, null,"2015-12-23");
		new LogisticStateUI(vo );
	}
    public LogisticStateUI(GoodsVO vo) {
    	this.vo = vo;
    	initComponents();
        listNum_label.setText(vo.listNum);
        this.setResizable(false);
    	this.setSize(width,height);
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
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
    }
    private void exit_btnMouseClicked (MouseEvent e) {
		this.dispose();
	}
    private void initComponents() {
    	panel=new JPanel(){
    		@Override
    	protected void paintComponent(Graphics g) {
    		g.drawImage(Img.getBackground_searchState(), 0, 0, this.getWidth(),this.getHeight(),null);
    	}};
    	exit_btn=new MyButton(288, 3, 10, 10, 1);
    	exit_btn.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			exit_btnMouseClicked(e);
    		}
		});
    	
    	panel.setLayout(null);
        listNum_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.setBounds(30,30,250,150);
        listNum_label.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel2.setText("物流信息");
        jLabel2.setBounds(10, 10, 50, 30);
        jLabel3.setText("订单号");
        int count=0;
        String[] dates=vo.dates.split(" ");
        content=new Object[dates.length][2];
        for(String date:dates){
        	content[count][0]=date;
        	content[count][1]=GoodsLogisticState.toFriendlyString(GoodsLogisticState.get(count));
        	count++;
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            content,
            new String [] {
                "时间", "物流状态"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        panel.add(jLabel2);
        panel.add(jLabel3);
        panel.add(listNum_label);
        panel.add(jTable1);
        panel.add(jScrollPane1);
        panel.add(exit_btn);
        this.setContentPane(panel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel listNum_label;
    private JPanel panel;
    private MyButton exit_btn;
    private GoodsVO vo;
    private final int width=300,height=200;
    private Object[][] content;
    // End of variables declaration//GEN-END:variables
}
