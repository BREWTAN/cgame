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

import onight.tfg.ordbgens.tlt.entity.TLTCoreWin;
import onight.tfg.ordbgens.tlt.entity.TLTCoreWinExample;
import onight.tfg.ordbgens.tlt.entity.TLTCoreWinExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTCoreWinKey;
import onight.tfg.ordbgens.tlt.mapper.TLTCoreWinMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_CORE_WIN")
public class TLTCoreWinDao extends ExtendDaoSupper<TLTCoreWin, TLTCoreWinExample, TLTCoreWinKey>{

	private TLTCoreWinMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTCoreWinExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTCoreWinExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTCoreWinKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTCoreWin record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTCoreWin record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTCoreWin> records) throws Exception
			 {
		for(TLTCoreWin record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTCoreWin> records) throws Exception
			 {
		for(TLTCoreWin record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTCoreWin> selectByExample(TLTCoreWinExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTCoreWin selectByPrimaryKey(TLTCoreWinKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTCoreWin> findAll(List<TLTCoreWin> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTCoreWinExample());
		}
		List<TLTCoreWin> list = new ArrayList();
		for(TLTCoreWin record : records){
			TLTCoreWin result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTCoreWin record, TLTCoreWinExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTCoreWin record, TLTCoreWinExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTCoreWin record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTCoreWin record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTCoreWinExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTCoreWinExample());
	}

	@Override
	public TLTCoreWinExample getExample(TLTCoreWin record) {
		TLTCoreWinExample example = new TLTCoreWinExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getWinNo()!=null){
				criteria.andWinNoEqualTo(record.getWinNo());
				}
				if(record.getTickNo()!=null){
				criteria.andTickNoEqualTo(record.getTickNo());
				}
				if(record.getBetNo()!=null){
				criteria.andBetNoEqualTo(record.getBetNo());
				}
				if(record.getMerchantid()!=null){
				criteria.andMerchantidEqualTo(record.getMerchantid());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getIssueNo()!=null){
				criteria.andIssueNoEqualTo(record.getIssueNo());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getWinType()!=null){
				criteria.andWinTypeEqualTo(record.getWinType());
				}
				if(record.getWinLevel()!=null){
				criteria.andWinLevelEqualTo(record.getWinLevel());
				}
				if(record.getWinPattern()!=null){
				criteria.andWinPatternEqualTo(record.getWinPattern());
				}
				if(record.getWinNum()!=null){
				criteria.andWinNumEqualTo(record.getWinNum());
				}
				if(record.getLevelBonusAmount()!=null){
				criteria.andLevelBonusAmountEqualTo(record.getLevelBonusAmount());
				}
				if(record.getAwardMoney()!=null){
				criteria.andAwardMoneyEqualTo(record.getAwardMoney());
				}
				if(record.getBonusMoney()!=null){
				criteria.andBonusMoneyEqualTo(record.getBonusMoney());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getSumDivisionType()!=null){
				criteria.andSumDivisionTypeEqualTo(record.getSumDivisionType());
				}
				if(record.getCreateDate()!=null){
				criteria.andCreateDateEqualTo(record.getCreateDate());
				}
				if(record.getModifyDate()!=null){
				criteria.andModifyDateEqualTo(record.getModifyDate());
				}
				if(record.getFundReturnAmount()!=null){
				criteria.andFundReturnAmountEqualTo(record.getFundReturnAmount());
				}
				if(record.getFundRefIdReturn()!=null){
				criteria.andFundRefIdReturnEqualTo(record.getFundRefIdReturn());
				}
				if(record.getFundRefIdCancel()!=null){
				criteria.andFundRefIdCancelEqualTo(record.getFundRefIdCancel());
				}
				if(record.getFundReturnDate()!=null){
				criteria.andFundReturnDateEqualTo(record.getFundReturnDate());
				}
				if(record.getFundReturnStatus()!=null){
				criteria.andFundReturnStatusEqualTo(record.getFundReturnStatus());
				}
				if(record.getFundCancelDate()!=null){
				criteria.andFundCancelDateEqualTo(record.getFundCancelDate());
				}
				if(record.getSerialNum()!=null){
				criteria.andSerialNumEqualTo(record.getSerialNum());
				}

		}
		return example;
	}
	
	public TLTCoreWin selectOneByExample(TLTCoreWinExample example)
			 {
		example.setLimit(1);
		List<TLTCoreWin> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTCoreWin> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_CORE_WIN(WIN_NO,TICK_NO,BET_NO,MERCHANTID,USER_ID,ISSUE_NO,LTYPE,PLAY_TYPE,WIN_TYPE,WIN_LEVEL,WIN_PATTERN,WIN_NUM,LEVEL_BONUS_AMOUNT,AWARD_MONEY,BONUS_MONEY,STATUS,SUM_DIVISION_TYPE,CREATE_DATE,MODIFY_DATE,FUND_RETURN_AMOUNT,FUND_REF_ID_RETURN,FUND_REF_ID_CANCEL,FUND_RETURN_DATE,FUND_RETURN_STATUS,FUND_CANCEL_DATE,SERIAL_NUM) values");
			int i=0;
			for (TLTCoreWin record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getWinNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getWinNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getTickNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTickNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getBetNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBetNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getMerchantid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMerchantid()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNo()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getIssueNo()+"'");
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
			
				if(record.getWinType()==null){
//						sb.append("'"+"1"+"'");
						sb.append("'"+"1"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getWinType()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinLevel()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getWinLevel()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinPattern()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getWinPattern()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinNum()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getWinNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getLevelBonusAmount()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getLevelBonusAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getAwardMoney()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getAwardMoney()+"'");
				}
			
				sb.append(",");
			
				if(record.getBonusMoney()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getBonusMoney()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
//						sb.append("'"+"1"+"'");
						sb.append("'"+"1"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getSumDivisionType()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getSumDivisionType()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreateDate()==null){
//						sb.append("'"+"CURRENT_TIMESTAMP"+"'");
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(new java.util.Date())+"'");
						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getCreateDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getModifyDate()==null){
//						sb.append("'"+"CURRENT_TIMESTAMP"+"'");
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(new java.util.Date())+"'");
						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getModifyDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getFundReturnAmount()==null){
//						sb.append("'"+"0.000000"+"'");
						sb.append("'"+"0.000000"+"'");
						
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getFundReturnAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundRefIdReturn()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFundRefIdReturn()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundRefIdCancel()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFundRefIdCancel()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundReturnDate()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getFundReturnDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getFundReturnStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFundReturnStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getFundCancelDate()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getFundCancelDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getSerialNum()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getSerialNum()+"'");
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
