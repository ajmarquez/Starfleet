package com.ninjarobot.abelardo.starshipfleet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.ViewHolder> {

    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView mTextView;
        private final Context context;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            mTextView = (TextView) v.findViewById(R.id.starship_name);
            context = v.getContext();
        }

        @Override
        public void onClick(View view) {
            Log.d("TEST", "You just touched my buttons");

            Intent intent = new Intent(context, Detail.class);
            context.startActivity(intent);

        }


    }


    public FleetAdapter(String[] mydataset) {
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
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}