package com.android.dhara.muviapp;

import android.support.v4.app.Fragment;

import com.android.dhara.muviapp.dagger2.components.DaggerFragmentComponent;
import com.android.dhara.muviapp.dagger2.components.FragmentComponent;
import com.android.dhara.muviapp.dagger2.modules.FragmentModule;

public class BaseFragment extends Fragment {
    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .muViAppComponent(((MuViApp) getActivity().getApplication()).getMuViAppComponent())
                .appComponent(((MuViApp) getActivity().getApplication()).getAppComponent())
                .fragmentModule(new FragmentModule(getActivity()))
                .build();
    }
}
