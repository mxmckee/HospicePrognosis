package edu.ualr.mxmckee.hospiceprognosis;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Prognosis.class}, exportSchema = false, version = 1)
public abstract class PrognosisDatabase extends RoomDatabase {

    public abstract PrognosisDao prognosisDao();
}