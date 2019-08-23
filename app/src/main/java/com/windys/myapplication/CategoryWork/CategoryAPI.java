package com.windys.myapplication.CategoryWork;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;

public interface CategoryAPI {

    // cach 1
    @POST("Service/GetListCategoryAndBanner")
    Call<CategoryRespon> getCategory();


    // cach 2
    @POST("Service/GetListCategoryAndBanner")
    Call<ResponseBody> getCategory1();

}
