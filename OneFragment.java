package com.vrplayerapp.in;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;
import android.widget.Switch;
import android.widget.Toast;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

/**
 * Created by Admin on 07-02-2017.
 */

public class OneFragment extends Fragment {
    private Spinner spinnercat,spinnersub;
    private GridView gridview;
    // Store instance variables
    private String title;
    private int page;
    CustomSpinnerAdapter spinAdaptersub;
    private  int mImageArray=0;
    ImageAdapter imageAdapter;
    Intent intentYoutube;
    private SearchView searchView;
    MenuItem myActionMenuItem;
    private String grid_currentQuery = null; // holds the current query..
    int searchFlag=0;
    //ListView lv;
    SearchView sv;
    //String[] names={"Juan Mata","Ander Herera","Wayne Rooney","Eden Hazard","Michael Carrick","Diego Costa","Jose Mourinho"};
    //int[] images={R.drawable.acrossouruniverse,R.drawable.alzheimersdisease,R.drawable.arttoday,R.drawable.alamo,R.drawable.africanelephant,R.drawable.activevolcano,R.drawable.amsterdam};
    String[] names={
            "letter a", "letter b",
           "letter c", "letter d",
            "letter e", "learn to count",
            "train ride", "five little monkeys",
            "wheels on the bus", "whoopies wonder world",
            "peppa pig living room", "peppa pig look inside",
            "sports balls", "street vehicles",
            "small animals", "big animals",
            "shark puppies", "owl story telling",
            "learn colors", "play house",
            "eye of the tiger", "wild dolphins",
            "african zoo", "feeding giraffes",
            "cincinnati zoo", "lemurs",
            "elephants hippos boat safari", "wild mountain gorilla",
            "horse jump", "kelp diving exploration",
            "white sharks", "playful elephants",
            "lions last stand", "whale sharks",
            "surviving shark attack", "caring rhinos",
            "flying on the edge manta ray fish", "crab life",
            "tanzania wildlife",
            "pigeon art", "wood art",
            "arts festival magic gallery", "art today",
            "glass bubbles blowing", "neon museum works",
            "rain forest", "paris",
            "amsterdam", "newyork",
            "camel tour", "swing among trees jungle canopy",
            "my earth", "egg hatching incubator",
            "flying with swans", "talking shop",
            "follow gold", "mr happy magnet",
            "collider",
            "gorillas in congo", "farm sanctuary",
            "dinosaur", "grizzly bears",
            "sharks everywhere", "shark expt experiment",
            "anchor species", "great whites",
            "tajmahal", "india gate",
            "great wall", "eiffel tower",
            "buckingham palace", "amazon rain forest",
            "train ride longest tunnel", "british museum",
            "sydney harbour", "guys on deck",
            "newyork harbour", "pacific sunset",
            "through rain forest jungles", "red woods",
            "lake austin", "around austin secret waterfall",
            "texas bridge caverns", "last alaskans refugee life",
            "space gallery", "total solar eclipse",
            "explore solar system",
            "virtual plant cell", "inside human body",
            "plant energy biology lab", "red kite bird",
            "explore sets",
            "threatened species", "african elephant",
            "bear attack", "wild elephants",
            "white sharks", "cell tour",
            "boxing injuries", "endocrine cells",
            "inside human body1", "great barrier reef",
            "cellular activity", "resilient forest 1",
            "resilient forest 2", "gravity disobeyed",
            "art gallery", "himalayas",
            "independence day", "civil war",
            "alamo", "gold mining",
            "dredge tour", "reclamation post mining",
            "mining tailings", "mining sluice box",
            "jupiter and moons", "inside venus",
            "space walk", "ge health care",
            "ge gas turbine factory", "submersible drone",
            "printing press", "microcosmic journey",
            "survival", "ireland tour",
            "takeoff dangerous airport", "helicopter",
            "shipwreck", "m5 warehouse",
            "italy",
            "nemomatic treasure from trash", "active volcano",
            "meteor crater", "syria before war",
            "gold prospecting", "gold wash plant",
            "milky way galaxy2", "walk on the moon",
            "alzheimers disease", "molecular biology",
            "molecular ecology", "vacuum car lift",
            "interior design", "city villa",
            "architecture", "desining innovation",
            "evolved design", "cockpit view",
            "rocket launch", "thermal power plant",
            "inside a fusion reactor", "plant energy accelerator",
            "renewable energy", "global research",
            "ge locomotive", "robotics 3d",
            "journey to the earth edge", "survivor man",
            "cruise ship tour", "trek through himalayas",
            "ride in venice", "ireland cliffs",
            "canyan swing", //R.drawable.freeboarding,
            "swamp rules", "office view",
            "paragliding"
    };
    int[] images = {
            R.drawable.lettera, R.drawable.letterb,
            R.drawable.letterc, R.drawable.letterd,
            R.drawable.lettere, R.drawable.learntocountwithrex,
            R.drawable.trainride, R.drawable.fivelittlemonkeys,
            R.drawable.wheelsonthebus, R.drawable.whoopieswonderworld,
            R.drawable.peppapiglivingroom, R.drawable.lookinside,
            R.drawable.surpriseeggs, R.drawable.streetvehicles,
            R.drawable.smallanimals, R.drawable.meetbiganimals,
            R.drawable.sharkpuppies, R.drawable.owlstorytelling,
            R.drawable.learncolors, R.drawable.ponystable,
            R.drawable.tigereye, R.drawable.wilddolphins,
            R.drawable.africanzoo, R.drawable.feedinggiraffes,
            R.drawable.cincinnati, R.drawable.lemors,
            R.drawable.elephantshippos, R.drawable.mountaingorilla,
            R.drawable.horsejump, R.drawable.divingexploration,
            R.drawable.whitesharks, R.drawable.playfulelephants,
            R.drawable.lionslaststand, R.drawable.whalesharks,
            R.drawable.survivingsharks, R.drawable.caringrhinos,
            R.drawable.flyingontheedge, R.drawable.crablife,
            R.drawable.wildlife,
            R.drawable.pigeonart, R.drawable.woodart,
            R.drawable.artsmagicgallery, R.drawable.arttoday,
            R.drawable.glassblowing, R.drawable.neonworks,
            R.drawable.rainforest, R.drawable.paris,
            R.drawable.amsterdam, R.drawable.newyork,
            R.drawable.cameltour, R.drawable.swingamongtrees,
            R.drawable.myearth, R.drawable.egghatching,
            R.drawable.flyingwithswans, R.drawable.talkingshop,
            R.drawable.followgold, R.drawable.happymagnet,
            R.drawable.collider,
            R.drawable.gorillasincongo, R.drawable.farmsanctuary,
            R.drawable.dinosaur, R.drawable.grizzlybears,
            R.drawable.sharkseverywhere, R.drawable.sharkexperiment,
            R.drawable.anchorspecies, R.drawable.greatwhites,
            R.drawable.tajmahal, R.drawable.indiagate,
            R.drawable.greatwall, R.drawable.eifeltower,
            R.drawable.buckinghampalace, R.drawable.amazonrainforest,
            R.drawable.trainridetunnel, R.drawable.britishmuseum,
            R.drawable.sydneyharbour, R.drawable.guysondeck,
            R.drawable.harbour, R.drawable.pacificsunset,
            R.drawable.throughrainforest, R.drawable.redwoods,
            R.drawable.lakeaustin, R.drawable.secretswaterfall,
            R.drawable.texasbridgecaverns, R.drawable.refugeelife,
            R.drawable.spacegallery, R.drawable.totalssolareclipse,
            R.drawable.exploresolarsystem,
            R.drawable.virtualplantcell, R.drawable.insidehumanbody,
            R.drawable.plantenergylab, R.drawable.redkitebird,
            R.drawable.exploresets,
            R.drawable.threatenedspecies, R.drawable.africanelephant,
            R.drawable.bearattack, R.drawable.wildelephants,
            R.drawable.whitesharks, R.drawable.celltour,
            R.drawable.boxinginjuries, R.drawable.endocrinecells,
            R.drawable.insidehumanbody1, R.drawable.greatbarrierreef,
            R.drawable.cellularactivity, R.drawable.resilientforestpart1,
            R.drawable.resilientforestpart2, R.drawable.gravity,
            R.drawable.artgallery, R.drawable.himalayas,
            R.drawable.independenceday, R.drawable.civilwar,
            R.drawable.alamo, R.drawable.goldmine,
            R.drawable.dredgetour, R.drawable.reclamation,
            R.drawable.tailings, R.drawable.sluicebox,
            R.drawable.jupiterandmoons, R.drawable.insidevenus,
            R.drawable.spacewalk, R.drawable.healthcare,
            R.drawable.turbinefactory, R.drawable.submersibledrone,
            R.drawable.presses, R.drawable.microcosmicjourney,
            R.drawable.survival, R.drawable.irelandtour,
            R.drawable.takeoffairport, R.drawable.helicopter,
            R.drawable.shipwreck, R.drawable.m5warehouse,
            R.drawable.italy,
            R.drawable.nemomatic, R.drawable.activevolcano,
            R.drawable.meteorcrater, R.drawable.syriabeforewar,
            R.drawable.goldprospecting, R.drawable.goldwashplant,
            R.drawable.milkywaygalaxy2, R.drawable.moonwalk,
            R.drawable.alzheimersdisease, R.drawable.molecularbiology,
            R.drawable.molecularecology, R.drawable.vacuumcarlift,
            R.drawable.interiordesign, R.drawable.cityvilla,
            R.drawable.architecture, R.drawable.desininginnovation,
            R.drawable.evolveddesign, R.drawable.cockpitview,
            R.drawable.rocketlaunch, R.drawable.thermalplant,
            R.drawable.fusionreactor, R.drawable.plantenergy,
            R.drawable.renewableenergy, R.drawable.globalresearch,
            R.drawable.locomotivege, R.drawable.robotics3d,
            R.drawable.earthedge, R.drawable.survivorman,
            R.drawable.cruiseshiptour, R.drawable.himalayantrek,
            R.drawable.rideinvenice, R.drawable.irelandcliffs,
            R.drawable.canyanswing, //R.drawable.freeboarding,
            R.drawable.swamprules, R.drawable.officeview,
            R.drawable.paragliding
    };
    // newInstance constructor for creating fragment with arguments
    public static OneFragment newInstance(int page, String title) {
        OneFragment fragmentFirst = new OneFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }



    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);

       // Toast.makeText(getActivity().getBaseContext(),"Oncreate",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate( R.menu.menu_main, menu);
        final SearchAdapter adapter=new SearchAdapter(getActivity().getApplicationContext(), getVideos());

         gridview.setAdapter(adapter);
        //gridview.setAdapter(new SearchAdapter(getActivity().getApplicationContext()));
        //gridview.setVerticalScrollBarEnabled(false);
        myActionMenuItem = menu.findItem( R.id.action_search);
        searchView = (SearchView) myActionMenuItem.getActionView();
       /* searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                // Toast like print
                //UserFeedback.show( "SearchOnQueryTextSubmit: " + query);
                //Toast.makeText(getActivity().getApplicationContext(), "SearchOnQueryTextSubmit: " + query, Toast.LENGTH_LONG).show();
                if( ! searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
               // adapter.getFilter().filter(s);
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
              // Toast.makeText(getActivity().getApplicationContext(),  "SearchOnQueryTextChanged: " + s, Toast.LENGTH_LONG).show();
                return false;
            }
        });*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            searchFlag=1;
            final SearchAdapter adapter=new SearchAdapter(getActivity().getApplicationContext(), getVideos());

            gridview.setAdapter(adapter);
            //gridview.setAdapter(new SearchAdapter(getActivity().getApplicationContext()));
            //gridview.setVerticalScrollBarEnabled(false);
            //myActionMenuItem = ( R.id.action_search);
            searchView = (SearchView) myActionMenuItem.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    adapter.getFilter().filter(query);
                    // Toast like print
                    //UserFeedback.show( "SearchOnQueryTextSubmit: " + query);
                    //Toast.makeText(getActivity().getApplicationContext(), "SearchOnQueryTextSubmit: " + query, Toast.LENGTH_LONG).show();
                    if( ! searchView.isIconified()) {
                        searchView.setIconified(true);
                    }
                    myActionMenuItem.collapseActionView();
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String s) {
                    // adapter.getFilter().filter(s);
                    // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                    // Toast.makeText(getActivity().getApplicationContext(),  "SearchOnQueryTextChanged: " + s, Toast.LENGTH_LONG).show();
                    return false;
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    final private SearchView.OnQueryTextListener queryListener = new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextChange(String newText) {
            if (TextUtils.isEmpty(newText)) {
                getActivity().getActionBar().setSubtitle("List");
                grid_currentQuery = null;
            } else {
                getActivity().getActionBar().setSubtitle("List - Searching for: " + newText);
                grid_currentQuery = newText;

            }
            getLoaderManager().restartLoader(0, null, this);
            return false;
        }


        @Override
        public boolean onQueryTextSubmit(String query) {
            Toast.makeText(getActivity(), "Searching for: " + query + "...", Toast.LENGTH_SHORT).show();
            return false;
        }
    };*/

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
       /* switch (item.getItemId()) {
            case R.id.action_search:

                //       onCall();   //your logic
                Toast.makeText(getActivity().getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
        /*menu.clear();
        inflater.inflate(R.menu.search_option_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(((ActionBarActivity)getActivity()).getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                          }
                                      }
        );
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Toast.makeText(getActivity().getApplicationContext(),"MainActivity...oncreateview...onefragent", Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_one, container, false);
        //lv=(ListView) findViewById(R.id.listView1);
        //sv=(SearchView) findViewById(R.id.searchView1);
        //ADASPTER
       // final SearchAdapter adapter=new SearchAdapter(getActivity().getApplicationContext(), getVideos());
        //gridview.setAdapter(adapter);

        spinnercat = (Spinner) view.findViewById(R.id.spinner_cat);
        spinnersub = (Spinner) view.findViewById(R.id.spinner_sub);
        addItemsToSpinnercat();
        addItemsToSpinnersub();
        spinnercat.setSelection(0);
        spinnersub.setSelection(0);
        //page = getArguments().getInt("someInt", 0);
        //title = getArguments().getString("someTitle");
        gridview = (GridView) view.findViewById(R.id.gridview);
       // gridview.setAdapter(adapter);
        imageAdapter= new ImageAdapter(getActivity().getApplicationContext(),mImageArray);
        gridview.setAdapter(imageAdapter);
       // gridview.setAdapter(new ImageAdapter(getActivity().getApplicationContext(),mImageArray));
        gridview.setVerticalScrollBarEnabled(false);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // Toast.makeText(this, "" + position,Toast.LENGTH_SHORT).show();
                int selCat = spinnercat.getSelectedItemPosition();
                int selSub = spinnersub.getSelectedItemPosition();
                //SearchAdapter i = (SearchAdapter)parent.getAdapter();
                ImageView image = (ImageView) gridview.getChildAt(position);
                int temp=0;
               // Toast.makeText(getActivity().getApplicationContext(),"drawable int value..."+(String.valueOf(R.drawable.acrossouruniverse)),Toast.LENGTH_LONG).show();
               // Toast.makeText(getActivity().getApplicationContext(),"image gettag..."+(String.valueOf(image.getTag())),Toast.LENGTH_LONG).show();
               // Toast.makeText(getActivity().getApplicationContext(),"parent.getid..."+(String.valueOf(parent.getId())),Toast.LENGTH_LONG).show();
               // Toast.makeText(getActivity().getApplicationContext(),"image getid..."+(String.valueOf(image.getId())),Toast.LENGTH_LONG).show();
               /* for(int ii=0;ii<((SearchAdapter) parent.getAdapter()).urlIndex.length;ii++)
                {
                    temp=((SearchAdapter) parent.getAdapter()).urlIndex[ii];
                    Toast.makeText(getActivity().getApplicationContext(),String.valueOf(temp),Toast.LENGTH_SHORT).show();
                }*/
                //Drawable mydrawable = getResources().getDrawable(R.drawable.acrossouruniverse);

                // if(image.getId()== (Integer)getResources().getDrawable(R.drawable.acrossouruniverse){
                //i.getItemId(position)
                //Toast.makeText(getActivity().getApplicationContext(), "" + String.valueOf(i.getItemId(position)).toString(), Toast.LENGTH_SHORT).show();
                //gridview.getSelectedItem().
                //String imageName = gridview.getSelectedItem().toString();
                //Toast.makeText(getActivity().getApplicationContext(), "imageName=" + imageName,Toast.LENGTH_SHORT).show();

               /* if((Integer)(image.getTag())==R.drawable.acrossouruniverse){//(getResources().getIdentifier("acrossouruniverse", "drawable", getActivity().getPackageName()))){ //R.drawable.acrossouruniverse){
                    //do work here
                    Toast.makeText(getActivity().getApplicationContext(),"Acrossuniverse clicked :-)",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),"Did not match..."+(String.valueOf(R.drawable.acrossouruniverse)+"tag="+(String.valueOf(image.getTag()))),Toast.LENGTH_LONG).show();
                }*/


                if(searchFlag==0) {
                   if ((selCat == 0) && (selSub == 0)) {
                       switch (position) {
                        /*Intent intentYoutubeFS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=-FyN5_-njAU&t=7s&autoplay=0"));
                            intentYoutubeFS.putExtra("force_fullscreen", true);
                            intentYoutubeFS.putExtra("finish_on_ended", true);
                            startActivity(intentYoutubeFS);*/
                        /*R.drawable.lettera, R.drawable.letterb,
            R.drawable.letterc, R.drawable.letterd,
            R.drawable.lettere, R.drawable.learntocountwithrex,
            R.drawable.trainride, R.drawable.fivelittlemonkeys,
            R.drawable.wheelsonthebus, R.drawable.whoopieswonderworld,
            R.drawable.peppapiglivingroom, R.drawable.lookinside,
            R.drawable.surpriseeggs, R.drawable.streetvehicles,
            R.drawable.smallanimals, R.drawable.meetbiganimals,
            R.drawable.sharkpuppies, R.drawable.owlstorytelling,
            R.drawable.learncolors, R.drawable.ponystable,
            R.drawable.tigereye, R.drawable.wilddolphins,
            R.drawable.africanzoo, R.drawable.feedinggiraffes,
            R.drawable.cincinnati, R.drawable.lemors,
            R.drawable.elephantshippos, R.drawable.mountaingorilla,
            R.drawable.horsejump, R.drawable.divingexploration,
            R.drawable.whitesharks, R.drawable.playfulelephants,
            R.drawable.lionslaststand, R.drawable.whalesharks,
            R.drawable.survivingsharks, R.drawable.caringrhinos,
            R.drawable.flyingontheedge, R.drawable.crablife,
            R.drawable.wildlife,
            R.drawable.pigeonart, R.drawable.woodart,
            R.drawable.artsmagicgallery, R.drawable.arttoday,
            R.drawable.glassblowing, R.drawable.neonworks,
            R.drawable.rainforest, R.drawable.paris,
            R.drawable.amsterdam, R.drawable.newyork,
            R.drawable.cameltour, R.drawable.swingamongtrees,
            R.drawable.myearth, R.drawable.egghatching,
            R.drawable.flyingwithswans, R.drawable.talkingshop,
            R.drawable.followgold, R.drawable.happymagnet,
            R.drawable.collider,
            R.drawable.gorillasincongo, R.drawable.farmsanctuary,
            R.drawable.dinosaur, R.drawable.grizzlybears,
            R.drawable.sharkseverywhere, R.drawable.sharkexperiment,
            R.drawable.anchorspecies, R.drawable.greatwhites,
            R.drawable.tajmahal, R.drawable.indiagate,
            R.drawable.greatwall, R.drawable.eifeltower,
            R.drawable.buckinghampalace, R.drawable.amazonrainforest,
            R.drawable.trainridetunnel, R.drawable.britishmuseum,
            R.drawable.sydneyharbour, R.drawable.guysondeck,
            R.drawable.harbour, R.drawable.pacificsunset,
            R.drawable.throughrainforest, R.drawable.redwoods,
            R.drawable.lakeaustin, R.drawable.secretswaterfall,
            R.drawable.texasbridgecaverns, R.drawable.refugeelife,
            R.drawable.spacegallery, R.drawable.totalssolareclipse,
            R.drawable.exploresolarsystem,
            R.drawable.virtualplantcell, R.drawable.insidehumanbody,
            R.drawable.plantenergylab, R.drawable.redkitebird,
            R.drawable.exploresets,
            R.drawable.threatenedspecies, R.drawable.africanelephant,
            R.drawable.bearattack, R.drawable.wildelephants,
            R.drawable.whitesharks, R.drawable.celltour,
            R.drawable.boxinginjuries, R.drawable.endocrinecells,
            R.drawable.insidehumanbody1, R.drawable.greatbarrierreef,
            R.drawable.cellularactivity, R.drawable.resilientforestpart1,
            R.drawable.resilientforestpart2, R.drawable.gravity,
            R.drawable.artgallery, R.drawable.himalayas,
            R.drawable.independenceday, R.drawable.civilwar,
            R.drawable.alamo, R.drawable.goldmine,
            R.drawable.dredgetour, R.drawable.reclamation,
            R.drawable.tailings, R.drawable.sluicebox,
            R.drawable.jupiterandmoons, R.drawable.insidevenus,
            R.drawable.spacewalk, R.drawable.healthcare,
            R.drawable.turbinefactory, R.drawable.submersibledrone,
            R.drawable.presses, R.drawable.microcosmicjourney,
            R.drawable.survival, R.drawable.irelandtour,
            R.drawable.takeoffairport, R.drawable.helicopter,
            R.drawable.shipwreck, R.drawable.m5warehouse,
            R.drawable.italy,
            R.drawable.nemomatic, R.drawable.activevolcano,
            R.drawable.meteorcrater, R.drawable.syriabeforewar,
            R.drawable.goldprospecting, R.drawable.goldwashplant,
            R.drawable.milkywaygalaxy2, R.drawable.moonwalk,
            R.drawable.alzheimersdisease, R.drawable.molecularbiology,
            R.drawable.molecularecology, R.drawable.vacuumcarlift,
            R.drawable.interiordesign, R.drawable.cityvilla,
            R.drawable.architecture, R.drawable.desininginnovation,
            R.drawable.evolveddesign, R.drawable.cockpitview,
            R.drawable.rocketlaunch, R.drawable.thermalplant,
            R.drawable.fusionreactor, R.drawable.plantenergy,
            R.drawable.renewableenergy, R.drawable.globalresearch,
            R.drawable.locomotivege, R.drawable.robotics3d,
            R.drawable.earthedge, R.drawable.survivorman,
            R.drawable.cruiseshiptour, R.drawable.himalayantrek,
            R.drawable.rideinvenice, R.drawable.irelandcliffs,
            R.drawable.canyanswing, //R.drawable.freeboarding,
            R.drawable.swamprules, R.drawable.officeview,
            R.drawable.paragliding*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/MvGymoT35aA?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/j-aPqU9DN5w?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/T4h6SQPlrAo?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/XggLgtJGNZY?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/i7R-5HLI_B0"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Lvz5UE5sz3s"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.trainride, R.drawable.fivelittlemonkeys,
            R.drawable.wheelsonthebus, R.drawable.whoopieswonderworld,
            R.drawable.peppapiglivingroom, R.drawable.lookinside,
            R.drawable.surpriseeggs, R.drawable.streetvehicles*/
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rWSKPgFAPmQ"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zGaCNcgYtwY"));
                               startActivity(intentYoutube);
                               break;
                           case 8:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/4SkU2II19G8"));
                               startActivity(intentYoutube);
                               break;
                           case 9:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-E7HIlgLGmg"));
                               startActivity(intentYoutube);
                               break;
                           case 10:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/gecEMTXfgJg"));
                               startActivity(intentYoutube);
                               break;
                           case 11:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/TVilDuNBcHM"));
                               startActivity(intentYoutube);
                               break;
                           case 12:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Y_i-kVCBgcg"));
                               startActivity(intentYoutube);
                               break;
                           case 13:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/K8eZkTfx9Vw?list=PLt6M1oQvo0nhAmcHNFKM73dqTVOcDg-Vg"));
                               startActivity(intentYoutube);
                               break;
                        /*  R.drawable.smallanimals, R.drawable.meetbiganimals,
            R.drawable.sharkpuppies, R.drawable.owlstorytelling,
            R.drawable.learncolors, R.drawable.ponystable*/
                           case 14:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pB8Ew3MgGW8"));
                               startActivity(intentYoutube);
                               break;
                           case 15:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VRjpO5GJAVc"));
                               startActivity(intentYoutube);
                               break;
                           case 16:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yCNmS5rZV54?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 17:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vhZZSGL2PP8?list=PLusRCtpGoSmtyb_7QFeIPZM9E4b5nOdF2"));
                               startActivity(intentYoutube);
                               break;
                           case 18:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/lAGEwpJgsJc"));
                               startActivity(intentYoutube);
                               break;
                           case 19:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/MWg1kjMmr3k?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /*  R.drawable.tigereye, R.drawable.wilddolphins,
                                            R.drawable.africanzoo, R.drawable.feedinggiraffes,
                                            R.drawable.cincinnati, R.drawable.lemors,
                                            R.drawable.elephantshippos, R.drawable.mountaingorilla,
                                            R.drawable.horsejump, R.drawable.divingexploration,
                                            R.drawable.whitesharks, R.drawable.playfulelephants,
                                            R.drawable.lionslaststand, R.drawable.whalesharks,
                                            R.drawable.survivingsharks, R.drawable.caringrhinos,
                                            R.drawable.flyingontheedge, R.drawable.crablife,
                                            R.drawable.wildlife*/
                           case 20:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xal78egELos"));
                               startActivity(intentYoutube);
                               break;
                           case 21:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BbT_e8lWWdo"));
                               startActivity(intentYoutube);
                               break;
                           case 22:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xq_jkzTuQwQ"));
                               startActivity(intentYoutube);
                               break;
                           case 23:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Bf8mZQRTJ5I"));
                               startActivity(intentYoutube);
                               break;
                           case 24:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/qlNa9qYxmG4"));
                               startActivity(intentYoutube);
                               break;
                           case 25:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Xb84aJg4DbE"));
                               startActivity(intentYoutube);
                               break;
                           case 26:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/r4QisBVtRgQ"));
                               startActivity(intentYoutube);
                               break;
                           case 27:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PusRw0HDfL0"));
                               startActivity(intentYoutube);
                               break;
                           case 28:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BXBsYm-dnYU"));
                               startActivity(intentYoutube);
                               break;
                           case 29:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kJv0eYQp1lo?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 30:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HNOT_feL27Y?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 31:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/a_XIZHXRw4I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 32:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/mymJJtH0X3w?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 33:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/IDDW3gAcySk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 34:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WZEJ7TZcG1I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 35:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/7IWp875pCxQ?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 36:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/L9-pO_aCCHU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 37:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6WHrZjODOaY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 38:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/spFZDkudhgc"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.pigeonart, R.drawable.woodart,
                                                R.drawable.artsmagicgallery, R.drawable.arttoday,
                                                R.drawable.glassblowing, R.drawable.neonworks*/
                           case 39:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/v9wWuKbnvyc"));
                               startActivity(intentYoutube);
                               break;
                           case 40:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/GB9DGyK6cHs"));
                               startActivity(intentYoutube);
                               break;
                           case 41:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0oc3w04fdaE"));
                               startActivity(intentYoutube);
                               break;
                           case 42:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AHrR6YP84ds?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 43:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/eYrLogOlgfI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 44:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PED18kzRcDE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.rainforest, R.drawable.paris,
                                                R.drawable.amsterdam, R.drawable.newyork,
                                                R.drawable.cameltour, R.drawable.swingamongtrees*/
                           case 45:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iPwlNh48eYk"));
                               startActivity(intentYoutube);
                               break;
                           case 46:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Tph_ntIJQxk"));
                               startActivity(intentYoutube);
                               break;
                           case 47:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FzrkpXlRP1M"));
                               startActivity(intentYoutube);
                               break;
                           case 48:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/f0-89v4Fk-M"));
                               startActivity(intentYoutube);
                               break;
                           case 49:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/LltbuEts1BE"));
                               startActivity(intentYoutube);
                               break;
                           case 50:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WUNvmTtmDvo?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.myearth, R.drawable.egghatching,
                                                        R.drawable.flyingwithswans, R.drawable.talkingshop,
                                                        R.drawable.followgold, R.drawable.happymagnet,
                                                        R.drawable.collider*/
                           case 51:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/o_rIAd1qMx0"));
                               startActivity(intentYoutube);
                               break;
                           case 52:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pDjGdTopAE0"));
                               startActivity(intentYoutube);
                               break;
                           case 53:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pXBDMyjBJRY?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 54:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sL8m72GAyNI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 55:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3l9ZvOd-Qvw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 56:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/giINIyBirAk"));
                               startActivity(intentYoutube);
                               break;
                           case 57:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/d_OeQxoKocU"));
                               startActivity(intentYoutube);
                               break;
                        /*  R.drawable.gorillasincongo, R.drawable.farmsanctuary,
                                                    R.drawable.dinosaur, R.drawable.grizzlybears,
                                                    R.drawable.sharkseverywhere, R.drawable.sharkexperiment,
                                                    R.drawable.anchorspecies, R.drawable.greatwhites*/
                           case 58:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/LMomKIt1uWA?list=PL6J03K740wkJx7mNNfg-j9ZhX20toNzCk"));
                               startActivity(intentYoutube);
                               break;
                           case 59:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-xfGkgU9T2A"));
                               startActivity(intentYoutube);
                               break;
                           case 60:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rfh-64s5va4?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 61:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/va1AmV24VSs"));
                               startActivity(intentYoutube);
                               break;
                           case 62:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3WIS6N_9gjA?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 63:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/g_WZncx-Baw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 64:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HWwaRcLqnU8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 65:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/eayh49rTZUM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /*  R.drawable.tajmahal, R.drawable.indiagate,
                                            R.drawable.greatwall, R.drawable.eifeltower,
                                            R.drawable.buckinghampalace, R.drawable.amazonrainforest,
                                            R.drawable.trainridetunnel, R.drawable.britishmuseum,
                                            R.drawable.sydneyharbour, R.drawable.guysondeck,
                                            R.drawable.harbour, R.drawable.pacificsunset,
                                            R.drawable.throughrainforest, R.drawable.redwoods,
                                            R.drawable.lakeaustin, R.drawable.secretswaterfall,
                                            R.drawable.texasbridgecaverns, R.drawable.refugeelife*/
                           case 66:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aFx_fER0EpU"));
                               startActivity(intentYoutube);
                               break;
                           case 67:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xsQ8eros35I"));
                               startActivity(intentYoutube);
                               break;
                           case 68:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/n1fZe-Oqs14?list=PLmJ34zyhdBjG61yeDaLmDiKwqpfUtpJUj"));
                               startActivity(intentYoutube);
                               break;
                           case 69:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sJxiPiAaB4k"));
                               startActivity(intentYoutube);
                               break;
                           case 70:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9MeqUPkVg2U"));
                               startActivity(intentYoutube);
                               break;
                           case 71:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/em3tQoespWI"));
                               startActivity(intentYoutube);
                               break;
                           case 72:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/lRyYm9AlF9c"));
                               startActivity(intentYoutube);
                               break;
                           case 73:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/04I0UCVnMmQ"));
                               startActivity(intentYoutube);
                               break;
                           case 74:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aq9nXIVTkug"));
                               startActivity(intentYoutube);
                               break;
                           case 75:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VpCO0tgyMXE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 76:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/4-UmBQ9szaU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 77:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ka3qzz-oa-A?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 78:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CR5IZRAqUzs?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 79:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/DTlzIGFrL_4?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 80:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zv4wUhfSqVE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 81:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/QL6MF8Kw32c?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 82:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/YKC4YNXUE8U?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 83:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kER8zKrgM8c?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.spacegallery, R.drawable.milkywaygalaxy,
                                                        R.drawable.totalssolareclipse, R.drawable.exploresolarsystem,
                                                        R.drawable.virtualplantcell, R.drawable.insidehumanbody2,
                                                        R.drawable.plantenergylab, R.drawable.redkitebird,
                                                        R.drawable.exploresets*/
                           case 84:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9kMEKmlWnf8"));
                               startActivity(intentYoutube);
                               break;
                           case 85:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xAuVs9_o9RY"));
                               startActivity(intentYoutube);
                               break;
                           case 86:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0ytyMKa8aps"));
                               startActivity(intentYoutube);
                               break;
                           case 87:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ZUPBtpm_XXI"));
                               startActivity(intentYoutube);
                               break;
                           case 88:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-FyN5_-njAU"));
                               startActivity(intentYoutube);
                               break;
                           case 89:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/OVOufYJnCgg?list=PLTereL9KWtx-uFrwHzLJZLlDEbJiG10l8"));
                               startActivity(intentYoutube);
                               break;
                           case 90:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PiSOVGZjous?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 91:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6o9mFOyqoUM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.threatenedspecies, R.drawable.africanelephant,
                                                    R.drawable.bearattack, R.drawable.wildelephants,
                                                    R.drawable.greatshark, R.drawable.celltour,
                                                    R.drawable.boxinginjuries, R.drawable.endocrinecells,
                                                    R.drawable.insidehumanbody, R.drawable.greatbarrierreef,
                                                    R.drawable.cellularactivity, R.drawable.resilientforestpart1,
                                                    R.drawable.resilientforestpart2, R.drawable.gravity*/
                           case 92:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/T-aOVE22lEw"));
                               startActivity(intentYoutube);
                               break;
                           case 93:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/2bpICIClAIg"));
                               startActivity(intentYoutube);
                               break;
                           case 94:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/g7btxyIbQQ0"));
                               startActivity(intentYoutube);
                               break;
                           case 95:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/mlOiXMvMaZo"));
                               startActivity(intentYoutube);
                               break;
                           case 96:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HNOT_feL27Y"));
                               startActivity(intentYoutube);
                               break;
                           case 97:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rKS-vvhMV6E"));
                               startActivity(intentYoutube);
                               break;
                           case 98:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FGsZf0BFHLU"));
                               startActivity(intentYoutube);
                               break;
                           case 99:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/IOK2fNXjDUU"));
                               startActivity(intentYoutube);
                               break;
                           case 100:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/uC0qdqk6INQ"));
                               startActivity(intentYoutube);
                               break;
                           case 101:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iBTArmgdBpI?list=PL6J03K740wkJx7mNNfg-j9ZhX20toNzCk"));
                               startActivity(intentYoutube);
                               break;
                           case 102:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8VUCEbNNKzI"));
                               startActivity(intentYoutube);
                               break;
                           case 103:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aAH40URLxkg"));
                               startActivity(intentYoutube);
                               break;
                           case 104:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AD-Lfk3LRh8"));
                               startActivity(intentYoutube);
                               break;
                           case 105:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VZK02CW7oy4"));
                               startActivity(intentYoutube);
                               break;
                        /*R.drawable.artgallery, R.drawable.himalayas,
                                                    R.drawable.independenceday, R.drawable.civilwar,
                                                    R.drawable.alamo, R.drawable.goldmine,
                                                    R.drawable.dredgetour, R.drawable.reclamation,
                                                    R.drawable.tailings, R.drawable.sluicebox*/
                           case 106:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Drh9qGnCgUg"));
                               startActivity(intentYoutube);
                               break;
                           case 107:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yONiqJRXNCk"));
                               startActivity(intentYoutube);
                               break;
                           case 108:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WMI89dFrIXc"));
                               startActivity(intentYoutube);
                               break;
                           case 109:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/m7h4XuvLrmg?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 110:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vigeyTerVEk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 111:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FNl5fc7UDG0?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 112:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/db9sHek49Ns?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 113:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vWYdsrXB9Kk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 114:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sVpBlcTk7sU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 115:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/biec1QKLe8s"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.jupiterandmoons, R.drawable.insidevenus,
                                                            R.drawable.spacewalk, R.drawable.healthcare,
                                                            R.drawable.turbinefactory, R.drawable.submersibledrone,
                                                            R.drawable.presses, R.drawable.microcosmicjourney*/
                           case 116:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kImxwNXzJu8"));
                               startActivity(intentYoutube);
                               break;
                           case 117:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/hJAmGG8MYRg"));
                               startActivity(intentYoutube);
                               break;
                           case 118:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/1tA7ColD8IQ"));
                               startActivity(intentYoutube);
                               break;
                           case 119:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Y_QPxBSiQl8"));
                               startActivity(intentYoutube);
                               break;
                           case 120:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WpaOn6y7QI8"));
                               startActivity(intentYoutube);
                               break;
                           case 121:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_zUKhRqf-FM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 122:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/H5pWJqYf1uk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 123:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ejs51o-Xdww?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.survival, R.drawable.irelandtour,
                                                R.drawable.takeoffairport, R.drawable.helicopter,
                                                R.drawable.shipwreck, R.drawable.m5warehouse,
                                                R.drawable.italy*/
                           case 124:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ctW79eQgtP8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 125:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/YLn2E5gYB_I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 126:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/z7YtD69DDmA?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 127:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/n0lm4crJ8cc?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 128:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aQd41nbQM-U?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 129:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/jBCs10yczfY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 130:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CecZb5DjGKg?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.nemomatic, R.drawable.activevolcano,
            R.drawable.meteorcrater, R.drawable.syriabeforewar,
            R.drawable.goldprospecting, R.drawable.goldwashplant*/
                           case 131:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/QfiNnG16mOE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 132:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/OBp2EWPjotk"));
                               startActivity(intentYoutube);
                               break;
                           case 133:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/cDcmlbObqvw"));
                               startActivity(intentYoutube);
                               break;
                           case 134:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yOPH5YFVu_w?list=PLmJ34zyhdBjG61yeDaLmDiKwqpfUtpJUj"));
                               startActivity(intentYoutube);
                               break;
                           case 135:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/k4uVC6tCGkU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 136:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iOjxRTKqrL8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /*  R.drawable.milkywaygalaxy2, R.drawable.moonwalk,
                                                            R.drawable.alzheimersdisease, R.drawable.molecularbiology,
                                                            R.drawable.molecularecology, R.drawable.vacuumcarlift*/
                           case 137:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/fUtale_i1jQ"));
                               startActivity(intentYoutube);
                               break;
                           case 138:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6OTl86BkPTs?list=PLIdyOC3BPCs2rfAWo5TidkvStU7ru6HK-"));
                               startActivity(intentYoutube);
                               break;
                           case 139:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_z7wp-knf88"));
                               startActivity(intentYoutube);
                               break;
                           case 140:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8T7NvlNUebs"));
                               startActivity(intentYoutube);
                               break;
                           case 141:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5ZJHg2270A0"));
                               startActivity(intentYoutube);
                               break;
                           case 142:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PSG47G0WDGI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.interiordesign, R.drawable.cityvilla,
                                                    R.drawable.architecture, R.drawable.desininginnovation,
                                                    R.drawable.evolveddesign, R.drawable.cockpitview,
                                                    R.drawable.rocketlaunch, R.drawable.thermalplant,
                                                    R.drawable.fusionreactor, R.drawable.plantenergy,
                                                    R.drawable.renewableenergy, R.drawable.globalresearch,
                                                    R.drawable.locomotivege, R.drawable.robotics3d*/
                           case 143:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/UOrOs5tzP48"));
                               startActivity(intentYoutube);
                               break;
                           case 144:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/v0WOHrwjyMg"));
                               startActivity(intentYoutube);
                               break;
                           case 145:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/EmGsFS6NJJk"));
                               startActivity(intentYoutube);
                               break;
                           case 146:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ctPyrvl83bc?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 147:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/O2ax_oQ0AsU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 148:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HEEIzZ7UjRg"));
                               startActivity(intentYoutube);
                               break;
                           case 149:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/03hAiKZDRAk?list=PL99oBFi6gZOhCu-nd_oYMDeVVCTcAuwOy"));
                               startActivity(intentYoutube);
                               break;
                           case 150:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/34cXKlP39Pg"));
                               startActivity(intentYoutube);
                               break;
                           case 151:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/NCIuHkKGNrQ"));
                               startActivity(intentYoutube);
                               break;
                           case 152:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0jHn6-QHX2U?list=PLTereL9KWtx-uFrwHzLJZLlDEbJiG10l8"));
                               startActivity(intentYoutube);
                               break;
                           case 153:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/o7VdVqy5gLk"));
                               startActivity(intentYoutube);
                               break;
                           case 154:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/EvnkL2efAc4"));
                               startActivity(intentYoutube);
                               break;
                           case 155:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/XTw58pFd-BY"));
                               startActivity(intentYoutube);
                               break;
                           case 156:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ew9g_Houqow?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                        /* R.drawable.earthedge, R.drawable.survivorman,
                                                            R.drawable.cruiseshiptour, R.drawable.himalayas,
                                                            R.drawable.rideinvenice, R.drawable.irelandcliffs,
                                                            R.drawable.canyanswing, R.drawable.freeboarding,
                                                            R.drawable.swamprules, R.drawable.officeview,
                                                            R.drawable.paragliding*/
                           case 157:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/nbq3R2xzNUk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 158:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/m_JO7oqBLFE"));
                               startActivity(intentYoutube);
                               break;
                           case 159:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xyInd6qv78U"));
                               startActivity(intentYoutube);
                               break;
                           case 160:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/GROaAAZrpEw"));
                               startActivity(intentYoutube);
                               break;
                           case 161:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CgV7gRSDKts?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 162:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5hGoo4X-4W8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 163:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/tl6rVm9vx2g?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 164:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Df0qyYPl0NY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 165:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/u0Z4Y1bJiBw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 166:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iTRwpgLRpEE"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((((selCat == 0) && (selSub == 1)) || ((selCat == 1) && (selSub == 0)) || ((selCat == 1) && (selSub == 1)))) {
                       switch (position) {
                        /*Intent intentYoutubeFS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=-FyN5_-njAU&t=7s&autoplay=0"));
                            intentYoutubeFS.putExtra("force_fullscreen", true);
                            intentYoutubeFS.putExtra("finish_on_ended", true);
                            startActivity(intentYoutubeFS);*/
                        /*R.drawable.lettera, R.drawable.letterb,
                        R.drawable.letterc, R.drawable.letterd,
                        R.drawable.lettere, R.drawable.learntocountwithrex*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/MvGymoT35aA?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/j-aPqU9DN5w?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/T4h6SQPlrAo?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/XggLgtJGNZY?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/i7R-5HLI_B0"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Lvz5UE5sz3s"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 1) && (selSub == 2)) {
                       switch (position) {
                        /* R.drawable.trainride, R.drawable.fivelittlemonkeys,
            R.drawable.wheelsonthebus, R.drawable.whoopieswonderworld,
            R.drawable.peppapiglivingroom, R.drawable.lookinside,
            R.drawable.surpriseeggs, R.drawable.streetvehicles*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rWSKPgFAPmQ"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zGaCNcgYtwY"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/4SkU2II19G8"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-E7HIlgLGmg"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/gecEMTXfgJg"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/TVilDuNBcHM"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Y_i-kVCBgcg"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/K8eZkTfx9Vw?list=PLt6M1oQvo0nhAmcHNFKM73dqTVOcDg-Vg"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 1) && (selSub == 3)) {
                       switch (position) {
                        /*  R.drawable.smallanimals, R.drawable.meetbiganimals,
            R.drawable.sharkpuppies, R.drawable.owlstorytelling,
            R.drawable.learncolors, R.drawable.ponystable*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pB8Ew3MgGW8"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VRjpO5GJAVc"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yCNmS5rZV54?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vhZZSGL2PP8?list=PLusRCtpGoSmtyb_7QFeIPZM9E4b5nOdF2"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/lAGEwpJgsJc"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/MWg1kjMmr3k?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 2) && (selSub == 0) || (selCat == 2) && (selSub == 1)) {
                       switch (position) {
                                        /*  R.drawable.tigereye, R.drawable.wilddolphins,
                                            R.drawable.africanzoo, R.drawable.feedinggiraffes,
                                            R.drawable.cincinnati, R.drawable.lemors,
                                            R.drawable.elephantshippos, R.drawable.mountaingorilla,
                                            R.drawable.horsejump, R.drawable.divingexploration,
                                            R.drawable.whitesharks, R.drawable.playfulelephants,
                                            R.drawable.lionslaststand, R.drawable.whalesharks,
                                            R.drawable.survivingsharks, R.drawable.caringrhinos,
                                            R.drawable.flyingontheedge, R.drawable.crablife,
                                            R.drawable.wildlife*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xal78egELos"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BbT_e8lWWdo"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xq_jkzTuQwQ"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Bf8mZQRTJ5I"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/qlNa9qYxmG4"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Xb84aJg4DbE"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/r4QisBVtRgQ"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PusRw0HDfL0"));
                               startActivity(intentYoutube);
                               break;
                           case 8:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BXBsYm-dnYU"));
                               startActivity(intentYoutube);
                               break;
                           case 9:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kJv0eYQp1lo?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 10:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HNOT_feL27Y?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 11:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/a_XIZHXRw4I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 12:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/mymJJtH0X3w?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 13:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/IDDW3gAcySk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 14:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WZEJ7TZcG1I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 15:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/7IWp875pCxQ?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 16:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/L9-pO_aCCHU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 17:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6WHrZjODOaY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 18:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/spFZDkudhgc"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 2) && (selSub == 2)) {
                       switch (position) {
                                                /* R.drawable.pigeonart, R.drawable.woodart,
                                                R.drawable.artsmagicgallery, R.drawable.arttoday,
                                                R.drawable.glassblowing, R.drawable.neonworks*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/v9wWuKbnvyc"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/GB9DGyK6cHs"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0oc3w04fdaE"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AHrR6YP84ds?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/eYrLogOlgfI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PED18kzRcDE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 2) && (selSub == 3)) {
                       switch (position) {
                                            /* R.drawable.rainforest, R.drawable.paris,
                                                R.drawable.amsterdam, R.drawable.newyork,
                                                R.drawable.cameltour, R.drawable.swingamongtrees*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iPwlNh48eYk"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Tph_ntIJQxk"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FzrkpXlRP1M"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/f0-89v4Fk-M"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/LltbuEts1BE"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WUNvmTtmDvo?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 2) && (selSub == 4)) {
                       switch (position) {
                                                    /* R.drawable.myearth, R.drawable.egghatching,
                                                        R.drawable.flyingwithswans, R.drawable.talkingshop,
                                                        R.drawable.followgold, R.drawable.happymagnet,
                                                        R.drawable.collider*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/o_rIAd1qMx0"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pDjGdTopAE0"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pXBDMyjBJRY?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sL8m72GAyNI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3l9ZvOd-Qvw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/giINIyBirAk"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/d_OeQxoKocU"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 3) && (selSub == 0) || (selCat == 3) && (selSub == 1)) {
                       switch (position) {
                                                /*  R.drawable.gorillasincongo, R.drawable.farmsanctuary,
                                                    R.drawable.dinosaur, R.drawable.grizzlybears,
                                                    R.drawable.sharkseverywhere, R.drawable.sharkexperiment,
                                                    R.drawable.anchorspecies, R.drawable.greatwhites*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/LMomKIt1uWA?list=PL6J03K740wkJx7mNNfg-j9ZhX20toNzCk"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-xfGkgU9T2A"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rfh-64s5va4?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/va1AmV24VSs"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3WIS6N_9gjA?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/g_WZncx-Baw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HWwaRcLqnU8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/eayh49rTZUM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 3) && (selSub == 2)) {
                       switch (position) {
                                        /*  R.drawable.tajmahal, R.drawable.indiagate,
                                            R.drawable.greatwall, R.drawable.eifeltower,
                                            R.drawable.buckinghampalace, R.drawable.amazonrainforest,
                                            R.drawable.trainridetunnel, R.drawable.britishmuseum,
                                            R.drawable.sydneyharbour, R.drawable.guysondeck,
                                            R.drawable.harbour, R.drawable.pacificsunset,
                                            R.drawable.throughrainforest, R.drawable.redwoods,
                                            R.drawable.lakeaustin, R.drawable.secretswaterfall,
                                            R.drawable.texasbridgecaverns, R.drawable.refugeelife*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aFx_fER0EpU"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xsQ8eros35I"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/n1fZe-Oqs14?list=PLmJ34zyhdBjG61yeDaLmDiKwqpfUtpJUj"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sJxiPiAaB4k"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9MeqUPkVg2U"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/em3tQoespWI"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/lRyYm9AlF9c"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/04I0UCVnMmQ"));
                               startActivity(intentYoutube);
                               break;
                           case 8:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aq9nXIVTkug"));
                               startActivity(intentYoutube);
                               break;
                           case 9:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VpCO0tgyMXE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 10:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/4-UmBQ9szaU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 11:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ka3qzz-oa-A?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 12:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CR5IZRAqUzs?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 13:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/DTlzIGFrL_4?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 14:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zv4wUhfSqVE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 15:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/QL6MF8Kw32c?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 16:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/YKC4YNXUE8U?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 17:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kER8zKrgM8c?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 3) && (selSub == 3)) {
                       switch (position) {
                                                    /* R.drawable.spacegallery, R.drawable.milkywaygalaxy,
                                                        R.drawable.totalssolareclipse, R.drawable.exploresolarsystem,
                                                        R.drawable.virtualplantcell, R.drawable.insidehumanbody2,
                                                        R.drawable.plantenergylab, R.drawable.redkitebird,
                                                        R.drawable.exploresets*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9kMEKmlWnf8"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xAuVs9_o9RY"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0ytyMKa8aps"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ZUPBtpm_XXI"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-FyN5_-njAU"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/OVOufYJnCgg?list=PLTereL9KWtx-uFrwHzLJZLlDEbJiG10l8"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PiSOVGZjous?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6o9mFOyqoUM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 4) && (selSub == 0) || (selCat == 4) && (selSub == 1)) {
                       switch (position) {
                                                /* R.drawable.threatenedspecies, R.drawable.africanelephant,
                                                    R.drawable.bearattack, R.drawable.wildelephants,
                                                    R.drawable.greatshark, R.drawable.celltour,
                                                    R.drawable.boxinginjuries, R.drawable.endocrinecells,
                                                    R.drawable.insidehumanbody, R.drawable.greatbarrierreef,
                                                    R.drawable.cellularactivity, R.drawable.resilientforestpart1,
                                                    R.drawable.resilientforestpart2, R.drawable.gravity*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/T-aOVE22lEw"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/2bpICIClAIg"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/g7btxyIbQQ0"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/mlOiXMvMaZo"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HNOT_feL27Y"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rKS-vvhMV6E"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FGsZf0BFHLU"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/IOK2fNXjDUU"));
                               startActivity(intentYoutube);
                               break;
                           case 8:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/uC0qdqk6INQ"));
                               startActivity(intentYoutube);
                               break;
                           case 9:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iBTArmgdBpI?list=PL6J03K740wkJx7mNNfg-j9ZhX20toNzCk"));
                               startActivity(intentYoutube);
                               break;
                           case 10:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8VUCEbNNKzI"));
                               startActivity(intentYoutube);
                               break;
                           case 11:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aAH40URLxkg"));
                               startActivity(intentYoutube);
                               break;
                           case 12:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AD-Lfk3LRh8"));
                               startActivity(intentYoutube);
                               break;
                           case 13:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VZK02CW7oy4"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 4) && (selSub == 2)) {
                       switch (position) {
                                                /*R.drawable.artgallery, R.drawable.himalayas,
                                                    R.drawable.independenceday, R.drawable.civilwar,
                                                    R.drawable.alamo, R.drawable.goldmine,
                                                    R.drawable.dredgetour, R.drawable.reclamation,
                                                    R.drawable.tailings, R.drawable.sluicebox*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Drh9qGnCgUg"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yONiqJRXNCk"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WMI89dFrIXc"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/m7h4XuvLrmg?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vigeyTerVEk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FNl5fc7UDG0?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/db9sHek49Ns?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vWYdsrXB9Kk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 8:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sVpBlcTk7sU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 9:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/biec1QKLe8s"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 4) && (selSub == 3)) {
                       switch (position) {
                                                        /* R.drawable.jupiterandmoons, R.drawable.insidevenus,
                                                            R.drawable.spacewalk, R.drawable.healthcare,
                                                            R.drawable.turbinefactory, R.drawable.submersibledrone,
                                                            R.drawable.presses, R.drawable.microcosmicjourney*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kImxwNXzJu8"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/hJAmGG8MYRg"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/1tA7ColD8IQ"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Y_QPxBSiQl8"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WpaOn6y7QI8"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_zUKhRqf-FM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/H5pWJqYf1uk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ejs51o-Xdww?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 4) && (selSub == 4)) {
                       switch (position) {
                                            /* R.drawable.survival, R.drawable.irelandtour,
                                                R.drawable.takeoffairport, R.drawable.helicopter,
                                                R.drawable.shipwreck, R.drawable.m5warehouse,
                                                R.drawable.italy*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ctW79eQgtP8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/YLn2E5gYB_I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/z7YtD69DDmA?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/n0lm4crJ8cc?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aQd41nbQM-U?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/jBCs10yczfY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CecZb5DjGKg?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 5) && (selSub == 0) || (selCat == 5) && (selSub == 1)) {
                       switch (position) {
                        /* R.drawable.nemomatic, R.drawable.activevolcano,
            R.drawable.meteorcrater, R.drawable.syriabeforewar,
            R.drawable.goldprospecting, R.drawable.goldwashplant*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/QfiNnG16mOE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/OBp2EWPjotk"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/cDcmlbObqvw"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yOPH5YFVu_w?list=PLmJ34zyhdBjG61yeDaLmDiKwqpfUtpJUj"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/k4uVC6tCGkU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iOjxRTKqrL8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 5) && (selSub == 2)) {
                       switch (position) {
                                                        /*  R.drawable.milkywaygalaxy2, R.drawable.moonwalk,
                                                            R.drawable.alzheimersdisease, R.drawable.molecularbiology,
                                                            R.drawable.molecularecology, R.drawable.vacuumcarlift*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/fUtale_i1jQ"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6OTl86BkPTs?list=PLIdyOC3BPCs2rfAWo5TidkvStU7ru6HK-"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_z7wp-knf88"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8T7NvlNUebs"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5ZJHg2270A0"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PSG47G0WDGI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 5) && (selSub == 3)) {
                       switch (position) {
                                                /* R.drawable.interiordesign, R.drawable.cityvilla,
                                                    R.drawable.architecture, R.drawable.desininginnovation,
                                                    R.drawable.evolveddesign, R.drawable.cockpitview,
                                                    R.drawable.rocketlaunch, R.drawable.thermalplant,
                                                    R.drawable.fusionreactor, R.drawable.plantenergy,
                                                    R.drawable.renewableenergy, R.drawable.globalresearch,
                                                    R.drawable.locomotivege, R.drawable.robotics3d*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/UOrOs5tzP48"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/v0WOHrwjyMg"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/EmGsFS6NJJk"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ctPyrvl83bc?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/O2ax_oQ0AsU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HEEIzZ7UjRg"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/03hAiKZDRAk?list=PL99oBFi6gZOhCu-nd_oYMDeVVCTcAuwOy"));
                               startActivity(intentYoutube);
                               break;
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/34cXKlP39Pg"));
                               startActivity(intentYoutube);
                               break;
                           case 8:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/NCIuHkKGNrQ"));
                               startActivity(intentYoutube);
                               break;
                           case 9:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0jHn6-QHX2U?list=PLTereL9KWtx-uFrwHzLJZLlDEbJiG10l8"));
                               startActivity(intentYoutube);
                               break;
                           case 10:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/o7VdVqy5gLk"));
                               startActivity(intentYoutube);
                               break;
                           case 11:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/EvnkL2efAc4"));
                               startActivity(intentYoutube);
                               break;
                           case 12:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/XTw58pFd-BY"));
                               startActivity(intentYoutube);
                               break;
                           case 13:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ew9g_Houqow?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   } else if ((selCat == 5) && (selSub == 4)) {
                       switch (position) {
                                                        /* R.drawable.earthedge, R.drawable.survivorman,
                                                            R.drawable.cruiseshiptour, R.drawable.himalayas,
                                                            R.drawable.rideinvenice, R.drawable.irelandcliffs,
                                                            R.drawable.canyanswing, R.drawable.freeboarding,
                                                            R.drawable.swamprules, R.drawable.officeview,
                                                            R.drawable.paragliding*/
                           case 0:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/nbq3R2xzNUk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 1:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/m_JO7oqBLFE"));
                               startActivity(intentYoutube);
                               break;
                           case 2:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xyInd6qv78U"));
                               startActivity(intentYoutube);
                               break;
                           case 3:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/GROaAAZrpEw"));
                               startActivity(intentYoutube);
                               break;
                           case 4:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CgV7gRSDKts?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 5:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5hGoo4X-4W8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 6:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/tl6rVm9vx2g?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                       /* case 7:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5oCTsArsOr4?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);*/
                           case 7:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Df0qyYPl0NY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 8:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/u0Z4Y1bJiBw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                               startActivity(intentYoutube);
                               break;
                           case 9:
                               intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iTRwpgLRpEE"));
                               startActivity(intentYoutube);
                               break;
                           default:
                               break;
                       }
                   }

               }
                else if(searchFlag==1) {
                    int tempInt = ((SearchAdapter) parent.getAdapter()).urlIndex[position];
                    switch (tempInt) {
                        case 0:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/MvGymoT35aA?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                            startActivity(intentYoutube);
                            break;
                        case 1:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/j-aPqU9DN5w?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                            startActivity(intentYoutube);
                            break;
                        case 2:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/T4h6SQPlrAo?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                            startActivity(intentYoutube);
                            break;
                        case 3:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/XggLgtJGNZY?list=PL9dE41aAmBq2h7RGnZn9whui5Rkmgi80U"));
                            startActivity(intentYoutube);
                            break;
                        case 4:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/i7R-5HLI_B0"));
                            startActivity(intentYoutube);
                            break;
                        case 5:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Lvz5UE5sz3s"));
                            startActivity(intentYoutube);
                            break;
                        case 6:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rWSKPgFAPmQ"));
                            startActivity(intentYoutube);
                            break;
                        case 7:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zGaCNcgYtwY"));
                            startActivity(intentYoutube);
                            break;
                        case 8:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/4SkU2II19G8"));
                            startActivity(intentYoutube);
                            break;
                        case 9:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-E7HIlgLGmg"));
                            startActivity(intentYoutube);
                            break;
                        case 10:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/gecEMTXfgJg"));
                            startActivity(intentYoutube);
                            break;
                        case 11:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/TVilDuNBcHM"));
                            startActivity(intentYoutube);
                            break;
                        case 12:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Y_i-kVCBgcg"));
                            startActivity(intentYoutube);
                            break;
                        case 13:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/K8eZkTfx9Vw?list=PLt6M1oQvo0nhAmcHNFKM73dqTVOcDg-Vg"));
                            startActivity(intentYoutube);
                            break;
                        case 14:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pB8Ew3MgGW8"));
                            startActivity(intentYoutube);
                            break;
                        case 15:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VRjpO5GJAVc"));
                            startActivity(intentYoutube);
                            break;
                        case 16:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yCNmS5rZV54?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 17:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vhZZSGL2PP8?list=PLusRCtpGoSmtyb_7QFeIPZM9E4b5nOdF2"));
                            startActivity(intentYoutube);
                            break;
                        case 18:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/lAGEwpJgsJc"));
                            startActivity(intentYoutube);
                            break;
                        case 19:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/MWg1kjMmr3k?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 20:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xal78egELos"));
                            startActivity(intentYoutube);
                            break;
                        case 21:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BbT_e8lWWdo"));
                            startActivity(intentYoutube);
                            break;
                        case 22:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xq_jkzTuQwQ"));
                            startActivity(intentYoutube);
                            break;
                        case 23:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Bf8mZQRTJ5I"));
                            startActivity(intentYoutube);
                            break;
                        case 24:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/qlNa9qYxmG4"));
                            startActivity(intentYoutube);
                            break;
                        case 25:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Xb84aJg4DbE"));
                            startActivity(intentYoutube);
                            break;
                        case 26:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/r4QisBVtRgQ"));
                            startActivity(intentYoutube);
                            break;
                        case 27:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PusRw0HDfL0"));
                            startActivity(intentYoutube);
                            break;
                        case 28:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BXBsYm-dnYU"));
                            startActivity(intentYoutube);
                            break;
                        case 29:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kJv0eYQp1lo?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                            startActivity(intentYoutube);
                            break;
                        case 30:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HNOT_feL27Y?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                            startActivity(intentYoutube);
                            break;
                        case 31:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/a_XIZHXRw4I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 32:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/mymJJtH0X3w?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 33:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/IDDW3gAcySk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 34:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WZEJ7TZcG1I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 35:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/7IWp875pCxQ?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 36:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/L9-pO_aCCHU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 37:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6WHrZjODOaY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 38:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/spFZDkudhgc"));
                            startActivity(intentYoutube);
                            break;
                        case 39:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/v9wWuKbnvyc"));
                            startActivity(intentYoutube);
                            break;
                        case 40:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/GB9DGyK6cHs"));
                            startActivity(intentYoutube);
                            break;
                        case 41:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0oc3w04fdaE"));
                            startActivity(intentYoutube);
                            break;
                        case 42:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AHrR6YP84ds?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 43:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/eYrLogOlgfI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 44:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PED18kzRcDE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 45:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iPwlNh48eYk"));
                            startActivity(intentYoutube);
                            break;
                        case 46:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Tph_ntIJQxk"));
                            startActivity(intentYoutube);
                            break;
                        case 47:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FzrkpXlRP1M"));
                            startActivity(intentYoutube);
                            break;
                        case 48:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/f0-89v4Fk-M"));
                            startActivity(intentYoutube);
                            break;
                        case 49:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/LltbuEts1BE"));
                            startActivity(intentYoutube);
                            break;
                        case 50:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WUNvmTtmDvo?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 51:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/o_rIAd1qMx0"));
                            startActivity(intentYoutube);
                            break;
                        case 52:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pDjGdTopAE0"));
                            startActivity(intentYoutube);
                            break;
                        case 53:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pXBDMyjBJRY?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                            startActivity(intentYoutube);
                            break;
                        case 54:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sL8m72GAyNI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 55:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3l9ZvOd-Qvw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 56:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/giINIyBirAk"));
                            startActivity(intentYoutube);
                            break;
                        case 57:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/d_OeQxoKocU"));
                            startActivity(intentYoutube);
                            break;
                        case 58:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/LMomKIt1uWA?list=PL6J03K740wkJx7mNNfg-j9ZhX20toNzCk"));
                            startActivity(intentYoutube);
                            break;
                        case 59:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-xfGkgU9T2A"));
                            startActivity(intentYoutube);
                            break;
                        case 60:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rfh-64s5va4?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                            startActivity(intentYoutube);
                            break;
                        case 61:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/va1AmV24VSs"));
                            startActivity(intentYoutube);
                            break;
                        case 62:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3WIS6N_9gjA?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 63:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/g_WZncx-Baw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 64:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HWwaRcLqnU8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 65:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/eayh49rTZUM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 66:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aFx_fER0EpU"));
                            startActivity(intentYoutube);
                            break;
                        case 67:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xsQ8eros35I"));
                            startActivity(intentYoutube);
                            break;
                        case 68:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/n1fZe-Oqs14?list=PLmJ34zyhdBjG61yeDaLmDiKwqpfUtpJUj"));
                            startActivity(intentYoutube);
                            break;
                        case 69:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sJxiPiAaB4k"));
                            startActivity(intentYoutube);
                            break;
                        case 70:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9MeqUPkVg2U"));
                            startActivity(intentYoutube);
                            break;
                        case 71:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/em3tQoespWI"));
                            startActivity(intentYoutube);
                            break;
                        case 72:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/lRyYm9AlF9c"));
                            startActivity(intentYoutube);
                            break;
                        case 73:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/04I0UCVnMmQ"));
                            startActivity(intentYoutube);
                            break;
                        case 74:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aq9nXIVTkug"));
                            startActivity(intentYoutube);
                            break;
                        case 75:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VpCO0tgyMXE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 76:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/4-UmBQ9szaU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 77:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ka3qzz-oa-A?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 78:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CR5IZRAqUzs?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 79:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/DTlzIGFrL_4?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 80:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zv4wUhfSqVE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 81:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/QL6MF8Kw32c?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 82:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/YKC4YNXUE8U?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 83:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kER8zKrgM8c?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 84:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9kMEKmlWnf8"));
                            startActivity(intentYoutube);
                            break;
                        case 85:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xAuVs9_o9RY"));
                            startActivity(intentYoutube);
                            break;
                        case 86:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0ytyMKa8aps"));
                            startActivity(intentYoutube);
                            break;
                        case 87:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ZUPBtpm_XXI"));
                            startActivity(intentYoutube);
                            break;
                        case 88:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-FyN5_-njAU"));
                            startActivity(intentYoutube);
                            break;
                        case 89:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/OVOufYJnCgg?list=PLTereL9KWtx-uFrwHzLJZLlDEbJiG10l8"));
                            startActivity(intentYoutube);
                            break;
                        case 90:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PiSOVGZjous?list=PLSs2JUvNOdCg8B9odiKo0aBRiCwf45amt"));
                            startActivity(intentYoutube);
                            break;
                        case 91:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6o9mFOyqoUM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 92:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/T-aOVE22lEw"));
                            startActivity(intentYoutube);
                            break;
                        case 93:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/2bpICIClAIg"));
                            startActivity(intentYoutube);
                            break;
                        case 94:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/g7btxyIbQQ0"));
                            startActivity(intentYoutube);
                            break;
                        case 95:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/mlOiXMvMaZo"));
                            startActivity(intentYoutube);
                            break;
                        case 96:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HNOT_feL27Y"));
                            startActivity(intentYoutube);
                            break;
                        case 97:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rKS-vvhMV6E"));
                            startActivity(intentYoutube);
                            break;
                        case 98:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FGsZf0BFHLU"));
                            startActivity(intentYoutube);
                            break;
                        case 99:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/IOK2fNXjDUU"));
                            startActivity(intentYoutube);
                            break;
                        case 100:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/uC0qdqk6INQ"));
                            startActivity(intentYoutube);
                            break;
                        case 101:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iBTArmgdBpI?list=PL6J03K740wkJx7mNNfg-j9ZhX20toNzCk"));
                            startActivity(intentYoutube);
                            break;
                        case 102:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8VUCEbNNKzI"));
                            startActivity(intentYoutube);
                            break;
                        case 103:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aAH40URLxkg"));
                            startActivity(intentYoutube);
                            break;
                        case 104:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AD-Lfk3LRh8"));
                            startActivity(intentYoutube);
                            break;
                        case 105:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/VZK02CW7oy4"));
                            startActivity(intentYoutube);
                            break;
                        case 106:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Drh9qGnCgUg"));
                            startActivity(intentYoutube);
                            break;
                        case 107:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yONiqJRXNCk"));
                            startActivity(intentYoutube);
                            break;
                        case 108:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WMI89dFrIXc"));
                            startActivity(intentYoutube);
                            break;
                        case 109:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/m7h4XuvLrmg?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 110:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vigeyTerVEk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 111:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/FNl5fc7UDG0?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 112:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/db9sHek49Ns?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 113:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vWYdsrXB9Kk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 114:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sVpBlcTk7sU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 115:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/biec1QKLe8s"));
                            startActivity(intentYoutube);
                            break;
                        case 116:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kImxwNXzJu8"));
                            startActivity(intentYoutube);
                            break;
                        case 117:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/hJAmGG8MYRg"));
                            startActivity(intentYoutube);
                            break;
                        case 118:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/1tA7ColD8IQ"));
                            startActivity(intentYoutube);
                            break;
                        case 119:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Y_QPxBSiQl8"));
                            startActivity(intentYoutube);
                            break;
                        case 120:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WpaOn6y7QI8"));
                            startActivity(intentYoutube);
                            break;
                        case 121:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_zUKhRqf-FM?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 122:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/H5pWJqYf1uk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 123:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ejs51o-Xdww?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 124:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ctW79eQgtP8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 125:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/YLn2E5gYB_I?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 126:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/z7YtD69DDmA?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 127:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/n0lm4crJ8cc?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 128:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aQd41nbQM-U?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 129:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/jBCs10yczfY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 130:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CecZb5DjGKg?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 131:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/QfiNnG16mOE?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 132:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/OBp2EWPjotk"));
                            startActivity(intentYoutube);
                            break;
                        case 133:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/cDcmlbObqvw"));
                            startActivity(intentYoutube);
                            break;
                        case 134:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/yOPH5YFVu_w?list=PLmJ34zyhdBjG61yeDaLmDiKwqpfUtpJUj"));
                            startActivity(intentYoutube);
                            break;
                        case 135:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/k4uVC6tCGkU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 136:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iOjxRTKqrL8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 137:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/fUtale_i1jQ"));
                            startActivity(intentYoutube);
                            break;
                        case 138:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/6OTl86BkPTs?list=PLIdyOC3BPCs2rfAWo5TidkvStU7ru6HK-"));
                            startActivity(intentYoutube);
                            break;
                        case 139:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_z7wp-knf88"));
                            startActivity(intentYoutube);
                            break;
                        case 140:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8T7NvlNUebs"));
                            startActivity(intentYoutube);
                            break;
                        case 141:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5ZJHg2270A0"));
                            startActivity(intentYoutube);
                            break;
                        case 142:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PSG47G0WDGI?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 143:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/UOrOs5tzP48"));
                            startActivity(intentYoutube);
                            break;
                        case 144:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/v0WOHrwjyMg"));
                            startActivity(intentYoutube);
                            break;
                        case 145:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/EmGsFS6NJJk"));
                            startActivity(intentYoutube);
                            break;
                        case 146:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ctPyrvl83bc?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 147:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/O2ax_oQ0AsU?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 148:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HEEIzZ7UjRg"));
                            startActivity(intentYoutube);
                            break;
                        case 149:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/03hAiKZDRAk?list=PL99oBFi6gZOhCu-nd_oYMDeVVCTcAuwOy"));
                            startActivity(intentYoutube);
                            break;
                        case 150:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/34cXKlP39Pg"));
                            startActivity(intentYoutube);
                            break;
                        case 151:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/NCIuHkKGNrQ"));
                            startActivity(intentYoutube);
                            break;
                        case 152:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0jHn6-QHX2U?list=PLTereL9KWtx-uFrwHzLJZLlDEbJiG10l8"));
                            startActivity(intentYoutube);
                            break;
                        case 153:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/o7VdVqy5gLk"));
                            startActivity(intentYoutube);
                            break;
                        case 154:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/EvnkL2efAc4"));
                            startActivity(intentYoutube);
                            break;
                        case 155:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/XTw58pFd-BY"));
                            startActivity(intentYoutube);
                            break;
                        case 156:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ew9g_Houqow?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 157:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/nbq3R2xzNUk?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 158:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/m_JO7oqBLFE"));
                            startActivity(intentYoutube);
                            break;
                        case 159:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xyInd6qv78U"));
                            startActivity(intentYoutube);
                            break;
                        case 160:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/GROaAAZrpEw"));
                            startActivity(intentYoutube);
                            break;
                        case 161:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/CgV7gRSDKts?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 162:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5hGoo4X-4W8?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 163:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/tl6rVm9vx2g?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 164:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Df0qyYPl0NY?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 165:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/u0Z4Y1bJiBw?list=PLiCk2I6PXl5qm0CTvO6zXt3k33GTmcIvk"));
                            startActivity(intentYoutube);
                            break;
                        case 166:
                            intentYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iTRwpgLRpEE"));
                            startActivity(intentYoutube);
                            break;
                        default:
                            break;
                    }
                    //searchFlag = false;
                }

            }
        });
        return view;
    }
    private ArrayList<Video> getVideos()
    {
        ArrayList<Video> videos=new ArrayList<Video>();
        Video p;
        for(int i=0;i<names.length;i++)
        {
            p=new Video(names[i], images[i]);
            videos.add(p);
        }
       /* for(int j=0;j<names.length;j++)
        {
             Toast.makeText(getActivity().getApplicationContext(), "SearchOnQueryTextSubmit: " + videos.get(j).getVidName().toString()+","+videos.get(j).getVidImage(), Toast.LENGTH_SHORT).show();
        }*/

        return videos;
    }
    public void addItemsToSpinnercat() {

        ArrayList<String> catlist = new ArrayList<String>();
        catlist.add("Category");
        catlist.add("3-5 yrs");
        catlist.add("5-7 yrs");
        catlist.add("7-11 yrs");
        catlist.add("11-14 yrs");
        catlist.add("14-16 yrs");

        final ArrayList<String> sublist0 = new ArrayList<String>();
        sublist0.add("Subject");
        sublist0.add("Alphabets/Numbers");
        sublist0.add("Rhymes");
        sublist0.add("Others");

        final ArrayList<String> sublist1 = new ArrayList<String>();
        sublist1.add("Subject");
        sublist1.add("Animals");
        sublist1.add("Art");
        sublist1.add("Travel");
        sublist1.add("Others");

        final ArrayList<String> sublist2 = new ArrayList<String>();
        sublist2.add("Subject");
        sublist2.add("Animals");
        sublist2.add("Travel");
        sublist2.add("Others");

        final ArrayList<String> sublist3 = new ArrayList<String>();
        sublist3.add("Subject");
        sublist3.add("Science");
        sublist3.add("Art/SocialScience");
        sublist3.add("AstroPhysics/Technology");
        sublist3.add("Travel");

        final ArrayList<String> sublist4 = new ArrayList<String>();
        sublist4.add("Subject");
        sublist4.add("Art/SocialScience");
        sublist4.add("Science");
        sublist4.add("Design/Technology");
        sublist4.add("Travel");


        // ArrayList<String><String> sublist = new ArrayList<String><String>();

        // Custom ArrayAdapter with spinner item layout to set popup background

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getActivity().getApplicationContext(), catlist);
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
                // On selecting a spinner item
                searchFlag=0;
               /* imageAdapter.notify();
                gridview.setAdapter(imageAdapter);*/
                String item = adapter.getItemAtPosition(position).toString();
                switch(position) {
                    case 0:
                        spinAdaptersub = new CustomSpinnerAdapter(
                            getActivity().getApplicationContext(), sublist0);
                        spinnersub.setAdapter(spinAdaptersub);
                        gridview.setAdapter(new ImageAdapter(getActivity().getApplicationContext(),0));
                        //Toast.makeText(getActivity().getApplicationContext(),"Category selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        spinAdaptersub = new CustomSpinnerAdapter(
                                getActivity().getApplicationContext(), sublist0);
                        spinnersub.setAdapter(spinAdaptersub);
                        break;
                    case 2:
                        spinAdaptersub = new CustomSpinnerAdapter(
                                getActivity().getApplicationContext(), sublist1);
                        spinnersub.setAdapter(spinAdaptersub);
                        break;
                    case 3:
                        spinAdaptersub = new CustomSpinnerAdapter(
                                getActivity().getApplicationContext(), sublist2);
                        spinnersub.setAdapter(spinAdaptersub);
                        break;
                    case 4:
                        spinAdaptersub = new CustomSpinnerAdapter(
                                getActivity().getApplicationContext(), sublist3);
                        spinnersub.setAdapter(spinAdaptersub);
                        break;
                    case 5:
                        spinAdaptersub = new CustomSpinnerAdapter(
                                getActivity().getApplicationContext(), sublist4);
                        spinnersub.setAdapter(spinAdaptersub);
                        break;
                    default:
                        break;
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
        sublist0.add("Alphabets/Numbers");
        sublist0.add("Rhymes");
        sublist0.add("General");

        ArrayList<String> sublist1 = new ArrayList<String>();
        sublist1.add("Subject");
        sublist1.add("Animals");
        sublist1.add("Art");
        sublist1.add("Travel");
        sublist1.add("General");

        ArrayList<String> sublist2 = new ArrayList<String>();
        sublist2.add("Subject");
        sublist2.add("Animals");
        sublist2.add("Travel");
        sublist2.add("General");

        ArrayList<String> sublist3 = new ArrayList<String>();
        sublist3.add("Subject");
        sublist3.add("Science");
        sublist3.add("Art/SocialScience");
        sublist3.add("AstroPhysics/Technology");
        sublist3.add("Travel");

        ArrayList<String> sublist4 = new ArrayList<String>();
        sublist4.add("Subject");
        sublist4.add("Art/SocialScience");
        sublist4.add("Science");
        sublist4.add("Design/Technology");
        sublist4.add("Travel");

        CustomSpinnerAdapter spinAdaptersub = new CustomSpinnerAdapter(
                getActivity().getApplicationContext(), sublist0);
  /*
   * ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this,
   * android.R.layout.simple_spinner_item, list);
   * spinAdapter.setDropDownViewResource
   * (android.R.layout.simple_spinner_dropdown_item);
   */
        spinnersub.setAdapter(spinAdaptersub);

        // Custom ArrayAdapter with spinner item layout to set popup background

        spinnersub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                searchFlag=0;
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();
                int category = spinnercat.getSelectedItemPosition();
                String catsub = String.valueOf(category) + String.valueOf(position);
                switch(catsub){
                    case "00":
                        mImageArray=0;
                        break;
                    case "10":
                    case "11":
                        mImageArray=1;
                        break;
                    case "12":
                        mImageArray=2;
                        break;
                    case  "13":
                        mImageArray=3;
                        break;
                    case "20":
                    case "21":
                        mImageArray=4;
                        break;
                    case "22":
                        mImageArray=5;
                        break;
                    case "23":
                        mImageArray=6;
                        break;
                    case "24":
                        mImageArray=7;
                        break;
                    case "30":
                    case "31":
                        mImageArray=8;
                        break;
                    case "32":
                        mImageArray=9;
                        break;
                    case "33":
                        mImageArray=10;
                        break;
                    case "40":
                    case "41":
                        mImageArray=11;
                        break;
                    case "42":
                        mImageArray=12;
                        break;
                    case "43":
                        mImageArray=13;
                        break;
                    case "44":
                        mImageArray=14;
                        break;
                    case "50":
                    case "51":
                        mImageArray=15;
                        break;
                    case "52":
                        mImageArray=16;
                        break;
                    case "53":
                        mImageArray=17;
                        break;
                    case "54":
                        mImageArray=18;
                        break;
                    default:
                        break;

                }

                gridview.setAdapter(new ImageAdapter(getActivity().getApplicationContext(),mImageArray));
                // Showing selected spinner item
               // Toast.makeText(getActivity().getApplicationContext(), "Selected  : " + item+"cat="+category, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

}
