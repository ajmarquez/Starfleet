package com.ninjarobot.abelardo.starshipfleet.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ninjarobot.abelardo.starshipfleet.ui.views.FleetAdapter;
import com.ninjarobot.abelardo.starshipfleet.network.interfaces.ApiCallback;
import com.ninjarobot.abelardo.starshipfleet.R;
import com.ninjarobot.abelardo.starshipfleet.Utilities.FleetConstants;
import com.ninjarobot.abelardo.starshipfleet.Utilities.FleetRetainFragment;
import com.ninjarobot.abelardo.starshipfleet.network.RESTClient;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import java.util.ArrayList;
import java.util.List;


public class FleetFragment<T> extends Fragment implements ApiCallback {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String TAG = FleetFragment.class.getName();
    private RecyclerView mRecycler;
    private FleetRetainFragment<T> retainFragment;
    private FleetAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<StarShip> dataset = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(FleetConstants.STATUS_DEBUG, "OnCreateView");
        //Set RecyclerView
        View v = inflater.inflate(R.layout.fragment_fleet, container, false);

        mRecycler = (RecyclerView) v.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLayoutManager);
        mAdapter = new FleetAdapter(dataset);
        mRecycler.setAdapter(mAdapter);

        /* FleetRetainFragment code  BEGIN */

        // Finish detail view with recycler on click.
        // refactor the app based on topics we discussed yesterday.
        // Stack and heap, how does method calls work with stack heap, where object get created, where primitives get created
        // Java Collections for beginners.

        retainFragment = FleetRetainFragment.findOrCreate(getManager(), FleetConstants.RETAINFRAGMENT);

        /* FleetRetainFragment ENDS*/

        if (savedInstanceState == null) {
            RESTClient restClient = new RESTClient();
            restClient.getStarships(this);
        } else {
            dataset = (List<StarShip>) retainFragment.data;
//            dataset = savedInstanceState.getParcelableArrayList(FleetConstants.STARSHIP_FLEET);
            mAdapter.setDataset(dataset);
            mRecycler.getAdapter().notifyDataSetChanged();

        }
        return v;
    }

    @Override
    public void shipCallback(List<StarShip> ships) {

        retainFragment.data = (T) ships;
//        dataset = ships;
        mAdapter.setDataset((List<StarShip>) retainFragment.data);
//        mAdapter.setDataset(dataset);
        mRecycler.getAdapter().notifyDataSetChanged();
    }

    public List<StarShip> getDataset(){
        return dataset;
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putParcelableArrayList(FleetConstants.STARSHIP_FLEET, (ArrayList<? extends Parcelable>) dataset);
//    }

    public FragmentManager getManager() {
        return getActivity().getSupportFragmentManager();
    }
}




