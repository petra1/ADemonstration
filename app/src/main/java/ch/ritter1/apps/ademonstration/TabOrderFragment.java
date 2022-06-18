package ch.ritter1.apps.ademonstration;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class TabOrderFragment extends Fragment {
    String lastname;
    String firstname;
    boolean clicked = false;

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
        View v = inflater.inflate(R.layout.fragment_tab__order, container, false);
        Button tab_button_f_name = v.findViewById(R.id.tab_send_first_name_btn);
        Button tab_button_l_name = v.findViewById(R.id.tab_send_last_name_btn);
        Button tab_button_full_name = v.findViewById(R.id.tab_full_name_btn);
        ImageButton tab_f_help = v.findViewById(R.id.tab_first_name_help);
        tab_f_help.setContentDescription(getString(R.string.help_first));
        ImageButton tab_l_help = v.findViewById(R.id.tab_last_name_help);
        tab_l_help.setContentDescription(getString(R.string.help_last));
        TextView tab_text_full_name = v.findViewById(R.id.tab_full_name_text);
        EditText tab_editText_f_name = v.findViewById(R.id.tab_first_name_edit);
        EditText tab_editText_l_name = v.findViewById(R.id.tab_last_name_edit);


        tab_button_f_name.setOnClickListener(
                view -> {


                    firstname = tab_editText_f_name.getText().toString();
                    clicked = true;
                    tab_button_f_name.setContentDescription(getString(R.string.first_name_send));


                }
        );

        tab_button_l_name.setOnClickListener(
                view -> {


                    lastname = tab_editText_l_name.getText().toString();
                    clicked = true;
                    tab_button_l_name.setContentDescription(getString(R.string.last_name_send));


                }
        );
        tab_button_full_name.setOnClickListener(
                view -> {
                    tab_text_full_name.setText(firstname + " " + lastname);
                   tab_text_full_name.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);

                }
        );

        tab_f_help.setOnClickListener(
                new Button.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(), R.string.somethings_wrong, Toast.LENGTH_SHORT).show();
                    }


                }
        );

        tab_l_help.setOnClickListener(
                new Button.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(), R.string.tab_correct, Toast.LENGTH_SHORT).show();
                    }


                }
        );



        return v;
    }
}