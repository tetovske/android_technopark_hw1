package ru.tetovske.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.tetovske.myapplication.R;

public class ItemPreview extends Fragment {
    private static final String VALUE_ARG_NAME = "num", COLOR_ARG_NAME = "color";
    private int mNumber, mNumColor;

    public ItemPreview() {}

    public static ItemPreview newInstance(int value, int color) {
        ItemPreview fragment = new ItemPreview();
        Bundle args = new Bundle();
        args.putInt(VALUE_ARG_NAME, value);
        args.putInt(COLOR_ARG_NAME, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNumber = getArguments().getInt(VALUE_ARG_NAME);
            mNumColor = getArguments().getInt(COLOR_ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_preview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textToPreview = view.findViewById(R.id.item_preview);
        textToPreview.setText(String.valueOf(mNumber));
        textToPreview.setTextColor(mNumColor);
    }
}
