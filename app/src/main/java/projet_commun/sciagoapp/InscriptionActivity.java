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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class InscriptionActivity extends AppCompatActivity {

    private EditText prenomChercheur, nomChercheur, statutChercheur, institutionChercheur, description, password;
    private AutoCompleteTextView email;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        prenomChercheur = (EditText)findViewById(R.id.prenomChercheur);
        nomChercheur = (EditText)findViewById(R.id.nomChercheur);
        statutChercheur = (EditText)findViewById(R.id.statutChercheur);
        institutionChercheur = (EditText)findViewById(R.id.institutionChercheur);


    }

}
