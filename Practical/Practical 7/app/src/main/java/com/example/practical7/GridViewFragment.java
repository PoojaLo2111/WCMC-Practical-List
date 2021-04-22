package com.example.practical7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridViewFragment extends Fragment {

    public GridViewFragment() {
        // Required empty public constructor
    }

    private GridView gridView1,gridView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        gridView1 = view.findViewById(R.id.GridView1);
        gridView2 = view.findViewById(R.id.GridView2);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.List, android.R.layout.simple_list_item_1);
        gridView1.setAdapter(adapter);
        gridView2.setAdapter(adapter);
    }
}