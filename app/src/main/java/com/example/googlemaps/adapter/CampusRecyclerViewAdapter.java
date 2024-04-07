package com.example.googlemaps.adapter;

// Import all necessary libraries.
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.googlemaps.R;
import com.example.googlemaps.databinding.FragmentCampusBinding;
import com.example.googlemaps.fragment.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

public class CampusRecyclerViewAdapter extends RecyclerView.Adapter<CampusRecyclerViewAdapter.ViewHolder> {
    private Fragment fragment;
    private final List<PlaceholderItem> mValues;

    public CampusRecyclerViewAdapter(List<PlaceholderItem> items, Fragment fragment) {
        // Initialize the adapter with a list of PlaceholderItems and a fragment.
        mValues = items;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a ViewHolder for each item view in the RecyclerView.
        return new ViewHolder(FragmentCampusBinding.inflate(LayoutInflater.
                from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // Bind data to the ViewHolder (populate views with data)
        PlaceholderItem placeholderItem = mValues.get(position);

        // Set the title and description in the ViewHolder.
        holder.mTitleView.setText(mValues.get(position).title);
        holder.mDescriptionView.setText(mValues.get(position).description.toString());

        // Set onClickListener for the item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            int isSelected = 1;
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                // Handles item click event.
                if (isSelected == 1) {
                    // If item is selected, change the text color to white.
                    holder.mTitleView.setTextColor(Color.WHITE);
                    NavController navController = NavHostFragment.findNavController(fragment);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("campusLocation", placeholderItem);
                    navController.navigate(R.id.nav_map, bundle);
                    isSelected = 0;
                } else {
                    // If the item is deselected, change the text color to a custom_1 color.
                    holder.mTitleView.setTextColor(R.color.custom_1);
                    isSelected = 1;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // Return total number of items in the list.
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //Declare TextViews for title and description
        public final TextView mTitleView;
        public final TextView mDescriptionView;

        public ViewHolder(FragmentCampusBinding binding) {
            super(binding.getRoot());
            // Initialize the TextViews using View Binding.
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