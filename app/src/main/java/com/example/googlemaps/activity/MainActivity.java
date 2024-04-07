package com.example.googlemaps.activity;

// Import all necessary libraries.
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.googlemaps.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.googlemaps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using View Binding.
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set the app toolbar as the action bar.
        setSupportActionBar(binding.appBarMain.toolbar);

        // Initialize DrawerLayout and Navigation View.
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_campus, R.id.nav_map)
                .setOpenableLayout(drawer)
                .build();

        // Obtain NavController for navigation.
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_content_main);

        // Set up the action bar (toolbar) with NavController.
        NavigationUI.setupActionBarWithNavController(this,
                navController, mAppBarConfiguration);

        // Connect the NavigationView with the NavController.
        NavigationUI.setupWithNavController(navigationView, navController);

        // Set a listener for navigation item clicks in NavigationView.
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // Mark the selected menu item as checked.
                menuItem.setChecked(true);

                // Get the ID of selected menu item.
                int id = menuItem.getItemId();

                // Navigate based on selected menu item.
                if(id == R.id.nav_home){
                    navController.navigate(R.id.nav_home);
                }
                else if(id == R.id.nav_campus){
                    navController.navigate(R.id.nav_campus);
                }
                else if(id == R.id.nav_map){
                    navController.navigate(R.id.nav_map);
            }
                // Close the navigation drawer.
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawers();

                // Indicate the item selection was successful.
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Navigate hierarchy true if successful, otherwise fallback to default behavior.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}