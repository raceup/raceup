package it.raceup.raceup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import it.raceup.raceup.R;

public class WheelShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_shop);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setup();
    }

    private void setup() {
        ImageButton button = findViewById(R.id.button_braid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Added x4 BRAID wheels");
            }
        });

        button = findViewById(R.id.button_blackwave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Added x4 BLACKWAVE wheels");
            }
        });

        button = findViewById(R.id.button_oz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Added x4 OZ wheels");
            }
        });

        button = findViewById(R.id.button_avon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Added x4 AVON wheels");
            }
        });
    }

    protected void showToast(String message) {
        Toast.makeText(WheelShopActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
