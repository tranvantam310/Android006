package winds.com.androidtutorial.recyclerview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Media implements Serializable {

    @SerializedName("urlID")
    @Expose
    public String urlID;
    @SerializedName("type")
    @Expose
    public Integer type;

}