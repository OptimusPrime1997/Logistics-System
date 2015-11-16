/**
 * account MockLog
 * @author JaneLDQ
 * @date 2014/11/13
 */
package bl.managementbl.vehicleanddriverbl;

import util.enumData.ResultMessage;
import bl.logbl.Logbl;


public class MockLog extends Logbl{

	private String content;
	
	public MockLog(String content){
		this.content=content;
	}
	
	public ResultMessage add(){
		System.out.println(this.content);
		System.out.println("Add Log successfully!");
		return ResultMessage.SUCCESS;
	}
	
	
}
