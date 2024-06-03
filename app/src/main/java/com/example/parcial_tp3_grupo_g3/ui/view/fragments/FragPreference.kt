package com.example.parcial_tp3_grupo_g3.ui.view.fragments
import android.content.res.Configuration
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.NightMode
import androidx.preference.PreferenceFragmentCompat
import com.example.parcial_tp3_grupo_g3.R
import androidx.preference.SwitchPreference


class FragPreference {


    class FragPreference : PreferenceFragmentCompat() {

        companion object {
            fun newInstance() = FragPreference()
        }

        //private val viewModel: PreferenceViewModel by viewModels()

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.preferencescreen, rootKey)

            val nightMode = findPreference<SwitchPreference>(getString(R.string.modo_oscuro));
            nightMode?.setDefaultValue(false)
            nightMode?.setOnPreferenceChangeListener { _, newValue ->
                if (newValue == true) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                true
            }
        }
    }
}