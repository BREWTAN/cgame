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

import onight.tfg.ordbgens.tlt.entity.TLTIssueHis;
import onight.tfg.ordbgens.tlt.entity.TLTIssueHisExample;
import onight.tfg.ordbgens.tlt.entity.TLTIssueHisExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTIssueHisKey;
import onight.tfg.ordbgens.tlt.mapper.TLTIssueHisMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_ISSUE_HIS")
public class TLTIssueHisDao extends ExtendDaoSupper<TLTIssueHis, TLTIssueHisExample, TLTIssueHisKey>{

	private TLTIssueHisMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTIssueHisExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTIssueHisExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTIssueHisKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTIssueHis record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTIssueHis record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTIssueHis> records) throws Exception
			 {
		for(TLTIssueHis record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTIssueHis> records) throws Exception
			 {
		for(TLTIssueHis record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTIssueHis> selectByExample(TLTIssueHisExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTIssueHis selectByPrimaryKey(TLTIssueHisKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTIssueHis> findAll(List<TLTIssueHis> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTIssueHisExample());
		}
		List<TLTIssueHis> list = new ArrayList();
		for(TLTIssueHis record : records){
			TLTIssueHis result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTIssueHis record, TLTIssueHisExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTIssueHis record, TLTIssueHisExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTIssueHis record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTIssueHis record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTIssueHisExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTIssueHisExample());
	}

	@Override
	public TLTIssueHisExample getExample(TLTIssueHis record) {
		TLTIssueHisExample example = new TLTIssueHisExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getIssueId()!=null){
				criteria.andIssueIdEqualTo(record.getIssueId());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getIssueNo()!=null){
				criteria.andIssueNoEqualTo(record.getIssueNo());
				}
				if(record.getLotteryNo()!=null){
				criteria.andLotteryNoEqualTo(record.getLotteryNo());
				}
				if(record.getIssueDate()!=null){
				criteria.andIssueDateEqualTo(record.getIssueDate());
				}
				if(record.getPreStime()!=null){
				criteria.andPreStimeEqualTo(record.getPreStime());
				}
				if(record.getPreEtime()!=null){
				criteria.andPreEtimeEqualTo(record.getPreEtime());
				}
				if(record.getSaleStime()!=null){
				criteria.andSaleStimeEqualTo(record.getSaleStime());
				}
				if(record.getSaleEtime()!=null){
				criteria.andSaleEtimeEqualTo(record.getSaleEtime());
				}
				if(record.getRealStime()!=null){
				criteria.andRealStimeEqualTo(record.getRealStime());
				}
				if(record.getRealEtime()!=null){
				criteria.andRealEtimeEqualTo(record.getRealEtime());
				}
				if(record.getCancelLtime()!=null){
				criteria.andCancelLtimeEqualTo(record.getCancelLtime());
				}
				if(record.getCloseshareDate()!=null){
				criteria.andCloseshareDateEqualTo(record.getCloseshareDate());
				}
				if(record.getRebateStatus()!=null){
				criteria.andRebateStatusEqualTo(record.getRebateStatus());
				}
				if(record.getWinStatus()!=null){
				criteria.andWinStatusEqualTo(record.getWinStatus());
				}
				if(record.getSendStatus()!=null){
				criteria.andSendStatusEqualTo(record.getSendStatus());
				}
				if(record.getAutobetStatus()!=null){
				criteria.andAutobetStatusEqualTo(record.getAutobetStatus());
				}
				if(record.getLockStatus()!=null){
				criteria.andLockStatusEqualTo(record.getLockStatus());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(record.getModifyTime()!=null){
				criteria.andModifyTimeEqualTo(record.getModifyTime());
				}
				if(record.getIssueStatus()!=null){
				criteria.andIssueStatusEqualTo(record.getIssueStatus());
				}
				if(record.getStatus()!=null){
				criteria.andStatusEqualTo(record.getStatus());
				}
				if(record.getBackupTime()!=null){
				criteria.andBackupTimeEqualTo(record.getBackupTime());
				}

		}
		return example;
	}
	
	public TLTIssueHis selectOneByExample(TLTIssueHisExample example)
			 {
		example.setLimit(1);
		List<TLTIssueHis> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTIssueHis> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_ISSUE_HIS() values");
			int i=0;
			for (TLTIssueHis record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getIssueId()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getIssueId()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueNo()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getIssueNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getLotteryNo()==null){
						sb.append("'"+""+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getLotteryNo()+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueDate()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getIssueDate()+"'");
				}
			
				sb.append(",");
			
				if(record.getPreStime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getPreStime())+"'");
				}
			
				sb.append(",");
			
				if(record.getPreEtime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getPreEtime())+"'");
				}
			
				sb.append(",");
			
				if(record.getSaleStime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getSaleStime())+"'");
				}
			
				sb.append(",");
			
				if(record.getSaleEtime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getSaleEtime())+"'");
				}
			
				sb.append(",");
			
				if(record.getRealStime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getRealStime())+"'");
				}
			
				sb.append(",");
			
				if(record.getRealEtime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getRealEtime())+"'");
				}
			
				sb.append(",");
			
				if(record.getCancelLtime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getCancelLtime())+"'");
				}
			
				sb.append(",");
			
				if(record.getCloseshareDate()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getCloseshareDate())+"'");
				}
			
				sb.append(",");
			
				if(record.getRebateStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getRebateStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getWinStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getSendStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getSendStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getAutobetStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getAutobetStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getLockStatus()+"'");
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
			
				if(record.getModifyTime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getModifyTime())+"'");
				}
			
				sb.append(",");
			
				if(record.getIssueStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getIssueStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getStatus()==null){
						sb.append("'"+"1"+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getBackupTime()==null){
						sb.append("'"+"CURRENT_TIMESTAMP"+"'");						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getBackupTime())+"'");
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
