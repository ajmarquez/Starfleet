package com.ninjarobot.abelardo.starshipfleet.ui.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ninjarobot.abelardo.starshipfleet.R;
import com.ninjarobot.abelardo.starshipfleet.controllers.FleetController;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import java.util.List;

public class FleetAdapter<T> extends RecyclerView.Adapter<FleetAdapter.ViewHolder> {

    private List<StarShip> dataset;
    private FleetController mFleetController;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nameTV;
        public TextView modelTV;
        public TextView manufacturerTV;
        public TextView capacityTV;
        private final Context context;
        private FleetController controller;
        private List<StarShip> vhdataset;


        public ViewHolder(View v, FleetController controller, List<StarShip> data) {
            super(v);
            v.setOnClickListener(this);
            nameTV = (TextView) v.findViewById(R.id.starship_name);
            modelTV = (TextView) v.findViewById(R.id.starship_model);
            manufacturerTV = (TextView) v.findViewById(R.id.starship_manufacturer);
            capacityTV = (TextView) v.findViewById(R.id.starship_capacity);
            context = v.getContext();
            this.controller = controller;
            vhdataset =  data;
        }

        @Override
        public void onClick(View view) {
//            this.controller.onClickedCell(vhdataset, getAdapterPosition(), context);
            //DetailActivity detail = n
        }
    }


    public FleetAdapter(FleetController controller) {
        this.mFleetController = controller;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View gets created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_starship, parent, false);

        ViewHolder vh = new ViewHolder(v, mFleetController, dataset);
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