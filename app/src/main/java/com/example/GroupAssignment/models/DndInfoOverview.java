package com.example.GroupAssignment.models;


public class DndInfoOverview
{

    private String count;

    private Results[] results;


    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public Results[] getSpells() {
        return results;
    }

    public void setSpells(Results[] results) {
        this.results = results;
    }
}
