package projet_commun.sciagoapp;

/**
 * Created by Elie on 31/05/2018.
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import projet_commun.sciagoapp.utils.JSONParser;

public class RegisterActivity extends AppCompatActivity {

    JSONParser jsonParser = new JSONParser();
    private EditText prenomChercheur, nomChercheur, statutChercheur, institutionChercheur, description, password;
    private AutoCompleteTextView email;
    private Button btnRegister;

    // url to create new product
    private static String url_create_user = "http://eabouhaydar.ddns.net/sciago/create-user.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Edit Text
        prenomChercheur = (EditText)findViewById(R.id.prenomChercheur);
        nomChercheur = (EditText)findViewById(R.id.nomChercheur);
        statutChercheur = (EditText)findViewById(R.id.statutChercheur);
        institutionChercheur = (EditText)findViewById(R.id.institutionChercheur);

        // Create button
        Button btnCreateProduct = (Button) findViewById(R.id.searcher_register_button);

        // button click event
        btnCreateProduct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // creating new product in background thread
                new CreateNewProduct().execute();
            }
        });
    }

    /**
     * Background Async Task to Create new product
     * */
    class CreateNewProduct extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
                    }

        /**
         * Creating product
         * */
        protected String doInBackground(String... args) {
            String name = prenomChercheur.getText().toString();
            String price = nomChercheur.getText().toString();

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", name));
            params.add(new BasicNameValuePair("password", price));

            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_create_user,
                    "GET", params);
            // check log cat fro response
            Log.d("Create Response", json.toString());

            return json.toString();
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            JSONObject json;
            try {
                json = new JSONObject(result);
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    // successfully created product
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    // closing this screen
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}
