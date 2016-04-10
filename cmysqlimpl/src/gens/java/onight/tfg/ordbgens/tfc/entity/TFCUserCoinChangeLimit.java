package onight.tfg.ordbgens.tfc.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_USER_COIN_CHANGE_LIMIT")
@AllArgsConstructor
@NoArgsConstructor
public class TFCUserCoinChangeLimit extends TFCUserCoinChangeLimitKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_COIN_CHANGE_LIMIT.IN_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Long inNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_COIN_CHANGE_LIMIT.OUT_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Long outNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_COIN_CHANGE_LIMIT.CHANGE_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Long changeNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_COIN_CHANGE_LIMIT.LASTUPDATETIME
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date lastupdatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_COIN_CHANGE_LIMIT.RESETTIME
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    private Date resettime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_COIN_CHANGE_LIMIT.IN_NUM
     *
     * @return the value of TFC_USER_COIN_CHANGE_LIMIT.IN_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Long getInNum() {
        return inNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_COIN_CHANGE_LIMIT.IN_NUM
     *
     * @param inNum the value for TFC_USER_COIN_CHANGE_LIMIT.IN_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setInNum(Long inNum) {
        this.inNum = inNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_COIN_CHANGE_LIMIT.OUT_NUM
     *
     * @return the value of TFC_USER_COIN_CHANGE_LIMIT.OUT_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Long getOutNum() {
        return outNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_COIN_CHANGE_LIMIT.OUT_NUM
     *
     * @param outNum the value for TFC_USER_COIN_CHANGE_LIMIT.OUT_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setOutNum(Long outNum) {
        this.outNum = outNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_COIN_CHANGE_LIMIT.CHANGE_NUM
     *
     * @return the value of TFC_USER_COIN_CHANGE_LIMIT.CHANGE_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Long getChangeNum() {
        return changeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_COIN_CHANGE_LIMIT.CHANGE_NUM
     *
     * @param changeNum the value for TFC_USER_COIN_CHANGE_LIMIT.CHANGE_NUM
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setChangeNum(Long changeNum) {
        this.changeNum = changeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_COIN_CHANGE_LIMIT.LASTUPDATETIME
     *
     * @return the value of TFC_USER_COIN_CHANGE_LIMIT.LASTUPDATETIME
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_COIN_CHANGE_LIMIT.LASTUPDATETIME
     *
     * @param lastupdatetime the value for TFC_USER_COIN_CHANGE_LIMIT.LASTUPDATETIME
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_COIN_CHANGE_LIMIT.RESETTIME
     *
     * @return the value of TFC_USER_COIN_CHANGE_LIMIT.RESETTIME
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public Date getResettime() {
        return resettime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_COIN_CHANGE_LIMIT.RESETTIME
     *
     * @param resettime the value for TFC_USER_COIN_CHANGE_LIMIT.RESETTIME
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    public void setResettime(Date resettime) {
        this.resettime = resettime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
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
        TFCUserCoinChangeLimit other = (TFCUserCoinChangeLimit) that;
        return (this.getCoinRowId() == null ? other.getCoinRowId() == null : this.getCoinRowId().equals(other.getCoinRowId()))
            && (this.getInNum() == null ? other.getInNum() == null : this.getInNum().equals(other.getInNum()))
            && (this.getOutNum() == null ? other.getOutNum() == null : this.getOutNum().equals(other.getOutNum()))
            && (this.getChangeNum() == null ? other.getChangeNum() == null : this.getChangeNum().equals(other.getChangeNum()))
            && (this.getLastupdatetime() == null ? other.getLastupdatetime() == null : this.getLastupdatetime().equals(other.getLastupdatetime()))
            && (this.getResettime() == null ? other.getResettime() == null : this.getResettime().equals(other.getResettime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCoinRowId() == null) ? 0 : getCoinRowId().hashCode());
        result = prime * result + ((getInNum() == null) ? 0 : getInNum().hashCode());
        result = prime * result + ((getOutNum() == null) ? 0 : getOutNum().hashCode());
        result = prime * result + ((getChangeNum() == null) ? 0 : getChangeNum().hashCode());
        result = prime * result + ((getLastupdatetime() == null) ? 0 : getLastupdatetime().hashCode());
        result = prime * result + ((getResettime() == null) ? 0 : getResettime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN_CHANGE_LIMIT
     *
     * @mbggenerated Sun Apr 10 12:52:14 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", inNum=").append(inNum);
        sb.append(", outNum=").append(outNum);
        sb.append(", changeNum=").append(changeNum);
        sb.append(", lastupdatetime=").append(lastupdatetime);
        sb.append(", resettime=").append(resettime);
        sb.append("]");
        return sb.toString();
    }
}