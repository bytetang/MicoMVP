package com.mico.micomvp.ui.activity.component;

import com.mico.micomvp.data.ApiServiceModule;
import com.mico.micomvp.ui.activity.PresenterScope;
import com.mico.micomvp.ui.activity.presenter.BasePresenter;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by tangjie on 16/6/26.
 */
@PresenterScope
@Component(modules = ApiServiceModule.class)
public interface PresenterComponent {

    BasePresenter inject(BasePresenter presenter);

    OkHttpClient getOkhttpClient();

    Retrofit getRetrofit();

}
