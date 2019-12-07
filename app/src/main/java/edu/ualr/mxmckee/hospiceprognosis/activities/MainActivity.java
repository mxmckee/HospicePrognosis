package edu.ualr.mxmckee.hospiceprognosis.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import edu.ualr.mxmckee.hospiceprognosis.models.PrognosisDatabase;
import edu.ualr.mxmckee.hospiceprognosis.R;
import edu.ualr.mxmckee.hospiceprognosis.models.UserDatabase;
import edu.ualr.mxmckee.hospiceprognosis.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public static UserDatabase userDatabase;
    public static PrognosisDatabase prognosisDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "userDB").allowMainThreadQueries().build();
        prognosisDatabase = Room.databaseBuilder(getApplicationContext(), PrognosisDatabase.class, "prognosisDB").allowMainThreadQueries().build();
    }
}
