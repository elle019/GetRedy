package com.example.testing_loading_screen.getready_dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testing_loading_screen.R;

import java.util.concurrent.Callable;

public class GetRedyCharacterDialog implements IGetRedyDialog {
    Dialog getRedyCharacterDialog;

    TextView dialogTitle, dialogContentText;
    ImageView characterImage, closeButton;
    Drawable characterImageDrawable;

    public GetRedyCharacterDialog(Activity activity, Drawable characterImageResource) {
        getRedyCharacterDialog = new Dialog(activity);

        getRedyCharacterDialog.setContentView(R.layout.dialog_getredy_character_template);
        getRedyCharacterDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialogTitle = (TextView) getRedyCharacterDialog.findViewById(R.id.dialog_title_text);
        dialogContentText = (TextView) getRedyCharacterDialog.findViewById(R.id.dialog_content_text);
        characterImage = (ImageView) getRedyCharacterDialog.findViewById(R.id.character_image_view);
        closeButton = (ImageView) getRedyCharacterDialog.findViewById(R.id.dialog_close_btn);

        characterImageDrawable = characterImageResource;
    }

    @Override
    public void setupDialog(String titleText, String contentText) {
        dialogTitle.setText(titleText);
        dialogContentText.setText(contentText);

        characterImage.setImageDrawable(characterImageDrawable);

        closeButton.setOnClickListener(view -> {
            dismiss();
        });
    }


    @Override
    public void dismiss() {
        getRedyCharacterDialog.dismiss();
    }

    @Override
    public void show() {
        getRedyCharacterDialog.show();
    }
}