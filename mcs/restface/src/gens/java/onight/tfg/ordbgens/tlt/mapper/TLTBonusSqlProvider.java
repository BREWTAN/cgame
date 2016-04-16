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
import onight.tfg.ordbgens.tlt.entity.TLTBonus;
import onight.tfg.ordbgens.tlt.entity.TLTBonusExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTBonusExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTBonusExample;

public class TLTBonusSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String countByExample(TLTBonusExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_BONUS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String deleteByExample(TLTBonusExample example) {
        BEGIN();
        DELETE_FROM("TLT_BONUS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String insertSelective(TLTBonus record) {
        BEGIN();
        INSERT_INTO("TLT_BONUS");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBonusgroupId() != null) {
            VALUES("BONUSGROUP_ID", "#{bonusgroupId,jdbcType=BIGINT}");
        }
        
        if (record.getLtype() != null) {
            VALUES("LTYPE", "#{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            VALUES("PLAY_TYPE", "#{playType,jdbcType=VARCHAR}");
        }
        
        if (record.getLpgId() != null) {
            VALUES("LPG_ID", "#{lpgId,jdbcType=BIGINT}");
        }
        
        if (record.getCnName() != null) {
            VALUES("CN_NAME", "#{cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            VALUES("EN_NAME", "#{enName,jdbcType=VARCHAR}");
        }
        
        if (record.getBonus() != null) {
            VALUES("BONUS", "#{bonus,jdbcType=REAL}");
        }
        
        if (record.getBetNum() != null) {
            VALUES("BET_NUM", "#{betNum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalMargin() != null) {
            VALUES("TOTAL_MARGIN", "#{totalMargin,jdbcType=REAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String selectByExample(TLTBonusExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("BONUSGROUP_ID");
        SELECT("LTYPE");
        SELECT("PLAY_TYPE");
        SELECT("LPG_ID");
        SELECT("CN_NAME");
        SELECT("EN_NAME");
        SELECT("BONUS");
        SELECT("BET_NUM");
        SELECT("TOTAL_MARGIN");
        SELECT("STATUS");
        FROM("TLT_BONUS");
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
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTBonus record = (TLTBonus) parameter.get("record");
        TLTBonusExample example = (TLTBonusExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_BONUS");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBonusgroupId() != null) {
            SET("BONUSGROUP_ID = #{record.bonusgroupId,jdbcType=BIGINT}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        }
        
        if (record.getLpgId() != null) {
            SET("LPG_ID = #{record.lpgId,jdbcType=BIGINT}");
        }
        
        if (record.getCnName() != null) {
            SET("CN_NAME = #{record.cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            SET("EN_NAME = #{record.enName,jdbcType=VARCHAR}");
        }
        
        if (record.getBonus() != null) {
            SET("BONUS = #{record.bonus,jdbcType=REAL}");
        }
        
        if (record.getBetNum() != null) {
            SET("BET_NUM = #{record.betNum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalMargin() != null) {
            SET("TOTAL_MARGIN = #{record.totalMargin,jdbcType=REAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_BONUS");
        
        SET("ID = #{record.id,jdbcType=BIGINT}");
        SET("BONUSGROUP_ID = #{record.bonusgroupId,jdbcType=BIGINT}");
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        SET("LPG_ID = #{record.lpgId,jdbcType=BIGINT}");
        SET("CN_NAME = #{record.cnName,jdbcType=VARCHAR}");
        SET("EN_NAME = #{record.enName,jdbcType=VARCHAR}");
        SET("BONUS = #{record.bonus,jdbcType=REAL}");
        SET("BET_NUM = #{record.betNum,jdbcType=INTEGER}");
        SET("TOTAL_MARGIN = #{record.totalMargin,jdbcType=REAL}");
        SET("STATUS = #{record.status,jdbcType=INTEGER}");
        
        TLTBonusExample example = (TLTBonusExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTBonus record) {
        BEGIN();
        UPDATE("TLT_BONUS");
        
        if (record.getBonusgroupId() != null) {
            SET("BONUSGROUP_ID = #{bonusgroupId,jdbcType=BIGINT}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            SET("PLAY_TYPE = #{playType,jdbcType=VARCHAR}");
        }
        
        if (record.getLpgId() != null) {
            SET("LPG_ID = #{lpgId,jdbcType=BIGINT}");
        }
        
        if (record.getCnName() != null) {
            SET("CN_NAME = #{cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            SET("EN_NAME = #{enName,jdbcType=VARCHAR}");
        }
        
        if (record.getBonus() != null) {
            SET("BONUS = #{bonus,jdbcType=REAL}");
        }
        
        if (record.getBetNum() != null) {
            SET("BET_NUM = #{betNum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalMargin() != null) {
            SET("TOTAL_MARGIN = #{totalMargin,jdbcType=REAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=INTEGER}");
        }
        
        WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    protected void applyWhere(TLTBonusExample example, boolean includeExamplePhrase) {
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