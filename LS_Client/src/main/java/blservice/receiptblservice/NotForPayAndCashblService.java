package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import Exception.NumNotFoundException;

public interface NotForPayAndCashblService {

	/**根据工作地点自动生成编号
	 * @param date
	 * @param office
	 * @return
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException;
	
}
