package ch.ritter1.apps.ademonstration;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class ImageButtonFragment extends Fragment {

    public ImageButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image_button, container, false);
        ImageButton imageButton1 = v.findViewById(R.id.imageButton1);
        ImageButton imageButton2 = v.findViewById(R.id.imageButton2);
        Button resetButton = v.findViewById(R.id.reset_bt);
        final TextView question1 = v.findViewById(R.id.imageButton_Question1);
        final TextView question2 = v.findViewById(R.id.imageButton_Question2);

        imageButton1.setOnClickListener(
                view -> question1.setText(getString(R.string.version_of_wcag))
        );
        imageButton2.setOnClickListener(
                view -> question2.setText(getString(R.string.released_wcag))
        );
        resetButton.setOnClickListener(
                view -> {
                    question1.setText(getString(R.string.what_is_the_current_version_of_wcag));
                    question2.setText(getString(R.string.when_was_the_current_version_of_wcag_released));
                }

        );
        return v;
    }
}