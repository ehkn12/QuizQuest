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

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoDetailFragment extends Fragment {
    private View view;
    private String infoName;
    private String infoType;

    private TextView spellName;
    private TextView spellDesc;
    private TextView spellHighLvl;
    private TextView spellRange;
    private TextView spellComponents;
    private TextView spellMaterials;
    private TextView spellRitual;
    private TextView spellDuration;
    private TextView spellConcentration;
    private TextView spellCastingTime;
    private TextView spellLevel;
    private TextView spellIntLvl;
    private TextView spellSchool;
    private TextView spellCircle;



    private TextView weaponName;
    private TextView weaponCategory;
    private TextView weaponCost;
    private TextView weaponDmgDice;
    private TextView weaponDmgType;
    private TextView weaponWeight;

    private TextView className;

    private TextView backgroundName;

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
                spellHighLvl = view.findViewById(R.id.spellHighLvl);
                spellRange = view.findViewById(R.id.spellRange);
                spellComponents = view.findViewById(R.id.spellComponents);
                spellMaterials = view.findViewById(R.id.spellMaterials);
                spellRitual = view.findViewById(R.id.spellRitualCheck);
                spellDuration = view.findViewById(R.id.spellDuration);
                spellConcentration = view.findViewById(R.id.spellConcentrationCheck);
                spellCastingTime = view.findViewById(R.id.spellCastingTIme);
                spellLevel = view.findViewById(R.id.spellLevel);
                spellIntLvl = view.findViewById(R.id.spellIntLevel);
                spellSchool = view.findViewById(R.id.spellSchool);
                spellCircle = view.findViewById(R.id.spellCircles);

                spellName.setText(dbReturn.getName());
                spellDesc.setText(dbReturn.getDesc());
                spellHighLvl.setText(dbReturn.getHigher_level());
                spellRange.setText(dbReturn.getRange());
                spellComponents.setText(dbReturn.getComponents());
                spellMaterials.setText(dbReturn.getMaterial());
                spellRitual.setText(dbReturn.getRitual());
                spellDuration.setText(dbReturn.getDuration());
                spellConcentration.setText(dbReturn.getConcentration());
                spellCastingTime.setText(dbReturn.getCasting_time());
                spellLevel.setText(dbReturn.getLevel());
                spellIntLvl.setText(dbReturn.getLevel_int());
                spellSchool.setText(dbReturn.getSchool());
                spellCircle.setText(dbReturn.getCircles());

                break;

            case "Weapons":
                view = inflater.inflate(R.layout.weaponlayout, container, false);

                rdb = ResultsDatabase.getInstance(view.getContext());
                dbReturn = rdb.dndInfoDao().getResult(infoName);

                weaponName = view.findViewById(R.id.weaponName);
                weaponCategory = view.findViewById(R.id.weaponCategory);
                weaponCost = view.findViewById(R.id.weaponCategory);
                weaponDmgDice = view.findViewById(R.id.weaponCategory);
                weaponDmgType = view.findViewById(R.id.weaponCategory);
                weaponWeight = view.findViewById(R.id.weaponCategory);

                weaponName.setText(dbReturn.getName());
                weaponCategory.setText(dbReturn.getCategory());


                break;

            case "Classes":
                view = inflater.inflate(R.layout.classlayout, container, false);

                rdb = ResultsDatabase.getInstance(view.getContext());
                dbReturn = rdb.dndInfoDao().getResult(infoName);

                className = view.findViewById(R.id.className);
                className.setText(dbReturn.getName());
                break;

            case "Backgrounds":
                view = inflater.inflate(R.layout.backgroundslayout, container, false);

                rdb = ResultsDatabase.getInstance(view.getContext());
                dbReturn = rdb.dndInfoDao().getResult(infoName);

                backgroundName = view.findViewById(R.id.backgroundName);
                backgroundName.setText(dbReturn.getName());
                break;
        }
        return view;
    }


}
