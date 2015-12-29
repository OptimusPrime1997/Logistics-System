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
import util.FromIntToCity;
import util.enumData.City;
import util.enumData.ResultMessage;

import java.awt.*;
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
        initComponents();
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

    	
    	
        jLabel9 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        oldBlocks = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        oldPlaces = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        newPlaces = new javax.swing.JComboBox();
        confirm = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        oldDivisions = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        newDivisions = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        newBlocks = new javax.swing.JComboBox();
        resultMessage = new JLabel();

      
        
        jLabel9.setText("当前账户："+Loginbl.getCurrentOptorName());

        exit.setText("退出");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel1.setText("原区域：");

        jLabel2.setText("区号：");

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

        jLabel3.setText("位号：");

        oldPlaces.setModel(new DefaultComboBoxModel(new String[] { "   "}));
        oldPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPlacesActionPerformed(evt);
            }
        });

        jLabel4.setText("新区域：");

        jLabel5.setText("调整至------------------------------------->");

        jLabel7.setText("位号：");

        newPlaces.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   "}));
        newPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlacesActionPerformed(evt);
            }
        });

        confirm.setText("确定");
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

        back.setText("返回");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel10.setText("所在地：南京 01");

        jLabel8.setText("块号：");

        
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

        jLabel11.setText("区号：");

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

        jLabel12.setText("块号：");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(oldDivisions, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(oldBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(oldPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(back)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(confirm))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(newDivisions, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(21, 21, 21)
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(newBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(newPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(27, 27, 27))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(resultMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(exit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(oldBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(oldPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(oldDivisions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(newPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(newDivisions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(newBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(confirm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        ); 
        pack();
    }// </editor-fold>                        


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
				result.add(vo.place%100+1);
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
    

    // Variables declaration - do not modify  
    private Integer[] oldblocksList;
    private Integer[] newblocksList;
    private Integer[] oldplacesList;
    private Integer[] newplacesList;
    private javax.swing.JButton exit;
    private javax.swing.JButton confirm;
    private javax.swing.JButton back;
    private javax.swing.JComboBox oldBlocks;
    private javax.swing.JComboBox oldPlaces;
    private javax.swing.JComboBox newPlaces;
    private javax.swing.JComboBox oldDivisions;
    private javax.swing.JComboBox newDivisions;
    private javax.swing.JComboBox newBlocks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private JLabel resultMessage;
    // End of variables declaration                   
}