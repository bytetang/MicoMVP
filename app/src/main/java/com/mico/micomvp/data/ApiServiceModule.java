package com.mico.micomvp.data;

import com.mico.micomvp.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


/**
 * 1.provide okhttp client
 * 2.provide retrofit to presenter
 * <p/>
 * Created by tangjie on 16/6/26.
 */
@Module
@Singleton
public class ApiServiceModule {

    private OkHttpClient okHttpClient;

    @Provides
    OkHttpClient provideOkHttpClient() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }

    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.BASE_URL)
                .client(provideOkHttpClient())
                .build();
    }

}
