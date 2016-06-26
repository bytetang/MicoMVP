package com.mico.micomvp.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mico.micomvp.R;
import com.mico.micomvp.ui.activity.BaseActivity;
import com.mico.micomvp.ui.activity.component.AppComponet;
import com.mico.micomvp.ui.activity.component.DaggerMainActivityComponent;
import com.mico.micomvp.ui.activity.module.MainActivityModule;
import com.mico.micomvp.ui.activity.presenter.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.etLoginName)
    EditText etLoginName;
    @InjectView(R.id.etLoginPwd)
    EditText etLoginPwd;
    @InjectView(R.id.tvLoginTitle)
    TextView tvLogtinTitle;

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mainActivityPresenter.showLoginTitle();
    }

    @Override
    public void setupActivityComponent(AppComponet appComponet) {
        DaggerMainActivityComponent.builder()
                .appComponet(appComponet)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    public void setLoginTitle(String title) {
        tvLogtinTitle.setText(title);
    }


    @OnClick(R.id.btnLogin)
    public void clickLogin() {
        mainActivityPresenter.login(etLoginName.getText().toString(), etLoginPwd.getText().toString());
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
