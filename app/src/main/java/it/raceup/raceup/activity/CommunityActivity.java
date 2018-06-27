package it.raceup.raceup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import it.raceup.raceup.R;

public class CommunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        setup();
    }

    private void setup() {
        setupCardListeners();
    }

    private void setupCardListeners() {
        CardView card = findViewById(R.id.card_aero);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForumDetailActivity();
            }
        });
    }

    protected void openForumDetailActivity() {
        Intent openActivity = new Intent(CommunityActivity.this, ForumDetailActivity.class);
        startActivity(openActivity);
    }
}
