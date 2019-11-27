package edu.ualr.mxmckee.hospiceprognosis;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User user);
}
