package com.moxy.moxymvptest.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.moxy.moxymvptest.R;
import com.moxy.moxymvptest.model.main.PictureData;
import com.squareup.picasso.Picasso;

public class PictureView extends LinearLayout {

    TextView textView;
    ImageView imageView;

    public PictureView(Context context) {
        super(context);
        initComponent(context);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initComponent(context);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initComponent(context);
    }

    private void initComponent(Context context) {
        inflate(context, R.layout.view_picture, this);
        textView = findViewById(R.id.picture_text);
        imageView = findViewById(R.id.picture_image);
    }

    public void setData(PictureData data) {
        textView.setText(data.getText());
        Picasso.get().load(data.getUrl()).into(imageView);
    }

}
