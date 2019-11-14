package com.example.thread;

import android.annotation.SuppressLint;
import android.util.Log;

@SuppressLint("Registered")
public class MyThread extends Thread {
    private static final String TAG = MyThread.class.getSimpleName();
    public void run() {
        Log.d(TAG, "Mой поток запущен...");
    }

}
