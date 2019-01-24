package com.mozeeb.crudroom.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa>getAll();

    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama ")
    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa... mahasiswa);

    @Delete
    public void deleteUsers(Mahasiswa... users);
}
