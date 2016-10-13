package com.smk.funny;

import com.memetix.mst.language.Language;

/**
 * Created by SMK on 10/12/2016.
 */
public class FnConfigs {
    private Language locale;
    private String msClientId;
    private String msClientSecret;
    private boolean enableEnglish;
    private static FnConfigs ourInstance;


    public static FnConfigs getInstance() {

        if(ourInstance != null)
            return ourInstance;
        else
            ourInstance = new FnConfigs();
        return ourInstance;
    }


    private FnConfigs() {
    }

    public FnConfigs(String msClientId, String msClientSecret) {
        this.msClientId = msClientId;
        this.msClientSecret = msClientSecret;
    }

    public Language getLocale() {
        return locale;
    }

    public void setLocale(Language locale) {
        this.locale = locale;
    }

    public String getMsClientId() {
        return msClientId;
    }

    public void setMsClientId(String msClientId) {
        this.msClientId = msClientId;
    }

    public String getMsClientSecret() {
        return msClientSecret;
    }

    public void setMsClientSecret(String msClientSecret) {
        this.msClientSecret = msClientSecret;
    }

    public boolean isEnableEnglish() {
        return enableEnglish;
    }

    public void setEnableEnglish(boolean enableEnglish) {
        this.enableEnglish = enableEnglish;
    }
}
