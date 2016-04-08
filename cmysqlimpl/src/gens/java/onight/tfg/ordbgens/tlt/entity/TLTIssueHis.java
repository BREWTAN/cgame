package onight.tfg.ordbgens.tlt.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_ISSUE_HIS")
@AllArgsConstructor
@NoArgsConstructor
public class TLTIssueHis extends TLTIssueHisKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.ISSUE_NO
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private String issueNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.LOTTERY_NO
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private String lotteryNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.ISSUE_DATE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private String issueDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.PRE_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date preStime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.PRE_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date preEtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.SALE_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date saleStime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.SALE_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date saleEtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.REAL_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date realStime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.REAL_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date realEtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.CANCEL_LTIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date cancelLtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.CLOSESHARE_DATE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date closeshareDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.REBATE_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Integer rebateStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.WIN_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Integer winStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.SEND_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Integer sendStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.AUTOBET_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Integer autobetStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.LOCK_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Integer lockStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.PROCESS_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Integer processStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.CREATE_TIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.MODIFY_TIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_HIS.STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.LTYPE
     *
     * @return the value of TLT_ISSUE_HIS.LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.LTYPE
     *
     * @param ltype the value for TLT_ISSUE_HIS.LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.ISSUE_NO
     *
     * @return the value of TLT_ISSUE_HIS.ISSUE_NO
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public String getIssueNo() {
        return issueNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.ISSUE_NO
     *
     * @param issueNo the value for TLT_ISSUE_HIS.ISSUE_NO
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.LOTTERY_NO
     *
     * @return the value of TLT_ISSUE_HIS.LOTTERY_NO
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public String getLotteryNo() {
        return lotteryNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.LOTTERY_NO
     *
     * @param lotteryNo the value for TLT_ISSUE_HIS.LOTTERY_NO
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setLotteryNo(String lotteryNo) {
        this.lotteryNo = lotteryNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.ISSUE_DATE
     *
     * @return the value of TLT_ISSUE_HIS.ISSUE_DATE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.ISSUE_DATE
     *
     * @param issueDate the value for TLT_ISSUE_HIS.ISSUE_DATE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.PRE_STIME
     *
     * @return the value of TLT_ISSUE_HIS.PRE_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getPreStime() {
        return preStime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.PRE_STIME
     *
     * @param preStime the value for TLT_ISSUE_HIS.PRE_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setPreStime(Date preStime) {
        this.preStime = preStime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.PRE_ETIME
     *
     * @return the value of TLT_ISSUE_HIS.PRE_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getPreEtime() {
        return preEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.PRE_ETIME
     *
     * @param preEtime the value for TLT_ISSUE_HIS.PRE_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setPreEtime(Date preEtime) {
        this.preEtime = preEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.SALE_STIME
     *
     * @return the value of TLT_ISSUE_HIS.SALE_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getSaleStime() {
        return saleStime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.SALE_STIME
     *
     * @param saleStime the value for TLT_ISSUE_HIS.SALE_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setSaleStime(Date saleStime) {
        this.saleStime = saleStime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.SALE_ETIME
     *
     * @return the value of TLT_ISSUE_HIS.SALE_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getSaleEtime() {
        return saleEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.SALE_ETIME
     *
     * @param saleEtime the value for TLT_ISSUE_HIS.SALE_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setSaleEtime(Date saleEtime) {
        this.saleEtime = saleEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.REAL_STIME
     *
     * @return the value of TLT_ISSUE_HIS.REAL_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getRealStime() {
        return realStime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.REAL_STIME
     *
     * @param realStime the value for TLT_ISSUE_HIS.REAL_STIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setRealStime(Date realStime) {
        this.realStime = realStime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.REAL_ETIME
     *
     * @return the value of TLT_ISSUE_HIS.REAL_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getRealEtime() {
        return realEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.REAL_ETIME
     *
     * @param realEtime the value for TLT_ISSUE_HIS.REAL_ETIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setRealEtime(Date realEtime) {
        this.realEtime = realEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.CANCEL_LTIME
     *
     * @return the value of TLT_ISSUE_HIS.CANCEL_LTIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getCancelLtime() {
        return cancelLtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.CANCEL_LTIME
     *
     * @param cancelLtime the value for TLT_ISSUE_HIS.CANCEL_LTIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setCancelLtime(Date cancelLtime) {
        this.cancelLtime = cancelLtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.CLOSESHARE_DATE
     *
     * @return the value of TLT_ISSUE_HIS.CLOSESHARE_DATE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getCloseshareDate() {
        return closeshareDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.CLOSESHARE_DATE
     *
     * @param closeshareDate the value for TLT_ISSUE_HIS.CLOSESHARE_DATE
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setCloseshareDate(Date closeshareDate) {
        this.closeshareDate = closeshareDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.REBATE_STATUS
     *
     * @return the value of TLT_ISSUE_HIS.REBATE_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Integer getRebateStatus() {
        return rebateStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.REBATE_STATUS
     *
     * @param rebateStatus the value for TLT_ISSUE_HIS.REBATE_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setRebateStatus(Integer rebateStatus) {
        this.rebateStatus = rebateStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.WIN_STATUS
     *
     * @return the value of TLT_ISSUE_HIS.WIN_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Integer getWinStatus() {
        return winStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.WIN_STATUS
     *
     * @param winStatus the value for TLT_ISSUE_HIS.WIN_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setWinStatus(Integer winStatus) {
        this.winStatus = winStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.SEND_STATUS
     *
     * @return the value of TLT_ISSUE_HIS.SEND_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.SEND_STATUS
     *
     * @param sendStatus the value for TLT_ISSUE_HIS.SEND_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.AUTOBET_STATUS
     *
     * @return the value of TLT_ISSUE_HIS.AUTOBET_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Integer getAutobetStatus() {
        return autobetStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.AUTOBET_STATUS
     *
     * @param autobetStatus the value for TLT_ISSUE_HIS.AUTOBET_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setAutobetStatus(Integer autobetStatus) {
        this.autobetStatus = autobetStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.LOCK_STATUS
     *
     * @return the value of TLT_ISSUE_HIS.LOCK_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Integer getLockStatus() {
        return lockStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.LOCK_STATUS
     *
     * @param lockStatus the value for TLT_ISSUE_HIS.LOCK_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.PROCESS_STATUS
     *
     * @return the value of TLT_ISSUE_HIS.PROCESS_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Integer getProcessStatus() {
        return processStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.PROCESS_STATUS
     *
     * @param processStatus the value for TLT_ISSUE_HIS.PROCESS_STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.CREATE_TIME
     *
     * @return the value of TLT_ISSUE_HIS.CREATE_TIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.CREATE_TIME
     *
     * @param createTime the value for TLT_ISSUE_HIS.CREATE_TIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.MODIFY_TIME
     *
     * @return the value of TLT_ISSUE_HIS.MODIFY_TIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.MODIFY_TIME
     *
     * @param modifyTime the value for TLT_ISSUE_HIS.MODIFY_TIME
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_HIS.STATUS
     *
     * @return the value of TLT_ISSUE_HIS.STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_HIS.STATUS
     *
     * @param status the value for TLT_ISSUE_HIS.STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
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
        TLTIssueHis other = (TLTIssueHis) that;
        return (this.getIssueId() == null ? other.getIssueId() == null : this.getIssueId().equals(other.getIssueId()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getIssueNo() == null ? other.getIssueNo() == null : this.getIssueNo().equals(other.getIssueNo()))
            && (this.getLotteryNo() == null ? other.getLotteryNo() == null : this.getLotteryNo().equals(other.getLotteryNo()))
            && (this.getIssueDate() == null ? other.getIssueDate() == null : this.getIssueDate().equals(other.getIssueDate()))
            && (this.getPreStime() == null ? other.getPreStime() == null : this.getPreStime().equals(other.getPreStime()))
            && (this.getPreEtime() == null ? other.getPreEtime() == null : this.getPreEtime().equals(other.getPreEtime()))
            && (this.getSaleStime() == null ? other.getSaleStime() == null : this.getSaleStime().equals(other.getSaleStime()))
            && (this.getSaleEtime() == null ? other.getSaleEtime() == null : this.getSaleEtime().equals(other.getSaleEtime()))
            && (this.getRealStime() == null ? other.getRealStime() == null : this.getRealStime().equals(other.getRealStime()))
            && (this.getRealEtime() == null ? other.getRealEtime() == null : this.getRealEtime().equals(other.getRealEtime()))
            && (this.getCancelLtime() == null ? other.getCancelLtime() == null : this.getCancelLtime().equals(other.getCancelLtime()))
            && (this.getCloseshareDate() == null ? other.getCloseshareDate() == null : this.getCloseshareDate().equals(other.getCloseshareDate()))
            && (this.getRebateStatus() == null ? other.getRebateStatus() == null : this.getRebateStatus().equals(other.getRebateStatus()))
            && (this.getWinStatus() == null ? other.getWinStatus() == null : this.getWinStatus().equals(other.getWinStatus()))
            && (this.getSendStatus() == null ? other.getSendStatus() == null : this.getSendStatus().equals(other.getSendStatus()))
            && (this.getAutobetStatus() == null ? other.getAutobetStatus() == null : this.getAutobetStatus().equals(other.getAutobetStatus()))
            && (this.getLockStatus() == null ? other.getLockStatus() == null : this.getLockStatus().equals(other.getLockStatus()))
            && (this.getProcessStatus() == null ? other.getProcessStatus() == null : this.getProcessStatus().equals(other.getProcessStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIssueId() == null) ? 0 : getIssueId().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getIssueNo() == null) ? 0 : getIssueNo().hashCode());
        result = prime * result + ((getLotteryNo() == null) ? 0 : getLotteryNo().hashCode());
        result = prime * result + ((getIssueDate() == null) ? 0 : getIssueDate().hashCode());
        result = prime * result + ((getPreStime() == null) ? 0 : getPreStime().hashCode());
        result = prime * result + ((getPreEtime() == null) ? 0 : getPreEtime().hashCode());
        result = prime * result + ((getSaleStime() == null) ? 0 : getSaleStime().hashCode());
        result = prime * result + ((getSaleEtime() == null) ? 0 : getSaleEtime().hashCode());
        result = prime * result + ((getRealStime() == null) ? 0 : getRealStime().hashCode());
        result = prime * result + ((getRealEtime() == null) ? 0 : getRealEtime().hashCode());
        result = prime * result + ((getCancelLtime() == null) ? 0 : getCancelLtime().hashCode());
        result = prime * result + ((getCloseshareDate() == null) ? 0 : getCloseshareDate().hashCode());
        result = prime * result + ((getRebateStatus() == null) ? 0 : getRebateStatus().hashCode());
        result = prime * result + ((getWinStatus() == null) ? 0 : getWinStatus().hashCode());
        result = prime * result + ((getSendStatus() == null) ? 0 : getSendStatus().hashCode());
        result = prime * result + ((getAutobetStatus() == null) ? 0 : getAutobetStatus().hashCode());
        result = prime * result + ((getLockStatus() == null) ? 0 : getLockStatus().hashCode());
        result = prime * result + ((getProcessStatus() == null) ? 0 : getProcessStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_HIS
     *
     * @mbggenerated Thu Apr 07 23:51:52 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ltype=").append(ltype);
        sb.append(", issueNo=").append(issueNo);
        sb.append(", lotteryNo=").append(lotteryNo);
        sb.append(", issueDate=").append(issueDate);
        sb.append(", preStime=").append(preStime);
        sb.append(", preEtime=").append(preEtime);
        sb.append(", saleStime=").append(saleStime);
        sb.append(", saleEtime=").append(saleEtime);
        sb.append(", realStime=").append(realStime);
        sb.append(", realEtime=").append(realEtime);
        sb.append(", cancelLtime=").append(cancelLtime);
        sb.append(", closeshareDate=").append(closeshareDate);
        sb.append(", rebateStatus=").append(rebateStatus);
        sb.append(", winStatus=").append(winStatus);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", autobetStatus=").append(autobetStatus);
        sb.append(", lockStatus=").append(lockStatus);
        sb.append(", processStatus=").append(processStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}