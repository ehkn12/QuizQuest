package com.example.GroupAssignment.Models;


// This class contains all the possible responses obtained from the API, each different URL always has Results array of objects
// so I just loaded everything into this class and Gson is smart enough to parse only the properties that are contained within each
// URL

// SO UH YEH THIS CLASS IS GOING TO BE ENORMOUS, TODO currently this class contains properties for Weapons and Spells <-- update it when more are added

public class Results
{
    //The properties below are for Spells

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

    private String text;

    // If we want to put Results in a RoomDB should we use name as the primary key?
    private String name;

    private String higher_level;

    private String level_int;

    private String page;

    private String document__title;

    private String slug;

    private String route;


    // The properties below are for Weapons, weapons have some similar properties as Spells, like name and document stuff.
    private String casting_time;

    private String dnd_class;

    private String desc;

    private String damage_type;

    private String cost;

    private String damage_dice;

    private String weight;

    private String category;

    private String[] properties;



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
        return material;
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
