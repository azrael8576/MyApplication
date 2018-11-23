package com.alex.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

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
        //正在創建活動。
        Log.d(TAG, "onCreate://正在創建活動 ");
    }
    @Override
    protected void onStart() {
        super.onStart();
        //活動即將變為可見。
        Log.d(TAG, "onStart://活動即將變為可見 ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        //活動已變為可見（現在已“恢復”）。
        Log.d(TAG, "onResume://活動已變為可見（現在已“恢復”） ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        //另一項活動正在關注（此活動即將“暫停”）。
        Log.d(TAG, "onPause://另一項活動正在關注（此活動即將“暫停”） ");
    }
    @Override
    protected void onStop() {
        super.onStop();
        //活動不再可見（現在已“停止”）
        Log.d(TAG, "onStop://活動不再可見（現在已“停止”） ");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //活動即將被銷毀。
        Log.d(TAG, "onDestroy://活動即將被銷毀。 ");
    }
}
