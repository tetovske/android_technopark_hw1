package ru.tetovske.myapplication.fragments;

import android.content.Context;
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

import java.util.Objects;

import ru.tetovske.myapplication.activities.NumberItemShowable;
import ru.tetovske.myapplication.pojo.Data;
import ru.tetovske.myapplication.R;
import ru.tetovske.myapplication.adapters.ItemListAdapter;

public class ListFragment extends Fragment {

    private RecyclerView mItemRecyclerView;
    private NumberItemShowable mNumberShowable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mItemRecyclerView = view.findViewById(R.id.item_list);
        int columnsCount;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnsCount = getResources().getInteger(R.integer.columns_landscape);
        } else {
            columnsCount = getResources().getInteger(R.integer.columns_portrait);
        }
        mItemRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columnsCount));
        ItemListAdapter adapter = new ItemListAdapter(Data.getInstance().getData(), mNumberShowable);
        mItemRecyclerView.setAdapter(adapter);
        Button addNumberButton = view.findViewById(R.id.add_element_btn);
        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data = Data.getInstance();
                data.addElement(data.getData().get(data.getData().size() - 1).GetValue() + 1);
                Objects.requireNonNull(mItemRecyclerView.getAdapter()).notifyItemInserted(data.getData().size() - 1);
            }
        });
    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mNumberShowable = (NumberItemShowable) context;
    }
}
