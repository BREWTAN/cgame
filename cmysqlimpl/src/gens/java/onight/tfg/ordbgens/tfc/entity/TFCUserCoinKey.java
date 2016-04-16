package onight.tfg.ordbgens.tfc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFCUserCoinKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_COIN.COIN_ROWID
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    private String coinRowid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_COIN.COIN_ROWID
     *
     * @return the value of TFC_USER_COIN.COIN_ROWID
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public String getCoinRowid() {
        return coinRowid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_COIN.COIN_ROWID
     *
     * @param coinRowid the value for TFC_USER_COIN.COIN_ROWID
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public void setCoinRowid(String coinRowid) {
        this.coinRowid = coinRowid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
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
        TFCUserCoinKey other = (TFCUserCoinKey) that;
        return (this.getCoinRowid() == null ? other.getCoinRowid() == null : this.getCoinRowid().equals(other.getCoinRowid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCoinRowid() == null) ? 0 : getCoinRowid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_COIN
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coinRowid=").append(coinRowid);
        sb.append("]");
        return sb.toString();
    }
}