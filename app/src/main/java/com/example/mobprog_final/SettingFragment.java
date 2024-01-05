package com.example.mobprog_final;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import androidx.annotation.Nullable;

public class SettingFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        addPreferencesFromResource(R.xml.preferences);
//
//        ListPreference fontSizePreference = (ListPreference) findPreference("list_preference_font_size");
//
//        fontSizePreference.setSummary(fontSizePreference.getEntry());
//
//        fontSizePreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//            @Override
//            public boolean onPreferenceChange(Preference preference, Object newValue) {
//                String stringValue = newValue.toString();
//                fontSizePreference.setSummary(stringValue);
//
//                return true;
//            }
//        });
    }
}
