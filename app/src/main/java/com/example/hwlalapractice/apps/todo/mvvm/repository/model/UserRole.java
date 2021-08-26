package com.example.hwlalapractice.apps.todo.mvvm.repository.model;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.DrawableUtils;

public class UserRole {
    int icon;
    String name;
    boolean isSelected;

    public UserRole(int icon, String name, boolean isSelected) {
        this.icon = icon;
        this.name = name;
        this.isSelected = isSelected;
    }


    public int getIcon() {
        return icon;
    }

    public String getName() {
        if(name == null || TextUtils.isEmpty(name))
            return "Unknown Role";
        return name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
    }

}
