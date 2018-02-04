package projet_commun.sciagoapp;

import android.app.Fragment;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tim-b on 03/02/2018.
 */

public class BottomBarFragment extends android.support.v4.app.Fragment {

    public static final String ARG_TITLE = "arg_title";
    private static final String ITEM_1 = "Home";
    private static final String ITEM_2 = "Fund";
    private static final String ITEM_3 = "Connect";

    private TextView textView;



    public BottomBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String title = getArguments().getString(ARG_TITLE, "");
        //System.err.println("######("+title+")######");

        View rootView = null;
        // Inflate the layout for this fragment
        if (title.equals(ITEM_1)) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        }
        else if (title.equals(ITEM_2)) {
            rootView = inflater.inflate(R.layout.fragment_fund, container, false);
        }else if (title.equals(ITEM_3)){
            rootView = inflater.inflate(R.layout.fragment_connect, container, false);
        }else
            rootView = inflater.inflate(R.layout.fragment_bottom_bar, container, false);

        //textView = (TextView) rootView.findViewById(R.id.fragment_bottom_bar_text_activetab);

        //textView.setText(title);

        return rootView;
    }

}
