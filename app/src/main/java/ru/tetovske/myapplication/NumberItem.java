package ru.tetovske.myapplication;

import android.graphics.Color;

public class NumberItem {

    private int value;
    private int itemColor;

    NumberItem(int value) {
        SetValue(value);
    }

    public int GetValue() {
        return value;
    }

    public int GetColor() {
        return itemColor;
    }

    public void SetValue(int value) {
        this.value = value;
        SetColor();
    }

    private void SetColor() {
        if (value % 2 != 0) {
            itemColor = Color.RED;
        } else {
            itemColor = Color.BLUE;
        }
    }
}