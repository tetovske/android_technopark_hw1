package ru.tetovske.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tetovske.myapplication.activities.NumberItemShowable;
import ru.tetovske.myapplication.pojo.Data;
import ru.tetovske.myapplication.R;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    private final List<Data.NumberItem> mData;
    private final NumberItemShowable mNumberItemShowable;

    public ItemListAdapter(List<Data.NumberItem> data, NumberItemShowable activity) {
        this.mData = data;
        this.mNumberItemShowable = activity;
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
        final Data.NumberItem element = mData.get(position);
        holder.mValue.setText(String.valueOf(element.GetValue()));
        holder.mValue.setTextColor(element.GetColor());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mNumberItemShowable.showNumberItem(element);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView mValue;
        private final CardView mCardView;

        ItemViewHolder(View itemView) {
            super(itemView);
            this.mValue = itemView.findViewById(R.id.item_content);
            this.mCardView = itemView.findViewById(R.id.card);
        }
    }
}
