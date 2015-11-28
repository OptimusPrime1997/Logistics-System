package bl.formbl.controller;

import util.enumData.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import VO.ProfitFormVO;
import bl.formbl.ProfitFormbl;
import blservice.formblservice.ProfitFormBLService;

public class ProfitFormController implements ProfitFormBLService{
	private ProfitFormbl profitFormbl = new ProfitFormbl();

	public ProfitFormVO show() throws RemoteException, MalformedURLException, NotBoundException {
		return profitFormbl.show();
	}

	public ResultMessage save(ProfitFormVO vo) {
		return profitFormbl.save(vo);
	}

}
