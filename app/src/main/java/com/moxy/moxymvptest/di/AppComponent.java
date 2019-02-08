package com.moxy.moxymvptest.di;

import com.moxy.moxymvptest.presentation.presenter.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    void inject(MainPresenter mainPresenter);
}