/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import ui.Img;
import ui.util.ButtonType;
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
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
    }
    private void exit_btnMouseClicked (MouseEvent e) {
		this.dispose();
	}
    private void initComponents() {
    	panel=new JPanel(){
    		@Override
    	protected void paintComponent(Graphics g) {
    		g.drawImage(Img.getBackground_main(), 0, 0, this.getWidth(),this.getHeight(),null);
    	}};
    	exit_btn=new MyButton(270, 3, ButtonType.EXIT);
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
        label01=new JLabel("日期");
        label02=new JLabel("物流状态");
        jScrollPane1 = new javax.swing.JScrollPane();
        listNum_label.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel2.setText("物流信息"+"  "+vo.listNum);
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setBounds(20, 5, 300, 30);
        
        label01.setBounds(20, 30, 30, 30);
        label02.setBounds(130, 30, 60, 30);
        jLabel3.setText("订单号");
        int count=0;
        String[] dates=vo.dates.split(" ");
        if(dates.length>7) content=new Object[6][2];
        else content=new Object[dates.length][2];
        //丢损 显示已丢损
        if(vo.arrivalState==GoodsArrivalState.BROKEN||vo.arrivalState==GoodsArrivalState.LOST){
        	for(int i=0;i<dates.length-1;i++){
        		if(count>=6) break;
             	content[count][0]=dates[i];
             	content[count][1]=GoodsLogisticState.toFriendlyString(GoodsLogisticState.get(count));
             	count++;
        	}
        	content[count][0]=dates[count];
        	content[count][1]=GoodsLogisticState.toFriendlyString(GoodsLogisticState.BROKEN_OR_LOST);
        }else{
        	count=0;
        	 for(String date:dates){
             	if(count>=6) break;
             	content[count][0]=date;
             	content[count][1]=GoodsLogisticState.toFriendlyString(GoodsLogisticState.get(count));
             	count++;
             }
        }
        table = new JTable(new MyTableModel(content));
        table.setBounds(20,60,280,120);
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
//        table.setModel(new javax.swing.table.DefaultTableModel(
//            content,
//            new String [] {
//                "时间", "物流状态"
//            }
//        ) {
//            Class[] types = new Class [] {
//                java.lang.String.class, java.lang.String.class
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
        table.setDefaultRenderer(String.class,new MyRenderer());
        jScrollPane1.setViewportView(table);
        panel.add(jLabel2);
        panel.add(jLabel3);
        panel.add(label01);
        panel.add(label02);
        panel.add(listNum_label);
        panel.add(table);
        panel.add(jScrollPane1);
        panel.add(exit_btn);
        this.setContentPane(panel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3,label01,label02;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JLabel listNum_label;
    private JPanel panel;
    private MyButton exit_btn;
    private GoodsVO vo;
    private final int width=320,height=200;
    private Object[][] content;
    // End of variables declaration//GEN-END:variables
}

class MyTableModel extends AbstractTableModel {
	Object[][] contents;
	public MyTableModel(Object[][] contents){
		this.contents=contents;
	}
	private String[] columnNames = { "Column 1", "Column 2" };
	public String getColumnName(int c) {
		return columnNames[c];
	}
	public Class<?> getColumnClass(int c) {
		return contents[0][c].getClass();
	}
	public int getColumnCount() {
		return contents[0].length;
	}

	public int getRowCount() {
		return contents.length;
	}

	public Object getValueAt(int r, int c) {
		return contents[r][c];
	}

	public void setValueAt(Object obj, int r, int c) {
		contents[r][c] = obj;
	}

}
class MyRenderer implements TableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		JLabel jl = new JLabel();
		if(row==table.getRowCount()-1){
			jl.setFont(new Font("", 3, 12));
//			jl.setForeground(Color.white);
			jl.setBackground(new Color(152 ,251 ,152));
		}
		
		jl.setOpaque(true);
		jl.setText(value.toString());
		return jl;
	}
}