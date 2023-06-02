package com.example.testing_loading_screen;

import androidx.annotation.Nullable;

import android.app.Dialog;
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
import android.widget.Toast;

import com.example.testing_loading_screen.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.util.Locale;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class MainActivity extends DrawerBaseActivity{

    ActivityMainBinding activityMainBinding;

    CircularSeekBar slider_circle;
    Button redy_button;
    CountDownTimer countdown;
    Boolean counterIsActive = false;
    TextView timePreset;
    MediaPlayer mediaPlayer;
    AnimationDrawable tomato_animation;
    Dialog dialog_set_a_time;

    int defaultSliderCircleValue = 300;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.nav_activity_main);

        // Shows the navbar on top of the activity
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // Sets the title of the activity
        allocateActivityTitle("Home");

        slider_circle = findViewById(R.id.slider_circle);
        slider_circle.setMax(3900);
        slider_circle.setProgress(defaultSliderCircleValue);

        timePreset = findViewById(R.id.time_preset);
        redy_button = findViewById(R.id.redy_button);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.chime);

        dialog_set_a_time = new Dialog(this);

        ImageView imageView = (ImageView) findViewById(R.id.kamatis);
        imageView.setBackgroundResource(R.drawable.tomato_animation);
        tomato_animation = (AnimationDrawable) imageView.getBackground();
    }

    @Override
    protected void onStart() {
        super.onStart();

        slider_circle.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(@Nullable CircularSeekBar circularSeekBar, float progress, boolean b) {
                update((int) progress);
            }

            @Override
            public void onStopTrackingTouch(@Nullable CircularSeekBar circularSeekBar) {}

            @Override
            public void onStartTrackingTouch(@Nullable CircularSeekBar circularSeekBar) {}
        });
    }

    private void update(int progress) {
        int min = progress / 60;
        int sec = progress % 60;

        slider_circle.setProgress(progress);
        timePreset.setText(String.format(Locale.getDefault(), "%02d:%02d", min, sec));
    }

    public void timer_starts(View view) {
        if (!counterIsActive) {
            counterIsActive = true;

            slider_circle.setEnabled(false);

            redy_button.setText(R.string.stopTimerButtonLabel);

            countdown = new CountDownTimer((long) (slider_circle.getProgress() * 1000), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    update((int) millisUntilFinished / 1000);
                    tomato_animation.start();
                }

                @Override
                public void onFinish() {
                    tomato_animation.stop();

                    // Plays chime after timer is finished
                    mediaPlayer.start();

                    finishTimerDialog();
                    reset();
                }
            }.start();
        } else {
            cancelTimerDialog();

            tomato_animation.stop();

            reset();
        }
    }

    private void finishTimerDialog(){
        dialog_set_a_time.setContentView(R.layout.dialog);
        dialog_set_a_time.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_set_a_time.show();

        ImageView closeButton = dialog_set_a_time.findViewById(R.id.imageView2);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_set_a_time.dismiss();
            }
        });
        dialog_set_a_time.show();
    }

    private void cancelTimerDialog(){
        dialog_set_a_time.setContentView(R.layout.dialog_cancel_timer);
        dialog_set_a_time.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_set_a_time.show();

        ImageView closeButton = dialog_set_a_time.findViewById(R.id.imageView2);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_set_a_time.dismiss();
            }
        });
        dialog_set_a_time.show();
    }

    private void reset() {
        timePreset.setText(R.string.defaultTimerValue);
        slider_circle.setProgress(defaultSliderCircleValue);
        countdown.cancel();
        redy_button.setText(R.string.startTimerButtonLabel);
        slider_circle.setEnabled(true);
        counterIsActive = false;
    }
}