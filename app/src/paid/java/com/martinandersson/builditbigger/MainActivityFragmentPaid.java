package com.martinandersson.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragmentPaid extends Fragment {

    public static final String TAG = MainActivityFragmentPaid.class.getSimpleName();

    public MainActivityFragmentPaid() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_paid, container, false);
        Log.d(TAG, "onCreateView FREE");
        return root;
    }
}
