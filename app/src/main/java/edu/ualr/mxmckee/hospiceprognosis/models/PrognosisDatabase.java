package edu.ualr.mxmckee.hospiceprognosis.models;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.ualr.mxmckee.hospiceprognosis.models.Prognosis;
import edu.ualr.mxmckee.hospiceprognosis.models.PrognosisDao;

@Database(entities = {Prognosis.class}, exportSchema = false, version = 1)
public abstract class PrognosisDatabase extends RoomDatabase {

    public abstract PrognosisDao prognosisDao();
}