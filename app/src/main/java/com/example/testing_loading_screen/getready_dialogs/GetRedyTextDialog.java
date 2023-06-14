package com.example.testing_loading_screen.getready_dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testing_loading_screen.R;

import org.w3c.dom.Text;

import java.util.concurrent.Callable;

public class GetRedyTextDialog implements IGetRedyDialog{
    Dialog getRedyTextDialog;
    TextView dialogTitle, dialogContentText;
    ImageView closeDialogButton;
    Button submitBtn, cancelBtn;

    public GetRedyTextDialog(Activity activity) {
        getRedyTextDialog = new Dialog(activity);

        getRedyTextDialog.setContentView(R.layout.dialog_getredy_template);
        getRedyTextDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialogTitle = (TextView) getRedyTextDialog.findViewById(R.id.dialog_title_text);
        dialogContentText = (TextView) getRedyTextDialog.findViewById(R.id.dialog_content_text);
        closeDialogButton = (ImageView) getRedyTextDialog.findViewById(R.id.dialog_close_btn);
        submitBtn = (Button) getRedyTextDialog.findViewById(R.id.dialog_submit_button);
        cancelBtn = (Button) getRedyTextDialog.findViewById(R.id.dialog_cancel_button);
    }

    public void setupDialog(String titleText, String contentText) {
        dialogTitle.setText(titleText);
        dialogContentText.setText(contentText);

        closeDialogButton.setOnClickListener(view -> dismiss());

        cancelBtn.setOnClickListener(view -> dismiss());
        submitBtn.setOnClickListener(view -> dismiss());
    }

    public void setOnSubmit(Callable<Void> onSubmit) {
        submitBtn.setOnClickListener(view -> {
            try {
                onSubmit.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setOnCancel(Callable<Void> onCancel) {
        cancelBtn.setOnClickListener(view -> {
            try {
                dismiss();
                onCancel.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void show() {
        getRedyTextDialog.show();
    }

    public void dismiss() {
        getRedyTextDialog.dismiss();
    }
}
