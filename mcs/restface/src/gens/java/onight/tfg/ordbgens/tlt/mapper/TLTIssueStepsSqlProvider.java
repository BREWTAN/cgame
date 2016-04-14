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
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample;

public class TLTIssueStepsSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public String countByExample(TLTIssueStepsExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_ISSUE_STEPS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public String deleteByExample(TLTIssueStepsExample example) {
        BEGIN();
        DELETE_FROM("TLT_ISSUE_STEPS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public String insertSelective(TLTIssueSteps record) {
        BEGIN();
        INSERT_INTO("TLT_ISSUE_STEPS");
        
        if (record.getIssueStepId() != null) {
            VALUES("ISSUE_STEP_ID", "#{issueStepId,jdbcType=VARCHAR}");
        }
        
        if (record.getLtype() != null) {
            VALUES("LTYPE", "#{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNo() != null) {
            VALUES("ISSUE_NO", "#{issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStepStatus() != null) {
            VALUES("STEP_STATUS", "#{stepStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            VALUES("MODIFY_TIME", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperatorId() != null) {
            VALUES("OPERATOR_ID", "#{operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getGsEcode() != null) {
            VALUES("GS_ECODE", "#{gsEcode,jdbcType=VARCHAR}");
        }
        
        if (record.getGsChcode() != null) {
            VALUES("GS_CHCODE", "#{gsChcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTimesecOffset() != null) {
            VALUES("TIMESEC_OFFSET", "#{timesecOffset,jdbcType=INTEGER}");
        }
        
        if (record.getGsOrder() != null) {
            VALUES("GS_ORDER", "#{gsOrder,jdbcType=VARCHAR}");
        }
        
        if (record.getNextOrders() != null) {
            VALUES("NEXT_ORDERS", "#{nextOrders,jdbcType=VARCHAR}");
        }
        
        if (record.getWaitOrders() != null) {
            VALUES("WAIT_ORDERS", "#{waitOrders,jdbcType=VARCHAR}");
        }
        
        if (record.getNodeType() != null) {
            VALUES("NODE_TYPE", "#{nodeType,jdbcType=VARCHAR}");
        }
        
        if (record.getRefParamGenId() != null) {
            VALUES("REF_PARAM_GEN_ID", "#{refParamGenId,jdbcType=BIGINT}");
        }
        
        if (record.getAutoGonext() != null) {
            VALUES("AUTO_GONEXT", "#{autoGonext,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryTimes() != null) {
            VALUES("RETRY_TIMES", "#{retryTimes,jdbcType=INTEGER}");
        }
        
        if (record.getFailedReason() != null) {
            VALUES("FAILED_REASON", "#{failedReason,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public String selectByExample(TLTIssueStepsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ISSUE_STEP_ID");
        } else {
            SELECT("ISSUE_STEP_ID");
        }
        SELECT("LTYPE");
        SELECT("ISSUE_NO");
        SELECT("STEP_STATUS");
        SELECT("CREATE_TIME");
        SELECT("MODIFY_TIME");
        SELECT("OPERATOR_ID");
        SELECT("GS_ECODE");
        SELECT("GS_CHCODE");
        SELECT("TIMESEC_OFFSET");
        SELECT("GS_ORDER");
        SELECT("NEXT_ORDERS");
        SELECT("WAIT_ORDERS");
        SELECT("NODE_TYPE");
        SELECT("REF_PARAM_GEN_ID");
        SELECT("AUTO_GONEXT");
        SELECT("RETRY_TIMES");
        SELECT("FAILED_REASON");
        FROM("TLT_ISSUE_STEPS");
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
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTIssueSteps record = (TLTIssueSteps) parameter.get("record");
        TLTIssueStepsExample example = (TLTIssueStepsExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_ISSUE_STEPS");
        
        if (record.getIssueStepId() != null) {
            SET("ISSUE_STEP_ID = #{record.issueStepId,jdbcType=VARCHAR}");
        }
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNo() != null) {
            SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStepStatus() != null) {
            SET("STEP_STATUS = #{record.stepStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("MODIFY_TIME = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperatorId() != null) {
            SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getGsEcode() != null) {
            SET("GS_ECODE = #{record.gsEcode,jdbcType=VARCHAR}");
        }
        
        if (record.getGsChcode() != null) {
            SET("GS_CHCODE = #{record.gsChcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTimesecOffset() != null) {
            SET("TIMESEC_OFFSET = #{record.timesecOffset,jdbcType=INTEGER}");
        }
        
        if (record.getGsOrder() != null) {
            SET("GS_ORDER = #{record.gsOrder,jdbcType=VARCHAR}");
        }
        
        if (record.getNextOrders() != null) {
            SET("NEXT_ORDERS = #{record.nextOrders,jdbcType=VARCHAR}");
        }
        
        if (record.getWaitOrders() != null) {
            SET("WAIT_ORDERS = #{record.waitOrders,jdbcType=VARCHAR}");
        }
        
        if (record.getNodeType() != null) {
            SET("NODE_TYPE = #{record.nodeType,jdbcType=VARCHAR}");
        }
        
        if (record.getRefParamGenId() != null) {
            SET("REF_PARAM_GEN_ID = #{record.refParamGenId,jdbcType=BIGINT}");
        }
        
        if (record.getAutoGonext() != null) {
            SET("AUTO_GONEXT = #{record.autoGonext,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryTimes() != null) {
            SET("RETRY_TIMES = #{record.retryTimes,jdbcType=INTEGER}");
        }
        
        if (record.getFailedReason() != null) {
            SET("FAILED_REASON = #{record.failedReason,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_ISSUE_STEPS");
        
        SET("ISSUE_STEP_ID = #{record.issueStepId,jdbcType=VARCHAR}");
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        SET("STEP_STATUS = #{record.stepStatus,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("MODIFY_TIME = #{record.modifyTime,jdbcType=TIMESTAMP}");
        SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        SET("GS_ECODE = #{record.gsEcode,jdbcType=VARCHAR}");
        SET("GS_CHCODE = #{record.gsChcode,jdbcType=VARCHAR}");
        SET("TIMESEC_OFFSET = #{record.timesecOffset,jdbcType=INTEGER}");
        SET("GS_ORDER = #{record.gsOrder,jdbcType=VARCHAR}");
        SET("NEXT_ORDERS = #{record.nextOrders,jdbcType=VARCHAR}");
        SET("WAIT_ORDERS = #{record.waitOrders,jdbcType=VARCHAR}");
        SET("NODE_TYPE = #{record.nodeType,jdbcType=VARCHAR}");
        SET("REF_PARAM_GEN_ID = #{record.refParamGenId,jdbcType=BIGINT}");
        SET("AUTO_GONEXT = #{record.autoGonext,jdbcType=VARCHAR}");
        SET("RETRY_TIMES = #{record.retryTimes,jdbcType=INTEGER}");
        SET("FAILED_REASON = #{record.failedReason,jdbcType=VARCHAR}");
        
        TLTIssueStepsExample example = (TLTIssueStepsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTIssueSteps record) {
        BEGIN();
        UPDATE("TLT_ISSUE_STEPS");
        
        if (record.getLtype() != null) {
            SET("LTYPE = #{ltype,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueNo() != null) {
            SET("ISSUE_NO = #{issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStepStatus() != null) {
            SET("STEP_STATUS = #{stepStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperatorId() != null) {
            SET("OPERATOR_ID = #{operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getGsEcode() != null) {
            SET("GS_ECODE = #{gsEcode,jdbcType=VARCHAR}");
        }
        
        if (record.getGsChcode() != null) {
            SET("GS_CHCODE = #{gsChcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTimesecOffset() != null) {
            SET("TIMESEC_OFFSET = #{timesecOffset,jdbcType=INTEGER}");
        }
        
        if (record.getGsOrder() != null) {
            SET("GS_ORDER = #{gsOrder,jdbcType=VARCHAR}");
        }
        
        if (record.getNextOrders() != null) {
            SET("NEXT_ORDERS = #{nextOrders,jdbcType=VARCHAR}");
        }
        
        if (record.getWaitOrders() != null) {
            SET("WAIT_ORDERS = #{waitOrders,jdbcType=VARCHAR}");
        }
        
        if (record.getNodeType() != null) {
            SET("NODE_TYPE = #{nodeType,jdbcType=VARCHAR}");
        }
        
        if (record.getRefParamGenId() != null) {
            SET("REF_PARAM_GEN_ID = #{refParamGenId,jdbcType=BIGINT}");
        }
        
        if (record.getAutoGonext() != null) {
            SET("AUTO_GONEXT = #{autoGonext,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryTimes() != null) {
            SET("RETRY_TIMES = #{retryTimes,jdbcType=INTEGER}");
        }
        
        if (record.getFailedReason() != null) {
            SET("FAILED_REASON = #{failedReason,jdbcType=VARCHAR}");
        }
        
        WHERE("ISSUE_STEP_ID = #{issueStepId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    protected void applyWhere(TLTIssueStepsExample example, boolean includeExamplePhrase) {
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