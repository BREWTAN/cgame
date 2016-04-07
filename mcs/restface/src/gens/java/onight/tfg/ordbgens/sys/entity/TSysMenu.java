package onight.tfg.ordbgens.sys.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="T_SYS_MENU")
@AllArgsConstructor
@NoArgsConstructor
public class TSysMenu extends TSysMenuKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_MENU.MENU_NAME
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private String menuName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_MENU.MENU_DESC
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private String menuDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_MENU.MENU_SEQ
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private Integer menuSeq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_MENU.MENU_URL
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private String menuUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_MENU.PARENT_ID
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private Integer parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_MENU.LEAF_FLAG
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private Integer leafFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_MENU.LEVEL
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_MENU.ICON
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    private String icon;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_MENU.MENU_NAME
     *
     * @return the value of T_SYS_MENU.MENU_NAME
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_MENU.MENU_NAME
     *
     * @param menuName the value for T_SYS_MENU.MENU_NAME
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_MENU.MENU_DESC
     *
     * @return the value of T_SYS_MENU.MENU_DESC
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_MENU.MENU_DESC
     *
     * @param menuDesc the value for T_SYS_MENU.MENU_DESC
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_MENU.MENU_SEQ
     *
     * @return the value of T_SYS_MENU.MENU_SEQ
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public Integer getMenuSeq() {
        return menuSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_MENU.MENU_SEQ
     *
     * @param menuSeq the value for T_SYS_MENU.MENU_SEQ
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setMenuSeq(Integer menuSeq) {
        this.menuSeq = menuSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_MENU.MENU_URL
     *
     * @return the value of T_SYS_MENU.MENU_URL
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_MENU.MENU_URL
     *
     * @param menuUrl the value for T_SYS_MENU.MENU_URL
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_MENU.PARENT_ID
     *
     * @return the value of T_SYS_MENU.PARENT_ID
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_MENU.PARENT_ID
     *
     * @param parentId the value for T_SYS_MENU.PARENT_ID
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_MENU.LEAF_FLAG
     *
     * @return the value of T_SYS_MENU.LEAF_FLAG
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public Integer getLeafFlag() {
        return leafFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_MENU.LEAF_FLAG
     *
     * @param leafFlag the value for T_SYS_MENU.LEAF_FLAG
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setLeafFlag(Integer leafFlag) {
        this.leafFlag = leafFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_MENU.LEVEL
     *
     * @return the value of T_SYS_MENU.LEVEL
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_MENU.LEVEL
     *
     * @param level the value for T_SYS_MENU.LEVEL
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_MENU.ICON
     *
     * @return the value of T_SYS_MENU.ICON
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_MENU.ICON
     *
     * @param icon the value for T_SYS_MENU.ICON
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_MENU
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
        TSysMenu other = (TSysMenu) that;
        return (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuDesc() == null ? other.getMenuDesc() == null : this.getMenuDesc().equals(other.getMenuDesc()))
            && (this.getMenuSeq() == null ? other.getMenuSeq() == null : this.getMenuSeq().equals(other.getMenuSeq()))
            && (this.getMenuUrl() == null ? other.getMenuUrl() == null : this.getMenuUrl().equals(other.getMenuUrl()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getLeafFlag() == null ? other.getLeafFlag() == null : this.getLeafFlag().equals(other.getLeafFlag()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_MENU
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuDesc() == null) ? 0 : getMenuDesc().hashCode());
        result = prime * result + ((getMenuSeq() == null) ? 0 : getMenuSeq().hashCode());
        result = prime * result + ((getMenuUrl() == null) ? 0 : getMenuUrl().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getLeafFlag() == null) ? 0 : getLeafFlag().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_MENU
     *
     * @mbggenerated Thu Apr 07 13:37:30 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuName=").append(menuName);
        sb.append(", menuDesc=").append(menuDesc);
        sb.append(", menuSeq=").append(menuSeq);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", parentId=").append(parentId);
        sb.append(", leafFlag=").append(leafFlag);
        sb.append(", level=").append(level);
        sb.append(", icon=").append(icon);
        sb.append("]");
        return sb.toString();
    }
}