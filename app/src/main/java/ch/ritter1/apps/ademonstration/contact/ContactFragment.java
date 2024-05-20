package ch.ritter1.apps.ademonstration.contact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ch.ritter1.apps.ademonstration.R;


public class ContactFragment extends Fragment {
    View v;
    TextView webSiteUrl;
    TextView gitHubUrl;
    TextView mail;


    public ContactFragment() {
            // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_contact, container, false);
        webSiteUrl = v.findViewById(R.id.textView_website_url);
        gitHubUrl = v.findViewById(R.id.textView_GitHup_url);
        mail = v.findViewById(R.id.textView_mail);

        webSiteUrl.setMovementMethod(LinkMovementMethod.getInstance());
        gitHubUrl.setMovementMethod(LinkMovementMethod.getInstance());
        mail.setMovementMethod(LinkMovementMethod.getInstance());

        return v;
    }

}