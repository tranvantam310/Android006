package com.PlaceHomeWorkdelete;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PlaceAPI {

    @POST("Service/GetListPlace")
    Call<PlaceList> getPlaceList(@Body JSONObject body);
}
