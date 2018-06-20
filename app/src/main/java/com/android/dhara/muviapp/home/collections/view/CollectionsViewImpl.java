package com.android.dhara.muviapp.home.collections.view;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.home.collections.model.CollectionsModelAdapter;
import com.android.dhara.muviapp.home.event.ToggleUpdateEvent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public class CollectionsViewImpl implements CollectionsView, View.OnClickListener {
    private static final int SPAN_COUNT = 2;
    private final FragmentActivity activity;
    private RecyclerView rvCollections;
    private View progressView;
    private VideoView videoView;
    private ImageView imgClose;
    private View videoFrameView;
    private CollectionsModelAdapter modelAdapter;
    private ViewInteractionListener listener;

    @Inject
    public CollectionsViewImpl(final FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void initViews(final CollectionsModelAdapter modelAdapter, final ViewInteractionListener listener) {
        EventBus.getDefault().post(ToggleUpdateEvent.create(false));

        videoFrameView = activity.findViewById(R.id.video_container);
        imgClose = activity.findViewById(R.id.img_close);
        videoView = activity.findViewById(R.id.video_view);
        rvCollections = activity.findViewById(R.id.rv_collections);
        progressView = activity.findViewById(R.id.lnr_progress_view);

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(SPAN_COUNT,
                StaggeredGridLayoutManager.VERTICAL);

        rvCollections.setHasFixedSize(true);
        rvCollections.setLayoutManager(layoutManager);

        this.listener = listener;
        this.modelAdapter = modelAdapter;
        final CollectionsAdapter adapter = CollectionsAdapter.createFrom(modelAdapter, listener);
        rvCollections.setAdapter(adapter);

        imgClose.setOnClickListener(this);
    }

    @Override
    public void updateData(final CollectionsModelAdapter modelAdapter) {
        this.modelAdapter = modelAdapter;
        final CollectionsAdapter adapter = CollectionsAdapter.createFrom(modelAdapter, listener);
        rvCollections.swapAdapter(adapter, false);
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
        Snackbar.make(rvCollections, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void playVideo(final int position) {
        videoFrameView.setVisibility(View.VISIBLE);
        videoView.setVideoPath(modelAdapter.getVideoPath(position));
        videoView.start();
    }

    @Override
    public void handleOnDestroy() {
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
            videoView.suspend();
            videoView.setVideoURI(null);
        }
        videoFrameView.setVisibility(View.GONE);
        videoView.setVisibility(View.GONE);
        videoView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.img_close) {
            handleOnDestroy();
        }
    }
}
