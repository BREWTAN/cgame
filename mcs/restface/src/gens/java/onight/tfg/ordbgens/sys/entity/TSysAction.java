package onight.tfg.ordbgens.sys.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="T_SYS_ACTION")
@AllArgsConstructor
@NoArgsConstructor
public class TSysAction extends TSysActionKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ACTION.ACTION_FLAG
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private String actionFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ACTION.ACTION_NAME
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private String actionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ACTION.ACTION_DESC
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private String actionDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ACTION.ACTION_MENU
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private Long actionMenu;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ACTION.FIELD1
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private String field1;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ACTION.ACTION_FLAG
     *
     * @return the value of T_SYS_ACTION.ACTION_FLAG
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public String getActionFlag() {
        return actionFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ACTION.ACTION_FLAG
     *
     * @param actionFlag the value for T_SYS_ACTION.ACTION_FLAG
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setActionFlag(String actionFlag) {
        this.actionFlag = actionFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ACTION.ACTION_NAME
     *
     * @return the value of T_SYS_ACTION.ACTION_NAME
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ACTION.ACTION_NAME
     *
     * @param actionName the value for T_SYS_ACTION.ACTION_NAME
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ACTION.ACTION_DESC
     *
     * @return the value of T_SYS_ACTION.ACTION_DESC
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public String getActionDesc() {
        return actionDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ACTION.ACTION_DESC
     *
     * @param actionDesc the value for T_SYS_ACTION.ACTION_DESC
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ACTION.ACTION_MENU
     *
     * @return the value of T_SYS_ACTION.ACTION_MENU
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public Long getActionMenu() {
        return actionMenu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ACTION.ACTION_MENU
     *
     * @param actionMenu the value for T_SYS_ACTION.ACTION_MENU
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setActionMenu(Long actionMenu) {
        this.actionMenu = actionMenu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ACTION.FIELD1
     *
     * @return the value of T_SYS_ACTION.FIELD1
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public String getField1() {
        return field1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ACTION.FIELD1
     *
     * @param field1 the value for T_SYS_ACTION.FIELD1
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setField1(String field1) {
        this.field1 = field1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
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
        TSysAction other = (TSysAction) that;
        return (this.getActionId() == null ? other.getActionId() == null : this.getActionId().equals(other.getActionId()))
            && (this.getActionFlag() == null ? other.getActionFlag() == null : this.getActionFlag().equals(other.getActionFlag()))
            && (this.getActionName() == null ? other.getActionName() == null : this.getActionName().equals(other.getActionName()))
            && (this.getActionDesc() == null ? other.getActionDesc() == null : this.getActionDesc().equals(other.getActionDesc()))
            && (this.getActionMenu() == null ? other.getActionMenu() == null : this.getActionMenu().equals(other.getActionMenu()))
            && (this.getField1() == null ? other.getField1() == null : this.getField1().equals(other.getField1()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActionId() == null) ? 0 : getActionId().hashCode());
        result = prime * result + ((getActionFlag() == null) ? 0 : getActionFlag().hashCode());
        result = prime * result + ((getActionName() == null) ? 0 : getActionName().hashCode());
        result = prime * result + ((getActionDesc() == null) ? 0 : getActionDesc().hashCode());
        result = prime * result + ((getActionMenu() == null) ? 0 : getActionMenu().hashCode());
        result = prime * result + ((getField1() == null) ? 0 : getField1().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ACTION
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", actionFlag=").append(actionFlag);
        sb.append(", actionName=").append(actionName);
        sb.append(", actionDesc=").append(actionDesc);
        sb.append(", actionMenu=").append(actionMenu);
        sb.append(", field1=").append(field1);
        sb.append("]");
        return sb.toString();
    }
}