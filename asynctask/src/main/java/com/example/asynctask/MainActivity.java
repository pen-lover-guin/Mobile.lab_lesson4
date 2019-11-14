package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAsyncTask(View view) {
        TextView resultTextView = (TextView) findViewById(R.id.textView);
        MyAsyncTask myAsyncTask = new MyAsyncTask(resultTextView);
        myAsyncTask.execute();
    }
}
