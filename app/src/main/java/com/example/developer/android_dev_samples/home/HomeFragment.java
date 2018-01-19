package com.example.developer.android_dev_samples.home;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.developer.android_dev_samples.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HasFragmentInjector, HomeView {

    private static final String FRAG_TAG_HOME_CHILD = "homeChild";

    @Inject
    public HomeFragment() {
        // Required empty public constructor
    }

    //@Inject
    //HomePresenterImpl<HomeView> presenter;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    HomeChildFragment homeChildFragment;

    @BindView(R.id.home_child_frag_container)
    View homeChildContainer;

    Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        addFragment();
        //presenter.onAttach(this);
        return rootView;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public void showKeyboard() {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void showDetails() {
        Timber.d("showing details");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void addFragment() {
      /*  HomeChildFragment homeChildFragment = getHomeChildFragment();
        if (homeChildFragment == null) {
            homeChildFragment = HomeChildFragment.newInstance();
            getFragmentManager().beginTransaction()
                    .add(R.id.home_child_frag_container, homeChildFragment)
                    .commit();
        }*/
        getFragmentManager().beginTransaction()
                .add(R.id.home_child_frag_container, homeChildFragment)
                .commit();
    }

    private HomeChildFragment getHomeChildFragment() {
        return (HomeChildFragment) getFragmentManager().findFragmentByTag(FRAG_TAG_HOME_CHILD);
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
