package ru.tetovske.myapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

import ru.tetovske.myapplication.R;
import ru.tetovske.myapplication.fragments.ItemPreview;
import ru.tetovske.myapplication.fragments.ListFragment;
import ru.tetovske.myapplication.pojo.Data;

public class MainActivity extends AppCompatActivity implements NumberItemShowable {

    private static final String DATA_LIST_ARG_NAME = "data_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            setupBasicFragment();
        } else {
            Data.getInstance().setData(savedInstanceState.<Data.NumberItem>getParcelableArrayList(DATA_LIST_ARG_NAME));
        }
    }

    private void setupBasicFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.recycle_fragment, ListFragment.newInstance())
                .commit();
    }

    @Override
    public void showNumberItem(@NotNull Data.NumberItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.recycle_fragment, ItemPreview.newInstance(item.GetValue(), item.GetColor()))
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(DATA_LIST_ARG_NAME, Data.getInstance().getData());
    }
}