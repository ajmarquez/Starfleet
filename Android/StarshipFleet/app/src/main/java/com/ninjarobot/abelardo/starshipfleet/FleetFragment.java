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

public class FleetFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String TAG = FleetFragment.class.getName();

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String EXTRA_INFO = "com.ninjarobot.abelardo.starshipfleet";
    private String[] myDataset = new String[] {"X-Wing", "Millenium Falcon", "Star Destroyer", "DeathStar", "Radiant VII", "TIE Fighter"};
    private OnFragmentInteractionListener mListener;

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
}




