package it.raceup.raceup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import it.raceup.raceup.R;

public class AeroShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aero_shop);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setup();
    }

    private void setup() {
        ImageButton button = findViewById(R.id.set_0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Added x1 SET 0 aerodynamics pack");
            }
        });

        button = findViewById(R.id.set_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Added x1 SET 1 aerodynamics pack");
            }
        });

        button = findViewById(R.id.set_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Added x1 SET 2 aerodynamics pack");
            }
        });

        button = findViewById(R.id.set_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Added x1 SET 3 aerodynamics pack");
            }
        });
    }

    protected void showToast(String message) {
        Toast.makeText(AeroShopActivity.this, message, Toast.LENGTH_LONG).show();
    }

}
