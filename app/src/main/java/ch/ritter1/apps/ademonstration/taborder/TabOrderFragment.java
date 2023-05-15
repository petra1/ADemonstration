package ch.ritter1.apps.ademonstration.taborder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import ch.ritter1.apps.ademonstration.R;


public class TabOrderFragment extends Fragment {
    String lastName;
    String firstName;
    boolean clicked = false;
    View v;
    Button tab_button_f_name;
    Button tab_button_l_name;
    Button tab_button_full_name;
    ImageButton tab_f_help;
    ImageButton tab_l_help;
    TextView tab_text_full_name;
    EditText tab_editText_f_name;
    EditText tab_editText_l_name;

    public TabOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tab__order, container, false);
        tab_button_f_name = v.findViewById(R.id.tab_send_first_name_btn);
        tab_button_l_name = v.findViewById(R.id.tab_send_last_name_btn);
        tab_button_full_name = v.findViewById(R.id.tab_full_name_btn);
        tab_f_help = v.findViewById(R.id.tab_first_name_help);
        tab_f_help.setContentDescription(getString(R.string.help_first));
        tab_l_help = v.findViewById(R.id.tab_last_name_help);
        tab_l_help.setContentDescription(getString(R.string.help_last));
        tab_text_full_name = v.findViewById(R.id.tab_full_name_text);
        tab_editText_f_name = v.findViewById(R.id.tab_first_name_edit);
        tab_editText_l_name = v.findViewById(R.id.tab_last_name_edit);


        tab_button_f_name.setOnClickListener(
                view -> setFirstName()
        );

        tab_button_l_name.setOnClickListener(
                view -> setLastName()
        );
        tab_button_full_name.setOnClickListener(
                view -> setFullMame()
        );

        tab_f_help.setOnClickListener(
                view -> Toast.makeText(getActivity(), R.string.somethings_wrong, Toast.LENGTH_SHORT).show()
        );

        tab_l_help.setOnClickListener(
                view -> Toast.makeText(getActivity(), R.string.tab_correct, Toast.LENGTH_SHORT).show()
        );



        return v;
    }

    private void setFirstName() {
        firstName = tab_editText_f_name.getText().toString();
        clicked = true;
        tab_button_f_name.setContentDescription(getString(R.string.first_name_send));

    }

    private void setLastName() {
        lastName = tab_editText_l_name.getText().toString();
        clicked = true;
        tab_button_l_name.setContentDescription(getString(R.string.last_name_send));

    }

    private void setFullMame() {
        tab_text_full_name.setText(firstName + " " + lastName);
        tab_text_full_name.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);

    }
}