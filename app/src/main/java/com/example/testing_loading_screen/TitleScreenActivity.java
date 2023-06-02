package com.example.testing_loading_screen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class TitleScreenActivity extends AppCompatActivity {

    RelativeLayout title_screen_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_title_screen);

        title_screen_layout = (RelativeLayout) findViewById(R.id.title_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();

        title_screen_layout.setOnClickListener(v -> {
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.appSharedPrefFile), Context.MODE_PRIVATE);

            boolean isLoggedIn = sharedPref.getBoolean(getString(R.string.sharedPrefIsLoggedInKey), false);

            if(isLoggedIn) {
                Intent optionModeScreen = new Intent(getApplicationContext(), OptionModeActivity.class);
                startActivity(optionModeScreen);
            } else {
                Intent loginScreen = new Intent(getApplicationContext(), LoginRegisterActivity.class);
                startActivity(loginScreen);
            }

            finish();
        });
    }
}