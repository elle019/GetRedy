package com.example.testing_loading_screen.getready_dialogs;

import java.util.concurrent.Callable;

public interface IGetRedyDialog {
    void setupDialog(String titleText, String contentText);
    void setOnSubmit(Callable<Void> onSubmit);
    void setOnCancel(Callable<Void> onCancel);
    void dismiss();
    void show();
}
