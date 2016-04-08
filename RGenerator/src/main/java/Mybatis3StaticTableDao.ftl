package ${packageName}.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import ${packageName}.entity.${domainClazz};
import ${packageName}.entity.${domainClazz}Example;
import ${packageName}.entity.${domainClazz}Example.Criteria;
import ${packageName}.entity.${domainClazz}Key;
import ${packageName}.mapper.${domainClazz}Mapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="${clazzinfo.tablename}")
public class ${domainClazz}Dao extends ExtendDaoSupper<${domainClazz}, ${domainClazz}Example, ${domainClazz}Key>{

	private ${domainClazz}Mapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(${domainClazz}Example example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(${domainClazz}Example example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(${domainClazz}Key key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(${domainClazz} record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(${domainClazz} record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<${domainClazz}> records) throws Exception
			 {
		for(${domainClazz} record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<${domainClazz}> records) throws Exception
			 {
		for(${domainClazz} record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<${domainClazz}> selectByExample(${domainClazz}Example example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public ${domainClazz} selectByPrimaryKey(${domainClazz}Key key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<${domainClazz}> findAll(List<${domainClazz}> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new ${domainClazz}Example());
		}
		List<${domainClazz}> list = new ArrayList();
		for(${domainClazz} record : records){
			${domainClazz} result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(${domainClazz} record, ${domainClazz}Example example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(${domainClazz} record, ${domainClazz}Example example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(${domainClazz} record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(${domainClazz} record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(${domainClazz}Example example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new ${domainClazz}Example());
	}

	@Override
	public ${domainClazz}Example getExample(${domainClazz} record) {
		${domainClazz}Example example = new ${domainClazz}Example();
		if(record!=null){
			Criteria criteria = example.createCriteria();
			${exampleBody}
		}
		return example;
	}
	
	public ${domainClazz} selectOneByExample(${domainClazz}Example example)
			 {
		example.setLimit(1);
		List<${domainClazz}> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<${domainClazz}> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO ${clazzinfo.tablename}(${clazzinfo.columns}) values");
			int i=0;
			for (${domainClazz} record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			<#list clazzinfo.columnAndProps as columns> 
			
			<#if columns_index == 0>
				sb.append("(");
			<#else>
				sb.append(",");
			</#if>
			
				if(record.${columns[2]}()==null){
				<#if columns[1]?exists >
						sb.append("'"+"${columns[1]}"+"'");						
				<#else>
						sb.append("null");
				</#if> 
				}else{
				// java type==${columns[4]}
					<#if columns[4] == "Date" >
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.${columns[2]}())+"'");
					<#else>
						sb.append("'"+record.${columns[2]}()+"'");
					</#if>
				}
			</#list>
							sb.append(")");
			
			}
			result=st.executeUpdate(sb.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		}finally{
			if(st!=null){
				try {
					st.close();
				} catch (Exception est) {
					est.printStackTrace();
				}
			}
			session.close();
		}
		return result;
	}
	
	
}
