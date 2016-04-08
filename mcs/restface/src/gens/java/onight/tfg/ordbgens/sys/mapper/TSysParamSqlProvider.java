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
import onight.tfg.ordbgens.sys.entity.TSysParam;
import onight.tfg.ordbgens.sys.entity.TSysParamExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysParamExample.Criterion;
import onight.tfg.ordbgens.sys.entity.TSysParamExample;

public class TSysParamSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String countByExample(TSysParamExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("T_SYS_PARAM");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String deleteByExample(TSysParamExample example) {
        BEGIN();
        DELETE_FROM("T_SYS_PARAM");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String insertSelective(TSysParam record) {
        BEGIN();
        INSERT_INTO("T_SYS_PARAM");
        
        if (record.getParamId() != null) {
            VALUES("PARAM_ID", "#{paramId,jdbcType=VARCHAR}");
        }
        
        if (record.getParamType() != null) {
            VALUES("PARAM_TYPE", "#{paramType,jdbcType=VARCHAR}");
        }
        
        if (record.getParamValue() != null) {
            VALUES("PARAM_VALUE", "#{paramValue,jdbcType=VARCHAR}");
        }
        
        if (record.getDsc() != null) {
            VALUES("DSC", "#{dsc,jdbcType=VARCHAR}");
        }
        
        if (record.getCrtTime() != null) {
            VALUES("CRT_TIME", "#{crtTime,jdbcType=VARCHAR}");
        }
        
        if (record.getField1() != null) {
            VALUES("FIELD1", "#{field1,jdbcType=VARCHAR}");
        }
        
        if (record.getField2() != null) {
            VALUES("FIELD2", "#{field2,jdbcType=VARCHAR}");
        }
        
        if (record.getField3() != null) {
            VALUES("FIELD3", "#{field3,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String selectByExample(TSysParamExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PARAM_ID");
        } else {
            SELECT("PARAM_ID");
        }
        SELECT("PARAM_TYPE");
        SELECT("PARAM_VALUE");
        SELECT("DSC");
        SELECT("CRT_TIME");
        SELECT("FIELD1");
        SELECT("FIELD2");
        SELECT("FIELD3");
        FROM("T_SYS_PARAM");
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
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TSysParam record = (TSysParam) parameter.get("record");
        TSysParamExample example = (TSysParamExample) parameter.get("example");
        
        BEGIN();
        UPDATE("T_SYS_PARAM");
        
        if (record.getParamId() != null) {
            SET("PARAM_ID = #{record.paramId,jdbcType=VARCHAR}");
        }
        
        if (record.getParamType() != null) {
            SET("PARAM_TYPE = #{record.paramType,jdbcType=VARCHAR}");
        }
        
        if (record.getParamValue() != null) {
            SET("PARAM_VALUE = #{record.paramValue,jdbcType=VARCHAR}");
        }
        
        if (record.getDsc() != null) {
            SET("DSC = #{record.dsc,jdbcType=VARCHAR}");
        }
        
        if (record.getCrtTime() != null) {
            SET("CRT_TIME = #{record.crtTime,jdbcType=VARCHAR}");
        }
        
        if (record.getField1() != null) {
            SET("FIELD1 = #{record.field1,jdbcType=VARCHAR}");
        }
        
        if (record.getField2() != null) {
            SET("FIELD2 = #{record.field2,jdbcType=VARCHAR}");
        }
        
        if (record.getField3() != null) {
            SET("FIELD3 = #{record.field3,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("T_SYS_PARAM");
        
        SET("PARAM_ID = #{record.paramId,jdbcType=VARCHAR}");
        SET("PARAM_TYPE = #{record.paramType,jdbcType=VARCHAR}");
        SET("PARAM_VALUE = #{record.paramValue,jdbcType=VARCHAR}");
        SET("DSC = #{record.dsc,jdbcType=VARCHAR}");
        SET("CRT_TIME = #{record.crtTime,jdbcType=VARCHAR}");
        SET("FIELD1 = #{record.field1,jdbcType=VARCHAR}");
        SET("FIELD2 = #{record.field2,jdbcType=VARCHAR}");
        SET("FIELD3 = #{record.field3,jdbcType=VARCHAR}");
        
        TSysParamExample example = (TSysParamExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String updateByPrimaryKeySelective(TSysParam record) {
        BEGIN();
        UPDATE("T_SYS_PARAM");
        
        if (record.getParamType() != null) {
            SET("PARAM_TYPE = #{paramType,jdbcType=VARCHAR}");
        }
        
        if (record.getParamValue() != null) {
            SET("PARAM_VALUE = #{paramValue,jdbcType=VARCHAR}");
        }
        
        if (record.getDsc() != null) {
            SET("DSC = #{dsc,jdbcType=VARCHAR}");
        }
        
        if (record.getCrtTime() != null) {
            SET("CRT_TIME = #{crtTime,jdbcType=VARCHAR}");
        }
        
        if (record.getField1() != null) {
            SET("FIELD1 = #{field1,jdbcType=VARCHAR}");
        }
        
        if (record.getField2() != null) {
            SET("FIELD2 = #{field2,jdbcType=VARCHAR}");
        }
        
        if (record.getField3() != null) {
            SET("FIELD3 = #{field3,jdbcType=VARCHAR}");
        }
        
        WHERE("PARAM_ID = #{paramId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    protected void applyWhere(TSysParamExample example, boolean includeExamplePhrase) {
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