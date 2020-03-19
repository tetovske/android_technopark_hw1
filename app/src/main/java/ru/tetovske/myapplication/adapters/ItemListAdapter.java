package ru.tetovske.myapplication.adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tetovske.myapplication.Data;
import ru.tetovske.myapplication.Data;
import ru.tetovske.myapplication.R;
import ru.tetovske.myapplication.fragments.ItemPreview;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    private List<Data.NumberItem> data;

    public ItemListAdapter(List<Data.NumberItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,
                parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Data.NumberItem element = data.get(position);
        holder.value.setText(String.valueOf(element.GetValue()));
        holder.value.setTextColor(element.GetColor());
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.recycle_fragment, ItemPreview.newInstance(element.GetValue(), element.GetColor()));
                transaction.addToBackStack("preview");
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView value;
        private CardView cardView;

        ItemViewHolder(View itemView) {
            super(itemView);
            this.value = itemView.findViewById(R.id.item_content);
            this.cardView = itemView.findViewById(R.id.card);
        }
    }
}
