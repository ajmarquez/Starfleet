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

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.ViewHolder> {

    private List<StarShip> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView mNameView;
        public TextView mModelView;
        public TextView mManufaturerView;
        public TextView mCapacityView;

        private final Context context;
        private ExecutorService executor = Executors.newSingleThreadExecutor();


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

            HttpUtils mUtils = new HttpUtils();


            //HttpUtils.CheckNetworkStatus(context);



//            executor.submit(() -> {
//                try {
//                    mUtils.downloadUrl("http://swapi.co/api/starships/");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
            //Content intent = new Intent(context, DetailActivity.class);
            //context.startActivity(intent);

        }


    }


    public FleetAdapter(List<StarShip> aDataSet) {
        mDataset = aDataSet;
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
        holder.mNameView.setText(mDataset.get(position).getName());
        holder.mModelView.setText(mDataset.get(position).getModel());
        holder.mManufaturerView.setText(mDataset.get(position).getManufacturer());
        holder.mCapacityView.setText(mDataset.get(position).getCapacity());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setDataset(List<StarShip> dataset) {
        mDataset = dataset;
    }
}