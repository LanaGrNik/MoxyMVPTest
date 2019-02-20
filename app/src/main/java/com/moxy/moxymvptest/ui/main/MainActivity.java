package com.moxy.moxymvptest.ui.main;

import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.*;
import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.moxy.moxymvptest.R;
import com.moxy.moxymvptest.model.main.*;
import com.moxy.moxymvptest.presentation.presenter.main.MainPresenter;
import com.moxy.moxymvptest.presentation.view.main.MainView;
import com.moxy.moxymvptest.ui.view.PictureView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.view.View.VISIBLE;

public class MainActivity extends MvpActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    private LinearLayout layout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        progressBar = findViewById(R.id.progress);

        progressBar.setVisibility(VISIBLE);
        presenter.loadData();
    }

    @Override
    public void onLoaded(DataResponse dataResponse) {
        layout.removeAllViews();
        progressBar.setVisibility(View.GONE);
        for (Data data : dataResponse.getData()) {
            drawData(data);
        }
    }

    private void drawData(Data data) {
        switch (data.getViewData()) {
            case HZ:
                drawHz(data);
                break;
            case PICTURE:
                drawPicture(data);
                break;
            case SELECTOR:
                drawSelector(data);
                break;
        }
    }

    private void drawHz(Data data) {
        HzData hzData = (HzData) data.getData();
        TextView textView = new TextView(this);
        textView.setText(hzData.getText());
        textView.setOnClickListener(v -> {
            Toast.makeText(this, hzData.getText(), Toast.LENGTH_SHORT).show();
        });
        layout.addView(textView);
    }

    private void drawPicture(Data data) {
        PictureData pictureData = (PictureData) data.getData();
        PictureView picView = new PictureView(this);
        picView.setData(pictureData);
        picView.setOnClickListener(v -> {
            Toast.makeText(this, pictureData.getText(), Toast.LENGTH_SHORT).show();
        });
        layout.addView(picView);
    }

    private void drawSelector(Data data) {
        SelectorData selectorData = (SelectorData) data.getData();
        AppCompatSpinner spinner = new AppCompatSpinner(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectorData.getStringVariants());
        spinner.setAdapter(adapter);
        spinner.setSelection(selectorData.getSelectedId());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, getSelectorMessage(position, selectorData.getVariants()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        layout.addView(spinner);
    }

    private String getSelectorMessage(int selected, List<Variant> variants) {
        Variant variant = variants.get(selected);
        return "id:" + variant.getId() + "; text:" + variant.getText();
    }

}
