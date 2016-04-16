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
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNum;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTLimitedNumExample;

public class TLTLimitedNumSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    public String countByExample(TLTLimitedNumExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_LIMITED_NUM");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    public String deleteByExample(TLTLimitedNumExample example) {
        BEGIN();
        DELETE_FROM("TLT_LIMITED_NUM");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    public String insertSelective(TLTLimitedNum record) {
        BEGIN();
        INSERT_INTO("TLT_LIMITED_NUM");
        
        if (record.getUuid() != null) {
            VALUES("UUID", "#{uuid,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNo() != null) {
            VALUES("ISSUE_NO", "#{issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLimitedNum() != null) {
            VALUES("LIMITED_NUM", "#{limitedNum,jdbcType=VARCHAR}");
        }
        
        if (record.getLtype() != null) {
            VALUES("LTYPE", "#{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            VALUES("PLAY_TYPE", "#{playType,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield1() != null) {
            VALUES("EXTRAFIELD1", "#{extrafield1,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield2() != null) {
            VALUES("EXTRAFIELD2", "#{extrafield2,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield3() != null) {
            VALUES("EXTRAFIELD3", "#{extrafield3,jdbcType=INTEGER}");
        }
        
        if (record.getExtrafield4() != null) {
            VALUES("EXTRAFIELD4", "#{extrafield4,jdbcType=DECIMAL}");
        }
        
        if (record.getExtrafield5() != null) {
            VALUES("EXTRAFIELD5", "#{extrafield5,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    public String selectByExample(TLTLimitedNumExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("UUID");
        } else {
            SELECT("UUID");
        }
        SELECT("ISSUE_NO");
        SELECT("LIMITED_NUM");
        SELECT("LTYPE");
        SELECT("PLAY_TYPE");
        SELECT("EXTRAFIELD1");
        SELECT("EXTRAFIELD2");
        SELECT("EXTRAFIELD3");
        SELECT("EXTRAFIELD4");
        SELECT("EXTRAFIELD5");
        FROM("TLT_LIMITED_NUM");
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
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTLimitedNum record = (TLTLimitedNum) parameter.get("record");
        TLTLimitedNumExample example = (TLTLimitedNumExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_LIMITED_NUM");
        
        if (record.getUuid() != null) {
            SET("UUID = #{record.uuid,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNo() != null) {
            SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLimitedNum() != null) {
            SET("LIMITED_NUM = #{record.limitedNum,jdbcType=VARCHAR}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield1() != null) {
            SET("EXTRAFIELD1 = #{record.extrafield1,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield2() != null) {
            SET("EXTRAFIELD2 = #{record.extrafield2,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield3() != null) {
            SET("EXTRAFIELD3 = #{record.extrafield3,jdbcType=INTEGER}");
        }
        
        if (record.getExtrafield4() != null) {
            SET("EXTRAFIELD4 = #{record.extrafield4,jdbcType=DECIMAL}");
        }
        
        if (record.getExtrafield5() != null) {
            SET("EXTRAFIELD5 = #{record.extrafield5,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_LIMITED_NUM");
        
        SET("UUID = #{record.uuid,jdbcType=VARCHAR}");
        SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        SET("LIMITED_NUM = #{record.limitedNum,jdbcType=VARCHAR}");
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        SET("EXTRAFIELD1 = #{record.extrafield1,jdbcType=VARCHAR}");
        SET("EXTRAFIELD2 = #{record.extrafield2,jdbcType=VARCHAR}");
        SET("EXTRAFIELD3 = #{record.extrafield3,jdbcType=INTEGER}");
        SET("EXTRAFIELD4 = #{record.extrafield4,jdbcType=DECIMAL}");
        SET("EXTRAFIELD5 = #{record.extrafield5,jdbcType=DECIMAL}");
        
        TLTLimitedNumExample example = (TLTLimitedNumExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTLimitedNum record) {
        BEGIN();
        UPDATE("TLT_LIMITED_NUM");
        
        if (record.getIssueNo() != null) {
            SET("ISSUE_NO = #{issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLimitedNum() != null) {
            SET("LIMITED_NUM = #{limitedNum,jdbcType=VARCHAR}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            SET("PLAY_TYPE = #{playType,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield1() != null) {
            SET("EXTRAFIELD1 = #{extrafield1,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield2() != null) {
            SET("EXTRAFIELD2 = #{extrafield2,jdbcType=VARCHAR}");
        }
        
        if (record.getExtrafield3() != null) {
            SET("EXTRAFIELD3 = #{extrafield3,jdbcType=INTEGER}");
        }
        
        if (record.getExtrafield4() != null) {
            SET("EXTRAFIELD4 = #{extrafield4,jdbcType=DECIMAL}");
        }
        
        if (record.getExtrafield5() != null) {
            SET("EXTRAFIELD5 = #{extrafield5,jdbcType=DECIMAL}");
        }
        
        WHERE("UUID = #{uuid,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LIMITED_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:10 CST 2016
     */
    protected void applyWhere(TLTLimitedNumExample example, boolean includeExamplePhrase) {
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