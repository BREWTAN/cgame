package onight.tfg.ordbgens.tfc.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_USER_LOCK")
@AllArgsConstructor
@NoArgsConstructor
public class TFCUserLock extends TFCUserLockKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.LOCK_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private String lockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.USER_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.COIN_ROW_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private String coinRowId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.GAME_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private String gameId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.SERVER_IP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private String serverIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.SERVER_NAME
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private String serverName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.COIN_TYPE_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private String coinTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.LOCK_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private Long lockNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_USER_LOCK.REC_DATE
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    private Date recDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.LOCK_ID
     *
     * @return the value of TFC_USER_LOCK.LOCK_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public String getLockId() {
        return lockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.LOCK_ID
     *
     * @param lockId the value for TFC_USER_LOCK.LOCK_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.USER_ID
     *
     * @return the value of TFC_USER_LOCK.USER_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.USER_ID
     *
     * @param userId the value for TFC_USER_LOCK.USER_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.COIN_ROW_ID
     *
     * @return the value of TFC_USER_LOCK.COIN_ROW_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public String getCoinRowId() {
        return coinRowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.COIN_ROW_ID
     *
     * @param coinRowId the value for TFC_USER_LOCK.COIN_ROW_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setCoinRowId(String coinRowId) {
        this.coinRowId = coinRowId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.GAME_ID
     *
     * @return the value of TFC_USER_LOCK.GAME_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.GAME_ID
     *
     * @param gameId the value for TFC_USER_LOCK.GAME_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.SERVER_IP
     *
     * @return the value of TFC_USER_LOCK.SERVER_IP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.SERVER_IP
     *
     * @param serverIp the value for TFC_USER_LOCK.SERVER_IP
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.SERVER_NAME
     *
     * @return the value of TFC_USER_LOCK.SERVER_NAME
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.SERVER_NAME
     *
     * @param serverName the value for TFC_USER_LOCK.SERVER_NAME
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.COIN_TYPE_ID
     *
     * @return the value of TFC_USER_LOCK.COIN_TYPE_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public String getCoinTypeId() {
        return coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.COIN_TYPE_ID
     *
     * @param coinTypeId the value for TFC_USER_LOCK.COIN_TYPE_ID
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setCoinTypeId(String coinTypeId) {
        this.coinTypeId = coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.LOCK_NUM
     *
     * @return the value of TFC_USER_LOCK.LOCK_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public Long getLockNum() {
        return lockNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.LOCK_NUM
     *
     * @param lockNum the value for TFC_USER_LOCK.LOCK_NUM
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setLockNum(Long lockNum) {
        this.lockNum = lockNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_USER_LOCK.REC_DATE
     *
     * @return the value of TFC_USER_LOCK.REC_DATE
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public Date getRecDate() {
        return recDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_USER_LOCK.REC_DATE
     *
     * @param recDate the value for TFC_USER_LOCK.REC_DATE
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
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
        TFCUserLock other = (TFCUserLock) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getLockId() == null ? other.getLockId() == null : this.getLockId().equals(other.getLockId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCoinRowId() == null ? other.getCoinRowId() == null : this.getCoinRowId().equals(other.getCoinRowId()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getServerIp() == null ? other.getServerIp() == null : this.getServerIp().equals(other.getServerIp()))
            && (this.getServerName() == null ? other.getServerName() == null : this.getServerName().equals(other.getServerName()))
            && (this.getCoinTypeId() == null ? other.getCoinTypeId() == null : this.getCoinTypeId().equals(other.getCoinTypeId()))
            && (this.getLockNum() == null ? other.getLockNum() == null : this.getLockNum().equals(other.getLockNum()))
            && (this.getRecDate() == null ? other.getRecDate() == null : this.getRecDate().equals(other.getRecDate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRowId() == null) ? 0 : getRowId().hashCode());
        result = prime * result + ((getLockId() == null) ? 0 : getLockId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCoinRowId() == null) ? 0 : getCoinRowId().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getServerIp() == null) ? 0 : getServerIp().hashCode());
        result = prime * result + ((getServerName() == null) ? 0 : getServerName().hashCode());
        result = prime * result + ((getCoinTypeId() == null) ? 0 : getCoinTypeId().hashCode());
        result = prime * result + ((getLockNum() == null) ? 0 : getLockNum().hashCode());
        result = prime * result + ((getRecDate() == null) ? 0 : getRecDate().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_USER_LOCK
     *
     * @mbggenerated Sat Apr 16 13:41:12 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lockId=").append(lockId);
        sb.append(", userId=").append(userId);
        sb.append(", coinRowId=").append(coinRowId);
        sb.append(", gameId=").append(gameId);
        sb.append(", serverIp=").append(serverIp);
        sb.append(", serverName=").append(serverName);
        sb.append(", coinTypeId=").append(coinTypeId);
        sb.append(", lockNum=").append(lockNum);
        sb.append(", recDate=").append(recDate);
        sb.append("]");
        return sb.toString();
    }
}