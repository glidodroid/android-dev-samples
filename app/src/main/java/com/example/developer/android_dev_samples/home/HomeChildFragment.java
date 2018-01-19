package com.example.developer.android_dev_samples.home;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.developer.android_dev_samples.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeChildFragment extends Fragment implements HomeView {

    @Inject
    HomePresenterImpl<HomeView> presenter;

    @Inject
    public HomeChildFragment() {
        // Required empty public constructor
    }

    public static HomeChildFragment newInstance() {
        return new HomeChildFragment();
    }

    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home_child, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        presenter.onAttach(this);
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
}
