package com.example.danielspeixoto.memories;

/**
 * Created by danielspeixoto on 18/09/16.
 */
public class Memory {

    private String title;
    private String description;

    public Memory(String title, String description) {

        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title;
    }

}
