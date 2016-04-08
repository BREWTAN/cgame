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

import onight.tfg.ordbgens.tlt.entity.TLTBetAuto;
import onight.tfg.ordbgens.tlt.entity.TLTBetAutoExample;
import onight.tfg.ordbgens.tlt.entity.TLTBetAutoExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTBetAutoKey;
import onight.tfg.ordbgens.tlt.mapper.TLTBetAutoMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_BET_AUTO")
public class TLTBetAutoDao extends ExtendDaoSupper<TLTBetAuto, TLTBetAutoExample, TLTBetAutoKey>{

	private TLTBetAutoMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTBetAutoExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTBetAutoExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTBetAutoKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTBetAuto record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTBetAuto record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTBetAuto> records) throws Exception
			 {
		for(TLTBetAuto record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTBetAuto> records) throws Exception
			 {
		for(TLTBetAuto record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTBetAuto> selectByExample(TLTBetAutoExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTBetAuto selectByPrimaryKey(TLTBetAutoKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTBetAuto> findAll(List<TLTBetAuto> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTBetAutoExample());
		}
		List<TLTBetAuto> list = new ArrayList();
		for(TLTBetAuto record : records){
			TLTBetAuto result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTBetAuto record, TLTBetAutoExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTBetAuto record, TLTBetAutoExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTBetAuto record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTBetAuto record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTBetAutoExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTBetAutoExample());
	}

	@Override
	public TLTBetAutoExample getExample(TLTBetAuto record) {
		TLTBetAutoExample example = new TLTBetAutoExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getAutobetNo()!=null){
				criteria.andAutobetNoEqualTo(record.getAutobetNo());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getLname()!=null){
				criteria.andLnameEqualTo(record.getLname());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getLpgId()!=null){
				criteria.andLpgIdEqualTo(record.getLpgId());
				}
				if(record.getLpId()!=null){
				criteria.andLpIdEqualTo(record.getLpId());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(record.getStartIssue()!=null){
				criteria.andStartIssueEqualTo(record.getStartIssue());
				}
				if(record.getIssueNum()!=null){
				criteria.andIssueNumEqualTo(record.getIssueNum());
				}
				if(record.getTotalBetAmounts()!=null){
				criteria.andTotalBetAmountsEqualTo(record.getTotalBetAmounts());
				}
				if(record.getTotalBetCounts()!=null){
				criteria.andTotalBetCountsEqualTo(record.getTotalBetCounts());
				}
				if(record.getCompleteNum()!=null){
				criteria.andCompleteNumEqualTo(record.getCompleteNum());
				}
				if(record.getCancelNum()!=null){
				criteria.andCancelNumEqualTo(record.getCancelNum());
				}
				if(record.getBetNum()!=null){
				criteria.andBetNumEqualTo(record.getBetNum());
				}
				if(record.getBetData()!=null){
				criteria.andBetDataEqualTo(record.getBetData());
				}
				if(record.getBetCoins()!=null){
				criteria.andBetCoinsEqualTo(record.getBetCoins());
				}
				if(record.getCompleteCoins()!=null){
				criteria.andCompleteCoinsEqualTo(record.getCompleteCoins());
				}
				if(record.getCancelCoins()!=null){
				criteria.andCancelCoinsEqualTo(record.getCancelCoins());
				}
				if(record.getMode()!=null){
				criteria.andModeEqualTo(record.getMode());
				}
				if(record.getTimes()!=null){
				criteria.andTimesEqualTo(record.getTimes());
				}
				if(record.getWinStop()!=null){
				criteria.andWinStopEqualTo(record.getWinStop());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getBetNo()!=null){
				criteria.andBetNoEqualTo(record.getBetNo());
				}

		}
		return example;
	}
	
	public TLTBetAuto selectOneByExample(TLTBetAutoExample example)
			 {
		example.setLimit(1);
		List<TLTBetAuto> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTBetAuto> records) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_BET_AUTO() values");
			int i=0;
			for (TLTBetAuto record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getAutobetNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getAutobetNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
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
			
				sb.append(",");
			
				if(record.getLname()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLname()+"'");
				}
			
				sb.append(",");
			
				if(record.getPlayType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPlayType()+"'");
				}
			
				sb.append(",");
			
				if(record.getLpgId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLpgId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLpId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLpId()+"'");
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
			
				if(record.getStartIssue()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getStartIssue()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNum()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getIssueNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getTotalBetAmounts()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getTotalBetAmounts()+"'");
				}
			
				sb.append(",");
			
				if(record.getTotalBetCounts()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getTotalBetCounts()+"'");
				}
			
				sb.append(",");
			
				if(record.getCompleteNum()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getCompleteNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getCancelNum()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getCancelNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetNum()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getBetNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetData()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBetData()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetCoins()==null){
						sb.append("'"+"0.0000"+"'");						
				}else{
				// java type==Float
						sb.append("'"+record.getBetCoins()+"'");
				}
			
				sb.append(",");
			
				if(record.getCompleteCoins()==null){
						sb.append("'"+"0.0000"+"'");						
				}else{
				// java type==Float
						sb.append("'"+record.getCompleteCoins()+"'");
				}
			
				sb.append(",");
			
				if(record.getCancelCoins()==null){
						sb.append("'"+"0.0000"+"'");						
				}else{
				// java type==Float
						sb.append("'"+record.getCancelCoins()+"'");
				}
			
				sb.append(",");
			
				if(record.getMode()==null){
						sb.append("'"+"1"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getMode()+"'");
				}
			
				sb.append(",");
			
				if(record.getTimes()==null){
						sb.append("'"+"1"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getTimes()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinStop()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getWinStop()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBetNo()+"'");
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
