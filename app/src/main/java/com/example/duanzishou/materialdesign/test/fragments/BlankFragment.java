package com.example.duanzishou.materialdesign.test.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.duanzishou.materialdesign.R;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment {


    private View view;
    private GridView mGridview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);

        mGridview = (GridView) view.findViewById(R.id.gridview);
        List<Integer> mlist=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mlist.add(R.mipmap.ic_launcher);
        }
        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(getActivity(),android.R.layout.simple_list_item_1,mlist);

        mGridview.setAdapter(adapter);
        return view;
    }




}
