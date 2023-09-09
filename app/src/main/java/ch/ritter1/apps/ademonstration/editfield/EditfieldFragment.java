package ch.ritter1.apps.ademonstration.editfield;



import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import ch.ritter1.apps.ademonstration.R;


public class EditfieldFragment extends Fragment {
    String lastName;
    String firstName;
    boolean clicked = false;
    View v;
    Button button_f_name;
    Button button_l_name;
    Button button_full_name;
    TextView text_full_name;
    EditText editText_f_name;
    EditText editText_l_name;



    public EditfieldFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_editfield, container, false);
        button_f_name = v.findViewById(R.id.bt_first_name);
        button_l_name = v.findViewById(R.id.bt_last_name);
        button_full_name = v.findViewById(R.id.bt_full_name);
        text_full_name = v.findViewById(R.id.text_full_name);
        editText_f_name = v.findViewById(R.id.editText_Fist_name);
        editText_l_name = v.findViewById(R.id.editText_Last_name);
        lastName = getString(R.string.default_lastName);
        firstName = getString(R.string.default_firstName);




        button_f_name.setOnClickListener(
                view -> setFirstName()
        );

        button_l_name.setOnClickListener(
                view -> setLastName()
        );
        button_full_name.setOnClickListener(
                view -> setFullName()
        );

        return v;
    }


    private void setFirstName() {
        firstName = editText_f_name.getText().toString();
        clicked = true;
        button_f_name.setContentDescription(getString(R.string.first_name_send));
    }

    private void setLastName() {
        lastName = editText_l_name.getText().toString();
        clicked = true;
        button_l_name.setContentDescription(getString(R.string.last_name_send));
    }


    private void setFullName() {

            text_full_name.setText(firstName + " " + lastName);
            text_full_name.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);

    }


}