package onight.tfg.ordbgens.tfc.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_CHANNEL_PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
public class TFCChannelProduct extends TFCChannelProductKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_CHANNEL_PRODUCT.GAME_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    private String gameId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_CHANNEL_PRODUCT.CHANNEL_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    private String channelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_CHANNEL_PRODUCT.PRODUCT_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    private String productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_CHANNEL_PRODUCT.NOTE
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    private String note;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_CHANNEL_PRODUCT.AUTHOR
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_CHANNEL_PRODUCT.RECTIME
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    private Date rectime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_CHANNEL_PRODUCT.GAME_ID
     *
     * @return the value of TFC_CHANNEL_PRODUCT.GAME_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_CHANNEL_PRODUCT.GAME_ID
     *
     * @param gameId the value for TFC_CHANNEL_PRODUCT.GAME_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_CHANNEL_PRODUCT.CHANNEL_ID
     *
     * @return the value of TFC_CHANNEL_PRODUCT.CHANNEL_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_CHANNEL_PRODUCT.CHANNEL_ID
     *
     * @param channelId the value for TFC_CHANNEL_PRODUCT.CHANNEL_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_CHANNEL_PRODUCT.PRODUCT_ID
     *
     * @return the value of TFC_CHANNEL_PRODUCT.PRODUCT_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_CHANNEL_PRODUCT.PRODUCT_ID
     *
     * @param productId the value for TFC_CHANNEL_PRODUCT.PRODUCT_ID
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_CHANNEL_PRODUCT.NOTE
     *
     * @return the value of TFC_CHANNEL_PRODUCT.NOTE
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_CHANNEL_PRODUCT.NOTE
     *
     * @param note the value for TFC_CHANNEL_PRODUCT.NOTE
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_CHANNEL_PRODUCT.AUTHOR
     *
     * @return the value of TFC_CHANNEL_PRODUCT.AUTHOR
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_CHANNEL_PRODUCT.AUTHOR
     *
     * @param author the value for TFC_CHANNEL_PRODUCT.AUTHOR
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_CHANNEL_PRODUCT.RECTIME
     *
     * @return the value of TFC_CHANNEL_PRODUCT.RECTIME
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public Date getRectime() {
        return rectime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_CHANNEL_PRODUCT.RECTIME
     *
     * @param rectime the value for TFC_CHANNEL_PRODUCT.RECTIME
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setRectime(Date rectime) {
        this.rectime = rectime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
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
        TFCChannelProduct other = (TFCChannelProduct) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getRectime() == null ? other.getRectime() == null : this.getRectime().equals(other.getRectime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRowId() == null) ? 0 : getRowId().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getRectime() == null) ? 0 : getRectime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CHANNEL_PRODUCT
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gameId=").append(gameId);
        sb.append(", channelId=").append(channelId);
        sb.append(", productId=").append(productId);
        sb.append(", note=").append(note);
        sb.append(", author=").append(author);
        sb.append(", rectime=").append(rectime);
        sb.append("]");
        return sb.toString();
    }
}