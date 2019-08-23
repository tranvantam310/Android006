package com.PlaceHomeWorkdelete.promotion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListMedium {

    @SerializedName("urlID")
    @Expose
    public String urlID;
    @SerializedName("type")
    @Expose
    public Integer type;

    public String getUrlID() {
        return urlID;
    }

    public void setUrlID(String urlID) {
        this.urlID = urlID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ListMedium(String urlID, Integer type) {
        this.urlID = urlID;
        this.type = type;
    }
}