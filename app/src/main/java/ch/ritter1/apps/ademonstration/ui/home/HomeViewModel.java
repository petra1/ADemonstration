package ch.ritter1.apps.ademonstration.ui.home;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ch.ritter1.apps.ademonstration.usage.UsageFragment;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("A Demonstration");
    }

    public LiveData<String> getText() {
        return mText;
    }

}