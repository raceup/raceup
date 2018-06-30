package it.raceup.raceup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import it.raceup.raceup.R;

public class SingleProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);
        setup();
    }

    private void setup() {
        Button button = findViewById(R.id.cart_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Added x4 OZ wheels");
            }
        });
    }

    protected void showToast(String message) {
        Toast.makeText(SingleProductActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
