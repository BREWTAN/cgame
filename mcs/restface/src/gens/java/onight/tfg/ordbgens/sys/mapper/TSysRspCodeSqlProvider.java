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
import onight.tfg.ordbgens.sys.entity.TSysRspCode;
import onight.tfg.ordbgens.sys.entity.TSysRspCodeExample.Criteria;
import onight.tfg.ordbgens.sys.entity.TSysRspCodeExample.Criterion;
import onight.tfg.ordbgens.sys.entity.TSysRspCodeExample;

public class TSysRspCodeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public String countByExample(TSysRspCodeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("T_SYS_RSP_CODE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public String deleteByExample(TSysRspCodeExample example) {
        BEGIN();
        DELETE_FROM("T_SYS_RSP_CODE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public String insertSelective(TSysRspCode record) {
        BEGIN();
        INSERT_INTO("T_SYS_RSP_CODE");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getProdId() != null) {
            VALUES("PROD_ID", "#{prodId,jdbcType=VARCHAR}");
        }
        
        if (record.getOutRspCode() != null) {
            VALUES("OUT_RSP_CODE", "#{outRspCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInRspCode2() != null) {
            VALUES("IN_RSP_CODE2", "#{inRspCode2,jdbcType=VARCHAR}");
        }
        
        if (record.getRspDesc() != null) {
            VALUES("RSP_DESC", "#{rspDesc,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public String selectByExample(TSysRspCodeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("PROD_ID");
        SELECT("OUT_RSP_CODE");
        SELECT("IN_RSP_CODE2");
        SELECT("RSP_DESC");
        FROM("T_SYS_RSP_CODE");
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
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TSysRspCode record = (TSysRspCode) parameter.get("record");
        TSysRspCodeExample example = (TSysRspCodeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("T_SYS_RSP_CODE");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getProdId() != null) {
            SET("PROD_ID = #{record.prodId,jdbcType=VARCHAR}");
        }
        
        if (record.getOutRspCode() != null) {
            SET("OUT_RSP_CODE = #{record.outRspCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInRspCode2() != null) {
            SET("IN_RSP_CODE2 = #{record.inRspCode2,jdbcType=VARCHAR}");
        }
        
        if (record.getRspDesc() != null) {
            SET("RSP_DESC = #{record.rspDesc,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("T_SYS_RSP_CODE");
        
        SET("ID = #{record.id,jdbcType=VARCHAR}");
        SET("PROD_ID = #{record.prodId,jdbcType=VARCHAR}");
        SET("OUT_RSP_CODE = #{record.outRspCode,jdbcType=VARCHAR}");
        SET("IN_RSP_CODE2 = #{record.inRspCode2,jdbcType=VARCHAR}");
        SET("RSP_DESC = #{record.rspDesc,jdbcType=VARCHAR}");
        
        TSysRspCodeExample example = (TSysRspCodeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    public String updateByPrimaryKeySelective(TSysRspCode record) {
        BEGIN();
        UPDATE("T_SYS_RSP_CODE");
        
        if (record.getProdId() != null) {
            SET("PROD_ID = #{prodId,jdbcType=VARCHAR}");
        }
        
        if (record.getOutRspCode() != null) {
            SET("OUT_RSP_CODE = #{outRspCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInRspCode2() != null) {
            SET("IN_RSP_CODE2 = #{inRspCode2,jdbcType=VARCHAR}");
        }
        
        if (record.getRspDesc() != null) {
            SET("RSP_DESC = #{rspDesc,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Sat Apr 16 13:41:08 CST 2016
     */
    protected void applyWhere(TSysRspCodeExample example, boolean includeExamplePhrase) {
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