package onight.tfw.rest.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.rest.db.dao.CommonSqlMapper;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.jdom.Element;

/**
 * 
 * <p>Description: 
 *    TODO 类功能描述
 *    主体数据导出excel
 * </p>
 */
@Slf4j
public class ExcelServiceUtil {
	public static final int pageSize=1000;
	public static final int perSheetSize=10000;
	@Getter
	public static ExcelServiceUtil util = new ExcelServiceUtil();
	
	public ExcelServiceUtil() {
		
	}
	
	@Data
	@AllArgsConstructor
	public class WorkBook{
		private String bookname;
		private List<Sheet> sheets;
	}
	
	@Data
	@AllArgsConstructor
	public class Sheet{
		private String sheetname;
		private String sql;
		private String alias;
	}

	private static CommonSqlMapper commonSqlMapper = 
			(CommonSqlMapper)BeanFactory.getBean("commonSqlMapper");

	public String downloadFileName(String name) {
		return name+".xls";
	}
	public boolean doDownload(WorkBook book, OutputStream out) {
		HSSFWorkbook wb = new HSSFWorkbook();
		List<Sheet> sheets = book.getSheets();
		for(Sheet sheetss:sheets){
			String alias=sheetss.getAlias();
			HSSFSheet sheet = wb.createSheet(sheetss.getSheetname());
			List<HashMap<String, Object>> dataList = commonSqlMapper.executeSql(sheetss.getSql());
	//		List<HashMap<String, Object>> dataList = query(sql);
			List<ExcelColumn> aliaLists = new ArrayList<>();
			StringBuffer sb = new StringBuffer();
			if(dataList==null||dataList.size()<=0){
				return false;
			}
			if(alias==null||alias.equals("")||!alias.contains(",")){
				for(String str:dataList.get(0).keySet()){
					sb.append(str+",");
				}
				alias=sb.toString().substring(0,sb.length()-1);
			}
			for(String keys:alias.split(",")){
				Element e = new Element("test");
				String key=keys;
				String name=keys;
				if(keys.split("-").length>1){
					key = keys.split("-")[0];
					name = keys.split("-")[1];
				}
				e.setAttribute("id", key);
				e.setAttribute("name", name);
				ExcelColumn col = new ExcelColumn(e);
				aliaLists.add(col);
			}
			
			ExcelSheetUtil.writeHead(wb, sheet, aliaLists);
			ExcelSheetUtil.writeData(wb, sheet, aliaLists, dataList, 1);
			
		}

		try {
			wb.write(out);
			return true;
		} catch (Exception e) {
			log.error("9999",e);
			return false;
		}finally{
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public List query(String sql){
//		Connection conn =  DBConnection.getConnectionByJDBC();
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		try {
//			conn.setAutoCommit(false);
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			ResultSetMetaData rsmd = ps.getMetaData();
//
//            // 取得结果集列数
//            int columnCount = rsmd.getColumnCount();
//
//            // 构造泛型结果集
//            List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
//            Map<String, Object> data = null;
//
//            // 循环结果集
//            while (rs.next()) {
//                data = new LinkedHashMap<String, Object>();
//                // 每循环一条将列名和列值存入Map
//                for (int i = 1; i < columnCount; i++) {
////                    System.out.println(rsmd.getColumnLabel(i));
////                    System.out.println(rsmd.getColumnName(i));
////                    System.out.println(rs.getObject(rsmd.getColumnLabel(i)));
//                    data.put(rsmd.getColumnLabel(i), rs.getString(rsmd
//                            .getColumnLabel(i)));
//                    
//                }
//                // 将整条数据的Map存入到List中
//                datas.add(data);
//            }
//            return datas;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			try {
//				conn.rollback();
//				System.out.println("rollback success!");
//			} catch (SQLException e1) {
//				System.out.println("rollback failed!");
//				e1.printStackTrace();
//			}
//		}finally{
//			try {
//				conn.commit();
//				System.out.println("commit success!");
//			} catch (SQLException e) {
//				System.out.println("commit failed!");
//				e.printStackTrace();
//			}
//			DBConnection.Close(conn);
//			DBConnection.Close(ps);
//			DBConnection.Close(rs);
//		}
//		return null;
//	}
	
	public static void main(String[] args) {
		ExcelServiceUtil util = new ExcelServiceUtil();
		String path = "D:\\";
		File file = new File(path+util.downloadFileName("test"));
		try {
			String sql = "select MCHNT_ID,MCHNT_NAME,MCHNT_ADDR,MCHNT_URL,ART_NAME,CERT_TYPE,CERT_NO,TAX_TYPE,TAX_NO,SINGLE_AMT,DAY_AMT,STATUS,TEL_NO,CONTACT,PHONE,FAX_NO,CRT_TIME,ADD_OPR,APPROVE_OPR,MCHNT_PUB_KEY,PRI_KEY,MCHNT_PRI_KEY,ENC_TYPE,MCHNT_KEY,UPD_TIME,MCHNT_LEVEL,MCHNT_TYPE,MCHNT_FLAG,PROD_FLAG,FIELD1,FIELD2,FIELD3 from T_MCH_INF ";
			String alias = "MCHNT_ID-商户ID,MCHNT_NAME-商户名称,MCHNT_ADDR-商户地址,MCHNT_URL,ART_NAME,CERT_TYPE,CERT_NO,TAX_TYPE,TAX_NO,SINGLE_AMT,DAY_AMT,STATUS,TEL_NO,CONTACT,PHONE,FAX_NO,CRT_TIME,ADD_OPR,APPROVE_OPR,MCHNT_PUB_KEY,PRI_KEY,MCHNT_PRI_KEY,ENC_TYPE,MCHNT_KEY,UPD_TIME,MCHNT_LEVEL,MCHNT_TYPE,MCHNT_FLAG,PROD_FLAG,FIELD1,FIELD2,FIELD3";
			file.createNewFile();
			OutputStream stream = new FileOutputStream(file);
//			util.doDownload(sql,alias,stream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}