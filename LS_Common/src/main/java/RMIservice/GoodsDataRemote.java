package RMIservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.goodsdataservice.GoodsDataService;

public interface GoodsDataRemote extends Remote{
	public GoodsDataService getGoodsDataService()throws RemoteException;
}
