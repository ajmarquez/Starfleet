package com.ninjarobot.abelardo.starshipfleet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ninjarobot.abelardo.starshipfleet.Utilities.HttpUtils;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import org.w3c.dom.Text;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.ViewHolder> {

    private StarShip[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView mNameView;
        public TextView mModelView;
        public TextView mManufaturerView;
        public TextView mCapacityView;

        private final Context context;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            mNameView = (TextView) v.findViewById(R.id.starship_name);
            mModelView = (TextView) v.findViewById(R.id.starship_model);
            mManufaturerView = (TextView) v.findViewById(R.id.starship_manufacturer);
            mCapacityView = (TextView) v.findViewById(R.id.starship_capacity);
            context = v.getContext();
        }

        @Override
        public void onClick(View view) {
            Log.d("TEST", "You just touched my buttons");


            HttpUtils.CheckNetworkStatus(context);

            Intent intent = new Intent(context, DetailActivity.class);
            context.startActivity(intent);

        }


    }


    public FleetAdapter(StarShip[] mydataset) {
        mDataset = mydataset;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View gets created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_starship, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mNameView.setText(mDataset[position].getName());
        holder.mModelView.setText(mDataset[position].getModel());
        holder.mManufaturerView.setText(mDataset[position].getManufacturer());
        holder.mCapacityView.setText(mDataset[position].getCapacity());
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}