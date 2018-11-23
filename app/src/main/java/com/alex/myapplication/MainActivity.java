package com.alex.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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
}
