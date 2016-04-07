package onight.tfg.ordbgens.tfc.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_ORDER")
@AllArgsConstructor
@NoArgsConstructor
public class TFCOrder extends TFCOrderKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_ORDER.USER_ID
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_ORDER.ORDER_STATUS
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    private Integer orderStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_ORDER.ITEM_ID
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    private String itemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_ORDER.COIN_NUM
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    private Long coinNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_ORDER.STORAGE_TIME
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    private Date storageTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_ORDER.HANDLE_TIME
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    private Date handleTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_ORDER.USER_ID
     *
     * @return the value of TFC_ORDER.USER_ID
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_ORDER.USER_ID
     *
     * @param userId the value for TFC_ORDER.USER_ID
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_ORDER.ORDER_STATUS
     *
     * @return the value of TFC_ORDER.ORDER_STATUS
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_ORDER.ORDER_STATUS
     *
     * @param orderStatus the value for TFC_ORDER.ORDER_STATUS
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_ORDER.ITEM_ID
     *
     * @return the value of TFC_ORDER.ITEM_ID
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_ORDER.ITEM_ID
     *
     * @param itemId the value for TFC_ORDER.ITEM_ID
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_ORDER.COIN_NUM
     *
     * @return the value of TFC_ORDER.COIN_NUM
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public Long getCoinNum() {
        return coinNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_ORDER.COIN_NUM
     *
     * @param coinNum the value for TFC_ORDER.COIN_NUM
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setCoinNum(Long coinNum) {
        this.coinNum = coinNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_ORDER.STORAGE_TIME
     *
     * @return the value of TFC_ORDER.STORAGE_TIME
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public Date getStorageTime() {
        return storageTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_ORDER.STORAGE_TIME
     *
     * @param storageTime the value for TFC_ORDER.STORAGE_TIME
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_ORDER.HANDLE_TIME
     *
     * @return the value of TFC_ORDER.HANDLE_TIME
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_ORDER.HANDLE_TIME
     *
     * @param handleTime the value for TFC_ORDER.HANDLE_TIME
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER
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
        TFCOrder other = (TFCOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getCoinNum() == null ? other.getCoinNum() == null : this.getCoinNum().equals(other.getCoinNum()))
            && (this.getStorageTime() == null ? other.getStorageTime() == null : this.getStorageTime().equals(other.getStorageTime()))
            && (this.getHandleTime() == null ? other.getHandleTime() == null : this.getHandleTime().equals(other.getHandleTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getCoinNum() == null) ? 0 : getCoinNum().hashCode());
        result = prime * result + ((getStorageTime() == null) ? 0 : getStorageTime().hashCode());
        result = prime * result + ((getHandleTime() == null) ? 0 : getHandleTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER
     *
     * @mbggenerated Thu Apr 07 13:40:53 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", itemId=").append(itemId);
        sb.append(", coinNum=").append(coinNum);
        sb.append(", storageTime=").append(storageTime);
        sb.append(", handleTime=").append(handleTime);
        sb.append("]");
        return sb.toString();
    }
}