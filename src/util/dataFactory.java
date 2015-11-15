package util;

import dataimpl.formdata.BusinessFormData;
import dataimpl.formdata.ProfitFormData;
import dataimpl.goodsdata.GoodsData;
import dataimpl.logdata.LogData;
import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;
import dataservice.goodsdataservice.GoodsDataService;
import dataservice.logdataservice.LogDataService;

public class dataFactory {
	GoodsDataService goodsdata=new GoodsData();
	BusinessFormDataService businessFormdata=new BusinessFormData();
	ProfitFormDataService profitFormdata=new ProfitFormData();
	LogDataService logdata=new LogData();
	public GoodsDataService getGoodsdata() {
		return goodsdata;
	}
	public BusinessFormDataService getBusinessFormdata() {
		return businessFormdata;
	}
	public ProfitFormDataService getProfitFormdata() {
		return profitFormdata;
	}
	public LogDataService getLogdata() {
		return logdata;
	}
	
	

}
