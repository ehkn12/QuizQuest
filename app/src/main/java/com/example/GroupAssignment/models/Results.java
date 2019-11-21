package com.example.GroupAssignment.models;


// This class contains all the possible responses obtained from the API, each different URL always has Results array of objects
// so I just loaded everything into this class and Gson is smart enough to parse only the properties that are contained within each
// URL

// SO UH YEH THIS CLASS IS GOING TO BE ENORMOUS, TODO currently this class contains properties for Weapons and Spells <-- update it when more are added

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "results")
public class Results
{
    //The properties below are unique to Spells

    private String components;

    private String ritual;

    private String level;

    private String document__license_url;

    private String range;

    private String circles;

    private String concentration;

    private String duration;

    private String archetype;

    private String material;

    private String school;

    private String document__slug;

    @NonNull
    @PrimaryKey
    private String name;

    private String higher_level;

    private String level_int;

    private String page;

    private String document__title;

    private String slug;

    //this is the property for categories e.g. "spells/", "weapons/" and so on..
    private String route;
    private String text;


    // The properties below unique to Weapons
    private String casting_time;

    private String dnd_class;

    private String desc;

    private String damage_type;

    private String cost;

    private String damage_dice;

    private String weight;

    private String category;
    @Ignore
    private String[] properties;


    // The properties below are unique for Classes
    private String prof_skills;

    private String spellcasting_ability;

    private String hp_at_higher_levels;

    private String equipment;

    private String subtypes_name;

    private String hp_at_1st_level;

    private String prof_saving_throws;
    @Ignore
    private Archetypes[] archetypes;

    private String hit_dice;

    private String prof_weapons;

    private String prof_armor;

    private String prof_tools;

    private String table;


    // The below are properties unique to Backgrounds
    private String languages;

    private String tool_proficiencies;

    private String suggested_characteristics;

    private String feature_desc;

    private String feature;

    private String skill_proficiencies;


    // The below are properties unique to Sections
    private String parent;

    //The below are properties unique to Races
    private String speed_desc;

    private String traits;

    private String asi_desc;
    @Ignore
    private Subraces[] subraces;
    @Ignore
    private Speed speed;

    private String vision;

    private String size;
    @Ignore
    private Asi[] asi;

    private String alignment;

    private String age;


    // The below are properties unique to Magic Items
    private String requires_attunement;

    private String type;

    private String rarity;




    public String getRequires_attunement ()
    {
        return requires_attunement;
    }

    public void setRequires_attunement (String requires_attunement)
    {
        this.requires_attunement = requires_attunement;
    }


    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }


    public String getRarity ()
    {
        return rarity;
    }

    public void setRarity (String rarity)
    {
        this.rarity = rarity;
    }


    public String getSpeed_desc ()
    {
        return speed_desc;
    }

    public void setSpeed_desc (String speed_desc)
    {
        this.speed_desc = speed_desc;
    }

    public String getTraits ()
    {
        return traits;
    }

    public void setTraits (String traits)
    {
        this.traits = traits;
    }

    public String getLanguages ()
    {
        return languages;
    }

    public void setLanguages (String languages)
    {
        this.languages = languages;
    }

    public String getAsi_desc ()
    {
        return asi_desc;
    }

    public void setAsi_desc (String asi_desc)
    {
        this.asi_desc = asi_desc;
    }

    public Subraces[] getSubraces ()
    {
        return subraces;
    }

    public void setSubraces (Subraces[] subraces)
    {
        this.subraces = subraces;
    }

    public Speed getSpeed ()
    {
        return speed;
    }

    public void setSpeed (Speed speed)
    {
        this.speed = speed;
    }

    public String getVision ()
    {
        return vision;
    }

    public void setVision (String vision)
    {
        this.vision = vision;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    public Asi[] getAsi ()
    {
        return asi;
    }

    public void setAsi (Asi[] asi)
    {
        this.asi = asi;
    }


    public String getAlignment ()
    {
        return alignment;
    }

    public void setAlignment (String alignment)
    {
        this.alignment = alignment;
    }


    public String getAge ()
    {
        return age;
    }

    public void setAge (String age)
    {
        this.age = age;
    }

    public String getParent ()
    {
        return parent;
    }

    public void setParent (String parent)
    {
        this.parent = parent;
    }


    public String getTool_proficiencies ()
{
    if (tool_proficiencies != null && !tool_proficiencies.isEmpty()) {
        return tool_proficiencies;
    }
    return "Doesn't use tools";
}

    public void setTool_proficiencies (String tool_proficiencies)
    {
        this.tool_proficiencies = tool_proficiencies;
    }


    public String getSuggested_characteristics ()
    {
        return suggested_characteristics;
    }

    public void setSuggested_characteristics (String suggested_characteristics)
    {
        this.suggested_characteristics = suggested_characteristics;
    }

    public String getFeature_desc ()
    {
        return feature_desc;
    }

    public void setFeature_desc (String feature_desc)
    {
        this.feature_desc = feature_desc;
    }

    public String getFeature ()
    {
        return feature;
    }

    public void setFeature (String feature)
    {
        this.feature = feature;
    }


    public String getSkill_proficiencies ()
    {
        return skill_proficiencies;
    }

    public void setSkill_proficiencies (String skill_proficiencies)
    {
        this.skill_proficiencies = skill_proficiencies;
    }


    public String getProf_skills ()
    {
        return prof_skills;
    }

    public void setProf_skills (String prof_skills)
    {
        this.prof_skills = prof_skills;
    }

    public String getSpellcasting_ability ()
    {
        return spellcasting_ability;
    }

    public void setSpellcasting_ability (String spellcasting_ability)
    {
        this.spellcasting_ability = spellcasting_ability;
    }

    public String getHp_at_higher_levels ()
    {
        return hp_at_higher_levels;
    }

    public void setHp_at_higher_levels (String hp_at_higher_levels)
    {
        this.hp_at_higher_levels = hp_at_higher_levels;
    }


    public String getEquipment ()
    {
        return equipment;
    }

    public void setEquipment (String equipment)
    {
        this.equipment = equipment;
    }

    public String getSubtypes_name ()
    {
        return subtypes_name;
    }

    public void setSubtypes_name (String subtypes_name)
    {
        this.subtypes_name = subtypes_name;
    }

    public String getHp_at_1st_level ()
    {
        return hp_at_1st_level;
    }

    public void setHp_at_1st_level (String hp_at_1st_level)
    {
        this.hp_at_1st_level = hp_at_1st_level;
    }

    public String getProf_saving_throws ()
    {
        return prof_saving_throws;
    }

    public void setProf_saving_throws (String prof_saving_throws)
    {
        this.prof_saving_throws = prof_saving_throws;
    }

    public Archetypes[] getArchetypes ()
    {
        return archetypes;
    }

    public void setArchetypes (Archetypes[] archetypes)
    {
        this.archetypes = archetypes;
    }

    public String getHit_dice ()
    {
        return hit_dice;
    }

    public void setHit_dice (String hit_dice)
    {
        this.hit_dice = hit_dice;
    }

    public String getProf_weapons ()
    {
        return prof_weapons;
    }

    public void setProf_weapons (String prof_weapons)
    {
        this.prof_weapons = prof_weapons;
    }


    public String getProf_armor ()
    {
        return prof_armor;
    }

    public void setProf_armor (String prof_armor)
    {
        this.prof_armor = prof_armor;
    }

    public String getProf_tools ()
    {
        return prof_tools;
    }

    public void setProf_tools (String prof_tools)
    {
        this.prof_tools = prof_tools;
    }


    public String getTable ()
    {
        return table;
    }


    public void setTable (String table)
    {
        this.table = table;
    }


    public String getDamage_type ()
    {
        return damage_type;
    }

    public void setDamage_type (String damage_type)
    {
        this.damage_type = damage_type;
    }


    public String getCost ()
    {
        return cost;
    }

    public void setCost (String cost)
    {
        this.cost = cost;
    }


    public String getDamage_dice ()
    {
        return damage_dice;
    }

    public void setDamage_dice (String damage_dice)
    {
        this.damage_dice = damage_dice;
    }


    public String getWeight ()
    {
        return weight;
    }

    public void setWeight (String weight)
    {
        this.weight = weight;
    }


    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }


    public String[] getProperties ()
    {
        return properties;
    }

    public void setProperties (String[] properties)
    {
        this.properties = properties;
    }


    public String getComponents ()
    {
        return components;
    }

    public void setComponents (String components)
    {
        this.components = components;
    }


    public String getRitual ()
    {
        return ritual;
    }

    public void setRitual (String ritual)
    {
        this.ritual = ritual;
    }


    public String getLevel ()
    {
        return level;
    }

    public void setLevel (String level)
    {
        this.level = level;
    }


    public String getDocument__license_url ()
    {
        return document__license_url;
    }

    public void setDocument__license_url (String document__license_url)
    {
        this.document__license_url = document__license_url;
    }

    public String getRange ()
    {
        return range;
    }

    public void setRange (String range)
    {
        this.range = range;
    }


    public String getCircles ()
    {
        return circles;
    }

    public void setCircles (String circles)
    {
        this.circles = circles;
    }


    public String getConcentration ()
    {
        return concentration;
    }

    public void setConcentration (String concentration)
    {
        this.concentration = concentration;
    }


    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }


    public String getArchetype ()
    {
        return archetype;
    }

    public void setArchetype (String archetype)
    {
        this.archetype = archetype;
    }


    public String getMaterial ()
    {
        if (!material.isEmpty()) {
            return material;
        }
        return "No Materials Needed";
    }

    public void setMaterial (String material)
    {
        this.material = material;
    }


    public String getSchool ()
    {
        return school;
    }

    public void setSchool (String school)
    {
        this.school = school;
    }


    public String getDocument__slug ()
    {
        return document__slug;
    }

    public void setDocument__slug (String document__slug)
    {
        this.document__slug = document__slug;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getHigher_level ()
    {
        return higher_level;
    }

    public void setHigher_level (String higher_level)
    {
        this.higher_level = higher_level;
    }

    public String getLevel_int ()
    {
        return level_int;
    }

    public void setLevel_int (String level_int)
    {
        this.level_int = level_int;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getDocument__title ()
    {
        return document__title;
    }

    public void setDocument__title (String document__title) {
        this.document__title = document__title;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }

    public String getCasting_time ()
    {
        return casting_time;
    }

    public void setCasting_time (String casting_time)
    {
        this.casting_time = casting_time;
    }

    public String getDnd_class ()
    {
        return dnd_class;
    }

    public void setDnd_class (String dnd_class)
    {
        this.dnd_class = dnd_class;
    }

    public String getDesc ()
    {
        return desc;
    }

    public void setDesc (String desc)
    {
        this.desc = desc;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
