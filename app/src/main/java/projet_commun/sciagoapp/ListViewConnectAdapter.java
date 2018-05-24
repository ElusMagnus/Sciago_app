package projet_commun.sciagoapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import projet_commun.sciagoapp.model.DataBase;

public class ListViewConnectAdapter extends BaseAdapter{

    Context mContext;
    LayoutInflater inflater;
    List<DataBase> modellist;
    ArrayList<DataBase> arrayList;

    public ListViewConnectAdapter(Context context, List<DataBase> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<DataBase>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHoler{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int position) {
        return modellist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHoler holder;
        if (view==null){
            holder = new ViewHoler();
            view = inflater.inflate(R.layout.list_researchers, null);

            //locate the views in list_researchers.xml
            holder.mTitleTv = (TextView) view.findViewById(R.id.mainTitle);
            holder.mDescTv = (TextView) view.findViewById(R.id.mainDesc);
            holder.mIconIv = (ImageView) view.findViewById(R.id.mainIcon);

            view.setTag(holder);
        }else {
            holder = (ViewHoler) view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(position).getTitle());
        holder.mDescTv.setText(modellist.get(position).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(position).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                Intent intent = new Intent(mContext, NewActivity.class);
                intent.putExtra("actionBarTitle", "Sensor");
                intent.putExtra("contentTv", "This is Sensor detail...");
                mContext.startActivity(intent);
                /*if (modellist.get(position).getTitle().equals("Battery")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Battery");
                    intent.putExtra("contentTv", "This is Battery detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Cpu")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Cpu");
                    intent.putExtra("contentTv", "This is Cpu detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Display")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Display");
                    intent.putExtra("contentTv", "This is Display detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Memory")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Memory");
                    intent.putExtra("contentTv", "This is Memory detail...");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Sensor")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Sensor");
                    intent.putExtra("contentTv", "This is Sensor detail...");
                    mContext.startActivity(intent);
                }*/
            }
        });
        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (DataBase model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
