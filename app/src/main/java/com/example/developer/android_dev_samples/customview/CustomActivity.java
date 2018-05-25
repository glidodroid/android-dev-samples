package com.example.developer.android_dev_samples.customview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.vladsch.flexmark.convert.html.FlexmarkHtmlParser;
import com.vladsch.flexmark.util.options.DataHolder;
import com.vladsch.flexmark.util.options.DataKey;
import com.vladsch.flexmark.util.options.MutableDataHolder;

import java.util.Collection;
import java.util.Map;

import timber.log.Timber;

public class CustomActivity extends AppCompatActivity {

    // private Remark remark;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final AvatarImageView avatarImageView = findViewById(R.id.avatar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                htmlToMarkdown();
                //setUpBottomSheet();
                //showBottomSheet();
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
        for (int i = 0; i < 2; i++) {
            final AvatarView avatarView = new AvatarView(this);
            if (i == 0) {
                avatarView.setAvatar("testing");
                avatarView.setTag("testing");
            } else {
                avatarView.setAvatar("working");
                avatarView.setTag("working");
            }
            layout.addView(avatarView);
            avatarView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Timber.d("avatar view %s", avatarView.getTag());
                }
            });
        }
        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();
        // to hide bottom sheet.
        //bottomSheetDialog.hide();
    }

    private void htmlToMarkdown() {
        //remark = new Remark(Options.markdown());
        runOnThread();
    }

    private void runOnThread() {
        String htmlText = "<em>Unordered</em>\n" +
                "<ul>\n" +
                "    <li>Item 1</li>\n" +
                "    <li>Item 2</li>\n" +
                "    <li>Item 3</li>\n" +
                "</ul>";
        String complexHtml = "<h1 id=\"reference\" style=\"font-weight: 400; margin: 0px0px30px; font-family: \"OpenSans\",Helvetica,Arial,sans-serif; font-size: 30px; line-height: 33px; position: relative; color: rgb(51,51,51); font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; letter-spacing: normal; orphans: 2text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255,255,255); text-decoration-style: initial; text-decoration-color: initial; text-align: left;\">Reference</h1><p style=\"margin: 0px0px15px; line-height: 24px; color: rgb(51,51,51); font-family: \"OpenSans\",Helvetica,Arial,sans-serif; font-size: 14px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: normal; letter-spacing: normal; orphans: 2text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255,255,255); text-decoration-style: initial; text-decoration-color: initial; text-align: left;\">Provides a complete reference to the Kotlin language and the<span> </span><a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/index.html\" style=\"color: rgb(73, 123, 183); text-decoration: underline;\">standard library</a>.</p><h3 id=\"where-to-begin\" style=\"font-weight: 400; margin: 30px0px15px; position: relative; font-family: \"OpenSans\",Helvetica,Arial,sans-serif; font-size: 19px; line-height: 22px; color: rgb(51,51,51); font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; letter-spacing: normal; orphans: 2text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255,255,255); text-decoration-style: initial; text-decoration-color: initial; text-align: left;\"></h3>";
        String markDown = FlexmarkHtmlParser.parse(complexHtml);
        Timber.d("markdown %s", markDown);
//        MutableDataSet options = new MutableDataSet();
//        Parser parser = Parser.builder(options).build();
//        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
//        Node document = parser.parse(htmlText);
//        String markdown = renderer.render(document);
//        Timber.d("markdown %s", markdown);
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                String markDownText = remark.convert("<em>Unordered</em>\n" +
//                        "<ul>\n" +
//                        "    <li>Item 1</li>\n" +
//                        "    <li>Item 2</li>\n" +
//                        "    <li>Item 3</li>\n" +
//                        "</ul>");
//                Timber.d("markdown %s", markDownText);
//            }
//        };
//        thread.start();
    }

}
