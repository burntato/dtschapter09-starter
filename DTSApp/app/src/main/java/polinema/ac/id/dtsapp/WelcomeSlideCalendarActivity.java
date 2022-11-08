package polinema.ac.id.dtsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeSlideCalendarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_slide);
    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(WelcomeSlideCalendarActivity.this, WelcomeSlideSuperheroActivity.class);
        startActivity(i);
    }

    public void clickLogin(View view) {
        Intent i = new Intent(WelcomeSlideCalendarActivity.this, WelcomeBackActivity.class);
        startActivity(i);
    }

    public void clickContactUs(View view) {
        // normal
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"dts@polinema.ac.id"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
        i.putExtra(Intent.EXTRA_TEXT, "Welcome to dts 2019");
        startActivity(i.createChooser(i, "Pilih email client"));

        // LATIHAN

        // ke banyak email ( tinggal di tambahkan aja email di array EXTRA_MAIL )
        // Intent i = new Intent(Intent.ACTION_SEND);
        // i.setType("text/plain");
        // i.putExtra(Intent.EXTRA_EMAIL, new String[]{"dts@polinema.ac.id", "fiandra18@gmail.com"});
        // i.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
        // i.putExtra(Intent.EXTRA_TEXT, "Welcome to dts 2019");
        // startActivity(i.createChooser(i, "Pilih email client"));

        // cc
        // Intent i = new Intent(Intent.ACTION_SEND);
        // i.setType("text/plain");
        // i.putExtra(Intent.EXTRA_EMAIL, new String[]{"dts@polinema.ac.id", "fiandra18@gmail.com"});
        // i.putExtra(Intent.EXTRA_CC, new String[]{"Poggerinos", "Poggers", "Pogchamp"});
        // i.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
        // i.putExtra(Intent.EXTRA_TEXT, "Welcome to dts 2019");
        // startActivity(i.createChooser(i, "Pilih email client"));

        // bcc
        // Intent i = new Intent(Intent.ACTION_SEND);
        // i.setType("text/plain");
        // i.putExtra(Intent.EXTRA_EMAIL, new String[]{"dts@polinema.ac.id", "fiandra18@gmail.com"});
        // i.putExtra(Intent.EXTRA_CC, new String[]{"Poggerinos", "Poggers", "Pogchamp"});
        // i.putExtra(Intent.EXTRA_BCC, new String[]{"Jalapenos", "Tacos", "Quesadila"});
        // i.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
        // i.putExtra(Intent.EXTRA_TEXT, "Welcome to dts 2019");
        // startActivity(i.createChooser(i, "Pilih email client"));

    }
}
