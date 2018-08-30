package com.quantum.higgs.sulapangka;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private ImageView soal;
    private Button ada, tidak;
    private ImageButton btnHelp;
    private ImageButton btnKeluar;
    private Integer jumlah = 0;
    private Integer nSoal = 0;
    private Integer jmlExtra = 0;

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //iklan banner

        //test unit "ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this,"ca-app-pub-2760112945176520~7294016378");

        //iklan interesial
        //test interesial ca-app-pub-3940256099942544/1033173712
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2760112945176520/6768236917");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        //run iklan banner
        //test banner ca-app-pub-3940256099942544/6300978111
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        soal = findViewById(R.id.img_soal);
        ada = findViewById(R.id.btn_Ada);
        tidak = findViewById(R.id.btn_Tidak);
        btnHelp = findViewById(R.id.btn_help);
        btnKeluar = findViewById(R.id.btn_close);

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });

        ada.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(nSoal == 0)
                {
                    jumlah += 1;
                    nSoal += 1;
                    soal.setImageResource(R.drawable.soal2);
                }
                else if(nSoal == 1)
                {
                    jumlah += 2;
                    nSoal += 1;
                    soal.setImageResource(R.drawable.soal3);
                }
                else if(nSoal == 2)
                {
                    jumlah += 4;
                    nSoal += 1;
                    soal.setImageResource(R.drawable.soal4);
                }
                else if(nSoal == 3)
                {
                    jumlah += 8;
                    nSoal += 1;
                    soal.setImageResource(R.drawable.soal5);
                }
                else if(nSoal == 4)
                {
                    jumlah += 16;
                    nSoal = 0;
                    Intent intent = new Intent(getApplication(),HasilActivity.class);
                    intent.putExtra("jumlah",jumlah);
                    startActivity(intent);

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }

            }
        });

        tidak.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(nSoal == 0)
                {
                    nSoal += 1;
                    soal.setImageResource(R.drawable.soal2);
                }
                else if(nSoal == 1)
                {
                    nSoal += 1;
                    soal.setImageResource(R.drawable.soal3);
                }
                else if(nSoal == 2)
                {
                    nSoal += 1;
                    soal.setImageResource(R.drawable.soal4);
                }
                else if(nSoal == 3)
                {
                    nSoal += 1;
                    soal.setImageResource(R.drawable.soal5);
                }
                else if(nSoal == 4)
                {
                    nSoal = 0;
                    Intent intent = new Intent(getApplication(),HasilActivity.class);
                    intent.putExtra("jumlah",jumlah);
                    startActivity(intent);

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_help);
                dialog.setTitle("Cara Bermain");

                // set the custom dialog components - text, image and button
                ImageView image = (ImageView) dialog.findViewById(R.id.img_help);
                image.setImageResource(R.mipmap.ic_launcher);

                Button dialogButton = (Button) dialog.findViewById(R.id.btnOk);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }
}
