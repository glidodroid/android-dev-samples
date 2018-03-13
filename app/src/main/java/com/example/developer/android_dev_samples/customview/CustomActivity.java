package com.example.developer.android_dev_samples.customview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.developer.android_dev_samples.AvatarImageView;
import com.example.developer.android_dev_samples.R;
import com.overzealous.remark.Remark;

import timber.log.Timber;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final AvatarImageView avatarImageView = findViewById(R.id.avatar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setUpBottomSheet();
                showBottomSheet();
                //avatarView.drawCircle();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();
            }
        });
    }

    private void setUpBottomSheet() {
        //https://medium.com/android-bits/android-bottom-sheet-30284293f066
        ConstraintLayout sheetOne = findViewById(R.id.bottom_sheet_one);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(sheetOne);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

// set the peek height
        bottomSheetBehavior.setPeekHeight(340);

// set hideable or not
        bottomSheetBehavior.setHideable(false);

// set callback for changes
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.layout_bottom_sheet, null);
        LinearLayout layout = sheetView.findViewById(R.id.bottom_sheet_layout);
        for (int i=0; i<2; i++) {
            final AvatarView avatarView = new AvatarView(this);
            if (i==0) {
                avatarView.setAvatar("testing");
                avatarView.setTag("testing");
            }else {
                avatarView.setAvatar("working");
                avatarView.setTag("working");
            }
            layout.addView(avatarView);
            avatarView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Timber.d("avatar view %s",avatarView.getTag());
                }
            });
        }
        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();
        // to hide bottom sheet.
        //bottomSheetDialog.hide();
    }

}
