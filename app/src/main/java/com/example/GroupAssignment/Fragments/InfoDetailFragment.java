package com.example.GroupAssignment.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.GroupAssignment.R;
import com.example.GroupAssignment.ResultsDatabase;
import com.example.GroupAssignment.models.Results;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoDetailFragment extends Fragment {
    private View view;
    private String infoName;
    private String infoType;

    private TextView spellName;
    private TextView spellDesc;
    private TextView weaponName;
    private TextView weaponCategory;

    private ResultsDatabase rdb;
    private Results dbReturn;



    public InfoDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        infoName = bundle.getString("InfoName");
        infoType = bundle.getString("InfoType");

        switch (infoType) {
            case "Spells":
                view = inflater.inflate(R.layout.spelllayout, container, false);

                rdb = ResultsDatabase.getInstance(view.getContext());
                dbReturn = rdb.dndInfoDao().getResult(infoName);

                spellName = view.findViewById(R.id.spellName);
                spellDesc = view.findViewById(R.id.spellDesc);

                spellName.setText(dbReturn.getName());
                spellDesc.setText(dbReturn.getDesc());
                break;

            case "Weapons":
                view = inflater.inflate(R.layout.weaponlayout, container, false);

                rdb = ResultsDatabase.getInstance(view.getContext());
                dbReturn = rdb.dndInfoDao().getResult(infoName);

                weaponName = view.findViewById(R.id.weaponName);
                weaponCategory = view.findViewById(R.id.weaponCat);

                weaponName.setText(dbReturn.getName());
                weaponCategory.setText(dbReturn.getCategory());
                break;

        }
        return view;
    }


}
