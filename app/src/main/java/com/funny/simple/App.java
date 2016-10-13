package com.funny.simple;

import android.app.Application;

import com.memetix.mst.language.Language;
import com.smk.funny.FnConfigs;

/**
 * Created by SMK on 10/12/2016.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        FnConfigs fnConfigs = FnConfigs.getInstance();
        fnConfigs.setMsClientId("smk_461990");
        fnConfigs.setMsClientSecret("bcVj4udm0Zm+rLxwEf+n654aqVv6rhb7SMS9QSY8Tyo=");
        FnConfigs.getInstance().setLocale(Language.JAPANESE);

    }
}
