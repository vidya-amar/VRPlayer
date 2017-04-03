package com.vrplayerapp.in;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 28-02-2017.
 */

public class SearchAdapter extends BaseAdapter implements Filterable {
    Context c;
    ArrayList<Video> videos;
    CustomFilter filter;
    ArrayList<Video> filterList;
    ImageView imageView;
    int urlIndex[]=new int[200];
    int count=0;
    public SearchAdapter(Context ctx, ArrayList<Video> videos) {
        this.c=ctx;
        this.videos=videos;
        this.filterList=videos;
    }

    @Override
    public int getCount() {
        //Toast.makeText(c, "getcount: "+String.valueOf(videos.size()), Toast.LENGTH_SHORT).show();
        return videos.size();

    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return videos.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(c);
            imageView.setLayoutParams(new GridView.LayoutParams(
                    (int)c.getResources().getDimension(R.dimen.width),
                    (int)c.getResources().getDimension(R.dimen.height)));
            //imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        /*if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model, null);
        }
        TextView nameTxt=(TextView) convertView.findViewById(R.id.nameTv);
        ImageView img=(ImageView) convertView.findViewById(R.id.imageView1);*/
        //SET DATA TO THEM
        //nameTxt.setText(videos.get(position).getVidName());
       // TextView nameTxt=(TextView) convertView.findViewById(R.id.nameTv);
        //nameTxt.setText(videos.get(position).getVidName());
        imageView.setImageResource(videos.get(position).getVidImage());
        //imageView.setTag(position,);
        //Toast.makeText(c, "getview: "+String.valueOf(videos.size())+"name="+videos.get(position).getVidName().toString(), Toast.LENGTH_SHORT).show();

        return imageView;
    }

    @Override
    public Filter getFilter() {
        if(filter == null)
        {
            filter=new CustomFilter();
        }
        return filter;
    }
    //INNER CLASS
    class CustomFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub
            FilterResults results=new FilterResults();
            if(constraint != null && constraint.length()>0)
            {
                //CONSTARINT TO UPPER
                constraint=constraint.toString().toUpperCase();
                ArrayList<Video> filters=new ArrayList<Video>();
                //int count=0;
                //get specific items
                count=0;
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getVidName().toUpperCase().contains(constraint))
                    {
                        Video p=new Video(filterList.get(i).getVidName(), filterList.get(i).getVidImage());
                        filters.add(p);
                        urlIndex[count]=i;
                        count++;
                        //Toast.makeText(c, "index:: " + String.valueOf(i) +",", Toast.LENGTH_SHORT).show();
                    }
                }
                //Toast.makeText(c, "filterresults: "+String.valueOf(filters.size())+"name="+filters.get(0).getVidName().toString(), Toast.LENGTH_SHORT).show();
                results.count=filters.size();
                results.values=filters;
            }else
            {
                results.count=filterList.size();
                results.values=filterList;
            }
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // TODO Auto-generated method stub
            videos=(ArrayList<Video>) results.values;
            //imageView.setImageResource(videos.get(0).getVidImage());
            //Toast.makeText(c, "Publishresults: "+String.valueOf(videos.size())+"name="+videos.get(0).getVidName().toString(), Toast.LENGTH_SHORT).show();


            notifyDataSetChanged();
        }
    }
}
