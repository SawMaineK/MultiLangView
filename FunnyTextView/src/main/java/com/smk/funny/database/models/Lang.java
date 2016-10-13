package com.smk.funny.database.models;

import java.io.Serializable;

/**
 * Created by SMK on 9/23/2016.
 */
public class Lang implements Serializable{
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

}
