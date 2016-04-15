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

import onight.tfg.ordbgens.tlt.entity.TLTPlayType;
import onight.tfg.ordbgens.tlt.entity.TLTPlayTypeExample;
import onight.tfg.ordbgens.tlt.entity.TLTPlayTypeExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTPlayTypeKey;
import onight.tfg.ordbgens.tlt.mapper.TLTPlayTypeMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;


@Data
@Tab(name="TLT_PLAY_TYPE")
public class TLTPlayTypeDao extends ExtendDaoSupper<TLTPlayType, TLTPlayTypeExample, TLTPlayTypeKey>{

	private TLTPlayTypeMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(TLTPlayTypeExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TLTPlayTypeExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TLTPlayTypeKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TLTPlayType record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TLTPlayType record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<TLTPlayType> records) throws Exception
			 {
		for(TLTPlayType record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<TLTPlayType> records) throws Exception
			 {
		for(TLTPlayType record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<TLTPlayType> selectByExample(TLTPlayTypeExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public TLTPlayType selectByPrimaryKey(TLTPlayTypeKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<TLTPlayType> findAll(List<TLTPlayType> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new TLTPlayTypeExample());
		}
		List<TLTPlayType> list = new ArrayList();
		for(TLTPlayType record : records){
			TLTPlayType result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(TLTPlayType record, TLTPlayTypeExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TLTPlayType record, TLTPlayTypeExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TLTPlayType record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TLTPlayType record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(TLTPlayTypeExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new TLTPlayTypeExample());
	}

	@Override
	public TLTPlayTypeExample getExample(TLTPlayType record) {
		TLTPlayTypeExample example = new TLTPlayTypeExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getPlayType()!=null){
				criteria.andPlayTypeEqualTo(record.getPlayType());
				}
				if(record.getLtype()!=null){
				criteria.andLtypeEqualTo(record.getLtype());
				}
				if(record.getGroupType()!=null){
				criteria.andGroupTypeEqualTo(record.getGroupType());
				}
				if(record.getLpgId()!=null){
				criteria.andLpgIdEqualTo(record.getLpgId());
				}
				if(record.getCnName()!=null){
				criteria.andCnNameEqualTo(record.getCnName());
				}
				if(record.getEnName()!=null){
				criteria.andEnNameEqualTo(record.getEnName());
				}
				if(record.getLockFunc()!=null){
				criteria.andLockFuncEqualTo(record.getLockFunc());
				}
				if(record.getLockTable()!=null){
				criteria.andLockTableEqualTo(record.getLockTable());
				}
				if(record.getLockStatus()!=null){
				criteria.andLockStatusEqualTo(record.getLockStatus());
				}
				if(record.getModeYjfl()!=null){
				criteria.andModeYjflEqualTo(record.getModeYjfl());
				}
				if(record.getIsandvalue()!=null){
				criteria.andIsandvalueEqualTo(record.getIsandvalue());
				}
				if(record.getMaxBuyCodenum()!=null){
				criteria.andMaxBuyCodenumEqualTo(record.getMaxBuyCodenum());
				}
				if(record.getWinFunc()!=null){
				criteria.andWinFuncEqualTo(record.getWinFunc());
				}
				if(record.getWinBeginpos()!=null){
				criteria.andWinBeginposEqualTo(record.getWinBeginpos());
				}
				if(record.getWinCodenum()!=null){
				criteria.andWinCodenumEqualTo(record.getWinCodenum());
				}
				if(record.getWinDiscontinuouspos()!=null){
				criteria.andWinDiscontinuousposEqualTo(record.getWinDiscontinuouspos());
				}
				if(record.getWinCheckfunc()!=null){
				criteria.andWinCheckfuncEqualTo(record.getWinCheckfunc());
				}
				if(record.getWinPaybonusfunc()!=null){
				criteria.andWinPaybonusfuncEqualTo(record.getWinPaybonusfunc());
				}
				if(record.getEnable()!=null){
				criteria.andEnableEqualTo(record.getEnable());
				}
				if(record.getRemark()!=null){
				criteria.andRemarkEqualTo(record.getRemark());
				}

		}
		return example;
	}
	
	public TLTPlayType selectOneByExample(TLTPlayTypeExample example)
			 {
		example.setLimit(1);
		List<TLTPlayType> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<TLTPlayType> records) throws Exception {
		if(records.size()<=0)return 0;
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		Statement st = null;
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO TLT_PLAY_TYPE(PLAY_TYPE,LTYPE,GROUP_TYPE,LPG_ID,CN_NAME,EN_NAME,LOCK_FUNC,LOCK_TABLE,LOCK_STATUS,MODE_YJFL,ISANDVALUE,MAX_BUY_CODENUM,WIN_FUNC,WIN_BEGINPOS,WIN_CODENUM,WIN_DISCONTINUOUSPOS,WIN_CHECKFUNC,WIN_PAYBONUSFUNC,ENABLE,REMARK) values");
			int i=0;
			for (TLTPlayType record : records) {
				if(i>0){
					sb.append(",");
				}
				i++;
				
			
				sb.append("(");
			
				if(record.getPlayType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPlayType()+"'");
				}
			
				sb.append(",");
			
				if(record.getLtype()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLtype()+"'");
				}
			
				sb.append(",");
			
				if(record.getGroupType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getGroupType()+"'");
				}
			
				sb.append(",");
			
				if(record.getLpgId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLpgId()+"'");
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
			
				if(record.getLockFunc()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLockFunc()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockTable()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLockTable()+"'");
				}
			
				sb.append(",");
			
				if(record.getLockStatus()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getLockStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getModeYjfl()==null){
						sb.append("'"+"1,2,3,4"+"'");						
				}else{
				// java type==String
						sb.append("'"+record.getModeYjfl()+"'");
				}
			
				sb.append(",");
			
				if(record.getIsandvalue()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getIsandvalue()+"'");
				}
			
				sb.append(",");
			
				if(record.getMaxBuyCodenum()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getMaxBuyCodenum()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinFunc()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getWinFunc()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinBeginpos()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getWinBeginpos()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinCodenum()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getWinCodenum()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinDiscontinuouspos()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getWinDiscontinuouspos()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinCheckfunc()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getWinCheckfunc()+"'");
				}
			
				sb.append(",");
			
				if(record.getWinPaybonusfunc()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getWinPaybonusfunc()+"'");
				}
			
				sb.append(",");
			
				if(record.getEnable()==null){
						sb.append("'"+"0"+"'");						
				}else{
				// java type==Integer
						sb.append("'"+record.getEnable()+"'");
				}
			
				sb.append(",");
			
				if(record.getRemark()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getRemark()+"'");
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
