package ch.ritter1.apps.ademonstration;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class UsageFragment extends Fragment {

    public UsageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_usage, container, false);
        WebView webView = v.findViewById (R.id.webView2);
        v.setHorizontalScrollBarEnabled(true);
        v.setHorizontalScrollBarEnabled(true);


        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                webView.loadUrl ("file:///android_asset/" + getString (R.string.dark_mode_usage_html));
                break;
            case  Configuration.UI_MODE_NIGHT_NO:
                webView.loadUrl ("file:///android_asset/" + "usage_de.html");
                break;
        }








        return v;

    }}