package tv.estreams.estreams.json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopGames {

    @SerializedName("_links")
    @Expose
    private Links Links;
    @SerializedName("_total")
    @Expose
    private Integer Total;
    @SerializedName("top")
    @Expose
    private List<Top> top = new ArrayList<Top>();

    /**
     * 
     * @return
     *     The Links
     */
    public Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The Total
     */
    public Integer getTotal() {
        return Total;
    }

    /**
     * 
     * @param Total
     *     The _total
     */
    public void setTotal(Integer Total) {
        this.Total = Total;
    }

    /**
     * 
     * @return
     *     The top
     */
    public List<Top> getTop() {
        return top;
    }

    /**
     * 
     * @param top
     *     The top
     */
    public void setTop(List<Top> top) {
        this.top = top;
    }

}
