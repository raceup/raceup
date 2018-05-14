/*
 * Copyright 2017 Race UP Electric Division
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

package it.raceup.raceup.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import it.raceup.raceup.R;
import it.raceup.raceup.fragment.ChallengesHistoryFragment;
import it.raceup.raceup.fragment.ChallengesNewFragment;

/**
 * Pager for RealTimeTelemetry activity
 */
public class ChallengesPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public ChallengesPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ChallengesNewFragment();
        } else {
            return new ChallengesHistoryFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;  // number of pages
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.challenges_fragment_history);
            case 1:
                return context.getString(R.string.challenges_fragment_new);
        }
        return null;
    }
}