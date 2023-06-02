package com.example.testing_loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.testing_loading_screen.getready_dialogs.GetRedyTextDialog;

public class OptionModeActivity extends AppCompatActivity {

    Button normalModeButton, storyModeButton;
    GetRedyTextDialog normalModeDialog, storyModeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_option_mode);

        normalModeButton = (Button) findViewById(R.id.button_normalmode);
        storyModeButton = (Button) findViewById(R.id.button_storymode);

        normalModeDialog = new GetRedyTextDialog(OptionModeActivity.this);
        normalModeDialog.setupDialog("Normal Mode", getString(R.string.dialog_normal_mode_text));
        normalModeDialog.setOnSubmit(() -> {
            startActivity(new Intent(OptionModeActivity.this, MainActivity.class));
            finish();

            return null;
        });

        storyModeDialog = new GetRedyTextDialog(OptionModeActivity.this);
        storyModeDialog.setupDialog("Story Mode", getString(R.string.dialog_story_mode_text));
        storyModeDialog.setOnSubmit(() -> {
            startActivity(new Intent(OptionModeActivity.this, MainActivity.class));
            finish();

            return null;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        normalModeButton.setOnClickListener(view -> normalModeDialog.show());

        storyModeButton.setOnClickListener(view -> storyModeDialog.show());
    }
}