package com.myapplicationdev.android.p04_revisionnotes;

public class Note {

	//What's here?
    private int id;
    private String note_Content;
    private int stars;

    public Note(int id, String note_Content, int stars) {
        this.id = id;
        this.note_Content = note_Content;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote_Content() {
        return note_Content;
    }

    public void setNote_Content(String note_Content) {
        this.note_Content = note_Content;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
