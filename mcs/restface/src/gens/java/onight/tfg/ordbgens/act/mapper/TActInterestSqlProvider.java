package onight.tfg.ordbgens.act.mapper;

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
import onight.tfg.ordbgens.act.entity.TActInterest;
import onight.tfg.ordbgens.act.entity.TActInterestExample.Criteria;
import onight.tfg.ordbgens.act.entity.TActInterestExample.Criterion;
import onight.tfg.ordbgens.act.entity.TActInterestExample;

public class TActInterestSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String countByExample(TActInterestExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("T_ACT_INTEREST");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String deleteByExample(TActInterestExample example) {
        BEGIN();
        DELETE_FROM("T_ACT_INTEREST");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String insertSelective(TActInterest record) {
        BEGIN();
        INSERT_INTO("T_ACT_INTEREST");
        
        if (record.getInstLogid() != null) {
            VALUES("INST_LOGID", "#{instLogid,jdbcType=VARCHAR}");
        }
        
        if (record.getInterestDate() != null) {
            VALUES("INTEREST_DATE", "#{interestDate,jdbcType=VARCHAR}");
        }
        
        if (record.getFundNo() != null) {
            VALUES("FUND_NO", "#{fundNo,jdbcType=VARCHAR}");
        }
        
        if (record.getActNo() != null) {
            VALUES("ACT_NO", "#{actNo,jdbcType=VARCHAR}");
        }
        
        if (record.getInterestType() != null) {
            VALUES("INTEREST_TYPE", "#{interestType,jdbcType=VARCHAR}");
        }
        
        if (record.getInterestAmount() != null) {
            VALUES("INTEREST_AMOUNT", "#{interestAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getGmtCreate() != null) {
            VALUES("GMT_CREATE", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            VALUES("GMT_MODIFY", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTradeDate() != null) {
            VALUES("TRADE_DATE", "#{tradeDate,jdbcType=VARCHAR}");
        }
        
        if (record.getRateValue() != null) {
            VALUES("RATE_VALUE", "#{rateValue,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitNo() != null) {
            VALUES("UNIT_NO", "#{unitNo,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String selectByExample(TActInterestExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("INST_LOGID");
        } else {
            SELECT("INST_LOGID");
        }
        SELECT("INTEREST_DATE");
        SELECT("FUND_NO");
        SELECT("ACT_NO");
        SELECT("INTEREST_TYPE");
        SELECT("INTEREST_AMOUNT");
        SELECT("GMT_CREATE");
        SELECT("GMT_MODIFY");
        SELECT("TRADE_DATE");
        SELECT("RATE_VALUE");
        SELECT("UNIT_NO");
        FROM("T_ACT_INTEREST");
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
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TActInterest record = (TActInterest) parameter.get("record");
        TActInterestExample example = (TActInterestExample) parameter.get("example");
        
        BEGIN();
        UPDATE("T_ACT_INTEREST");
        
        if (record.getInstLogid() != null) {
            SET("INST_LOGID = #{record.instLogid,jdbcType=VARCHAR}");
        }
        
        if (record.getInterestDate() != null) {
            SET("INTEREST_DATE = #{record.interestDate,jdbcType=VARCHAR}");
        }
        
        if (record.getFundNo() != null) {
            SET("FUND_NO = #{record.fundNo,jdbcType=VARCHAR}");
        }
        
        if (record.getActNo() != null) {
            SET("ACT_NO = #{record.actNo,jdbcType=VARCHAR}");
        }
        
        if (record.getInterestType() != null) {
            SET("INTEREST_TYPE = #{record.interestType,jdbcType=VARCHAR}");
        }
        
        if (record.getInterestAmount() != null) {
            SET("INTEREST_AMOUNT = #{record.interestAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getGmtCreate() != null) {
            SET("GMT_CREATE = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            SET("GMT_MODIFY = #{record.gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTradeDate() != null) {
            SET("TRADE_DATE = #{record.tradeDate,jdbcType=VARCHAR}");
        }
        
        if (record.getRateValue() != null) {
            SET("RATE_VALUE = #{record.rateValue,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitNo() != null) {
            SET("UNIT_NO = #{record.unitNo,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("T_ACT_INTEREST");
        
        SET("INST_LOGID = #{record.instLogid,jdbcType=VARCHAR}");
        SET("INTEREST_DATE = #{record.interestDate,jdbcType=VARCHAR}");
        SET("FUND_NO = #{record.fundNo,jdbcType=VARCHAR}");
        SET("ACT_NO = #{record.actNo,jdbcType=VARCHAR}");
        SET("INTEREST_TYPE = #{record.interestType,jdbcType=VARCHAR}");
        SET("INTEREST_AMOUNT = #{record.interestAmount,jdbcType=DECIMAL}");
        SET("GMT_CREATE = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        SET("GMT_MODIFY = #{record.gmtModify,jdbcType=TIMESTAMP}");
        SET("TRADE_DATE = #{record.tradeDate,jdbcType=VARCHAR}");
        SET("RATE_VALUE = #{record.rateValue,jdbcType=DECIMAL}");
        SET("UNIT_NO = #{record.unitNo,jdbcType=VARCHAR}");
        
        TActInterestExample example = (TActInterestExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String updateByPrimaryKeySelective(TActInterest record) {
        BEGIN();
        UPDATE("T_ACT_INTEREST");
        
        if (record.getInterestDate() != null) {
            SET("INTEREST_DATE = #{interestDate,jdbcType=VARCHAR}");
        }
        
        if (record.getFundNo() != null) {
            SET("FUND_NO = #{fundNo,jdbcType=VARCHAR}");
        }
        
        if (record.getActNo() != null) {
            SET("ACT_NO = #{actNo,jdbcType=VARCHAR}");
        }
        
        if (record.getInterestType() != null) {
            SET("INTEREST_TYPE = #{interestType,jdbcType=VARCHAR}");
        }
        
        if (record.getInterestAmount() != null) {
            SET("INTEREST_AMOUNT = #{interestAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getGmtCreate() != null) {
            SET("GMT_CREATE = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            SET("GMT_MODIFY = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTradeDate() != null) {
            SET("TRADE_DATE = #{tradeDate,jdbcType=VARCHAR}");
        }
        
        if (record.getRateValue() != null) {
            SET("RATE_VALUE = #{rateValue,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitNo() != null) {
            SET("UNIT_NO = #{unitNo,jdbcType=VARCHAR}");
        }
        
        WHERE("INST_LOGID = #{instLogid,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    protected void applyWhere(TActInterestExample example, boolean includeExamplePhrase) {
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