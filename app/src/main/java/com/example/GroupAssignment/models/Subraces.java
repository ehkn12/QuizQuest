package com.example.GroupAssignment.models;

import androidx.room.Ignore;

public class Subraces
{
    private String traits;
    @Ignore
    private Asi[] asi;

    private String document__slug;

    private String name;

    private String document__title;

    private String asi_desc;

    private String slug;

    private String desc;



    public String getTraits ()
    {
        return traits;
    }

    public void setTraits (String traits)
    {
        this.traits = traits;
    }

    public Asi[] getAsi ()
    {
        return asi;
    }

    public void setAsi (Asi[] asi)
    {
        this.asi = asi;
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

    public String getDocument__title ()
    {
        return document__title;
    }

    public void setDocument__title (String document__title)
    {
        this.document__title = document__title;
    }

    public String getAsi_desc ()
    {
        return asi_desc;
    }

    public void setAsi_desc (String asi_desc)
    {
        this.asi_desc = asi_desc;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }

    public String getDesc ()
    {
        return desc;
    }

    public void setDesc (String desc)
    {
        this.desc = desc;
    }

}
