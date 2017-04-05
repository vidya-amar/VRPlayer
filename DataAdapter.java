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
    private ArrayList<AppsDataModel> dataSet,filterList;
    CustomFilter filter;
    private OnItemClickListener mListener;
    GestureDetector mGestureDetector;
    int count=0;
    int urlIndex[]=new int[200];

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);

    }

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
        this.filterList=data;
    }
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }

        return filter;
    }
    //INNER CLASS
    public class CustomFilter extends Filter {
        DataAdapter adapter;
        ArrayList<AppsDataModel> filterList;

        public CustomFilter(ArrayList<AppsDataModel> filterList, DataAdapter adapter) {
            this.adapter = adapter;
            this.filterList = filterList;
        }

        //FILTERING OCURS
        @Override
        protected Filter.FilterResults performFiltering(CharSequence constraint) {
            Filter.FilterResults results = new Filter.FilterResults();
            //CHECK CONSTRAINT VALIDITY
            if (constraint != null && constraint.length() > 0) {
                //CHANGE TO UPPER
                constraint = constraint.toString().toUpperCase();
                //STORE OUR FILTERED PLAYERS
                ArrayList<AppsDataModel> filteredApps = new ArrayList<>();
                for (int i = 0; i < filterList.size(); i++) {
                    //CHECK
                    if (filterList.get(i).getHeaderTxt().toUpperCase().contains(constraint)) {
                        //ADD APP TO FILTERED APPS
                        AppsDataModel p = new AppsDataModel(filterList.get(i).getHeaderTxt(), filterList.get(i).getFooterTxt(), filterList.get(i).getImageUrl(), filterList.get(i).getId());
                        filteredApps.add(p);
                        // filteredApps.add(filterList.get(i).getHeaderTxt(),filterList.get(i).getFooterTxt(),filterList.get(i).getImageUrl(),filterList.get(i).getId());
                    }
                }
                results.count = filteredApps.size();
                results.values = filteredApps;
            } else {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
            adapter.dataSet = (ArrayList<AppsDataModel>) results.values;
            //REFRESH
            adapter.notifyDataSetChanged();
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
