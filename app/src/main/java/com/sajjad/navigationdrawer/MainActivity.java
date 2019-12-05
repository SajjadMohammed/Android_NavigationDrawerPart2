package com.sajjad.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView myText,headerText;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        myText = findViewById(R.id.myText);
        actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, mainToolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);
        //
        View headerView = navigationView.getHeaderView(0);
        headerText = headerView.findViewById(R.id.headerText);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        actionBarDrawerToggle.syncState();
        super.onPostCreate(savedInstanceState);
    }

    NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()){
                case R.id.homeItem:
                    myText.setText("Home");
                    headerText.setText("Home");
                    break;
                case R.id.settingsItem:
                    myText.setText("Settings");
                    break;
                case R.id.aboutItem:
                    myText.setText("About");
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    };

}