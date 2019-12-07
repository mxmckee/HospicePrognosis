package edu.ualr.mxmckee.hospiceprognosis;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "prognoses")
public class Prognosis {

    @PrimaryKey
    @NonNull
    private int prognosisID;
    private String username;
    private String date;
    private String prognosis;

    public int getPrognosisID() {
        return prognosisID;
    }

    public void setPrognosisID(int prognosisID) {
        this.prognosisID = prognosisID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrognosis() {
        return prognosis;
    }

    public void setPrognosis(String prognosis) {
        this.prognosis = prognosis;
    }
}