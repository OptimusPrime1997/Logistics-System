package util;

import dataimpl.formdata.BusinessFormData;
import dataimpl.formdata.ProfitFormData;
import dataimpl.goodsdata.GoodsData;
import dataimpl.logdata.LogData;
import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;
import dataservice.goodsdataservice.GoodsDataService;
import dataservice.logdataservice.LogDataService;

public class DataFactory {
	static GoodsDataService goodsdata=new GoodsData();
	static BusinessFormDataService businessFormdata=new BusinessFormData();
	static ProfitFormDataService profitFormdata=new ProfitFormData();
	static LogDataService logdata=new LogData();
	public static GoodsDataService getGoodsdata() {
		return goodsdata;
	}
	public static BusinessFormDataService getBusinessFormdata() {
		return businessFormdata;
	}
	public static ProfitFormDataService getProfitFormdata() {
		return profitFormdata;
	}
	public static LogDataService getLogdata() {
		return logdata;
	}

}
