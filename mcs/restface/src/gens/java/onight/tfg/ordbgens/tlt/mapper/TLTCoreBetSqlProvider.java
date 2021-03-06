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
import onight.tfg.ordbgens.tlt.entity.TLTCoreBet;
import onight.tfg.ordbgens.tlt.entity.TLTCoreBetExample.Criteria;
import onight.tfg.ordbgens.tlt.entity.TLTCoreBetExample.Criterion;
import onight.tfg.ordbgens.tlt.entity.TLTCoreBetExample;

public class TLTCoreBetSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String countByExample(TLTCoreBetExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TLT_CORE_BET");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String deleteByExample(TLTCoreBetExample example) {
        BEGIN();
        DELETE_FROM("TLT_CORE_BET");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String insertSelective(TLTCoreBet record) {
        BEGIN();
        INSERT_INTO("TLT_CORE_BET");
        
        if (record.getBetNo() != null) {
            VALUES("BET_NO", "#{betNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTickNo() != null) {
            VALUES("TICK_NO", "#{tickNo,jdbcType=VARCHAR}");
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
        
        if (record.getMerchantid() != null) {
            VALUES("MERCHANTID", "#{merchantid,jdbcType=VARCHAR}");
        }
        
        if (record.getSerialNum() != null) {
            VALUES("SERIAL_NUM", "#{serialNum,jdbcType=VARCHAR}");
        }
        
        if (record.getBetAmounts() != null) {
            VALUES("BET_AMOUNTS", "#{betAmounts,jdbcType=DECIMAL}");
        }
        
        if (record.getBetMulti() != null) {
            VALUES("BET_MULTI", "#{betMulti,jdbcType=DECIMAL}");
        }
        
        if (record.getIssueNo() != null) {
            VALUES("ISSUE_NO", "#{issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBetDatetime() != null) {
            VALUES("BET_DATETIME", "#{betDatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBetDivContent() != null) {
            VALUES("BET_DIV_CONTENT", "#{betDivContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBetOrgCounts() != null) {
            VALUES("BET_ORG_COUNTS", "#{betOrgCounts,jdbcType=DECIMAL}");
        }
        
        if (record.getBetOrgContent() != null) {
            VALUES("BET_ORG_CONTENT", "#{betOrgContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBetIp() != null) {
            VALUES("BET_IP", "#{betIp,jdbcType=VARCHAR}");
        }
        
        if (record.getBetMoneyUnit() != null) {
            VALUES("BET_MONEY_UNIT", "#{betMoneyUnit,jdbcType=INTEGER}");
        }
        
        if (record.getBonusMoneyMode() != null) {
            VALUES("BONUS_MONEY_MODE", "#{bonusMoneyMode,jdbcType=DECIMAL}");
        }
        
        if (record.getBonusRateMode() != null) {
            VALUES("BONUS_RATE_MODE", "#{bonusRateMode,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            VALUES("VERSION", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getPrintTime() != null) {
            VALUES("PRINT_TIME", "#{printTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBetStatus() != null) {
            VALUES("BET_STATUS", "#{betStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifystatus() != null) {
            VALUES("NOTIFYSTATUS", "#{notifystatus,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            VALUES("REGION", "#{region,jdbcType=VARCHAR}");
        }
        
        if (record.getFailreason() != null) {
            VALUES("FAILREASON", "#{failreason,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantuserid() != null) {
            VALUES("MERCHANTUSERID", "#{merchantuserid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            VALUES("USER_ID", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getAutobetNo() != null) {
            VALUES("AUTOBET_NO", "#{autobetNo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAuto() != null) {
            VALUES("IS_AUTO", "#{isAuto,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoRefTickno() != null) {
            VALUES("AUTO_REF_TICKNO", "#{autoRefTickno,jdbcType=VARCHAR}");
        }
        
        if (record.getCostFund0() != null) {
            VALUES("COST_FUND0", "#{costFund0,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund1() != null) {
            VALUES("COST_FUND1", "#{costFund1,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund2() != null) {
            VALUES("COST_FUND2", "#{costFund2,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund3() != null) {
            VALUES("COST_FUND3", "#{costFund3,jdbcType=DECIMAL}");
        }
        
        if (record.getFundRefId() != null) {
            VALUES("FUND_REF_ID", "#{fundRefId,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueLock() != null) {
            VALUES("ISSUE_LOCK", "#{issueLock,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String selectByExample(TLTCoreBetExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("BET_NO");
        } else {
            SELECT("BET_NO");
        }
        SELECT("TICK_NO");
        SELECT("LTYPE");
        SELECT("LNAME");
        SELECT("PLAY_TYPE");
        SELECT("MERCHANTID");
        SELECT("SERIAL_NUM");
        SELECT("BET_AMOUNTS");
        SELECT("BET_MULTI");
        SELECT("ISSUE_NO");
        SELECT("BET_DATETIME");
        SELECT("BET_DIV_CONTENT");
        SELECT("BET_ORG_COUNTS");
        SELECT("BET_ORG_CONTENT");
        SELECT("BET_IP");
        SELECT("BET_MONEY_UNIT");
        SELECT("BONUS_MONEY_MODE");
        SELECT("BONUS_RATE_MODE");
        SELECT("VERSION");
        SELECT("PRINT_TIME");
        SELECT("BET_STATUS");
        SELECT("NOTIFYSTATUS");
        SELECT("REGION");
        SELECT("FAILREASON");
        SELECT("MERCHANTUSERID");
        SELECT("USER_ID");
        SELECT("AUTOBET_NO");
        SELECT("IS_AUTO");
        SELECT("AUTO_REF_TICKNO");
        SELECT("COST_FUND0");
        SELECT("COST_FUND1");
        SELECT("COST_FUND2");
        SELECT("COST_FUND3");
        SELECT("FUND_REF_ID");
        SELECT("ISSUE_LOCK");
        FROM("TLT_CORE_BET");
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
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TLTCoreBet record = (TLTCoreBet) parameter.get("record");
        TLTCoreBetExample example = (TLTCoreBetExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TLT_CORE_BET");
        
        if (record.getBetNo() != null) {
            SET("BET_NO = #{record.betNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTickNo() != null) {
            SET("TICK_NO = #{record.tickNo,jdbcType=VARCHAR}");
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
        
        if (record.getMerchantid() != null) {
            SET("MERCHANTID = #{record.merchantid,jdbcType=VARCHAR}");
        }
        
        if (record.getSerialNum() != null) {
            SET("SERIAL_NUM = #{record.serialNum,jdbcType=VARCHAR}");
        }
        
        if (record.getBetAmounts() != null) {
            SET("BET_AMOUNTS = #{record.betAmounts,jdbcType=DECIMAL}");
        }
        
        if (record.getBetMulti() != null) {
            SET("BET_MULTI = #{record.betMulti,jdbcType=DECIMAL}");
        }
        
        if (record.getIssueNo() != null) {
            SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBetDatetime() != null) {
            SET("BET_DATETIME = #{record.betDatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBetDivContent() != null) {
            SET("BET_DIV_CONTENT = #{record.betDivContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBetOrgCounts() != null) {
            SET("BET_ORG_COUNTS = #{record.betOrgCounts,jdbcType=DECIMAL}");
        }
        
        if (record.getBetOrgContent() != null) {
            SET("BET_ORG_CONTENT = #{record.betOrgContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBetIp() != null) {
            SET("BET_IP = #{record.betIp,jdbcType=VARCHAR}");
        }
        
        if (record.getBetMoneyUnit() != null) {
            SET("BET_MONEY_UNIT = #{record.betMoneyUnit,jdbcType=INTEGER}");
        }
        
        if (record.getBonusMoneyMode() != null) {
            SET("BONUS_MONEY_MODE = #{record.bonusMoneyMode,jdbcType=DECIMAL}");
        }
        
        if (record.getBonusRateMode() != null) {
            SET("BONUS_RATE_MODE = #{record.bonusRateMode,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            SET("VERSION = #{record.version,jdbcType=VARCHAR}");
        }
        
        if (record.getPrintTime() != null) {
            SET("PRINT_TIME = #{record.printTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBetStatus() != null) {
            SET("BET_STATUS = #{record.betStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifystatus() != null) {
            SET("NOTIFYSTATUS = #{record.notifystatus,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            SET("REGION = #{record.region,jdbcType=VARCHAR}");
        }
        
        if (record.getFailreason() != null) {
            SET("FAILREASON = #{record.failreason,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantuserid() != null) {
            SET("MERCHANTUSERID = #{record.merchantuserid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getAutobetNo() != null) {
            SET("AUTOBET_NO = #{record.autobetNo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAuto() != null) {
            SET("IS_AUTO = #{record.isAuto,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoRefTickno() != null) {
            SET("AUTO_REF_TICKNO = #{record.autoRefTickno,jdbcType=VARCHAR}");
        }
        
        if (record.getCostFund0() != null) {
            SET("COST_FUND0 = #{record.costFund0,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund1() != null) {
            SET("COST_FUND1 = #{record.costFund1,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund2() != null) {
            SET("COST_FUND2 = #{record.costFund2,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund3() != null) {
            SET("COST_FUND3 = #{record.costFund3,jdbcType=DECIMAL}");
        }
        
        if (record.getFundRefId() != null) {
            SET("FUND_REF_ID = #{record.fundRefId,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueLock() != null) {
            SET("ISSUE_LOCK = #{record.issueLock,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TLT_CORE_BET");
        
        SET("BET_NO = #{record.betNo,jdbcType=VARCHAR}");
        SET("TICK_NO = #{record.tickNo,jdbcType=VARCHAR}");
        SET("LTYPE = #{record.ltype,jdbcType=VARCHAR}");
        SET("LNAME = #{record.lname,jdbcType=VARCHAR}");
        SET("PLAY_TYPE = #{record.playType,jdbcType=VARCHAR}");
        SET("MERCHANTID = #{record.merchantid,jdbcType=VARCHAR}");
        SET("SERIAL_NUM = #{record.serialNum,jdbcType=VARCHAR}");
        SET("BET_AMOUNTS = #{record.betAmounts,jdbcType=DECIMAL}");
        SET("BET_MULTI = #{record.betMulti,jdbcType=DECIMAL}");
        SET("ISSUE_NO = #{record.issueNo,jdbcType=VARCHAR}");
        SET("BET_DATETIME = #{record.betDatetime,jdbcType=TIMESTAMP}");
        SET("BET_DIV_CONTENT = #{record.betDivContent,jdbcType=VARCHAR}");
        SET("BET_ORG_COUNTS = #{record.betOrgCounts,jdbcType=DECIMAL}");
        SET("BET_ORG_CONTENT = #{record.betOrgContent,jdbcType=VARCHAR}");
        SET("BET_IP = #{record.betIp,jdbcType=VARCHAR}");
        SET("BET_MONEY_UNIT = #{record.betMoneyUnit,jdbcType=INTEGER}");
        SET("BONUS_MONEY_MODE = #{record.bonusMoneyMode,jdbcType=DECIMAL}");
        SET("BONUS_RATE_MODE = #{record.bonusRateMode,jdbcType=DECIMAL}");
        SET("VERSION = #{record.version,jdbcType=VARCHAR}");
        SET("PRINT_TIME = #{record.printTime,jdbcType=TIMESTAMP}");
        SET("BET_STATUS = #{record.betStatus,jdbcType=VARCHAR}");
        SET("NOTIFYSTATUS = #{record.notifystatus,jdbcType=VARCHAR}");
        SET("REGION = #{record.region,jdbcType=VARCHAR}");
        SET("FAILREASON = #{record.failreason,jdbcType=VARCHAR}");
        SET("MERCHANTUSERID = #{record.merchantuserid,jdbcType=VARCHAR}");
        SET("USER_ID = #{record.userId,jdbcType=VARCHAR}");
        SET("AUTOBET_NO = #{record.autobetNo,jdbcType=VARCHAR}");
        SET("IS_AUTO = #{record.isAuto,jdbcType=VARCHAR}");
        SET("AUTO_REF_TICKNO = #{record.autoRefTickno,jdbcType=VARCHAR}");
        SET("COST_FUND0 = #{record.costFund0,jdbcType=DECIMAL}");
        SET("COST_FUND1 = #{record.costFund1,jdbcType=DECIMAL}");
        SET("COST_FUND2 = #{record.costFund2,jdbcType=DECIMAL}");
        SET("COST_FUND3 = #{record.costFund3,jdbcType=DECIMAL}");
        SET("FUND_REF_ID = #{record.fundRefId,jdbcType=VARCHAR}");
        SET("ISSUE_LOCK = #{record.issueLock,jdbcType=VARCHAR}");
        
        TLTCoreBetExample example = (TLTCoreBetExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String updateByPrimaryKeySelective(TLTCoreBet record) {
        BEGIN();
        UPDATE("TLT_CORE_BET");
        
        if (record.getTickNo() != null) {
            SET("TICK_NO = #{tickNo,jdbcType=VARCHAR}");
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
        
        if (record.getMerchantid() != null) {
            SET("MERCHANTID = #{merchantid,jdbcType=VARCHAR}");
        }
        
        if (record.getSerialNum() != null) {
            SET("SERIAL_NUM = #{serialNum,jdbcType=VARCHAR}");
        }
        
        if (record.getBetAmounts() != null) {
            SET("BET_AMOUNTS = #{betAmounts,jdbcType=DECIMAL}");
        }
        
        if (record.getBetMulti() != null) {
            SET("BET_MULTI = #{betMulti,jdbcType=DECIMAL}");
        }
        
        if (record.getIssueNo() != null) {
            SET("ISSUE_NO = #{issueNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBetDatetime() != null) {
            SET("BET_DATETIME = #{betDatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBetDivContent() != null) {
            SET("BET_DIV_CONTENT = #{betDivContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBetOrgCounts() != null) {
            SET("BET_ORG_COUNTS = #{betOrgCounts,jdbcType=DECIMAL}");
        }
        
        if (record.getBetOrgContent() != null) {
            SET("BET_ORG_CONTENT = #{betOrgContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBetIp() != null) {
            SET("BET_IP = #{betIp,jdbcType=VARCHAR}");
        }
        
        if (record.getBetMoneyUnit() != null) {
            SET("BET_MONEY_UNIT = #{betMoneyUnit,jdbcType=INTEGER}");
        }
        
        if (record.getBonusMoneyMode() != null) {
            SET("BONUS_MONEY_MODE = #{bonusMoneyMode,jdbcType=DECIMAL}");
        }
        
        if (record.getBonusRateMode() != null) {
            SET("BONUS_RATE_MODE = #{bonusRateMode,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            SET("VERSION = #{version,jdbcType=VARCHAR}");
        }
        
        if (record.getPrintTime() != null) {
            SET("PRINT_TIME = #{printTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBetStatus() != null) {
            SET("BET_STATUS = #{betStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifystatus() != null) {
            SET("NOTIFYSTATUS = #{notifystatus,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            SET("REGION = #{region,jdbcType=VARCHAR}");
        }
        
        if (record.getFailreason() != null) {
            SET("FAILREASON = #{failreason,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantuserid() != null) {
            SET("MERCHANTUSERID = #{merchantuserid,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getAutobetNo() != null) {
            SET("AUTOBET_NO = #{autobetNo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAuto() != null) {
            SET("IS_AUTO = #{isAuto,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoRefTickno() != null) {
            SET("AUTO_REF_TICKNO = #{autoRefTickno,jdbcType=VARCHAR}");
        }
        
        if (record.getCostFund0() != null) {
            SET("COST_FUND0 = #{costFund0,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund1() != null) {
            SET("COST_FUND1 = #{costFund1,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund2() != null) {
            SET("COST_FUND2 = #{costFund2,jdbcType=DECIMAL}");
        }
        
        if (record.getCostFund3() != null) {
            SET("COST_FUND3 = #{costFund3,jdbcType=DECIMAL}");
        }
        
        if (record.getFundRefId() != null) {
            SET("FUND_REF_ID = #{fundRefId,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueLock() != null) {
            SET("ISSUE_LOCK = #{issueLock,jdbcType=VARCHAR}");
        }
        
        WHERE("BET_NO = #{betNo,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    protected void applyWhere(TLTCoreBetExample example, boolean includeExamplePhrase) {
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