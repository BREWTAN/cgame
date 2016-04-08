package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_PLAY_TYPE")
@AllArgsConstructor
@NoArgsConstructor
public class TLTPlayType extends TLTPlayTypeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.GROUP_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String groupType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.LPG_ID
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String lpgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.CN_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String cnName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.EN_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String enName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.LOCK_FUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String lockFunc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.LOCK_TABLE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String lockTable;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.LOCK_STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private Boolean lockStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.MODE_YJFL
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String modeYjfl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.ISANDVALUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private Boolean isandvalue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.MAX_BUY_CODENUM
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private Integer maxBuyCodenum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.WIN_FUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String winFunc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.WIN_BEGINPOS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private Integer winBeginpos;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.WIN_CODENUM
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private Integer winCodenum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.WIN_DISCONTINUOUSPOS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private Integer winDiscontinuouspos;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.WIN_CHECKFUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String winCheckfunc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.WIN_PAYBONUSFUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String winPaybonusfunc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.ENABLE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private Boolean enable;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAY_TYPE.REMARK
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.LTYPE
     *
     * @return the value of TLT_PLAY_TYPE.LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.LTYPE
     *
     * @param ltype the value for TLT_PLAY_TYPE.LTYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.GROUP_TYPE
     *
     * @return the value of TLT_PLAY_TYPE.GROUP_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getGroupType() {
        return groupType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.GROUP_TYPE
     *
     * @param groupType the value for TLT_PLAY_TYPE.GROUP_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.LPG_ID
     *
     * @return the value of TLT_PLAY_TYPE.LPG_ID
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getLpgId() {
        return lpgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.LPG_ID
     *
     * @param lpgId the value for TLT_PLAY_TYPE.LPG_ID
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setLpgId(String lpgId) {
        this.lpgId = lpgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.CN_NAME
     *
     * @return the value of TLT_PLAY_TYPE.CN_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.CN_NAME
     *
     * @param cnName the value for TLT_PLAY_TYPE.CN_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.EN_NAME
     *
     * @return the value of TLT_PLAY_TYPE.EN_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getEnName() {
        return enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.EN_NAME
     *
     * @param enName the value for TLT_PLAY_TYPE.EN_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.LOCK_FUNC
     *
     * @return the value of TLT_PLAY_TYPE.LOCK_FUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getLockFunc() {
        return lockFunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.LOCK_FUNC
     *
     * @param lockFunc the value for TLT_PLAY_TYPE.LOCK_FUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setLockFunc(String lockFunc) {
        this.lockFunc = lockFunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.LOCK_TABLE
     *
     * @return the value of TLT_PLAY_TYPE.LOCK_TABLE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getLockTable() {
        return lockTable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.LOCK_TABLE
     *
     * @param lockTable the value for TLT_PLAY_TYPE.LOCK_TABLE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setLockTable(String lockTable) {
        this.lockTable = lockTable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.LOCK_STATUS
     *
     * @return the value of TLT_PLAY_TYPE.LOCK_STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public Boolean getLockStatus() {
        return lockStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.LOCK_STATUS
     *
     * @param lockStatus the value for TLT_PLAY_TYPE.LOCK_STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setLockStatus(Boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.MODE_YJFL
     *
     * @return the value of TLT_PLAY_TYPE.MODE_YJFL
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getModeYjfl() {
        return modeYjfl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.MODE_YJFL
     *
     * @param modeYjfl the value for TLT_PLAY_TYPE.MODE_YJFL
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setModeYjfl(String modeYjfl) {
        this.modeYjfl = modeYjfl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.ISANDVALUE
     *
     * @return the value of TLT_PLAY_TYPE.ISANDVALUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public Boolean getIsandvalue() {
        return isandvalue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.ISANDVALUE
     *
     * @param isandvalue the value for TLT_PLAY_TYPE.ISANDVALUE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setIsandvalue(Boolean isandvalue) {
        this.isandvalue = isandvalue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.MAX_BUY_CODENUM
     *
     * @return the value of TLT_PLAY_TYPE.MAX_BUY_CODENUM
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public Integer getMaxBuyCodenum() {
        return maxBuyCodenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.MAX_BUY_CODENUM
     *
     * @param maxBuyCodenum the value for TLT_PLAY_TYPE.MAX_BUY_CODENUM
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setMaxBuyCodenum(Integer maxBuyCodenum) {
        this.maxBuyCodenum = maxBuyCodenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.WIN_FUNC
     *
     * @return the value of TLT_PLAY_TYPE.WIN_FUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getWinFunc() {
        return winFunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.WIN_FUNC
     *
     * @param winFunc the value for TLT_PLAY_TYPE.WIN_FUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setWinFunc(String winFunc) {
        this.winFunc = winFunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.WIN_BEGINPOS
     *
     * @return the value of TLT_PLAY_TYPE.WIN_BEGINPOS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public Integer getWinBeginpos() {
        return winBeginpos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.WIN_BEGINPOS
     *
     * @param winBeginpos the value for TLT_PLAY_TYPE.WIN_BEGINPOS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setWinBeginpos(Integer winBeginpos) {
        this.winBeginpos = winBeginpos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.WIN_CODENUM
     *
     * @return the value of TLT_PLAY_TYPE.WIN_CODENUM
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public Integer getWinCodenum() {
        return winCodenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.WIN_CODENUM
     *
     * @param winCodenum the value for TLT_PLAY_TYPE.WIN_CODENUM
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setWinCodenum(Integer winCodenum) {
        this.winCodenum = winCodenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.WIN_DISCONTINUOUSPOS
     *
     * @return the value of TLT_PLAY_TYPE.WIN_DISCONTINUOUSPOS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public Integer getWinDiscontinuouspos() {
        return winDiscontinuouspos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.WIN_DISCONTINUOUSPOS
     *
     * @param winDiscontinuouspos the value for TLT_PLAY_TYPE.WIN_DISCONTINUOUSPOS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setWinDiscontinuouspos(Integer winDiscontinuouspos) {
        this.winDiscontinuouspos = winDiscontinuouspos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.WIN_CHECKFUNC
     *
     * @return the value of TLT_PLAY_TYPE.WIN_CHECKFUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getWinCheckfunc() {
        return winCheckfunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.WIN_CHECKFUNC
     *
     * @param winCheckfunc the value for TLT_PLAY_TYPE.WIN_CHECKFUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setWinCheckfunc(String winCheckfunc) {
        this.winCheckfunc = winCheckfunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.WIN_PAYBONUSFUNC
     *
     * @return the value of TLT_PLAY_TYPE.WIN_PAYBONUSFUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getWinPaybonusfunc() {
        return winPaybonusfunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.WIN_PAYBONUSFUNC
     *
     * @param winPaybonusfunc the value for TLT_PLAY_TYPE.WIN_PAYBONUSFUNC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setWinPaybonusfunc(String winPaybonusfunc) {
        this.winPaybonusfunc = winPaybonusfunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.ENABLE
     *
     * @return the value of TLT_PLAY_TYPE.ENABLE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.ENABLE
     *
     * @param enable the value for TLT_PLAY_TYPE.ENABLE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAY_TYPE.REMARK
     *
     * @return the value of TLT_PLAY_TYPE.REMARK
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAY_TYPE.REMARK
     *
     * @param remark the value for TLT_PLAY_TYPE.REMARK
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
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
        TLTPlayType other = (TLTPlayType) that;
        return (this.getPlayType() == null ? other.getPlayType() == null : this.getPlayType().equals(other.getPlayType()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getGroupType() == null ? other.getGroupType() == null : this.getGroupType().equals(other.getGroupType()))
            && (this.getLpgId() == null ? other.getLpgId() == null : this.getLpgId().equals(other.getLpgId()))
            && (this.getCnName() == null ? other.getCnName() == null : this.getCnName().equals(other.getCnName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getLockFunc() == null ? other.getLockFunc() == null : this.getLockFunc().equals(other.getLockFunc()))
            && (this.getLockTable() == null ? other.getLockTable() == null : this.getLockTable().equals(other.getLockTable()))
            && (this.getLockStatus() == null ? other.getLockStatus() == null : this.getLockStatus().equals(other.getLockStatus()))
            && (this.getModeYjfl() == null ? other.getModeYjfl() == null : this.getModeYjfl().equals(other.getModeYjfl()))
            && (this.getIsandvalue() == null ? other.getIsandvalue() == null : this.getIsandvalue().equals(other.getIsandvalue()))
            && (this.getMaxBuyCodenum() == null ? other.getMaxBuyCodenum() == null : this.getMaxBuyCodenum().equals(other.getMaxBuyCodenum()))
            && (this.getWinFunc() == null ? other.getWinFunc() == null : this.getWinFunc().equals(other.getWinFunc()))
            && (this.getWinBeginpos() == null ? other.getWinBeginpos() == null : this.getWinBeginpos().equals(other.getWinBeginpos()))
            && (this.getWinCodenum() == null ? other.getWinCodenum() == null : this.getWinCodenum().equals(other.getWinCodenum()))
            && (this.getWinDiscontinuouspos() == null ? other.getWinDiscontinuouspos() == null : this.getWinDiscontinuouspos().equals(other.getWinDiscontinuouspos()))
            && (this.getWinCheckfunc() == null ? other.getWinCheckfunc() == null : this.getWinCheckfunc().equals(other.getWinCheckfunc()))
            && (this.getWinPaybonusfunc() == null ? other.getWinPaybonusfunc() == null : this.getWinPaybonusfunc().equals(other.getWinPaybonusfunc()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPlayType() == null) ? 0 : getPlayType().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getGroupType() == null) ? 0 : getGroupType().hashCode());
        result = prime * result + ((getLpgId() == null) ? 0 : getLpgId().hashCode());
        result = prime * result + ((getCnName() == null) ? 0 : getCnName().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getLockFunc() == null) ? 0 : getLockFunc().hashCode());
        result = prime * result + ((getLockTable() == null) ? 0 : getLockTable().hashCode());
        result = prime * result + ((getLockStatus() == null) ? 0 : getLockStatus().hashCode());
        result = prime * result + ((getModeYjfl() == null) ? 0 : getModeYjfl().hashCode());
        result = prime * result + ((getIsandvalue() == null) ? 0 : getIsandvalue().hashCode());
        result = prime * result + ((getMaxBuyCodenum() == null) ? 0 : getMaxBuyCodenum().hashCode());
        result = prime * result + ((getWinFunc() == null) ? 0 : getWinFunc().hashCode());
        result = prime * result + ((getWinBeginpos() == null) ? 0 : getWinBeginpos().hashCode());
        result = prime * result + ((getWinCodenum() == null) ? 0 : getWinCodenum().hashCode());
        result = prime * result + ((getWinDiscontinuouspos() == null) ? 0 : getWinDiscontinuouspos().hashCode());
        result = prime * result + ((getWinCheckfunc() == null) ? 0 : getWinCheckfunc().hashCode());
        result = prime * result + ((getWinPaybonusfunc() == null) ? 0 : getWinPaybonusfunc().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAY_TYPE
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ltype=").append(ltype);
        sb.append(", groupType=").append(groupType);
        sb.append(", lpgId=").append(lpgId);
        sb.append(", cnName=").append(cnName);
        sb.append(", enName=").append(enName);
        sb.append(", lockFunc=").append(lockFunc);
        sb.append(", lockTable=").append(lockTable);
        sb.append(", lockStatus=").append(lockStatus);
        sb.append(", modeYjfl=").append(modeYjfl);
        sb.append(", isandvalue=").append(isandvalue);
        sb.append(", maxBuyCodenum=").append(maxBuyCodenum);
        sb.append(", winFunc=").append(winFunc);
        sb.append(", winBeginpos=").append(winBeginpos);
        sb.append(", winCodenum=").append(winCodenum);
        sb.append(", winDiscontinuouspos=").append(winDiscontinuouspos);
        sb.append(", winCheckfunc=").append(winCheckfunc);
        sb.append(", winPaybonusfunc=").append(winPaybonusfunc);
        sb.append(", enable=").append(enable);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}