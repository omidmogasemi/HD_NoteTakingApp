package com.example.notetakingapp;

import com.google.gson.annotations.SerializedName;

// All that this file is is an object representation of a regular note.
// We use GSON to automatically interpret a JSON object and create note objects based on
// each object that it sees into response.body, which can be stored into a list of notes
// in line 41 of MainActivity.java
public class Note {
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
