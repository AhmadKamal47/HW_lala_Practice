package com.example.hwlalapractice.manager;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.hwlalapractice.MyApp;

public class PrefManager {

    private SharedPreferences sharedPreferences;

    public PrefManager() {
        sharedPreferences = MyApp.getInstance().getAppContext().getSharedPreferences("name", MODE_PRIVATE);
    }

    public void saveString(String key, String value){
        sharedPreferences
                .edit()
                .putString(key, value)
                .apply();
    }
    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }

    public String getString(String key, String defValue){
        return sharedPreferences.getString(key, defValue);
    }

    public void saveInt(String key, int value){
        sharedPreferences
                .edit()
                .putInt(key, value)
                .apply();
    }

    public int getInt(String key){
        return sharedPreferences.getInt(key, -1);
    }



}
