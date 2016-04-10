package onight.tfg.ordbgens.tfc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_COIN_TYPE")
@AllArgsConstructor
@NoArgsConstructor
public class TFCCoinType extends TFCCoinTypeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_COIN_TYPE.COIN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    private String coinName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_COIN_TYPE.COIN_SCRIPT
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    private String coinScript;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_COIN_TYPE.HAVE_CHILD
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    private Integer haveChild;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_COIN_TYPE.CAN_SPLIT
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    private Integer canSplit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_COIN_TYPE.USE_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    private Integer useLevel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_COIN_TYPE.COIN_NAME
     *
     * @return the value of TFC_COIN_TYPE.COIN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public String getCoinName() {
        return coinName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_COIN_TYPE.COIN_NAME
     *
     * @param coinName the value for TFC_COIN_TYPE.COIN_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_COIN_TYPE.COIN_SCRIPT
     *
     * @return the value of TFC_COIN_TYPE.COIN_SCRIPT
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public String getCoinScript() {
        return coinScript;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_COIN_TYPE.COIN_SCRIPT
     *
     * @param coinScript the value for TFC_COIN_TYPE.COIN_SCRIPT
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void setCoinScript(String coinScript) {
        this.coinScript = coinScript;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_COIN_TYPE.HAVE_CHILD
     *
     * @return the value of TFC_COIN_TYPE.HAVE_CHILD
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public Integer getHaveChild() {
        return haveChild;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_COIN_TYPE.HAVE_CHILD
     *
     * @param haveChild the value for TFC_COIN_TYPE.HAVE_CHILD
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void setHaveChild(Integer haveChild) {
        this.haveChild = haveChild;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_COIN_TYPE.CAN_SPLIT
     *
     * @return the value of TFC_COIN_TYPE.CAN_SPLIT
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public Integer getCanSplit() {
        return canSplit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_COIN_TYPE.CAN_SPLIT
     *
     * @param canSplit the value for TFC_COIN_TYPE.CAN_SPLIT
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void setCanSplit(Integer canSplit) {
        this.canSplit = canSplit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_COIN_TYPE.USE_LEVEL
     *
     * @return the value of TFC_COIN_TYPE.USE_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public Integer getUseLevel() {
        return useLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_COIN_TYPE.USE_LEVEL
     *
     * @param useLevel the value for TFC_COIN_TYPE.USE_LEVEL
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void setUseLevel(Integer useLevel) {
        this.useLevel = useLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
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
        TFCCoinType other = (TFCCoinType) that;
        return (this.getCoinTypeId() == null ? other.getCoinTypeId() == null : this.getCoinTypeId().equals(other.getCoinTypeId()))
            && (this.getCoinName() == null ? other.getCoinName() == null : this.getCoinName().equals(other.getCoinName()))
            && (this.getCoinScript() == null ? other.getCoinScript() == null : this.getCoinScript().equals(other.getCoinScript()))
            && (this.getHaveChild() == null ? other.getHaveChild() == null : this.getHaveChild().equals(other.getHaveChild()))
            && (this.getCanSplit() == null ? other.getCanSplit() == null : this.getCanSplit().equals(other.getCanSplit()))
            && (this.getUseLevel() == null ? other.getUseLevel() == null : this.getUseLevel().equals(other.getUseLevel()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCoinTypeId() == null) ? 0 : getCoinTypeId().hashCode());
        result = prime * result + ((getCoinName() == null) ? 0 : getCoinName().hashCode());
        result = prime * result + ((getCoinScript() == null) ? 0 : getCoinScript().hashCode());
        result = prime * result + ((getHaveChild() == null) ? 0 : getHaveChild().hashCode());
        result = prime * result + ((getCanSplit() == null) ? 0 : getCanSplit().hashCode());
        result = prime * result + ((getUseLevel() == null) ? 0 : getUseLevel().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coinName=").append(coinName);
        sb.append(", coinScript=").append(coinScript);
        sb.append(", haveChild=").append(haveChild);
        sb.append(", canSplit=").append(canSplit);
        sb.append(", useLevel=").append(useLevel);
        sb.append("]");
        return sb.toString();
    }
}