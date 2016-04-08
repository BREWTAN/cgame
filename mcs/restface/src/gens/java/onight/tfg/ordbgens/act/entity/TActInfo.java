package onight.tfg.ordbgens.act.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="T_ACT_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class TActInfo extends TActInfoKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String actName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.CUST_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String custId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.MCHNT_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String mchntId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String actType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.MNY_SMB
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String mnySmb;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.CHANNEL_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String channelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.CATALOG
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String catalog;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_YINIT_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private BigDecimal actYinitBal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_DINIT_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private BigDecimal actDinitBal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_CUR_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private BigDecimal actCurBal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_STAT
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private BigDecimal actStat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_MAXOD_AMT
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private BigDecimal actMaxodAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_CTRL_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private BigDecimal actCtrlBal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.ACT_BAL_WARN_FLAG
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String actBalWarnFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.CREATE_TIME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.UPDATE_TIME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.MODIFY_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String modifyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INFO.MEMO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    private String memo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_NAME
     *
     * @return the value of T_ACT_INFO.ACT_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getActName() {
        return actName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_NAME
     *
     * @param actName the value for T_ACT_INFO.ACT_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActName(String actName) {
        this.actName = actName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.CUST_ID
     *
     * @return the value of T_ACT_INFO.CUST_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getCustId() {
        return custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.CUST_ID
     *
     * @param custId the value for T_ACT_INFO.CUST_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.MCHNT_ID
     *
     * @return the value of T_ACT_INFO.MCHNT_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getMchntId() {
        return mchntId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.MCHNT_ID
     *
     * @param mchntId the value for T_ACT_INFO.MCHNT_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setMchntId(String mchntId) {
        this.mchntId = mchntId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_TYPE
     *
     * @return the value of T_ACT_INFO.ACT_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getActType() {
        return actType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_TYPE
     *
     * @param actType the value for T_ACT_INFO.ACT_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActType(String actType) {
        this.actType = actType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.MNY_SMB
     *
     * @return the value of T_ACT_INFO.MNY_SMB
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getMnySmb() {
        return mnySmb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.MNY_SMB
     *
     * @param mnySmb the value for T_ACT_INFO.MNY_SMB
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setMnySmb(String mnySmb) {
        this.mnySmb = mnySmb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.CHANNEL_ID
     *
     * @return the value of T_ACT_INFO.CHANNEL_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.CHANNEL_ID
     *
     * @param channelId the value for T_ACT_INFO.CHANNEL_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.CATALOG
     *
     * @return the value of T_ACT_INFO.CATALOG
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.CATALOG
     *
     * @param catalog the value for T_ACT_INFO.CATALOG
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_YINIT_BAL
     *
     * @return the value of T_ACT_INFO.ACT_YINIT_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public BigDecimal getActYinitBal() {
        return actYinitBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_YINIT_BAL
     *
     * @param actYinitBal the value for T_ACT_INFO.ACT_YINIT_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActYinitBal(BigDecimal actYinitBal) {
        this.actYinitBal = actYinitBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_DINIT_BAL
     *
     * @return the value of T_ACT_INFO.ACT_DINIT_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public BigDecimal getActDinitBal() {
        return actDinitBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_DINIT_BAL
     *
     * @param actDinitBal the value for T_ACT_INFO.ACT_DINIT_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActDinitBal(BigDecimal actDinitBal) {
        this.actDinitBal = actDinitBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_CUR_BAL
     *
     * @return the value of T_ACT_INFO.ACT_CUR_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public BigDecimal getActCurBal() {
        return actCurBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_CUR_BAL
     *
     * @param actCurBal the value for T_ACT_INFO.ACT_CUR_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActCurBal(BigDecimal actCurBal) {
        this.actCurBal = actCurBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_STAT
     *
     * @return the value of T_ACT_INFO.ACT_STAT
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public BigDecimal getActStat() {
        return actStat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_STAT
     *
     * @param actStat the value for T_ACT_INFO.ACT_STAT
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActStat(BigDecimal actStat) {
        this.actStat = actStat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_MAXOD_AMT
     *
     * @return the value of T_ACT_INFO.ACT_MAXOD_AMT
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public BigDecimal getActMaxodAmt() {
        return actMaxodAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_MAXOD_AMT
     *
     * @param actMaxodAmt the value for T_ACT_INFO.ACT_MAXOD_AMT
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActMaxodAmt(BigDecimal actMaxodAmt) {
        this.actMaxodAmt = actMaxodAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_CTRL_BAL
     *
     * @return the value of T_ACT_INFO.ACT_CTRL_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public BigDecimal getActCtrlBal() {
        return actCtrlBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_CTRL_BAL
     *
     * @param actCtrlBal the value for T_ACT_INFO.ACT_CTRL_BAL
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActCtrlBal(BigDecimal actCtrlBal) {
        this.actCtrlBal = actCtrlBal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.ACT_BAL_WARN_FLAG
     *
     * @return the value of T_ACT_INFO.ACT_BAL_WARN_FLAG
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getActBalWarnFlag() {
        return actBalWarnFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.ACT_BAL_WARN_FLAG
     *
     * @param actBalWarnFlag the value for T_ACT_INFO.ACT_BAL_WARN_FLAG
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setActBalWarnFlag(String actBalWarnFlag) {
        this.actBalWarnFlag = actBalWarnFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.CREATE_TIME
     *
     * @return the value of T_ACT_INFO.CREATE_TIME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.CREATE_TIME
     *
     * @param createTime the value for T_ACT_INFO.CREATE_TIME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.UPDATE_TIME
     *
     * @return the value of T_ACT_INFO.UPDATE_TIME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.UPDATE_TIME
     *
     * @param updateTime the value for T_ACT_INFO.UPDATE_TIME
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.MODIFY_ID
     *
     * @return the value of T_ACT_INFO.MODIFY_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getModifyId() {
        return modifyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.MODIFY_ID
     *
     * @param modifyId the value for T_ACT_INFO.MODIFY_ID
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INFO.MEMO
     *
     * @return the value of T_ACT_INFO.MEMO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INFO.MEMO
     *
     * @param memo the value for T_ACT_INFO.MEMO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
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
        TActInfo other = (TActInfo) that;
        return (this.getActNo() == null ? other.getActNo() == null : this.getActNo().equals(other.getActNo()))
            && (this.getActName() == null ? other.getActName() == null : this.getActName().equals(other.getActName()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getMchntId() == null ? other.getMchntId() == null : this.getMchntId().equals(other.getMchntId()))
            && (this.getActType() == null ? other.getActType() == null : this.getActType().equals(other.getActType()))
            && (this.getMnySmb() == null ? other.getMnySmb() == null : this.getMnySmb().equals(other.getMnySmb()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getCatalog() == null ? other.getCatalog() == null : this.getCatalog().equals(other.getCatalog()))
            && (this.getActYinitBal() == null ? other.getActYinitBal() == null : this.getActYinitBal().equals(other.getActYinitBal()))
            && (this.getActDinitBal() == null ? other.getActDinitBal() == null : this.getActDinitBal().equals(other.getActDinitBal()))
            && (this.getActCurBal() == null ? other.getActCurBal() == null : this.getActCurBal().equals(other.getActCurBal()))
            && (this.getActStat() == null ? other.getActStat() == null : this.getActStat().equals(other.getActStat()))
            && (this.getActMaxodAmt() == null ? other.getActMaxodAmt() == null : this.getActMaxodAmt().equals(other.getActMaxodAmt()))
            && (this.getActCtrlBal() == null ? other.getActCtrlBal() == null : this.getActCtrlBal().equals(other.getActCtrlBal()))
            && (this.getActBalWarnFlag() == null ? other.getActBalWarnFlag() == null : this.getActBalWarnFlag().equals(other.getActBalWarnFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getModifyId() == null ? other.getModifyId() == null : this.getModifyId().equals(other.getModifyId()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActNo() == null) ? 0 : getActNo().hashCode());
        result = prime * result + ((getActName() == null) ? 0 : getActName().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getMchntId() == null) ? 0 : getMchntId().hashCode());
        result = prime * result + ((getActType() == null) ? 0 : getActType().hashCode());
        result = prime * result + ((getMnySmb() == null) ? 0 : getMnySmb().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getCatalog() == null) ? 0 : getCatalog().hashCode());
        result = prime * result + ((getActYinitBal() == null) ? 0 : getActYinitBal().hashCode());
        result = prime * result + ((getActDinitBal() == null) ? 0 : getActDinitBal().hashCode());
        result = prime * result + ((getActCurBal() == null) ? 0 : getActCurBal().hashCode());
        result = prime * result + ((getActStat() == null) ? 0 : getActStat().hashCode());
        result = prime * result + ((getActMaxodAmt() == null) ? 0 : getActMaxodAmt().hashCode());
        result = prime * result + ((getActCtrlBal() == null) ? 0 : getActCtrlBal().hashCode());
        result = prime * result + ((getActBalWarnFlag() == null) ? 0 : getActBalWarnFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getModifyId() == null) ? 0 : getModifyId().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INFO
     *
     * @mbggenerated Thu Apr 07 21:43:54 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", actName=").append(actName);
        sb.append(", custId=").append(custId);
        sb.append(", mchntId=").append(mchntId);
        sb.append(", actType=").append(actType);
        sb.append(", mnySmb=").append(mnySmb);
        sb.append(", channelId=").append(channelId);
        sb.append(", catalog=").append(catalog);
        sb.append(", actYinitBal=").append(actYinitBal);
        sb.append(", actDinitBal=").append(actDinitBal);
        sb.append(", actCurBal=").append(actCurBal);
        sb.append(", actStat=").append(actStat);
        sb.append(", actMaxodAmt=").append(actMaxodAmt);
        sb.append(", actCtrlBal=").append(actCtrlBal);
        sb.append(", actBalWarnFlag=").append(actBalWarnFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", modifyId=").append(modifyId);
        sb.append(", memo=").append(memo);
        sb.append("]");
        return sb.toString();
    }
}