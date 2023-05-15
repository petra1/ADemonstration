package ch.ritter1.apps.ademonstration.imagebutton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import ch.ritter1.apps.ademonstration.R;


public class ImageButtonFragment extends Fragment {

    View v;
    ImageButton imageButton1;
    ImageButton imageButton2;
    Button resetButton;
    TextView question1;
    TextView question2;

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
        v = inflater.inflate(R.layout.fragment_image_button, container, false);
        imageButton1 = v.findViewById(R.id.imageButton1);
        imageButton2 = v.findViewById(R.id.imageButton2);
        resetButton = v.findViewById(R.id.reset_bt);
        question1 = v.findViewById(R.id.imageButton_Question1);
        question2 = v.findViewById(R.id.imageButton_Question2);

        imageButton1.setOnClickListener(
                view -> answerFirstQuestion()

        );
        imageButton2.setOnClickListener(
                view -> answerSecondQuestion()

        );
        resetButton.setOnClickListener(
                view -> resetQuestions()


        );
        return v;
    }


    private void answerFirstQuestion() {
        question1.setText(getString(R.string.version_of_wcag));
    }
    private void answerSecondQuestion() {
        question2.setText(getString(R.string.released_wcag));
    }
    private void resetQuestions() {
        question1.setText(getString(R.string.what_is_the_current_version_of_wcag));
        question2.setText(getString(R.string.when_was_the_current_version_of_wcag_released));

    }

}