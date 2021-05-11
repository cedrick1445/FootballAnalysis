package ced.football.analysismoto.fragments;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import ced.football.analysismoto.R;
import ced.football.analysismoto.databinding.ActivityOneFragmentBinding;
import ced.football.analysismoto.viewmodel.OneViewModel;

public class OneFragment extends Fragment {
    private ActivityOneFragmentBinding binding;
    View tab1;
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OneViewModel oneView = ViewModelProviders.of(this).get(OneViewModel.class);
        binding = ActivityOneFragmentBinding.inflate(inflater,container,false);
        tab1 = binding.getRoot();

        homeLoading();

        final TextView homeOne = binding.home1;
        final TextView homeTwo = binding.home2;
        final TextView homeThree = binding.home3;
        final TextView homeFour = binding.home4;

        oneView.getHome1().observe(getViewLifecycleOwner(), homeOne::setText);
        oneView.getHome2().observe(getViewLifecycleOwner(), homeTwo::setText);
        oneView.getHome3().observe(getViewLifecycleOwner(), homeThree::setText);
        oneView.getHome4().observe(getViewLifecycleOwner(), homeFour::setText);

        final ImageView imgOne = binding.imageOne;
        final ImageView imgTwo = binding.imageTwo;
        final ImageView imgThree = binding.imageThree;
        final ImageView imgFour = binding.imageFour;

        oneView.getImg1().observe(getViewLifecycleOwner(), imgOne::setImageResource);
        oneView.getImg2().observe(getViewLifecycleOwner(), imgTwo::setImageResource);
        oneView.getImg3().observe(getViewLifecycleOwner(), imgThree::setImageResource);
        oneView.getImg4().observe(getViewLifecycleOwner(), imgFour::setImageResource);

        return tab1;
    }

    private void homeLoading() {
        LinearLayout loadingHome = tab1.findViewById(R.id.loading_home);
        LinearLayout contentHome = tab1.findViewById(R.id.content_home);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            loadingHome.setVisibility(View.GONE);
            contentHome.setVisibility(View.VISIBLE);
        }, 4000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}