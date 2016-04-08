package onight.tfg.ordbgens.tfg.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFG_GROUP")
@AllArgsConstructor
@NoArgsConstructor
public class TFGGroup extends TFGGroupKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_GROUP.PARENT_GROUP_ID
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String parentGroupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_GROUP.GROUP_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String groupName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_GROUP.GROUP_DESC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String groupDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_GROUP.STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_GROUP.PARENT_GROUP_ID
     *
     * @return the value of TFG_GROUP.PARENT_GROUP_ID
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getParentGroupId() {
        return parentGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_GROUP.PARENT_GROUP_ID
     *
     * @param parentGroupId the value for TFG_GROUP.PARENT_GROUP_ID
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setParentGroupId(String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_GROUP.GROUP_NAME
     *
     * @return the value of TFG_GROUP.GROUP_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_GROUP.GROUP_NAME
     *
     * @param groupName the value for TFG_GROUP.GROUP_NAME
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_GROUP.GROUP_DESC
     *
     * @return the value of TFG_GROUP.GROUP_DESC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_GROUP.GROUP_DESC
     *
     * @param groupDesc the value for TFG_GROUP.GROUP_DESC
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_GROUP.STATUS
     *
     * @return the value of TFG_GROUP.STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_GROUP.STATUS
     *
     * @param status the value for TFG_GROUP.STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
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
        TFGGroup other = (TFGGroup) that;
        return (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getParentGroupId() == null ? other.getParentGroupId() == null : this.getParentGroupId().equals(other.getParentGroupId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getGroupDesc() == null ? other.getGroupDesc() == null : this.getGroupDesc().equals(other.getGroupDesc()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getParentGroupId() == null) ? 0 : getParentGroupId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getGroupDesc() == null) ? 0 : getGroupDesc().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_GROUP
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", parentGroupId=").append(parentGroupId);
        sb.append(", groupName=").append(groupName);
        sb.append(", groupDesc=").append(groupDesc);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}