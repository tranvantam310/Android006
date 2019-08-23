package com.PlaceHomeWorkdelete;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaceList {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("result")
    @Expose
    public List<Place> result = null;
    @SerializedName("message")
    @Expose
    public String message;

}