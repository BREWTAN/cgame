package onight.tfg.ordbgens.tfg.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFGGroupKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_GROUP.GROUP_ID
     *
     * @mbggenerated Thu Apr 14 00:28:10 CST 2016
     */
    private String groupId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_GROUP.GROUP_ID
     *
     * @return the value of TFG_GROUP.GROUP_ID
     *
     * @mbggenerated Thu Apr 14 00:28:10 CST 2016
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_GROUP.GROUP_ID
     *
     * @param groupId the value for TFG_GROUP.GROUP_ID
     *
     * @mbggenerated Thu Apr 14 00:28:10 CST 2016
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:10 CST 2016
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
        TFGGroupKey other = (TFGGroupKey) that;
        return (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:10 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 14 00:28:10 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", groupId=").append(groupId);
        sb.append("]");
        return sb.toString();
    }
}