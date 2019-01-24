package com.mozeeb.crudroom;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mozeeb.crudroom.model.Mahasiswa;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;

import static com.mozeeb.crudroom.MyApp.db;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etNama)
    EditText etNama;
    @BindView(R.id.etNim)
    EditText etNim;
    @BindView(R.id.etKejuruan)
    EditText etKejuruan;
    @BindView(R.id.etAlamat)
    EditText etAlamat;
    @BindView(R.id.btInsert)
    Button btInsert;

    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    @OnClick(R.id.btInsert)
    public void onViewClicked() {
        if (!etAlamat.getText().toString().isEmpty() &&! etKejuruan.getText().toString().isEmpty() &&! etNama.getText().toString().isEmpty()
        &&! etNim.getText().toString().isEmpty()){

            mahasiswa = new Mahasiswa();
            mahasiswa.setAlamat(etAlamat.getText().toString());
            mahasiswa.setKejuruan(etKejuruan.getText().toString());
            mahasiswa.setNama(etNama.getText().toString());
            mahasiswa.setNim(etNim.getText().toString());

            //insert data didatabase
            db.userDao().insertAll(mahasiswa);
            finish();
        }else {
            Toast.makeText(this, "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();

        }
    }


}
