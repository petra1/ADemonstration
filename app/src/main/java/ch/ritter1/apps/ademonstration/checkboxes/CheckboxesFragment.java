package ch.ritter1.apps.ademonstration.checkboxes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ch.ritter1.apps.ademonstration.R;
import ch.ritter1.apps.ademonstration.databinding.FragmentCheckboxesBinding;

public class CheckboxesFragment extends Fragment {

    private FragmentCheckboxesBinding binding;

    public CheckboxesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment petra
        binding = FragmentCheckboxesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.checkBox1.setOnClickListener(v -> {
            if (binding.checkBox1.isChecked()) {
                Toast.makeText(getContext(), R.string.message_checkbox_question1_yes, Toast.LENGTH_SHORT).show();
            }
        });
        binding.checkBox2.setOnClickListener(v -> {
            if (binding.checkBox2.isChecked()) {
                Toast.makeText(getContext(), R.string.message_checkbox_question1_no, Toast.LENGTH_SHORT).show();
            }
        });
        binding.checkBox3.setOnClickListener(v -> {
            if (binding.checkBox3.isChecked()) {
                Toast.makeText(getContext(), R.string.message_checkbox_question2_yes, Toast.LENGTH_SHORT).show();
            }
        });
        binding.checkBox4.setOnClickListener(v -> {
            if (binding.checkBox4.isChecked()) {
                Toast.makeText(getContext(), R.string.message_checkbox_question2_no, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}