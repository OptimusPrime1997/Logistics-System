package dataimpl.goodsdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.GoodsPO;
import dataservice.goodsdataservice.GoodsDataService;
import datautil.DataUtility;

public class GoodsData extends UnicastRemoteObject implements GoodsDataService{
	String filename = "goods.txt";
	DataUtility helper = new DataUtility();	
	@Override
	public ResultMessage add(GoodsPO po) throws RemoteException {

		System.out.println("goodsdata.add");
		ArrayList<Object> all;
		System.out.println("试图添加");
		
			GoodsPO temp;
		    try {
				all=helper.getAll(filename);
				System.out.println(all.size());
			    for(Object o:all){
			    	temp=(GoodsPO)o;
			    	//该订单号已存在  则添加失败
			    	if(temp.getListNum().equals(po.getListNum())){
			    		return ResultMessage.EXIST;
			    	}
			    	System.out.println("inloop");
			    }
			    System.out.println("已添加");
			    return helper.save(po, filename);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		
		return ResultMessage.FAILED;
	}
	@Override
	public ResultMessage modify(GoodsPO po) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage delete(GoodsPO po) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<GoodsPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsPO findbygoods(String ListNum)throws RemoteException {
		ArrayList<Object> all=null;
		GoodsPO po=null,temp;
		try {
			all=helper.getAll(filename);
			for(Object o:all){
				temp=(GoodsPO)o;//找到了货物~
				if(temp.getListNum().equals(ListNum)){
					po=temp;
					break;
				}
			}
		} catch (ClassNotFoundException | IOException e) {
		}
		return po;
	}

	@Override
	public ArrayList<GoodsPO> findbyGetCourier(String CourierNum,String date)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findbyCourier(String CourierNum,String date)
			throws RemoteException {
		return 0;
	//TODO
	}
	public  GoodsData() throws RemoteException {
		super();
	}
	private static final long serialVersionUID = 1L;

}
