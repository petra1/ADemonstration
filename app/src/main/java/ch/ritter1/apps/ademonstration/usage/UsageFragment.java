package ch.ritter1.apps.ademonstration.usage;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import ch.ritter1.apps.ademonstration.R;
import ch.ritter1.apps.ademonstration.databinding.FragmentUsageBinding;


public class UsageFragment extends Fragment {
    private FragmentUsageBinding binding;

    public UsageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUsageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        WebView webView = binding.webView2;
        SwipeRefreshLayout swipeLayout = binding.swipeRefreshLayout;
        view.setHorizontalScrollBarEnabled(true);
        view.setHorizontalScrollBarEnabled(true);


        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                webView.loadUrl ("file:///android_asset/" + getString (R.string.dark_mode_usage_html));
                break;
            case  Configuration.UI_MODE_NIGHT_NO:
                webView.loadUrl ("file:///android_asset/" + getString (R.string.usage_html));
                break;
        }

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(false);
            }
        });

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}