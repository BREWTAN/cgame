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

import onight.tfg.ordbgens.tlt.entity.TLTPlaygroup;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroupExample;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroupExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroupKey;
import onight.tfg.ordbgens.tlt.mapper.TLTPlaygroupMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_PLAYGROUP")
public class TLTPlaygroupDao extends ExtendDaoSupper<TLTPlaygroup, TLTPlaygroupExample, TLTPlaygroupKey>{

	private TLTPlaygroupMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTPlaygroupExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTPlaygroupExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTPlaygroupKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTPlaygroup record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTPlaygroup record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTPlaygroup> records) throws Exception
			 {
		for(TLTPlaygroup record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTPlaygroup> records) throws Exception
			 {
		for(TLTPlaygroup record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTPlaygroup> selectByExample(TLTPlaygroupExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTPlaygroup selectByPrimaryKey(TLTPlaygroupKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTPlaygroup> findAll(List<TLTPlaygroup> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTPlaygroupExample());
		}
		List<TLTPlaygroup> list = new ArrayList();
		for(TLTPlaygroup record : records){
			TLTPlaygroup result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTPlaygroup record, TLTPlaygroupExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTPlaygroup record, TLTPlaygroupExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTPlaygroup record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTPlaygroup record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTPlaygroupExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTPlaygroupExample());
	}

	@Override
	public TLTPlaygroupExample getExample(TLTPlaygroup record) {
		TLTPlaygroupExample example = new TLTPlaygroupExample();
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
				if(record.getLockTable()!=null){
				criteria.andLockTableEqualTo(record.getLockTable());
				}
				if(record.getAwardLevel()!=null){
				criteria.andAwardLevelEqualTo(record.getAwardLevel());
				}
				if(record.getCost()!=null){
				criteria.andCostEqualTo(record.getCost());
				}
				if(record.getEnable()!=null){
				criteria.andEnableEqualTo(record.getEnable());
				}
				if(record.getRemark()!=null){
				criteria.andRemarkEqualTo(record.getRemark());
				}
				if(record.getRebate()!=null){
				criteria.andRebateEqualTo(record.getRebate());
				}
				if(record.getDeloRebate()!=null){
				criteria.andDeloRebateEqualTo(record.getDeloRebate());
				}
				if(record.getViewgroup()!=null){
				criteria.andViewgroupEqualTo(record.getViewgroup());
				}

		}
		return example;
	}
	
	public TLTPlaygroup selectOneByExample(TLTPlaygroupExample example)
			 {
		example.setLimit(1);
		List<TLTPlaygroup> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTPlaygroup> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_PLAYGROUP() values");
			int i=0;
			for (TLTPlaygroup record : records) {
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
			
				if(record.getLockTable()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLockTable()+"'");
				}
			
				sb.append(",");
			
				if(record.getAwardLevel()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getAwardLevel()+"'");
				}
			
				sb.append(",");
			
				if(record.getCost()==null){
						sb.append("'"+"0.00"+"'");						
				}else{
				// java type==Float
						sb.append("'"+record.getCost()+"'");
				}
			
				sb.append(",");
			
				if(record.getEnable()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Boolean
						sb.append("'"+record.getEnable()+"'");
				}
			
				sb.append(",");
			
				if(record.getRemark()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getRemark()+"'");
				}
			
				sb.append(",");
			
				if(record.getRebate()==null){
						sb.append("'"+"0.0"+"'");						
				}else{
				// java type==Float
						sb.append("'"+record.getRebate()+"'");
				}
			
				sb.append(",");
			
				if(record.getDeloRebate()==null){
						sb.append("'"+"0.0"+"'");						
				}else{
				// java type==Float
						sb.append("'"+record.getDeloRebate()+"'");
				}
			
				sb.append(",");
			
				if(record.getViewgroup()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getViewgroup()+"'");
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
