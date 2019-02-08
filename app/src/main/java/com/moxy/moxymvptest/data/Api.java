package com.moxy.moxymvptest.data;

import com.moxy.moxymvptest.model.main.DataResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("tmp/JSONSample.json")
    Single<DataResponse> loadData();

}
