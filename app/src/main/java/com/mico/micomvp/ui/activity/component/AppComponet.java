package com.mico.micomvp.ui.activity.component;

import android.app.Application;

import com.mico.micomvp.data.ApiServiceModule;
import com.mico.micomvp.model.User;
import com.mico.micomvp.ui.activity.module.AppModule;
import com.mico.micomvp.ui.activity.module.AppServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by tangjie on 16/6/26.
 */
@Singleton
@Component(modules = {AppModule.class, AppServiceModule.class})
public interface AppComponet {

    Application getApplication();

    User getUser();

//    OkHttpClient getOkHttpClient();
//
//    Retrofit getRetrofit();
}
