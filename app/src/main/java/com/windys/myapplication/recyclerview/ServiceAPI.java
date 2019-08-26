package com.windys.myapplication.recyclerview;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {

   /* @POST("Service/GetListPlace")
    Call<List<Place>> getListPlace(@Body JSONObject body1);*/

    @POST("Service/GetListPlace")
    Call<ListPlaceResponse1> getListPlace(@Body JSONObject body);

  /* @POST("Service/GetListPlace")
    Call<ResponseBody> getListPlace1();*/

    @POST("Service/GetListPlace")
    Call<ListPlaceResponse1> getListPlace();

}
