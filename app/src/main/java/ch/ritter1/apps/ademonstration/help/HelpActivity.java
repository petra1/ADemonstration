package ch.ritter1.apps.ademonstration.help;

import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import ch.ritter1.apps.ademonstration.R;

public class HelpActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        webView = findViewById(R.id.webView3);
        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                webView.loadUrl ("file:///android_asset/" + getString (R.string.dark_mode_usage_html));
                break;
            case  Configuration.UI_MODE_NIGHT_NO:
                webView.loadUrl ("file:///android_asset/" + getString (R.string.usage_html));
                break;
        }





    }
}