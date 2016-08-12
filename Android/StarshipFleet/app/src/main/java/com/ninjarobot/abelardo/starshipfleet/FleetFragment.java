package com.ninjarobot.abelardo.starshipfleet;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ninjarobot.abelardo.starshipfleet.Utilities.HttpUtils;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FleetFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String TAG = FleetFragment.class.getName();

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String EXTRA_INFO = "com.ninjarobot.abelardo.starshipfleet";
    private OnFragmentInteractionListener mListener;

    //Dataset declaration StarShip(String name, String model, String manufacturer, int capacity)
    private List<StarShip> myDataset = new ArrayList<StarShip>();
    //private String[] myDataset = new String[] {"X-Wing", "Millenium Falcon", "Star Destroyer", "DeathStar", "Radiant VII", "TIE Fighter"};

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load data

    }

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

    public List<StarShip> getDataset(){
        return myDataset;
    }

    public void setMyDataset(List<StarShip> myDataset) {
        this.myDataset = myDataset;
    }
}




