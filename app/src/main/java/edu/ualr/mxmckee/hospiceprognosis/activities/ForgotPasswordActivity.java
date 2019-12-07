package edu.ualr.mxmckee.hospiceprognosis.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import edu.ualr.mxmckee.hospiceprognosis.R;
import edu.ualr.mxmckee.hospiceprognosis.fragments.VerifyUsernameFragment;

public class ForgotPasswordActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {

                return;
            }
        }

        fragmentManager.beginTransaction().add(R.id.fragment_container, new VerifyUsernameFragment(), "verify_username").commit();
    }
}
