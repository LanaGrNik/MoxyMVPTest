package com.moxy.moxymvptest.model.main;

import java.util.List;

public class DataResponse {

    private List<Data> data;
    private List<ViewData> view;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<ViewData> getView() {
        return view;
    }

    public void setView(List<ViewData> view) {
        this.view = view;
    }
}
