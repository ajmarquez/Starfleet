package com.ninjarobot.abelardo.starshipfleet.ui.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ninjarobot.abelardo.starshipfleet.R;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.ViewHolder> {

    private List<StarShip> dataset;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nameTV;
        public TextView modelTV;
        public TextView manufacturerTV;
        public TextView capacityTV;
        private final Context context;


        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            nameTV = (TextView) v.findViewById(R.id.starship_name);
            modelTV = (TextView) v.findViewById(R.id.starship_model);
            manufacturerTV = (TextView) v.findViewById(R.id.starship_manufacturer);
            capacityTV = (TextView) v.findViewById(R.id.starship_capacity);
            context = v.getContext();
        }

        @Override
        public void onClick(View view) {
            Log.d("TEST", "You just touched my buttons");
        }
    }


    public FleetAdapter(List<StarShip> dataset) {
        this.dataset = dataset;
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
        holder.nameTV.setText(dataset.get(position).getName());
        holder.modelTV.setText(dataset.get(position).getModel());
        holder.manufacturerTV.setText(dataset.get(position).getManufacturer());
        holder.capacityTV.setText(dataset.get(position).getCapacity());
    }



    @Override
    public int getItemCount() {
        if (dataset == null) {
            return 0;
        } else {
            return dataset.size();
        }
    }

    public void setDataset(List<StarShip> dataset) {
        this.dataset = dataset;
    }
}