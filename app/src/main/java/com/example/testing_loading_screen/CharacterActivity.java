package com.example.testing_loading_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.testing_loading_screen.databinding.ActivityCharacterBinding;
import com.example.testing_loading_screen.databinding.ActivityDashboardBinding;
import com.example.testing_loading_screen.databinding.KamatisDialogBinding;
import com.example.testing_loading_screen.getready_dialogs.GetRedyCharacterDialog;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class CharacterActivity extends DrawerBaseActivity {

    ActivityCharacterBinding activityCharacterBinding;

    CircleImageView char_kam, char_sin, char_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activityCharacterBinding = ActivityCharacterBinding.inflate(getLayoutInflater());
        setContentView(activityCharacterBinding.getRoot());
        allocateActivityTitle("Character");

        char_kam = (CircleImageView) findViewById(R.id.char1);
        char_sin = (CircleImageView) findViewById(R.id.char2);
        char_lock = (CircleImageView) findViewById(R.id.char4);

    }

    @Override
    protected void onStart() {
        super.onStart();

        GetRedyCharacterDialog kamatisDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.kamatis));
        kamatisDialog.setupDialog(getString(R.string.kamatis_title), getString(R.string.kamatis_description));


        char_kam.setOnClickListener(view -> {
            kamatisDialog.show();
        });
    }
}


