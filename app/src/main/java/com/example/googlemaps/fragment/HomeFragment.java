package com.example.googlemaps.fragment;

// Import all necessary libraries.
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.googlemaps.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate fragment layout using view binding.
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot(); // Return root view.
    }

    // Call when fragment view is going to be destroyed.
    // Cleans up any resources associated with the view.
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}