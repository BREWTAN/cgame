package onight.tfg.ordbgens.tfg.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tfg.entity.TFGGroup;
import onight.tfg.ordbgens.tfg.entity.TFGGroupExample;
import onight.tfg.ordbgens.tfg.entity.TFGGroupExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGGroupKey;
import onight.tfg.ordbgens.tfg.mapper.TFGGroupMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFG_GROUP")
public class TFGGroupDao extends ExtendDaoSupper<TFGGroup, TFGGroupExample, TFGGroupKey>{

	private TFGGroupMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFGGroupExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFGGroupExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFGGroupKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFGGroup record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFGGroup record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFGGroup> records) throws Exception
			 {
		for(TFGGroup record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFGGroup> records) throws Exception
			 {
		for(TFGGroup record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFGGroup> selectByExample(TFGGroupExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFGGroup selectByPrimaryKey(TFGGroupKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFGGroup> findAll(List<TFGGroup> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFGGroupExample());
		}
		List<TFGGroup> list = new ArrayList();
		for(TFGGroup record : records){
			TFGGroup result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFGGroup record, TFGGroupExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFGGroup record, TFGGroupExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFGGroup record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFGGroup record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFGGroupExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TFGGroupExample());
	}

	@Override
	public TFGGroupExample getExample(TFGGroup record) {
		TFGGroupExample example = new TFGGroupExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getGroupId()!=null){
				criteria.andGroupIdEqualTo(record.getGroupId());
				}
				if(record.getParentGroupId()!=null){
				criteria.andParentGroupIdEqualTo(record.getParentGroupId());
				}
				if(record.getGroupName()!=null){
				criteria.andGroupNameEqualTo(record.getGroupName());
				}
				if(record.getGroupDesc()!=null){
				criteria.andGroupDescEqualTo(record.getGroupDesc());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}

		}
		return example;
	}
	
	public TFGGroup selectOneByExample(TFGGroupExample example)
			 {
		example.setLimit(1);
		List<TFGGroup> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFGGroup> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFG_GROUP() values");
			int i=0;
			for (TFGGroup record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getGroupId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getGroupId()+"'");
				}
			
				sb.append(",");
			
				if(record.getParentGroupId()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getParentGroupId()+"'");
				}
			
				sb.append(",");
			
				if(record.getGroupName()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getGroupName()+"'");
				}
			
				sb.append(",");
			
				if(record.getGroupDesc()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getGroupDesc()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("null");
				}else{
					sb.append("'"+record.getStatus()+"'");
				}
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
