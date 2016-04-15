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

import onight.tfg.ordbgens.tlt.entity.TLTCoreUseridPrize;
import onight.tfg.ordbgens.tlt.entity.TLTCoreUseridPrizeExample;
import onight.tfg.ordbgens.tlt.entity.TLTCoreUseridPrizeExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTCoreUseridPrizeKey;
import onight.tfg.ordbgens.tlt.mapper.TLTCoreUseridPrizeMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_CORE_USERID_PRIZE")
public class TLTCoreUseridPrizeDao extends ExtendDaoSupper<TLTCoreUseridPrize, TLTCoreUseridPrizeExample, TLTCoreUseridPrizeKey>{

	private TLTCoreUseridPrizeMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTCoreUseridPrizeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTCoreUseridPrizeExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTCoreUseridPrizeKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTCoreUseridPrize record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTCoreUseridPrize record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTCoreUseridPrize> records) throws Exception
			 {
		for(TLTCoreUseridPrize record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTCoreUseridPrize> records) throws Exception
			 {
		for(TLTCoreUseridPrize record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTCoreUseridPrize> selectByExample(TLTCoreUseridPrizeExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTCoreUseridPrize selectByPrimaryKey(TLTCoreUseridPrizeKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTCoreUseridPrize> findAll(List<TLTCoreUseridPrize> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTCoreUseridPrizeExample());
		}
		List<TLTCoreUseridPrize> list = new ArrayList();
		for(TLTCoreUseridPrize record : records){
			TLTCoreUseridPrize result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTCoreUseridPrize record, TLTCoreUseridPrizeExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTCoreUseridPrize record, TLTCoreUseridPrizeExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTCoreUseridPrize record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTCoreUseridPrize record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTCoreUseridPrizeExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTCoreUseridPrizeExample());
	}

	@Override
	public TLTCoreUseridPrizeExample getExample(TLTCoreUseridPrize record) {
		TLTCoreUseridPrizeExample example = new TLTCoreUseridPrizeExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUuid()!=null){
				criteria.andUuidEqualTo(record.getUuid());
				}
				if(record.getCatalog()!=null){
				criteria.andCatalogEqualTo(record.getCatalog());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}

		}
		return example;
	}
	
	public TLTCoreUseridPrize selectOneByExample(TLTCoreUseridPrizeExample example)
			 {
		example.setLimit(1);
		List<TLTCoreUseridPrize> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTCoreUseridPrize> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_CORE_USERID_PRIZE(UUID,CATALOG,USER_ID,LTYPE) values");
			int i=0;
			for (TLTCoreUseridPrize record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getUuid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUuid()+"'");
				}
			
				sb.append(",");
			
				if(record.getCatalog()==null){
//						sb.append("'"+"ALL"+"'");
						sb.append("'"+"ALL"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getCatalog()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
//						sb.append("'"+"ALL"+"'");
						sb.append("'"+"ALL"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
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
