package com.moxy.moxymvptest;

import android.app.Application;
import com.moxy.moxymvptest.di.AppComponent;
import com.moxy.moxymvptest.di.AppModule;
import com.moxy.moxymvptest.di.DaggerAppComponent;

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }

}
