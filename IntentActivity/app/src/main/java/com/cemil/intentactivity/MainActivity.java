package com.cemil.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
    }

    public void button(View view) {
        String barang = editTextTextPersonName.getText().toString();
        Intent intent = new Intent (this, Barang.class);
        intent.putExtra("ISI",barang);
        startActivity(intent);
    }
}