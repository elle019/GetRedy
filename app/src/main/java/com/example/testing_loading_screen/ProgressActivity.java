package com.example.testing_loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.testing_loading_screen.databinding.ActivityHelpBinding;
import com.example.testing_loading_screen.databinding.ActivityProgressBinding;

public class ProgressActivity extends DrawerBaseActivity {

    ActivityProgressBinding activityProgressBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        activityProgressBinding = ActivityProgressBinding.inflate(getLayoutInflater());
        setContentView(activityProgressBinding.getRoot());

        allocateActivityTitle("Progress");
    }
}