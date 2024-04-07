package com.example.googlemaps.fragment.placeholder;

// Import all necessary libraries.
import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.LatLng;
import java.io.Serializable;

// Nested static class for placeholder items.
public class PlaceholderContent {

    public static class PlaceholderItem implements Serializable {
        public final String title;
        public final LatLng description;

        public PlaceholderItem(String title, LatLng description) {
            this.title = String.valueOf(title);
            this.description = description;
        }

        // toString() method that returns description.
        @NonNull
        @Override
        public String toString() {

            return String.valueOf(description);
        }
    }
}