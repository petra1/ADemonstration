package ch.ritter1.apps.ademonstration.imagebutton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import ch.ritter1.apps.ademonstration.R;
import ch.ritter1.apps.ademonstration.databinding.FragmentImageButtonBinding;


public class ImageButtonFragment extends Fragment {

    private FragmentImageButtonBinding binding;

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
        binding = FragmentImageButtonBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.imageButton1.setOnClickListener(
                v -> answerFirstQuestion()

        );
        binding.imageButton2.setOnClickListener(
                v -> answerSecondQuestion()

        );
        binding.resetBt.setOnClickListener(
                v -> resetQuestions()


        );
        return view;
    }


    private void answerFirstQuestion() {
        binding.imageButtonQuestion1.setText(getString(R.string.version_of_wcag));
    }
    private void answerSecondQuestion() {
        binding.imageButtonQuestion2.setText(getString(R.string.released_wcag));
    }
    private void resetQuestions() {
        binding.imageButtonQuestion1.setText(getString(R.string.question1_imageButton));
        binding.imageButtonQuestion2.setText(getString(R.string.question2_imageButton));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}