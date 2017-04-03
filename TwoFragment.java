package com.vrplayerapp.in;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 07-02-2017.
 */

public class TwoFragment extends Fragment {
    //https://goo.gl/photos/kva6hpnybst4Ls1y6
    //private Spinner spinnercat,spinnersub;
    // Store instance variables
    private String title;
    private int page;
    private Spinner spinnerarvr,spinnercat,spinnersub;
    //GridView gridview;
    private int mImageArray=0;
    CustomSpinnerAdapter spinAdaptercat, spinAdaptersub;
    Intent intentAppUrl;
    private SearchView searchView;
    MenuItem myActionMenuItem;
    private int arvrFlag=0;
    private int ageFlag=0;
    private int subjectFlag=0;
    int searchFlag=0;
    private ArrayList<AppsDataModel> dataSet;
    ArrayList<AppsDataModel> filterList;

    private String grid_currentQuery = null; // holds the current query..
    //ListView lv;
    SearchView sv;
    private static ArrayList<AppsDataModel> data,ar,vr,arAge1,arAge2,vrAge1,
            vrAge2,vrAge3,vrAge4,arAge1Sub1,arAge1Sub2,arAge2Sub1,arAge2Sub2,
            vrAge1Sub1,vrAge1Sub2,vrAge1Sub3,vrAge2Sub1,vrAge2Sub2,vrAge2Sub3,
            vrAge3Sub1,vrAge3Sub2,vrAge3Sub3,vrAge3Sub4,vrAge4Sub1,vrAge4Sub2,vrAge4Sub3;
    private ArrayList footerArraylist,headerArraylist,imageUrllist;
    private RecyclerView recyclerView;
    // newInstance constructor for creating fragment with arguments
    public static TwoFragment newInstance(int page, String title) {
        TwoFragment fragmentTwo = new TwoFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentTwo.setArguments(args);
        return fragmentTwo;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate( R.menu.menu_main, menu);
       // final SearchAdapter adapter=new SearchAdapter(getActivity().getApplicationContext(), getVideos());
        myActionMenuItem = menu.findItem( R.id.action_search);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       int id = item.getItemId();
        if (id == R.id.action_search) {
            searchFlag=1;
            final RecyclerView.Adapter adapter = new DataAdapter(getActivity().getApplicationContext(),data);
            recyclerView.setAdapter(adapter);
            searchView = (SearchView) myActionMenuItem.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                   // recyclerView.getAdapter().filter(query);
                   //adapter.getFilter().filter(query);
                    //Toast.makeText(getActivity().getApplicationContext(), "SearchOnQueryTextSubmit: " + query, Toast.LENGTH_LONG).show();
                    if( ! searchView.isIconified()) {
                        searchView.setIconified(true);
                    }
                    myActionMenuItem.collapseActionView();
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                   // adapter.filter(data,newText);
                    // adapter.getFilter().filter(s);
                    // Toast.makeText(getActivity().getApplicationContext(),  "SearchOnQueryTextChanged: " + s, Toast.LENGTH_LONG).show();
                    return false;
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_two, container, false);
        spinnerarvr = (Spinner) view.findViewById(R.id.spinner_arvr);
        spinnercat = (Spinner) view.findViewById(R.id.spinner_app_cat);
        spinnersub = (Spinner) view.findViewById(R.id.spinner_app_sub);
        addItemsToSpinnerarvr();
        addItemsToSpinnercat();
        addItemsToSpinnersub();
        initViews(view);
        return view;
    }
    private void initViews(View vw){
        recyclerView = (RecyclerView) vw.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
       // Toast.makeText(getActivity().getApplicationContext(), "initviews entered", Toast.LENGTH_SHORT).show();
      
        data = new ArrayList<AppsDataModel>();

        for (int i = 0; i < AppsData.headerArray.length; i++) {
            data.add(new AppsDataModel(
                    AppsData.headerArray[i],
                    AppsData.sizeArray[i],
                    //AppsData.id_[i],
                    AppsData.appThumbnailUrls[i],
                    AppsData.id_[i]
            ));
        }
        ar = new ArrayList<AppsDataModel>(data.subList(0,14));
        arAge1 = new ArrayList<AppsDataModel>(data.subList(0,9));
        arAge1Sub1 = new ArrayList<AppsDataModel>(data.subList(0,5));
        arAge1Sub2 = new ArrayList<AppsDataModel>(data.subList(5,9));

        arAge2 = new ArrayList<AppsDataModel>(data.subList(9,14));
        arAge2Sub1 = new ArrayList<AppsDataModel>(data.subList(9,13));
        arAge2Sub2 = new ArrayList<AppsDataModel>(data.subList(13,14));

        vr = new ArrayList<AppsDataModel>(data.subList(14,80));

        vrAge1 = new ArrayList<AppsDataModel>(data.subList(14,27));
        vrAge1Sub1 = new ArrayList<AppsDataModel>(data.subList(14,20));
        vrAge1Sub2 = new ArrayList<AppsDataModel>(data.subList(25,27));
        vrAge1Sub3 = new ArrayList<AppsDataModel>(data.subList(20,25));

        vrAge2 = new ArrayList<AppsDataModel>(data.subList(27,41));
        vrAge2Sub1 = new ArrayList<AppsDataModel>(data.subList(27,29));
        vrAge2Sub2 = new ArrayList<AppsDataModel>(data.subList(29,39));
        vrAge2Sub3 = new ArrayList<AppsDataModel>(data.subList(39,41));

        vrAge3 = new ArrayList<AppsDataModel>(data.subList(41,73));
        vrAge3Sub1 = new ArrayList<AppsDataModel>(data.subList(41,47));
        vrAge3Sub2 = new ArrayList<AppsDataModel>(data.subList(47,49));
        vrAge3Sub3 = new ArrayList<AppsDataModel>(data.subList(68,73));
        vrAge3Sub4 = new ArrayList<AppsDataModel>(data.subList(49,68));

        vrAge4 = new ArrayList<AppsDataModel>(data.subList(73,80));
        vrAge4Sub3 = new ArrayList<AppsDataModel>(data.subList(75,80));
        vrAge4Sub1 = new ArrayList<AppsDataModel>(data.subList(73,75));
        vrAge4Sub2 = new ArrayList<AppsDataModel>(data.subList(75,80));


        final RecyclerView.Adapter adapter = new DataAdapter(getActivity().getApplicationContext(),data);
        recyclerView.setAdapter(adapter);
        recyclerView.invalidate();
        //Toast.makeText(getActivity().getApplicationContext(), "initviews entered", Toast.LENGTH_SHORT).show();
        recyclerView.addOnItemTouchListener(
                new DataAdapter(getActivity(), new   DataAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                       // recyclerView.invalidate();
                       // recyclerView.getAdapter().notifyDataSetChanged();
                        long index=recyclerView.getAdapter().getItemId(position);
                        int indexInt = (int)index;
                        //Toast.makeText(getActivity().getApplicationContext(),"At last index="+String.valueOf(index).toString(),Toast.LENGTH_SHORT).show();
                        //Log.e("@@@@@",""+position);
                        switch(indexInt){

                            case 0:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.heart.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 1:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.bloodcirculation.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 2:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.digestivesystem.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 3:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.spine.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 4:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.biogas_plant.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 5:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.thermal_power_station.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 6:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.escapistgames.starchart"));
                                startActivity(intentAppUrl);
                                break;
                            case 7:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.earth_in_solar_system.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 8:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.LunarExGames.myARgalaxySolarSystem"));
                                startActivity(intentAppUrl);
                                break;
                            case 9:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.femalerepsys.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 10:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.malerepsys.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 11:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.spermstructure.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 12:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.fetus.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 13:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.electriccircuit.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 14:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.virtualSpeech.android.language"));
                                startActivity(intentAppUrl);
                                break;
                            case 15:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.mattel.vmdestinations"));
                                startActivity(intentAppUrl);
                                break;
                            case 16:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1096173157163965/"));
                                startActivity(intentAppUrl);
                                break;
                            case 17:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.frag.vrvolcanoflythrough"));
                                startActivity(intentAppUrl);
                                break;
                            case 18:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1130312973723945/"));
                                startActivity(intentAppUrl);
                                break;
                            case 19:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.vr.expeditions"));
                                startActivity(intentAppUrl);
                                break;
                            case 20:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.discovery.DiscoveryVR"));
                                startActivity(intentAppUrl);
                                break;
                            case 21:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.Einpictures.SeaWorldVR"));
                                startActivity(intentAppUrl);
                                break;
                            case 22:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.sculfa.vroceanaquarium"));
                                startActivity(intentAppUrl);
                                break;
                            case 23:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.arloopa.zoo"));
                                startActivity(intentAppUrl);
                                break;
                            case 24:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.wrf.zoo.adventure.animal.apps"));
                                startActivity(intentAppUrl);
                                break;
                            case 25:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.AaronKnobloch.SpaceSimVR"));
                                startActivity(intentAppUrl);
                                break;
                            case 26:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.PYOPYO.StarTrackerVR"));
                                startActivity(intentAppUrl);
                                break;
                            case 27:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.azamoka.inbody_vr"));
                                startActivity(intentAppUrl);
                                break;
                            case 28:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rendernet.bacteria"));
                                startActivity(intentAppUrl);
                                break;
                            case 29:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.sculfa.vrmoonwalk3d"));
                                startActivity(intentAppUrl);
                                break;
                            case 30:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.ThomasKole.Apollo15VR"));
                                startActivity(intentAppUrl);
                                break;
                            case 31:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.onepixelsoft.solarsystemcb"));
                                startActivity(intentAppUrl);
                                break;
                            case 32:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.drashvr.titansofspacecb"));
                                startActivity(intentAppUrl);
                                break;
                            case 33:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.einpictures.SpaceWorldVR"));
                                startActivity(intentAppUrl);
                                break;
                            case 34:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.mattel.viewmasterspace"));
                                startActivity(intentAppUrl);
                                break;
                            case 35:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/886577898031804/"));
                                startActivity(intentAppUrl);
                                break;
                            case 36:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=kr.IllusicSoft.VRSpaceAdventure"));
                                startActivity(intentAppUrl);
                                break;
                            case 37:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/817920331578674/"));
                                startActivity(intentAppUrl);
                                break;
                            case 38:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=net.vrforce.vr.mars"));
                                startActivity(intentAppUrl);
                                break;
                            case 39:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1061939523887646/"));
                                startActivity(intentAppUrl);
                                break;
                            case 40:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.mattel.vmnatgeowildlife"));
                                startActivity(intentAppUrl);
                                break;
                            case 41:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1095228957166724/"));
                                startActivity(intentAppUrl);
                                break;
                            case 42:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1102239349818336/"));
                                startActivity(intentAppUrl);
                                break;
                            case 43:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/820253268102944/"));//https://www.oculus.com/experiences/gear-vr/839109046206257/

                                startActivity(intentAppUrl);
                                break;
                            case 44:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/957887340986022/"));
                                startActivity(intentAppUrl);
                                break;
                            case 45:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/908477449239883/"));
                                startActivity(intentAppUrl);
                                break;
                            case 46:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1045550998808912/"));
                                startActivity(intentAppUrl);
                                break;
                            case 47:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.virtualSpeech.android"));
                                startActivity(intentAppUrl);
                                break;
                            case 48:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1129567930394285/"));
                                startActivity(intentAppUrl);
                                break;
                            case 49:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.nivalvr.inmind"));
                                startActivity(intentAppUrl);
                                break;
                            case 50:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.nivalvr.incell"));
                                startActivity(intentAppUrl);
                                break;
                            case 51:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1249878741704255/"));
                                startActivity(intentAppUrl);
                                break;
                            case 52:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/839109046206257/"));
                                startActivity(intentAppUrl);
                                break;
                            case 53:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1192938717388849/"));
                                startActivity(intentAppUrl);
                                break;
                            case 54:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/772273116219706/"));
                                startActivity(intentAppUrl);
                                break;
                            case 55:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1015802351839289/"));
                                startActivity(intentAppUrl);
                                break;
                            case 56:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/890452791032257/"));
                                startActivity(intentAppUrl);
                                break;
                            case 57:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1037345173060965/"));
                                startActivity(intentAppUrl);
                                break;
                            case 58:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1148894061844063/"));
                                startActivity(intentAppUrl);
                                break;
                            case 59:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1533717109978548/"));
                                startActivity(intentAppUrl);
                                break;
                            case 60:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1290835750988761/"));
                                startActivity(intentAppUrl);
                                break;
                            case 61:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1039691276148629/"));
                                startActivity(intentAppUrl);
                                break;
                            case 62:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1059383670741232/"));
                                startActivity(intentAppUrl);
                                break;
                            case 63:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1096173157163965/"));
                                startActivity(intentAppUrl);
                                break;
                            case 64:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/771250866318951/"));
                                startActivity(intentAppUrl);
                                break;
                            case 65:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1084090091622343/"));
                                startActivity(intentAppUrl);
                                break;
                            case 66:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/684014421708964/"));
                                startActivity(intentAppUrl);
                                break;
                            case 67:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1073856559366835/"));
                                startActivity(intentAppUrl);
                                break;
                            case 68:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.Meritnation.PeriodicTable"));
                                startActivity(intentAppUrl);
                                break;
                            case 69:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.arloopa.chemistryvr"));
                                startActivity(intentAppUrl);
                                break;
                            case 70:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1111432215631156/"));
                                startActivity(intentAppUrl);
                                break;
                            case 71:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1327971593879954/"));
                                startActivity(intentAppUrl);
                                break;
                            case 72:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/869485659814410/"));
                                startActivity(intentAppUrl);
                                break;
                            case 73:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/1130312973723945/"));
                                startActivity(intentAppUrl);
                                break;
                            case 74:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/742896805825051/"));
                                startActivity(intentAppUrl);
                                break;
                            case 75:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.AppMinded.MoleculeVR"));
                                startActivity(intentAppUrl);
                                break;
                            case 76:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rendernet.humanmale"));
                                startActivity(intentAppUrl);
                                break;
                            case 77:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rendernet.hearing"));
                                startActivity(intentAppUrl);
                                break;
                            case 78:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rendernet.ottoengine"));
                                startActivity(intentAppUrl);
                                break;
                            case 79:
                                intentAppUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oculus.com/experiences/gear-vr/914641785316114/"));
                                startActivity(intentAppUrl);
                                break;
                            default:
                                break;


                        }
                    }
                })
        );

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
                    Toast.makeText(getActivity().getApplicationContext(), headerArraylist.get(position).toString(), Toast.LENGTH_SHORT).show();
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
    public void addItemsToSpinnerarvr() {

        ArrayList<String> arvrlist = new ArrayList<String>();
        arvrlist.add("AR");
        arvrlist.add("VR");

        final ArrayList<String> ageGrplist0 = new ArrayList<String>();
        ageGrplist0.add("Age Grp");
        ageGrplist0.add("8-12yrs");
        ageGrplist0.add("12-20yrs");

        final ArrayList<String> ageGrplist1 = new ArrayList<String>();
        ageGrplist1.add("Age Grp");
        ageGrplist1.add("4-10yrs");
        ageGrplist1.add("10-12yrs");
        ageGrplist1.add("12-15yrs");
        ageGrplist1.add("15-20yrs");



        // Custom ArrayAdapter with spinner item layout to set popup background

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getActivity().getApplicationContext(), arvrlist);
  /*
   * ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this,
   * android.R.layout.simple_spinner_item, list);
   * spinAdapter.setDropDownViewResource
   * (android.R.layout.simple_spinner_dropdown_item);
   */
        spinnerarvr.setAdapter(spinAdapter);

        spinnerarvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                if(arvrFlag==0){
                    arvrFlag++;
                }
                else {
                    String item = adapter.getItemAtPosition(position).toString();
                    switch (position) {
                        case 0:
                            spinAdaptercat = new CustomSpinnerAdapter(
                                    getActivity().getApplicationContext(), ageGrplist0);
                            spinnercat.setAdapter(spinAdaptercat);
                            RecyclerView.Adapter adapterar = new DataAdapter(getActivity().getApplicationContext(), ar);
                            recyclerView.setAdapter(adapterar);
                            //recyclerView.invalidate();
                            //Toast.makeText(getActivity().getApplicationContext(), "AR selected", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            spinAdaptercat = new CustomSpinnerAdapter(
                                    getActivity().getApplicationContext(), ageGrplist1);
                            spinnercat.setAdapter(spinAdaptercat);
                            RecyclerView.Adapter adaptervr = new DataAdapter(getActivity().getApplicationContext(), vr);
                            recyclerView.setAdapter(adaptervr);
                            //recyclerView.invalidate();
                            //Toast.makeText(getActivity().getApplicationContext(), "VR selected", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }
                }
                // Showing selected spinner item
                //Toast.makeText(getActivity().getApplicationContext(), "Selected  : " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }
    public void addItemsToSpinnercat() {
        final ArrayList<String> ageGrplist0 = new ArrayList<String>();
        ageGrplist0.add("Age Grp");
        ageGrplist0.add("8-12yrs");
        ageGrplist0.add("12-20yrs");

        final ArrayList<String> ageGrplist1 = new ArrayList<String>();
        ageGrplist1.add("Age Grp");
        ageGrplist1.add("4-10yrs");
        ageGrplist1.add("10-12yrs");
        ageGrplist1.add("12-15yrs");
        ageGrplist1.add("15-20yrs");

        final ArrayList<String> catlist0 = new ArrayList<String>();
        catlist0.add("Subject");
        catlist0.add("Biology");
        catlist0.add("Physics");

        final ArrayList<String> catlist1 = new ArrayList<String>();
        catlist1.add("Subject");
        catlist1.add("Biology");
        catlist1.add("Electrical");

        final ArrayList<String> catlist2 = new ArrayList<String>();
        catlist2.add("Subject");
        catlist2.add("English");
        catlist2.add("Physics");
        catlist2.add("General");

        final ArrayList<String> catlist3 = new ArrayList<String>();
        catlist3.add("Subject");
        catlist3.add("Biology");
        catlist3.add("Physics");
        catlist3.add("General");

        final ArrayList<String> catlist4 = new ArrayList<String>();
        catlist4.add("Subject");
        catlist4.add("Art/SocialScience");
        catlist4.add("Language");
        catlist4.add("Science");
        catlist4.add("General");

        final ArrayList<String> catlist5 = new ArrayList<String>();
        catlist5.add("Subject");
        catlist5.add("Science");
        catlist5.add("General");

        // Custom ArrayAdapter with spinner item layout to set popup background

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getActivity().getApplicationContext(), ageGrplist0);
  /*
   * ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this,
   * android.R.layout.simple_spinner_item, list);
   * spinAdapter.setDropDownViewResource
   * (android.R.layout.simple_spinner_dropdown_item);
   */
        spinnercat.setAdapter(spinAdapter);

        spinnercat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                if(ageFlag==0){
                    ageFlag++;
                }
                else {
                    // On selecting a spinner item
                    String item = adapter.getItemAtPosition(position).toString();
                    int arvr = spinnerarvr.getSelectedItemPosition();
                    if (arvr == 0) {
                        switch (position) {
                            case 0:
                                RecyclerView.Adapter adapterAgeAr0 = new DataAdapter(getActivity().getApplicationContext(), ar);
                                recyclerView.setAdapter(adapterAgeAr0);
                                break;
                            case 1:
                                spinAdaptersub = new CustomSpinnerAdapter(
                                        getActivity().getApplicationContext(), catlist0);
                                spinnersub.setAdapter(spinAdaptersub);
                                RecyclerView.Adapter adapterAge1 = new DataAdapter(getActivity().getApplicationContext(), arAge1);
                                recyclerView.setAdapter(adapterAge1);
                                break;
                            case 2:
                                spinAdaptersub = new CustomSpinnerAdapter(
                                        getActivity().getApplicationContext(), catlist1);
                                spinnersub.setAdapter(spinAdaptersub);
                                RecyclerView.Adapter adapterAge2 = new DataAdapter(getActivity().getApplicationContext(), arAge2);
                                recyclerView.setAdapter(adapterAge2);
                                break;
                            default:
                                break;
                        }
                    } else {
                        switch (position) {
                            case 0:
                                RecyclerView.Adapter adapterAgeVr0 = new DataAdapter(getActivity().getApplicationContext(), vr);
                                recyclerView.setAdapter(adapterAgeVr0);
                                break;
                            case 1:
                                spinAdaptersub = new CustomSpinnerAdapter(
                                        getActivity().getApplicationContext(), catlist2);
                                spinnersub.setAdapter(spinAdaptersub);
                                RecyclerView.Adapter adapterAge3 = new DataAdapter(getActivity().getApplicationContext(), vrAge1);
                                recyclerView.setAdapter(adapterAge3);
                                break;
                            case 2:
                                spinAdaptersub = new CustomSpinnerAdapter(
                                        getActivity().getApplicationContext(), catlist3);
                                spinnersub.setAdapter(spinAdaptersub);
                                RecyclerView.Adapter adapterAge4 = new DataAdapter(getActivity().getApplicationContext(), vrAge2);
                                recyclerView.setAdapter(adapterAge4);
                                break;
                            case 3:
                                spinAdaptersub = new CustomSpinnerAdapter(
                                        getActivity().getApplicationContext(), catlist4);
                                spinnersub.setAdapter(spinAdaptersub);
                                RecyclerView.Adapter adapterAge5 = new DataAdapter(getActivity().getApplicationContext(), vrAge3);
                                recyclerView.setAdapter(adapterAge5);
                                break;
                            case 4:
                                spinAdaptersub = new CustomSpinnerAdapter(
                                        getActivity().getApplicationContext(), catlist5);
                                spinnersub.setAdapter(spinAdaptersub);
                                RecyclerView.Adapter adapterAge6 = new DataAdapter(getActivity().getApplicationContext(), vrAge4);
                                recyclerView.setAdapter(adapterAge6);
                                break;
                            default:
                                break;
                        }
                    }
                }
                // Showing selected spinner item
                //Toast.makeText(getActivity().getApplicationContext(), "Selected  : " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    public void addItemsToSpinnersub() {

        ArrayList<String> sublist0 = new ArrayList<String>();
        sublist0.add("Subject");
        sublist0.add("Biology");
        sublist0.add("Physics");

        ArrayList<String> sublist1 = new ArrayList<String>();
        sublist1.add("Subject");
        sublist1.add("Biology");
        sublist1.add("Electrical");

        ArrayList<String> sublist2 = new ArrayList<String>();
        sublist2.add("Subject");
        sublist2.add("English");
        sublist2.add("Physics");
        sublist2.add("General");

        ArrayList<String> sublist3 = new ArrayList<String>();
        sublist3.add("Subject");
        sublist3.add("Biology");
        sublist3.add("Physics");
        sublist3.add("General");

        ArrayList<String> sublist4 = new ArrayList<String>();
        sublist4.add("Subject");
        sublist4.add("Art/SocialScience");
        sublist4.add("Language");
        sublist4.add("Science");
        sublist4.add("General");

        ArrayList<String> sublist5 = new ArrayList<String>();
        sublist5.add("Subject");
        sublist5.add("Science");
        sublist5.add("General");


        // Custom ArrayAdapter with spinner item layout to set popup background

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getActivity().getApplicationContext(), sublist0);
        spinnersub.setAdapter(spinAdapter);

        spinnersub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                if(subjectFlag==0){
                    subjectFlag++;
                }
                else {
                    // On selecting a spinner item
                    String item = adapter.getItemAtPosition(position).toString();
                    int arvr = spinnerarvr.getSelectedItemPosition();
                    int age = spinnercat.getSelectedItemPosition();
                    int sub = spinnersub.getSelectedItemPosition();
                    if (arvr == 0) {
                        if(age==0){
                            switch(sub){
                                case 0:
                                    RecyclerView.Adapter adapterAgeAr0 = new DataAdapter(getActivity().getApplicationContext(), ar);
                                    recyclerView.setAdapter(adapterAgeAr0);
                                    break;
                                case 1:
                                    RecyclerView.Adapter adapterAge1 = new DataAdapter(getActivity().getApplicationContext(), arAge1Sub1);
                                    recyclerView.setAdapter(adapterAge1);
                                    break;
                                case 2:
                                    RecyclerView.Adapter adapterAge2 = new DataAdapter(getActivity().getApplicationContext(), arAge1Sub2);
                                    recyclerView.setAdapter(adapterAge2);
                                    break;
                                default:
                                    break;
                            }
                        }
                         else if(age==1){
                            switch (position) {
                                case 0:
                                    RecyclerView.Adapter adapterAgeAr0 = new DataAdapter(getActivity().getApplicationContext(), arAge1);
                                    recyclerView.setAdapter(adapterAgeAr0);
                                    break;
                                case 1:
                                    RecyclerView.Adapter adapterAge1 = new DataAdapter(getActivity().getApplicationContext(), arAge1Sub1);
                                    recyclerView.setAdapter(adapterAge1);
                                    break;
                                case 2:
                                    RecyclerView.Adapter adapterAge2 = new DataAdapter(getActivity().getApplicationContext(), arAge1Sub2);
                                    recyclerView.setAdapter(adapterAge2);
                                    break;
                               default:
                                    break;
                            }
                        }
                        else{
                            switch (position) {
                                case 0:
                                    RecyclerView.Adapter adapterAgeAr0 = new DataAdapter(getActivity().getApplicationContext(), arAge2);
                                    recyclerView.setAdapter(adapterAgeAr0);
                                    break;
                                case 1:
                                    RecyclerView.Adapter adapterAge1 = new DataAdapter(getActivity().getApplicationContext(), arAge2Sub1);
                                    recyclerView.setAdapter(adapterAge1);
                                    break;
                                case 2:
                                    RecyclerView.Adapter adapterAge2 = new DataAdapter(getActivity().getApplicationContext(), arAge2Sub2);
                                    recyclerView.setAdapter(adapterAge2);
                                    break;
                                default:
                                    break;
                            }
                        }
                    } else {
                        switch (age) {
                            case 0: {
                                if (sub == 0) {
                                    RecyclerView.Adapter adapterAgeVr0 = new DataAdapter(getActivity().getApplicationContext(), vr);
                                    recyclerView.setAdapter(adapterAgeVr0);
                                } else if (sub == 1) {
                                    RecyclerView.Adapter adapterAgeVr1 = new DataAdapter(getActivity().getApplicationContext(), vrAge1Sub1);
                                    recyclerView.setAdapter(adapterAgeVr1);
                                } else {
                                    RecyclerView.Adapter adapterAgeVr2 = new DataAdapter(getActivity().getApplicationContext(), vrAge1Sub2);
                                    recyclerView.setAdapter(adapterAgeVr2);
                                }
                            }
                                break;
                            case 1:{
                                if (sub == 0) {
                                    RecyclerView.Adapter adapterAgeVr0 = new DataAdapter(getActivity().getApplicationContext(), vrAge1);
                                    recyclerView.setAdapter(adapterAgeVr0);
                                } else if (sub == 1) {
                                    RecyclerView.Adapter adapterAgeVr1 = new DataAdapter(getActivity().getApplicationContext(), vrAge1Sub1);
                                    recyclerView.setAdapter(adapterAgeVr1);
                                }else if (sub == 2) {
                                    RecyclerView.Adapter adapterAgeVr2 = new DataAdapter(getActivity().getApplicationContext(), vrAge1Sub2);
                                    recyclerView.setAdapter(adapterAgeVr2);
                                }
                                else {
                                    RecyclerView.Adapter adapterAgeVr3 = new DataAdapter(getActivity().getApplicationContext(), vrAge1Sub3);
                                    recyclerView.setAdapter(adapterAgeVr3);
                                }
                            }
                            break;
                            case 2:{
                                if (sub == 0) {
                                    RecyclerView.Adapter adapterAgeVr0 = new DataAdapter(getActivity().getApplicationContext(), vrAge2);
                                    recyclerView.setAdapter(adapterAgeVr0);
                                } else if (sub == 1) {
                                    RecyclerView.Adapter adapterAgeVr1 = new DataAdapter(getActivity().getApplicationContext(), vrAge2Sub1);
                                    recyclerView.setAdapter(adapterAgeVr1);
                                }else if (sub == 2) {
                                    RecyclerView.Adapter adapterAgeVr2 = new DataAdapter(getActivity().getApplicationContext(), vrAge2Sub2);
                                    recyclerView.setAdapter(adapterAgeVr2);
                                }
                                else {
                                    RecyclerView.Adapter adapterAgeVr3 = new DataAdapter(getActivity().getApplicationContext(), vrAge2Sub3);
                                    recyclerView.setAdapter(adapterAgeVr3);
                                }
                            }
                                break;
                            case 3:{
                                if (sub == 0) {
                                    RecyclerView.Adapter adapterAgeVr0 = new DataAdapter(getActivity().getApplicationContext(), vrAge3);
                                    recyclerView.setAdapter(adapterAgeVr0);
                                } else if (sub == 1) {
                                    RecyclerView.Adapter adapterAgeVr1 = new DataAdapter(getActivity().getApplicationContext(), vrAge3Sub1);
                                    recyclerView.setAdapter(adapterAgeVr1);
                                }else if (sub == 2) {
                                    RecyclerView.Adapter adapterAgeVr2 = new DataAdapter(getActivity().getApplicationContext(), vrAge3Sub2);
                                    recyclerView.setAdapter(adapterAgeVr2);
                                }else if (sub == 3) {
                                    RecyclerView.Adapter adapterAgeVr3 = new DataAdapter(getActivity().getApplicationContext(), vrAge3Sub3);
                                    recyclerView.setAdapter(adapterAgeVr3);
                                }
                                else {
                                    RecyclerView.Adapter adapterAgeVr4 = new DataAdapter(getActivity().getApplicationContext(), vrAge3Sub4);
                                    recyclerView.setAdapter(adapterAgeVr4);
                                }
                            }
                                break;
                            case 4: {
                                if (sub == 0) {
                                    RecyclerView.Adapter adapterAgeVr0 = new DataAdapter(getActivity().getApplicationContext(), vrAge4);
                                    recyclerView.setAdapter(adapterAgeVr0);
                                } else if(sub == 1) {
                                    RecyclerView.Adapter adapterAgeVr1 = new DataAdapter(getActivity().getApplicationContext(), vrAge4Sub2);
                                    recyclerView.setAdapter(adapterAgeVr1);
                                } else{
                                    RecyclerView.Adapter adapterAgeVr2 = new DataAdapter(getActivity().getApplicationContext(), vrAge4Sub1);
                                    recyclerView.setAdapter(adapterAgeVr2);
                                }
                            }
                                break;
                            default:
                                break;
                        }
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

}
