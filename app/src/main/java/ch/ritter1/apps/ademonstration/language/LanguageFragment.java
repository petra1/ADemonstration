package ch.ritter1.apps.ademonstration.language;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.LocaleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import ch.ritter1.apps.ademonstration.R;


public class LanguageFragment extends Fragment {

    View v;





    public LanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_language, container, false);
        TextView esText = v.findViewById(R.id.text_view_correct_example);
        Locale esLocale = Locale.forLanguageTag("es-MX");
        LocaleSpan esLocaleSpan = new LocaleSpan(esLocale);
        SpannableString esString = new SpannableString(esText.getText());
        esString.setSpan(esLocaleSpan, 0, esString.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        esText.setText(esString);
        // Inflate the layout for this fragment
        return v;
    }
}