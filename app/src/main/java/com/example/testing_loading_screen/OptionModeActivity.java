package com.example.testing_loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class OptionModeActivity extends AppCompatActivity {


    Dialog proceed_dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_option_mode);

        Button normal_mode_button = (Button) findViewById(R.id.button_normalmode);
        Button story_mode_button = (Button) findViewById(R.id.button_storymode);

        proceed_dialog = new Dialog(OptionModeActivity.this);

        normal_mode_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Normal_Mode();
            }
        });
        story_mode_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Story_mode();
            }
        });
    }

    //Does not work.
    private void Normal_Mode() {
        proceed_dialog.setContentView(R.layout.normal_mode_dialog);
        proceed_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        proceed_dialog.show();
        Button yes_button = proceed_dialog.findViewById(R.id.btn_yes);
        Button no_button = proceed_dialog.findViewById(R.id.btn_no);

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_normal_mode = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_normal_mode);
            }
        });

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceed_dialog.dismiss();
            }
        });
    }

    private void Story_mode() {
        proceed_dialog.setContentView(R.layout.story_mode_dialog);
        proceed_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        proceed_dialog.show();
        Button yes1_button = proceed_dialog.findViewById(R.id.btn_yes);
        Button no1_button = proceed_dialog.findViewById(R.id.btn_no);

        yes1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_story_mode = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent_story_mode);
            }
        });
        proceed_dialog.show();

        no1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceed_dialog.dismiss();
            }
        });
        proceed_dialog.show();
    }
}