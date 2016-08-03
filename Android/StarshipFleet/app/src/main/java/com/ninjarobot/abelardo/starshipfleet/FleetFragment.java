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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FleetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FleetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FleetFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private TextView mTextView;
    private Button mDetailButton;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String EXTRA_INFO = "com.ninjarobot.abelardo.starshipfleet";


    private String[] myDataset = new String[] {"X-Wing", "Millenium Falcon", "Star Destroyer", "DeathStar", "Radiant VII", "TIE Fighter"};


    private OnFragmentInteractionListener mListener;

    public FleetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FleetFragment.
     */

    public static FleetFragment newInstance(String param1, String param2) {
        FleetFragment fragment = new FleetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        //mTextView = (TextView) v.findViewById(R.id.fragment_container);
//        mDetailButton = (Button) v.findViewById(R.id.detail_button);
//        mDetailButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v){
//                Intent i = new Intent(FleetFragment.this.getActivity(), Detail.class);
//                startActivity(i);
//            }
//        });

        //Set RecyclerView
        View v = inflater.inflate(R.layout.fragment_fleet, container, false);
        // Recycler view
        mRecycler = (RecyclerView) v.findViewById(R.id.recycler);
//          mRecycler.setHasFixedSize(true);

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}




