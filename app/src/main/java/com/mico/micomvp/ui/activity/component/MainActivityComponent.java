package com.mico.micomvp.ui.activity.component;

import com.mico.micomvp.ui.activity.MainActivity;
import com.mico.micomvp.ui.activity.ActivityScope;
import com.mico.micomvp.ui.activity.module.MainActivityModule;
import com.mico.micomvp.ui.activity.presenter.MainActivityPresenter;


import dagger.Component;

/**
 * Created by tangjie on 16/6/26.
 */

@ActivityScope
@Component(modules = MainActivityModule.class,dependencies = AppComponet.class)
public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);

    MainActivityPresenter presenter();
}
