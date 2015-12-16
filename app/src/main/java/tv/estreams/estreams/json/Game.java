package tv.estreams.estreams.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("box")
    @Expose
    private Box box;
    @SerializedName("logo")
    @Expose
    private Logo logo;
    @SerializedName("_links")
    @Expose
    private Links_ Links;
    @SerializedName("_id")
    @Expose
    private Integer Id;
    @SerializedName("giantbomb_id")
    @Expose
    private Integer giantbombId;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The box
     */
    public Box getBox() {
        return box;
    }

    /**
     * 
     * @param box
     *     The box
     */
    public void setBox(Box box) {
        this.box = box;
    }

    /**
     * 
     * @return
     *     The logo
     */
    public Logo getLogo() {
        return logo;
    }

    /**
     * 
     * @param logo
     *     The logo
     */
    public void setLogo(Logo logo) {
        this.logo = logo;
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
     *     The Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The _id
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The giantbombId
     */
    public Integer getGiantbombId() {
        return giantbombId;
    }

    /**
     * 
     * @param giantbombId
     *     The giantbomb_id
     */
    public void setGiantbombId(Integer giantbombId) {
        this.giantbombId = giantbombId;
    }

}
