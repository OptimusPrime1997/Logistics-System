package bl.formbl.controller;

import util.enumData.ResultMessage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import VO.BusinessFormVO;
import bl.formbl.BusinessFormbl;
import blservice.formblservice.BusinessFormBLService;

public class BusinessFormController implements BusinessFormBLService{

	private BusinessFormbl businessFormbl = new BusinessFormbl();

	public BusinessFormVO show(String startTime, String endTime) throws NotBoundException, ClassNotFoundException, IOException {
		return businessFormbl.show(startTime, endTime);
	}

	public ResultMessage save(BusinessFormVO vo) {
		return businessFormbl.save(vo);
	}

}
