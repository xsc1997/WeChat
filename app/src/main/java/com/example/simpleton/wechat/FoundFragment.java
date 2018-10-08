package com.example.simpleton.wechat;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FoundFragment extends Fragment {


    public FoundFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance(String param1, String param2) {
        FoundFragment fragment = new FoundFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_found, container, false);
    }
}
