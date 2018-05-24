package projet_commun.sciagoapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        //ActionBar actionBar = getSupportActionBar();
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
