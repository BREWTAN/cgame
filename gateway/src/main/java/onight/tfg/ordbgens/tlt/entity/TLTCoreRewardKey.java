package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TLTCoreRewardKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_CORE_REWARD.REWARD_NO
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private String rewardNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_CORE_REWARD.REWARD_NO
     *
     * @return the value of TLT_CORE_REWARD.REWARD_NO
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public String getRewardNo() {
        return rewardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_CORE_REWARD.REWARD_NO
     *
     * @param rewardNo the value for TLT_CORE_REWARD.REWARD_NO
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setRewardNo(String rewardNo) {
        this.rewardNo = rewardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_REWARD
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
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
        TLTCoreRewardKey other = (TLTCoreRewardKey) that;
        return (this.getRewardNo() == null ? other.getRewardNo() == null : this.getRewardNo().equals(other.getRewardNo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_REWARD
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRewardNo() == null) ? 0 : getRewardNo().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_CORE_REWARD
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rewardNo=").append(rewardNo);
        sb.append("]");
        return sb.toString();
    }
}