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
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsHis;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsHisExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsHisExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsHisExample;

public class TLTIssueStepsHisSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS_HIS
     *
     * @mbggenerated Sun Apr 10 15:45:55 CST 2016
     */
    public String countByExample(TLTIssueStepsHisExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_ISSUE_STEPS_HIS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS_HIS
     *
     * @mbggenerated Sun Apr 10 15:45:55 CST 2016
     */
    public String deleteByExample(TLTIssueStepsHisExample example) {
        BEGIN();
        DELETE_FROM("TLT_ISSUE_STEPS_HIS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS_HIS
     *
     * @mbggenerated Sun Apr 10 15:45:55 CST 2016
     */
    public String insertSelective(TLTIssueStepsHis record) {
        BEGIN();
        INSERT_INTO("TLT_ISSUE_STEPS_HIS");
        
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
        
        if (record.getGsName() != null) {
            VALUES("GS_NAME", "#{gsName,jdbcType=VARCHAR}");
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
        
        if (record.getRefParamGenId() != null) {
            VALUES("REF_PARAM_GEN_ID", "#{refParamGenId,jdbcType=BIGINT}");
        }
        
        if (record.getAutoGonext() != null) {
            VALUES("AUTO_GONEXT", "#{autoGonext,jdbcType=VARCHAR}");
        }
        
        if (record.getBackupTime() != null) {
            VALUES("BACKUP_TIME", "#{backupTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS_HIS
     *
     * @mbggenerated Sun Apr 10 15:45:55 CST 2016
     */
    public String selectByExample(TLTIssueStepsHisExample example) {
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
        SELECT("GS_NAME");
        SELECT("TIMESEC_OFFSET");
        SELECT("GS_ORDER");
        SELECT("NEXT_ORDERS");
        SELECT("REF_PARAM_GEN_ID");
        SELECT("AUTO_GONEXT");
        SELECT("BACKUP_TIME");
        FROM("TLT_ISSUE_STEPS_HIS");
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
     * This method corresponds to the database table TLT_ISSUE_STEPS_HIS
     *
     * @mbggenerated Sun Apr 10 15:45:55 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTIssueStepsHis record = (TLTIssueStepsHis) parameter.get("record");
        TLTIssueStepsHisExample example = (TLTIssueStepsHisExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_ISSUE_STEPS_HIS");
        
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
        
        if (record.getGsName() != null) {
            SET("GS_NAME = #{record.gsName,jdbcType=VARCHAR}");
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
        
        if (record.getRefParamGenId() != null) {
            SET("REF_PARAM_GEN_ID = #{record.refParamGenId,jdbcType=BIGINT}");
        }
        
        if (record.getAutoGonext() != null) {
            SET("AUTO_GONEXT = #{record.autoGonext,jdbcType=VARCHAR}");
        }
        
        if (record.getBackupTime() != null) {
            SET("BACKUP_TIME = #{record.backupTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS_HIS
     *
     * @mbggenerated Sun Apr 10 15:45:55 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_ISSUE_STEPS_HIS");
        
        SET("ISSUE_STEP_ID = #{record.issueStepId,jdbcType=VARCHAR}");
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        SET("STEP_STATUS = #{record.stepStatus,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("MODIFY_TIME = #{record.modifyTime,jdbcType=TIMESTAMP}");
        SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        SET("GS_ECODE = #{record.gsEcode,jdbcType=VARCHAR}");
        SET("GS_NAME = #{record.gsName,jdbcType=VARCHAR}");
        SET("TIMESEC_OFFSET = #{record.timesecOffset,jdbcType=INTEGER}");
        SET("GS_ORDER = #{record.gsOrder,jdbcType=VARCHAR}");
        SET("NEXT_ORDERS = #{record.nextOrders,jdbcType=VARCHAR}");
        SET("REF_PARAM_GEN_ID = #{record.refParamGenId,jdbcType=BIGINT}");
        SET("AUTO_GONEXT = #{record.autoGonext,jdbcType=VARCHAR}");
        SET("BACKUP_TIME = #{record.backupTime,jdbcType=TIMESTAMP}");
        
        TLTIssueStepsHisExample example = (TLTIssueStepsHisExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS_HIS
     *
     * @mbggenerated Sun Apr 10 15:45:55 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTIssueStepsHis record) {
        BEGIN();
        UPDATE("TLT_ISSUE_STEPS_HIS");
        
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
        
        if (record.getGsName() != null) {
            SET("GS_NAME = #{gsName,jdbcType=VARCHAR}");
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
        
        if (record.getRefParamGenId() != null) {
            SET("REF_PARAM_GEN_ID = #{refParamGenId,jdbcType=BIGINT}");
        }
        
        if (record.getAutoGonext() != null) {
            SET("AUTO_GONEXT = #{autoGonext,jdbcType=VARCHAR}");
        }
        
        if (record.getBackupTime() != null) {
            SET("BACKUP_TIME = #{backupTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ISSUE_STEP_ID = #{issueStepId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS_HIS
     *
     * @mbggenerated Sun Apr 10 15:45:55 CST 2016
     */
    protected void applyWhere(TLTIssueStepsHisExample example, boolean includeExamplePhrase) {
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