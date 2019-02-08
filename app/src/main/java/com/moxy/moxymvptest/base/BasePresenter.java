package com.moxy.moxymvptest.base;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Базовый класс для презентеров
 * @param <V>
 */
public abstract class BasePresenter<V extends MvpView> extends MvpPresenter<V> {

    //cобираем подписки чтобы отписаться при уничтожении
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void disposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
