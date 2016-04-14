package onight.tfg.ordbgens.tfc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFCCoinTypeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_COIN_TYPE.COIN_TYPE_ID
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    private String coinTypeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_COIN_TYPE.COIN_TYPE_ID
     *
     * @return the value of TFC_COIN_TYPE.COIN_TYPE_ID
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    public String getCoinTypeId() {
        return coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_COIN_TYPE.COIN_TYPE_ID
     *
     * @param coinTypeId the value for TFC_COIN_TYPE.COIN_TYPE_ID
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    public void setCoinTypeId(String coinTypeId) {
        this.coinTypeId = coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
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
        TFCCoinTypeKey other = (TFCCoinTypeKey) that;
        return (this.getCoinTypeId() == null ? other.getCoinTypeId() == null : this.getCoinTypeId().equals(other.getCoinTypeId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCoinTypeId() == null) ? 0 : getCoinTypeId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_COIN_TYPE
     *
     * @mbggenerated Thu Apr 14 00:28:13 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coinTypeId=").append(coinTypeId);
        sb.append("]");
        return sb.toString();
    }
}