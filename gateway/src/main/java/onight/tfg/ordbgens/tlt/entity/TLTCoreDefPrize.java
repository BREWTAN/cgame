package onight.tfg.ordbgens.tlt.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_CORE_DEF_PRIZE")
@AllArgsConstructor
@NoArgsConstructor
public class TLTCoreDefPrize extends TLTCoreDefPrizeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.CATALOG
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private String catalog;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.LTYPE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.PLAY_TYPE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private String playType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.WIN_LEVEL
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private String winLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.REGION
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private String region;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.DIVISION
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private String division;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.WONBOARDS
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private BigDecimal wonboards;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.WIN_AMOUNT
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private BigDecimal winAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.BONUS_AMOUNT
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private BigDecimal bonusAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.PRIORITY
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private Integer priority;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_DEF_PRIZE.INSERTTIME
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    private Date inserttime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.CATALOG
     *
     * @return the value of TLT_CORE_DEF_PRIZE.CATALOG
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.CATALOG
     *
     * @param catalog the value for TLT_CORE_DEF_PRIZE.CATALOG
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.LTYPE
     *
     * @return the value of TLT_CORE_DEF_PRIZE.LTYPE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.LTYPE
     *
     * @param ltype the value for TLT_CORE_DEF_PRIZE.LTYPE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.PLAY_TYPE
     *
     * @return the value of TLT_CORE_DEF_PRIZE.PLAY_TYPE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public String getPlayType() {
        return playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.PLAY_TYPE
     *
     * @param playType the value for TLT_CORE_DEF_PRIZE.PLAY_TYPE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setPlayType(String playType) {
        this.playType = playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.WIN_LEVEL
     *
     * @return the value of TLT_CORE_DEF_PRIZE.WIN_LEVEL
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public String getWinLevel() {
        return winLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.WIN_LEVEL
     *
     * @param winLevel the value for TLT_CORE_DEF_PRIZE.WIN_LEVEL
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setWinLevel(String winLevel) {
        this.winLevel = winLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.REGION
     *
     * @return the value of TLT_CORE_DEF_PRIZE.REGION
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.REGION
     *
     * @param region the value for TLT_CORE_DEF_PRIZE.REGION
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.DIVISION
     *
     * @return the value of TLT_CORE_DEF_PRIZE.DIVISION
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public String getDivision() {
        return division;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.DIVISION
     *
     * @param division the value for TLT_CORE_DEF_PRIZE.DIVISION
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.WONBOARDS
     *
     * @return the value of TLT_CORE_DEF_PRIZE.WONBOARDS
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public BigDecimal getWonboards() {
        return wonboards;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.WONBOARDS
     *
     * @param wonboards the value for TLT_CORE_DEF_PRIZE.WONBOARDS
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setWonboards(BigDecimal wonboards) {
        this.wonboards = wonboards;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.WIN_AMOUNT
     *
     * @return the value of TLT_CORE_DEF_PRIZE.WIN_AMOUNT
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public BigDecimal getWinAmount() {
        return winAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.WIN_AMOUNT
     *
     * @param winAmount the value for TLT_CORE_DEF_PRIZE.WIN_AMOUNT
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setWinAmount(BigDecimal winAmount) {
        this.winAmount = winAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.BONUS_AMOUNT
     *
     * @return the value of TLT_CORE_DEF_PRIZE.BONUS_AMOUNT
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.BONUS_AMOUNT
     *
     * @param bonusAmount the value for TLT_CORE_DEF_PRIZE.BONUS_AMOUNT
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.PRIORITY
     *
     * @return the value of TLT_CORE_DEF_PRIZE.PRIORITY
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.PRIORITY
     *
     * @param priority the value for TLT_CORE_DEF_PRIZE.PRIORITY
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_DEF_PRIZE.INSERTTIME
     *
     * @return the value of TLT_CORE_DEF_PRIZE.INSERTTIME
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public Date getInserttime() {
        return inserttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_DEF_PRIZE.INSERTTIME
     *
     * @param inserttime the value for TLT_CORE_DEF_PRIZE.INSERTTIME
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_DEF_PRIZE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
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
        TLTCoreDefPrize other = (TLTCoreDefPrize) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCatalog() == null ? other.getCatalog() == null : this.getCatalog().equals(other.getCatalog()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getPlayType() == null ? other.getPlayType() == null : this.getPlayType().equals(other.getPlayType()))
            && (this.getWinLevel() == null ? other.getWinLevel() == null : this.getWinLevel().equals(other.getWinLevel()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getDivision() == null ? other.getDivision() == null : this.getDivision().equals(other.getDivision()))
            && (this.getWonboards() == null ? other.getWonboards() == null : this.getWonboards().equals(other.getWonboards()))
            && (this.getWinAmount() == null ? other.getWinAmount() == null : this.getWinAmount().equals(other.getWinAmount()))
            && (this.getBonusAmount() == null ? other.getBonusAmount() == null : this.getBonusAmount().equals(other.getBonusAmount()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_DEF_PRIZE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getCatalog() == null) ? 0 : getCatalog().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getPlayType() == null) ? 0 : getPlayType().hashCode());
        result = prime * result + ((getWinLevel() == null) ? 0 : getWinLevel().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getDivision() == null) ? 0 : getDivision().hashCode());
        result = prime * result + ((getWonboards() == null) ? 0 : getWonboards().hashCode());
        result = prime * result + ((getWinAmount() == null) ? 0 : getWinAmount().hashCode());
        result = prime * result + ((getBonusAmount() == null) ? 0 : getBonusAmount().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_DEF_PRIZE
     *
     * @mbggenerated Sat Apr 16 00:19:00 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", catalog=").append(catalog);
        sb.append(", ltype=").append(ltype);
        sb.append(", playType=").append(playType);
        sb.append(", winLevel=").append(winLevel);
        sb.append(", region=").append(region);
        sb.append(", division=").append(division);
        sb.append(", wonboards=").append(wonboards);
        sb.append(", winAmount=").append(winAmount);
        sb.append(", bonusAmount=").append(bonusAmount);
        sb.append(", priority=").append(priority);
        sb.append(", inserttime=").append(inserttime);
        sb.append("]");
        return sb.toString();
    }
}