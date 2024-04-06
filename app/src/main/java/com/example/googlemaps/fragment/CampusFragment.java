package com.example.googlemaps.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.googlemaps.R;
import com.example.googlemaps.adapter.CampusRecyclerViewAdapter;
import com.example.googlemaps.fragment.placeholder.PlaceholderContent;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class CampusFragment extends Fragment {
    private PlaceholderContent placeholderContent;

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CampusFragment() {
    }

    @SuppressWarnings("unused")
    public static CampusFragment newInstance(int columnCount) {
        CampusFragment fragment = new CampusFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load campus data.
        ArrayList<PlaceholderContent.PlaceholderItem> campus = loadCampusData();

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_campus_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new CampusRecyclerViewAdapter(loadCampusData()));
        }
        return view;
    }

    // Method to load campus data.
    private ArrayList<PlaceholderContent.PlaceholderItem> loadCampusData() {
        ArrayList<PlaceholderContent.PlaceholderItem> campus = new ArrayList<>();

        // List of Penn State campuses (title).
        String abingtonCampus = "Penn State - Abington";
        String altoonaCampus = "Penn State - Altoona";
        String beaverCampus = "Penn State - Beaver";
        String behrendCampus = "Penn State - Behrend";
        String berksCampus = "Penn State - Berks";
        String brandywineCampus = "Penn State - Brandywine";
        String carlisleCampus = "Penn State - Carlisle";
        String duboisCampus = "Penn State - Dubois";
        String fayetteCampus = "Penn State - Fayette";
        String greatValleyCampus = "Penn State - Great Valley";
        String greaterAlleghenyCampus = "Penn State - Greater Allegheny";
        String harrisburgCampus = "Penn State - Harrisburg";
        String hazeltonCampus = "Penn State - Hazleton";
        String hersheyCampus = "Penn State - Hershey";
        String lehighValleyCampus = "Penn State - Lehigh Valley";
        String montAltoCampus = "Penn State - Mont Alto";
        String newKensingtonCampus = "Penn State - New Kensington";
        String schuylkillCampus = "Penn State - Schuylkill";
        String scrantonCampus = "Penn State - Scranton";
        String shenangoCampus = "Penn State - Shenango";
        String universityParkCampus = "Penn State - University Park";
        String wilkesBarreCampus = "Penn State - Wilkes-Barre";
        String williamsportCampus = "Penn State - Williamsport";
        String yorkCampus = "Penn State - York";

        // Represent Penn State campus locations we need to use LatLng.
        LatLng abington = new LatLng(39.88211,-75.337234);
        LatLng altoona = new LatLng(40.489433,-78.349874);
        LatLng beaver = new LatLng(41.19368,-79.588940);
        LatLng behrend = new LatLng(40.902496,-77.833451);
        LatLng berks = new LatLng(40.33692,-75.921960);
        LatLng brandywine = new LatLng(40.09733,-75.37213);
        LatLng carlisle = new LatLng(40.20148,-77.18887);
        LatLng dubois = new LatLng(41.118045,-78.720302);
        LatLng fayette = new LatLng(41.103948,-80.309787);
        LatLng greatValley = new LatLng(39.88211,-75.337234);
        LatLng greaterAllegheny = new LatLng(40.469757,-79.980452);
        LatLng harrisburg= new LatLng(40.258655,-76.894376);
        LatLng hazelton = new LatLng(40.947134,-75.957126);
        LatLng hershey = new LatLng(40.269748,-76.636357);
        LatLng lehighValley = new LatLng(40.693376,-75.471156);
        LatLng montAlto = new LatLng(39.84426,-77.55832);
        LatLng newKensington = new LatLng(40.557925,-79.726079);
        LatLng schuylkill = new LatLng(40.703682, -76.217788);
        LatLng scranton = new LatLng(41.410079,-75.666784);
        LatLng shenango = new LatLng(41.379777,-80.398957);
        LatLng universityPark = new LatLng(40.799672, -77.862339);
        LatLng wilkesBarre = new LatLng(41.243648,-75.885029);
        LatLng williamsport = new LatLng(41.345045,-76.857256);
        LatLng york = new LatLng(39.962998,-76.727139);

        // Adds campus data for title and description.
        campus.add(new PlaceholderContent.PlaceholderItem(abingtonCampus, abington));
        campus.add(new PlaceholderContent.PlaceholderItem(altoonaCampus, altoona));
        campus.add(new PlaceholderContent.PlaceholderItem(beaverCampus, beaver));
        campus.add(new PlaceholderContent.PlaceholderItem(behrendCampus, behrend));
        campus.add(new PlaceholderContent.PlaceholderItem(berksCampus, berks));
        campus.add(new PlaceholderContent.PlaceholderItem(brandywineCampus, brandywine));
        campus.add(new PlaceholderContent.PlaceholderItem(carlisleCampus, carlisle));
        campus.add(new PlaceholderContent.PlaceholderItem(duboisCampus, dubois));
        campus.add(new PlaceholderContent.PlaceholderItem(fayetteCampus, fayette));
        campus.add(new PlaceholderContent.PlaceholderItem(greatValleyCampus, greatValley));
        campus.add(new PlaceholderContent.PlaceholderItem(greaterAlleghenyCampus, greaterAllegheny));
        campus.add(new PlaceholderContent.PlaceholderItem(harrisburgCampus, harrisburg));
        campus.add(new PlaceholderContent.PlaceholderItem(hazeltonCampus, hazelton));
        campus.add(new PlaceholderContent.PlaceholderItem(hersheyCampus, hershey));
        campus.add(new PlaceholderContent.PlaceholderItem(lehighValleyCampus, lehighValley));
        campus.add(new PlaceholderContent.PlaceholderItem(montAltoCampus, montAlto));
        campus.add(new PlaceholderContent.PlaceholderItem(newKensingtonCampus, newKensington));
        campus.add(new PlaceholderContent.PlaceholderItem(schuylkillCampus, schuylkill));
        campus.add(new PlaceholderContent.PlaceholderItem(scrantonCampus, scranton));
        campus.add(new PlaceholderContent.PlaceholderItem(shenangoCampus, shenango));
        campus.add(new PlaceholderContent.PlaceholderItem(universityParkCampus, universityPark));
        campus.add(new PlaceholderContent.PlaceholderItem(wilkesBarreCampus, wilkesBarre));
        campus.add(new PlaceholderContent.PlaceholderItem(williamsportCampus, williamsport));
        campus.add(new PlaceholderContent.PlaceholderItem(yorkCampus, york));

        // Add more courses as needed.
        return campus;
    }
}