package com.example.googlemaps.fragment.placeholder;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaceholderContent {
    public static final List<PlaceholderItem> ITEMS = new ArrayList<>();

    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<>();

    public static class PlaceholderItem implements Serializable {
        public final String title;
        public final LatLng description;

        public PlaceholderItem(String title, LatLng description) {
            this.title = String.valueOf(title);
            this.description = description;
        }

        @NonNull
        @Override
        public String toString() {

            return String.valueOf(description);
        }
    }
}