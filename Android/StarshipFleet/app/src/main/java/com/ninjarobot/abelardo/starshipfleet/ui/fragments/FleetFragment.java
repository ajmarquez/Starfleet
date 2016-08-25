package com.ninjarobot.abelardo.starshipfleet.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ninjarobot.abelardo.starshipfleet.controllers.FleetController;
import com.ninjarobot.abelardo.starshipfleet.repositories.StarShipRepository;
import com.ninjarobot.abelardo.starshipfleet.ui.views.FleetAdapter;
import com.ninjarobot.abelardo.starshipfleet.R;
import com.ninjarobot.abelardo.starshipfleet.utils.FleetConstants;
import com.ninjarobot.abelardo.starshipfleet.utils.FleetRetainFragment;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import java.util.ArrayList;
import java.util.List;


public class FleetFragment extends Fragment implements FleetController.StarshipsRetrieved{


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String TAG = FleetFragment.class.getName();
    private RecyclerView mRecycler;
    private FleetRetainFragment<StarShip> retainFragment;
    private FleetController controller;
    private FleetAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new FleetController(new StarShipRepository());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(FleetConstants.STATUS_DEBUG, "OnCreateView");
        //Set RecyclerView
        View v = inflater.inflate(R.layout.fragment_fleet, container, false);

        mRecycler = (RecyclerView) v.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLayoutManager);
        mAdapter = new FleetAdapter(controller);
        mRecycler.setAdapter(mAdapter);

        /* FleetRetainFragment code  BEGIN */
        retainFragment = FleetRetainFragment.findOrCreate(getFragmentManager(), FleetConstants.RETAINFRAGMENT);
        /* FleetRetainFragment ENDS*/

        if (savedInstanceState == null) {
            controller.getRepository(this::onStarshipsRetrieved);

        } else {
            mAdapter.setDataset((List<StarShip>) retainFragment.data);
            mRecycler.getAdapter().notifyDataSetChanged();

        }
        return v;
    }


    @Override
    public void onStarshipsRetrieved(List<StarShip> starShips) {
        mAdapter.setDataset(starShips);
        mRecycler.getAdapter().notifyDataSetChanged();
    }

//    @Override
//    public void onStarShipSelected(StarShip starShip) {
//        final Intent intent = new Intent(getActivity(), DetailActivity.class);
//        intent.putExtra("", starShip);
//        startActivity(intent);
//    }


}








