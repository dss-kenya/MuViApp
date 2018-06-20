package com.android.dhara.muviapp.home.collections.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.home.collections.model.CollectionsModelAdapter;
import com.bumptech.glide.Glide;
import com.mikepenz.iconics.view.IconicsTextView;

public final class CollectionsAdapter extends RecyclerView.Adapter<CollectionsAdapter.ViewHolder> {
    private final CollectionsModelAdapter modelAdapter;
    private ViewInteractionListener listener;

    public static CollectionsAdapter createFrom(final CollectionsModelAdapter modelAdapter,
                                                final ViewInteractionListener listener) {
        return new CollectionsAdapter(modelAdapter, listener);
    }

    private CollectionsAdapter(final CollectionsModelAdapter modelAdapter,
                               final ViewInteractionListener listener) {
        this.modelAdapter = modelAdapter;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_collection, parent, false);
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtCollectionName.setText(modelAdapter.getMuViName(position));
        holder.txtDesc.setText(modelAdapter.getMuViDesc(position));
        holder.iconFontViews.setText(holder.itemView.getContext().getString(R.string.icon_font_views,
                modelAdapter.getNumberOfViews(position)));

        Glide.with(holder.itemView.getContext()).asBitmap()
                .load(modelAdapter.getVideoPath(position))
                .into(holder.imgCollection);


    }

    @Override
    public int getItemCount() {
        return modelAdapter.getCount();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCollectionName;
        TextView txtDesc;
        ImageView imgCollection;
        IconicsTextView iconFontViews;

        ViewHolder(final View itemView, final ViewInteractionListener listener) {
            super(itemView);
            iconFontViews = itemView.findViewById(R.id.icon_font_views);
            imgCollection = itemView.findViewById(R.id.img_collection);
            txtCollectionName = itemView.findViewById(R.id.txt_title);
            txtDesc = itemView.findViewById(R.id.txt_description);

            itemView.setOnClickListener(view -> {
                final int pos = getAdapterPosition();

                if (pos == RecyclerView.NO_POSITION) {
                    return;
                }

                listener.onMuViCollectionClicked(pos);
            });
        }
    }
}
