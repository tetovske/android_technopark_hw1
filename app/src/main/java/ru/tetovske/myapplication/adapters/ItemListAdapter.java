package ru.tetovske.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tetovske.myapplication.NumberItem;
import ru.tetovske.myapplication.R;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    private List<NumberItem> data;

    public ItemListAdapter(List<NumberItem> data) {
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
        NumberItem element = data.get(position);
        holder.value.setText(String.valueOf(element.GetValue()));
        holder.value.setTextColor(element.GetColor());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView value;

        ItemViewHolder(View itemView) {
            super(itemView);
            this.value = itemView.findViewById(R.id.item_content);
        }
    }
}
