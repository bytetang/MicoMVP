package com.mico.micomvp.ui.activity.presenter;

import com.mico.micomvp.data.ApiService;
import com.mico.micomvp.data.ApiServiceModule;
import com.mico.micomvp.ui.activity.component.DaggerPresenterComponent;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * inject retrofit
 * provide ApiService
 *
 * Created by tangjie on 16/6/26.
 */
public class BasePresenter {

    @Inject
    Retrofit retrofit;
    ApiService apiService;

    public BasePresenter(){
        setupPresenterComponent();
        apiService = retrofit.create(ApiService.class);
    }

    protected void setupPresenterComponent(){
        DaggerPresenterComponent.builder()
                .apiServiceModule(new ApiServiceModule())
                .build()
                .inject(this);
    }


}
