package ch.ritter1.apps.ademonstration.focusvisible;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import ch.ritter1.apps.ademonstration.R;
import ch.ritter1.apps.ademonstration.databinding.FragmentFocusVisibleBinding;


public class  FocusVisibleFragment extends Fragment implements View.OnClickListener{
    private FragmentFocusVisibleBinding binding;

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
        binding = FragmentFocusVisibleBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.bt1.setOnClickListener(this);
        binding.bt2.setOnClickListener(this);
        binding.bt3.setOnClickListener(this);
        binding.bt4.setOnClickListener(this);
        binding.bt5.setOnClickListener(this);
        binding.bt6.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {


        int id = v.getId();
        if (id == R.id.bt_1) {
            Toast.makeText(getActivity(), R.string.btn_1, Toast.LENGTH_LONG).show();
        } else if (id == R.id.bt_2) {
            Toast.makeText(getActivity(), R.string.btn_2, Toast.LENGTH_LONG).show();
        } else if (id == R.id.bt_3) {
            Toast.makeText(getActivity(), R.string.btn_3, Toast.LENGTH_LONG).show();
        } else if (id == R.id.bt_4) {
            Toast.makeText(getActivity(), R.string.btn_4, Toast.LENGTH_LONG).show();
        } else if (id == R.id.bt_5) {
            Toast.makeText(getActivity(), R.string.btn_5, Toast.LENGTH_LONG).show();
        } else if (id == R.id.bt_6) {
            Toast.makeText(getActivity(), R.string.btn_6, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}