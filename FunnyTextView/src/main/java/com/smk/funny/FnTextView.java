package com.smk.funny;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.smk.funny.database.DatabaseManager;
import com.smk.funny.database.controller.LangController;
import com.smk.funny.database.models.Lang;

/**
 * Created by SMK on 10/12/2016.
 */

public class FnTextView extends TextView{


    public FnTextView(Context context) {
        super(context);
        init(context);
    }

    public FnTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FnTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        final DatabaseManager<Lang> databaseManager = new LangController(context);
        if(FnConfigs.getInstance().getLocale() != null){
            Lang lang = databaseManager.find(FnConfigs.getInstance().getLocale().toString(), getText().toString());
            if (lang != null && lang.getTranslatedText().length() > 0) {
                setText(lang.getTranslatedText());
            } else {
                MSTranslator translate = new MSTranslator(context, getText().toString());
                translate.setOnCallbacks(new MSTranslator.Callbacks() {
                    @Override
                    public void translated(String text) {
                        if (!text.contains("Translate Error =>") && !text.contains("TranslateApiException:") && !text.contains("Azure Market Place Translator Subscription")) {
                            databaseManager.save(new Lang(FnConfigs.getInstance().getLocale().toString(), getText().toString(), text));
                            setText(text);
                        }else{
                            setText(text);
                        }
                    }
                });
                translate.execute();
            }
        }else{
            setText("Translate Error => Invalid Locale!");
        }

    }


}
