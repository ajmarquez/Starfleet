package com.ninjarobot.abelardo.starshipfleet.Utilities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by ajmarquez on 19/08/16.
 */
public class FleetRetainFragment<T> extends Fragment {
    public T data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public static <T> FleetRetainFragment<T> findOrCreate(FragmentManager fm, String tag){

        FleetRetainFragment<T> retainFragment = (FleetRetainFragment<T>) fm.findFragmentByTag(tag);

        if(retainFragment == null){
            retainFragment = new FleetRetainFragment<>();
            fm.beginTransaction()
                    .add(retainFragment,tag)
                    .commitAllowingStateLoss();
        }
        return retainFragment;
    }
}
