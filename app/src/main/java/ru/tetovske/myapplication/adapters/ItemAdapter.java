package ru.tetovske.myapplication.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter {
    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView itemHeader, itemDescription;

        public ItemViewHolder(View itemView) {
            super(itemView);

        }
    }
}
