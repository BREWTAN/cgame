package onight.tfg.ordbgens.sys.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TSysRoleMenuKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ROLE_MENU.ID
     *
     * @mbggenerated Thu Apr 07 23:51:50 CST 2016
     */
    private String id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ROLE_MENU.ID
     *
     * @return the value of T_SYS_ROLE_MENU.ID
     *
     * @mbggenerated Thu Apr 07 23:51:50 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ROLE_MENU.ID
     *
     * @param id the value for T_SYS_ROLE_MENU.ID
     *
     * @mbggenerated Thu Apr 07 23:51:50 CST 2016
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Thu Apr 07 23:51:50 CST 2016
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
        TSysRoleMenuKey other = (TSysRoleMenuKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Thu Apr 07 23:51:50 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Thu Apr 07 23:51:50 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}