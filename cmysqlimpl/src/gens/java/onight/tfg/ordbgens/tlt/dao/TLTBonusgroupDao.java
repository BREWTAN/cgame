package onight.tfg.ordbgens.tlt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tlt.entity.TLTBonusgroup;
import onight.tfg.ordbgens.tlt.entity.TLTBonusgroupExample;
import onight.tfg.ordbgens.tlt.entity.TLTBonusgroupExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTBonusgroupKey;
import onight.tfg.ordbgens.tlt.mapper.TLTBonusgroupMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_BONUSGROUP")
public class TLTBonusgroupDao extends ExtendDaoSupper<TLTBonusgroup, TLTBonusgroupExample, TLTBonusgroupKey>{

	private TLTBonusgroupMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTBonusgroupExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTBonusgroupExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTBonusgroupKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTBonusgroup record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTBonusgroup record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTBonusgroup> records) throws Exception
			 {
		for(TLTBonusgroup record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTBonusgroup> records) throws Exception
			 {
		for(TLTBonusgroup record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTBonusgroup> selectByExample(TLTBonusgroupExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTBonusgroup selectByPrimaryKey(TLTBonusgroupKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTBonusgroup> findAll(List<TLTBonusgroup> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTBonusgroupExample());
		}
		List<TLTBonusgroup> list = new ArrayList();
		for(TLTBonusgroup record : records){
			TLTBonusgroup result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTBonusgroup record, TLTBonusgroupExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTBonusgroup record, TLTBonusgroupExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTBonusgroup record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTBonusgroup record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTBonusgroupExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTBonusgroupExample());
	}

	@Override
	public TLTBonusgroupExample getExample(TLTBonusgroup record) {
		TLTBonusgroupExample example = new TLTBonusgroupExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getId()!=null){
				criteria.andIdEqualTo(record.getId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getCnName()!=null){
				criteria.andCnNameEqualTo(record.getCnName());
				}
				if(record.getEnName()!=null){
				criteria.andEnNameEqualTo(record.getEnName());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(record.getUpdateTime()!=null){
				criteria.andUpdateTimeEqualTo(record.getUpdateTime());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}

		}
		return example;
	}
	
	public TLTBonusgroup selectOneByExample(TLTBonusgroupExample example)
			 {
		example.setLimit(1);
		List<TLTBonusgroup> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTBonusgroup> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_BONUSGROUP() values");
			int i=0;
			for (TLTBonusgroup record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getPlayType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPlayType()+"'");
				}
			
				sb.append(",");
			
				if(record.getCnName()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getCnName()+"'");
				}
			
				sb.append(",");
			
				if(record.getEnName()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getEnName()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreateTime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getCreateTime())+"'");
				}
			
				sb.append(",");
			
				if(record.getUpdateTime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getUpdateTime())+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getUserId()+"'");
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
