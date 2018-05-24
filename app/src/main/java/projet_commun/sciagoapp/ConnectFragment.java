package projet_commun.sciagoapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import projet_commun.sciagoapp.model.DataBase;

public class ConnectFragment extends Fragment{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    ListView connect_listView;
    ListViewConnectAdapter connectAdapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<DataBase> arrayList = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    private LazyAdapter adapter2;

    public ConnectFragment(){
        // Required empty public constructor
    }

    public static ConnectFragment newInstance(String param1, String param2) {
        ConnectFragment fragment = new ConnectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
            /*@Nullable*/ ViewGroup container,
                             /*@Nullable*/ Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_connect, container, false);

        final ArrayList<String> data = new ArrayList<>();
        //Appel à la base de données !
        //DataBase db = new DataBase();
        //Map<Integer, ArrayList<String>> listeChercheurs = db.getListeChercheurs();

        //data.add(listeChercheurs.get(0).get(0));
        //data.add(listeChercheurs.get(0).get(1));
        //data.add(listeChercheurs.get(1).get(0));
        //data.add(listeChercheurs.get(1).get(1));
        data.add("Mission 2");
        data.add("Prénom nom Chercheur 3");
        data.add("Financement 5");
        data.add("Mission 3");
        data.add("Financement 6");
        data.add("Financement 7");
        data.add("Mission 4");
        data.add("Financement 8");
        data.add("Mission 5");
        data.add("Mission 6");
        data.add("Mission 7");
        data.add("Mission 8");

        title = new String[]{"Battery", "Cpu", "Display", "Memory", "Sensor"};
        description = new String[]{"Battery detail...", "Cpu detail...", "Display detail...", "Memory detail...", "Sensor detail..."};
        icon = new int[]{R.drawable.ic_profile, R.drawable.ic_profile, R.drawable.ic_person_profile, R.drawable.ic_profile, R.drawable.ic_profile};

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, data);
        connect_listView = (ListView) view.findViewById(R.id.connect_listView);

        for (int i =0; i<title.length; i++){
            DataBase model = new DataBase(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
        connectAdapter = new ListViewConnectAdapter(this.getContext(), arrayList);   //(this, arrayList)

        //bind the adapter to the listview
        connect_listView.setAdapter(connectAdapter);




        /*ArrayList<HashMap<String, String>> arrayListChercheurs = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        hm.put(listeChercheurs.get(0).get(0), listeChercheurs.get(0).get(1));
        arrayListChercheurs.add(0, hm);
        Activity a = null;
        adapter2 = new LazyAdapter(a, arrayListChercheurs);
        connect_listView.setAdapter(adapter2);*/

        /*connect_listView.setAdapter(connectAdapter);
        connect_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedData = data.get(i);
                System.err.println("selectedData : "+selectedData+" #"+i);
                //DetailFundFragment detailFundFragment = new DetailFundFragment();
                //ConnectFragment fragment = new ConnectFragment();

                Bundle bundle = new Bundle();
                bundle.putString("selected_data", selectedData);
                //detailFundFragment.setArguments(bundle);
                //fragment.setArguments(bundle);

                //FragmentManager fragmentManager = getFragmentManager();
                //fragmentManager.beginTransaction().replace(R.id.fragment_connect, detailFundFragment).commit();
            }
        });*/

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ConnectFragment.OnFragmentInteractionListener) {
            mListener = (ConnectFragment.OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
