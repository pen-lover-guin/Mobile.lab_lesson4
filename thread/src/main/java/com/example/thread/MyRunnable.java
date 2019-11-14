package com.example.thread;
import android.util.Log;

public class MyRunnable implements Runnable {
    private static final String TAG = MyRunnable.class.getSimpleName();
    private String goal;
    public MyRunnable(String goal) {
        this.goal=goal;
    }
    @Override
    public void run() {
        Log.d(TAG, " Mой поток запущен:" + goal);
    }
}