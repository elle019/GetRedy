package com.example.testing_loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.testing_loading_screen.databinding.ActivityAmbienceBinding;
import com.example.testing_loading_screen.databinding.ActivitySettingsBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class AmbienceActivity extends DrawerBaseActivity {

    ActivityAmbienceBinding activityAmbienceBinding;
    Dialog dialog_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activityAmbienceBinding = ActivityAmbienceBinding.inflate(getLayoutInflater());
        setContentView(activityAmbienceBinding.getRoot());
        allocateActivityTitle("Ambience");

        CircleImageView amb_rain = (CircleImageView) findViewById(R.id.amb2);
        final MediaPlayer sound_rain = MediaPlayer.create(this, R.raw.rain);
        CircleImageView amb_fireplace = (CircleImageView) findViewById(R.id.amb3);
        final MediaPlayer sound_fire = MediaPlayer.create(this, R.raw.fireplace);
        CircleImageView amb_forest = (CircleImageView) findViewById(R.id.amb1);
        final MediaPlayer sound_forest = MediaPlayer.create(this, R.raw.forest);
        CircleImageView locked_amb = (CircleImageView) findViewById(R.id.amb6);
        dialog_sounds = new Dialog(this);
        amb_rain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound_rain.start();
            }
        });
        amb_fireplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound_fire.start();
            }
        });
        amb_forest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound_forest.start();
            }
        });

        locked_amb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            lockedSound_Dialog();
           }
         });
       }
    private void lockedSound_Dialog() {
        dialog_sounds.setContentView(R.layout.locked_sound_dialog);
        dialog_sounds.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_sounds.show();
        ImageView imageView2 = dialog_sounds.findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_sounds.dismiss();
            }
        });
        dialog_sounds.show();
    }
}