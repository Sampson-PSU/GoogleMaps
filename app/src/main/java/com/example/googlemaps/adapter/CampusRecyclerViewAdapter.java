package com.example.googlemaps.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.googlemaps.databinding.FragmentCampusBinding;
import com.example.googlemaps.fragment.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

public class CampusRecyclerViewAdapter extends RecyclerView.Adapter<CampusRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;

    public CampusRecyclerViewAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentCampusBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mTitleView.setText(mValues.get(position).title);
        holder.mDescriptionView.setText(mValues.get(position).description);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitleView;
        public final TextView mDescriptionView;

        public ViewHolder(FragmentCampusBinding binding) {
            super(binding.getRoot());
            mTitleView = binding.titleTextview;
            mDescriptionView = binding.descriptionTextview;
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + mDescriptionView.getText() + "'";
        }
    }
}