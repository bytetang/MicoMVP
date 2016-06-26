package com.mico.micomvp;

import android.app.Application;

import com.mico.micomvp.ui.activity.component.AppComponet;
import com.mico.micomvp.ui.activity.component.DaggerAppComponet;
import com.mico.micomvp.ui.activity.module.AppModule;
import com.mico.micomvp.ui.activity.module.AppServiceModule;


/**
 * Created by tangjie on 16/6/26.
 */
public class MicoApplication extends Application {

    private AppComponet appComponet;
    private static MicoApplication mInstance;
    public static MicoApplication getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        //get appComonet .application dependencies
        appComponet = DaggerAppComponet.builder()
                .appModule(new AppModule(this))
                .appServiceModule(new AppServiceModule())
                .build();

    }

    public AppComponet getAppComponet(){
        return appComponet;
    }
}
