package com.cemil.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvhasil;
    EditText etbil_1,etbil_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load() {
        tvhasil = findViewById(R.id.tvhasil);
        etbil_1 = findViewById(R.id.etbil_1);
        etbil_2 = findViewById(R.id.etbil_2);
    }

    public void btnjumlah(View view) {
        if(etbil_1.getText().toString().equals("") || etbil_2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {

            double bil_1 = Double.parseDouble(etbil_1.getText().toString());
            double bil_2 = Double.parseDouble(etbil_2.getText().toString());

            double hasil = bil_1 + bil_2;

            tvhasil.setText(hasil + "");
        }
    }
}