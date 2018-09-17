package com.enjoylife.ironghui.enjoylife.login.time;

import android.os.CountDownTimer;
import android.os.Handler;

public class RegisterCodeTimer extends CountDownTimer {
    private static Handler mHandler;
    public static final int IN_RUNNING = 1001;
    public static int END_RUNNING = 1002;

    /**
     * @param millisInFuture    // 倒计时的时长
     * @param countDownInterval // 间隔时间
     * @param handler           // 通知进度的Handler
     */
    public RegisterCodeTimer(long millisInFuture, long countDownInterval, Handler handler) {
        super(millisInFuture, countDownInterval);
        mHandler = handler;
    }

    // 结束
    @Override
    public void onFinish() {
        if (mHandler != null)
            mHandler.obtainMessage(END_RUNNING, "重新发送").sendToTarget();
    }

    //正在倒计时
    @Override
    public void onTick(long millisUntilFinished) {
        if (mHandler != null)
            mHandler.obtainMessage(IN_RUNNING, "重新发送(" + (millisUntilFinished / 1000) + "s)").sendToTarget();
    }

}
