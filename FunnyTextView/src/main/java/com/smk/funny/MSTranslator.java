package com.smk.funny;

import android.content.Context;
import android.os.AsyncTask;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

/**
 * Created by SMK on 10/9/2016.
 */

public class MSTranslator extends AsyncTask<Void, Void, Void>{


    Context mContent;
    Callbacks mCallback;
    String translateText = "";
    String translatedText = "";

    public MSTranslator(Context context,String text){
        this.mContent = context;
        this.translateText = text;
    }
    @Override
    protected Void doInBackground(Void... params) {
        // TODO Auto-generated method stub
        try {
            if(FnConfigs.getInstance().getLocale() != null){
                Language language = FnConfigs.getInstance().getLocale();
                if(language != null){
                    translatedText = translate(translateText, language);
                }else{
                    translatedText = "Translate Error => Invalid Locale!";
                }
            }else{
                translatedText = "Translate Error => Invalid Locale!";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            translatedText = "Translate Error => "+ e.toString();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        if(mCallback != null){
            mCallback.translated(translatedText);
        }
        super.onPostExecute(result);
    }

    public void setOnCallbacks(Callbacks callbacks){
        this.mCallback = callbacks;
    }

    public interface Callbacks{
        void translated(String text);
    }

    private String translate(String text, Language toLang) throws Exception{

        // Set the Client ID / Client Secret once per JVM. It is set statically and applies to all services
        Translate.setClientId(FnConfigs.getInstance().getMsClientId()); //Change this
        Translate.setClientSecret(FnConfigs.getInstance().getMsClientSecret()); //change

        return Translate.execute(text, toLang);
    }


}
