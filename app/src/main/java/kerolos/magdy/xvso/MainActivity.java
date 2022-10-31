package kerolos.magdy.xvso;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnComp,btnPlayers;
    Intent intent;
    Button btnBoor;
    Button btnSmart;
    globalV gvalue ;

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // AdMob Creation

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
//                Toast.makeText(MainActivity.this, "onAdLoaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
//                Toast.makeText(MainActivity.this, "onAdFailedToLoad", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
//                Toast.makeText(MainActivity.this, "onAdOpened", Toast.LENGTH_SHORT).show();
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
//                Toast.makeText(MainActivity.this, "onAdClicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
//                Toast.makeText(MainActivity.this, "onAdClosed", Toast.LENGTH_SHORT).show();
                // to the app after tapping on an ad.
            }
        });








        final MediaPlayer mp = MediaPlayer.create(this, R.raw.s5);


        btnBoor = findViewById(R.id.btnBoor);
        btnSmart = findViewById(R.id.btnSmart);

        btnComp = findViewById(R.id.btnComp);
        btnPlayers = findViewById(R.id.btnPlayers);


        gvalue = (globalV) getApplicationContext();

        btnBoor.setVisibility(View.INVISIBLE);
        btnSmart.setVisibility(View.INVISIBLE);



        btnPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this , Two_Players.class);
                startActivity(intent);
                mp.start();
            }
        });



        btnComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnBoor.getVisibility() == View.INVISIBLE) {
                    btnBoor.setVisibility(View.VISIBLE);
                    btnSmart.setVisibility(View.VISIBLE);
                }else
                {
                    btnBoor.setVisibility(View.INVISIBLE);
                    btnSmart.setVisibility(View.INVISIBLE);
                }
                mp.start();
            }
        });


        btnBoor.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                gvalue.setBrain("Boor");
                intent = new Intent(MainActivity.this , Comp.class);
                startActivity(intent);
                mp.start();
            }
        });

        btnSmart.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                gvalue.setBrain("Smart");
                intent = new Intent(MainActivity.this , Comp.class);
                startActivity(intent);
                mp.start();
            }
        });



    }
}
