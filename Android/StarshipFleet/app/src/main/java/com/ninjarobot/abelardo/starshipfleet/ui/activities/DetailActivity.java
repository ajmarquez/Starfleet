package com.ninjarobot.abelardo.starshipfleet.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ninjarobot.abelardo.starshipfleet.R;
import com.ninjarobot.abelardo.starshipfleet.utils.FleetConstants;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

public class DetailActivity<T> extends AppCompatActivity {

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nameTV = (TextView) findViewById(R.id.starship_name_detail);
        TextView modelTV = (TextView) findViewById(R.id.starship_model_detail);
        TextView manufacturerTV = (TextView) findViewById(R.id.starship_manufacturer_detail);
        TextView capacityTV = (TextView) findViewById(R.id.starship_capacity_detail);

        Intent intent = getIntent();
        StarShip data =  intent.getBundleExtra(FleetConstants.DETAIL_INTENT).getParcelable(FleetConstants.PARCELABLE);

        nameTV.setText(data.getName());
        modelTV.setText(data.getModel());
        manufacturerTV.setText(data.getManufacturer());
        capacityTV.setText(data.getCapacity());

    }

    public void detailIntent(Context context, Bundle bundle){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(FleetConstants.DETAIL_INTENT, bundle);
        context.startActivity(intent);
    }
}
