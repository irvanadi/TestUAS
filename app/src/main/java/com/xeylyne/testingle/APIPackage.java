package com.xeylyne.testingle;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIPackage {

    @GET("pl_getPlace.php")
    Call<ReqAPI> request();
}
