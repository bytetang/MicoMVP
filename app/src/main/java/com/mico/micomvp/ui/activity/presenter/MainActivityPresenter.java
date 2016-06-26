package com.mico.micomvp.ui.activity.presenter;

import com.mico.micomvp.ui.activity.MainActivity;
import com.mico.micomvp.data.MicoSubcriber;
import com.mico.micomvp.model.User;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by tangjie on 16/6/26.
 */
public class MainActivityPresenter extends BasePresenter{

    private MainActivity mainActivity;
    private User user;

    public MainActivityPresenter(MainActivity mainActivity, User user){
        this.mainActivity = mainActivity;
        this.user = user;
    }


    public void showLoginTitle(){
        mainActivity.setLoginTitle("hello mvp");
    }

    public void login(String name,String pwd){
        apiService.userLogin(name,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MicoSubcriber<User>(mainActivity) {
                    @Override
                    public void onResponse(User user) {
                        mainActivity.showToast(user.getName());
                    }
                });

    }

}
