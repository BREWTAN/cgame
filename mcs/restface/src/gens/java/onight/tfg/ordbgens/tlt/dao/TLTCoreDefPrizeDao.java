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

import onight.tfg.ordbgens.tlt.entity.TLTCoreDefPrize;
import onight.tfg.ordbgens.tlt.entity.TLTCoreDefPrizeExample;
import onight.tfg.ordbgens.tlt.entity.TLTCoreDefPrizeExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTCoreDefPrizeKey;
import onight.tfg.ordbgens.tlt.mapper.TLTCoreDefPrizeMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_CORE_DEF_PRIZE")
public class TLTCoreDefPrizeDao extends ExtendDaoSupper<TLTCoreDefPrize, TLTCoreDefPrizeExample, TLTCoreDefPrizeKey>{

	private TLTCoreDefPrizeMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTCoreDefPrizeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTCoreDefPrizeExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTCoreDefPrizeKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTCoreDefPrize record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTCoreDefPrize record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTCoreDefPrize> records) throws Exception
			 {
		for(TLTCoreDefPrize record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTCoreDefPrize> records) throws Exception
			 {
		for(TLTCoreDefPrize record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTCoreDefPrize> selectByExample(TLTCoreDefPrizeExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTCoreDefPrize selectByPrimaryKey(TLTCoreDefPrizeKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTCoreDefPrize> findAll(List<TLTCoreDefPrize> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTCoreDefPrizeExample());
		}
		List<TLTCoreDefPrize> list = new ArrayList();
		for(TLTCoreDefPrize record : records){
			TLTCoreDefPrize result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTCoreDefPrize record, TLTCoreDefPrizeExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTCoreDefPrize record, TLTCoreDefPrizeExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTCoreDefPrize record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTCoreDefPrize record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTCoreDefPrizeExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTCoreDefPrizeExample());
	}

	@Override
	public TLTCoreDefPrizeExample getExample(TLTCoreDefPrize record) {
		TLTCoreDefPrizeExample example = new TLTCoreDefPrizeExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getUuid()!=null){
				criteria.andUuidEqualTo(record.getUuid());
				}
				if(record.getCatalog()!=null){
				criteria.andCatalogEqualTo(record.getCatalog());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getWinLevel()!=null){
				criteria.andWinLevelEqualTo(record.getWinLevel());
				}
				if(record.getRegion()!=null){
				criteria.andRegionEqualTo(record.getRegion());
				}
				if(record.getDivision()!=null){
				criteria.andDivisionEqualTo(record.getDivision());
				}
				if(record.getWonboards()!=null){
				criteria.andWonboardsEqualTo(record.getWonboards());
				}
				if(record.getWinAmount()!=null){
				criteria.andWinAmountEqualTo(record.getWinAmount());
				}
				if(record.getBonusAmount()!=null){
				criteria.andBonusAmountEqualTo(record.getBonusAmount());
				}
				if(record.getPriority()!=null){
				criteria.andPriorityEqualTo(record.getPriority());
				}
				if(record.getInserttime()!=null){
				criteria.andInserttimeEqualTo(record.getInserttime());
				}

		}
		return example;
	}
	
	public TLTCoreDefPrize selectOneByExample(TLTCoreDefPrizeExample example)
			 {
		example.setLimit(1);
		List<TLTCoreDefPrize> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTCoreDefPrize> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_CORE_DEF_PRIZE(UUID,CATALOG,LTYPE,PLAY_TYPE,WIN_LEVEL,REGION,DIVISION,WONBOARDS,WIN_AMOUNT,BONUS_AMOUNT,PRIORITY,INSERTTIME) values");
			int i=0;
			for (TLTCoreDefPrize record : records) {
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
//						sb.append("'"+"*"+"'");
						sb.append("'"+"*"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getCatalog()+"'");
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
			
				if(record.getWinLevel()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getWinLevel()+"'");
				}
			
				sb.append(",");
			
				if(record.getRegion()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getRegion()+"'");
				}
			
				sb.append(",");
			
				if(record.getDivision()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getDivision()+"'");
				}
			
				sb.append(",");
			
				if(record.getWonboards()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getWonboards()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinAmount()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getWinAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getBonusAmount()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getBonusAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getPriority()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getPriority()+"'");
				}
			
				sb.append(",");
			
				if(record.getInserttime()==null){
//						sb.append("'"+"CURRENT_TIMESTAMP"+"'");
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(new java.util.Date())+"'");
						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getInserttime())+"'");
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
