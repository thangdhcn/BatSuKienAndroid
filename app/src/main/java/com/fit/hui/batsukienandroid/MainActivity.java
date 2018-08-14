package com.fit.hui.batsukienandroid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AlertDialog.Builder builder ;
    private Button btnCong, btnTru, btnThoat;
    private EditText edtA, edtB;
    private TextView tvKetQua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCong = (Button) findViewById(R.id.btn_Cong);
        btnTru = (Button) findViewById(R.id.btn_Tru);
        btnThoat = findViewById(R.id.btn_Thoat);
        edtA=findViewById(R.id.edt_A);
        edtB=findViewById(R.id.edt_B);
        tvKetQua= findViewById(R.id.tv_KetQua);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThoat();

            }
        });
        btnCong.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Bạn nhấn hoài làm gì", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//code cho su kien có 2 cách bắt

    }

    private void xuLyThoat( ) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo Thoát");
        builder.setMessage("Bạn có chắc thoát?");
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setPositiveButton("Đồng Ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dlg, int i) {
                dlg.dismiss();
            }
        });
        Dialog dlg = builder.create();
        dlg.show();



    }
    @Override
    public void onClick(View v)
    {
        int A=0, B=0,KQ=0;

           if(edtA.getText().length()>0&& edtB.getText().length()>0)
           {
               A= Integer.parseInt( edtA.getText().toString());
               B= Integer.parseInt( edtB.getText().toString());
               switch (v.getId())
               {
                   case R.id.btn_Cong:
                       KQ=A+B;
                       tvKetQua.setText(KQ+"");
                       break;
                   case R.id.btn_Tru:
                       KQ=A-B;
                       tvKetQua.setText(KQ+"");
                       break;

               }

           }
           else
           {
               Toast.makeText(this, "Bạn phải nhập cho A và B", Toast.LENGTH_SHORT).show();
           }
    }
}
