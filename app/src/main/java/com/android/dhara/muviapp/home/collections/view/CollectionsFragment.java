package com.android.dhara.muviapp.home.collections.view;

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
import com.android.dhara.muviapp.home.collections.presenter.CollectionsPresenter;
import com.android.dhara.muviapp.utils.ConstantIntentExtra;

import javax.inject.Inject;

public class CollectionsFragment extends BaseFragment {
    @Inject
    CollectionsPresenter presenter;

    @Inject
    CollectionsView collectionsView;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.handleOnDestroyView();
    }

    public static void loadFragment(final FragmentActivity activity, final Bundle bundle) {
        final FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_content, CollectionsFragment.newInstance(bundle));
        ft.addToBackStack("collections_frag");
        ft.commit();
    }

    public static CollectionsFragment newInstance(final Bundle bundle) {
        final CollectionsFragment fragment = new CollectionsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        long categoryId = -1;
        if (getArguments() != null) {
            categoryId = getArguments().getLong(ConstantIntentExtra.EXTRA_CATEGORY_ID);
        }
        presenter.handleOnViewCreated(categoryId, collectionsView);
    }
}
