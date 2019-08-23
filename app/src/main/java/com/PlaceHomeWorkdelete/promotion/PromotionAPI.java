package com.PlaceHomeWorkdelete.promotion;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PromotionAPI {

    // didnt work
    @POST("Service/GetListPromotion")
    Call<Promotion> getPromotion();


    @POST("Service/GetListPromotion")
    Call<Promotion> getPromotion(@Body JSONObject body);
}
