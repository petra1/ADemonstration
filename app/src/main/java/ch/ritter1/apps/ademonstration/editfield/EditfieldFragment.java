package ch.ritter1.apps.ademonstration.editfield;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import ch.ritter1.apps.ademonstration.R;
import ch.ritter1.apps.ademonstration.databinding.FragmentEditfieldBinding;


public class EditfieldFragment extends Fragment {
    String lastName;
    String firstName;
    String fullName;

    private FragmentEditfieldBinding binding;


    public EditfieldFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentEditfieldBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.btFirstName.setOnClickListener(
                v -> setFirstName()
        );

        binding.btLastName.setOnClickListener(
                v -> setLastName()
        );
        binding.btFullName.setOnClickListener(v -> {
            if (firstName == null || lastName == null || (firstName.isEmpty() && lastName.isEmpty())) {
                showAlertDialog();
            } else {
                setFullName();
            }
        });
        return view;
    }

    private void setFirstName() {
        binding.btFirstName.setContentDescription(getString(R.string.first_name_send));
        firstName = binding.editTextFistName.getText().toString();
    }

    private void setLastName() {
        binding.btLastName.setContentDescription(getString(R.string.last_name_send));
        lastName = binding.editTextLastName.getText().toString();
    }

    private void setFullName() {
        fullName = firstName + " " + lastName;
        binding.textFullName.setText(fullName);
        binding.textFullName.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);
    }

    private void showAlertDialog() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle(R.string.alert_title);
        alertDialogBuilder.setMessage(R.string.alert_message);
        alertDialogBuilder.setPositiveButton(R.string.alert_button, (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}