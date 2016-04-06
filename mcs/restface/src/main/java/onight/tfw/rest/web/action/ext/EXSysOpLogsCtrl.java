package onight.tfw.rest.web.action.ext;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import onight.tfg.ordbgens.sys.entity.TSysOpLogs;
import onight.tfg.ordbgens.sys.mapper.TSysOpLogsMapper;
import onight.tfw.rest.db.ext.EXSysOpLogsMapper;
import onight.tfw.rest.utils.BeanFactory;
import onight.tfw.rest.web.bean.ReturnInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/exsysoplogs")
public class EXSysOpLogsCtrl {

	private static EXSysOpLogsMapper exTSysOpLogsMapper = (EXSysOpLogsMapper) BeanFactory
			.getBean("exSysOpLogsMapper");
	private static TSysOpLogsMapper sysOpLogsMapper = (TSysOpLogsMapper) BeanFactory
			.getBean("tSysOpLogsMapper");
	@RequestMapping(value = "/getLogs", method = RequestMethod.GET)
	@ResponseBody
	public Object getLogs(HttpServletRequest req) {
		Object ret = exTSysOpLogsMapper.selectLogs();
		log.debug("ret.getrole==" + ret);
		return ret;
	}
	/**
	 * ajax单条数据插入 
	 * url:'http://ip/rest/sysoplogs' 
	 * data:'{"key1":"value1","key2":"value2",...}' 
	 * type:’POST
	 */
	@RequestMapping(value="/saveAuditLogInfo",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert( @RequestBody TSysOpLogs info,HttpServletRequest req) {
		try {
			sysOpLogsMapper.insert(info);
			log.info("[zbx]:AUDIT|0000|审批信息："+info.getContents()+"|审核人:"+info.getSkeys()+"|状态："+info.getLevel());
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("TSysOpLogsCtrl insert error..",e);
//			e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}
}
