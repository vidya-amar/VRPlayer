package com.vrplayerapp.in;

/**
 * Created by Admin on 16-03-2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.Filterable;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.GestureDetector;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements RecyclerView.OnItemTouchListener,Filterable {
    private TextView header;
    private  TextView size;
    private ImageView image;
    private Context ctx;
    private ArrayList<AppsDataModel> dataSet;
    CustomFilter filter;
    ArrayList<AppsDataModel> filterList;
    private OnItemClickListener mListener;
    int count=0;
    int urlIndex[]=new int[200];

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);

    }
    GestureDetector mGestureDetector;
    public DataAdapter(Context context, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }
    public DataAdapter(Context ctx, ArrayList<AppsDataModel> data) {
        this.dataSet=data;
        this.ctx = ctx;
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
    public class CustomFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub
            FilterResults results=new FilterResults();
            if(constraint != null && constraint.length()>0)
            {
                //CONSTARINT TO UPPER
                constraint=constraint.toString().toUpperCase();
                ArrayList<AppsDataModel> filters=new ArrayList<AppsDataModel>();
                //int count=0;
                //get specific items
                count=0;
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getHeaderTxt().toUpperCase().contains(constraint))
                    {
                        AppsDataModel p=new AppsDataModel(filterList.get(i).getHeaderTxt(), filterList.get(i).getFooterTxt(),filterList.get(i).getImageUrl(),filterList.get(i).getId());
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
            dataSet=(ArrayList<AppsDataModel>) results.values;
            //imageView.setImageResource(videos.get(0).getVidImage());
            //Toast.makeText(c, "Publishresults: "+String.valueOf(videos.size())+"name="+videos.get(0).getVidName().toString(), Toast.LENGTH_SHORT).show();


            notifyDataSetChanged();
        }
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int listPosition) {
        TextView textViewHeader = viewHolder.header;
        TextView textViewSize = viewHolder.footer;
        ImageView imageView = viewHolder.image;

        textViewHeader.setText(dataSet.get(listPosition).getHeaderTxt());
        textViewSize.setText(dataSet.get(listPosition).getFooterTxt());
        String url = dataSet.get(listPosition).getImageUrl().toString();
        //https://image.ibb.co/ggMika/bacteria3d.png
        //
        // Trigger the download of the URL asynchronously into the image view.
        Picasso.with(ctx) //
                .load(url) //
                //.placeholder(R.drawable.placeholder) //
                .error(R.drawable.error) //
                .fit() //
                .tag(ctx) //
                .into(viewHolder.image);


    }

    @Override
    public int getItemCount() {
        //notifyDataSetChanged();
        return dataSet.size();
    }
    @Override
    public long getItemId(int position) {
        return dataSet.get(position).getId();
    }

   /* public void filter(String text) {
        dataSet.clear();
        if(text.isEmpty()){
            dataSet.addAll(itemsCopy);
        } else{
            text = text.toLowerCase();
            for(PhoneBookItem item: itemsCopy){
                if(item.name.toLowerCase().contains(text) || item.phone.toLowerCase().contains(text)){
                    dataSet.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }*/
  /* private static ArrayList<AppsDataModel> filter(ArrayList<AppsDataModel> data, String query) {
       final String lowerCaseQuery = query.toLowerCase();

       final ArrayList<AppsDataModel> filteredModelList = new ArrayList<AppsDataModel>();
       for (AppsDataModel model : data) {
           final String text = model.getHeaderTxt().toLowerCase();
           if (text.contains(lowerCaseQuery)) {
               filteredModelList.add(model);
           }
       }
       //notifyDataSetChanged();
       return filteredModelList;
   }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView header;
        private TextView footer;
        private ImageView image;
        public ViewHolder(View view) {
            super(view);

            header = (TextView)view.findViewById(R.id.header_txt);
            footer = (TextView)view.findViewById(R.id.footer_txt);
            image = (ImageView)view.findViewById(R.id.icon);
        }
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }



}
