package com.example.allpurposeflour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.RouteListingPreference;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.allpurposeflour.Fragments.Fragment_2D_Main;
import com.example.allpurposeflour.Fragments.Fragment_3D_Main;
import com.example.allpurposeflour.Fragments.Fragment_Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private boolean is_logged_in;
    Fragment_2D_Main fragment2DMain = new Fragment_2D_Main();
    Fragment_3D_Main fragment3DMain = new Fragment_3D_Main();
    BottomNavigationView main_bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment(fragment2DMain);
        main_bottomNav = findViewById(R.id.main_bottomNav);
        main_bottomNav.setOnItemSelectedListener(navListener);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            if (extras.getBoolean("isLoggedIn")){
                is_logged_in = true;
            }
            else{
                is_logged_in = false;
            }
        }
    }
    private void setFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_frame, fragment);
        transaction.commit();
    }
    private NavigationBarView.OnItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.menu_2d) {
                setFragment(fragment2DMain);
                return true;
            }
            if (item.getItemId() == R.id.menu_3d) {
                setFragment(fragment3DMain);
                return true;
            }
            if (item.getItemId() == R.id.profile) {
                setFragment(new Fragment_Profile(is_logged_in));
                return true;
            }
            return false;
        }
    };
}