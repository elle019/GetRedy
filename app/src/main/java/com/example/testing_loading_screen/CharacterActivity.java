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

import com.example.testing_loading_screen.databinding.ActivityCharacterBinding;
import com.example.testing_loading_screen.databinding.ActivityDashboardBinding;
import com.example.testing_loading_screen.databinding.KamatisDialogBinding;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class CharacterActivity extends DrawerBaseActivity {

    ActivityCharacterBinding activityCharacterBinding;

    Dialog dialog_characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activityCharacterBinding = ActivityCharacterBinding.inflate(getLayoutInflater());
        setContentView(activityCharacterBinding.getRoot());
        allocateActivityTitle("Character");
        CircleImageView char_kam = (CircleImageView) findViewById(R.id.char1);
        CircleImageView char_sin = (CircleImageView) findViewById(R.id.char2);
        CircleImageView char_lock = (CircleImageView) findViewById(R.id.char4);
        dialog_characters = new Dialog(this);
        char_kam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kamatis_Dialog();
            }
        });

        char_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                singkamas_Dialog();
            }
        });

        char_lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                charLocked_Dialog();
        }
        });
    }

        private void kamatis_Dialog() {
            dialog_characters.setContentView(R.layout.kamatis_dialog);
            dialog_characters.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog_characters.show();
            ImageView imageView2 = dialog_characters.findViewById(R.id.imageView2);

            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_characters.dismiss();
                }
            });
            dialog_characters.show();
        }
    private void singkamas_Dialog() {
        dialog_characters.setContentView(R.layout.singkamas_dialog);
        dialog_characters.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_characters.show();
        ImageView imageView2 = dialog_characters.findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_characters.dismiss();
            }
        });
        dialog_characters.show();
    }
    private void charLocked_Dialog() {
        dialog_characters.setContentView(R.layout.locked_char_dialog);
        dialog_characters.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_characters.show();
        ImageView imageView2 = dialog_characters.findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_characters.dismiss();
            }
        });
        dialog_characters.show();
    }

    }


