package onight.tfw.rest.web.action.ext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import onight.tfw.rest.db.ext.EXSysActionMapper;
import onight.tfw.rest.utils.BeanFactory;
import onight.tfw.rest.web.bean.FieldsMapperBean;
import onight.tfw.rest.web.bean.PageInfo;
import onight.tfw.rest.web.bean.QueryMapperBean;
import onight.tfw.rest.web.bind.RequestJsonParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/exsysaction")
public class EXSysActionCtrl {

	private static EXSysActionMapper exSysActionMapper = (EXSysActionMapper) BeanFactory
			.getBean("exSysActionMapper");

	/**
	 * ajax精确查询请求 
	 * url: 'http://ip/app/sysaction/?query=({"key1":"value1","key2":"value2",...})' 
	 * dataType: 'json' 
	 * type: 'get'
	 * 
	 * ajax无条件查询全部请求
	 * url: 'http://ip/app/sysaction' 
	 * dataType: 'json' 
	 * type: 'get' 
	 * 
	 * ajax模糊查询请求 
	 * url: 'http://ip/app/sysaction/?query={"(colname)":{"$regex":"(colvalue)","$options":"i"} 
	 * dataType: 'json' 
	 * type: 'get'
	 * 
	 * ajax分页查询
	 * 请求 url: 'http://ip/app/sysaction/?query=(空或{"key1":"value1","key2":"value2",...})&skip=" + beginRow + "&limit=" + rowNum' 
	 * dataType:'json' 
	 * type:'get' 
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@RequestJsonParam(value = "query",required=false) QueryMapperBean info,
			@RequestJsonParam(value = "fields",required=false) FieldsMapperBean fmb,
			PageInfo para, HttpServletRequest req) {
		Object list = null;
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("userId", info.getNode().get("userId").getTextValue());
			map.put("actionFlag", info.getNode().get("actionFlag").getTextValue());
			list = exSysActionMapper.selectActionCount(map);
		} catch (Exception e) {
			log.warn("SysActionCtrl get error..",e);
		}
		return list;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public Object getList(HttpServletRequest req) {
		Object list = null;
		try {
			list = exSysActionMapper.selectActionList();
		} catch (Exception e) {
			log.warn("SysActionCtrl get error..",e);
		}
		return list;
	}
}
