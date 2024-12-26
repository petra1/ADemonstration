package ch.ritter1.apps.ademonstration.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ch.ritter1.apps.ademonstration.BuildConfig;
import ch.ritter1.apps.ademonstration.R;


public class AboutFragment extends Fragment {
    View v;
    TextView appName;
    TextView versionName;
    TextView versionCode;


    TextView  gitHubUrl;


    public AboutFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       v = inflater.inflate(R.layout.fragment_about, container, false);
        gitHubUrl = v.findViewById(R.id.textView_GitHup_url);
       appName = v.findViewById(R.id.textView_app_name);
        versionName = v.findViewById(R.id.textView_app_vers);
       versionCode = v.findViewById(R.id.textView_build_no);


        appName.setText(getResources().getString(R.string.app_name));
        versionName.setText(String.valueOf(BuildConfig.VERSION_NAME));
        versionCode.setText(String.valueOf(BuildConfig.VERSION_CODE));
        gitHubUrl.setMovementMethod(LinkMovementMethod.getInstance());
        return v;
    }
}