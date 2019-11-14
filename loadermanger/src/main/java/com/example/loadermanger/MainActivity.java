package com.example.loadermanger;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<String> {

    public final String TAG = this.getClass().getSimpleName();
    private TextView mResultTextView;
    public static final int LOADER_ID = 1;
    private Loader<String> mLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTextView = (TextView) findViewById(R.id.textView);

        Bundle bundle = new Bundle();
        bundle.putString(RandomLoader.ARG_WORD, "mirea");
        mLoader = getSupportLoaderManager().initLoader(LOADER_ID, bundle, this);
    }


    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        // Создаем новый CursorLoader с нужными параметрами
        Loader<String> mLoader = null;
        // условие можно убрать, если вы используете только один загрузчик
        if (id == LOADER_ID) {
            mLoader = new RandomLoader(this, args);
            Log.d(TAG, "onCreateLoader");
        }
        return mLoader;
    }


    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        Log.d(TAG, "onLoadFinished");
        mResultTextView.setText(data);
    }

    // Вызовется при уничтожении активности
    @Override
    public void onLoaderReset(Loader<String> loader) {
        Log.d(TAG, "onLoaderReset");
    }

}