package com.example.developer.android_dev_samples.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.developer.android_dev_samples.R;
import com.example.developer.android_dev_samples.storage.PlayerManager;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

public class HomeActivity extends AppCompatActivity implements HasFragmentInjector {

    private static final String FRAG_TAG_START_HOME = "home";

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    HomeFragment homeFragment;
    @Inject
    PlayerManager playerManager;

    @BindView(R.id.home_frag_container)
    View homeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        playerManager.insertRow(10L,"sachin");
        playerManager.insertRow(11L,"dravid");
        playerManager.insertRow(12L,"shewag");
        playerManager.insertRow(13L,"ganguly");
        playerManager.allPlayers();
        addFragment();
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    private void addFragment() {
        getFragmentManager().beginTransaction()
                .add(R.id.home_frag_container, homeFragment)
                .commit();
    }

    private HomeFragment getHomeFragment() {
        return (HomeFragment) getFragmentManager().findFragmentByTag(FRAG_TAG_START_HOME);
    }
}
