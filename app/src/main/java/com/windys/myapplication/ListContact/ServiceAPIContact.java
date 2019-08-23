package com.windys.myapplication.ListContact;

//    Call<ResponseBody> getListContact(@Body JSONObject body);

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPIContact {

    @POST("Service/GetListContact")
    Call<ResponseBody> getListContact(@Body JSONObject body);

}
