package com.moxy.moxymvptest.presentation.presenter.main;


import com.arellomobile.mvp.InjectViewState;
import com.moxy.moxymvptest.App;
import com.moxy.moxymvptest.base.BasePresenter;
import com.moxy.moxymvptest.data.ApiService;
import com.moxy.moxymvptest.presentation.view.main.MainView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    ApiService apiService;

    public MainPresenter() {
        App.getAppComponent().inject(this);
    }

    public void loadData() {
        disposable(apiService.loadData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> getViewState().onLoaded(data), error -> error.printStackTrace()));
    }

}
