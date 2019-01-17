package com.shivam.uber.Model;

public class Setting {

    private String Name;
    private String Phone;
    private int Photo;

    public Setting() {

    }

    public Setting(String name, int photo) {
        Name = name;
        Photo = photo;
    }

    // Getter

    public String getName() {
        return Name;
    }


    public int getPhoto() {
        return Photo;
    }

    // Setter

    public void setName(String name) {
        Name = name;
    }


    public void setPhoto(int photo) {
        Photo = photo;
    }
}
