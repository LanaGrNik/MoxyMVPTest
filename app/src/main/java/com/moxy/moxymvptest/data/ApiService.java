package com.moxy.moxymvptest.data;

import com.google.gson.Gson;
import com.moxy.moxymvptest.model.main.Data;
import com.moxy.moxymvptest.model.main.DataResponse;
import com.moxy.moxymvptest.model.main.HzData;
import com.moxy.moxymvptest.model.main.PictureData;
import com.moxy.moxymvptest.model.main.SelectorData;
import com.moxy.moxymvptest.model.main.ViewData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Класс для отравки на сервер и обработки ответа
 */
public class ApiService {

    private Api api;
    private Gson gson;

    @Inject
    public ApiService(Api api, Gson gson) {
        this.api = api;
        this.gson = gson;
    }

    public Single<DataResponse> loadData() {
        return api.loadData()
                .map(dataResponse -> mapResponse(dataResponse))
                .map(dataResponse -> filterVisible(dataResponse));
    }

    //конвертируем Data
    private DataResponse mapResponse(DataResponse dataResponse) {
        for (Data data : dataResponse.getData()) {
            ViewData viewData = data.getViewData();
            Object dataData;
            switch (viewData) {
                case HZ:
                    dataData = mapHz(data);
                     break;
                case PICTURE:
                    dataData  = mapPicture(data);
                    break;
                case SELECTOR:
                    dataData = mapSelector(data);
                    break;
                default:
                    dataData = null;
                    break;
            }
            data.setData(dataData);
        }
        return dataResponse;
    }

    //фильтруем видимые
    private HzData mapHz(Data data) {
        String str = gson.toJson(data.getData());
        HzData hzData = gson.fromJson(str, HzData.class);
        return hzData;
    }

    private PictureData mapPicture(Data data) {
        String str = gson.toJson(data.getData());
        PictureData picData = gson.fromJson(str, PictureData.class);
        return picData;
    }

    private SelectorData mapSelector(Data data) {
        String str = gson.toJson(data.getData());
        SelectorData selectorData = gson.fromJson(str, SelectorData.class);
        return selectorData;
    }

    private DataResponse filterVisible(DataResponse dataResponse) {
        List<ViewData> viewDataList = dataResponse.getView();
        List<Data> dataList = new ArrayList<>();
        for (Data data: dataResponse.getData()) {
            ViewData viewData = data.getViewData();
            if (viewDataList.contains(viewData)) {
                dataList.add(data);
            }
        }
        dataResponse.setData(dataList);
        return dataResponse;
    }

}
