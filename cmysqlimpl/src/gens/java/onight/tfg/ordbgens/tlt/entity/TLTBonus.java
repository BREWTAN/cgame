package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_BONUS")
@AllArgsConstructor
@NoArgsConstructor
public class TLTBonus extends TLTBonusKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.BONUSGROUP_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private Long bonusgroupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.PLAY_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private String playType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.LPG_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private Long lpgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.CN_NAME
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private String cnName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.EN_NAME
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private String enName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.BONUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private Float bonus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.BET_NUM
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private Integer betNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.TOTAL_MARGIN
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private Float totalMargin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BONUS.STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.BONUSGROUP_ID
     *
     * @return the value of TLT_BONUS.BONUSGROUP_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public Long getBonusgroupId() {
        return bonusgroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.BONUSGROUP_ID
     *
     * @param bonusgroupId the value for TLT_BONUS.BONUSGROUP_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setBonusgroupId(Long bonusgroupId) {
        this.bonusgroupId = bonusgroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.LTYPE
     *
     * @return the value of TLT_BONUS.LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.LTYPE
     *
     * @param ltype the value for TLT_BONUS.LTYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.PLAY_TYPE
     *
     * @return the value of TLT_BONUS.PLAY_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public String getPlayType() {
        return playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.PLAY_TYPE
     *
     * @param playType the value for TLT_BONUS.PLAY_TYPE
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setPlayType(String playType) {
        this.playType = playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.LPG_ID
     *
     * @return the value of TLT_BONUS.LPG_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public Long getLpgId() {
        return lpgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.LPG_ID
     *
     * @param lpgId the value for TLT_BONUS.LPG_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setLpgId(Long lpgId) {
        this.lpgId = lpgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.CN_NAME
     *
     * @return the value of TLT_BONUS.CN_NAME
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.CN_NAME
     *
     * @param cnName the value for TLT_BONUS.CN_NAME
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.EN_NAME
     *
     * @return the value of TLT_BONUS.EN_NAME
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public String getEnName() {
        return enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.EN_NAME
     *
     * @param enName the value for TLT_BONUS.EN_NAME
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.BONUS
     *
     * @return the value of TLT_BONUS.BONUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public Float getBonus() {
        return bonus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.BONUS
     *
     * @param bonus the value for TLT_BONUS.BONUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.BET_NUM
     *
     * @return the value of TLT_BONUS.BET_NUM
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public Integer getBetNum() {
        return betNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.BET_NUM
     *
     * @param betNum the value for TLT_BONUS.BET_NUM
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setBetNum(Integer betNum) {
        this.betNum = betNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.TOTAL_MARGIN
     *
     * @return the value of TLT_BONUS.TOTAL_MARGIN
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public Float getTotalMargin() {
        return totalMargin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.TOTAL_MARGIN
     *
     * @param totalMargin the value for TLT_BONUS.TOTAL_MARGIN
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setTotalMargin(Float totalMargin) {
        this.totalMargin = totalMargin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BONUS.STATUS
     *
     * @return the value of TLT_BONUS.STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BONUS.STATUS
     *
     * @param status the value for TLT_BONUS.STATUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
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
        TLTBonus other = (TLTBonus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBonusgroupId() == null ? other.getBonusgroupId() == null : this.getBonusgroupId().equals(other.getBonusgroupId()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getPlayType() == null ? other.getPlayType() == null : this.getPlayType().equals(other.getPlayType()))
            && (this.getLpgId() == null ? other.getLpgId() == null : this.getLpgId().equals(other.getLpgId()))
            && (this.getCnName() == null ? other.getCnName() == null : this.getCnName().equals(other.getCnName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getBonus() == null ? other.getBonus() == null : this.getBonus().equals(other.getBonus()))
            && (this.getBetNum() == null ? other.getBetNum() == null : this.getBetNum().equals(other.getBetNum()))
            && (this.getTotalMargin() == null ? other.getTotalMargin() == null : this.getTotalMargin().equals(other.getTotalMargin()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBonusgroupId() == null) ? 0 : getBonusgroupId().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getPlayType() == null) ? 0 : getPlayType().hashCode());
        result = prime * result + ((getLpgId() == null) ? 0 : getLpgId().hashCode());
        result = prime * result + ((getCnName() == null) ? 0 : getCnName().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getBonus() == null) ? 0 : getBonus().hashCode());
        result = prime * result + ((getBetNum() == null) ? 0 : getBetNum().hashCode());
        result = prime * result + ((getTotalMargin() == null) ? 0 : getTotalMargin().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BONUS
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bonusgroupId=").append(bonusgroupId);
        sb.append(", ltype=").append(ltype);
        sb.append(", playType=").append(playType);
        sb.append(", lpgId=").append(lpgId);
        sb.append(", cnName=").append(cnName);
        sb.append(", enName=").append(enName);
        sb.append(", bonus=").append(bonus);
        sb.append(", betNum=").append(betNum);
        sb.append(", totalMargin=").append(totalMargin);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}