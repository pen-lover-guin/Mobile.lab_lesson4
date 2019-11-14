package com.example.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    private static final String TAG = MyAsyncTask.class.getSimpleName();
    private WeakReference<TextView> wTextView;
    MyAsyncTask(TextView textView) {
        this.wTextView = new WeakReference<>(textView);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        updateText("Запуск");
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        updateText("Выполнено: " + values[0]);
    }
    @Override
    protected Void doInBackground(Void... params) {
        try {
            int counter = 0;
            for (int i = 0; i < 13152; i++) {
                getTime();
                publishProgress(++counter);
            }
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        updateText("Выполнено");
    }
    private void getTime() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }
    private void updateText(String str){
        final TextView textView = wTextView.get();
        if (textView != null) {
            textView.setText(str);
        } else {
            Log.d(TAG, "Что-то пошло не так!");
        }
    }
}