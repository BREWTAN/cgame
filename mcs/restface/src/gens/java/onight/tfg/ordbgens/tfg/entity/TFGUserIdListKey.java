package onight.tfg.ordbgens.tfg.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFGUserIdListKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_ID_LIST.USER_ID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    private Long userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_ID_LIST.USER_ID
     *
     * @return the value of TFG_USER_ID_LIST.USER_ID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_ID_LIST.USER_ID
     *
     * @param userId the value for TFG_USER_ID_LIST.USER_ID
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
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
        TFGUserIdListKey other = (TFGUserIdListKey) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Wed Apr 06 22:53:31 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}