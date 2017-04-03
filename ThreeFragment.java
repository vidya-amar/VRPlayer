package com.vrplayerapp.in;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 07-02-2017.
 */

public class ThreeFragment extends Fragment {
    private Spinner spinnercat,spinnersub;
    // Store instance variables
    private String title;
    private int page;
    private ArrayList countries;

    // newInstance constructor for creating fragment with arguments
    public static ThreeFragment newInstance(int page, String title) {
        ThreeFragment fragmentThree = new ThreeFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentThree.setArguments(args);
        return fragmentThree;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //page = getArguments().getInt("someInt", 0);
        //title = getArguments().getString("someTitle");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_three, container, false);
     //   initViews(view);
        /*RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        Toast.makeText(getActivity().getApplicationContext(), "oncreate view entered", Toast.LENGTH_SHORT).show();*/
        return view;
       /* spinnercat = (Spinner) view.findViewById(R.id.spinner_cat);
        spinnersub = (Spinner) view.findViewById(R.id.spinner_sub);
        addItemsToSpinnercat();
        addItemsToSpinnersub();*/
    }
 /*   private void initViews(View vw){
        RecyclerView recyclerView = (RecyclerView) vw.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        Toast.makeText(getActivity().getApplicationContext(), "initviews entered", Toast.LENGTH_SHORT).show();
        countries = new ArrayList<>();
        countries.add("Australia");
        countries.add("India");
        countries.add("United States of America");
        countries.add("Germany");
        countries.add("Russia");
        RecyclerView.Adapter adapter = new DataAdapter(countries);
        recyclerView.setAdapter(adapter);
        Toast.makeText(getActivity().getApplicationContext(), "initviews entered", Toast.LENGTH_SHORT).show();

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getActivity().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if((child != null) && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    Toast.makeText(getActivity().getApplicationContext(), countries.get(position).toString(), Toast.LENGTH_SHORT).show();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }
 /*   public void addItemsToSpinnercat() {

        ArrayList<String> catlist = new ArrayList<String>();
        catlist.add("Category");
        catlist.add("3-5 yrs");
        catlist.add("5-7 yrs");
        catlist.add("7-11 yrs");
        catlist.add("11-14 yrs");
        catlist.add("14-16 yrs");

        // Custom ArrayAdapter with spinner item layout to set popup background

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getActivity().getApplicationContext(), catlist);
  /*
   * ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this,
   * android.R.layout.simple_spinner_item, list);
   * spinAdapter.setDropDownViewResource
   * (android.R.layout.simple_spinner_dropdown_item);
   */
   /*    spinnercat.setAdapter(spinAdapter);

        spinnercat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(getActivity().getApplicationContext(), "Selected  : " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

     /*       }
        });

    }*/
  /*  public void addItemsToSpinnersub() {

        ArrayList<String> sublist = new ArrayList<String>();
        sublist.add("Subject");
        sublist.add("Alphabets");
        sublist.add("Animals");
        sublist.add("Birds");
        sublist.add("Colours");
        sublist.add("Design");
        sublist.add("Numbers");
        sublist.add("Rhymes");

        // Custom ArrayAdapter with spinner item layout to set popup background

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getActivity().getApplicationContext(), sublist);
  /*
   * ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this,
   * android.R.layout.simple_spinner_item, list);
   * spinAdapter.setDropDownViewResource
   * (android.R.layout.simple_spinner_dropdown_item);
   */
  /*     spinnersub.setAdapter(spinAdapter);

        spinnersub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
                //Toast.makeText(getApplicationContext(), "Selected  : " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
/*
            }
        });

    }*/

}
