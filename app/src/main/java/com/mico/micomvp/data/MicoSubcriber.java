package com.mico.micomvp.data;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import rx.Subscriber;

/**
 * Created by tangjie on 16/6/26.
 */
public abstract class MicoSubcriber<T> extends Subscriber<T> {
    Activity activity;

    public MicoSubcriber(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onNext(T t) {
        onResponse(t);
    }

    @Override
    public void onCompleted() {
        Log.d(this.getClass().getSimpleName(),"onCompleted...");
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(activity,"服务网络错误",Toast.LENGTH_LONG).show();
    }

   public abstract void onResponse(T t);
}
