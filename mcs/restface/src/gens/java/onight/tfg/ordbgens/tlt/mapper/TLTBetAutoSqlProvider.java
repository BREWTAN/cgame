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
import onight.tfg.ordbgens.tlt.entity.TLTBetAuto;
import onight.tfg.ordbgens.tlt.entity.TLTBetAutoExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTBetAutoExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTBetAutoExample;

public class TLTBetAutoSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 12:52:28 CST 2016
     */
    public String countByExample(TLTBetAutoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_BET_AUTO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 12:52:28 CST 2016
     */
    public String deleteByExample(TLTBetAutoExample example) {
        BEGIN();
        DELETE_FROM("TLT_BET_AUTO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 12:52:28 CST 2016
     */
    public String insertSelective(TLTBetAuto record) {
        BEGIN();
        INSERT_INTO("TLT_BET_AUTO");
        
        if (record.getAutobetNo() != null) {
            VALUES("AUTOBET_NO", "#{autobetNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            VALUES("USER_ID", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getLtype() != null) {
            VALUES("LTYPE", "#{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getLname() != null) {
            VALUES("LNAME", "#{lname,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            VALUES("PLAY_TYPE", "#{playType,jdbcType=VARCHAR}");
        }
        
        if (record.getLpgId() != null) {
            VALUES("LPG_ID", "#{lpgId,jdbcType=VARCHAR}");
        }
        
        if (record.getLpId() != null) {
            VALUES("LP_ID", "#{lpId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartIssue() != null) {
            VALUES("START_ISSUE", "#{startIssue,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNum() != null) {
            VALUES("ISSUE_NUM", "#{issueNum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalTickAmounts() != null) {
            VALUES("TOTAL_TICK_AMOUNTS", "#{totalTickAmounts,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalTickCounts() != null) {
            VALUES("TOTAL_TICK_COUNTS", "#{totalTickCounts,jdbcType=DECIMAL}");
        }
        
        if (record.getCompleteNum() != null) {
            VALUES("COMPLETE_NUM", "#{completeNum,jdbcType=INTEGER}");
        }
        
        if (record.getCancelNum() != null) {
            VALUES("CANCEL_NUM", "#{cancelNum,jdbcType=INTEGER}");
        }
        
        if (record.getBetData() != null) {
            VALUES("BET_DATA", "#{betData,jdbcType=VARCHAR}");
        }
        
        if (record.getCompleteCoins() != null) {
            VALUES("COMPLETE_COINS", "#{completeCoins,jdbcType=REAL}");
        }
        
        if (record.getCancelCoins() != null) {
            VALUES("CANCEL_COINS", "#{cancelCoins,jdbcType=REAL}");
        }
        
        if (record.getMode() != null) {
            VALUES("MODE", "#{mode,jdbcType=INTEGER}");
        }
        
        if (record.getTimes() != null) {
            VALUES("TIMES", "#{times,jdbcType=INTEGER}");
        }
        
        if (record.getWinStop() != null) {
            VALUES("WIN_STOP", "#{winStop,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getTickNo() != null) {
            VALUES("TICK_NO", "#{tickNo,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 12:52:28 CST 2016
     */
    public String selectByExample(TLTBetAutoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("AUTOBET_NO");
        } else {
            SELECT("AUTOBET_NO");
        }
        SELECT("USER_ID");
        SELECT("LTYPE");
        SELECT("LNAME");
        SELECT("PLAY_TYPE");
        SELECT("LPG_ID");
        SELECT("LP_ID");
        SELECT("CREATE_TIME");
        SELECT("START_ISSUE");
        SELECT("ISSUE_NUM");
        SELECT("TOTAL_TICK_AMOUNTS");
        SELECT("TOTAL_TICK_COUNTS");
        SELECT("COMPLETE_NUM");
        SELECT("CANCEL_NUM");
        SELECT("BET_DATA");
        SELECT("COMPLETE_COINS");
        SELECT("CANCEL_COINS");
        SELECT("MODE");
        SELECT("TIMES");
        SELECT("WIN_STOP");
        SELECT("STATUS");
        SELECT("TICK_NO");
        FROM("TLT_BET_AUTO");
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
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 12:52:28 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTBetAuto record = (TLTBetAuto) parameter.get("record");
        TLTBetAutoExample example = (TLTBetAutoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_BET_AUTO");
        
        if (record.getAutobetNo() != null) {
            SET("AUTOBET_NO = #{record.autobetNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getLname() != null) {
            SET("LNAME = #{record.lname,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        }
        
        if (record.getLpgId() != null) {
            SET("LPG_ID = #{record.lpgId,jdbcType=VARCHAR}");
        }
        
        if (record.getLpId() != null) {
            SET("LP_ID = #{record.lpId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartIssue() != null) {
            SET("START_ISSUE = #{record.startIssue,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNum() != null) {
            SET("ISSUE_NUM = #{record.issueNum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalTickAmounts() != null) {
            SET("TOTAL_TICK_AMOUNTS = #{record.totalTickAmounts,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalTickCounts() != null) {
            SET("TOTAL_TICK_COUNTS = #{record.totalTickCounts,jdbcType=DECIMAL}");
        }
        
        if (record.getCompleteNum() != null) {
            SET("COMPLETE_NUM = #{record.completeNum,jdbcType=INTEGER}");
        }
        
        if (record.getCancelNum() != null) {
            SET("CANCEL_NUM = #{record.cancelNum,jdbcType=INTEGER}");
        }
        
        if (record.getBetData() != null) {
            SET("BET_DATA = #{record.betData,jdbcType=VARCHAR}");
        }
        
        if (record.getCompleteCoins() != null) {
            SET("COMPLETE_COINS = #{record.completeCoins,jdbcType=REAL}");
        }
        
        if (record.getCancelCoins() != null) {
            SET("CANCEL_COINS = #{record.cancelCoins,jdbcType=REAL}");
        }
        
        if (record.getMode() != null) {
            SET("MODE = #{record.mode,jdbcType=INTEGER}");
        }
        
        if (record.getTimes() != null) {
            SET("TIMES = #{record.times,jdbcType=INTEGER}");
        }
        
        if (record.getWinStop() != null) {
            SET("WIN_STOP = #{record.winStop,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getTickNo() != null) {
            SET("TICK_NO = #{record.tickNo,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 12:52:28 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_BET_AUTO");
        
        SET("AUTOBET_NO = #{record.autobetNo,jdbcType=VARCHAR}");
        SET("USER_ID = #{record.userId,jdbcType=VARCHAR}");
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("LNAME = #{record.lname,jdbcType=VARCHAR}");
        SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        SET("LPG_ID = #{record.lpgId,jdbcType=VARCHAR}");
        SET("LP_ID = #{record.lpId,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("START_ISSUE = #{record.startIssue,jdbcType=VARCHAR}");
        SET("ISSUE_NUM = #{record.issueNum,jdbcType=INTEGER}");
        SET("TOTAL_TICK_AMOUNTS = #{record.totalTickAmounts,jdbcType=DECIMAL}");
        SET("TOTAL_TICK_COUNTS = #{record.totalTickCounts,jdbcType=DECIMAL}");
        SET("COMPLETE_NUM = #{record.completeNum,jdbcType=INTEGER}");
        SET("CANCEL_NUM = #{record.cancelNum,jdbcType=INTEGER}");
        SET("BET_DATA = #{record.betData,jdbcType=VARCHAR}");
        SET("COMPLETE_COINS = #{record.completeCoins,jdbcType=REAL}");
        SET("CANCEL_COINS = #{record.cancelCoins,jdbcType=REAL}");
        SET("MODE = #{record.mode,jdbcType=INTEGER}");
        SET("TIMES = #{record.times,jdbcType=INTEGER}");
        SET("WIN_STOP = #{record.winStop,jdbcType=INTEGER}");
        SET("STATUS = #{record.status,jdbcType=INTEGER}");
        SET("TICK_NO = #{record.tickNo,jdbcType=VARCHAR}");
        
        TLTBetAutoExample example = (TLTBetAutoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 12:52:28 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTBetAuto record) {
        BEGIN();
        UPDATE("TLT_BET_AUTO");
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getLname() != null) {
            SET("LNAME = #{lname,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayType() != null) {
            SET("PLAY_TYPE = #{playType,jdbcType=VARCHAR}");
        }
        
        if (record.getLpgId() != null) {
            SET("LPG_ID = #{lpgId,jdbcType=VARCHAR}");
        }
        
        if (record.getLpId() != null) {
            SET("LP_ID = #{lpId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartIssue() != null) {
            SET("START_ISSUE = #{startIssue,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNum() != null) {
            SET("ISSUE_NUM = #{issueNum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalTickAmounts() != null) {
            SET("TOTAL_TICK_AMOUNTS = #{totalTickAmounts,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalTickCounts() != null) {
            SET("TOTAL_TICK_COUNTS = #{totalTickCounts,jdbcType=DECIMAL}");
        }
        
        if (record.getCompleteNum() != null) {
            SET("COMPLETE_NUM = #{completeNum,jdbcType=INTEGER}");
        }
        
        if (record.getCancelNum() != null) {
            SET("CANCEL_NUM = #{cancelNum,jdbcType=INTEGER}");
        }
        
        if (record.getBetData() != null) {
            SET("BET_DATA = #{betData,jdbcType=VARCHAR}");
        }
        
        if (record.getCompleteCoins() != null) {
            SET("COMPLETE_COINS = #{completeCoins,jdbcType=REAL}");
        }
        
        if (record.getCancelCoins() != null) {
            SET("CANCEL_COINS = #{cancelCoins,jdbcType=REAL}");
        }
        
        if (record.getMode() != null) {
            SET("MODE = #{mode,jdbcType=INTEGER}");
        }
        
        if (record.getTimes() != null) {
            SET("TIMES = #{times,jdbcType=INTEGER}");
        }
        
        if (record.getWinStop() != null) {
            SET("WIN_STOP = #{winStop,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getTickNo() != null) {
            SET("TICK_NO = #{tickNo,jdbcType=VARCHAR}");
        }
        
        WHERE("AUTOBET_NO = #{autobetNo,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 12:52:28 CST 2016
     */
    protected void applyWhere(TLTBetAutoExample example, boolean includeExamplePhrase) {
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