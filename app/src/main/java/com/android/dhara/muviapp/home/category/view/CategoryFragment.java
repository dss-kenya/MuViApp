package com.android.dhara.muviapp.home.category.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dhara.muviapp.BaseFragment;
import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.home.category.presenter.CategoryPresenter;
import com.android.dhara.muviapp.home.category.router.CategoryRouter;

import javax.inject.Inject;

public class CategoryFragment extends BaseFragment {
    @Inject
    CategoryPresenter presenter;

    @Inject
    CategoryView categoryView;

    @Inject
    CategoryRouter router;

    public static void loadFragment(final FragmentActivity activity) {
        final FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_content, CategoryFragment.newInstance());
        ft.commit();
    }

    private static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.handleOnViewCreated(categoryView, router);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.handleOnResume();
    }
}
