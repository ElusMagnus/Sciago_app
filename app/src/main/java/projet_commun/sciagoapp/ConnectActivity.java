package projet_commun.sciagoapp;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by tim-b on 02/02/2018.
 */

public class ConnectActivity extends AppCompatActivity{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.action_onglet_1:
                    item.setChecked(true);
                    Intent intent = new Intent(ConnectActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.action_onglet_2:
                    item.setChecked(true);

                    break;

                case R.id.action_onglet_3:
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
        setContentView(R.layout.activity_connect);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //MenuItem item3 = (MenuItem) findViewById(R.id.action_onglet_3);
        //item3.setChecked(true);
        //BottomNavigationItemView item3 = (BottomNavigationItemView) findViewById(R.id.menu_items);
        //MenuView.ItemView item3 = (MenuView.ItemView) findViewById(R.id.action_onglet_3);
        //item3.setChecked(true);
        //Menu menu = (Menu) findViewById(R.id.menu_items);
        //menu.getItem(3).setChecked(true);
        //BottomNavigationItemView bottomNav = (BottomNavigationItemView) findViewById(R.id.bottom_navigation)

    }

}
