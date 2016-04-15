package onight.tfg.ordbgens.tfc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import onight.tfg.ordbgens.tfc.entity.TFCUserLockChangeDetail;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockChangeDetailExample;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockChangeDetailExample.Criteria;
import onight.tfg.ordbgens.tfc.entity.TFCUserLockChangeDetailKey;
import onight.tfg.ordbgens.tfc.mapper.TFCUserLockChangeDetailMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TFC_USER_LOCK_CHANGE_DETAIL")
public class TFCUserLockChangeDetailDao extends ExtendDaoSupper<TFCUserLockChangeDetail, TFCUserLockChangeDetailExample, TFCUserLockChangeDetailKey>{

	private TFCUserLockChangeDetailMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TFCUserLockChangeDetailExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFCUserLockChangeDetailExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TFCUserLockChangeDetailKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TFCUserLockChangeDetail record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TFCUserLockChangeDetail record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TFCUserLockChangeDetail> records) throws Exception
			 {
		for(TFCUserLockChangeDetail record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TFCUserLockChangeDetail> records) throws Exception
			 {
		for(TFCUserLockChangeDetail record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TFCUserLockChangeDetail> selectByExample(TFCUserLockChangeDetailExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TFCUserLockChangeDetail selectByPrimaryKey(TFCUserLockChangeDetailKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TFCUserLockChangeDetail> findAll(List<TFCUserLockChangeDetail> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TFCUserLockChangeDetailExample());
		}
		List<TFCUserLockChangeDetail> list = new ArrayList();
		for(TFCUserLockChangeDetail record : records){
			TFCUserLockChangeDetail result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TFCUserLockChangeDetail record, TFCUserLockChangeDetailExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFCUserLockChangeDetail record, TFCUserLockChangeDetailExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFCUserLockChangeDetail record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFCUserLockChangeDetail record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TFCUserLockChangeDetailExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TFCUserLockChangeDetailExample());
	}

	@Override
	public TFCUserLockChangeDetailExample getExample(TFCUserLockChangeDetail record) {
		TFCUserLockChangeDetailExample example = new TFCUserLockChangeDetailExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getRowId()!=null){
				criteria.andRowIdEqualTo(record.getRowId());
				}
				if(record.getCoinTypeId()!=null){
				criteria.andCoinTypeIdEqualTo(record.getCoinTypeId());
				}
				if(record.getRecTime()!=null){
				criteria.andRecTimeEqualTo(record.getRecTime());
				}
				if(record.getLockId()!=null){
				criteria.andLockIdEqualTo(record.getLockId());
				}
				if(record.getUserId()!=null){
				criteria.andUserIdEqualTo(record.getUserId());
				}
				if(record.getChangeNum()!=null){
				criteria.andChangeNumEqualTo(record.getChangeNum());
				}
				if(record.getLockedNum()!=null){
				criteria.andLockedNumEqualTo(record.getLockedNum());
				}
				if(record.getChannelId()!=null){
				criteria.andChannelIdEqualTo(record.getChannelId());
				}
				if(record.getProductId()!=null){
				criteria.andProductIdEqualTo(record.getProductId());
				}
				if(record.getFlowNumber()!=null){
				criteria.andFlowNumberEqualTo(record.getFlowNumber());
				}
				if(record.getUserIp()!=null){
				criteria.andUserIpEqualTo(record.getUserIp());
				}
				if(record.getServerIp()!=null){
				criteria.andServerIpEqualTo(record.getServerIp());
				}
				if(record.getGameId()!=null){
				criteria.andGameIdEqualTo(record.getGameId());
				}

		}
		return example;
	}
	
	public TFCUserLockChangeDetail selectOneByExample(TFCUserLockChangeDetailExample example)
			 {
		example.setLimit(1);
		List<TFCUserLockChangeDetail> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TFCUserLockChangeDetail> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TFC_USER_LOCK_CHANGE_DETAIL(ROW_ID,COIN_TYPE_ID,REC_TIME,LOCK_ID,USER_ID,CHANGE_NUM,LOCKED_NUM,CHANNEL_ID,PRODUCT_ID,FLOW_NUMBER,USER_IP,SERVER_IP,GAME_ID) values");
			int i=0;
			for (TFCUserLockChangeDetail record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getRowId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getRowId()+"'");
				}
			
				sb.append(",");
			
				if(record.getCoinTypeId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getCoinTypeId()+"'");
				}
			
				sb.append(",");
			
				if(record.getRecTime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getRecTime())+"'");
				}
			
				sb.append(",");
			
				if(record.getLockId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLockId()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUserId()+"'");
				}
			
				sb.append(",");
			
				if(record.getChangeNum()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getChangeNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockedNum()==null){
						sb.append("null");
				}else{
				// java type==Long
						sb.append("'"+record.getLockedNum()+"'");
				}
			
				sb.append(",");
			
				if(record.getChannelId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getChannelId()+"'");
				}
			
				sb.append(",");
			
				if(record.getProductId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getProductId()+"'");
				}
			
				sb.append(",");
			
				if(record.getFlowNumber()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getFlowNumber()+"'");
				}
			
				sb.append(",");
			
				if(record.getUserIp()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getUserIp()+"'");
				}
			
				sb.append(",");
			
				if(record.getServerIp()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getServerIp()+"'");
				}
			
				sb.append(",");
			
				if(record.getGameId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getGameId()+"'");
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
