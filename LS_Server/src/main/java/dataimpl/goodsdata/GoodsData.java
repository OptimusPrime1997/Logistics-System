package dataimpl.goodsdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.CourierNotFoundException;
import Exception.GoodsNotFound;
import PO.GoodsPO;
import dataservice.goodsdataservice.GoodsDataService;
import datautil.DataUtility;

public class GoodsData extends UnicastRemoteObject implements GoodsDataService{
	String filename = "goods.txt";
	DataUtility helper = new DataUtility();	
	//Done!
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
			} catch ( IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return ResultMessage.FAILED;
	}
	/**
	 * 不需要抛不存在的异常，，，因为bl在把PO传过来之前已经确认过PO存在了~
	 */
	//Done!
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
	//Done!
	@Override
	public ResultMessage delete(GoodsPO po) throws RemoteException,GoodsNotFound {
		ArrayList<Object> all;
		Boolean ifFound=false;
		GoodsPO temp;
	    try {
			all=helper.getAll(filename);
			System.out.println(all.size());
			for(int i=0;i<all.size();i++){
		    	temp=(GoodsPO)all.get(i);
		    	if(temp.getListNum().equals(po.getListNum())){
		    		ifFound=true;
		    		all.remove(i);
		    		break;
		    	}
		    }
			if(!ifFound) throw new GoodsNotFound();
		    helper.SaveAll(all, filename);
		    return ResultMessage.SUCCESS;
	    }catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	//Done!
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

	//Done!
	@Override	
	public GoodsPO findbygoods(String ListNum)throws RemoteException,GoodsNotFound {
		System.out.println("GoodsData.findbygoods");
		ArrayList<Object> all=null;
		GoodsPO po=null,temp;
		try {
			all=helper.getAll(filename);
			for(Object o:all){
				temp=(GoodsPO)o;
				//找到了货物~
				if(temp.getListNum().equals(ListNum)){
					po=temp;
					break;
				}
			}
		} catch (ClassNotFoundException | IOException e) {
		}
		System.out.println("我在找~~");
		if(po==null) throw new GoodsNotFound();
		return po;
	}

	/**
	 * 返回某一天  快递员接件的  货物  的PO
	 */
	//Done!
	@Override
	public ArrayList<GoodsPO> findbyGetCourier(String CourierNum,String date)
			throws RemoteException{
		ArrayList<Object> all=null;
		ArrayList<GoodsPO> ans=new ArrayList<GoodsPO>();
		GoodsPO po;
		try {
			all=helper.getAll(filename);
			for(Object o:all){
				po=(GoodsPO)o;
				//找到了接件的货物~
				if(po.getGetCourierAccount().equals(CourierNum)){
					ans.add(po);
				}
			}
			return ans;
		} catch (ClassNotFoundException | IOException e) {
		}
		return null;
	}
	/**
	 * 返回某一天  快递员接件/派件 数量
	 */
	//Done!
	@Override
	public int findbyCourier(String CourierNum,String date)
			throws RemoteException{
		ArrayList<Object> all=null;
		//待返回的总数
		int sum=0;
		GoodsPO po=null;
		try {
			all=helper.getAll(filename);
			for(Object o:all){
				po=(GoodsPO)o;
				//找到了货物~
				if(po.getGetCourierAccount().equals(CourierNum)//TODO
						//||po.getDeliverCourierAccount().equals(CourierNum)
						){
					sum++;
				}
			}
		} catch (ClassNotFoundException | IOException e) {
		}
		return sum;
	
	}
	public  GoodsData() throws RemoteException {
		super();
	}
	private static final long serialVersionUID = 1L;

}
