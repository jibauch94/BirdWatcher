package com.example.jibba.birdwatcher.objects;

/**
 * Created by jibba on 12-04-2018.
 */

public class Birds {
    private String created, nameDanish, nameEnglish, photoUrl;
    private int id;

    public Birds(String created, String nameDanish, String nameEnglish, String photoUrl, int id) {
        this.created = created;
        this.nameDanish = nameDanish;
        this.nameEnglish = nameEnglish;
        this.photoUrl = photoUrl;
        this.id = id;
    }
    public Birds(){

    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getNameDanish() {
        return nameDanish;
    }

    public void setNameDanish(String nameDanish) {
        this.nameDanish = nameDanish;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


