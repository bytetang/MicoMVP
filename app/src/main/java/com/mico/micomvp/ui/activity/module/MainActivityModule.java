package com.mico.micomvp.ui.activity.module;

import com.mico.micomvp.ui.activity.MainActivity;
import com.mico.micomvp.model.User;
import com.mico.micomvp.ui.activity.scope.ActivityScope;
import com.mico.micomvp.ui.activity.presenter.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tangjie on 16/6/26.
 */

@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity){
        this.mainActivity  = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity(){
        return this.mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivityPresenter provideMainActivityPresenter(MainActivity mainActivity, User user){
        return new MainActivityPresenter(mainActivity,user);
    }

}
