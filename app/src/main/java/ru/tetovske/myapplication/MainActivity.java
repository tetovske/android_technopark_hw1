package ru.tetovske.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private RecyclerView itemsRecycleView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        Log.d(TAG, "Hello World!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getLogTag(), "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(getLogTag(), "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getLogTag(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getLogTag(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getLogTag(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getLogTag(), "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(getLogTag(), "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(getLogTag(), "onRestoreInstanceState");
    }

    private String getLogTag() {
        return getClass().getName();
    }

    private void initializeViews() {
        itemsRecycleView = findViewById(R.id.item_list);
        itemsRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(getLogTag(), "CONFIG CHANGED!");
    }
}


