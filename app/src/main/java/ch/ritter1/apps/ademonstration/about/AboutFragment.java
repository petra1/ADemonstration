package ch.ritter1.apps.ademonstration.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ch.ritter1.apps.ademonstration.BuildConfig;
import ch.ritter1.apps.ademonstration.R;
import ch.ritter1.apps.ademonstration.databinding.FragmentAboutBinding;


public class AboutFragment extends Fragment {
    private FragmentAboutBinding binding;


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
       binding = FragmentAboutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.textViewAppName.setText(getResources().getString(R.string.app_name));
        binding.textViewAppVers.setText(BuildConfig.VERSION_NAME);
        binding.textViewBuildNo.setText(String.valueOf(BuildConfig.VERSION_CODE));
        binding.textViewGitHupUrl.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}