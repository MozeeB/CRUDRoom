package com.mozeeb.crudroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.tambah)
    Button tambah;
    @BindView(R.id.lihat)
    Button lihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tambah, R.id.lihat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tambah:
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                break;
            case R.id.lihat:
                startActivity(new Intent(HomeActivity.this,DetailActivity.class));
                break;
        }
    }
}
