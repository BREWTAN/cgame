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

import onight.tfg.ordbgens.tlt.mapper.TLTLimitedNumMapper;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNum;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumExample;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumKey;

@Slf4j
@Controller
@RequestMapping("/tltlimitednum")
public class TLTLimitedNumCtrl extends BasicCtrl {

	private static TLTLimitedNumMapper tLTLimitedNumMapper = 
			(TLTLimitedNumMapper)BeanFactory.getBean("tLTLimitedNumMapper");
	
	private static DataService mysqlDataService = 
			(DataService)BeanFactory.getBean("mysqlDataService");
	
	/**
	 * ajax单条数据插入 
	 * url:'http://ip/rest/tltlimitednum' 
	 * data:'{"key1":"value1","key2":"value2",...}' 
	 * type:’POST
	 */
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert( @RequestBody TLTLimitedNum info,HttpServletRequest req) {
		try {
			tLTLimitedNumMapper.insertSelective(info);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("TLTLimitedNumCtrl insert error..",e);
//			e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}
	
	/**
	 * ajax精确查询请求 
	 * url: 'http://ip/app/tltlimitednum/?query=({"key1":"value1","key2":"value2",...})' 
	 * dataType: 'json' 
	 * type: 'get'
	 * 
	 * ajax无条件查询全部请求
	 * url: 'http://ip/app/tltlimitednum' 
	 * dataType: 'json' 
	 * type: 'get' 
	 * 
	 * ajax模糊查询请求 
	 * url: 'http://ip/app/tltlimitednum/?query={"(colname)":{"$regex":"(colvalue)","$options":"i"} 
	 * dataType: 'json' 
	 * type: 'get'
	 * 
	 * ajax分页查询
	 * 请求 url: 'http://ip/app/tltlimitednum/?query=(空或{"key1":"value1","key2":"value2",...})&skip=" + beginRow + "&limit=" + rowNum' 
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
			dc.setEntityClass(TLTLimitedNum.class);
			dc.setKeyClass(TLTLimitedNumKey.class);
			dc.setMapperClass(TLTLimitedNumMapper.class);
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
			log.warn("TLTLimitedNumCtrl get error..",e);
		}
		if(para.isPage()){
			return new ListInfo(totalCount, list, para);
		}else{
			return list;
		}
	}
	
	/**
	 * ajax根据ID主键查询
	 * 请求 url: 'http://ip/app/tltlimitednum/(_id值)' 
	 * dataType: 'json' 
	 * type: 'get'
	 */
	@RequestMapping(value="/{key}",method=RequestMethod.GET)
	@ResponseBody
	public ListInfo<TLTLimitedNum> get(@PathVariable String key,HttpServletRequest req) {
		int totalCount = 1;
		List<TLTLimitedNum> list = null;
		try {
			TLTLimitedNum akey = new TLTLimitedNum();
				
				Field keyField=FieldUtils.allDeclaredField(TLTLimitedNumKey.class).get(0);

				if(keyField.getType().isInstance(1)){
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				}else if(keyField.getType().isInstance(1L)){
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				}else{
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				
			
			if(true && akey.getUuid() == null ){
				list = new ArrayList<TLTLimitedNum>();
			}else{
				TLTLimitedNumExample example = new TLTLimitedNumExample();
				example.createCriteria().andUuidEqualTo(akey.getUuid());
				list = tLTLimitedNumMapper.selectByExample(example);
			}
			totalCount = list.size();
		} catch (Exception e) {
			log.warn("TLTLimitedNumCtrl get by key error..",e);
		}
		return  new ListInfo(totalCount, list, 0, 1);
	}
	
	/**
	 * ajax根据主键删除 
	 * url:'http://ip/app/tltlimitednum/(_id值)' 
	 * type: 'DELETE' 
	 * dataType: 'json' 
	 */
	@RequestMapping(value="/{key}",method=RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key,HttpServletRequest req) {
		try {
			TLTLimitedNum akey = new TLTLimitedNum();
				
				Field keyField=FieldUtils.allDeclaredField(TLTLimitedNumKey.class).get(0);

				if(keyField.getType().isInstance(1)){
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				}else if(keyField.getType().isInstance(1L)){
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				}else{
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				
			if(true && akey.getUuid() != null ){
				tLTLimitedNumMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("TLTLimitedNumCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}
	
	/**
	 * ajax根据主键单条修改 
	 * url:'http://ip/app/tltlimitednum/(_id值)' 
	 * data:'{"key1":"value1","key2":"value2",...}' 
	 * type:'PUT'
	 */
	@RequestMapping(value="/{key}",method=RequestMethod.PUT)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key,@RequestBody TLTLimitedNum info,HttpServletRequest req) {
		try {
			if(info!=null){
				TLTLimitedNum akey = new TLTLimitedNum();
				
				Field keyField=FieldUtils.allDeclaredField(TLTLimitedNumKey.class).get(0);

				if(keyField.getType().isInstance(1)){
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				}else if(keyField.getType().isInstance(1L)){
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				}else{
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				TLTLimitedNumExample example = new TLTLimitedNumExample();
				example.createCriteria().andUuidEqualTo(akey.getUuid());
				tLTLimitedNumMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("TLTLimitedNum update by key error..");
		}
		return ReturnInfo.Faild;
	}
	
	private void setTableName(DbCondi dc){
		String tName = DBBean.getTableName2Class(TLTLimitedNum.class);
		if(dc.getOther() == null){
			Map<String,Object> o = new HashMap<String,Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		}else{
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}
	
	@SuppressWarnings("serial")
	public static class TLTLimitedNums extends ArrayList<TLTLimitedNum> {  
	    public TLTLimitedNums() { super(); }  
	}
}