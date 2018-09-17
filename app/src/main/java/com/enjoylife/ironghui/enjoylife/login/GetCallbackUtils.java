package com.enjoylife.ironghui.enjoylife.login;

import com.enjoylife.ironghui.enjoylife.login.OnInputListener;

public class GetCallbackUtils {
    public static OnInputListener mOnInputListener;

    public static void setOnInputListener(OnInputListener onInputListener) {
        mOnInputListener = onInputListener;
    }

    public static void returnOnInput(String stirng) {
        mOnInputListener.onSucess("");
    }

    public static void returnOnInputFali(String stirng) {
        mOnInputListener.onInput();
    }
}
