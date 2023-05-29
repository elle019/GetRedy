package com.example.testing_loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.testing_loading_screen.databinding.ActivityProgressBinding;
import com.example.testing_loading_screen.databinding.ActivityTaskBinding;

public class TaskActivity extends DrawerBaseActivity {

    ActivityTaskBinding activityTaskBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activityTaskBinding = ActivityTaskBinding.inflate(getLayoutInflater());
        setContentView(activityTaskBinding.getRoot());
        allocateActivityTitle("To Do List");
    }
}



