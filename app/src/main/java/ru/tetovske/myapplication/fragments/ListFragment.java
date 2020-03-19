package ru.tetovske.myapplication.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;

import ru.tetovske.myapplication.Data;
import ru.tetovske.myapplication.Data.NumberItem;
import ru.tetovske.myapplication.R;
import ru.tetovske.myapplication.adapters.ItemListAdapter;

public class ListFragment extends Fragment {

    private RecyclerView itemRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemRecyclerView = view.findViewById(R.id.item_list);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            itemRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            itemRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        }
        ItemListAdapter adapter = new ItemListAdapter(Data.getInstance().getData());
        itemRecyclerView.setAdapter(adapter);
        Button addNumberButton = view.findViewById(R.id.add_element_btn);
        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.getInstance().addElement(Data.getInstance().getData().get(Data.getInstance().getData().size() - 1).GetValue() + 1);
                Objects.requireNonNull(itemRecyclerView.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    public static ListFragment newInstance(ArrayList<Data.NumberItem> list) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("data_list", list);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
