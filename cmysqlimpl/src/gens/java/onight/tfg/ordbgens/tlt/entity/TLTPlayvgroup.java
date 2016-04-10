package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_PLAYVGROUP")
@AllArgsConstructor
@NoArgsConstructor
public class TLTPlayvgroup extends TLTPlayvgroupKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYVGROUP.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYVGROUP.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String playType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYVGROUP.CN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String cnName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYVGROUP.EN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private String enName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYVGROUP.DEFAULT_PG
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private Integer defaultPg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYVGROUP.LTYPE
     *
     * @return the value of TLT_PLAYVGROUP.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYVGROUP.LTYPE
     *
     * @param ltype the value for TLT_PLAYVGROUP.LTYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYVGROUP.PLAY_TYPE
     *
     * @return the value of TLT_PLAYVGROUP.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getPlayType() {
        return playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYVGROUP.PLAY_TYPE
     *
     * @param playType the value for TLT_PLAYVGROUP.PLAY_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setPlayType(String playType) {
        this.playType = playType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYVGROUP.CN_NAME
     *
     * @return the value of TLT_PLAYVGROUP.CN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYVGROUP.CN_NAME
     *
     * @param cnName the value for TLT_PLAYVGROUP.CN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYVGROUP.EN_NAME
     *
     * @return the value of TLT_PLAYVGROUP.EN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public String getEnName() {
        return enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYVGROUP.EN_NAME
     *
     * @param enName the value for TLT_PLAYVGROUP.EN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYVGROUP.DEFAULT_PG
     *
     * @return the value of TLT_PLAYVGROUP.DEFAULT_PG
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public Integer getDefaultPg() {
        return defaultPg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYVGROUP.DEFAULT_PG
     *
     * @param defaultPg the value for TLT_PLAYVGROUP.DEFAULT_PG
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setDefaultPg(Integer defaultPg) {
        this.defaultPg = defaultPg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
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
        TLTPlayvgroup other = (TLTPlayvgroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getPlayType() == null ? other.getPlayType() == null : this.getPlayType().equals(other.getPlayType()))
            && (this.getCnName() == null ? other.getCnName() == null : this.getCnName().equals(other.getCnName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getDefaultPg() == null ? other.getDefaultPg() == null : this.getDefaultPg().equals(other.getDefaultPg()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
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
        result = prime * result + ((getDefaultPg() == null) ? 0 : getDefaultPg().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYVGROUP
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
        sb.append(", defaultPg=").append(defaultPg);
        sb.append("]");
        return sb.toString();
    }
}