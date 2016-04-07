package starstart.cgame.flows.land.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDemo {

	public static void main(String[] args) {
		String zipFilePath="E:/settle/20150715/LT04/1.zip";
		String txtFilePath="E:/settle/20150715/LT04/1.txt";
		
		
		String str="2015-07-20|LHZF||MSCVA00000000010054|0.00|84657.53|0.00000||1030000.00|PI00000000003|MSC20150718000000000|";
		str.split("\\|");
		/*try {
			File file = new File(zipFilePath); // 加密文件流保存本地文件
			file.getParentFile().mkdirs();
			if (!file.exists()) {
				file.createNewFile();
			}
			
			
			File file2 = new File(txtFilePath); // 解密文件
			if (!file2.exists()) {
				file2.createNewFile();
			}
			FileInputStream fileInput = new FileInputStream(file); // 读入加密文件流
			FileOutputStream fileOutput2 = new FileOutputStream(file2);
//			InputStream dataInput = DESCoder.decodeStream("hhnpUvciWN7fu0LfBxwGMSBAOMSCS.802" + TradeLocal.getToday(),
//					fileInput); // 使用3des密钥对加密文件流进行解密
//			DataInputStream dis = new DataInputStream(dataInput);
//			IOUtils.copy(dis, fileOutput2);
			fileInput.close();
			fileOutput2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
