package com.android.dhara.muviapp.home.category.view;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.home.event.ToggleUpdateEvent;
import com.android.dhara.muviapp.home.model.CategoryModelAdapter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public class CategoryViewImpl implements CategoryView {
    private static final int SPAN_COUNT = 2;
    private FragmentActivity activity;
    private RecyclerView rvCategories;
    private View progressView;
    private CategoryListener listener;

    @Inject
    public CategoryViewImpl(final FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void initViews(final CategoryModelAdapter modelAdapter, final CategoryListener listener) {
        handleOnResume();

        this.listener = listener;

        rvCategories = activity.findViewById(R.id.rv_categories);
        progressView = activity.findViewById(R.id.lnr_progress_view);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, SPAN_COUNT);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        rvCategories.setHasFixedSize(true);
        rvCategories.setLayoutManager(gridLayoutManager);

        final CategoryAdapter adapter = CategoryAdapter.createFrom(modelAdapter, listener);
        rvCategories.setAdapter(adapter);
    }

    @Override
    public void handleOnResume() {
        EventBus.getDefault().post(ToggleUpdateEvent.create(true));
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(final String message) {
        Snackbar.make(rvCategories, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void updateData(final CategoryModelAdapter modelAdapter) {
        final CategoryAdapter adapter = CategoryAdapter.createFrom(modelAdapter, listener);
        rvCategories.swapAdapter(adapter, false);
    }

    @Override
    public void notifyChanges() {
        rvCategories.getAdapter().notifyDataSetChanged();
    }
}
