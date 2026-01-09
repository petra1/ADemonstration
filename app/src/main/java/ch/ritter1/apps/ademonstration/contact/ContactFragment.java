package ch.ritter1.apps.ademonstration.contact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.ritter1.apps.ademonstration.databinding.FragmentContactBinding;


public class ContactFragment extends Fragment {
    private FragmentContactBinding binding;


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
        binding = FragmentContactBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.textViewWebsiteUrl.setMovementMethod(LinkMovementMethod.getInstance());
        binding.textViewMail.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}