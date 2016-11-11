package com.example.developer.android_dev_samples.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.example.developer.android_dev_samples.R;
import com.example.developer.android_dev_samples.eventbus.MainBus;
import com.example.developer.android_dev_samples.fragment.HomeFragment;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Home page of this app.
 */

public class HomeActivity extends AppCompatActivity {

    private static final String HOME_FRAG_TAG = "home";
    @BindView(R.id.home_container)
    View homeFragmentContainer;
    private ViewGroup view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        addFragments();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainBus.getInstance().getBusObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mainBusSubscriber);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainBusSubscriber.unsubscribe();
    }

    private Subscriber<? super Object> mainBusSubscriber = new Subscriber<Object>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Object o) {

            if (o.equals("String")) {
                Timber.d("Event received");
            }

        }
    };

    private void addFragments() {
        getSupportFragmentManager().beginTransaction()
                .replace(homeFragmentContainer.getId(), getHomeFragment(), HOME_FRAG_TAG)
                .commit();

        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(HOME_FRAG_TAG);
    }

    private HomeFragment getHomeFragment() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        return homeFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
