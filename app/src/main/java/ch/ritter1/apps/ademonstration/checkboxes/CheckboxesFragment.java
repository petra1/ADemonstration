package ch.ritter1.apps.ademonstration.checkboxes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ch.ritter1.apps.ademonstration.R;

public class CheckboxesFragment extends Fragment implements View.OnClickListener {

    public CheckboxesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);


        // Find the CheckBoxes by their IDs
        CheckBox checkBox1 = view.findViewById(R.id.checkBox1);
        CheckBox checkBox2 = view.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = view.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = view.findViewById(R.id.checkBox4);

        // Set OnClickListener for each CheckBox
        // Since the fragment implements View.OnClickListener, we can pass 'this'
        if (checkBox1 != null) {
            checkBox1.setOnClickListener(this);
        }
        if (checkBox2 != null) {
            checkBox2.setOnClickListener(this);
        }
        if (checkBox3 != null) {
            checkBox3.setOnClickListener(this);
        }
        if (checkBox4 != null) {
            checkBox4.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        // It's good practice to ensure getContext() is not null before making a Toast
        if (getContext() == null) {
            return;
        }

        // We need to cast the clicked view to a CheckBox to check its state
        CheckBox clickedCheckBox = (CheckBox) v;

        // Only show Toast if the CheckBox was just checked
        if (!clickedCheckBox.isChecked()) {
            return; // Do nothing if the checkbox was unchecked
        }

        int id = v.getId();

        if (id == R.id.checkBox1) {
            Toast.makeText(getContext(), R.string.message_checkbox_question1_yes, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.checkBox2) {
            Toast.makeText(getContext(), R.string.message_checkbox_question1_no, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.checkBox3) {
            Toast.makeText(getContext(), R.string.message_checkbox_question2_yes, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.checkBox4) {
            Toast.makeText(getContext(), R.string.message_checkbox_question2_no, Toast.LENGTH_SHORT).show();
        }
    }
}