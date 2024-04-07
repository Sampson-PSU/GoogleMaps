package com.example.googlemaps.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.googlemaps.R;
import com.example.googlemaps.fragment.placeholder.PlaceholderContent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.SquareCap;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.List;

public class MapsFragment extends Fragment implements View.OnClickListener {
    private GoogleMap mMap;
    private SearchView mSearchView;
    private SupportMapFragment supportMapFragment;
    private View rootView;
    private TextView textViewOption1, textViewOption2, textViewOption3, textViewOption4;
    private FloatingActionButton mFloatingActionButton;
    private PlaceholderContent.PlaceholderItem placeholderItem;

    private final OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            mMap = googleMap;
            createSearchViewListener();
            if(placeholderItem != null) {
                mMap.addMarker(new MarkerOptions().position(placeholderItem.description).title(placeholderItem.title));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeholderItem.description,7));
                placeholderItem = null;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if (bundle != null) {
            placeholderItem = (PlaceholderContent.PlaceholderItem)
                    bundle.getSerializable("campusLocation");
        }

        rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        textViewOption1 = rootView.findViewById(R.id.option_clear_map);
        textViewOption2 = rootView.findViewById(R.id.option_add_marker);
        textViewOption3 = rootView.findViewById(R.id.option_create_polylines);
        textViewOption4 = rootView.findViewById(R.id.option_create_polygons);

        mFloatingActionButton = rootView.findViewById(R.id.fab);

        textViewOption1.setOnClickListener(this);
        textViewOption2.setOnClickListener(this);
        textViewOption3.setOnClickListener(this);
        textViewOption4.setOnClickListener(this);

        mFloatingActionButton.setOnClickListener(this);

        mSearchView = rootView.findViewById(R.id.idSearchView);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize map fragment.
        supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.nav_map);

        // Async map.
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(callback);
        }
    }

    private void showOptionsMenu() {
        ConstraintLayout optionsMenu = rootView.findViewById(R.id.options_menu);
        if (optionsMenu.getVisibility() == View.VISIBLE) {
            // Hide the options menu.
            optionsMenu.setVisibility(View.GONE);
        } else {
            // Show the options menu.
            optionsMenu.setVisibility(View.VISIBLE);
        }
    }

    public void addMarker(String location, LatLng coordinates) {
        mMap.addMarker(new MarkerOptions().position(coordinates).title(location));
        // Moves the camera to a specific location, without changing the zoom of the map.
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates));

        // Moves the camera to a specific location, and set up the zoom.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 9));
    }

    private void createMarkerOnLocation() {
        String harrisburgCampus = "Penn State - Harrisburg";
        String hersheyCampus = "Penn State - Hershey";
        String yorkCampus = "Penn State - York";


        // Represent Penn State campus locations we need to use LatLng.
        LatLng harrisburg= new LatLng(40.258655,-76.894376);
        addMarker(harrisburgCampus, harrisburg);

        LatLng hershey = new LatLng(40.269748,-76.636357);
        addMarker(hersheyCampus, hershey);

        LatLng york = new LatLng(39.962998,-76.727139);
        addMarker(yorkCampus, york);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab) {
            showOptionsMenu();
        } else if (id == R.id.option_clear_map) {
            mMap.clear();
        } else if (id == R.id.option_add_marker) {
            createMarkerOnLocation();
        } else if (id == R.id.option_create_polylines) {
            createPolylinesOnMap();
        } else if (id == R.id.option_create_polygons) {
            createPolygonsOnMap();
        }
    }

    private void createPolygonsOnMap() {
        // Define the Coordinates  for Polygon A.
        LatLng columbus = new LatLng(39.96712, -82.9988);
        LatLng newYork = new LatLng(40.7128, -74.0060);
        LatLng philadelphia = new LatLng(39.9526, -75.1652);
        LatLng nashville = new LatLng(36.1627, -86.7816);

        // Configuring polygon A.
        Polygon polygonA = mMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(columbus, nashville, philadelphia, newYork));
        polygonA.setTag("Polygon A");

        // Define Coordinates for Polygon B.
        LatLng miami = new LatLng(25.7617, -80.1918);
        LatLng orlando = new LatLng(28.5383, -81.3792);
        LatLng jacksonville = new LatLng(30.3322, -81.6557);
        LatLng tampa = new LatLng(27.9506, -82.4572);

        // Configuring polygon B.
        Polygon polygonB = mMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(miami, orlando, jacksonville, tampa));
        polygonB.setTag("Polygon B");

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jacksonville, 4));
    }

    private void createPolylinesOnMap() {
        // Define the Coordinates.
        LatLng abington = new LatLng(39.88211, -75.337234);
        LatLng altoona = new LatLng(40.489433, -78.349874);
        LatLng beaver = new LatLng(41.19368, -79.588940);

        // Add markers to specific location.
        mMap.addMarker(new MarkerOptions().position(abington).title("Abington, PA"));
        mMap.addMarker(new MarkerOptions().position(altoona).title("Altoona, PA"));
        mMap.addMarker(new MarkerOptions().position(beaver).title("Beaver, PA"));

        // Configure the PolylineOptions to be displayed in map.
        PolylineOptions polylineOptions = new PolylineOptions()
                .width(15)
                .color(Color.RED)
                .startCap(new SquareCap())
                .endCap(new SquareCap());
        // Add the coordinates to be included in the Polyline.
        polylineOptions.add(abington, altoona, beaver);
        // Add the polyline to the map.
        mMap.addPolyline(polylineOptions);
        // Call the move camera method to the new coordinate, and adjust the zoom.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(altoona, 6));
    }

    private void createSearchViewListener() {
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Getting the location name from the searchView.
                String locationName = mSearchView.getQuery().toString();
                // Create list of address where we will store the locations found.
                List<Address> addressList = null;
                // Check if the location is null.
                if (locationName != null || locationName.equals("")) {
                    // Initializing the geocode.
                    Geocoder geocoder = new Geocoder(getContext());
                    try {
                        addressList = geocoder.getFromLocationName(locationName, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // Getting the location in the first position.
                    Address address = null;
                    if (addressList != null) {
                        address = addressList.get(0);
                    }
                    // Creating the LatLng object to store the address coordinates.
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    // Add a marker.
                    mMap.addMarker(new MarkerOptions().position(latLng).title(locationName));
                    // Animate the camera.
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        // Call our map fragment to update.
        supportMapFragment.getMapAsync(callback);
    }
}