package edu.ualr.mxmckee.hospiceprognosis.models;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.ualr.mxmckee.hospiceprognosis.models.User;
import edu.ualr.mxmckee.hospiceprognosis.models.UserDao;

@Database(entities = {User.class}, exportSchema = false, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
