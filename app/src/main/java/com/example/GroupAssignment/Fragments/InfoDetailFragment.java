package com.example.GroupAssignment.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.GroupAssignment.AsyncTask.ResultsAsyncTaskDelegate;
import com.example.GroupAssignment.AsyncTask.ResultsRetrieveAsyncTask;
import com.example.GroupAssignment.R;
import com.example.GroupAssignment.ResultsDatabase;
import com.example.GroupAssignment.models.Results;


public class InfoDetailFragment extends Fragment implements ResultsAsyncTaskDelegate {
    private InfoDetailFragment infoDetailFragment = this;

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
    private TextView classDesc;
    private TextView classHitDie;
    private TextView class1stHp;
    private TextView classHpGainPerLvl;
    private TextView classProfArmour;
    private TextView classProfWeapon;
    private TextView classProfTools;
    private TextView classProfSavingThrow;
    private TextView classProfSkills;
    private TextView classEquipment;
    private TextView classTable;
    private TextView classSpellCastingAbility;
    private TextView classSubtype;

    private ResultsDatabase rdb;
    private Results dbReturn;




    public InfoDetailFragment() {
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

                retrieveResultsFromDb(infoName, rdb);

                break;

            case "Weapons":
                view = inflater.inflate(R.layout.weaponlayout, container, false);
                rdb = ResultsDatabase.getInstance(view.getContext());

                retrieveResultsFromDb(infoName, rdb);

                break;

            case "Classes":
                view = inflater.inflate(R.layout.classlayout, container, false);
                rdb = ResultsDatabase.getInstance(view.getContext());

                retrieveResultsFromDb(infoName, rdb);

                break;
        }
        return view;
    }


    @Override
    public void handleResultsReturned(Results results) {

        switch (infoType) {
            case "Spells":

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

                spellName.setText(results.getName());
                spellDesc.setText(results.getDesc());
                spellHighLvl.setText(results.getHigher_level());
                spellRange.setText(results.getRange());
                spellComponents.setText(results.getComponents());
                spellMaterials.setText(results.getMaterial());
                spellRitual.setText(results.getRitual());
                spellDuration.setText(results.getDuration());
                spellConcentration.setText(results.getConcentration());
                spellCastingTime.setText(results.getCasting_time());
                spellLevel.setText(results.getLevel());
                spellIntLvl.setText(results.getLevel_int());
                spellSchool.setText(results.getSchool());
                spellCircle.setText(results.getCircles());


                break;

            case "Weapons":

                weaponName = view.findViewById(R.id.weaponName);
                weaponCategory = view.findViewById(R.id.weaponCategory);
                weaponCost = view.findViewById(R.id.weaponCost);
                weaponDmgDice = view.findViewById(R.id.weaponDmgDice);
                weaponDmgType = view.findViewById(R.id.weaponDmgType);
                weaponWeight = view.findViewById(R.id.weaponWeight);

                weaponName.setText(results.getName());
                weaponCategory.setText(results.getCategory());
                weaponCost.setText(results.getCost());
                weaponDmgType.setText(results.getDamage_type());
                weaponDmgDice.setText(results.getDamage_dice());
                weaponWeight.setText(results.getWeight());
                break;

            case "Classes":

                className = view.findViewById(R.id.className);
                classDesc = view.findViewById(R.id.classDesc);
                classHitDie = view.findViewById(R.id.classHitDie);
                class1stHp = view.findViewById(R.id.class1stLvHp);
                classHpGainPerLvl = view.findViewById(R.id.classHpGainPerLvl);
                classProfArmour = view.findViewById(R.id.classProfArmor);
                classProfWeapon = view.findViewById(R.id.classProfWeapons);
                classProfSavingThrow = view.findViewById(R.id.classProfSaveThrows);
                classProfSkills = view.findViewById(R.id.classProfSkills);
                classProfTools = view.findViewById(R.id.classProfTools);
                classEquipment = view.findViewById(R.id.classEquipment);
                classTable = view.findViewById(R.id.classTable);
                classSpellCastingAbility = view.findViewById(R.id.classSpellcastAb);
                classSubtype = view.findViewById(R.id.classSubtype);


                className.setText(results.getName());
                classDesc.setText(results.getDesc());
                classHitDie.setText(results.getHit_dice());
                class1stHp.setText(results.getHp_at_1st_level());
                classHpGainPerLvl.setText(results.getHp_at_higher_levels());
                classProfArmour.setText(results.getProf_armor());
                classProfWeapon.setText(results.getProf_weapons());
                classProfSavingThrow.setText(results.getProf_saving_throws());
                classProfSkills.setText(results.getProf_skills());
                classProfTools.setText(results.getProf_tools());
                classEquipment.setText(results.getEquipment());
                classTable.setText(results.getTable());
                classSpellCastingAbility.setText(results.getSpellcasting_ability());
                classSubtype.setText(results.getSubtypes_name());
                break;
        }
    }

    public void retrieveResultsFromDb (String string, ResultsDatabase resultsDatabase) {
        ResultsRetrieveAsyncTask resultsRetrieveAsyncTask = new ResultsRetrieveAsyncTask();
        resultsRetrieveAsyncTask.setResultsDatabase(resultsDatabase);
        resultsRetrieveAsyncTask.setDelegate(infoDetailFragment);
        resultsRetrieveAsyncTask.execute(string);
    }

}
