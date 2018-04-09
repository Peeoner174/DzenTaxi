package com.peeoner174.msi.oneapril2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.peeoner174.msi.oneapril2.dzen.ui.activity.LoginActivity;
import com.peeoner174.msi.oneapril2.dzen.ui.activity.MapsActivity;
import com.peeoner174.msi.oneapril2.dzen.ui.activity.TapleActivity;
import com.peeoner174.msi.oneapril2.dzen.ui.activity.UserInfoActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}