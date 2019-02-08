package com.moxy.moxymvptest.presentation.view.main;

import com.arellomobile.mvp.MvpView;
import com.moxy.moxymvptest.model.main.DataResponse;

public interface MainView extends MvpView {

    void onLoaded(DataResponse data);

}
