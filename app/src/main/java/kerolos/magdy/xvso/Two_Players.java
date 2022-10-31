package kerolos.magdy.xvso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Two_Players extends AppCompatActivity {
    Button btnNest,btnAgain,btnBack;
    TextView b1,b2,b3,b4,b5,b6,b7,b8,b9;

    TextView txtPlayer1, txtPlayer2,txtPoints1,txtPoints2;
    String w = "X";

    String player1 = " ";
    String player2 = " ";

    int point1 = 0, point2 = 0;

    boolean ch = false;

    AdView adView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_players);

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
//                Toast.makeText(Two_Players.this, "onAdLoaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
//                Toast.makeText(Two_Players.this, "onAdFailedToLoad", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
//                Toast.makeText(Two_Players.this, "onAdOpened", Toast.LENGTH_SHORT).show();
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
//                Toast.makeText(Two_Players.this, "onAdClicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
//                Toast.makeText(Two_Players.this, "onAdClosed", Toast.LENGTH_SHORT).show();
                // to the app after tapping on an ad.
            }
        });







        final MediaPlayer mp = MediaPlayer.create(this, R.raw.s6);


        txtPlayer1 = findViewById(R.id.player1);
        txtPlayer2 = findViewById(R.id.player2);
        txtPoints1 = findViewById(R.id.txtPoints1);
        txtPoints2 = findViewById(R.id.txtPoints2);

        btnNest = findViewById(R.id.btnNext);
        btnAgain = findViewById(R.id.btnAgain);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Two_Players.this, MainActivity.class);
                startActivity(intent);
            }
        });



        btnNest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w = "X";
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");

                b1.setTextColor(getColor(R.color.black));
                b2.setTextColor(getColor(R.color.black));
                b3.setTextColor(getColor(R.color.black));
                b4.setTextColor(getColor(R.color.black));
                b5.setTextColor(getColor(R.color.black));
                b6.setTextColor(getColor(R.color.black));
                b7.setTextColor(getColor(R.color.black));
                b8.setTextColor(getColor(R.color.black));
                b9.setTextColor(getColor(R.color.black));

                ch = false;

                mp.start();
            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // the original bunner id :  // ca-app-pub-2364540151063575/9419552229
                AdRequest adRequest2 = new AdRequest.Builder().build();

                InterstitialAd.load(Two_Players.this,"ca-app-pub-2364540151063575/9419552229", adRequest2,
                        new InterstitialAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                // The mInterstitialAd reference will be null until
                                // an ad is loaded.
//                                Toast.makeText(Two_Players.this, "onAdLoaded", Toast.LENGTH_SHORT).show();
                                interstitialAd.show(Two_Players.this);

                                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdClicked() {
                                        super.onAdClicked();
//                                        Toast.makeText(Two_Players.this, "onAdClicked", Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
//                                        Toast.makeText(Two_Players.this, "onAdDismissedFullScreenContent", Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
//                                        Toast.makeText(Two_Players.this, "onAdFailedToShowFullScreenContent", Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onAdImpression() {
                                        super.onAdImpression();
//                                        Toast.makeText(Two_Players.this, "onAdImpression", Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                        super.onAdShowedFullScreenContent();
//                                        Toast.makeText(Two_Players.this, "onAdShowedFullScreenContent", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                // Handle the error
//                                Toast.makeText(Two_Players.this, "onAdFailedToLoad", Toast.LENGTH_SHORT).show();

                            }
                        });









                w = "X";
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");

                b1.setTextColor(getColor(R.color.black));
                b2.setTextColor(getColor(R.color.black));
                b3.setTextColor(getColor(R.color.black));
                b4.setTextColor(getColor(R.color.black));
                b5.setTextColor(getColor(R.color.black));
                b6.setTextColor(getColor(R.color.black));
                b7.setTextColor(getColor(R.color.black));
                b8.setTextColor(getColor(R.color.black));
                b9.setTextColor(getColor(R.color.black));

                point1 = 0;
                point2 = 0;

                txtPoints2.setText("" + point1);
                txtPoints1.setText("" + point2);


                txtPlayer1.setText("");
                txtPlayer2.setText("");

                infoAlert("Player 2",txtPlayer2);
                infoAlert("Player 1",txtPlayer1);

                txtPlayer1.setText(player1);
                txtPlayer2.setText(player2);


                ch = false;

                mp.start();
            }
        });

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);


        infoAlert("Player 2",txtPlayer2);
        infoAlert("Player 1",txtPlayer1);

        txtPlayer1.setText(player1);
        txtPlayer2.setText(player2);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b1);
                win();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b2);
                win();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b3);
                win();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b4);
                win();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b5);
                win();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b6);
                win();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b7);
                win();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b8);
                win();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                press(b9);
                win();
            }
        });
    }

    public void press(TextView b)
    {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.s7);


        Typeface tf = Typeface.createFromAsset(getAssets(), "font5.TTF");

        if(b.getText() == "") {

            b.setText(w);

            if (w == "X")
                w = "O";
            else
                w = "X";
        }

        b.setTypeface(tf);

        mp.start();
    }


    public void win()
    {

        if (b1.getText() == b2.getText() && b2.getText() == b3.getText() && b1.getText() != "")
        {
            b1.setTextColor(getColor(R.color.Red));
            b2.setTextColor(getColor(R.color.Red));
            b3.setTextColor(getColor(R.color.Red));

            b4.setTextColor(getColor(R.color.gray));
            b5.setTextColor(getColor(R.color.gray));
            b6.setTextColor(getColor(R.color.gray));
            b7.setTextColor(getColor(R.color.gray));
            b8.setTextColor(getColor(R.color.gray));
            b9.setTextColor(getColor(R.color.gray));

            winAlert();

        }
        if (b4.getText() == b5.getText() && b5.getText() == b6.getText() && b4.getText() != "")
        {
            b4.setTextColor(getColor(R.color.Red));
            b5.setTextColor(getColor(R.color.Red));
            b6.setTextColor(getColor(R.color.Red));

            b1.setTextColor(getColor(R.color.gray));
            b2.setTextColor(getColor(R.color.gray));
            b3.setTextColor(getColor(R.color.gray));
            b7.setTextColor(getColor(R.color.gray));
            b8.setTextColor(getColor(R.color.gray));
            b9.setTextColor(getColor(R.color.gray));

            winAlert();
        }
        if (b7.getText() == b8.getText() && b8.getText() == b9.getText() && b7.getText() != "")
        {
            b7.setTextColor(getColor(R.color.Red));
            b8.setTextColor(getColor(R.color.Red));
            b9.setTextColor(getColor(R.color.Red));

            b4.setTextColor(getColor(R.color.gray));
            b5.setTextColor(getColor(R.color.gray));
            b6.setTextColor(getColor(R.color.gray));
            b1.setTextColor(getColor(R.color.gray));
            b2.setTextColor(getColor(R.color.gray));
            b3.setTextColor(getColor(R.color.gray));

            winAlert();
        }
        if (b1.getText() == b4.getText() && b4.getText() == b7.getText() && b1.getText() != "")
        {
            b1.setTextColor(getColor(R.color.Red));
            b4.setTextColor(getColor(R.color.Red));
            b7.setTextColor(getColor(R.color.Red));

            b2.setTextColor(getColor(R.color.gray));
            b3.setTextColor(getColor(R.color.gray));
            b5.setTextColor(getColor(R.color.gray));
            b6.setTextColor(getColor(R.color.gray));
            b8.setTextColor(getColor(R.color.gray));
            b9.setTextColor(getColor(R.color.gray));

            winAlert();
        }
        if (b2.getText() == b5.getText() && b5.getText() == b8.getText() && b2.getText() != "")
        {
            b2.setTextColor(getColor(R.color.Red));
            b5.setTextColor(getColor(R.color.Red));
            b8.setTextColor(getColor(R.color.Red));

            b1.setTextColor(getColor(R.color.gray));
            b3.setTextColor(getColor(R.color.gray));
            b4.setTextColor(getColor(R.color.gray));
            b6.setTextColor(getColor(R.color.gray));
            b7.setTextColor(getColor(R.color.gray));
            b9.setTextColor(getColor(R.color.gray));

            winAlert();
        }
        if (b3.getText() == b6.getText() && b6.getText() == b9.getText() && b3.getText() != "")
        {
            b3.setTextColor(getColor(R.color.Red));
            b6.setTextColor(getColor(R.color.Red));
            b9.setTextColor(getColor(R.color.Red));

            b1.setTextColor(getColor(R.color.gray));
            b2.setTextColor(getColor(R.color.gray));
            b4.setTextColor(getColor(R.color.gray));
            b5.setTextColor(getColor(R.color.gray));
            b7.setTextColor(getColor(R.color.gray));
            b8.setTextColor(getColor(R.color.gray));

            winAlert();
        }
        if (b1.getText() == b5.getText() && b5.getText() == b9.getText() && b1.getText() != "")
        {
            b1.setTextColor(getColor(R.color.Red));
            b5.setTextColor(getColor(R.color.Red));
            b9.setTextColor(getColor(R.color.Red));

            b2.setTextColor(getColor(R.color.gray));
            b3.setTextColor(getColor(R.color.gray));
            b4.setTextColor(getColor(R.color.gray));
            b6.setTextColor(getColor(R.color.gray));
            b7.setTextColor(getColor(R.color.gray));
            b8.setTextColor(getColor(R.color.gray));

            winAlert();
        }
        if (b3.getText() == b5.getText() && b5.getText() == b7.getText() && b3.getText() != "")
        {
            b3.setTextColor(getColor(R.color.Red));
            b5.setTextColor(getColor(R.color.Red));
            b7.setTextColor(getColor(R.color.Red));

            b1.setTextColor(getColor(R.color.gray));
            b2.setTextColor(getColor(R.color.gray));
            b4.setTextColor(getColor(R.color.gray));
            b6.setTextColor(getColor(R.color.gray));
            b8.setTextColor(getColor(R.color.gray));
            b9.setTextColor(getColor(R.color.gray));

            winAlert();
        }


    }

    @SuppressLint("ResourceAsColor")
    public void winAlert() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        if (ch == false)
        {
            if (w == "X") {
                point1++;
                txtPoints2.setText("" + point1);
                if (!txtPlayer1.getText().toString().matches(" ") && !txtPlayer2.getText().toString().matches(" "))
                    alert.setTitle(txtPlayer2.getText() + "is the WINNER..! ☺");
                else
                    alert.setTitle("Player (O) is the WINNER..! ☺");

            } else if (w == "O") {
                point2++;
                txtPoints1.setText("" + point2);
                if (!txtPlayer1.getText().toString().matches(" ") && !txtPlayer2.getText().toString().matches(" "))
                    alert.setTitle(txtPlayer1.getText() + "is the WINNER..! ☺");
                else
                    alert.setTitle("Player (X) is the WINNER..! ☺");

            }
            alert.create().show();
        }

        ch = true;

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);

        mp.start();
    }


    public void infoAlert(final String player , final TextView text)
    {

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.s5);

        final EditText txtname = new EditText(this);


        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(player + " : ");
        alert.setCancelable(false);
//        alert.setMessage();
        alert.setView(txtname);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text.setText(txtname.getText().toString() + " ");

                mp.start();
            }
        });



        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                mp.start();
            }
        });

        alert.show();

    }

}
