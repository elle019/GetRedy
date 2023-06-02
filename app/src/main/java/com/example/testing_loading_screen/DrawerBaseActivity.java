package com.example.testing_loading_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        
        switch(item.getItemId()){
            case R.id.nav_home:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_character:
                startActivity(new Intent(this, CharacterActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_ambience:
                startActivity(new Intent(this, AmbienceActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_task:
                startActivity(new Intent(this, TaskActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_progress:
                startActivity(new Intent(this, ProgressActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_help:
                startActivity(new Intent(this, HelpActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_logout:
                SharedPreferences sharedPref = getSharedPreferences(getString(R.string.appSharedPrefFile), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean(getString(R.string.sharedPrefIsLoggedInKey), false);
                editor.apply();

                startActivity(new Intent(this, LoginRegisterActivity.class));
                overridePendingTransition(0,0);
                break;
        }

        finish();
        return false;
    }

    protected void allocateActivityTitle(String titleString){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(titleString);
        }
    }
}