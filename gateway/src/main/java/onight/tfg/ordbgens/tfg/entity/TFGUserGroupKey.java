package onight.tfg.ordbgens.tfg.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFGUserGroupKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_GROUP.USER_GROUP_ID
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    private String userGroupId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_GROUP.USER_GROUP_ID
     *
     * @return the value of TFG_USER_GROUP.USER_GROUP_ID
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public String getUserGroupId() {
        return userGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_GROUP.USER_GROUP_ID
     *
     * @param userGroupId the value for TFG_USER_GROUP.USER_GROUP_ID
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
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
        TFGUserGroupKey other = (TFGUserGroupKey) that;
        return (this.getUserGroupId() == null ? other.getUserGroupId() == null : this.getUserGroupId().equals(other.getUserGroupId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserGroupId() == null) ? 0 : getUserGroupId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_GROUP
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userGroupId=").append(userGroupId);
        sb.append("]");
        return sb.toString();
    }
}