package com.mozeeb.crudroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mozeeb.crudroom.model.Mahasiswa;
import com.mozeeb.crudroom.model.MahasiswaDao;

@Database(entities = {Mahasiswa.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDao userDao();



}
