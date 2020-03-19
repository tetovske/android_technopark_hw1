package ru.tetovske.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.tetovske.myapplication.adapters.ItemListAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView itemsRecycleView;
    private List<NumberItem> database;
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
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(getLogTag(), "onRestoreInstanceState");
    }

    private String getLogTag() {
        return getClass().getName();
    }

    private void initializeViews() {
        InitNumbersList();
        itemsRecycleView = findViewById(R.id.item_list);
        itemsRecycleView.setLayoutManager(new GridLayoutManager(this, 3));
        ItemListAdapter adapter = new ItemListAdapter(database);
        itemsRecycleView.setAdapter(adapter);

        Button addNumberButton = findViewById(R.id.add_element_btn);
        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.add(new NumberItem(database.get(database.size() - 1).GetValue() + 1));
                Objects.requireNonNull(itemsRecycleView.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    private void InitNumbersList() {
        database = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            database.add(new NumberItem(i));
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(getLogTag(), "CONFIG CHANGED!");
    }
}


