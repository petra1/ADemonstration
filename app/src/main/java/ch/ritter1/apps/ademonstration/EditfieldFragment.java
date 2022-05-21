package ch.ritter1.apps.ademonstration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EditfieldFragment extends Fragment {
    String lastname;
    String firstname;
    boolean clicked = false;


    public EditfieldFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_editfield, container, false);
        Button button_f_name = v.findViewById(R.id.bt_first_name);
        Button button_l_name = v.findViewById(R.id.bt_last_name);
        Button button_full_name = v.findViewById(R.id.bt_full_name);
        TextView text_full_name = v.findViewById(R.id.text_full_name);
        EditText editText_f_name = v.findViewById(R.id.editText_Fist_name);
        EditText editText_l_name = v.findViewById(R.id.editText_Last_name);


        button_f_name.setOnClickListener(
                view -> {


                    firstname = editText_f_name.getText().toString();
                    clicked = true;
                    button_f_name.setContentDescription(getString(R.string.first_name_send));


                }
        );

        button_l_name.setOnClickListener(
                view -> {

                    lastname = editText_l_name.getText().toString();
                    clicked = true;
                    button_l_name.setContentDescription(getString(R.string.last_name_send));


                }
        );
        button_full_name.setOnClickListener(
                view -> {
                    text_full_name.setText(firstname + " " + lastname);
                    text_full_name.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);

                }
        );

        return v;
    }
}