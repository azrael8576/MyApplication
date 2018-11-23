package com.alex.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    TextView txtName;
    EditText edtName;
    Button btnConfirm;
    Button btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = edtName.getText().toString();
                txtName.setText(result);
                Toast.makeText(getApplicationContext(),getString(R.string.toast_hello) + result,Toast.LENGTH_LONG).show();
                //建立Intent
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name",result);
                startActivity(intent);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showClearDialog();
            }
        });
        //正在創建活動。
        Log.d(TAG, "onCreate://正在創建活動 ");
    }



    private void findViews() {
        edtName = findViewById(R.id.editName);
        txtName = findViewById(R.id.txtName);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnClear = findViewById(R.id.btnClear);
    }
    private void showClearDialog() {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("清除")
                    .setMessage(R.string.dialog_clear_message)
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edtName.setText("");
                            txtName.setText("");
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
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
