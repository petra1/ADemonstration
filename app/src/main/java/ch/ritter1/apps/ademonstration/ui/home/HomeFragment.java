package ch.ritter1.apps.ademonstration.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ch.ritter1.apps.ademonstration.R;
import ch.ritter1.apps.ademonstration.databinding.FragmentHomeBinding;
import ch.ritter1.apps.ademonstration.help.HelpActivity;
import ch.ritter1.apps.ademonstration.usage.UsageFragment;

public class HomeFragment extends Fragment {

    Activity context;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context= getActivity();
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

        public void onStart(){
        super.onStart();
        Button btn = (Button) context.findViewById(R.id.button_help);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HelpActivity.class);
                startActivity(intent);
            }
        });
        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}