package com.vrplayerapp.in;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

/**
 * Created by Admin on 03-03-2017.
 */

public class AppsImageAdapter extends BaseAdapter {
    private final Context context;
    private final List<String> urls = new ArrayList<>();
    private int mImageArray;

    public AppsImageAdapter(Context context,int arrayindex) {
        this.context = context;
        mImageArray=arrayindex;
        // Ensure we get a different ordering of images on each run.
       // Collections.addAll(urls, ContactsContract.Contacts.Data.URLS);
       // Collections.shuffle(urls);

        // Triple up the list.
     /*   ArrayList<String> copy = new ArrayList<>(urls);
        urls.addAll(copy);
        urls.addAll(copy);*/
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(
                    (int)context.getResources().getDimension(R.dimen.width),
                    (int)context.getResources().getDimension(R.dimen.height)));
            //imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        //https://imgbb.com
        //user id-vidya_amar
        //pw-beinself_123
        //imageView.setImageResource(mThumbIds0[position]);
       /* SquaredImageView view = (SquaredImageView) convertView;
        if (view == null) {
            view = new SquaredImageView(context);
            view.setScaleType(CENTER_CROP);
        }*/

        // Get the image URL for the current position.
        //String url = getItem(position);
        //String url = "https://www.simplifiedcoding.net/wp-content/uploads/2015/10/advertise.png";
        //String url ="https://photos.google.com/photo/femalereproductivesys.png";

        //https://photos.google.com/photo/AF1QipPyL6wOqS9fkqcsLPzJoPgVLJMr-gNHnFsjNwha
        String url = mThumbIdsAppUrl0[position];
        //https://image.ibb.co/ggMika/bacteria3d.png
        //
        // Trigger the download of the URL asynchronously into the image view.
        Picasso.with(context) //
                .load(url) //
                //.placeholder(R.drawable.placeholder) //
                .error(R.drawable.error) //
                .fit() //
                .tag(context) //
                .into(imageView);

        return imageView;
    }

    @Override public int getCount() {
        switch (mImageArray) {
            case 0:
                return mThumbIdsAppUrl0.length;
            case 1:
                return mThumbIds1.length;
            case 2:
                return mThumbIds2.length;
            case 3:
                return mThumbIds3.length;
            case 4:
                return mThumbIds4.length;
            case 5:
                return mThumbIds5.length;
            case 6:
                return mThumbIds6.length;
            case 7:
                return mThumbIds7.length;
            case 8:
                return mThumbIds8.length;
            case 9:
                return mThumbIds9.length;
            case 10:
                return mThumbIds10.length;
            case 11:
                return mThumbIds11.length;
            case 12:
                return mThumbIds12.length;
            case 13:
                return mThumbIds13.length;
            case 14:
                return mThumbIds14.length;
            case 15:
                return mThumbIds15.length;
            case 16:
                return mThumbIds16.length;
            case 17:
                return mThumbIds17.length;
            case 18:
                return mThumbIds18.length;
            default:
                return mThumbIdsAppUrl0.length;
        }
        // return urls.size();
    }

    @Override public String getItem(int position) {
        return null;
        //return urls.get(position);
    }

    @Override public long getItemId(int position) {
        return 0;
        //return position;
    }

    private String[] mThumbIdsAppUrl0 = {
            "http://image.ibb.co/eyFZRF/humanheart.png",
            "http://image.ibb.co/nv3xwF/bloodcirculation.png",
            "http://image.ibb.co/hfE4bF/humandigestivesystem.png",
            "http://image.ibb.co/gtbutv/humanspine.png",
            "http://image.ibb.co/ctvhVa/biogasplant.png",
            "http://image.ibb.co/b6ouAa/thermalpowerstation.png",
            "http://image.ibb.co/mp4sfa/bacteria3d.png",
            "http://image.ibb.co/mUHHDv/femalereproductivesys.png"

    };

    // references to our images
    private Integer[] mThumbIds0 = {
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
    // references to our images
    private Integer[] mThumbIds1 = {
            R.drawable.lettera, R.drawable.letterb,
            R.drawable.letterc, R.drawable.letterd,
            R.drawable.lettere, R.drawable.learntocountwithrex

    };
    // references to our images
    private Integer[] mThumbIds2 = {
            R.drawable.trainride, R.drawable.fivelittlemonkeys,
            R.drawable.wheelsonthebus, R.drawable.whoopieswonderworld,
            R.drawable.peppapiglivingroom, R.drawable.lookinside,
            R.drawable.surpriseeggs, R.drawable.streetvehicles
    };
    // references to our images
    private Integer[] mThumbIds3 = {
            R.drawable.smallanimals, R.drawable.meetbiganimals,
            R.drawable.sharkpuppies, R.drawable.owlstorytelling,
            R.drawable.learncolors, R.drawable.ponystable
    };
    // references to our images
    private Integer[] mThumbIds4 = {
            R.drawable.tigereye, R.drawable.wilddolphins,
            R.drawable.africanzoo, R.drawable.feedinggiraffes,
            R.drawable.cincinnati, R.drawable.lemors,
            R.drawable.elephantshippos, R.drawable.mountaingorilla,
            R.drawable.horsejump, R.drawable.divingexploration,
            R.drawable.whitesharks, R.drawable.playfulelephants,
            R.drawable.lionslaststand, R.drawable.whalesharks,
            R.drawable.survivingsharks, R.drawable.caringrhinos,
            R.drawable.flyingontheedge, R.drawable.crablife,
            R.drawable.wildlife

    };
    // references to our images
    private Integer[] mThumbIds5 = {
            R.drawable.pigeonart, R.drawable.woodart,
            R.drawable.artsmagicgallery, R.drawable.arttoday,
            R.drawable.glassblowing, R.drawable.neonworks

    };
    // references to our images
    private Integer[] mThumbIds6 = {
            R.drawable.rainforest, R.drawable.paris,
            R.drawable.amsterdam, R.drawable.newyork,
            R.drawable.cameltour, R.drawable.swingamongtrees

    };
    // references to our images
    private Integer[] mThumbIds7 = {
            R.drawable.myearth, R.drawable.egghatching,
            R.drawable.flyingwithswans, R.drawable.talkingshop,
            R.drawable.followgold, R.drawable.happymagnet,
            R.drawable.collider

    };
    // references to our images
    private Integer[] mThumbIds8 = {
            R.drawable.gorillasincongo, R.drawable.farmsanctuary,
            R.drawable.dinosaur, R.drawable.grizzlybears,
            R.drawable.sharkseverywhere, R.drawable.sharkexperiment,
            R.drawable.anchorspecies, R.drawable.greatwhites

    };
    // references to our images
    private Integer[] mThumbIds9 = {
            R.drawable.tajmahal, R.drawable.indiagate,
            R.drawable.greatwall, R.drawable.eifeltower,
            R.drawable.buckinghampalace, R.drawable.amazonrainforest,
            R.drawable.trainridetunnel, R.drawable.britishmuseum,
            R.drawable.sydneyharbour, R.drawable.guysondeck,
            R.drawable.harbour, R.drawable.pacificsunset,
            R.drawable.throughrainforest, R.drawable.redwoods,
            R.drawable.lakeaustin, R.drawable.secretswaterfall,
            R.drawable.texasbridgecaverns, R.drawable.refugeelife


    };
    // references to our images
    private Integer[] mThumbIds10 = {
            R.drawable.spacegallery, R.drawable.totalssolareclipse,
            R.drawable.exploresolarsystem,
            R.drawable.virtualplantcell, R.drawable.insidehumanbody,
            R.drawable.plantenergylab, R.drawable.redkitebird,
            R.drawable.exploresets

    };
    // references to our images
    private Integer[] mThumbIds11 = {
            R.drawable.threatenedspecies, R.drawable.africanelephant,
            R.drawable.bearattack, R.drawable.wildelephants,
            R.drawable.whitesharks, R.drawable.celltour,
            R.drawable.boxinginjuries, R.drawable.endocrinecells,
            R.drawable.insidehumanbody1, R.drawable.greatbarrierreef,
            R.drawable.cellularactivity, R.drawable.resilientforestpart1,
            R.drawable.resilientforestpart2, R.drawable.gravity

    };
    // references to our images
    private Integer[] mThumbIds12 = {
            R.drawable.artgallery, R.drawable.himalayas,
            R.drawable.independenceday, R.drawable.civilwar,
            R.drawable.alamo, R.drawable.goldmine,
            R.drawable.dredgetour, R.drawable.reclamation,
            R.drawable.tailings, R.drawable.sluicebox

    };
    // references to our images
    private Integer[] mThumbIds13 = {
            R.drawable.jupiterandmoons, R.drawable.insidevenus,
            R.drawable.spacewalk, R.drawable.healthcare,
            R.drawable.turbinefactory, R.drawable.submersibledrone,
            R.drawable.presses, R.drawable.microcosmicjourney

    };
    // references to our images
    private Integer[] mThumbIds14 = {
            R.drawable.survival, R.drawable.irelandtour,
            R.drawable.takeoffairport, R.drawable.helicopter,
            R.drawable.shipwreck, R.drawable.m5warehouse,
            R.drawable.italy

    };
    // references to our images
    private Integer[] mThumbIds15 = {
            R.drawable.nemomatic, R.drawable.activevolcano,
            R.drawable.meteorcrater, R.drawable.syriabeforewar,
            R.drawable.goldprospecting, R.drawable.goldwashplant

    };
    // references to our images
    private Integer[] mThumbIds16 = {
            R.drawable.milkywaygalaxy2, R.drawable.moonwalk,
            R.drawable.alzheimersdisease, R.drawable.molecularbiology,
            R.drawable.molecularecology, R.drawable.vacuumcarlift

    };
    // references to our images
    private Integer[] mThumbIds17 = {
            R.drawable.interiordesign, R.drawable.cityvilla,
            R.drawable.architecture, R.drawable.desininginnovation,
            R.drawable.evolveddesign, R.drawable.cockpitview,
            R.drawable.rocketlaunch, R.drawable.thermalplant,
            R.drawable.fusionreactor, R.drawable.plantenergy,
            R.drawable.renewableenergy, R.drawable.globalresearch,
            R.drawable.locomotivege, R.drawable.robotics3d
    };
    // references to our images
    private Integer[] mThumbIds18 = {
            R.drawable.earthedge, R.drawable.survivorman,
            R.drawable.cruiseshiptour, R.drawable.himalayantrek,
            R.drawable.rideinvenice, R.drawable.irelandcliffs,
            R.drawable.canyanswing, //R.drawable.freeboarding,
            R.drawable.swamprules, R.drawable.officeview,
            R.drawable.paragliding

    };

}