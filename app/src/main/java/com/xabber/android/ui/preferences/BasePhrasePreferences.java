package com.xabber.android.ui.preferences;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.xabber.android.data.message.phrase.Phrase;
import com.xabber.android.ui.helper.BarPainter;
import com.xabber.android.ui.helper.ManagedActivity;
import com.xabber.androiddev.R;

public abstract class BasePhrasePreferences extends ManagedActivity
        implements PhraseEditorFragment.OnPhraseEditorFragmentInteractionListener {

    private Phrase phrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_preferences);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_default);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BarPainter barPainter = new BarPainter(this, toolbar);
        barPainter.setDefaultColor();

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.preferences_activity_container, new PhraseEditorFragment()).commit();
        }
    }

    @Override
    public Phrase getPhrase() {
        return phrase;
    }

    @Override
    public void setPhrase(Phrase phrase) {
        this.phrase = phrase;
    }
}
