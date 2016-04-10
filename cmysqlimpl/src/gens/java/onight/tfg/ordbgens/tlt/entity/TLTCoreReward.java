package onight.tfg.ordbgens.tlt.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_CORE_REWARD")
@AllArgsConstructor
@NoArgsConstructor
public class TLTCoreReward extends TLTCoreRewardKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.TICK_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String tickNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.BET_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String betNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.MERCHANTID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.USER_ID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.ISSUE_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal issueNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String playType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.CREATE_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.MODIFY_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date modifyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.BET_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal betAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.BET_COUNTS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal betCounts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.REWARD_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal rewardAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.REWARD_RATIO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal rewardRatio;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.FUND_REWARD_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private BigDecimal fundRewardAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.FUND_REF_ID_REWARD
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String fundRefIdReward;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.FUND_REF_ID_CANCEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String fundRefIdCancel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.FUND_REWARD_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date fundRewardDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.FUND_REWARD_STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String fundRewardStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.FUND_CANCEL_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date fundCancelDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.SERIAL_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String serialNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.TICK_NO
     *
     * @return the value of TLT_CORE_REWARD.TICK_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getTickNo() {
        return tickNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.TICK_NO
     *
     * @param tickNo the value for TLT_CORE_REWARD.TICK_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setTickNo(String tickNo) {
        this.tickNo = tickNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.BET_NO
     *
     * @return the value of TLT_CORE_REWARD.BET_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getBetNo() {
        return betNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.BET_NO
     *
     * @param betNo the value for TLT_CORE_REWARD.BET_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setBetNo(String betNo) {
        this.betNo = betNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.MERCHANTID
     *
     * @return the value of TLT_CORE_REWARD.MERCHANTID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.MERCHANTID
     *
     * @param merchantid the value for TLT_CORE_REWARD.MERCHANTID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.USER_ID
     *
     * @return the value of TLT_CORE_REWARD.USER_ID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.USER_ID
     *
     * @param userId the value for TLT_CORE_REWARD.USER_ID
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.ISSUE_NO
     *
     * @return the value of TLT_CORE_REWARD.ISSUE_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getIssueNo() {
        return issueNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.ISSUE_NO
     *
     * @param issueNo the value for TLT_CORE_REWARD.ISSUE_NO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setIssueNo(BigDecimal issueNo) {
        this.issueNo = issueNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.LTYPE
     *
     * @return the value of TLT_CORE_REWARD.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.LTYPE
     *
     * @param ltype the value for TLT_CORE_REWARD.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.PLAY_TYPE
     *
     * @return the value of TLT_CORE_REWARD.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getPlayType() {
        return playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.PLAY_TYPE
     *
     * @param playType the value for TLT_CORE_REWARD.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setPlayType(String playType) {
        this.playType = playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.CREATE_DATE
     *
     * @return the value of TLT_CORE_REWARD.CREATE_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.CREATE_DATE
     *
     * @param createDate the value for TLT_CORE_REWARD.CREATE_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.MODIFY_DATE
     *
     * @return the value of TLT_CORE_REWARD.MODIFY_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.MODIFY_DATE
     *
     * @param modifyDate the value for TLT_CORE_REWARD.MODIFY_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.BET_AMOUNT
     *
     * @return the value of TLT_CORE_REWARD.BET_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getBetAmount() {
        return betAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.BET_AMOUNT
     *
     * @param betAmount the value for TLT_CORE_REWARD.BET_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.BET_COUNTS
     *
     * @return the value of TLT_CORE_REWARD.BET_COUNTS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getBetCounts() {
        return betCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.BET_COUNTS
     *
     * @param betCounts the value for TLT_CORE_REWARD.BET_COUNTS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setBetCounts(BigDecimal betCounts) {
        this.betCounts = betCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.REWARD_AMOUNT
     *
     * @return the value of TLT_CORE_REWARD.REWARD_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.REWARD_AMOUNT
     *
     * @param rewardAmount the value for TLT_CORE_REWARD.REWARD_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.REWARD_RATIO
     *
     * @return the value of TLT_CORE_REWARD.REWARD_RATIO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getRewardRatio() {
        return rewardRatio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.REWARD_RATIO
     *
     * @param rewardRatio the value for TLT_CORE_REWARD.REWARD_RATIO
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setRewardRatio(BigDecimal rewardRatio) {
        this.rewardRatio = rewardRatio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.FUND_REWARD_AMOUNT
     *
     * @return the value of TLT_CORE_REWARD.FUND_REWARD_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public BigDecimal getFundRewardAmount() {
        return fundRewardAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.FUND_REWARD_AMOUNT
     *
     * @param fundRewardAmount the value for TLT_CORE_REWARD.FUND_REWARD_AMOUNT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundRewardAmount(BigDecimal fundRewardAmount) {
        this.fundRewardAmount = fundRewardAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.FUND_REF_ID_REWARD
     *
     * @return the value of TLT_CORE_REWARD.FUND_REF_ID_REWARD
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getFundRefIdReward() {
        return fundRefIdReward;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.FUND_REF_ID_REWARD
     *
     * @param fundRefIdReward the value for TLT_CORE_REWARD.FUND_REF_ID_REWARD
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundRefIdReward(String fundRefIdReward) {
        this.fundRefIdReward = fundRefIdReward;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.FUND_REF_ID_CANCEL
     *
     * @return the value of TLT_CORE_REWARD.FUND_REF_ID_CANCEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getFundRefIdCancel() {
        return fundRefIdCancel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.FUND_REF_ID_CANCEL
     *
     * @param fundRefIdCancel the value for TLT_CORE_REWARD.FUND_REF_ID_CANCEL
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundRefIdCancel(String fundRefIdCancel) {
        this.fundRefIdCancel = fundRefIdCancel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.FUND_REWARD_DATE
     *
     * @return the value of TLT_CORE_REWARD.FUND_REWARD_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getFundRewardDate() {
        return fundRewardDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.FUND_REWARD_DATE
     *
     * @param fundRewardDate the value for TLT_CORE_REWARD.FUND_REWARD_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundRewardDate(Date fundRewardDate) {
        this.fundRewardDate = fundRewardDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.FUND_REWARD_STATUS
     *
     * @return the value of TLT_CORE_REWARD.FUND_REWARD_STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getFundRewardStatus() {
        return fundRewardStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.FUND_REWARD_STATUS
     *
     * @param fundRewardStatus the value for TLT_CORE_REWARD.FUND_REWARD_STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundRewardStatus(String fundRewardStatus) {
        this.fundRewardStatus = fundRewardStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.FUND_CANCEL_DATE
     *
     * @return the value of TLT_CORE_REWARD.FUND_CANCEL_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getFundCancelDate() {
        return fundCancelDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.FUND_CANCEL_DATE
     *
     * @param fundCancelDate the value for TLT_CORE_REWARD.FUND_CANCEL_DATE
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setFundCancelDate(Date fundCancelDate) {
        this.fundCancelDate = fundCancelDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.SERIAL_NUM
     *
     * @return the value of TLT_CORE_REWARD.SERIAL_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.SERIAL_NUM
     *
     * @param serialNum the value for TLT_CORE_REWARD.SERIAL_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.STATUS
     *
     * @return the value of TLT_CORE_REWARD.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.STATUS
     *
     * @param status the value for TLT_CORE_REWARD.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_REWARD
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
        TLTCoreReward other = (TLTCoreReward) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getTickNo() == null ? other.getTickNo() == null : this.getTickNo().equals(other.getTickNo()))
            && (this.getBetNo() == null ? other.getBetNo() == null : this.getBetNo().equals(other.getBetNo()))
            && (this.getMerchantid() == null ? other.getMerchantid() == null : this.getMerchantid().equals(other.getMerchantid()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIssueNo() == null ? other.getIssueNo() == null : this.getIssueNo().equals(other.getIssueNo()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getPlayType() == null ? other.getPlayType() == null : this.getPlayType().equals(other.getPlayType()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getBetAmount() == null ? other.getBetAmount() == null : this.getBetAmount().equals(other.getBetAmount()))
            && (this.getBetCounts() == null ? other.getBetCounts() == null : this.getBetCounts().equals(other.getBetCounts()))
            && (this.getRewardAmount() == null ? other.getRewardAmount() == null : this.getRewardAmount().equals(other.getRewardAmount()))
            && (this.getRewardRatio() == null ? other.getRewardRatio() == null : this.getRewardRatio().equals(other.getRewardRatio()))
            && (this.getFundRewardAmount() == null ? other.getFundRewardAmount() == null : this.getFundRewardAmount().equals(other.getFundRewardAmount()))
            && (this.getFundRefIdReward() == null ? other.getFundRefIdReward() == null : this.getFundRefIdReward().equals(other.getFundRefIdReward()))
            && (this.getFundRefIdCancel() == null ? other.getFundRefIdCancel() == null : this.getFundRefIdCancel().equals(other.getFundRefIdCancel()))
            && (this.getFundRewardDate() == null ? other.getFundRewardDate() == null : this.getFundRewardDate().equals(other.getFundRewardDate()))
            && (this.getFundRewardStatus() == null ? other.getFundRewardStatus() == null : this.getFundRewardStatus().equals(other.getFundRewardStatus()))
            && (this.getFundCancelDate() == null ? other.getFundCancelDate() == null : this.getFundCancelDate().equals(other.getFundCancelDate()))
            && (this.getSerialNum() == null ? other.getSerialNum() == null : this.getSerialNum().equals(other.getSerialNum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_REWARD
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
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getBetAmount() == null) ? 0 : getBetAmount().hashCode());
        result = prime * result + ((getBetCounts() == null) ? 0 : getBetCounts().hashCode());
        result = prime * result + ((getRewardAmount() == null) ? 0 : getRewardAmount().hashCode());
        result = prime * result + ((getRewardRatio() == null) ? 0 : getRewardRatio().hashCode());
        result = prime * result + ((getFundRewardAmount() == null) ? 0 : getFundRewardAmount().hashCode());
        result = prime * result + ((getFundRefIdReward() == null) ? 0 : getFundRefIdReward().hashCode());
        result = prime * result + ((getFundRefIdCancel() == null) ? 0 : getFundRefIdCancel().hashCode());
        result = prime * result + ((getFundRewardDate() == null) ? 0 : getFundRewardDate().hashCode());
        result = prime * result + ((getFundRewardStatus() == null) ? 0 : getFundRewardStatus().hashCode());
        result = prime * result + ((getFundCancelDate() == null) ? 0 : getFundCancelDate().hashCode());
        result = prime * result + ((getSerialNum() == null) ? 0 : getSerialNum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_REWARD
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
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", betAmount=").append(betAmount);
        sb.append(", betCounts=").append(betCounts);
        sb.append(", rewardAmount=").append(rewardAmount);
        sb.append(", rewardRatio=").append(rewardRatio);
        sb.append(", fundRewardAmount=").append(fundRewardAmount);
        sb.append(", fundRefIdReward=").append(fundRefIdReward);
        sb.append(", fundRefIdCancel=").append(fundRefIdCancel);
        sb.append(", fundRewardDate=").append(fundRewardDate);
        sb.append(", fundRewardStatus=").append(fundRewardStatus);
        sb.append(", fundCancelDate=").append(fundCancelDate);
        sb.append(", serialNum=").append(serialNum);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}