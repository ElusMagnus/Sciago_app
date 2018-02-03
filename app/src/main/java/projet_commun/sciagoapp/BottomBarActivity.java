package projet_commun.sciagoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tim-b on 03/02/2018.
 */

public class BottomBarActivity extends AppCompatActivity {
    private static final String TAG_FRAGMENT_CALLS = "tag_frag_calls";
    private static final String TAG_FRAGMENT_RECENTS = "tag_frag_recents";
    private static final String TAG_FRAGMENT_TRIPS = "tag_frag_trips";
    private static final String TAG_FRAGMENT_REWARD = "tag_frag_reward";

    private BottomNavigationView bottomNavigationView;
    /**
     * Maintains a list of Fragments for {@link BottomNavigationView}
     */
    private List<BottomBarFragment> fragments = new ArrayList<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_onglet_1:
                                switchFragment(0, TAG_FRAGMENT_CALLS);
                                return true;
                            case R.id.action_onglet_2:
                                switchFragment(1, TAG_FRAGMENT_RECENTS);
                                return true;
                            case R.id.action_onglet_3:
                                switchFragment(2, TAG_FRAGMENT_TRIPS);
                                return true;
                            case R.id.action_onglet_4:
                                switchFragment(3, TAG_FRAGMENT_REWARD);
                                return true;
                        }
                        return false;
                    }
                });

        buildFragmentsList();

        // Set the 0th Fragment to be displayed by default.
        switchFragment(0, TAG_FRAGMENT_CALLS);

    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, fragments.get(pos), tag)
                .commit();
    }

    private void buildFragmentsList() {
        BottomBarFragment callsFragment = buildFragment("Calls");
        BottomBarFragment recentsFragment = buildFragment("Recents");
        BottomBarFragment tripsFragment = buildFragment("Trips");
        BottomBarFragment rewardFragment = buildFragment("Reward");

        fragments.add(callsFragment);
        fragments.add(recentsFragment);
        fragments.add(tripsFragment);
        fragments.add(rewardFragment);
    }

    private BottomBarFragment buildFragment(String title) {
        BottomBarFragment fragment = new BottomBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BottomBarFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }
}