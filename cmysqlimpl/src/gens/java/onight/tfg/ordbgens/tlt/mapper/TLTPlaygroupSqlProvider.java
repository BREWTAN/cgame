package onight.tfg.ordbgens.tlt.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroup;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroupExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroupExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTPlaygroupExample;

public class TLTPlaygroupSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String countByExample(TLTPlaygroupExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_PLAYGROUP");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String deleteByExample(TLTPlaygroupExample example) {
        BEGIN();
        DELETE_FROM("TLT_PLAYGROUP");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String insertSelective(TLTPlaygroup record) {
        BEGIN();
        INSERT_INTO("TLT_PLAYGROUP");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getLtype() != null) {
            VALUES("LTYPE", "#{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            VALUES("PLAY_TYPE", "#{playType,jdbcType=VARCHAR}");
        }
        
        if (record.getCnName() != null) {
            VALUES("CN_NAME", "#{cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            VALUES("EN_NAME", "#{enName,jdbcType=VARCHAR}");
        }
        
        if (record.getLockTable() != null) {
            VALUES("LOCK_TABLE", "#{lockTable,jdbcType=VARCHAR}");
        }
        
        if (record.getAwardLevel() != null) {
            VALUES("AWARD_LEVEL", "#{awardLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCost() != null) {
            VALUES("COST", "#{cost,jdbcType=REAL}");
        }
        
        if (record.getEnable() != null) {
            VALUES("ENABLE", "#{enable,jdbcType=BIT}");
        }
        
        if (record.getRemark() != null) {
            VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getRebate() != null) {
            VALUES("REBATE", "#{rebate,jdbcType=REAL}");
        }
        
        if (record.getDeloRebate() != null) {
            VALUES("DELO_REBATE", "#{deloRebate,jdbcType=REAL}");
        }
        
        if (record.getViewgroup() != null) {
            VALUES("VIEWGROUP", "#{viewgroup,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String selectByExample(TLTPlaygroupExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("LTYPE");
        SELECT("PLAY_TYPE");
        SELECT("CN_NAME");
        SELECT("EN_NAME");
        SELECT("LOCK_TABLE");
        SELECT("AWARD_LEVEL");
        SELECT("COST");
        SELECT("ENABLE");
        SELECT("REMARK");
        SELECT("REBATE");
        SELECT("DELO_REBATE");
        SELECT("VIEWGROUP");
        FROM("TLT_PLAYGROUP");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        if(example!=null&&example.getSelectCols()!=null&&example.getSelectCols().trim().length()>0){
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT(example.getSelectCols());
		} else {
				SELECT(example.getSelectCols());
		}
				applyWhere(example, false);
		}
        if(example != null){
            String retstr= SQL().concat(" limit "+example.getOffset()+","+example.getLimit());
            if(example.isForUpdate()) { return retstr+"  FOR UPDATE " ;} else { return retstr;}
        }
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTPlaygroup record = (TLTPlaygroup) parameter.get("record");
        TLTPlaygroupExample example = (TLTPlaygroupExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_PLAYGROUP");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        }
        
        if (record.getCnName() != null) {
            SET("CN_NAME = #{record.cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            SET("EN_NAME = #{record.enName,jdbcType=VARCHAR}");
        }
        
        if (record.getLockTable() != null) {
            SET("LOCK_TABLE = #{record.lockTable,jdbcType=VARCHAR}");
        }
        
        if (record.getAwardLevel() != null) {
            SET("AWARD_LEVEL = #{record.awardLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCost() != null) {
            SET("COST = #{record.cost,jdbcType=REAL}");
        }
        
        if (record.getEnable() != null) {
            SET("ENABLE = #{record.enable,jdbcType=BIT}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getRebate() != null) {
            SET("REBATE = #{record.rebate,jdbcType=REAL}");
        }
        
        if (record.getDeloRebate() != null) {
            SET("DELO_REBATE = #{record.deloRebate,jdbcType=REAL}");
        }
        
        if (record.getViewgroup() != null) {
            SET("VIEWGROUP = #{record.viewgroup,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_PLAYGROUP");
        
        SET("ID = #{record.id,jdbcType=BIGINT}");
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        SET("CN_NAME = #{record.cnName,jdbcType=VARCHAR}");
        SET("EN_NAME = #{record.enName,jdbcType=VARCHAR}");
        SET("LOCK_TABLE = #{record.lockTable,jdbcType=VARCHAR}");
        SET("AWARD_LEVEL = #{record.awardLevel,jdbcType=INTEGER}");
        SET("COST = #{record.cost,jdbcType=REAL}");
        SET("ENABLE = #{record.enable,jdbcType=BIT}");
        SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        SET("REBATE = #{record.rebate,jdbcType=REAL}");
        SET("DELO_REBATE = #{record.deloRebate,jdbcType=REAL}");
        SET("VIEWGROUP = #{record.viewgroup,jdbcType=VARCHAR}");
        
        TLTPlaygroupExample example = (TLTPlaygroupExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTPlaygroup record) {
        BEGIN();
        UPDATE("TLT_PLAYGROUP");
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            SET("PLAY_TYPE = #{playType,jdbcType=VARCHAR}");
        }
        
        if (record.getCnName() != null) {
            SET("CN_NAME = #{cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            SET("EN_NAME = #{enName,jdbcType=VARCHAR}");
        }
        
        if (record.getLockTable() != null) {
            SET("LOCK_TABLE = #{lockTable,jdbcType=VARCHAR}");
        }
        
        if (record.getAwardLevel() != null) {
            SET("AWARD_LEVEL = #{awardLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCost() != null) {
            SET("COST = #{cost,jdbcType=REAL}");
        }
        
        if (record.getEnable() != null) {
            SET("ENABLE = #{enable,jdbcType=BIT}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getRebate() != null) {
            SET("REBATE = #{rebate,jdbcType=REAL}");
        }
        
        if (record.getDeloRebate() != null) {
            SET("DELO_REBATE = #{deloRebate,jdbcType=REAL}");
        }
        
        if (record.getViewgroup() != null) {
            SET("VIEWGROUP = #{viewgroup,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    protected void applyWhere(TLTPlaygroupExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}