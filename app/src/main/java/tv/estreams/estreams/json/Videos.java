package tv.estreams.estreams.json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("_links")
    @Expose
    private tv.estreams.estreams.json.Links Links;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = new ArrayList<Video>();

    /**
     * 
     * @return
     *     The Links
     */
    public tv.estreams.estreams.json.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(tv.estreams.estreams.json.Links Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The videos
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     * 
     * @param videos
     *     The videos
     */
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

}
