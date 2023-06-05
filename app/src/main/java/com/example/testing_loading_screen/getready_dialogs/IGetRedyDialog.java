package com.example.testing_loading_screen.getready_dialogs;

import java.util.concurrent.Callable;

public interface IGetRedyDialog {
    void setupDialog(String titleText, String contentText);
    void dismiss();
    void show();
}
