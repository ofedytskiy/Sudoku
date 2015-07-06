package com.example.oleg.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by Oleg on 06.07.2015.
 */
public class SettingsActivity extends Activity implements View.OnClickListener {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings_activity);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

        }
    }


}
