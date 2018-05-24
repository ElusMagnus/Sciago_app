package projet_commun.sciagoapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    //public ImageLoader imageLoader;

    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        //activity = a;
        data=d;
        //inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        /*if(convertView==null)
            vi = inflater.inflate(R.layout.list_researchers, null);*/

        TextView title = (TextView)vi.findViewById(R.id.mainTitle); // title
        TextView artist = (TextView)vi.findViewById(R.id.mainDesc); // artist name
        //TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image =(ImageView)vi.findViewById(R.id.mainIcon); // thumb image

        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        // Setting all values in listview
        title.setText(song.get("Daniel Diaz"));
        artist.setText(song.get("Enseignant chercheur !"));
        //duration.setText(song.get("17:09"));
        //imageLoader.DisplayImage(song.get(""), thumb_image);

        //Image de profile
        final int stub_id = R.drawable.ic_profile;
        final int stub_id2 = R.drawable.ic_person_profile;
        /*if(bitmap!=null)
            imageView.setImageBitmap(bitmap);
        else
        {
            queuePhoto(url, imageView);
            imageView.setImageResource(stub_id);
        }*/
        thumb_image.setImageResource(stub_id2);

        return vi;
    }
}
