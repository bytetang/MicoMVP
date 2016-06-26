package com.mico.micomvp.data;

import com.mico.micomvp.model.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 *
 * retrofit api service interface
 * Created by tangjie on 16/6/26.
 */
public interface ApiService {

    String BASE_URL = "http://192.168.56.1:12306/";

    @POST("/user/login/")
    @FormUrlEncoded
    Observable<User> userLogin(@Field("name") String name, @Field("pwd") String pwd);
}
