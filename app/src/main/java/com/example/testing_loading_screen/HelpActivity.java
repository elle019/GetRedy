package com.example.testing_loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.testing_loading_screen.databinding.ActivityCharacterBinding;
import com.example.testing_loading_screen.databinding.ActivityHelpBinding;

public class HelpActivity extends DrawerBaseActivity {

    ActivityHelpBinding activityHelpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activityHelpBinding = ActivityHelpBinding.inflate(getLayoutInflater());
        setContentView(activityHelpBinding.getRoot());
        allocateActivityTitle("Help");
    }
}