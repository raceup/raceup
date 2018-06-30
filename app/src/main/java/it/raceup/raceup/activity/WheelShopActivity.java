package it.raceup.raceup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

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
        ImageButton button = findViewById(R.id.button_oz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSingleProductActivity();
            }
        });
    }

    protected void openSingleProductActivity() {
        Intent openActivity = new Intent(WheelShopActivity.this, SingleProductActivity.class);
        startActivity(openActivity);
    }
}
