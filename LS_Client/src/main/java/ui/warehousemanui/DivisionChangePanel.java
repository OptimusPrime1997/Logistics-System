/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.warehousemanui;
import javax.swing.*;

import main.MainFrame;
import VO.StockDivisionVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import bl.loginbl.Loginbl;
import blservice.stockblservice.StockDivisionBLService;
import ui.Img;
import ui.util.ButtonType;
import ui.util.MyButton;
import ui.util.MyLabel;
import util.FromIntToCity;
import util.enumData.City;
import util.enumData.ResultMessage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author G
 */
public class DivisionChangePanel extends JFrame {

    /**
     * Creates new form DivisionChange
     */
    public DivisionChangePanel() {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
    	
    	/**
    	 * 设置窗体大小
    	 */
    	this.setSize(800, 500);
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

    	
    	
        userLabel = new MyLabel("当前账户："+Loginbl.getCurrentOptorName(), 590, 20, 300, 20);
        exit = new MyButton(750, 10, ButtonType.EXIT);
        oldLabel = new MyLabel("原区域：", 100, 80, 80, 20);
        oldD_Label = new MyLabel("区号：", 120, 120, 80, 20);
        oldBlocks = new javax.swing.JComboBox();
        oldBlocks.setBounds(380, 120, 70, 20);
        oldP_Label = new MyLabel("位号：", 520, 120, 80, 20);
        oldPlaces = new javax.swing.JComboBox();
        oldPlaces.setBounds(580, 120, 70, 20);
        newLabel = new MyLabel("新区域：", 100, 250, 80, 20);
        middle_Label = new MyLabel("调整至------------------------------------------>", 100, 180, 680, 20);
        newP_Label = new MyLabel("位号：", 520, 290, 80, 20);
        newPlaces = new javax.swing.JComboBox();
        newPlaces.setBounds(580, 290, 70, 20);
        back = new MyButton(380, 360, ButtonType.BACK);
        confirm = new MyButton(540, 360, ButtonType.OK);
        oldB_Label = new MyLabel("块号：", 320, 120, 80, 20);
        oldDivisions = new javax.swing.JComboBox();
        oldDivisions.setBounds(180, 120, 70, 20);
        newD_Label = new MyLabel("区号：", 120, 290, 80, 20);
        newDivisions = new javax.swing.JComboBox();
        newDivisions.setBounds(180, 290, 70, 20);
        newB_Label = new MyLabel("块号：", 320, 290, 80, 20);
        newBlocks = new javax.swing.JComboBox();
        newBlocks.setBounds(380, 290, 70, 20);
        resultMessage = new MyLabel("反馈", 30, 470, 800, 20);

      
        panel.add(userLabel);
        panel.add(resultMessage);
        panel.add(exit);
        panel.add(oldLabel);
        panel.add(oldD_Label);
        panel.add(oldDivisions);
        panel.add(oldB_Label);
        panel.add(oldBlocks);
        panel.add(oldP_Label);
        panel.add(oldPlaces);
        panel.add(middle_Label);
        panel.add(newLabel);
        panel.add(newD_Label);
        panel.add(newDivisions);
        panel.add(newB_Label);
        panel.add(newBlocks);
        panel.add(newP_Label);
        panel.add(newPlaces);
        panel.add(back);
        panel.add(confirm);
        
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

    


        oldBlocks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   "}));
        oldBlocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					oldBlocksActionPerformed(evt);
				} catch (MalformedURLException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				} catch (RemoteException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				} catch (NotBoundException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				} catch (IOException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				}
            }
        });


        oldPlaces.setModel(new DefaultComboBoxModel(new String[] { "   "}));
        oldPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPlacesActionPerformed(evt);
            }
        });


        newPlaces.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   "}));
        newPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlacesActionPerformed(evt);
            }
        });

        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					confirmActionPerformed(evt);
				} catch (NotBoundException | IOException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				} catch (ClassNotFoundException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				}
            }
        });

        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        oldDivisions.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 01,2, 3, 4, 5, 6, 7, 8}));
        oldDivisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					oldDivisionsActionPerformed(evt);
				} catch (NotBoundException | IOException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				}
            }
        });

        newDivisions.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 01,2, 3, 4, 5, 6, 7, 8}));
        newDivisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					newDivisionsActionPerformed(evt);
				} catch (NotBoundException | IOException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				}
            }
        });

        newBlocks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "  "}));
        newBlocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					newBlocksActionPerformed(evt);
				} catch (NotBoundException | IOException e) {
					showFeedback(ResultMessage.REMOTE_FAILED, "");
				}
            }
        });

    }  

    
    StockDivisionBLService s = ControllerFactoryImpl.getInstance().getStockDivisionController();
    
    /**
     * 退出
     * @param evt
     */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	MainFrame mf = new MainFrame();
    	mf.setVisible(true);
    	this.dispose();
    } //GEN-LAST:event_jButton3ActionPerformed                                       

    private void oldBlocksActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException {                                           
    	//得到本仓库选中的区的所有VO
    	int division = (int) oldDivisions.getSelectedItem();	
    	ArrayList<StockDivisionVO> list = s.getBlockByDivision(division);
    	//得到本区所选小块的存在的所有位号
//    	int block = oldBlocks.getSelectedIndex()+1;    
    	int block = (int) oldBlocks.getSelectedItem();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (StockDivisionVO vo : list) {
    		if (vo.place<=(100*block)&&vo.place>=((block-1)*100+1)) {
				result.add(vo.place%100);
			}
    		
       	}
    	
    	//在oldplaces中显示这些位号
    	oldplacesList = new Integer[result.size()];
    	for (int i = 0; i < result.size(); i++) {
			oldplacesList[i] = result.get(i);
		}
    	oldPlaces.setModel(new DefaultComboBoxModel<Integer>(oldplacesList));
    } //GEN-LAST:event_jButton3ActionPerformed                                         

    private void oldPlacesActionPerformed(java.awt.event.ActionEvent evt) {                                           
    } //GEN-LAST:event_jButton3ActionPerformed                                         

    private void newPlacesActionPerformed(java.awt.event.ActionEvent evt) {                                           
    }  //GEN-LAST:event_jButton3ActionPerformed                                        

    
    /**
     * 得到所有的复选框中的值，然后判断
     * @param evt
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws NotBoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    private void confirmActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException, ClassNotFoundException {                                         
    	
    	if (oldBlocks.getSelectedItem()!=null && newBlocks.getSelectedItem() != null &&
    		oldDivisions.getSelectedItem() != null && newDivisions.getSelectedItem() !=null &&
    		oldPlaces.getSelectedItem() != null && newPlaces.getSelectedItem() != null) {
    		int newblock = (int)newDivisions.getSelectedItem();
        	ArrayList<StockDivisionVO> list = s.getBlockByDivision(newblock);
        	if (list.size()>800) {
        		showFeedback(ResultMessage.ALARM, "请调至别的区");
			} else{
				int Oblock = (int)oldDivisions.getSelectedItem();
				//TODO
				int Oplace = (int)oldPlaces.getSelectedItem()+((int)oldBlocks.getSelectedItem()-1)*100;
				int Nblock = (int)newDivisions.getSelectedItem();
				int Nplace = (int)newPlaces.getSelectedItem()+((int)newBlocks.getSelectedItem()-1)*100;
				ResultMessage rm = s.modifyDivision(Oblock,Oplace,Nblock,Nplace);
				showFeedback(rm, " ");
			}
		}
    	
    }//GEN-LAST:event_jButton3ActionPerformed   
    
    

    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	WarehousePanel w = new WarehousePanel();
		w.setVisible(true);
		this.dispose();
    } //GEN-LAST:event_jButton3ActionPerformed                                       

  
    private void oldDivisionsActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException {                                           
    	//得到本仓库选中的区的所有VO
    	int division = (int) oldDivisions.getSelectedItem();	
    	
    	City desCity = FromIntToCity.toCity(division);
    	ArrayList<StockDivisionVO> list = s.getBlockByDivision(division);
    	//得到中间参数小块号，布尔值为true的需要显示
    	boolean[] smallBlocks = new boolean[10];
    	
    	for (StockDivisionVO vo : list) {
    		int i = vo.place/100 ;
    		

    		
    		smallBlocks[i] = true;
    		//判断是不是所有的小块都满了，如果全满，则停止遍历
    		boolean full = true;
    		for(int m = 0; m < 10; m++) {
    			if (smallBlocks[m] == false) {
					full = false;
					break;
				}
    		}
    		if (full) {
				break;
			}
    	}
    	
    	
    	//要在oldblocks下拉框中显示出这些小块
    	int placeSize = 0;    	
    	
    	
    
    	
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i < smallBlocks.length; i++) {
			if (smallBlocks[i] == true) {
				placeSize++;
				result.add(i+1);
			}
		}	
    	
    	oldblocksList = new Integer[placeSize];
    	for (int i = 0; i < oldblocksList.length; i++) {
			oldblocksList[i] = result.get(i);
		}
    	
    	oldBlocks.setModel(new DefaultComboBoxModel<Integer>(oldblocksList));
    	
    } //GEN-LAST:event_jButton3ActionPerformed                                         

    private void newDivisionsActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException {                                           
    	//得到本仓库选中的区的所有VO
    	int division = (int) newDivisions.getSelectedItem();	
    	ArrayList<StockDivisionVO> list = s.getBlockByDivision(division);
    	//得到空闲的中间参数小块号
    	boolean[] smallBlocks = new boolean[10];
    	//得到每个块中的库存数量
    	int[] blocks = new int[10];
    	for (StockDivisionVO vo : list) {
    		int i = vo.place/100 ;
    		blocks[i]+=blocks[i];
    	
    	}
    	for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] < 100) {
				smallBlocks[i] = true;
			}
		}
    	
    	

    	//在newblocks下拉框中显示出这些小块
    	int placeSize = 0;    	
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i < smallBlocks.length; i++) {
			if (smallBlocks[i] == true) {
				placeSize++;
				result.add(i+1);
			}
		}	
    	
    	newblocksList = new Integer[placeSize];
    	for (int i = 0; i < newblocksList.length; i++) {
			newblocksList[i] = result.get(i);
		}
    	
    	newBlocks.setModel(new DefaultComboBoxModel<Integer>(newblocksList));
    } //GEN-LAST:event_jButton3ActionPerformed                                         

    private void newBlocksActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException {                                           
    	//得到本仓库选中的区的所有VO
    	int division = (int) oldDivisions.getSelectedItem();	
    	ArrayList<StockDivisionVO> list = s.getBlockByDivision(division);
    	/**
    	 *    初始places均为0，然后使得选中的小块中的位号全为1，然后再
    	 *  把vo list中所有的位号全置为0，这样得到最后的所有位号为1的即为需要显示的位号
    	 *  注意，其中places的下标与真实显示的位号相差1
    	 */
    	boolean[] places = new boolean[100];
    	int block = (int) newBlocks.getSelectedItem();    	
    	
    	for (StockDivisionVO vo : list) {
			if (vo.place<block*100&&(vo.place>=(block-1)*100)) {
				places[(vo.place-1)%100] = true;
			}
		}
    	
    	
    	//在newplaces里面显示位号
	
    	
    	int placeSize = 0;
  	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i < places.length; i++) {
			if (places[i] == false) {
				placeSize++;
				result.add(i+1);
			}
		}	
    	
    	newplacesList = new Integer[placeSize];
    	for (int i = 0; i < newplacesList.length; i++) {
			newplacesList[i] = result.get(i);
		}
    	
    	newPlaces.setModel(new DefaultComboBoxModel<Integer>(newplacesList));
    } //GEN-LAST:event_jButton3ActionPerformed
    private void showFeedback(ResultMessage msg, String operation) {
    	
    	if (msg.equals(ResultMessage.SUCCESS)) {
    		this.resultMessage.setForeground(Color.GREEN);
		} else {
			this.resultMessage.setForeground(Color.RED);
		}
    	
    	this.resultMessage.setText(operation + ResultMessage.toFriendlyString(msg));
	}
    

    public static void main(String[] args) {
		new DivisionChangePanel();
	}
    // Variables declaration - do not modify  
    private Integer[] oldblocksList;
    private Integer[] newblocksList;
    private Integer[] oldplacesList;
    private Integer[] newplacesList;
    private MyButton exit;
    private MyButton confirm;
    private MyButton back;
    private javax.swing.JComboBox oldBlocks;
    private javax.swing.JComboBox oldPlaces;
    private javax.swing.JComboBox newPlaces;
    private javax.swing.JComboBox oldDivisions;
    private javax.swing.JComboBox newDivisions;
    private javax.swing.JComboBox newBlocks;
    private MyLabel oldLabel;
    private MyLabel jLabel10;
    private MyLabel newD_Label;
    private MyLabel newB_Label;
    private MyLabel oldD_Label;
    private MyLabel oldP_Label;
    private MyLabel newLabel;
    private MyLabel middle_Label;
    private MyLabel newP_Label;
    private MyLabel oldB_Label;
    private MyLabel userLabel;
    private MyLabel resultMessage;
    private int mousePressedX;
   	private int mousePressedY;
    private JPanel panel;
    // End of variables declaration                   
}