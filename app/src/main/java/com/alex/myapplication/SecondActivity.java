package com.alex.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //使用getIntent()取得傳來的Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        //設定txtContent字串
        TextView txtContent = findViewById(R.id.txtContent);
        txtContent.setText(name);
    }
}
