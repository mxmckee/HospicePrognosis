package edu.ualr.mxmckee.hospiceprognosis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

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
