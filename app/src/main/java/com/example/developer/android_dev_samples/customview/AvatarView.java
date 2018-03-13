package com.example.developer.android_dev_samples.customview;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.developer.android_dev_samples.R;

/**
 * Created by developer on 18/2/18.
 */

public class AvatarView extends LinearLayout {

    private ImageView imageView;
    private TextView textView;

    public AvatarView(@NonNull Context context) {
        super(context);
        init();
    }

    public AvatarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AvatarView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.HORIZONTAL);
        inflate(getContext(), R.layout.layout_avatar_view, this);
        imageView = (ImageView) findViewById(R.id.avatar_image);
        textView = (TextView) findViewById(R.id.avatar_text);
    }

    public void setAvatar(String userName) {
        if (userName != null) {
            imageView.setVisibility(VISIBLE);
            textView.setText(userName);
        }
    }
}
