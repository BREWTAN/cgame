package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TLTCoreBetKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_BET.BET_NO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    private String betNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_BET.BET_NO
     *
     * @return the value of TLT_CORE_BET.BET_NO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public String getBetNo() {
        return betNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_BET.BET_NO
     *
     * @param betNo the value for TLT_CORE_BET.BET_NO
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    public void setBetNo(String betNo) {
        this.betNo = betNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
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
        TLTCoreBetKey other = (TLTCoreBetKey) that;
        return (this.getBetNo() == null ? other.getBetNo() == null : this.getBetNo().equals(other.getBetNo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBetNo() == null) ? 0 : getBetNo().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_BET
     *
     * @mbggenerated Sat Apr 16 13:41:09 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", betNo=").append(betNo);
        sb.append("]");
        return sb.toString();
    }
}