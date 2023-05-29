package com.example.testing_loading_screen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testing_loading_screen.databinding.ActivityDashboardBinding;
import com.example.testing_loading_screen.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class MainActivity extends DrawerBaseActivity{

    CircularSeekBar slider_circle;
    Button redy_button;
    CountDownTimer countdown;
    Boolean counterisActive = false;
    TextView time_preset;
    MediaPlayer mediaPlayer;
    AnimationDrawable tomato_animation;
    Dialog dialog_set_a_time;


    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.nav_activity_main);

          //as of may 26, this is what is needed to put the nav bar at the top of the home
            activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(activityMainBinding.getRoot());
            allocateActivityTitle("Home");

        slider_circle = findViewById(R.id.slider_circle);
        time_preset = findViewById(R.id.time_preset);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.chime);
        redy_button = findViewById(R.id.redy_button);
        slider_circle.setMax(3900);
        slider_circle.setProgress(300);
        dialog_set_a_time = new Dialog(this);
        ImageView imageView = (ImageView) findViewById(R.id.kamatis);
        imageView.setBackgroundResource(R.drawable.tomato_animation);
        tomato_animation = (AnimationDrawable) imageView.getBackground();
        slider_circle.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {

            @Override
            public void onProgressChanged(@Nullable CircularSeekBar circularSeekBar, float progress, boolean b) {
                update((int) progress);
            }

            @Override
            public void onStopTrackingTouch(@Nullable CircularSeekBar circularSeekBar) {

            }

            @Override
            public void onStartTrackingTouch(@Nullable CircularSeekBar circularSeekBar) {

            }
        });
    }

// deleted the if else statement in this method as of 05/14/23
    private void update(int progress) {
        int mins = progress / 60;
        int sec = progress % 60;
        slider_circle.setProgress(progress);
        String timeFormat = String.format(Locale.getDefault(), "%02d:%02d", mins, sec);
        time_preset.setText(timeFormat);
    }


//app crashes when you first click the button before setting the timer. Use the OpenAlertDialog


    public void timer_starts(View view) {
        if (counterisActive == false) {
            counterisActive = true;
            slider_circle.setEnabled(false);
            redy_button.setText("Stop");
            countdown = new CountDownTimer((long) (slider_circle.getProgress() * 1000), 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    update((int) millisUntilFinished / 1000);
                    tomato_animation.start();

                }

                @Override
                public void onFinish() {
                    tomato_animation.stop();
                    if ( time_preset!= null) {
                        mediaPlayer.start();
                    }
                    openAlertDialog();
                    reset();

                }

            }.start();


        } else {
            cancelAlertDialog();
            // this part works after finishing the task.
            //You could put the break time here to announce something
            tomato_animation.stop();
            reset();

        }
    }


// this method works na. I just don't know where to put it
    private void openAlertDialog(){
        dialog_set_a_time.setContentView(R.layout.dialog);
        dialog_set_a_time.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_set_a_time.show();
        ImageView imageView2 = dialog_set_a_time.findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_set_a_time.dismiss();
            }
        });
        dialog_set_a_time.show();
    }
        //as of 6:30 pm, I have made this work by putting the same dialog name for both dialogs
    private void cancelAlertDialog(){
        dialog_set_a_time.setContentView(R.layout.dialog_cancel_timer);
        dialog_set_a_time.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_set_a_time.show();
        ImageView imageView2 = dialog_set_a_time.findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_set_a_time.dismiss();
            }
        });
        dialog_set_a_time.show();
    }
    private void reset() {
        time_preset.setText("05:00");
        slider_circle.setProgress(300);
        countdown.cancel();
        redy_button.setText("Red-y?");
        slider_circle.setEnabled(true);
        counterisActive = false;
    }
}