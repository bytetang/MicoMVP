package com.mico.micomvp.ui.activity.module;

import com.mico.micomvp.model.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tangjie on 16/6/26.
 */
@Singleton
@Module
public class AppServiceModule {

    @Provides
    User getUser(){
        User user = new User();
        user.setId(12);
        user.setName("Aaron");
        return user;
    }
}
