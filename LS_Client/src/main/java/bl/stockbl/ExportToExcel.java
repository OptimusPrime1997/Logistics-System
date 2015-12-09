
/**
 * 
 */
package bl.stockbl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import util.enumData.ResultMessage;
import VO.StockVO;

/**
 * @author G
 *
 */
public class ExportToExcel {
	
	public static ResultMessage exportStockExcel (ArrayList<StockVO> list, String pathname) {
		//创建一个webbook,对应一个excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		//在webbook中添加sheet
		HSSFSheet sheet = wb.createSheet("库存快照");
		//在sheet中添加表头第0行
		HSSFRow row = sheet.createRow(0);
		//创建单元格，并设置值表头
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("货物编号");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("入库单号");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("入库日期");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("目的地");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("区号");
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("位号");
		cell.setCellStyle(style);
		
		//写入实体数据
		for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i+1);
				StockVO vo = list.get(i);
				//创建单元格，并设置值
				row.createCell(0).setCellValue(vo.listNum);
				row.createCell(1).setCellValue(vo.inStockRepNum);
				row.createCell(2).setCellValue(vo.inStockDate);
				row.createCell(3).setCellValue(vo.destination+"");
				row.createCell(4).setCellValue(vo.block);
				row.createCell(5).setCellValue(vo.place);
		}
		
		//将文件存到指定位置
		
		
		
		try {
			File f = new File(pathname);
		
	        if(!f.exists()){
	            f.createNewFile();
	        }
			
			FileOutputStream fout;
			fout = new FileOutputStream(f);
			
			wb.write(fout);
			
			fout.close();
			
			return ResultMessage.SUCCESS;
		} catch (FileNotFoundException e) {
			return ResultMessage.IOFAILED;
		} catch (IOException e) {
			return ResultMessage.IOFAILED;		
		}
		
		
		
		
		
		
	}

}
