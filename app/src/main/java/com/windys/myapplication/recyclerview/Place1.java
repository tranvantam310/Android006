package com.windys.myapplication.recyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place1 {

   /* @SerializedName("placeName")
    @Expose
    public String placeName;
    @SerializedName("isMoreDetail")
    @Expose
    public Integer isMoreDetail;
    @SerializedName("isPromotion")
    @Expose
    public Integer isPromotion;

    public Place1(String placeName, Integer isMoreDetail, Integer isPromotion) {
        this.placeName = placeName;
        this.isMoreDetail = isMoreDetail;
        this.isPromotion = isPromotion;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getIsMoreDetail() {
        return isMoreDetail;
    }

    public void setIsMoreDetail(Integer isMoreDetail) {
        this.isMoreDetail = isMoreDetail;
    }

    public Integer getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }*/

    @SerializedName("placeName")
    @Expose
    public String placeName;
    @SerializedName("isMoreDetail")
    @Expose
    public Integer isMoreDetail;
    @SerializedName("isPromotion")
    @Expose
    public Integer isPromotion;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getIsMoreDetail() {
        return isMoreDetail;
    }

    public void setIsMoreDetail(Integer isMoreDetail) {
        this.isMoreDetail = isMoreDetail;
    }

    public Integer getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }
}
