package com.peeoner174.msi.oneapril2;

import android.util.Log;

public class MySingleton {
    private static MySingleton mInstance;
    private int MyVariable;

    public static void initInstance() {
        Log.d("MY", "MySingleton::InitInstance()");
        if (mInstance == null) {
            mInstance = new MySingleton();
        }
    }

    public static MySingleton getInstance() {
        Log.d("MY", "MySingleton::getInstance()");
        return mInstance;
    }
    private MySingleton() {
        Log.w("MY_TAG", "MySingleton::MySingleton()");
        MyVariable = 1;
    }


    public int getMyVariable() {
        return MyVariable;
    }

    public void setMyVariable(int var) {
        MyVariable = var;
    }
}