package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_PLAYGROUP")
@AllArgsConstructor
@NoArgsConstructor
public class TLTPlaygroup extends TLTPlaygroupKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String playType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.CN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String cnName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.EN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String enName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.LOCK_TABLE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String lockTable;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.AWARD_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private Integer awardLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.COST
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private Float cost;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.ENABLE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private Boolean enable;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.REMARK
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.REBATE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private Float rebate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.DELO_REBATE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private Float deloRebate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.VIEWGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String viewgroup;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.LTYPE
     *
     * @return the value of TLT_PLAYGROUP.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.LTYPE
     *
     * @param ltype the value for TLT_PLAYGROUP.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.PLAY_TYPE
     *
     * @return the value of TLT_PLAYGROUP.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getPlayType() {
        return playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.PLAY_TYPE
     *
     * @param playType the value for TLT_PLAYGROUP.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setPlayType(String playType) {
        this.playType = playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.CN_NAME
     *
     * @return the value of TLT_PLAYGROUP.CN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.CN_NAME
     *
     * @param cnName the value for TLT_PLAYGROUP.CN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.EN_NAME
     *
     * @return the value of TLT_PLAYGROUP.EN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getEnName() {
        return enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.EN_NAME
     *
     * @param enName the value for TLT_PLAYGROUP.EN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.LOCK_TABLE
     *
     * @return the value of TLT_PLAYGROUP.LOCK_TABLE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getLockTable() {
        return lockTable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.LOCK_TABLE
     *
     * @param lockTable the value for TLT_PLAYGROUP.LOCK_TABLE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setLockTable(String lockTable) {
        this.lockTable = lockTable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.AWARD_LEVEL
     *
     * @return the value of TLT_PLAYGROUP.AWARD_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public Integer getAwardLevel() {
        return awardLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.AWARD_LEVEL
     *
     * @param awardLevel the value for TLT_PLAYGROUP.AWARD_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setAwardLevel(Integer awardLevel) {
        this.awardLevel = awardLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.COST
     *
     * @return the value of TLT_PLAYGROUP.COST
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public Float getCost() {
        return cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.COST
     *
     * @param cost the value for TLT_PLAYGROUP.COST
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.ENABLE
     *
     * @return the value of TLT_PLAYGROUP.ENABLE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.ENABLE
     *
     * @param enable the value for TLT_PLAYGROUP.ENABLE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.REMARK
     *
     * @return the value of TLT_PLAYGROUP.REMARK
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.REMARK
     *
     * @param remark the value for TLT_PLAYGROUP.REMARK
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.REBATE
     *
     * @return the value of TLT_PLAYGROUP.REBATE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public Float getRebate() {
        return rebate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.REBATE
     *
     * @param rebate the value for TLT_PLAYGROUP.REBATE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setRebate(Float rebate) {
        this.rebate = rebate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.DELO_REBATE
     *
     * @return the value of TLT_PLAYGROUP.DELO_REBATE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public Float getDeloRebate() {
        return deloRebate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.DELO_REBATE
     *
     * @param deloRebate the value for TLT_PLAYGROUP.DELO_REBATE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setDeloRebate(Float deloRebate) {
        this.deloRebate = deloRebate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.VIEWGROUP
     *
     * @return the value of TLT_PLAYGROUP.VIEWGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getViewgroup() {
        return viewgroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.VIEWGROUP
     *
     * @param viewgroup the value for TLT_PLAYGROUP.VIEWGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setViewgroup(String viewgroup) {
        this.viewgroup = viewgroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
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
        TLTPlaygroup other = (TLTPlaygroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getPlayType() == null ? other.getPlayType() == null : this.getPlayType().equals(other.getPlayType()))
            && (this.getCnName() == null ? other.getCnName() == null : this.getCnName().equals(other.getCnName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getLockTable() == null ? other.getLockTable() == null : this.getLockTable().equals(other.getLockTable()))
            && (this.getAwardLevel() == null ? other.getAwardLevel() == null : this.getAwardLevel().equals(other.getAwardLevel()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRebate() == null ? other.getRebate() == null : this.getRebate().equals(other.getRebate()))
            && (this.getDeloRebate() == null ? other.getDeloRebate() == null : this.getDeloRebate().equals(other.getDeloRebate()))
            && (this.getViewgroup() == null ? other.getViewgroup() == null : this.getViewgroup().equals(other.getViewgroup()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getPlayType() == null) ? 0 : getPlayType().hashCode());
        result = prime * result + ((getCnName() == null) ? 0 : getCnName().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getLockTable() == null) ? 0 : getLockTable().hashCode());
        result = prime * result + ((getAwardLevel() == null) ? 0 : getAwardLevel().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRebate() == null) ? 0 : getRebate().hashCode());
        result = prime * result + ((getDeloRebate() == null) ? 0 : getDeloRebate().hashCode());
        result = prime * result + ((getViewgroup() == null) ? 0 : getViewgroup().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ltype=").append(ltype);
        sb.append(", playType=").append(playType);
        sb.append(", cnName=").append(cnName);
        sb.append(", enName=").append(enName);
        sb.append(", lockTable=").append(lockTable);
        sb.append(", awardLevel=").append(awardLevel);
        sb.append(", cost=").append(cost);
        sb.append(", enable=").append(enable);
        sb.append(", remark=").append(remark);
        sb.append(", rebate=").append(rebate);
        sb.append(", deloRebate=").append(deloRebate);
        sb.append(", viewgroup=").append(viewgroup);
        sb.append("]");
        return sb.toString();
    }
}