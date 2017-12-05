package com.example.user.fuck;

/**
 * Created by user on 2017-12-06.
 */

public class Musical {

    private int _id;
    private String _musicalname;
    private String _summary;

    public Musical() {
    }

    public Musical(int id, String musicalname, String summary) {
        this._id = id;
        this._musicalname = musicalname;
        this._summary = summary;
    }

    public Musical(String musicalname, String summary) {
        this._musicalname = musicalname;
        this._summary = summary;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setMusicalName(String musicalname) {
        this._musicalname = musicalname;
    }

    public String getMusicalName() {
        return this._musicalname;
    }

    public void setSummary(String summary) {
        this._summary = summary;
    }

    public String getSummary() {
        return this._summary;
    }
}
