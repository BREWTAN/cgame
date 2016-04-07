package starstart.cgame.flows.land.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 
* @ClassName: BlendAccountCheckingFiles 
* @Description: 对账 脚本执行
* @author kyn
* @date 2015年4月14日 下午5:48:31 
*
 */
public class BlendAccountCheckingFiles {
	
	
	
	public static void execute(Map<String,Object> parammap) {
		try {
			String cmds="";
			cmds=parammap.get("shell").toString();
			List<String> cmdList = new ArrayList<String>();
			cmdList.add("sh");
			cmdList.add("-c");
			cmdList.add(cmds);
			//log.info("执行脚本命令："+cmdList);
			if(!executeCommand(cmdList)){
				throw new Exception("执行脚本失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static boolean executeCommand(List<String> list) throws Exception{
		BufferedReader brError = null;
		try {
			ProcessBuilder pb = new ProcessBuilder(list);
			Process process = pb.start();
			brError =new BufferedReader(new InputStreamReader(process.getErrorStream()));
			StringBuffer dataline = new StringBuffer();
			String line;
			while((line = brError.readLine()) != null){
				dataline.append(line);
			}
			//log.error(dataline.toString());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				brError.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
