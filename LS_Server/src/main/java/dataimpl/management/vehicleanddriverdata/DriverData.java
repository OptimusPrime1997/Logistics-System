package dataimpl.management.vehicleanddriverdata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.DriverPO;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;
import datautil.DataUtility;

public class DriverData extends UnicastRemoteObject implements DriverDataService {
	private DataUtility d;
	private final String path="data/currentdata/driver";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DriverData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		d=new DataUtility();
	}

	@Override
	public ResultMessage insertDriver(DriverPO po) throws IOException {
		// TODO Auto-generated method stub
		print();
		if(d.save(po,path)==ResultMessage.FAILED){
			return ResultMessage.FAILED;
		}else{
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage updateDriver(DriverPO po) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO=false;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			return ResultMessage.NOT_FOUND_FILE;
		}else{
			DriverPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(DriverPO)objects.get(i);
				if(p.getDriverNum().equals(po.getDriverNum())){
					objects.remove((Object)p);
					objects.add((Object)po);
					findPO=true;
					d.SaveAll(objects, path);
					break;
				}
			}
		}
		if(findPO==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.NOT_FOUND;
		}
	}

	@Override
	public ResultMessage deleteDriver(DriverPO po) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		print();
		boolean findPO=false;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			return ResultMessage.NOT_FOUND_FILE;
		}else{
			DriverPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(DriverPO)objects.get(i);
				if(p.getDriverNum().equals(po.getDriverNum())){
					findPO=true;
					objects.remove((Object)p);
				}
				break;
			}
			d.SaveAll(objects, path);
		}
		if(findPO==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.NOT_FOUND;
		}	}

	@Override
	public ArrayList<DriverPO> showDriver() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects=d.getAll(path);
		ArrayList<DriverPO> DriverPOs=new ArrayList<DriverPO>();
		for(Object o:objects){
			DriverPOs.add((DriverPO)o);
		}
		return DriverPOs;
	}

	@Override
	public DriverPO findByDriverNum(String driverNum) throws NumNotFoundException, ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		print();
		DriverPO exist=null;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			throw new FileNotFoundException();
		}else{
			DriverPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(DriverPO)objects.get(i);
				if(p.getDriverNum().equals(driverNum)){
					exist=p;
					break;
				}
			}
		}
		if(exist==null){
			throw new NumNotFoundException();
		}else{
			return exist;
		}	
		}

	private void print() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ": executing " + 
				Thread.currentThread().getStackTrace()[2].getMethodName());
	}
}
