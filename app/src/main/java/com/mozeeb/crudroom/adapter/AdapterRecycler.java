package com.mozeeb.crudroom.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mozeeb.crudroom.R;
import com.mozeeb.crudroom.model.Mahasiswa;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {

    private Context mContext;
    private List<Mahasiswa> mahasiswaList;
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama,nim,kejuruan,alamat;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            nama = (TextView)itemView.findViewById(R.id.tvNama);
            nim = (TextView)itemView.findViewById(R.id.tvNim);
            kejuruan = (TextView)itemView.findViewById(R.id.tvKejuruan);
            alamat = (TextView)itemView.findViewById(R.id.tvAlamat);

        }

    }
    public AdapterRecycler(Context mContext, List<Mahasiswa> mahasiswaList){
        this.mContext = mContext;
        this.mahasiswaList = mahasiswaList;
    }

    @NonNull
    @Override
    public AdapterRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.design_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.MyViewHolder myViewHolder, int i) {
        final Mahasiswa album = mahasiswaList.get(i);
        myViewHolder.nama.setText(album.getNama());
        myViewHolder.alamat.setText(album.getAlamat());
        myViewHolder.kejuruan.setText(album.getKejuruan());
        myViewHolder.nim.setText(album.getNim());

    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }
}
