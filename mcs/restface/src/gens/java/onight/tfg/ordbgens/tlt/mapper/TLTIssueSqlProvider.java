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
import onight.tfg.ordbgens.tlt.entity.TLTIssue;
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample;

public class TLTIssueSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String countByExample(TLTIssueExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_ISSUE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String deleteByExample(TLTIssueExample example) {
        BEGIN();
        DELETE_FROM("TLT_ISSUE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String insertSelective(TLTIssue record) {
        BEGIN();
        INSERT_INTO("TLT_ISSUE");
        
        if (record.getIssueId() != null) {
            VALUES("ISSUE_ID", "#{issueId,jdbcType=BIGINT}");
        }
        
        if (record.getLtype() != null) {
            VALUES("LTYPE", "#{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNo() != null) {
            VALUES("ISSUE_NO", "#{issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLotteryNo() != null) {
            VALUES("LOTTERY_NO", "#{lotteryNo,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueDate() != null) {
            VALUES("ISSUE_DATE", "#{issueDate,jdbcType=VARCHAR}");
        }
        
        if (record.getPreStime() != null) {
            VALUES("PRE_STIME", "#{preStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPreEtime() != null) {
            VALUES("PRE_ETIME", "#{preEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSaleStime() != null) {
            VALUES("SALE_STIME", "#{saleStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSaleEtime() != null) {
            VALUES("SALE_ETIME", "#{saleEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRealStime() != null) {
            VALUES("REAL_STIME", "#{realStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRealEtime() != null) {
            VALUES("REAL_ETIME", "#{realEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCancelLtime() != null) {
            VALUES("CANCEL_LTIME", "#{cancelLtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseshareDate() != null) {
            VALUES("CLOSESHARE_DATE", "#{closeshareDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRebateStatus() != null) {
            VALUES("REBATE_STATUS", "#{rebateStatus,jdbcType=INTEGER}");
        }
        
        if (record.getWinStatus() != null) {
            VALUES("WIN_STATUS", "#{winStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSendStatus() != null) {
            VALUES("SEND_STATUS", "#{sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAutobetStatus() != null) {
            VALUES("AUTOBET_STATUS", "#{autobetStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLockStatus() != null) {
            VALUES("LOCK_STATUS", "#{lockStatus,jdbcType=INTEGER}");
        }
        
        if (record.getProcessStatus() != null) {
            VALUES("PROCESS_STATUS", "#{processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            VALUES("MODIFY_TIME", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String selectByExample(TLTIssueExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ISSUE_ID");
        } else {
            SELECT("ISSUE_ID");
        }
        SELECT("LTYPE");
        SELECT("ISSUE_NO");
        SELECT("LOTTERY_NO");
        SELECT("ISSUE_DATE");
        SELECT("PRE_STIME");
        SELECT("PRE_ETIME");
        SELECT("SALE_STIME");
        SELECT("SALE_ETIME");
        SELECT("REAL_STIME");
        SELECT("REAL_ETIME");
        SELECT("CANCEL_LTIME");
        SELECT("CLOSESHARE_DATE");
        SELECT("REBATE_STATUS");
        SELECT("WIN_STATUS");
        SELECT("SEND_STATUS");
        SELECT("AUTOBET_STATUS");
        SELECT("LOCK_STATUS");
        SELECT("PROCESS_STATUS");
        SELECT("CREATE_TIME");
        SELECT("MODIFY_TIME");
        SELECT("STATUS");
        FROM("TLT_ISSUE");
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
     * This method corresponds to the database table TLT_ISSUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTIssue record = (TLTIssue) parameter.get("record");
        TLTIssueExample example = (TLTIssueExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_ISSUE");
        
        if (record.getIssueId() != null) {
            SET("ISSUE_ID = #{record.issueId,jdbcType=BIGINT}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNo() != null) {
            SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLotteryNo() != null) {
            SET("LOTTERY_NO = #{record.lotteryNo,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueDate() != null) {
            SET("ISSUE_DATE = #{record.issueDate,jdbcType=VARCHAR}");
        }
        
        if (record.getPreStime() != null) {
            SET("PRE_STIME = #{record.preStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPreEtime() != null) {
            SET("PRE_ETIME = #{record.preEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSaleStime() != null) {
            SET("SALE_STIME = #{record.saleStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSaleEtime() != null) {
            SET("SALE_ETIME = #{record.saleEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRealStime() != null) {
            SET("REAL_STIME = #{record.realStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRealEtime() != null) {
            SET("REAL_ETIME = #{record.realEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCancelLtime() != null) {
            SET("CANCEL_LTIME = #{record.cancelLtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseshareDate() != null) {
            SET("CLOSESHARE_DATE = #{record.closeshareDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRebateStatus() != null) {
            SET("REBATE_STATUS = #{record.rebateStatus,jdbcType=INTEGER}");
        }
        
        if (record.getWinStatus() != null) {
            SET("WIN_STATUS = #{record.winStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSendStatus() != null) {
            SET("SEND_STATUS = #{record.sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAutobetStatus() != null) {
            SET("AUTOBET_STATUS = #{record.autobetStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLockStatus() != null) {
            SET("LOCK_STATUS = #{record.lockStatus,jdbcType=INTEGER}");
        }
        
        if (record.getProcessStatus() != null) {
            SET("PROCESS_STATUS = #{record.processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("MODIFY_TIME = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_ISSUE");
        
        SET("ISSUE_ID = #{record.issueId,jdbcType=BIGINT}");
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        SET("LOTTERY_NO = #{record.lotteryNo,jdbcType=VARCHAR}");
        SET("ISSUE_DATE = #{record.issueDate,jdbcType=VARCHAR}");
        SET("PRE_STIME = #{record.preStime,jdbcType=TIMESTAMP}");
        SET("PRE_ETIME = #{record.preEtime,jdbcType=TIMESTAMP}");
        SET("SALE_STIME = #{record.saleStime,jdbcType=TIMESTAMP}");
        SET("SALE_ETIME = #{record.saleEtime,jdbcType=TIMESTAMP}");
        SET("REAL_STIME = #{record.realStime,jdbcType=TIMESTAMP}");
        SET("REAL_ETIME = #{record.realEtime,jdbcType=TIMESTAMP}");
        SET("CANCEL_LTIME = #{record.cancelLtime,jdbcType=TIMESTAMP}");
        SET("CLOSESHARE_DATE = #{record.closeshareDate,jdbcType=TIMESTAMP}");
        SET("REBATE_STATUS = #{record.rebateStatus,jdbcType=INTEGER}");
        SET("WIN_STATUS = #{record.winStatus,jdbcType=INTEGER}");
        SET("SEND_STATUS = #{record.sendStatus,jdbcType=INTEGER}");
        SET("AUTOBET_STATUS = #{record.autobetStatus,jdbcType=INTEGER}");
        SET("LOCK_STATUS = #{record.lockStatus,jdbcType=INTEGER}");
        SET("PROCESS_STATUS = #{record.processStatus,jdbcType=INTEGER}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("MODIFY_TIME = #{record.modifyTime,jdbcType=TIMESTAMP}");
        SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        
        TLTIssueExample example = (TLTIssueExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTIssue record) {
        BEGIN();
        UPDATE("TLT_ISSUE");
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNo() != null) {
            SET("ISSUE_NO = #{issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLotteryNo() != null) {
            SET("LOTTERY_NO = #{lotteryNo,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueDate() != null) {
            SET("ISSUE_DATE = #{issueDate,jdbcType=VARCHAR}");
        }
        
        if (record.getPreStime() != null) {
            SET("PRE_STIME = #{preStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPreEtime() != null) {
            SET("PRE_ETIME = #{preEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSaleStime() != null) {
            SET("SALE_STIME = #{saleStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSaleEtime() != null) {
            SET("SALE_ETIME = #{saleEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRealStime() != null) {
            SET("REAL_STIME = #{realStime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRealEtime() != null) {
            SET("REAL_ETIME = #{realEtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCancelLtime() != null) {
            SET("CANCEL_LTIME = #{cancelLtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseshareDate() != null) {
            SET("CLOSESHARE_DATE = #{closeshareDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRebateStatus() != null) {
            SET("REBATE_STATUS = #{rebateStatus,jdbcType=INTEGER}");
        }
        
        if (record.getWinStatus() != null) {
            SET("WIN_STATUS = #{winStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSendStatus() != null) {
            SET("SEND_STATUS = #{sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAutobetStatus() != null) {
            SET("AUTOBET_STATUS = #{autobetStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLockStatus() != null) {
            SET("LOCK_STATUS = #{lockStatus,jdbcType=INTEGER}");
        }
        
        if (record.getProcessStatus() != null) {
            SET("PROCESS_STATUS = #{processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=VARCHAR}");
        }
        
        WHERE("ISSUE_ID = #{issueId,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    protected void applyWhere(TLTIssueExample example, boolean includeExamplePhrase) {
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