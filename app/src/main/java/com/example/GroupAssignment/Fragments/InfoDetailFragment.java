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
                spellHighLvl.setText("Level Learnt: " + dbReturn.getHigher_level());
                spellRange.setText("Range: " + dbReturn.getRange());
                spellComponents.setText(dbReturn.getComponents());
                spellMaterials.setText("Components: " +dbReturn.getMaterial());
                spellRitual.setText("Ritual: " + dbReturn.getRitual());
                spellDuration.setText("Duration: "+dbReturn.getDuration());
                spellConcentration.setText("Concentration: " + dbReturn.getConcentration());
                spellCastingTime.setText("Casting Time: " +dbReturn.getCasting_time());
                spellLevel.setText("Spell Level: "+dbReturn.getLevel());
                spellIntLvl.setText("Intelligence Level: "+dbReturn.getLevel_int());
                spellSchool.setText("School: "+dbReturn.getSchool());
                spellCircle.setText("Circle: " +dbReturn.getCircles());


                break;

            case "Weapons":
                view = inflater.inflate(R.layout.weaponlayout, container, false);

                rdb = ResultsDatabase.getInstance(view.getContext());
                dbReturn = rdb.dndInfoDao().getResult(infoName);

                weaponName = view.findViewById(R.id.weaponName);
                weaponCategory = view.findViewById(R.id.weaponCategory);
                weaponCost = view.findViewById(R.id.weaponCost);
                weaponDmgDice = view.findViewById(R.id.weaponDmgDice);
                weaponDmgType = view.findViewById(R.id.weaponDmgType);
                weaponWeight = view.findViewById(R.id.weaponWeight);

                weaponName.setText(dbReturn.getName());
                weaponCategory.setText("Category: "+dbReturn.getCategory());
                weaponCost.setText("Cost: "+dbReturn.getCost());
                weaponDmgType.setText("Damage Type: "+ dbReturn.getDamage_type());
                weaponDmgDice.setText("Damage Dice: " + dbReturn.getDamage_dice());
                weaponWeight.setText("Weight: " + dbReturn.getWeight());
                break;

            case "Classes":
                view = inflater.inflate(R.layout.classlayout, container, false);

                rdb = ResultsDatabase.getInstance(view.getContext());
                dbReturn = rdb.dndInfoDao().getResult(infoName);

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

                
                className.setText(dbReturn.getName());
                classDesc.setText(dbReturn.getDesc());
                classHitDie.setText("Hit Die: " + dbReturn.getHit_dice());
                class1stHp.setText("Initial HP: " + dbReturn.getHp_at_1st_level());
                classHpGainPerLvl.setText("HP Gain per Level: " + dbReturn.getHp_at_higher_levels());
                classProfArmour.setText("Armour: " + dbReturn.getProf_armor());
                classProfWeapon.setText("Weapon: " + dbReturn.getProf_weapons());
                classProfSavingThrow.setText("Saving Throw: " + dbReturn.getProf_saving_throws());
                classProfSkills.setText("Skills: " + dbReturn.getProf_skills());
                classProfTools.setText("Tools: " + dbReturn.getProf_tools());
                classEquipment.setText("Equipment: " + dbReturn.getEquipment());
                classTable.setText("Table: " + dbReturn.getTable());
                classSpellCastingAbility.setText("Spell Casting Ability: " + dbReturn.getSpellcasting_ability());
                classSubtype.setText("Subtype: " + dbReturn.getSubtypes_name());
                break;


        }
        return view;
    }


}
