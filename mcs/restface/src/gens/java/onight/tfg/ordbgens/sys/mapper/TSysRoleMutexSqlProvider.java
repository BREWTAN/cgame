package onight.tfg.ordbgens.sys.mapper;

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
import onight.tfg.ordbgens.sys.entity.TSysRoleMutex;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutexExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutexExample.Criterion;
import onight.tfg.ordbgens.sys.entity.TSysRoleMutexExample;

public class TSysRoleMutexSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String countByExample(TSysRoleMutexExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("T_SYS_ROLE_MUTEX");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String deleteByExample(TSysRoleMutexExample example) {
        BEGIN();
        DELETE_FROM("T_SYS_ROLE_MUTEX");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String insertSelective(TSysRoleMutex record) {
        BEGIN();
        INSERT_INTO("T_SYS_ROLE_MUTEX");
        
        if (record.getRoleMutexId() != null) {
            VALUES("ROLE_MUTEX_ID", "#{roleMutexId,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleIdA() != null) {
            VALUES("ROLE_ID_A", "#{roleIdA,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleIdB() != null) {
            VALUES("ROLE_ID_B", "#{roleIdB,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String selectByExample(TSysRoleMutexExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ROLE_MUTEX_ID");
        } else {
            SELECT("ROLE_MUTEX_ID");
        }
        SELECT("ROLE_ID_A");
        SELECT("ROLE_ID_B");
        SELECT("STATUS");
        FROM("T_SYS_ROLE_MUTEX");
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
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TSysRoleMutex record = (TSysRoleMutex) parameter.get("record");
        TSysRoleMutexExample example = (TSysRoleMutexExample) parameter.get("example");
        
        BEGIN();
        UPDATE("T_SYS_ROLE_MUTEX");
        
        if (record.getRoleMutexId() != null) {
            SET("ROLE_MUTEX_ID = #{record.roleMutexId,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleIdA() != null) {
            SET("ROLE_ID_A = #{record.roleIdA,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleIdB() != null) {
            SET("ROLE_ID_B = #{record.roleIdB,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("T_SYS_ROLE_MUTEX");
        
        SET("ROLE_MUTEX_ID = #{record.roleMutexId,jdbcType=VARCHAR}");
        SET("ROLE_ID_A = #{record.roleIdA,jdbcType=VARCHAR}");
        SET("ROLE_ID_B = #{record.roleIdB,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=INTEGER}");
        
        TSysRoleMutexExample example = (TSysRoleMutexExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String updateByPrimaryKeySelective(TSysRoleMutex record) {
        BEGIN();
        UPDATE("T_SYS_ROLE_MUTEX");
        
        if (record.getRoleIdA() != null) {
            SET("ROLE_ID_A = #{roleIdA,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleIdB() != null) {
            SET("ROLE_ID_B = #{roleIdB,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=INTEGER}");
        }
        
        WHERE("ROLE_MUTEX_ID = #{roleMutexId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MUTEX
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    protected void applyWhere(TSysRoleMutexExample example, boolean includeExamplePhrase) {
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