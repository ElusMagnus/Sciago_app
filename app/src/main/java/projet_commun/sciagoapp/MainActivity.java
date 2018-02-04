package projet_commun.sciagoapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {



    private static final String TAG_FRAGMENT_HOME = "tag_frag_home";
    private static final String TAG_FRAGMENT_FUND = "tag_frag_fund";
    private static final String TAG_FRAGMENT_CONNECT = "tag_frag_connect";
    private static final String TAG_FRAGMENT_REWARD = "tag_frag_reward";

    private BottomNavigationView bottomNavigationView;

    /**
     * Maintains a list of Fragments for {@link BottomNavigationView}
     */
    private List<BottomBarFragment> fragments = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        HomeFragment homeFragment = new HomeFragment();
                        FundFragment fundFragment = new FundFragment();
                        switch (item.getItemId()) {
                            case R.id.action_onglet_1:
                                transaction.replace(R.id.frame_fragmentholder, homeFragment).commit();
                                //switchFragment(0, TAG_FRAGMENT_HOME);
                                return true;
                            case R.id.action_onglet_2:
                                transaction.replace(R.id.frame_fragmentholder, fundFragment).commit();
                                //switchFragment(1, TAG_FRAGMENT_FUND);
                                return true;
                            case R.id.action_onglet_3:
                                switchFragment(2, TAG_FRAGMENT_CONNECT);
                                return true;
                            case R.id.action_onglet_4:
                                switchFragment(3, TAG_FRAGMENT_REWARD);
                                return true;
                        }
                        return false;
                    }
                }
        );

        buildFragmentsList();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_fragmentholder, new HomeFragment()).commit();

        // Set the 0th Fragment to be displayed by default.
        //switchFragment(0, TAG_FRAGMENT_HOME);
    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, fragments.get(pos), tag)
                .commit();
    }

    private void buildFragmentsList() {
        BottomBarFragment homeFragment = buildFragment("Home");
        BottomBarFragment fundFragment = buildFragment("Fund");
        BottomBarFragment connectFragment = buildFragment("Connect");
        BottomBarFragment rewardFragment = buildFragment("Reward");

        fragments.add(homeFragment);
        fragments.add(fundFragment);
        fragments.add(connectFragment);
        fragments.add(rewardFragment);
    }

    /**
     * Creates a {@link BottomBarFragment} with corresponding Item title.
     *
     * @param title
     * @return
     */

    private BottomBarFragment buildFragment(String title) {
        BottomBarFragment fragment = new BottomBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BottomBarFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }





    /*private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.action_onglet_1:
                    item.setChecked(true);
                    break;

                case R.id.action_onglet_2:
                    //Action quand onglet 2 sélectionné
                    //item.setChecked(true);
                    break;


                case R.id.action_onglet_3:
                    //item.setChecked(true);
                    Intent intent = new Intent(MainActivity.this, ConnectActivity.class);
                    startActivity(intent);
                    item.setChecked(true);
                    break;

                case R.id.action_onglet_4:
                    item.setChecked(true);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.bottom_navigation);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }*/

}