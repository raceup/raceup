/*
 * Copyright 2018 Race UP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.raceup.raceup.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import it.raceup.raceup.R;
import it.raceup.raceup.dialog.AboutDialog;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setup();
    }

    private void setup() {
        Button button = findViewById(R.id.shop_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShopActivity();
            }
        });

        button = findViewById(R.id.challenges_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChallengesActivity();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            openSettingsActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_real_time) {
            openRealTimeTelemetryActivity();
        } else if (id == R.id.nav_car) {
            openCustomizeActivity();
        } else if (id == R.id.nav_shop) {
            openShopActivity();
        } else if (id == R.id.nav_community) {
            openCommunityActivity();
        } else if (id == R.id.nav_challenge) {
            openChallengesActivity();
        } else if (id == R.id.nav_events) {
            openEventsActivity();
        } else if (id == R.id.nav_manage) {
            openSettingsActivity();
        } else if (id == R.id.nav_webpage) {
            openWebpage("http://www.raceup.it");
        } else if (id == R.id.nav_share) {
            openShareActivity();
        } else if (id == R.id.nav_about) {
            openAboutDialog();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openRealTimeTelemetryActivity() {
        openActivityByClass(RealTimeTelemetryActivity.class);
    }

    private void openWebpage(String url) {
        Intent openActivity = new Intent(
                "android.intent.action.VIEW",
                Uri.parse(url)
        );
        startActivity(openActivity);
    }

    private void openCustomizeActivity() {
        openActivityByClass(CustomizeActivity.class);
    }

    private void openShopActivity() {
        openActivityByClass(ShopActivity.class);
    }

    private void openSettingsActivity() {
        openActivityByClass(SettingsActivity.class);
    }

    private void openChallengesActivity() {
        openActivityByClass(ChallengesActivity.class);
    }

    private void openCommunityActivity() {
        openActivityByClass(CommunityActivity.class);
    }

    private void openEventsActivity() {
        openActivityByClass(EventsActivity.class);
    }

    private void openShareActivity() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey! Have you checked out the official Race UP android app?" +
                "Download it from here: https://github.com/raceup/raceup/blob/master/app/build/outputs/apk/app-debug.apk?raw=true");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void openActivityByClass(Class activityClass) {
        Intent openActivity = new Intent(MainActivity.this, activityClass);
        startActivity(openActivity);
    }

    private void openAboutDialog() {
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        try {
            assert inflater != null;
            View aboutDialogView = inflater.inflate(R.layout.about_dialog, null);
            TextView infoText = aboutDialogView.findViewById(R.id.info_text_about_dialog);
            infoText.setText(
                    Html.fromHtml(
                            "<h3>" +
                                    "RaceApp: the official Race UP android app to build your racing car" +
                                    "</h3>\n" +
                                    "<i>Build. Invite friends. Challenge them.</i><br>\n" +
                                    "Version 0.0.1<br>\n" +
                                    "Copyright (C) 2018<br>\n" +
                                    "<b>Race UP</b><br><br>\n" +
                                    "info@raceup.it"
                    )
            );

            // set legal text
            TextView legalText = aboutDialogView.findViewById(R.id.legal_text_about_dialog);
            legalText.setText(Html.fromHtml(
                    "Copyright (C) Race UP Electric Division 2018. <b>All rights reserved.</b>\n" +
                            "Unauthorized copying of this file, via any medium is strictly prohibited."));
            AboutDialog dialog = new AboutDialog(MainActivity.this, "", aboutDialogView);
            dialog.show();
        } catch (Exception e) {
            // todo get current view showToastMessage("Ooops! Cannot open the about dialog!");
        }
    }
}
