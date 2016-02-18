package uk.ivanc.archimvvm.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface EzloanService {

    @Headers({
            "version: 3.0.2",
            "os: android",
            "X-Ip: 172.15.16.202",
            "X-DeviceNo: 863092027526956",
            "X-Lng: 121.603508",
            "X-Lat: 31.200136",
            "Authorization: Basic c3VpeGluZGFpOjFxYXohQCMk"
    })


    @FormUrlEncoded
    @POST("api/v2/login")
    Observable<Object> login(@Field("account") String account, @Field("password") String pass,
                             @Field("pushId") String pushId, @Field("pushType") String pushType);

    class Factory {
        public static EzloanService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://open.ezloan.cn/b2b2p-ws/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(EzloanService.class);
        }
    }
}
