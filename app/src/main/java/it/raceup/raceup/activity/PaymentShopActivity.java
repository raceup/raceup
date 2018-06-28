package it.raceup.raceup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import it.raceup.raceup.R;

public class PaymentShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_shop);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setup();
    }

    private void setup() {
        Button button = findViewById(R.id.pay_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("All done! Payment successful!");
            }
        });
    }

    protected void showToast(String message) {
        Toast.makeText(PaymentShopActivity.this, message, Toast.LENGTH_LONG).show();
    }

}
