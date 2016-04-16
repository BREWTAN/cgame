package onight.tfg.ordbgens.sys.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="T_SYS_OP_LOGS")
@AllArgsConstructor
@NoArgsConstructor
public class TSysOpLogs extends TSysOpLogsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_OP_LOGS.SKEYS
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    private String skeys;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_OP_LOGS.CONTENTS
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    private String contents;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_OP_LOGS.LEVEL
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    private String level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_OP_LOGS.CRT_TIME
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    private Date crtTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_OP_LOGS.SKEYS
     *
     * @return the value of T_SYS_OP_LOGS.SKEYS
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public String getSkeys() {
        return skeys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_OP_LOGS.SKEYS
     *
     * @param skeys the value for T_SYS_OP_LOGS.SKEYS
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public void setSkeys(String skeys) {
        this.skeys = skeys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_OP_LOGS.CONTENTS
     *
     * @return the value of T_SYS_OP_LOGS.CONTENTS
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public String getContents() {
        return contents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_OP_LOGS.CONTENTS
     *
     * @param contents the value for T_SYS_OP_LOGS.CONTENTS
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_OP_LOGS.LEVEL
     *
     * @return the value of T_SYS_OP_LOGS.LEVEL
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_OP_LOGS.LEVEL
     *
     * @param level the value for T_SYS_OP_LOGS.LEVEL
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_OP_LOGS.CRT_TIME
     *
     * @return the value of T_SYS_OP_LOGS.CRT_TIME
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_OP_LOGS.CRT_TIME
     *
     * @param crtTime the value for T_SYS_OP_LOGS.CRT_TIME
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_OP_LOGS
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
        TSysOpLogs other = (TSysOpLogs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkeys() == null ? other.getSkeys() == null : this.getSkeys().equals(other.getSkeys()))
            && (this.getContents() == null ? other.getContents() == null : this.getContents().equals(other.getContents()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_OP_LOGS
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkeys() == null) ? 0 : getSkeys().hashCode());
        result = prime * result + ((getContents() == null) ? 0 : getContents().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_OP_LOGS
     *
     * @mbggenerated Sat Apr 16 13:41:11 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", skeys=").append(skeys);
        sb.append(", contents=").append(contents);
        sb.append(", level=").append(level);
        sb.append(", crtTime=").append(crtTime);
        sb.append("]");
        return sb.toString();
    }
}