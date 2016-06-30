package com.founder.mp3player.callback;

import android.app.Dialog;

import com.founder.mp3player.activity.MainTabActivity;

/**
 * Created by Administrator on 2015/7/13.
 */
public class DialogCallbackImpl implements MainTabActivity.dialogCallback {
private Dialog dialog;

    public DialogCallbackImpl(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void dismissDialog(Dialog dialog) {
        dialog.dismiss();
    }
}
