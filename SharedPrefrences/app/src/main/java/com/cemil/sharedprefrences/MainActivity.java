package com.cemil.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView etbarang, etstok;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        etbarang = findViewById(R.id.etbarang);
        etstok = findViewById(R.id.etstok);
        sharedPreferences = getSharedPreferences("barang", MODE_PRIVATE);
    }

    public void isiSharedPrefrences(String barang, float stok){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("barang",barang);
        editor.putFloat("stok", stok);
        editor.apply();
    }

    public void simpan(View view) {
        String barang = etbarang.getText().toString();
        float stok = Float.parseFloat(etstok.getText().toString());

        if (barang.isEmpty() || stok == 0.0){
            Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show();
        }else {
            isiSharedPrefrences(barang,stok);
            Toast.makeText(this, "Data sudah disimpan", Toast.LENGTH_SHORT).show();
        }
        etbarang.setText("");
        etstok.setText("");
    }

    public void tampil(View view) {
        String barang = sharedPreferences.getString("barang","");
        float stok = sharedPreferences.getFloat("stok",0);

        etbarang.setText(barang);
        etstok.setText(stok+"");
    }
}