package ru.tetovske.myapplication.pojo;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Data {

    private static Data sInstance;
    private ArrayList<NumberItem> mItems;

    private Data() {
        mItems = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            mItems.add(new NumberItem(i));
        }
    }

    public static Data getInstance() {
        if (sInstance == null) {
            sInstance = new Data();
        }
        return sInstance;
    }

    public ArrayList<NumberItem> getData() {
        return mItems;
    }

    public void setData(ArrayList<NumberItem> dataList) {
        this.mItems = new ArrayList<>(dataList);
    }

    public void addElement(int value) {
        mItems.add(new NumberItem(value));
    }

    public static class NumberItem implements Parcelable {

        private int mValue;
        private int mItemColor;

        NumberItem(int value) {
            SetValue(value);
        }

        NumberItem(Parcel in) {
            mValue = in.readInt();
            mItemColor = in.readInt();
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
            return mValue;
        }

        public int GetColor() {
            return mItemColor;
        }

        private void SetValue(int value) {
            this.mValue = value;
            SetColor();
        }

        private void SetColor() {
            if (mValue % 2 == 0) {
                mItemColor = Color.RED;
            } else {
                mItemColor = Color.BLUE;
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mValue);
            dest.writeInt(mItemColor);
        }
    }
}