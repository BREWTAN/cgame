package onight.tfg.ordbgens.tlt.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_CORE_WIN")
@AllArgsConstructor
@NoArgsConstructor
public class TLTCoreWin extends TLTCoreWinKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.TICK_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String tickNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.BET_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String betNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.MERCHANTID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.USER_ID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.ISSUE_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal issueNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String playType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.DIVISION_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String divisionType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.DIVISION_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String divisionLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.DIVISION_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Long divisionNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.LEVEL_BONUS_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal levelBonusAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.AWARD_MONEY
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal awardMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.BONUS_MONEY
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Long bonusMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.SUM_DIVISION_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Integer sumDivisionType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.CREATE_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.MODIFY_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date modifyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.FUND_RETURN_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal fundReturnAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.FUND_REF_ID_RETURN
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String fundRefIdReturn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.FUND_REF_ID_CANCEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String fundRefIdCancel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.FUND_RETURN_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date fundReturnDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.FUND_RETURN_STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String fundReturnStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.FUND_CANCEL_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date fundCancelDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_WIN.SERIAL_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String serialNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.TICK_NO
     *
     * @return the value of TLT_CORE_WIN.TICK_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getTickNo() {
        return tickNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.TICK_NO
     *
     * @param tickNo the value for TLT_CORE_WIN.TICK_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setTickNo(String tickNo) {
        this.tickNo = tickNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.BET_NO
     *
     * @return the value of TLT_CORE_WIN.BET_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getBetNo() {
        return betNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.BET_NO
     *
     * @param betNo the value for TLT_CORE_WIN.BET_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setBetNo(String betNo) {
        this.betNo = betNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.MERCHANTID
     *
     * @return the value of TLT_CORE_WIN.MERCHANTID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.MERCHANTID
     *
     * @param merchantid the value for TLT_CORE_WIN.MERCHANTID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.USER_ID
     *
     * @return the value of TLT_CORE_WIN.USER_ID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.USER_ID
     *
     * @param userId the value for TLT_CORE_WIN.USER_ID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.ISSUE_NO
     *
     * @return the value of TLT_CORE_WIN.ISSUE_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getIssueNo() {
        return issueNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.ISSUE_NO
     *
     * @param issueNo the value for TLT_CORE_WIN.ISSUE_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setIssueNo(BigDecimal issueNo) {
        this.issueNo = issueNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.LTYPE
     *
     * @return the value of TLT_CORE_WIN.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.LTYPE
     *
     * @param ltype the value for TLT_CORE_WIN.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.PLAY_TYPE
     *
     * @return the value of TLT_CORE_WIN.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getPlayType() {
        return playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.PLAY_TYPE
     *
     * @param playType the value for TLT_CORE_WIN.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setPlayType(String playType) {
        this.playType = playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.DIVISION_TYPE
     *
     * @return the value of TLT_CORE_WIN.DIVISION_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getDivisionType() {
        return divisionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.DIVISION_TYPE
     *
     * @param divisionType the value for TLT_CORE_WIN.DIVISION_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setDivisionType(String divisionType) {
        this.divisionType = divisionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.DIVISION_LEVEL
     *
     * @return the value of TLT_CORE_WIN.DIVISION_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getDivisionLevel() {
        return divisionLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.DIVISION_LEVEL
     *
     * @param divisionLevel the value for TLT_CORE_WIN.DIVISION_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setDivisionLevel(String divisionLevel) {
        this.divisionLevel = divisionLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.DIVISION_NUM
     *
     * @return the value of TLT_CORE_WIN.DIVISION_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Long getDivisionNum() {
        return divisionNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.DIVISION_NUM
     *
     * @param divisionNum the value for TLT_CORE_WIN.DIVISION_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setDivisionNum(Long divisionNum) {
        this.divisionNum = divisionNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.LEVEL_BONUS_AMOUNT
     *
     * @return the value of TLT_CORE_WIN.LEVEL_BONUS_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getLevelBonusAmount() {
        return levelBonusAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.LEVEL_BONUS_AMOUNT
     *
     * @param levelBonusAmount the value for TLT_CORE_WIN.LEVEL_BONUS_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setLevelBonusAmount(BigDecimal levelBonusAmount) {
        this.levelBonusAmount = levelBonusAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.STATUS
     *
     * @return the value of TLT_CORE_WIN.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.STATUS
     *
     * @param status the value for TLT_CORE_WIN.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.AWARD_MONEY
     *
     * @return the value of TLT_CORE_WIN.AWARD_MONEY
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getAwardMoney() {
        return awardMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.AWARD_MONEY
     *
     * @param awardMoney the value for TLT_CORE_WIN.AWARD_MONEY
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setAwardMoney(BigDecimal awardMoney) {
        this.awardMoney = awardMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.BONUS_MONEY
     *
     * @return the value of TLT_CORE_WIN.BONUS_MONEY
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Long getBonusMoney() {
        return bonusMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.BONUS_MONEY
     *
     * @param bonusMoney the value for TLT_CORE_WIN.BONUS_MONEY
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setBonusMoney(Long bonusMoney) {
        this.bonusMoney = bonusMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.SUM_DIVISION_TYPE
     *
     * @return the value of TLT_CORE_WIN.SUM_DIVISION_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Integer getSumDivisionType() {
        return sumDivisionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.SUM_DIVISION_TYPE
     *
     * @param sumDivisionType the value for TLT_CORE_WIN.SUM_DIVISION_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setSumDivisionType(Integer sumDivisionType) {
        this.sumDivisionType = sumDivisionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.CREATE_DATE
     *
     * @return the value of TLT_CORE_WIN.CREATE_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.CREATE_DATE
     *
     * @param createDate the value for TLT_CORE_WIN.CREATE_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.MODIFY_DATE
     *
     * @return the value of TLT_CORE_WIN.MODIFY_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.MODIFY_DATE
     *
     * @param modifyDate the value for TLT_CORE_WIN.MODIFY_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.FUND_RETURN_AMOUNT
     *
     * @return the value of TLT_CORE_WIN.FUND_RETURN_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getFundReturnAmount() {
        return fundReturnAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.FUND_RETURN_AMOUNT
     *
     * @param fundReturnAmount the value for TLT_CORE_WIN.FUND_RETURN_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundReturnAmount(BigDecimal fundReturnAmount) {
        this.fundReturnAmount = fundReturnAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.FUND_REF_ID_RETURN
     *
     * @return the value of TLT_CORE_WIN.FUND_REF_ID_RETURN
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getFundRefIdReturn() {
        return fundRefIdReturn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.FUND_REF_ID_RETURN
     *
     * @param fundRefIdReturn the value for TLT_CORE_WIN.FUND_REF_ID_RETURN
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundRefIdReturn(String fundRefIdReturn) {
        this.fundRefIdReturn = fundRefIdReturn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.FUND_REF_ID_CANCEL
     *
     * @return the value of TLT_CORE_WIN.FUND_REF_ID_CANCEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getFundRefIdCancel() {
        return fundRefIdCancel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.FUND_REF_ID_CANCEL
     *
     * @param fundRefIdCancel the value for TLT_CORE_WIN.FUND_REF_ID_CANCEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundRefIdCancel(String fundRefIdCancel) {
        this.fundRefIdCancel = fundRefIdCancel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.FUND_RETURN_DATE
     *
     * @return the value of TLT_CORE_WIN.FUND_RETURN_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getFundReturnDate() {
        return fundReturnDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.FUND_RETURN_DATE
     *
     * @param fundReturnDate the value for TLT_CORE_WIN.FUND_RETURN_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundReturnDate(Date fundReturnDate) {
        this.fundReturnDate = fundReturnDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.FUND_RETURN_STATUS
     *
     * @return the value of TLT_CORE_WIN.FUND_RETURN_STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getFundReturnStatus() {
        return fundReturnStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.FUND_RETURN_STATUS
     *
     * @param fundReturnStatus the value for TLT_CORE_WIN.FUND_RETURN_STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundReturnStatus(String fundReturnStatus) {
        this.fundReturnStatus = fundReturnStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.FUND_CANCEL_DATE
     *
     * @return the value of TLT_CORE_WIN.FUND_CANCEL_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getFundCancelDate() {
        return fundCancelDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.FUND_CANCEL_DATE
     *
     * @param fundCancelDate the value for TLT_CORE_WIN.FUND_CANCEL_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundCancelDate(Date fundCancelDate) {
        this.fundCancelDate = fundCancelDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_WIN.SERIAL_NUM
     *
     * @return the value of TLT_CORE_WIN.SERIAL_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_WIN.SERIAL_NUM
     *
     * @param serialNum the value for TLT_CORE_WIN.SERIAL_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_WIN
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TLTCoreWin other = (TLTCoreWin) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getTickNo() == null ? other.getTickNo() == null : this.getTickNo().equals(other.getTickNo()))
            && (this.getBetNo() == null ? other.getBetNo() == null : this.getBetNo().equals(other.getBetNo()))
            && (this.getMerchantid() == null ? other.getMerchantid() == null : this.getMerchantid().equals(other.getMerchantid()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIssueNo() == null ? other.getIssueNo() == null : this.getIssueNo().equals(other.getIssueNo()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getPlayType() == null ? other.getPlayType() == null : this.getPlayType().equals(other.getPlayType()))
            && (this.getDivisionType() == null ? other.getDivisionType() == null : this.getDivisionType().equals(other.getDivisionType()))
            && (this.getDivisionLevel() == null ? other.getDivisionLevel() == null : this.getDivisionLevel().equals(other.getDivisionLevel()))
            && (this.getDivisionNum() == null ? other.getDivisionNum() == null : this.getDivisionNum().equals(other.getDivisionNum()))
            && (this.getLevelBonusAmount() == null ? other.getLevelBonusAmount() == null : this.getLevelBonusAmount().equals(other.getLevelBonusAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAwardMoney() == null ? other.getAwardMoney() == null : this.getAwardMoney().equals(other.getAwardMoney()))
            && (this.getBonusMoney() == null ? other.getBonusMoney() == null : this.getBonusMoney().equals(other.getBonusMoney()))
            && (this.getSumDivisionType() == null ? other.getSumDivisionType() == null : this.getSumDivisionType().equals(other.getSumDivisionType()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getFundReturnAmount() == null ? other.getFundReturnAmount() == null : this.getFundReturnAmount().equals(other.getFundReturnAmount()))
            && (this.getFundRefIdReturn() == null ? other.getFundRefIdReturn() == null : this.getFundRefIdReturn().equals(other.getFundRefIdReturn()))
            && (this.getFundRefIdCancel() == null ? other.getFundRefIdCancel() == null : this.getFundRefIdCancel().equals(other.getFundRefIdCancel()))
            && (this.getFundReturnDate() == null ? other.getFundReturnDate() == null : this.getFundReturnDate().equals(other.getFundReturnDate()))
            && (this.getFundReturnStatus() == null ? other.getFundReturnStatus() == null : this.getFundReturnStatus().equals(other.getFundReturnStatus()))
            && (this.getFundCancelDate() == null ? other.getFundCancelDate() == null : this.getFundCancelDate().equals(other.getFundCancelDate()))
            && (this.getSerialNum() == null ? other.getSerialNum() == null : this.getSerialNum().equals(other.getSerialNum()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_WIN
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getTickNo() == null) ? 0 : getTickNo().hashCode());
        result = prime * result + ((getBetNo() == null) ? 0 : getBetNo().hashCode());
        result = prime * result + ((getMerchantid() == null) ? 0 : getMerchantid().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIssueNo() == null) ? 0 : getIssueNo().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getPlayType() == null) ? 0 : getPlayType().hashCode());
        result = prime * result + ((getDivisionType() == null) ? 0 : getDivisionType().hashCode());
        result = prime * result + ((getDivisionLevel() == null) ? 0 : getDivisionLevel().hashCode());
        result = prime * result + ((getDivisionNum() == null) ? 0 : getDivisionNum().hashCode());
        result = prime * result + ((getLevelBonusAmount() == null) ? 0 : getLevelBonusAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAwardMoney() == null) ? 0 : getAwardMoney().hashCode());
        result = prime * result + ((getBonusMoney() == null) ? 0 : getBonusMoney().hashCode());
        result = prime * result + ((getSumDivisionType() == null) ? 0 : getSumDivisionType().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getFundReturnAmount() == null) ? 0 : getFundReturnAmount().hashCode());
        result = prime * result + ((getFundRefIdReturn() == null) ? 0 : getFundRefIdReturn().hashCode());
        result = prime * result + ((getFundRefIdCancel() == null) ? 0 : getFundRefIdCancel().hashCode());
        result = prime * result + ((getFundReturnDate() == null) ? 0 : getFundReturnDate().hashCode());
        result = prime * result + ((getFundReturnStatus() == null) ? 0 : getFundReturnStatus().hashCode());
        result = prime * result + ((getFundCancelDate() == null) ? 0 : getFundCancelDate().hashCode());
        result = prime * result + ((getSerialNum() == null) ? 0 : getSerialNum().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_WIN
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tickNo=").append(tickNo);
        sb.append(", betNo=").append(betNo);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", userId=").append(userId);
        sb.append(", issueNo=").append(issueNo);
        sb.append(", ltype=").append(ltype);
        sb.append(", playType=").append(playType);
        sb.append(", divisionType=").append(divisionType);
        sb.append(", divisionLevel=").append(divisionLevel);
        sb.append(", divisionNum=").append(divisionNum);
        sb.append(", levelBonusAmount=").append(levelBonusAmount);
        sb.append(", status=").append(status);
        sb.append(", awardMoney=").append(awardMoney);
        sb.append(", bonusMoney=").append(bonusMoney);
        sb.append(", sumDivisionType=").append(sumDivisionType);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", fundReturnAmount=").append(fundReturnAmount);
        sb.append(", fundRefIdReturn=").append(fundRefIdReturn);
        sb.append(", fundRefIdCancel=").append(fundRefIdCancel);
        sb.append(", fundReturnDate=").append(fundReturnDate);
        sb.append(", fundReturnStatus=").append(fundReturnStatus);
        sb.append(", fundCancelDate=").append(fundCancelDate);
        sb.append(", serialNum=").append(serialNum);
        sb.append("]");
        return sb.toString();
    }
}