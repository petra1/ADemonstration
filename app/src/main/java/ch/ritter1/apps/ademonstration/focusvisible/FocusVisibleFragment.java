package ch.ritter1.apps.ademonstration.focusvisible;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import ch.ritter1.apps.ademonstration.R;


public class FocusVisibleFragment extends Fragment implements View.OnClickListener{
    View v;
    Button bt_1,  bt_2,  bt_3,  bt_4,  bt_5,  bt_6,  bt_7,  bt_8;

    public FocusVisibleFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_focus_visible, container, false);

        bt_1 = v.findViewById(R.id.bt_1);
        bt_2 = v.findViewById(R.id.bt_2);
        bt_3 = v.findViewById(R.id.bt_3);
        bt_4 = v.findViewById(R.id.bt_4);
        bt_5 = v.findViewById(R.id.bt_5);
        bt_6 = v.findViewById(R.id.bt_6);
        bt_7 = v.findViewById(R.id.bt_7);
        bt_8 = v.findViewById(R.id.bt_8);

        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_1:
                Toast.makeText(getActivity(), R.string.btn_1, Toast.LENGTH_LONG ).show();
                break;
            case R.id.bt_2:
                Toast.makeText(getActivity(), R.string.btn_2, Toast.LENGTH_LONG ).show();
                break;
            case R.id.bt_3:
                Toast.makeText(getActivity(), R.string.btn_3, Toast.LENGTH_LONG ).show();
                break;
            case R.id.bt_4:
                Toast.makeText(getActivity(), R.string.btn_4, Toast.LENGTH_LONG ).show();
                break;
            case R.id.bt_5:
                Toast.makeText(getActivity(), R.string.btn_5, Toast.LENGTH_LONG ).show();
                break;
            case R.id.bt_6:
                Toast.makeText(getActivity(), R.string.btn_6, Toast.LENGTH_LONG ).show();
                break;
            case R.id.bt_7:
                Toast.makeText(getActivity(), R.string.btn_7, Toast.LENGTH_LONG ).show();
                break;
            case R.id.bt_8:
                Toast.makeText(getActivity(), R.string.btn_8 , Toast.LENGTH_LONG ).show();
                break;

        }

    }
}