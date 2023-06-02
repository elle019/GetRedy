package com.example.testing_loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class LoginRegisterActivity extends AppCompatActivity {

    Button loginButton, signinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login_register);

        loginButton = (Button) findViewById(R.id.button_login);
        signinButton = (Button) findViewById(R.id.button_sign);
    }

    @Override
    protected void onStart() {
        super.onStart();

        loginButton.setOnClickListener(v -> {
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.appSharedPrefFile), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(getString(R.string.sharedPrefIsLoggedInKey), true);
            editor.apply();

            Intent intent_login = new Intent(getApplicationContext(), OptionModeActivity.class);
            startActivity(intent_login);

            finish();
        });

        signinButton.setOnClickListener(v -> {
            Intent signInActivity = new Intent(getApplicationContext(), OptionModeActivity.class);
            startActivity(signInActivity);
        });
    }
}