package projet_commun.sciagoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        /*Toolbar header = (Toolbar) findViewById(R.id.header);

        setSupportActionBar(header);

        getSupportActionBar().setTitle("Go SCIAGO");
        getSupportActionBar().setIcon(R.drawable.cropped_logo_agora_blanc);*/
    }
}
