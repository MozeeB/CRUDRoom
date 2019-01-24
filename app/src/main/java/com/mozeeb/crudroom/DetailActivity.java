package com.mozeeb.crudroom;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mozeeb.crudroom.adapter.AdapterRecycler;
import com.mozeeb.crudroom.model.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mozeeb.crudroom.MyApp.db;

public class DetailActivity extends AppCompatActivity {


    @BindView(R.id.myRecyclerview)
    RecyclerView myRecyclerview;

    AdapterRecycler adapterRecycler;
    List<Mahasiswa> mahasiswaList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();


    }


    private void fetchDataFromRoom() {

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();

        mahasiswaList = db.userDao().getAll();

        //cek db
        for (int i = 0; i < mahasiswaList.size(); i++) {
            Log.e("Aplikasi", mahasiswaList.get(i).getAlamat() + i);
            Log.e("Aplikasi", mahasiswaList.get(i).getKejuruan() + i);
            Log.e("Aplikasi", mahasiswaList.get(i).getNama() + i);
            Log.e("Aplikasi", mahasiswaList.get(i).getNim() + i);
        }


    }

    private void initRecyclerView() {
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager lnr = new LinearLayoutManager(this);
        lnr.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(lnr);
        adapterRecycler = new AdapterRecycler(this, mahasiswaList);


    }

    private void setAdapter() {
        myRecyclerview.setAdapter(adapterRecycler);

    }

}
