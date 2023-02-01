package com.cemil.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etnilai;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        spinner = findViewById(R.id.spinner);
        etnilai = findViewById(R.id.etnilai);
        tvhasil = findViewById(R.id.tvhasil);
    }

    /*
    public void isispinner(){
        String[] isi = {"Celcius to Reamur", "Celcius to Farenheit", "Celcius to Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }
     */

    public void btnkonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if (etnilai.getText().toString().equals("")){
            Toast.makeText(this, "Nilai Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else{
            if (pilihan.equals("Celcius To Reamur")){
                cToR();
            }
            if (pilihan.equals("Celcius to farenheit")){
                cToF();
            }
        }
    }

    public void cToR (){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (4.0/5.0) * suhu;

        tvhasil.setText(hasil+"");
    }

    public void cToF(){
        Toast.makeText(this, "Belum dibuat", Toast.LENGTH_SHORT).show();
    }
}