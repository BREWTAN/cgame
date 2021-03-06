package onight.tfg.ordbgens.tfg.mapper;

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
import onight.tfg.ordbgens.tfg.entity.TFGGroup;
import onight.tfg.ordbgens.tfg.entity.TFGGroupExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGGroupExample.Criterion;
import onight.tfg.ordbgens.tfg.entity.TFGGroupExample;

public class TFGGroupSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String countByExample(TFGGroupExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TFG_GROUP");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String deleteByExample(TFGGroupExample example) {
        BEGIN();
        DELETE_FROM("TFG_GROUP");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String insertSelective(TFGGroup record) {
        BEGIN();
        INSERT_INTO("TFG_GROUP");
        
        if (record.getGroupId() != null) {
            VALUES("GROUP_ID", "#{groupId,jdbcType=VARCHAR}");
        }
        
        if (record.getParentGroupId() != null) {
            VALUES("PARENT_GROUP_ID", "#{parentGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupName() != null) {
            VALUES("GROUP_NAME", "#{groupName,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDesc() != null) {
            VALUES("GROUP_DESC", "#{groupDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String selectByExample(TFGGroupExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("GROUP_ID");
        } else {
            SELECT("GROUP_ID");
        }
        SELECT("PARENT_GROUP_ID");
        SELECT("GROUP_NAME");
        SELECT("GROUP_DESC");
        SELECT("STATUS");
        FROM("TFG_GROUP");
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
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TFGGroup record = (TFGGroup) parameter.get("record");
        TFGGroupExample example = (TFGGroupExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TFG_GROUP");
        
        if (record.getGroupId() != null) {
            SET("GROUP_ID = #{record.groupId,jdbcType=VARCHAR}");
        }
        
        if (record.getParentGroupId() != null) {
            SET("PARENT_GROUP_ID = #{record.parentGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupName() != null) {
            SET("GROUP_NAME = #{record.groupName,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDesc() != null) {
            SET("GROUP_DESC = #{record.groupDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TFG_GROUP");
        
        SET("GROUP_ID = #{record.groupId,jdbcType=VARCHAR}");
        SET("PARENT_GROUP_ID = #{record.parentGroupId,jdbcType=VARCHAR}");
        SET("GROUP_NAME = #{record.groupName,jdbcType=VARCHAR}");
        SET("GROUP_DESC = #{record.groupDesc,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        
        TFGGroupExample example = (TFGGroupExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByPrimaryKeySelective(TFGGroup record) {
        BEGIN();
        UPDATE("TFG_GROUP");
        
        if (record.getParentGroupId() != null) {
            SET("PARENT_GROUP_ID = #{parentGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupName() != null) {
            SET("GROUP_NAME = #{groupName,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupDesc() != null) {
            SET("GROUP_DESC = #{groupDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=VARCHAR}");
        }
        
        WHERE("GROUP_ID = #{groupId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    protected void applyWhere(TFGGroupExample example, boolean includeExamplePhrase) {
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