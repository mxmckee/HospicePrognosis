package edu.ualr.mxmckee.hospiceprognosis;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    public User verifyCredentials(String username, String password);
}
