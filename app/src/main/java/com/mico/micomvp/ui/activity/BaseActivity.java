package com.mico.micomvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mico.micomvp.MicoApplication;
import com.mico.micomvp.ui.activity.component.AppComponet;

/**
 * Created by tangjie on 16/6/26.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(MicoApplication.getInstance().getAppComponet());
    }

    public abstract void setupActivityComponent(AppComponet appComponet);
}
