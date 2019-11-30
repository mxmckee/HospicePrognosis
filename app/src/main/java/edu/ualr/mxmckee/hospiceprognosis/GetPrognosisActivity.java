package edu.ualr.mxmckee.hospiceprognosis;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

public class GetPrognosisActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_prognosis);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String username = getIntent().getStringExtra("username");

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {

                return;
            }

            MainMenuFragment mainMenuFragment = new MainMenuFragment();
            Bundle bundle = new Bundle();
            bundle.putString("USERNAME", username);
            mainMenuFragment.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.fragment_container, mainMenuFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_out_action:
                Intent intent = new Intent(GetPrognosisActivity.this, MainActivity.class);
                startActivity(intent);
                //finish();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
