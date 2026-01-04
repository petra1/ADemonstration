package ch.ritter1.apps.ademonstration.taborder;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ch.ritter1.apps.ademonstration.R;
import ch.ritter1.apps.ademonstration.databinding.FragmentTabOrderBinding;

public class TabOrderFragment extends Fragment {
    String lastName;
    String firstName;
    String fullName;
    boolean clicked = false;

    private FragmentTabOrderBinding binding;

    public TabOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTabOrderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tabFirstNameHelp.setContentDescription(getString(R.string.help_first));
        binding.tabLastNameHelp.setContentDescription(getString(R.string.help_last));
        binding.tabSendFirstNameBtn.setOnClickListener(v -> setFirstName());
        binding.tabSendLastNameBtn.setOnClickListener(v -> setLastName());
        binding.tabFullNameBtn.setOnClickListener(v -> {
            if (firstName == null || lastName == null || (firstName.isEmpty() && lastName.isEmpty())) {
                showAlertDialog();
            } else {
                setFullName();
            }
        });
        binding.tabFirstNameHelp.setOnClickListener(v -> Toast.makeText(getActivity(), R.string.somethings_wrong, Toast.LENGTH_SHORT).show());
        binding.tabLastNameHelp.setOnClickListener(v -> Toast.makeText(getActivity(), R.string.tab_correct, Toast.LENGTH_SHORT).show());
    }

    private void setFirstName() {
        firstName = binding.tabFirstNameEdit.getText().toString();
        clicked = true;
        binding.tabSendFirstNameBtn.setContentDescription(getString(R.string.first_name_send));
    }

    private void setLastName() {
        lastName = binding.tabLastNameEdit.getText().toString();
        clicked = true;
        binding.tabSendLastNameBtn.setContentDescription(getString(R.string.last_name_send));
    }

    private void setFullName() {
        fullName = firstName + " " + lastName;
        binding.tabFullNameText.setText(fullName);
        binding.tabFullNameText.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);
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
