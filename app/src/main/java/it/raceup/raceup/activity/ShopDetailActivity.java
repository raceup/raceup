package it.raceup.raceup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import it.raceup.raceup.R;

public class ShopDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setup();
    }

    private void setup() {
        CardView card = findViewById(R.id.aero);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openActivity = new Intent(ShopDetailActivity.this, AeroShopActivity.class);
                startActivity(openActivity);
            }
        });

        card = findViewById(R.id.tyres);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openActivity = new Intent(ShopDetailActivity.this, WheelShopActivity.class);
                startActivity(openActivity);
            }
        });

        Button button = findViewById(R.id.checkout_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheckoutActivity();
            }
        });
    }

    protected void openCheckoutActivity() {
        Intent openActivity = new Intent(ShopDetailActivity.this, CheckoutShopActivity.class);
        startActivity(openActivity);
    }

}
