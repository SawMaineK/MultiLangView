package com.smk.funny.database.models;

import java.io.Serializable;

/**
 * Created by SMK on 9/23/2016.
 */
public class Lang implements Serializable{
    private Integer id;
    private String name;
    private String translateText;
    private String translatedText;

    public Lang() {
    }

    public Lang(String name, String translateText, String translatedText) {
        this.name = name;
        this.translateText = translateText;
        this.translatedText = translatedText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranslateText() {
        return translateText;
    }

    public void setTranslateText(String translateText) {
        this.translateText = translateText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", translateText='" + translateText + '\'' +
                ", translatedText='" + translatedText + '\'' +
                '}';
    }
}
