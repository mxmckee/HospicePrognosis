package edu.ualr.mxmckee.hospiceprognosis.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import edu.ualr.mxmckee.hospiceprognosis.R;
import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBeforeLogoText("Hospice Prognostic Estimator\n")
                .withLogo(R.drawable.ic_final_app_icon)
                .withFooterText("\u00a9 2019 Michael McKee\n");

        config.getBeforeLogoTextView().setTextSize(24);
        config.getBeforeLogoTextView().setTextColor(getResources().getColor(R.color.secondaryColor, null));
        config.getFooterTextView().setTextColor(getResources().getColor(R.color.secondaryColor, null));

        View view = config.create();

        setContentView(view);
    }
}
