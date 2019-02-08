package com.moxy.moxymvptest.model.main;

import com.google.gson.annotations.SerializedName;

public class Data<T> {

    @SerializedName("name")
    private ViewData viewData;
    private T data;

    public ViewData getViewData() {
        return viewData;
    }

    public void setViewData(ViewData name) {
        this.viewData = name;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
