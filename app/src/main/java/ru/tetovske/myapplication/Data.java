package ru.tetovske.myapplication;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static Data instance;
    private ArrayList<NumberItem> items;

    private Data() {
        items = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            items.add(new NumberItem(i));
        }
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public ArrayList<NumberItem> getData() {
        return items;
    }

    public void addElement(int value) {
        items.add(new NumberItem(value));
    }

    public static class NumberItem implements Parcelable {

        private int value;
        private int itemColor;

        NumberItem(int value) {
            SetValue(value);
        }

        NumberItem(Parcel in) {
            value = in.readInt();
            itemColor = in.readInt();
        }

        public static final Creator<NumberItem> CREATOR = new Creator<NumberItem>() {
            @Override
            public NumberItem createFromParcel(Parcel in) {
                return new NumberItem(in);
            }

            @Override
            public NumberItem[] newArray(int size) {
                return new NumberItem[size];
            }
        };

        public int GetValue() {
            return value;
        }

        public int GetColor() {
            return itemColor;
        }

        private void SetValue(int value) {
            this.value = value;
            SetColor();
        }

        private void SetColor() {
            if (value % 2 == 0) {
                itemColor = Color.RED;
            } else {
                itemColor = Color.BLUE;
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(value);
            dest.writeInt(itemColor);
        }
    }
}