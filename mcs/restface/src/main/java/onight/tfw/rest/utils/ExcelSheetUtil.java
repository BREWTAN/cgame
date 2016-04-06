package onight.tfw.rest.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 */
public class ExcelSheetUtil {
	public static void writeHead(Workbook wb,Sheet sheet,List<ExcelColumn> columns){
		{
			//创建表头
			CellStyle style = styleHead(wb);
			Row row = sheet.createRow(0);
			for(int i=0;i<columns.size();i++){
				ExcelColumn excelColumn = columns.get(i);
				createCell(row, style, i, excelColumn.getName());
				sheet.setColumnWidth(i, 256 * excelColumn.getWidth());
			}
		}
	}
	
	
	/**
	 * <p>
	 * 方法描述:根据指定的输出列输出数据
	 * </p>
	 * @param wb
	 * @param sheet
	 * @param columns
	 * @param dataList
	 * @param start
	 * void
	 */
	public static void writeData(HSSFWorkbook wb,HSSFSheet sheet,
			List<ExcelColumn> columns,List<HashMap<String, Object>> dataList,
			int start){
		CellStyle styleText = styleData(wb);
		CellStyle styleNumber = styleNumber(wb);
		sheet.setDisplayGridlines(false);
		int columnSize = columns.size();//总列数

		if(dataList != null){ 
			//创建数据内容
			for(Map<String,Object> dataMap:dataList){
				HSSFRow row = sheet.createRow(start++);
				for(int i=0;i<columnSize;i++){
					ExcelColumn excelColumn = columns.get(i);
					String key = excelColumn.getId();//对应字段名称
					Object obj = dataMap.get(key);
					if(obj != null){
						if(obj instanceof BigDecimal){
							createCell(row, styleNumber, i, ((BigDecimal)obj).doubleValue());	
						}else if(obj instanceof Integer){
							createCell(row, styleNumber, i, ((Integer)obj).doubleValue());	
						}else if(obj instanceof Number){
							createCell(row, styleNumber, i, ((Number)obj).doubleValue());	
						}else if(obj instanceof Date){
							createCell(row, styleText, i, obj.toString());	
						}else if(obj instanceof Calendar){
							createCell(row, styleText, i, (Calendar)obj);	
						}else if(obj instanceof Boolean){
							createCell(row, styleText, i, (Boolean)obj);	
						}else{
							createCell(row, styleText, i, obj.toString());	
						}
					}else{
						//如果查询没有数据给该域赋空
						createCell(row, styleText, i,"");
					}
				}
			}
		}
		
	}
	/**
	 * 根据查询结果导出EXCEL
	 * <p>
	 * 方法描述:
	 * </p>
	 * @param wb
	 * @param sheet
	 * @param columns
	 * @param dataList
	 * @param start
	 * void
	 */
	public static void writeExcel(Workbook wb,Sheet sheet,
			List<ExcelColumn> columns,List<Map<String, Object>> dataList,
			int start){
		System.out.println("是否进入");
		CellStyle styleText = styleData(wb);
		CellStyle styleNumber = styleNumber(wb);
		sheet.setDisplayGridlines(false);
		int columnSize = columns.size();//总列数
		
		if(dataList != null){
			//创建数据内容
			for(Map<String,Object> dataMap:dataList){
				Row row = sheet.createRow(start++);
				for(int i=0;i<columnSize;i++){
					ExcelColumn excelColumn = columns.get(i);
					String key = excelColumn.getId();//对应字段名称
					Object obj = dataMap.get(key);
					if(obj != null){
						if(null !=obj){
							if(obj instanceof BigDecimal){
								createCell(row, styleNumber, i, ((BigDecimal)obj).doubleValue());	
							}else if(obj instanceof Integer){
								createCell(row, styleNumber, i, ((Integer)obj).doubleValue());	
							}else if(obj instanceof Number){
								createCell(row, styleNumber, i, ((Number)obj).doubleValue());	
							}else if(obj instanceof Date){
								createCell(row, styleText, i, obj.toString());	
							}else if(obj instanceof Calendar){
								createCell(row, styleText, i, (Calendar)obj);	
							}else if(obj instanceof Boolean){
								createCell(row, styleText, i, (Boolean)obj);	
							}else{
								createCell(row, styleText, i, obj.toString());	
							}
						}else{
							createCell(row, styleText, i,"");	
						}
					}else{
						//如果查询没有数据给该域赋空
						createCell(row, styleText, i,"");
					}
				}
			}
		}
		
	}	
	public static void createCell(Row row, CellStyle style, int column, String value) {
		Cell cell = row.createCell(column);
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(style);
		}
	}
	
	public static void createCell(Row row, CellStyle style, int column, String value,Workbook wb) {
		Cell cell = row.createCell(column);
		CellStyle cellStyle = wb.createCellStyle();
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(cellStyle);
		}
	}
	
	//浮点数
	public static void createCell(Row row, CellStyle style, int column, double value) {
		Cell cell = row.createCell(column);
		//数字千分位
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC); 
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(style);
		}
	}
	
	//浮点数
	public static void createCell1(Row row, CellStyle style, int column, double value,Workbook wb) {
		Cell cell = row.createCell(column);
		CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		//数字千分位
		cell.setCellStyle(cellStyle);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC); 
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(cellStyle);
		}
	}
	
	//日期
	public static void createCell(Row row, CellStyle style, int column, Date value) {
		Cell cell = row.createCell(column);
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(style);
		}
	}
	
	//日历
	public static void createCell(Row row, CellStyle style, int column, Calendar value) {
		Cell cell = row.createCell(column);
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(style);
		}
	}
	
	//日历
	public static void createCell(Row row, CellStyle style, int column, Calendar value,Workbook wb) {
		Cell cell = row.createCell(column);
		CellStyle cellStyle = wb.createCellStyle();
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(cellStyle);
		}
	}
	
	//boolean
	public static void createCell(Row row, CellStyle style, int column, boolean value) {
		Cell cell = row.createCell(column);
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(style);
		}
	}
	//boolean
	public static void createCell(Row row, CellStyle style, int column, boolean value,Workbook wb) {
		Cell cell = row.createCell(column);
		CellStyle cellStyle = wb.createCellStyle();
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(cellStyle);
		}
	}
	
	//富文本
	public static void createCell(HSSFRow row, CellStyle style, int column, RichTextString value) {
		HSSFCell cell = row.createCell(column);
		cell.setCellValue(value);
		if (style != null){
			cell.setCellStyle(style);
		}
	}
	/**
	 * 
	 * <p>
	 * 方法描述:设置表格数据样式
	 * </p>
	 * @param wb
	 * @return
	 * CellStyle
	 */
	public static CellStyle styleData(Workbook wb) {

		CellStyle style = wb.createCellStyle();
		// 设置边框
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		// 设置对其方式
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		return style;
	}
	/**
	 * 
	 * <p>
	 * 方法描述:设置表格数据样式
	 * </p>
	 * @param wb
	 * @return
	 * CellStyle
	 */
	private static CellStyle styleNumber(Workbook wb) {

		CellStyle style = wb.createCellStyle();
		// 设置边框
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		// 设置对其方式
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setDataFormat((short)2);//0.00
		return style;
	}
	/**
	 * 
	 * <p>
	 * 方法描述:设置表格头样式
	 * </p>
	 * @param wb
	 * @return
	 * CellStyle
	 */
	public static CellStyle styleHead(Workbook wb) {

		CellStyle style = wb.createCellStyle();
		// 设置边框
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());

		// 设置字体
		Font headerFont = wb.createFont();
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerFont.setFontHeightInPoints((short) 10);//修改表头字号为10号字体
		style.setFont(headerFont);

		// 设置对其方式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// 设置背景
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		return style;
	}
	
	/**
	 * 
	 * <p>
	 * 方法描述:压缩文件
	 * </p>
	 * @param srcfile
	 * @param zipfile
	 * void
	 */
	public static void ZipFiles(java.io.File[] srcfile, java.io.File zipfile) {
	    byte[] buf = new byte[1024];
	    try {
	      // Create the ZIP file
	      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
	      // Compress the files
	      for (int i = 0; i < srcfile.length; i++) {
	        FileInputStream in = new FileInputStream(srcfile[i]);
	        // Add ZIP entry to output stream.
	        out.putNextEntry(new ZipEntry(srcfile[i].getName()));
	        // Transfer bytes from the file to the ZIP file
	        int len;
	        while ( (len = in.read(buf)) > 0) {
	          out.write(buf, 0, len);
	        }
	        // Complete the entry
	        out.closeEntry();
	        in.close();
	      }
	      // Complete the ZIP file
	      out.close();
	      System.out.println("压缩完成.");
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
}
