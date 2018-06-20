package com.android.dhara.muviapp.home.category.view;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.home.model.CategoryModelAdapter;

public final class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryVH> {
    private final CategoryModelAdapter modelAdapter;
    private final CategoryListener listener;

    static CategoryAdapter createFrom(final CategoryModelAdapter modelAdapter,
                                             final CategoryListener listener) {
        return new CategoryAdapter(modelAdapter, listener);
    }

    private CategoryAdapter(final CategoryModelAdapter modelAdapter,
                            final CategoryListener listener) {
        this.modelAdapter = modelAdapter;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new CategoryVH(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryVH holder, final int position) {
        holder.txtDescription.setText(modelAdapter.getDescription(position));
        holder.txtCategoryName.setText(modelAdapter.getCategoryName(position));

        holder.txtDescription.setTextColor(ContextCompat.getColor(holder.itemView.getContext(),
                modelAdapter.getTextColor(position)));
        holder.txtCategoryName.setTextColor(ContextCompat.getColor(holder.itemView.getContext(),
                modelAdapter.getTextColor(position)));

        holder.itemView.setBackground(modelAdapter.getBackgroundDrawable(position));
    }

    @Override
    public int getItemCount() {
        return modelAdapter.getCount();
    }

    static class CategoryVH extends RecyclerView.ViewHolder {
        TextView txtCategoryName;
        TextView txtDescription;

        CategoryVH(final View itemView, final CategoryListener listener) {
            super(itemView);

            txtCategoryName = itemView.findViewById(R.id.txt_category);
            txtDescription = itemView.findViewById(R.id.txt_description);

            itemView.setOnClickListener(v -> {
                final int pos = getAdapterPosition();
                if (pos == RecyclerView.NO_POSITION) {
                    return;
                }
                listener.onCategoryClicked(pos);
            });
        }
    }
}
