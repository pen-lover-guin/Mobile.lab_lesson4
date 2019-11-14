package com.example.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyLooper myLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLooper = new MyLooper();
        myLooper.start();
    }
        public void onClick (View view){
            Message msg = new Message();
            Bundle bundle = new Bundle();
            Message msg1 = new Message();
            Bundle bundle1 = new Bundle();
            Integer res = 19+40;
            String a = res.toString();
            bundle1.putString("KEY", a);
            bundle.putString("KEY", "mirea");
            msg.setData(bundle);
            if (myLooper != null) {
                myLooper.handler.sendMessage(msg);
            }
            msg1.setData(bundle1);
            if (myLooper != null) {
                myLooper.handler.sendMessage(msg1);
            }
    }

}
