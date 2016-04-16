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
import onight.tfg.ordbgens.tfg.entity.TFGUserInfo;
import onight.tfg.ordbgens.tfg.entity.TFGUserInfoExample.Criteria;
import onight.tfg.ordbgens.tfg.entity.TFGUserInfoExample.Criterion;
import onight.tfg.ordbgens.tfg.entity.TFGUserInfoExample;

public class TFGUserInfoSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String countByExample(TFGUserInfoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TFG_USER_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String deleteByExample(TFGUserInfoExample example) {
        BEGIN();
        DELETE_FROM("TFG_USER_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String insertSelective(TFGUserInfo record) {
        BEGIN();
        INSERT_INTO("TFG_USER_INFO");
        
        if (record.getUserId() != null) {
            VALUES("USER_ID", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getNickname() != null) {
            VALUES("NICKNAME", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            VALUES("PARENT_ID", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getRecommendId() != null) {
            VALUES("RECOMMEND_ID", "#{recommendId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            VALUES("USER_TYPE", "#{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getSecurityEmail() != null) {
            VALUES("SECURITY_EMAIL", "#{securityEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            VALUES("REAL_NAME", "#{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getIdNo() != null) {
            VALUES("ID_NO", "#{idNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQqId() != null) {
            VALUES("QQ_ID", "#{qqId,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatId() != null) {
            VALUES("WECHAT_ID", "#{wechatId,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            VALUES("MOBILE", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("EMAIL", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getRenren() != null) {
            VALUES("RENREN", "#{renren,jdbcType=VARCHAR}");
        }
        
        if (record.getWeibo() != null) {
            VALUES("WEIBO", "#{weibo,jdbcType=VARCHAR}");
        }
        
        if (record.getFace() != null) {
            VALUES("FACE", "#{face,jdbcType=INTEGER}");
        }
        
        if (record.getFaceUrl() != null) {
            VALUES("FACE_URL", "#{faceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            VALUES("GENDER", "#{gender,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("BIRTHDAY", "#{birthday,jdbcType=DATE}");
        }
        
        if (record.getCountry() != null) {
            VALUES("COUNTRY", "#{country,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            VALUES("PROVINCE", "#{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            VALUES("CITY", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getHomeAddress() != null) {
            VALUES("HOME_ADDRESS", "#{homeAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkAddress() != null) {
            VALUES("WORK_ADDRESS", "#{workAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile1() != null) {
            VALUES("MOBILE1", "#{mobile1,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile2() != null) {
            VALUES("MOBILE2", "#{mobile2,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile3() != null) {
            VALUES("MOBILE3", "#{mobile3,jdbcType=VARCHAR}");
        }
        
        if (record.getMobilehis() != null) {
            VALUES("MOBILEHIS", "#{mobilehis,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getRegTime() != null) {
            VALUES("REG_TIME", "#{regTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRegIp() != null) {
            VALUES("REG_IP", "#{regIp,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String selectByExample(TFGUserInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("USER_ID");
        } else {
            SELECT("USER_ID");
        }
        SELECT("NICKNAME");
        SELECT("PARENT_ID");
        SELECT("RECOMMEND_ID");
        SELECT("USER_TYPE");
        SELECT("SECURITY_EMAIL");
        SELECT("REAL_NAME");
        SELECT("STATUS");
        SELECT("ID_NO");
        SELECT("UPDATE_TIME");
        SELECT("CREATE_TIME");
        SELECT("QQ_ID");
        SELECT("WECHAT_ID");
        SELECT("MOBILE");
        SELECT("EMAIL");
        SELECT("RENREN");
        SELECT("WEIBO");
        SELECT("FACE");
        SELECT("FACE_URL");
        SELECT("GENDER");
        SELECT("BIRTHDAY");
        SELECT("COUNTRY");
        SELECT("PROVINCE");
        SELECT("CITY");
        SELECT("HOME_ADDRESS");
        SELECT("WORK_ADDRESS");
        SELECT("MOBILE1");
        SELECT("MOBILE2");
        SELECT("MOBILE3");
        SELECT("MOBILEHIS");
        SELECT("REMARK");
        SELECT("REG_TIME");
        SELECT("REG_IP");
        FROM("TFG_USER_INFO");
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
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TFGUserInfo record = (TFGUserInfo) parameter.get("record");
        TFGUserInfoExample example = (TFGUserInfoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TFG_USER_INFO");
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getNickname() != null) {
            SET("NICKNAME = #{record.nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("PARENT_ID = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getRecommendId() != null) {
            SET("RECOMMEND_ID = #{record.recommendId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            SET("USER_TYPE = #{record.userType,jdbcType=VARCHAR}");
        }
        
        if (record.getSecurityEmail() != null) {
            SET("SECURITY_EMAIL = #{record.securityEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            SET("REAL_NAME = #{record.realName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getIdNo() != null) {
            SET("ID_NO = #{record.idNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQqId() != null) {
            SET("QQ_ID = #{record.qqId,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatId() != null) {
            SET("WECHAT_ID = #{record.wechatId,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("MOBILE = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("EMAIL = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getRenren() != null) {
            SET("RENREN = #{record.renren,jdbcType=VARCHAR}");
        }
        
        if (record.getWeibo() != null) {
            SET("WEIBO = #{record.weibo,jdbcType=VARCHAR}");
        }
        
        if (record.getFace() != null) {
            SET("FACE = #{record.face,jdbcType=INTEGER}");
        }
        
        if (record.getFaceUrl() != null) {
            SET("FACE_URL = #{record.faceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("GENDER = #{record.gender,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            SET("BIRTHDAY = #{record.birthday,jdbcType=DATE}");
        }
        
        if (record.getCountry() != null) {
            SET("COUNTRY = #{record.country,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            SET("PROVINCE = #{record.province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("CITY = #{record.city,jdbcType=VARCHAR}");
        }
        
        if (record.getHomeAddress() != null) {
            SET("HOME_ADDRESS = #{record.homeAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkAddress() != null) {
            SET("WORK_ADDRESS = #{record.workAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile1() != null) {
            SET("MOBILE1 = #{record.mobile1,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile2() != null) {
            SET("MOBILE2 = #{record.mobile2,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile3() != null) {
            SET("MOBILE3 = #{record.mobile3,jdbcType=VARCHAR}");
        }
        
        if (record.getMobilehis() != null) {
            SET("MOBILEHIS = #{record.mobilehis,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getRegTime() != null) {
            SET("REG_TIME = #{record.regTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRegIp() != null) {
            SET("REG_IP = #{record.regIp,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TFG_USER_INFO");
        
        SET("USER_ID = #{record.userId,jdbcType=BIGINT}");
        SET("NICKNAME = #{record.nickname,jdbcType=VARCHAR}");
        SET("PARENT_ID = #{record.parentId,jdbcType=BIGINT}");
        SET("RECOMMEND_ID = #{record.recommendId,jdbcType=BIGINT}");
        SET("USER_TYPE = #{record.userType,jdbcType=VARCHAR}");
        SET("SECURITY_EMAIL = #{record.securityEmail,jdbcType=VARCHAR}");
        SET("REAL_NAME = #{record.realName,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=INTEGER}");
        SET("ID_NO = #{record.idNo,jdbcType=VARCHAR}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("QQ_ID = #{record.qqId,jdbcType=VARCHAR}");
        SET("WECHAT_ID = #{record.wechatId,jdbcType=VARCHAR}");
        SET("MOBILE = #{record.mobile,jdbcType=VARCHAR}");
        SET("EMAIL = #{record.email,jdbcType=VARCHAR}");
        SET("RENREN = #{record.renren,jdbcType=VARCHAR}");
        SET("WEIBO = #{record.weibo,jdbcType=VARCHAR}");
        SET("FACE = #{record.face,jdbcType=INTEGER}");
        SET("FACE_URL = #{record.faceUrl,jdbcType=VARCHAR}");
        SET("GENDER = #{record.gender,jdbcType=INTEGER}");
        SET("BIRTHDAY = #{record.birthday,jdbcType=DATE}");
        SET("COUNTRY = #{record.country,jdbcType=VARCHAR}");
        SET("PROVINCE = #{record.province,jdbcType=VARCHAR}");
        SET("CITY = #{record.city,jdbcType=VARCHAR}");
        SET("HOME_ADDRESS = #{record.homeAddress,jdbcType=VARCHAR}");
        SET("WORK_ADDRESS = #{record.workAddress,jdbcType=VARCHAR}");
        SET("MOBILE1 = #{record.mobile1,jdbcType=VARCHAR}");
        SET("MOBILE2 = #{record.mobile2,jdbcType=VARCHAR}");
        SET("MOBILE3 = #{record.mobile3,jdbcType=VARCHAR}");
        SET("MOBILEHIS = #{record.mobilehis,jdbcType=VARCHAR}");
        SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        SET("REG_TIME = #{record.regTime,jdbcType=TIMESTAMP}");
        SET("REG_IP = #{record.regIp,jdbcType=VARCHAR}");
        
        TFGUserInfoExample example = (TFGUserInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByPrimaryKeySelective(TFGUserInfo record) {
        BEGIN();
        UPDATE("TFG_USER_INFO");
        
        if (record.getNickname() != null) {
            SET("NICKNAME = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("PARENT_ID = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getRecommendId() != null) {
            SET("RECOMMEND_ID = #{recommendId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            SET("USER_TYPE = #{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getSecurityEmail() != null) {
            SET("SECURITY_EMAIL = #{securityEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            SET("REAL_NAME = #{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getIdNo() != null) {
            SET("ID_NO = #{idNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQqId() != null) {
            SET("QQ_ID = #{qqId,jdbcType=VARCHAR}");
        }
        
        if (record.getWechatId() != null) {
            SET("WECHAT_ID = #{wechatId,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("MOBILE = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("EMAIL = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getRenren() != null) {
            SET("RENREN = #{renren,jdbcType=VARCHAR}");
        }
        
        if (record.getWeibo() != null) {
            SET("WEIBO = #{weibo,jdbcType=VARCHAR}");
        }
        
        if (record.getFace() != null) {
            SET("FACE = #{face,jdbcType=INTEGER}");
        }
        
        if (record.getFaceUrl() != null) {
            SET("FACE_URL = #{faceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("GENDER = #{gender,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            SET("BIRTHDAY = #{birthday,jdbcType=DATE}");
        }
        
        if (record.getCountry() != null) {
            SET("COUNTRY = #{country,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            SET("PROVINCE = #{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("CITY = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getHomeAddress() != null) {
            SET("HOME_ADDRESS = #{homeAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkAddress() != null) {
            SET("WORK_ADDRESS = #{workAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile1() != null) {
            SET("MOBILE1 = #{mobile1,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile2() != null) {
            SET("MOBILE2 = #{mobile2,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile3() != null) {
            SET("MOBILE3 = #{mobile3,jdbcType=VARCHAR}");
        }
        
        if (record.getMobilehis() != null) {
            SET("MOBILEHIS = #{mobilehis,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getRegTime() != null) {
            SET("REG_TIME = #{regTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRegIp() != null) {
            SET("REG_IP = #{regIp,jdbcType=VARCHAR}");
        }
        
        WHERE("USER_ID = #{userId,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    protected void applyWhere(TFGUserInfoExample example, boolean includeExamplePhrase) {
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