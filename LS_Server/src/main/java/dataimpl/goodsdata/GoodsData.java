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
		ArrayList<Object> all;
			GoodsPO temp;
		    try {
				all=helper.getAll(filename);
			    for(Object o:all){
			    	temp=(GoodsPO)o;
			    	//该订单号已存在  则添加失败
			    	if(temp.getListNum().equals(po.getListNum())){
			    		return ResultMessage.EXIST;
			    	}
			    }
			    System.out.println("已添加");
			    return helper.save(po, filename);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		return ResultMessage.FAILED;
	}
	@Override
	public ResultMessage modify(GoodsPO po) throws RemoteException {
		ArrayList<Object> all;
		GoodsPO temp;
	    try {
			all=helper.getAll(filename);
		    for(int i=0;i<all.size();i++){
		    	temp=(GoodsPO)all.get(i);
		    	if(temp.getListNum().equals(po.getListNum())){
		    		all.remove(i);
		    		break;
		    	}
		    }
		    all.add(po);
		    helper.SaveAll(all, filename);
		    return ResultMessage.SUCCESS;
	    }catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
	@Override
	public ResultMessage delete(GoodsPO po) throws RemoteException {
		ArrayList<Object> all;
		GoodsPO temp;
	    try {
			all=helper.getAll(filename);
		    for(int i=0;i<all.size();i++){
		    	temp=(GoodsPO)all.get(i);
		    	if(temp.getListNum().equals(po.getListNum())){
		    		all.remove(i);
		    		break;
		    	}
		    }
		    helper.SaveAll(all, filename);
		    return ResultMessage.SUCCESS;
	    }catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<GoodsPO> show() throws RemoteException {
		ArrayList<Object> all;
		ArrayList<GoodsPO> pos=new ArrayList<GoodsPO>();
		GoodsPO temp;
			try {
				all=helper.getAll(filename);
				for(Object o:all){
					temp=(GoodsPO)o;
					pos.add(temp);
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		return pos;
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
		System.out.println("我在找~~");
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
		super();//TODO
	}
	private static final long serialVersionUID = 1L;

}
