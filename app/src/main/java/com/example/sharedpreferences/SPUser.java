package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUser {
    private static final String SP_FILE_NAME = "sp_file";
    public static SPUser instance = null;
    private static SharedPreferences mSp;
    /**
     * 创建一个SharedPreferences实例对象
     */
    private SPUser(Context context) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        }
    }
    /**
     * 单例是否创建，不存在就创建，存在就返回单例
     */
    public static SPUser getInstance(Context context) {
        if (instance == null) {
            synchronized (SPUser.class) {
                if (instance == null) {
                    instance = new SPUser(context);
                }
            }
        }
        return instance;
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = mSp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public boolean getBoolean(String key) {
        return mSp.getBoolean(key, false);
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = mSp.edit();
        editor.putInt(key, value);
        editor.apply();
//        boolean t = editor.commit();
    }
    public int getInt(String key) {
        return mSp.getInt(key, 0);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = mSp.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getString(String key) {
        return mSp.getString(key, null);
    }

    public void deleteData(String key) {
        SharedPreferences.Editor editor = mSp.edit();
        editor.remove(key);
        editor.apply();
    }
    public static void clearData(){
        SharedPreferences.Editor editor = mSp.edit();
        editor.clear();
        editor.apply();
    }
}
