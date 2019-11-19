package com.example.GroupAssignment.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GroupAssignment.Adapters.InformationRecyclerAdapter;
import com.example.GroupAssignment.R;

import java.util.ArrayList;
import java.util.List;


public class InformationFragment extends Fragment {

    public TextView spells;
    public TextView weapons;
    public TextView classes;

    public String infoType;

    public List<String> infoList;

    private RecyclerView informationRecycler;
    private RecyclerView.LayoutManager informationLayoutManager;
    private RecyclerView.Adapter informationAdapter;


    public InformationFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_information, container, false);

        infoList = setInfoList();

        informationRecycler = view.findViewById(R.id.infoListRecycler);

        informationLayoutManager = new LinearLayoutManager(view.getContext());
        informationRecycler.setLayoutManager(informationLayoutManager);

        informationAdapter = new InformationRecyclerAdapter(infoList);
        informationRecycler.setAdapter(informationAdapter);
        
        return view;
    }

    public List<String> setInfoList() {

        List<String> infos = new ArrayList<String>();

        infos.add("Spells");
        infos.add("Monsters");
        infos.add("Documents");
        infos.add("Backgrounds");
        infos.add("Planes");
        infos.add("Sections");
        infos.add("Feats");
        infos.add("Conditions");
        infos.add("Races");
        infos.add("Classes");
        infos.add("Magic Items");
        infos.add("Weapons");
        infos.add("Search");

        return infos;
    }




}
