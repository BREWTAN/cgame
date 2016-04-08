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
import onight.tfg.ordbgens.tlt.entity.TLTLtype;
import onight.tfg.ordbgens.tlt.entity.TLTLtypeExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTLtypeExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTLtypeExample;

public class TLTLtypeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String countByExample(TLTLtypeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_LTYPE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String deleteByExample(TLTLtypeExample example) {
        BEGIN();
        DELETE_FROM("TLT_LTYPE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String insertSelective(TLTLtype record) {
        BEGIN();
        INSERT_INTO("TLT_LTYPE");
        
        if (record.getLtype() != null) {
            VALUES("LTYPE", "#{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupType() != null) {
            VALUES("GROUP_TYPE", "#{groupType,jdbcType=VARCHAR}");
        }
        
        if (record.getCnName() != null) {
            VALUES("CN_NAME", "#{cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            VALUES("EN_NAME", "#{enName,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeList() != null) {
            VALUES("CODE_LIST", "#{codeList,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeLen() != null) {
            VALUES("CODE_LEN", "#{codeLen,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            VALUES("SORT", "#{sort,jdbcType=TINYINT}");
        }
        
        if (record.getEnable() != null) {
            VALUES("ENABLE", "#{enable,jdbcType=BIT}");
        }
        
        if (record.getRemark() != null) {
            VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getDelayTime() != null) {
            VALUES("DELAY_TIME", "#{delayTime,jdbcType=INTEGER}");
        }
        
        if (record.getCatchCodeCount() != null) {
            VALUES("CATCH_CODE_COUNT", "#{catchCodeCount,jdbcType=INTEGER}");
        }
        
        if (record.getCatchCodeInterval() != null) {
            VALUES("CATCH_CODE_INTERVAL", "#{catchCodeInterval,jdbcType=INTEGER}");
        }
        
        if (record.getMinLeft() != null) {
            VALUES("MIN_LEFT", "#{minLeft,jdbcType=REAL}");
        }
        
        if (record.getMinSpread() != null) {
            VALUES("MIN_SPREAD", "#{minSpread,jdbcType=REAL}");
        }
        
        if (record.getIssueNoFmt() != null) {
            VALUES("ISSUE_NO_FMT", "#{issueNoFmt,jdbcType=VARCHAR}");
        }
        
        if (record.getClearYmd() != null) {
            VALUES("CLEAR_YMD", "#{clearYmd,jdbcType=VARCHAR}");
        }
        
        if (record.getLotteryCycle() != null) {
            VALUES("LOTTERY_CYCLE", "#{lotteryCycle,jdbcType=VARCHAR}");
        }
        
        if (record.getCloseStime() != null) {
            VALUES("CLOSE_STIME", "#{closeStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseEtime() != null) {
            VALUES("CLOSE_ETIME", "#{closeEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRebate() != null) {
            VALUES("REBATE", "#{rebate,jdbcType=REAL}");
        }
        
        if (record.getDeloRebate() != null) {
            VALUES("DELO_REBATE", "#{deloRebate,jdbcType=REAL}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String selectByExample(TLTLtypeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("LTYPE");
        } else {
            SELECT("LTYPE");
        }
        SELECT("GROUP_TYPE");
        SELECT("CN_NAME");
        SELECT("EN_NAME");
        SELECT("CODE_LIST");
        SELECT("CODE_LEN");
        SELECT("SORT");
        SELECT("ENABLE");
        SELECT("REMARK");
        SELECT("DELAY_TIME");
        SELECT("CATCH_CODE_COUNT");
        SELECT("CATCH_CODE_INTERVAL");
        SELECT("MIN_LEFT");
        SELECT("MIN_SPREAD");
        SELECT("ISSUE_NO_FMT");
        SELECT("CLEAR_YMD");
        SELECT("LOTTERY_CYCLE");
        SELECT("CLOSE_STIME");
        SELECT("CLOSE_ETIME");
        SELECT("REBATE");
        SELECT("DELO_REBATE");
        FROM("TLT_LTYPE");
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
            return SQL().concat(" limit "+example.getOffset()+","+example.getLimit());
        }
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTLtype record = (TLTLtype) parameter.get("record");
        TLTLtypeExample example = (TLTLtypeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_LTYPE");
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupType() != null) {
            SET("GROUP_TYPE = #{record.groupType,jdbcType=VARCHAR}");
        }
        
        if (record.getCnName() != null) {
            SET("CN_NAME = #{record.cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            SET("EN_NAME = #{record.enName,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeList() != null) {
            SET("CODE_LIST = #{record.codeList,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeLen() != null) {
            SET("CODE_LEN = #{record.codeLen,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            SET("SORT = #{record.sort,jdbcType=TINYINT}");
        }
        
        if (record.getEnable() != null) {
            SET("ENABLE = #{record.enable,jdbcType=BIT}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getDelayTime() != null) {
            SET("DELAY_TIME = #{record.delayTime,jdbcType=INTEGER}");
        }
        
        if (record.getCatchCodeCount() != null) {
            SET("CATCH_CODE_COUNT = #{record.catchCodeCount,jdbcType=INTEGER}");
        }
        
        if (record.getCatchCodeInterval() != null) {
            SET("CATCH_CODE_INTERVAL = #{record.catchCodeInterval,jdbcType=INTEGER}");
        }
        
        if (record.getMinLeft() != null) {
            SET("MIN_LEFT = #{record.minLeft,jdbcType=REAL}");
        }
        
        if (record.getMinSpread() != null) {
            SET("MIN_SPREAD = #{record.minSpread,jdbcType=REAL}");
        }
        
        if (record.getIssueNoFmt() != null) {
            SET("ISSUE_NO_FMT = #{record.issueNoFmt,jdbcType=VARCHAR}");
        }
        
        if (record.getClearYmd() != null) {
            SET("CLEAR_YMD = #{record.clearYmd,jdbcType=VARCHAR}");
        }
        
        if (record.getLotteryCycle() != null) {
            SET("LOTTERY_CYCLE = #{record.lotteryCycle,jdbcType=VARCHAR}");
        }
        
        if (record.getCloseStime() != null) {
            SET("CLOSE_STIME = #{record.closeStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseEtime() != null) {
            SET("CLOSE_ETIME = #{record.closeEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRebate() != null) {
            SET("REBATE = #{record.rebate,jdbcType=REAL}");
        }
        
        if (record.getDeloRebate() != null) {
            SET("DELO_REBATE = #{record.deloRebate,jdbcType=REAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_LTYPE");
        
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("GROUP_TYPE = #{record.groupType,jdbcType=VARCHAR}");
        SET("CN_NAME = #{record.cnName,jdbcType=VARCHAR}");
        SET("EN_NAME = #{record.enName,jdbcType=VARCHAR}");
        SET("CODE_LIST = #{record.codeList,jdbcType=VARCHAR}");
        SET("CODE_LEN = #{record.codeLen,jdbcType=INTEGER}");
        SET("SORT = #{record.sort,jdbcType=TINYINT}");
        SET("ENABLE = #{record.enable,jdbcType=BIT}");
        SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        SET("DELAY_TIME = #{record.delayTime,jdbcType=INTEGER}");
        SET("CATCH_CODE_COUNT = #{record.catchCodeCount,jdbcType=INTEGER}");
        SET("CATCH_CODE_INTERVAL = #{record.catchCodeInterval,jdbcType=INTEGER}");
        SET("MIN_LEFT = #{record.minLeft,jdbcType=REAL}");
        SET("MIN_SPREAD = #{record.minSpread,jdbcType=REAL}");
        SET("ISSUE_NO_FMT = #{record.issueNoFmt,jdbcType=VARCHAR}");
        SET("CLEAR_YMD = #{record.clearYmd,jdbcType=VARCHAR}");
        SET("LOTTERY_CYCLE = #{record.lotteryCycle,jdbcType=VARCHAR}");
        SET("CLOSE_STIME = #{record.closeStime,jdbcType=TIMESTAMP}");
        SET("CLOSE_ETIME = #{record.closeEtime,jdbcType=TIMESTAMP}");
        SET("REBATE = #{record.rebate,jdbcType=REAL}");
        SET("DELO_REBATE = #{record.deloRebate,jdbcType=REAL}");
        
        TLTLtypeExample example = (TLTLtypeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTLtype record) {
        BEGIN();
        UPDATE("TLT_LTYPE");
        
        if (record.getGroupType() != null) {
            SET("GROUP_TYPE = #{groupType,jdbcType=VARCHAR}");
        }
        
        if (record.getCnName() != null) {
            SET("CN_NAME = #{cnName,jdbcType=VARCHAR}");
        }
        
        if (record.getEnName() != null) {
            SET("EN_NAME = #{enName,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeList() != null) {
            SET("CODE_LIST = #{codeList,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeLen() != null) {
            SET("CODE_LEN = #{codeLen,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            SET("SORT = #{sort,jdbcType=TINYINT}");
        }
        
        if (record.getEnable() != null) {
            SET("ENABLE = #{enable,jdbcType=BIT}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getDelayTime() != null) {
            SET("DELAY_TIME = #{delayTime,jdbcType=INTEGER}");
        }
        
        if (record.getCatchCodeCount() != null) {
            SET("CATCH_CODE_COUNT = #{catchCodeCount,jdbcType=INTEGER}");
        }
        
        if (record.getCatchCodeInterval() != null) {
            SET("CATCH_CODE_INTERVAL = #{catchCodeInterval,jdbcType=INTEGER}");
        }
        
        if (record.getMinLeft() != null) {
            SET("MIN_LEFT = #{minLeft,jdbcType=REAL}");
        }
        
        if (record.getMinSpread() != null) {
            SET("MIN_SPREAD = #{minSpread,jdbcType=REAL}");
        }
        
        if (record.getIssueNoFmt() != null) {
            SET("ISSUE_NO_FMT = #{issueNoFmt,jdbcType=VARCHAR}");
        }
        
        if (record.getClearYmd() != null) {
            SET("CLEAR_YMD = #{clearYmd,jdbcType=VARCHAR}");
        }
        
        if (record.getLotteryCycle() != null) {
            SET("LOTTERY_CYCLE = #{lotteryCycle,jdbcType=VARCHAR}");
        }
        
        if (record.getCloseStime() != null) {
            SET("CLOSE_STIME = #{closeStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseEtime() != null) {
            SET("CLOSE_ETIME = #{closeEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRebate() != null) {
            SET("REBATE = #{rebate,jdbcType=REAL}");
        }
        
        if (record.getDeloRebate() != null) {
            SET("DELO_REBATE = #{deloRebate,jdbcType=REAL}");
        }
        
        WHERE("LTYPE = #{ltype,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    protected void applyWhere(TLTLtypeExample example, boolean includeExamplePhrase) {
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