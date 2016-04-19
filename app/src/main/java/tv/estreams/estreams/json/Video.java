package tv.estreams.estreams.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("broadcast_id")
    @Expose
    private Integer broadcastId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tag_list")
    @Expose
    private String tagList;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("recorded_at")
    @Expose
    private String recordedAt;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("preview")
    @Expose
    private String preview;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("broadcast_type")
    @Expose
    private String broadcastType;
    @SerializedName("_links")
    @Expose
    private Links_ Links;
    @SerializedName("channel")
    @Expose
    private Channel channel;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The broadcastId
     */
    public Integer getBroadcastId() {
        return broadcastId;
    }

    /**
     * 
     * @param broadcastId
     *     The broadcast_id
     */
    public void setBroadcastId(Integer broadcastId) {
        this.broadcastId = broadcastId;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The tagList
     */
    public String getTagList() {
        return tagList;
    }

    /**
     * 
     * @param tagList
     *     The tag_list
     */
    public void setTagList(String tagList) {
        this.tagList = tagList;
    }

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The recordedAt
     */
    public String getRecordedAt() {
        return recordedAt;
    }

    /**
     * 
     * @param recordedAt
     *     The recorded_at
     */
    public void setRecordedAt(String recordedAt) {
        this.recordedAt = recordedAt;
    }

    /**
     * 
     * @return
     *     The game
     */
    public String getGame() {
        return game;
    }

    /**
     * 
     * @param game
     *     The game
     */
    public void setGame(String game) {
        this.game = game;
    }

    /**
     * 
     * @return
     *     The length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The length
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * 
     * @return
     *     The preview
     */
    public String getPreview() {
        return preview;
    }

    /**
     * 
     * @param preview
     *     The preview
     */
    public void setPreview(String preview) {
        this.preview = preview;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The views
     */
    public Integer getViews() {
        return views;
    }

    /**
     * 
     * @param views
     *     The views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 
     * @return
     *     The broadcastType
     */
    public String getBroadcastType() {
        return broadcastType;
    }

    /**
     * 
     * @param broadcastType
     *     The broadcast_type
     */
    public void setBroadcastType(String broadcastType) {
        this.broadcastType = broadcastType;
    }

    /**
     * 
     * @return
     *     The Links
     */
    public Links_ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links_ Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The channel
     */
    public Channel getChannel() {
        return channel;
    }

    /**
     * 
     * @param channel
     *     The channel
     */
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}
