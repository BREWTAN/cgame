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
import onight.tfg.ordbgens.tfg.entity.TFGLoginUser;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserExample.Criterion;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserExample;

public class TFGLoginUserSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String countByExample(TFGLoginUserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TFG_LOGIN_USER");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String deleteByExample(TFGLoginUserExample example) {
        BEGIN();
        DELETE_FROM("TFG_LOGIN_USER");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String insertSelective(TFGLoginUser record) {
        BEGIN();
        INSERT_INTO("TFG_LOGIN_USER");
        
        if (record.getUserId() != null) {
            VALUES("USER_ID", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getLoginId() != null) {
            VALUES("LOGIN_ID", "#{loginId,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            VALUES("NICKNAME", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("EMAIL", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            VALUES("MOBILE", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getThirdLoginid1() != null) {
            VALUES("THIRD_LOGINID1", "#{thirdLoginid1,jdbcType=VARCHAR}");
        }
        
        if (record.getThirdLoginid2() != null) {
            VALUES("THIRD_LOGINID2", "#{thirdLoginid2,jdbcType=VARCHAR}");
        }
        
        if (record.getRegType() != null) {
            VALUES("REG_TYPE", "#{regType,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPassword() != null) {
            VALUES("PASSWORD", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePassword() != null) {
            VALUES("TRADE_PASSWORD", "#{tradePassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginTime() != null) {
            VALUES("LAST_LOGIN_TIME", "#{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginIp() != null) {
            VALUES("LAST_LOGIN_IP", "#{lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTerminal() != null) {
            VALUES("LAST_LOGIN_TERMINAL", "#{lastLoginTerminal,jdbcType=INTEGER}");
        }
        
        if (record.getLastLoginSysinfo() != null) {
            VALUES("LAST_LOGIN_SYSINFO", "#{lastLoginSysinfo,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String selectByExample(TFGLoginUserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("USER_ID");
        } else {
            SELECT("USER_ID");
        }
        SELECT("LOGIN_ID");
        SELECT("NICKNAME");
        SELECT("EMAIL");
        SELECT("MOBILE");
        SELECT("THIRD_LOGINID1");
        SELECT("THIRD_LOGINID2");
        SELECT("REG_TYPE");
        SELECT("STATUS");
        SELECT("PASSWORD");
        SELECT("TRADE_PASSWORD");
        SELECT("UPDATE_TIME");
        SELECT("CREATE_TIME");
        SELECT("LAST_LOGIN_TIME");
        SELECT("LAST_LOGIN_IP");
        SELECT("LAST_LOGIN_TERMINAL");
        SELECT("LAST_LOGIN_SYSINFO");
        FROM("TFG_LOGIN_USER");
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
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TFGLoginUser record = (TFGLoginUser) parameter.get("record");
        TFGLoginUserExample example = (TFGLoginUserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TFG_LOGIN_USER");
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getLoginId() != null) {
            SET("LOGIN_ID = #{record.loginId,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            SET("NICKNAME = #{record.nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("EMAIL = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("MOBILE = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getThirdLoginid1() != null) {
            SET("THIRD_LOGINID1 = #{record.thirdLoginid1,jdbcType=VARCHAR}");
        }
        
        if (record.getThirdLoginid2() != null) {
            SET("THIRD_LOGINID2 = #{record.thirdLoginid2,jdbcType=VARCHAR}");
        }
        
        if (record.getRegType() != null) {
            SET("REG_TYPE = #{record.regType,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPassword() != null) {
            SET("PASSWORD = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePassword() != null) {
            SET("TRADE_PASSWORD = #{record.tradePassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginTime() != null) {
            SET("LAST_LOGIN_TIME = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginIp() != null) {
            SET("LAST_LOGIN_IP = #{record.lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTerminal() != null) {
            SET("LAST_LOGIN_TERMINAL = #{record.lastLoginTerminal,jdbcType=INTEGER}");
        }
        
        if (record.getLastLoginSysinfo() != null) {
            SET("LAST_LOGIN_SYSINFO = #{record.lastLoginSysinfo,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TFG_LOGIN_USER");
        
        SET("USER_ID = #{record.userId,jdbcType=BIGINT}");
        SET("LOGIN_ID = #{record.loginId,jdbcType=VARCHAR}");
        SET("NICKNAME = #{record.nickname,jdbcType=VARCHAR}");
        SET("EMAIL = #{record.email,jdbcType=VARCHAR}");
        SET("MOBILE = #{record.mobile,jdbcType=VARCHAR}");
        SET("THIRD_LOGINID1 = #{record.thirdLoginid1,jdbcType=VARCHAR}");
        SET("THIRD_LOGINID2 = #{record.thirdLoginid2,jdbcType=VARCHAR}");
        SET("REG_TYPE = #{record.regType,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=INTEGER}");
        SET("PASSWORD = #{record.password,jdbcType=VARCHAR}");
        SET("TRADE_PASSWORD = #{record.tradePassword,jdbcType=VARCHAR}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("LAST_LOGIN_TIME = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        SET("LAST_LOGIN_IP = #{record.lastLoginIp,jdbcType=VARCHAR}");
        SET("LAST_LOGIN_TERMINAL = #{record.lastLoginTerminal,jdbcType=INTEGER}");
        SET("LAST_LOGIN_SYSINFO = #{record.lastLoginSysinfo,jdbcType=VARCHAR}");
        
        TFGLoginUserExample example = (TFGLoginUserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String updateByPrimaryKeySelective(TFGLoginUser record) {
        BEGIN();
        UPDATE("TFG_LOGIN_USER");
        
        if (record.getLoginId() != null) {
            SET("LOGIN_ID = #{loginId,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            SET("NICKNAME = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("EMAIL = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("MOBILE = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getThirdLoginid1() != null) {
            SET("THIRD_LOGINID1 = #{thirdLoginid1,jdbcType=VARCHAR}");
        }
        
        if (record.getThirdLoginid2() != null) {
            SET("THIRD_LOGINID2 = #{thirdLoginid2,jdbcType=VARCHAR}");
        }
        
        if (record.getRegType() != null) {
            SET("REG_TYPE = #{regType,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPassword() != null) {
            SET("PASSWORD = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePassword() != null) {
            SET("TRADE_PASSWORD = #{tradePassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginTime() != null) {
            SET("LAST_LOGIN_TIME = #{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginIp() != null) {
            SET("LAST_LOGIN_IP = #{lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTerminal() != null) {
            SET("LAST_LOGIN_TERMINAL = #{lastLoginTerminal,jdbcType=INTEGER}");
        }
        
        if (record.getLastLoginSysinfo() != null) {
            SET("LAST_LOGIN_SYSINFO = #{lastLoginSysinfo,jdbcType=VARCHAR}");
        }
        
        WHERE("USER_ID = #{userId,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_LOGIN_USER
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    protected void applyWhere(TFGLoginUserExample example, boolean includeExamplePhrase) {
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