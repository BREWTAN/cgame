package onight.tfg.ordbgens.tfc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_USER_LOCKCS")
@AllArgsConstructor
@NoArgsConstructor
public class TFCUserLockcs extends TFCUserLockcsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCKCS.READ_COUNT
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    private Long readCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCKCS.WRITE_COUNT
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    private Long writeCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCKCS.READ_COUNT
     *
     * @return the value of TFC_USER_LOCKCS.READ_COUNT
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public Long getReadCount() {
        return readCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCKCS.READ_COUNT
     *
     * @param readCount the value for TFC_USER_LOCKCS.READ_COUNT
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCKCS.WRITE_COUNT
     *
     * @return the value of TFC_USER_LOCKCS.WRITE_COUNT
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public Long getWriteCount() {
        return writeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCKCS.WRITE_COUNT
     *
     * @param writeCount the value for TFC_USER_LOCKCS.WRITE_COUNT
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setWriteCount(Long writeCount) {
        this.writeCount = writeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
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
        TFCUserLockcs other = (TFCUserLockcs) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getReadCount() == null ? other.getReadCount() == null : this.getReadCount().equals(other.getReadCount()))
            && (this.getWriteCount() == null ? other.getWriteCount() == null : this.getWriteCount().equals(other.getWriteCount()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getReadCount() == null) ? 0 : getReadCount().hashCode());
        result = prime * result + ((getWriteCount() == null) ? 0 : getWriteCount().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCKCS
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", readCount=").append(readCount);
        sb.append(", writeCount=").append(writeCount);
        sb.append("]");
        return sb.toString();
    }
}