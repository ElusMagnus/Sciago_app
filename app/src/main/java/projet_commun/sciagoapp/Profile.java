package projet_commun.sciagoapp;

import android.content.ClipData;
import android.content.Intent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    /*FragmentManager fragmentManager;
    FragmentTransaction transaction;
    ConnectFragment connectFragment;*/

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        //ActionBar actionBar = getSupportActionBar();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //android.support.design.internal.BottomNavigationItemView
        BottomNavigationItemView onglet1 = (BottomNavigationItemView) findViewById(R.id.action_onglet_1);
        onglet1.setChecked(false);
        //onglet1.setCheckable();
        //onglet1.setKeepScreenOn();
        //onglet1.setEnabled();
        //onglet1.setShiftingMode(false);

        //int color = getResources().getColor(R.color.mainTabInactive);
        //onglet1.setBackgroundColor(color);

        BottomNavigationItemView onglet3 = (BottomNavigationItemView) findViewById(R.id.action_onglet_3);
        onglet3.setChecked(true);
        BottomNavigationItemView onglet4 = (BottomNavigationItemView) findViewById(R.id.action_onglet_4);
        onglet4.setChecked(false);

        TextView mDetailTv = (TextView) findViewById(R.id.textView1);
        TextView mDescTv = (TextView) findViewById(R.id.textView2);
        EditText champ = (EditText) findViewById(R.id.editTextChamp);
        champ.clearFocus();

        //get data from previous activity when item of listview is clicked using intent
        Intent intent = getIntent();
        //String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentTv");
        String mDesc = intent.getStringExtra("descTv");


        //set actionbar title
        //actionBar.setTitle(mActionBarTitle);
        //set text in textview
        mDetailTv.setText(mContent);
        mDescTv.setText(mDesc);

    }
}
