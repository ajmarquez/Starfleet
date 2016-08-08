package com.ninjarobot.abelardo.starshipfleet;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

public class FleetFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String TAG = FleetFragment.class.getName();

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String EXTRA_INFO = "com.ninjarobot.abelardo.starshipfleet";
    private OnFragmentInteractionListener mListener;

    //Dataset declaration StarShip(String name, String model, String manufacturer, int capacity)
    private StarShip[] myDataset = new StarShip[]{
            new StarShip("X-Wing", "Premium", "Rebels Inc", "4"),
            new StarShip("Millenium Falcon", "Original", "Han Solo", "100"),
            new StarShip("Star Destroyer", "Premium", "The Republic", "2000"),
            new StarShip("DeathStar", "Unique", "The Republic", "10000"),
            new StarShip("Radiant VII", "Regular", "Droid Bros", "300"),
            new StarShip("TIE Fighter", "Regular", "The Rebels", "4")
    };
    //private String[] myDataset = new String[] {"X-Wing", "Millenium Falcon", "Star Destroyer", "DeathStar", "Radiant VII", "TIE Fighter"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Set RecyclerView
        View v = inflater.inflate(R.layout.fragment_fleet, container, false);
        // Recycler view
        mRecycler = (RecyclerView) v.findViewById(R.id.recycler);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLayoutManager);

        //RecyclerView Adapter
        mAdapter = new FleetAdapter(myDataset);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setHasFixedSize(true);

        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

    public StarShip[] getDataset(){
        return myDataset;
    }
}




