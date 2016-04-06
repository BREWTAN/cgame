package onight.tfg.ordbgens.tlt.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_CORE_BET")
@AllArgsConstructor
@NoArgsConstructor
public class TLTCoreBet extends TLTCoreBetKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.LTYPE
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.LNAME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String lname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.PLAYTYPE
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String playtype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.MERCHANTID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.SERIALNUM
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String serialnum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.BET_AMOUNT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private BigDecimal betAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.BOARDS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private Short boards;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.MULTI
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private Short multi;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.ISSUE_NO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String issueNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.BET_DATETIME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private Date betDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.BET_CONTENT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String betContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.BET_IP
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String betIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.BET_MOENY_UNIT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private Integer betMoenyUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.VERSION
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.PRINTTIME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private Long printtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.BET_STATUS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private Short betStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.NOTIFYSTATUS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private Short notifystatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.REGION
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String region;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.FAILREASON
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String failreason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.MERCHANTUSERID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String merchantuserid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.USER_ID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.AUTOBET_NO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String autobetNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.IS_AUTO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String isAuto;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.AUTO_REF_TICKNO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private String autoRefTickno;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.LTYPE
     *
     * @return the value of TLT_CORE_BET.LTYPE
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.LTYPE
     *
     * @param ltype the value for TLT_CORE_BET.LTYPE
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.LNAME
     *
     * @return the value of TLT_CORE_BET.LNAME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getLname() {
        return lname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.LNAME
     *
     * @param lname the value for TLT_CORE_BET.LNAME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.PLAYTYPE
     *
     * @return the value of TLT_CORE_BET.PLAYTYPE
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getPlaytype() {
        return playtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.PLAYTYPE
     *
     * @param playtype the value for TLT_CORE_BET.PLAYTYPE
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setPlaytype(String playtype) {
        this.playtype = playtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.MERCHANTID
     *
     * @return the value of TLT_CORE_BET.MERCHANTID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.MERCHANTID
     *
     * @param merchantid the value for TLT_CORE_BET.MERCHANTID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.SERIALNUM
     *
     * @return the value of TLT_CORE_BET.SERIALNUM
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getSerialnum() {
        return serialnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.SERIALNUM
     *
     * @param serialnum the value for TLT_CORE_BET.SERIALNUM
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.BET_AMOUNT
     *
     * @return the value of TLT_CORE_BET.BET_AMOUNT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public BigDecimal getBetAmount() {
        return betAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.BET_AMOUNT
     *
     * @param betAmount the value for TLT_CORE_BET.BET_AMOUNT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.BOARDS
     *
     * @return the value of TLT_CORE_BET.BOARDS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public Short getBoards() {
        return boards;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.BOARDS
     *
     * @param boards the value for TLT_CORE_BET.BOARDS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setBoards(Short boards) {
        this.boards = boards;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.MULTI
     *
     * @return the value of TLT_CORE_BET.MULTI
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public Short getMulti() {
        return multi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.MULTI
     *
     * @param multi the value for TLT_CORE_BET.MULTI
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setMulti(Short multi) {
        this.multi = multi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.ISSUE_NO
     *
     * @return the value of TLT_CORE_BET.ISSUE_NO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getIssueNo() {
        return issueNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.ISSUE_NO
     *
     * @param issueNo the value for TLT_CORE_BET.ISSUE_NO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.BET_DATETIME
     *
     * @return the value of TLT_CORE_BET.BET_DATETIME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public Date getBetDatetime() {
        return betDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.BET_DATETIME
     *
     * @param betDatetime the value for TLT_CORE_BET.BET_DATETIME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setBetDatetime(Date betDatetime) {
        this.betDatetime = betDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.BET_CONTENT
     *
     * @return the value of TLT_CORE_BET.BET_CONTENT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getBetContent() {
        return betContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.BET_CONTENT
     *
     * @param betContent the value for TLT_CORE_BET.BET_CONTENT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setBetContent(String betContent) {
        this.betContent = betContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.BET_IP
     *
     * @return the value of TLT_CORE_BET.BET_IP
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getBetIp() {
        return betIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.BET_IP
     *
     * @param betIp the value for TLT_CORE_BET.BET_IP
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setBetIp(String betIp) {
        this.betIp = betIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.BET_MOENY_UNIT
     *
     * @return the value of TLT_CORE_BET.BET_MOENY_UNIT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public Integer getBetMoenyUnit() {
        return betMoenyUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.BET_MOENY_UNIT
     *
     * @param betMoenyUnit the value for TLT_CORE_BET.BET_MOENY_UNIT
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setBetMoenyUnit(Integer betMoenyUnit) {
        this.betMoenyUnit = betMoenyUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.VERSION
     *
     * @return the value of TLT_CORE_BET.VERSION
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.VERSION
     *
     * @param version the value for TLT_CORE_BET.VERSION
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.PRINTTIME
     *
     * @return the value of TLT_CORE_BET.PRINTTIME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public Long getPrinttime() {
        return printtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.PRINTTIME
     *
     * @param printtime the value for TLT_CORE_BET.PRINTTIME
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setPrinttime(Long printtime) {
        this.printtime = printtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.BET_STATUS
     *
     * @return the value of TLT_CORE_BET.BET_STATUS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public Short getBetStatus() {
        return betStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.BET_STATUS
     *
     * @param betStatus the value for TLT_CORE_BET.BET_STATUS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setBetStatus(Short betStatus) {
        this.betStatus = betStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.NOTIFYSTATUS
     *
     * @return the value of TLT_CORE_BET.NOTIFYSTATUS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public Short getNotifystatus() {
        return notifystatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.NOTIFYSTATUS
     *
     * @param notifystatus the value for TLT_CORE_BET.NOTIFYSTATUS
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setNotifystatus(Short notifystatus) {
        this.notifystatus = notifystatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.REGION
     *
     * @return the value of TLT_CORE_BET.REGION
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.REGION
     *
     * @param region the value for TLT_CORE_BET.REGION
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.FAILREASON
     *
     * @return the value of TLT_CORE_BET.FAILREASON
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getFailreason() {
        return failreason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.FAILREASON
     *
     * @param failreason the value for TLT_CORE_BET.FAILREASON
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setFailreason(String failreason) {
        this.failreason = failreason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.MERCHANTUSERID
     *
     * @return the value of TLT_CORE_BET.MERCHANTUSERID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getMerchantuserid() {
        return merchantuserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.MERCHANTUSERID
     *
     * @param merchantuserid the value for TLT_CORE_BET.MERCHANTUSERID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setMerchantuserid(String merchantuserid) {
        this.merchantuserid = merchantuserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.USER_ID
     *
     * @return the value of TLT_CORE_BET.USER_ID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.USER_ID
     *
     * @param userId the value for TLT_CORE_BET.USER_ID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.AUTOBET_NO
     *
     * @return the value of TLT_CORE_BET.AUTOBET_NO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getAutobetNo() {
        return autobetNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.AUTOBET_NO
     *
     * @param autobetNo the value for TLT_CORE_BET.AUTOBET_NO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setAutobetNo(String autobetNo) {
        this.autobetNo = autobetNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.IS_AUTO
     *
     * @return the value of TLT_CORE_BET.IS_AUTO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getIsAuto() {
        return isAuto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.IS_AUTO
     *
     * @param isAuto the value for TLT_CORE_BET.IS_AUTO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setIsAuto(String isAuto) {
        this.isAuto = isAuto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.AUTO_REF_TICKNO
     *
     * @return the value of TLT_CORE_BET.AUTO_REF_TICKNO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public String getAutoRefTickno() {
        return autoRefTickno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.AUTO_REF_TICKNO
     *
     * @param autoRefTickno the value for TLT_CORE_BET.AUTO_REF_TICKNO
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setAutoRefTickno(String autoRefTickno) {
        this.autoRefTickno = autoRefTickno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
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
        TLTCoreBet other = (TLTCoreBet) that;
        return (this.getTickNo() == null ? other.getTickNo() == null : this.getTickNo().equals(other.getTickNo()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getLname() == null ? other.getLname() == null : this.getLname().equals(other.getLname()))
            && (this.getPlaytype() == null ? other.getPlaytype() == null : this.getPlaytype().equals(other.getPlaytype()))
            && (this.getMerchantid() == null ? other.getMerchantid() == null : this.getMerchantid().equals(other.getMerchantid()))
            && (this.getSerialnum() == null ? other.getSerialnum() == null : this.getSerialnum().equals(other.getSerialnum()))
            && (this.getBetAmount() == null ? other.getBetAmount() == null : this.getBetAmount().equals(other.getBetAmount()))
            && (this.getBoards() == null ? other.getBoards() == null : this.getBoards().equals(other.getBoards()))
            && (this.getMulti() == null ? other.getMulti() == null : this.getMulti().equals(other.getMulti()))
            && (this.getIssueNo() == null ? other.getIssueNo() == null : this.getIssueNo().equals(other.getIssueNo()))
            && (this.getBetDatetime() == null ? other.getBetDatetime() == null : this.getBetDatetime().equals(other.getBetDatetime()))
            && (this.getBetContent() == null ? other.getBetContent() == null : this.getBetContent().equals(other.getBetContent()))
            && (this.getBetIp() == null ? other.getBetIp() == null : this.getBetIp().equals(other.getBetIp()))
            && (this.getBetMoenyUnit() == null ? other.getBetMoenyUnit() == null : this.getBetMoenyUnit().equals(other.getBetMoenyUnit()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getPrinttime() == null ? other.getPrinttime() == null : this.getPrinttime().equals(other.getPrinttime()))
            && (this.getBetStatus() == null ? other.getBetStatus() == null : this.getBetStatus().equals(other.getBetStatus()))
            && (this.getNotifystatus() == null ? other.getNotifystatus() == null : this.getNotifystatus().equals(other.getNotifystatus()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getFailreason() == null ? other.getFailreason() == null : this.getFailreason().equals(other.getFailreason()))
            && (this.getMerchantuserid() == null ? other.getMerchantuserid() == null : this.getMerchantuserid().equals(other.getMerchantuserid()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAutobetNo() == null ? other.getAutobetNo() == null : this.getAutobetNo().equals(other.getAutobetNo()))
            && (this.getIsAuto() == null ? other.getIsAuto() == null : this.getIsAuto().equals(other.getIsAuto()))
            && (this.getAutoRefTickno() == null ? other.getAutoRefTickno() == null : this.getAutoRefTickno().equals(other.getAutoRefTickno()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTickNo() == null) ? 0 : getTickNo().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getLname() == null) ? 0 : getLname().hashCode());
        result = prime * result + ((getPlaytype() == null) ? 0 : getPlaytype().hashCode());
        result = prime * result + ((getMerchantid() == null) ? 0 : getMerchantid().hashCode());
        result = prime * result + ((getSerialnum() == null) ? 0 : getSerialnum().hashCode());
        result = prime * result + ((getBetAmount() == null) ? 0 : getBetAmount().hashCode());
        result = prime * result + ((getBoards() == null) ? 0 : getBoards().hashCode());
        result = prime * result + ((getMulti() == null) ? 0 : getMulti().hashCode());
        result = prime * result + ((getIssueNo() == null) ? 0 : getIssueNo().hashCode());
        result = prime * result + ((getBetDatetime() == null) ? 0 : getBetDatetime().hashCode());
        result = prime * result + ((getBetContent() == null) ? 0 : getBetContent().hashCode());
        result = prime * result + ((getBetIp() == null) ? 0 : getBetIp().hashCode());
        result = prime * result + ((getBetMoenyUnit() == null) ? 0 : getBetMoenyUnit().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getPrinttime() == null) ? 0 : getPrinttime().hashCode());
        result = prime * result + ((getBetStatus() == null) ? 0 : getBetStatus().hashCode());
        result = prime * result + ((getNotifystatus() == null) ? 0 : getNotifystatus().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getFailreason() == null) ? 0 : getFailreason().hashCode());
        result = prime * result + ((getMerchantuserid() == null) ? 0 : getMerchantuserid().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAutobetNo() == null) ? 0 : getAutobetNo().hashCode());
        result = prime * result + ((getIsAuto() == null) ? 0 : getIsAuto().hashCode());
        result = prime * result + ((getAutoRefTickno() == null) ? 0 : getAutoRefTickno().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ltype=").append(ltype);
        sb.append(", lname=").append(lname);
        sb.append(", playtype=").append(playtype);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", serialnum=").append(serialnum);
        sb.append(", betAmount=").append(betAmount);
        sb.append(", boards=").append(boards);
        sb.append(", multi=").append(multi);
        sb.append(", issueNo=").append(issueNo);
        sb.append(", betDatetime=").append(betDatetime);
        sb.append(", betContent=").append(betContent);
        sb.append(", betIp=").append(betIp);
        sb.append(", betMoenyUnit=").append(betMoenyUnit);
        sb.append(", version=").append(version);
        sb.append(", printtime=").append(printtime);
        sb.append(", betStatus=").append(betStatus);
        sb.append(", notifystatus=").append(notifystatus);
        sb.append(", region=").append(region);
        sb.append(", failreason=").append(failreason);
        sb.append(", merchantuserid=").append(merchantuserid);
        sb.append(", userId=").append(userId);
        sb.append(", autobetNo=").append(autobetNo);
        sb.append(", isAuto=").append(isAuto);
        sb.append(", autoRefTickno=").append(autoRefTickno);
        sb.append("]");
        return sb.toString();
    }
}