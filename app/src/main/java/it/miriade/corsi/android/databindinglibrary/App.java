package it.miriade.corsi.android.databindinglibrary;

import android.app.Application;

import it.miriade.corsi.android.databindinglibrary.model.DbHelper;

/**
 * Created by roberto on 16/11/16 for project DataBindingLibrary
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize DbHelper singleton instance
        new DbHelper(getApplicationContext());
    }

}
