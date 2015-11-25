package RMIClient;
import java.rmi.Naming;
import java.rmi.RemoteException;
import RMIservice.GoodsDataRemote;
import dataservice.goodsdataservice.GoodsDataService;

public class GoodsClient {
	GoodsDataRemote remote;
	public void getInstance(){
		try {
			remote=(GoodsDataRemote)Naming.lookup("rmi://127.0.0.1:19006/goods");
		} catch (Exception e) {
		}
	}
	
	public GoodsDataService getGoodsDataService() throws RemoteException{
		getInstance();
		return remote.getGoodsDataService();
	}

}
