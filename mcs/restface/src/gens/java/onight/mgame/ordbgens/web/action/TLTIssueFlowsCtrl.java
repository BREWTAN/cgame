package onight.mgame.ordbgens.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import onight.tfw.rest.utils.BeanFactory;
import onight.tfw.rest.utils.DBBean;
import onight.tfw.rest.utils.SerializerUtil;
import onight.tfw.rest.web.bean.DbCondi;
import onight.tfw.rest.web.bean.FieldsMapperBean;
import onight.tfw.rest.web.bean.ListInfo;
import onight.tfw.rest.web.bean.PageInfo;
import onight.tfw.rest.web.bean.QueryMapperBean;
import onight.tfw.rest.web.bean.ReturnInfo;
import onight.tfw.rest.web.bean.SqlMaker;
import onight.tfw.rest.web.bind.FieldUtils;
import onight.tfw.rest.web.bind.KeyExplainHandler;
import onight.tfw.rest.web.bind.RequestJsonParam;
import onight.tfw.rest.db.service.DataService;
import onight.tfw.rest.web.action.BasicCtrl;

import onight.tfg.ordbgens.tlt.mapper.TLTIssueFlowsMapper;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlows;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsKey;

@Slf4j
@Controller
@RequestMapping("/tltissueflows")
public class TLTIssueFlowsCtrl extends BasicCtrl {

	private static TLTIssueFlowsMapper tLTIssueFlowsMapper = 
			(TLTIssueFlowsMapper)BeanFactory.getBean("tLTIssueFlowsMapper");
	
	private static DataService mysqlDataService = 
			(DataService)BeanFactory.getBean("mysqlDataService");
	
	/**
	 * ajax单条数据插入 
	 * url:'http://ip/rest/tltissueflows' 
	 * data:'{"key1":"value1","key2":"value2",...}' 
	 * type:’POST
	 */
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert( @RequestBody TLTIssueFlows info,HttpServletRequest req) {
		try {
			tLTIssueFlowsMapper.insertSelective(info);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("TLTIssueFlowsCtrl insert error..",e);
//			e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}
	
	/**
	 * ajax精确查询请求 
	 * url: 'http://ip/app/tltissueflows/?query=({"key1":"value1","key2":"value2",...})' 
	 * dataType: 'json' 
	 * type: 'get'
	 * 
	 * ajax无条件查询全部请求
	 * url: 'http://ip/app/tltissueflows' 
	 * dataType: 'json' 
	 * type: 'get' 
	 * 
	 * ajax模糊查询请求 
	 * url: 'http://ip/app/tltissueflows/?query={"(colname)":{"$regex":"(colvalue)","$options":"i"} 
	 * dataType: 'json' 
	 * type: 'get'
	 * 
	 * ajax分页查询
	 * 请求 url: 'http://ip/app/tltissueflows/?query=(空或{"key1":"value1","key2":"value2",...})&skip=" + beginRow + "&limit=" + rowNum' 
	 * dataType:'json' 
	 * type:'get' 
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@RequestJsonParam(value = "query",required=false) QueryMapperBean info,
			@RequestJsonParam(value = "fields",required=false) FieldsMapperBean fmb,
			PageInfo para, HttpServletRequest req) {
		int totalCount = 0;
		List<HashMap> list = null;
		try {
			DbCondi dc = new DbCondi();
			dc.setEntityClass(TLTIssueFlows.class);
			dc.setKeyClass(TLTIssueFlowsKey.class);
			dc.setMapperClass(TLTIssueFlowsMapper.class);
			dc.setQmb(info);
			dc.setPageinfo(para);
			dc.setFmb(fmb);
			this.setTableName(dc);
			// TEST  query
//			if(info!=null){
//				StringBuffer keyValues = new StringBuffer();
//				for(EqualBean b : info.getEqual()){
//					keyValues.append(b.getFieldName()).append(" = ").append(b.getValue()).append(",");
//				}
//				for(LikeBean b : info.getLikes()){
//					keyValues.append(b.getFieldName()).append(" like ").append(b.getRegex()).append(",");
//				}
//				for(OrBean b : info.getOr()){
//					keyValues.append(b.getFieldName()).append(" or ").append(b.getValue()).append(",");
//				}
//				for(ConditionBean b : info.getCondition()){
//					keyValues.append(b.getFieldName()).append(" ").append(b.getCondi())
//					.append(" ").append(b.getValue()).append(",");
//				}
//				log.debug("传递参数为="+keyValues.toString());
//			}
			////////////////////
			String sql = SqlMaker.getReferenceCountSql(dc);
			totalCount = mysqlDataService.getCount(sql);
			sql = SqlMaker.getReferenceData(dc); 
			list = SerializerUtil.deserializeArray(mysqlDataService.doBySQL(sql), HashMap.class);
			for(HashMap map : list){
				for(Field filed:FieldUtils.allDeclaredField(dc.getKeyClass())){
					if(map.get(filed.getName())==null){
						map.put(filed.getName(), "");
					}
				}
				map.put(KeyExplainHandler.ID_KEY, KeyExplainHandler.genKey(map, dc.getKeyClass()));
			}
		} catch (Exception e) {
			log.warn("TLTIssueFlowsCtrl get error..",e);
		}
		if(para.isPage()){
			return new ListInfo(totalCount, list, para);
		}else{
			return list;
		}
	}
	
	/**
	 * ajax根据ID主键查询
	 * 请求 url: 'http://ip/app/tltissueflows/(_id值)' 
	 * dataType: 'json' 
	 * type: 'get'
	 */
	@RequestMapping(value="/{key}",method=RequestMethod.GET)
	@ResponseBody
	public ListInfo<TLTIssueFlows> get(@PathVariable String key,HttpServletRequest req) {
		int totalCount = 1;
		List<TLTIssueFlows> list = null;
		try {
			TLTIssueFlows akey = new TLTIssueFlows();
				
				Field keyField=FieldUtils.allDeclaredField(TLTIssueFlowsKey.class).get(0);

				if(keyField.getType().isInstance(1)){
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				}else if(keyField.getType().isInstance(1L)){
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				}else{
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				
			
			if(true && akey.getGenId() == null ){
				list = new ArrayList<TLTIssueFlows>();
			}else{
				TLTIssueFlowsExample example = new TLTIssueFlowsExample();
				example.createCriteria().andGenIdEqualTo(akey.getGenId());
				list = tLTIssueFlowsMapper.selectByExample(example);
			}
			totalCount = list.size();
		} catch (Exception e) {
			log.warn("TLTIssueFlowsCtrl get by key error..",e);
		}
		return  new ListInfo(totalCount, list, 0, 1);
	}
	
	/**
	 * ajax根据主键删除 
	 * url:'http://ip/app/tltissueflows/(_id值)' 
	 * type: 'DELETE' 
	 * dataType: 'json' 
	 */
	@RequestMapping(value="/{key}",method=RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key,HttpServletRequest req) {
		try {
			TLTIssueFlows akey = new TLTIssueFlows();
				
				Field keyField=FieldUtils.allDeclaredField(TLTIssueFlowsKey.class).get(0);

				if(keyField.getType().isInstance(1)){
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				}else if(keyField.getType().isInstance(1L)){
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				}else{
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				
			if(true && akey.getGenId() != null ){
				tLTIssueFlowsMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("TLTIssueFlowsCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}
	
	/**
	 * ajax根据主键单条修改 
	 * url:'http://ip/app/tltissueflows/(_id值)' 
	 * data:'{"key1":"value1","key2":"value2",...}' 
	 * type:'PUT'
	 */
	@RequestMapping(value="/{key}",method=RequestMethod.PUT)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key,@RequestBody TLTIssueFlows info,HttpServletRequest req) {
		try {
			if(info!=null){
				TLTIssueFlows akey = new TLTIssueFlows();
				
				Field keyField=FieldUtils.allDeclaredField(TLTIssueFlowsKey.class).get(0);

				if(keyField.getType().isInstance(1)){
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				}else if(keyField.getType().isInstance(1L)){
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				}else{
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				TLTIssueFlowsExample example = new TLTIssueFlowsExample();
				example.createCriteria().andGenIdEqualTo(akey.getGenId());
				tLTIssueFlowsMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("TLTIssueFlows update by key error..");
		}
		return ReturnInfo.Faild;
	}
	
	private void setTableName(DbCondi dc){
		String tName = DBBean.getTableName2Class(TLTIssueFlows.class);
		if(dc.getOther() == null){
			Map<String,Object> o = new HashMap<String,Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		}else{
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}
	
	@SuppressWarnings("serial")
	public static class TLTIssueFlowss extends ArrayList<TLTIssueFlows> {  
	    public TLTIssueFlowss() { super(); }  
	}
}