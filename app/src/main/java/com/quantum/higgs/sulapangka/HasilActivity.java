package com.quantum.higgs.sulapangka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Quantum Higgs on 6/26/2018.
 */

public class HasilActivity extends AppCompatActivity {

    TextView txtHasil;
    Button balik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);

        balik = findViewById(R.id.Thanks);
        txtHasil = findViewById(R.id.txtHasil);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if ( b!= null)
        {
            Integer jumlah = (Integer) b.get("jumlah");
            txtHasil.setText(jumlah.toString());
        }

        balik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
