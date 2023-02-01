package com.cemil.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText etbarang, etstok, etharga;
    TextView tvpilihan;

    List<Barang> databarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    RecyclerView rcvbarang;

    String idbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        selectData();
    }

    public void load(){
        db = new Database(this);
        db.buatTabel();

        etbarang = findViewById(R.id.etbarang);
        etstok = findViewById(R.id.etstok);
        etharga = findViewById(R.id.etharga);
        tvpilihan = findViewById(R.id.tvpilihan);
        rcvbarang = findViewById(R.id.rcvbarang);

        rcvbarang.setLayoutManager(new LinearLayoutManager(this));
        rcvbarang.setHasFixedSize(true);
    }

    public void simpan(View v){
        String barang = etbarang.getText().toString();
        String stok = etstok.getText().toString();
        String harga = etharga.getText().toString();
        String pilihan = tvpilihan.getText().toString();

        if(barang.isEmpty() || stok.isEmpty() || harga.isEmpty()){
            pesan ("Data Kosong");
        }else {
            if(pilihan.equals("insert")){
                String sql = "INSERT INTO tblbarang (barang,stok,harga) VALUES ('"+barang+"',"+stok+", "+harga+")";
                if(db.runSQL(sql)){
                    pesan("insert berhasil");
                    selectData();
                }else {
                    pesan("insert gagal");
                }

            }else {
                String sql = "UPDATE tblbarang\n" +
                        "SET barang = \'"+barang+"', stok = "+stok+",harga = "+harga+"\n" +
                        "WHERE idbarang = "+idbarang+";";
                if(db.runSQL(sql)){
                    pesan("Data sudah di ubah");
                    selectData();
                }else{
                    pesan("Data tidak bisa diubah");
                }
            }
        }

        etbarang.setText("");
        etstok.setText("");
        etharga.setText("");
        tvpilihan.setText("insert");
    }

    public void pesan (String isi){
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }

    public void selectData(){
        String sql = "SELECT * FROM tblbarang ORDER BY barang ASC";
        Cursor cursor = db.select(sql);
        databarang.clear();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                String idbarang = cursor.getString(cursor.getColumnIndexOrThrow("idbarang"));
                String barang = cursor.getString(cursor.getColumnIndexOrThrow("barang"));
                String stok = cursor.getString(cursor.getColumnIndexOrThrow("stok"));
                String harga = cursor.getString(cursor.getColumnIndexOrThrow("harga"));

                databarang.add(new Barang(idbarang,barang,stok,harga));
            }

            adapter = new BarangAdapter(this,databarang);
            rcvbarang.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }else{
            pesan("Data Kosong");
        }
    }
    public void deleteData(String id){
        idbarang = id;

        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle("PERINGATAN !");
        al.setMessage("Yakin akan menghapus?");
        al.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sql = "DELETE FROM tblbarang WHERE idbarang = "+idbarang+";";
                if(db.runSQL(sql)){
                    pesan("Data Sudah Dihapus");
                    selectData();
                }else{
                    pesan("Data tidak bisa dihapus");
                }
            }
        });

        al.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
            }
        });

        al.show();


    }

    public void selectUpdate(String id){
        idbarang = id;
        String sql = "SELECT * FROM tblbarang WHERE idbarang="+id+";";
        Cursor cursor = db.select(sql);
        cursor.moveToNext();

        etbarang.setText(cursor.getString(cursor.getColumnIndex("barang")));
        etstok.setText(cursor.getString(cursor.getColumnIndex("stok")));
        etharga.setText(cursor.getString(cursor.getColumnIndex("harga")));

        tvpilihan.setText("update");
    }

}