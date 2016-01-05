package dataimpl.logdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import PO.LogPO;
import dataservice.logdataservice.LogDataService;
import datautil.DataUtility;

public class LogData extends UnicastRemoteObject implements LogDataService{

	String filename = "Log";
	DataUtility helper = new DataUtility();	
	 
	public LogData() throws RemoteException {
	}
	private static final long serialVersionUID = 1L;

	@Override
	public ResultMessage add(LogPO po) throws RemoteException {
		try {
			System.out.println("LogData.add "+po.getTime());
			return helper.save(po, filename);
		} catch (IOException e) {
		}
		return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<LogPO> show(LogType type, String startTime, String endTime)
			throws RemoteException {
		System.out.println("Logdata.show");
		ArrayList<LogPO> pos=new ArrayList<LogPO>();
		ArrayList<Object> all;
		LogPO temp;
		try {
			all=helper.getAll(filename);
			if(type==LogType.ALL){
				System.out.println("管我要所有 ");
				for(Object o:all){
					temp=(LogPO)o;
					String tempT=temp.getTime().substring(0, 10);
					System.out.println("日志的日期  "+tempT);
					if(//在起止时间之间
							(CurrentTime.ifearlier(startTime, tempT)
									&&
							CurrentTime.ifearlier(tempT, endTime))||
							
							//等于起时间
							(!CurrentTime.ifearlier(startTime, tempT)
									&&!CurrentTime.ifearlier(tempT,startTime)||
							//等于终止时间
							(!CurrentTime.ifearlier(endTime, tempT)
									&&!CurrentTime.ifearlier(tempT,endTime)))){
								
						pos.add(temp);
					}
				}
				return pos;
			}
			for(Object o:all){
				temp=(LogPO)o;
				if(temp.getOperationName()!=type){
					continue;
				}else{//操作类型正确
					String tempT=temp.getTime().substring(0, 10);
					System.out.println("日志的日期  "+tempT);
					if(//在起止时间之间
							
							(CurrentTime.ifearlier(startTime, tempT)
									&&
							CurrentTime.ifearlier(tempT, endTime))||
							
							//等于起时间
							(!CurrentTime.ifearlier(startTime, tempT)
									&&!CurrentTime.ifearlier(tempT,startTime)||
							//等于终止时间
							(!CurrentTime.ifearlier(endTime, tempT)
									&&!CurrentTime.ifearlier(tempT,endTime)))){
								
						pos.add(temp);
					}
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return pos;
		
	}
}
