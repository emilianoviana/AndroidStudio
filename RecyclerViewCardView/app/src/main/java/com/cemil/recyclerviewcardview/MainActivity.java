package com.cemil.recyclerviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        isiData();
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvsiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Nana","Bajong"));
        siswaList.add(new Siswa("Eko","Amerika"));
        siswaList.add(new Siswa("Amel","Amerika"));
        siswaList.add(new Siswa("Koko","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));
        siswaList.add(new Siswa("Emil","Amerika"));

        adapter = new SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);
    }

    public void btntambah(View view) {
        siswaList.add(new Siswa("Emil Cantik","LA"));
        adapter.notifyDataSetChanged();
    }
}