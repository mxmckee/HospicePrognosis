package edu.ualr.mxmckee.hospiceprognosis.models;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.ualr.mxmckee.hospiceprognosis.models.Prognosis;

@Dao
public interface PrognosisDao {

    @Insert
    public void addPrognosis(Prognosis prognosis);

    @Query("SELECT * FROM prognoses WHERE username = :username")
    public List<Prognosis> getAllPrognoses(String username);

    @Query("DELETE FROM prognoses WHERE username = :username")
    public void clearPrognoses(String username);

    @Query("SELECT COUNT(*) FROM prognoses")
    public int getCount();
}