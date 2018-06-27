package it.raceup.raceup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import it.raceup.raceup.R;

public class CheckoutShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_shop);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setup();
    }

    private void setup() {
        Button button = findViewById(R.id.pay_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheckoutActivity();
            }
        });
    }

    protected void openCheckoutActivity() {
        Intent openActivity = new Intent(CheckoutShopActivity.this, PaymentShopActivity.class);
        startActivity(openActivity);
    }

}
