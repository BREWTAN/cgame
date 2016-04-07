package starstart.cgame.flows.land.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import starstart.cgame.flows.nsttl.exception.SettleException;

public class FileUpLoadUtil {

	
	public static void isFileExits(String filepath,String pathFro){
		FileInputStream fileInput = null; 
		FileOutputStream fileOutput = null; 
		try {
			File file=new File(filepath);
			if(!file.exists()){
				String path=filepath.substring(0,filepath.lastIndexOf("/")+1);
				File fileN=new File(path);
				if(!fileN.exists()){
					fileN.mkdirs();
				}
				file.createNewFile();
				File fileLoc=new File(pathFro);
				fileInput = new FileInputStream(fileLoc); // 读入文件流
				fileOutput = new FileOutputStream(file);
				IOUtils.copy(fileInput, fileOutput);
				fileInput.close();
				fileOutput.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException();
		}finally{
			try {
				if(null!=fileInput){
					fileInput.close();
				}
				if(null!=fileOutput){
					fileOutput.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new SettleException();
			}
		}
	}
}
