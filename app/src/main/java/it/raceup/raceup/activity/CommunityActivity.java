package it.raceup.raceup.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import it.raceup.raceup.R;

public class CommunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        setupClickListeners();
    }

    private void setupClickListeners() {
        CardView card = getWindow().getDecorView().findViewById(R.id.card_eleonora);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayerActivity(
                        getString(R.string.eleonora),
                        getString(R.string.eleonora_spa),
                        getString(R.string.eleonora_age),
                        getString(R.string.eleonora_email),
                        getString(R.string.eleonora_career_record_monza),
                        getString(R.string.eleonora_career_record_spa)
                );
            }
        });

        card = getWindow().getDecorView().findViewById(R.id.card_jacopo);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayerActivity(
                        getString(R.string.jacopo),
                        getString(R.string.jacopo_spa),
                        getString(R.string.jacopo_age),
                        getString(R.string.jacopo_email),
                        getString(R.string.jacopo_career_record_monza),
                        getString(R.string.jacopo_career_record_spa)
                );
            }
        });
    }

    protected void openPlayerActivity(String name, String industry, String age, String email, String record_0, String record_1) {
        /*todo*/
    }
}
