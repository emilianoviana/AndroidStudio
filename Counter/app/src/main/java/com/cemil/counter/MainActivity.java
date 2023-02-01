package com.cemil.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    TextView tvhasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        tvhasil = findViewById(R.id.tvhasil);
    }

    public void btnup(View view) {
        count++;
        tvhasil.setText(count+"");
    }

    public void btnDown(View view) {
        count--;
        tvhasil.setText(count+"");
    }
}