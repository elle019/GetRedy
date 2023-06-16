package com.example.testing_loading_screen;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.content.res.AppCompatResources;

import com.example.testing_loading_screen.databinding.ActivityCharacterBinding;
import com.example.testing_loading_screen.getready_dialogs.GetRedyCharacterDialog;

import de.hdodenhof.circleimageview.CircleImageView;

public class CharacterActivity extends DrawerBaseActivity {

    ActivityCharacterBinding activityCharacterBinding;

    Dialog dialog_characters;
    ImageView char_kamatis, char_singkamas, char_sibuyas, char_talong, char_sigarilyas, char_mani,
            char_sitaw, char_bataw, char_patani, char_kundol, char_patola, char_upo, char_kalabas,
            char_labanos, char_mustasa, char_bawang, char_luya, char_linga, char_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activityCharacterBinding = ActivityCharacterBinding.inflate(getLayoutInflater());
        setContentView(activityCharacterBinding.getRoot());
        allocateActivityTitle("Character");

//        char_singkamas = (CircleImageView) findViewById(R.id.char1);
//        char_talong = (CircleImageView) findViewById(R.id.char2);
//        char_sigarilyas = (CircleImageView) findViewById(R.id.char3);
//        char_mani = (CircleImageView) findViewById(R.id.char4);
//        char_sitaw = (CircleImageView) findViewById(R.id.char5);
//        char_bataw = (CircleImageView) findViewById(R.id.char6);
//        char_patani = (CircleImageView) findViewById(R.id.char7);
//        char_kundol = (CircleImageView) findViewById(R.id.char8);
//        char_patola = (CircleImageView) findViewById(R.id.char9);
//        char_upo = (CircleImageView) findViewById(R.id.char10);
//        char_kalabas = (CircleImageView) findViewById(R.id.char11);
//        char_labanos = (CircleImageView) findViewById(R.id.char12);
//        char_mustasa = (CircleImageView) findViewById(R.id.char13);
//        char_sibuyas = (CircleImageView) findViewById(R.id.char14);
//        char_kamatis = (CircleImageView) findViewById(R.id.char15);
//        char_bawang= (CircleImageView) findViewById(R.id.char16);
//        char_luya = (CircleImageView) findViewById(R.id.char17);
//        char_linga = (CircleImageView) findViewById(R.id.char18);
        //lock
        //char_lock = (CircleImageView) findViewById(R.id.char4);

    }

    protected void onStart() {
        super.onStart();

//        //CHARACTERS DESCRIPTION
//        GetRedyCharacterDialog singkamasDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.singkamas_asset));
//        singkamasDialog.setupDialog(getString(R.string.singkamas_title), getString(R.string.singkamas_description));
//
//        char_singkamas.setOnClickListener(view -> {
//            singkamasDialog.show();
//        });
//
//        GetRedyCharacterDialog talongDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.talong_asset));
//        talongDialog.setupDialog(getString(R.string.talong_title), getString(R.string.talong_description));
//
//        char_talong.setOnClickListener(view -> {
//            talongDialog.show();
//        });
//
//        GetRedyCharacterDialog sigarilyasDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.sigarilyas_asset));
//        sigarilyasDialog.setupDialog(getString(R.string.sigarilyas_title), getString(R.string.sigarilyas_description));
//
//        char_sigarilyas.setOnClickListener(view -> {
//            sigarilyasDialog.show();
//        });
//        GetRedyCharacterDialog maniDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.mani_asset1));
//        maniDialog.setupDialog(getString(R.string.mani_title), getString(R.string.mani_description));
//
//        char_mani.setOnClickListener(view -> {
//            maniDialog.show();
//        });
//        GetRedyCharacterDialog sitawDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.sitaw_asset));
//        sitawDialog.setupDialog(getString(R.string.sitaw_title), getString(R.string.sitaw_description));
//
//        char_sitaw.setOnClickListener(view -> {
//            sitawDialog.show();
//        });
//        GetRedyCharacterDialog batawDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.bataw_asset));
//        batawDialog.setupDialog(getString(R.string.bataw_title), getString(R.string.bataw_description));
//
//        char_bataw.setOnClickListener(view -> {
//            batawDialog.show();
//        });
//        GetRedyCharacterDialog pataniDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.patani_asset));
//        pataniDialog.setupDialog(getString(R.string.patani_title), getString(R.string.patani_description));
//
//        char_patani.setOnClickListener(view -> {
//            pataniDialog.show();
//        });
//        GetRedyCharacterDialog kundolDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.kundol_asset));
//        kundolDialog.setupDialog(getString(R.string.kundol_title), getString(R.string.kundol_description));
//
//        char_kundol.setOnClickListener(view -> {
//            kundolDialog.show();
//        });
//        GetRedyCharacterDialog patolaDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.patola_asset));
//        patolaDialog.setupDialog(getString(R.string.patola_title), getString(R.string.patola_description));
//
//        char_patola.setOnClickListener(view -> {
//            patolaDialog.show();
//        });
//        GetRedyCharacterDialog upoDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.upo_asset));
//        upoDialog.setupDialog(getString(R.string.upo_title), getString(R.string.upo_description));
//
//        char_upo.setOnClickListener(view -> {
//            upoDialog.show();
//        });
//        GetRedyCharacterDialog kalabasaDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.kalabasa_asset));
//        kalabasaDialog.setupDialog(getString(R.string.kalabasa_title), getString(R.string.kalabasa_description));
//
//        char_kalabas.setOnClickListener(view -> {
//            kalabasaDialog.show();
//        });
//        GetRedyCharacterDialog labanosDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.labanos_asset));
//        labanosDialog.setupDialog(getString(R.string.labanos_title), getString(R.string.labanos_description));
//
//        char_labanos.setOnClickListener(view -> {
//            labanosDialog.show();
//        });
//        GetRedyCharacterDialog mustasaDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.mustasa_asset));
//        mustasaDialog.setupDialog(getString(R.string.mustasa_title), getString(R.string.mustasa_description));
//
//        char_mustasa.setOnClickListener(view -> {
//            mustasaDialog.show();
//        });
//        GetRedyCharacterDialog sibuyasDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.sibuyas_asset));
//        sibuyasDialog.setupDialog(getString(R.string.sibuyas_title), getString(R.string.sibuyas_description));
//
//        char_sibuyas.setOnClickListener(view -> {
//            sibuyasDialog.show();
//        });
//
//        GetRedyCharacterDialog kamatisDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.kamatis_asset));
//        kamatisDialog.setupDialog(getString(R.string.kamatis_title), getString(R.string.kamatis_description));
//
//        char_kamatis.setOnClickListener(view -> {
//            kamatisDialog.show();
//        });
//        GetRedyCharacterDialog bawangDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.bawang_asset));
//        bawangDialog.setupDialog(getString(R.string.bawang_title), getString(R.string.bawang_description));
//
//        char_bawang.setOnClickListener(view -> {
//            bawangDialog.show();
//        });
//        GetRedyCharacterDialog luyaDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.luya_asset));
//        luyaDialog.setupDialog(getString(R.string.luya_title), getString(R.string.luya_description));
//
//        char_luya.setOnClickListener(view -> {
//            luyaDialog.show();
//        });
//        GetRedyCharacterDialog lingaDialog = new GetRedyCharacterDialog(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.linga_asset));
//        lingaDialog.setupDialog(getString(R.string.linga_title), getString(R.string.linga_description));
//
//        char_linga.setOnClickListener(view -> {
//            lingaDialog.show();
//        });


        //LOCKED
      /*  DialogCharacterTemplate lockedDialog = new DialogCharacterTemplate(CharacterActivity.this, AppCompatResources.getDrawable(CharacterActivity.this, R.drawable.mystplant));
        lockedDialog.setupDialog(getString(R.string.locked_title), getString(R.string.locked_description));

        char_lock.setOnClickListener(view -> {
            lockedDialog.show();
      });
    */
    }
}




