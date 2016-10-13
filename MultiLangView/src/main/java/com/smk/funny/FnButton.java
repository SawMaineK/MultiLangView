package com.smk.funny;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.smk.funny.database.DatabaseManager;
import com.smk.funny.database.controller.LangController;
import com.smk.funny.database.models.Lang;

/**
 * Created by SMK on 10/12/2016.
 */

public class FnButton extends Button{


    public FnButton(Context context) {
        super(context);
    }

    public FnButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FnButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(final CharSequence text, final BufferType type) {
        super.setText(text, type);
        final DatabaseManager<Lang> databaseManager = new LangController(getContext());
        if(FnConfigs.getInstance().getLocale() != null){
            if(text.length() > 0){
                final Lang lang = databaseManager.find(FnConfigs.getInstance().getLocale().toString(), text.toString());
                if (lang != null && lang.getTranslatedText() != null && lang.getTranslatedText().length() > 0) {
                    super.setText(lang.getTranslatedText(), type);
                } else {
                    MSTranslator translate = new MSTranslator(getContext(), text.toString());
                    translate.setOnCallbacks(new MSTranslator.Callbacks() {
                        @Override
                        public void translated(String translatedText) {
                            if (!translatedText.contains("Translate Error =>") && !translatedText.contains("TranslateApiException:") && !translatedText.contains("Azure Market Place Translator Subscription")) {
                                Lang lang = databaseManager.find(FnConfigs.getInstance().getLocale().toString(), text.toString());
                                if(lang != null) {
                                    lang.setTranslatedText(translatedText);
                                    databaseManager.update(lang);
                                }else {
                                    databaseManager.save(new Lang(FnConfigs.getInstance().getLocale().toString(), text.toString(), translatedText));
                                }
                                FnButton.super.setText(translatedText, type);
                            }else{
                                FnButton.super.setText(translatedText, type);
                            }
                        }
                    });
                    translate.execute();
                }
            }
        }else{
            FnButton.super.setText("Translate Error => Invalid Locale!", type);
        }
    }


}
