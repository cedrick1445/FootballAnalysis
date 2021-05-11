package ced.football.analysismoto.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ced.football.analysismoto.R;
import ced.football.analysismoto.adapter.StadiumAdapter;
import ced.football.analysismoto.apiconnections.Connection;
import ced.football.analysismoto.model.FootbalModel;
import ced.football.analysismoto.viewmodel.FootballViewModel;

public class ThreeFragment extends Fragment {
    Connection connectionStad;
    Context context3;
    List<FootbalModel.Team> stadList = new ArrayList<>();
    View tab3;
    private StadiumAdapter stadiumAdapter;
    private LinearLayout stdLoading,stdContent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tab3 = inflater.inflate(R.layout.activity_three_fragment, container, false);
        connectionStad = new Connection();
        context3 = tab3.getContext();
        if (connectionStad.isConnected(requireActivity())) {
            loadingStadium();
            stadiumCall();
        }
        return tab3;
    }

    private void loadingStadium() {
        stdContent = tab3.findViewById(R.id.stadContent);
        stdLoading = tab3.findViewById(R.id.loading_stadium);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            stdLoading.setVisibility(View.GONE);
            stdContent.setVisibility(View.VISIBLE);
        }, 4000);
    }


    private void stadiumGet(List<FootbalModel.Team> stadd) {
        RecyclerView stdView = tab3.findViewById(R.id.stadiumRecycleView);
        stdView.setHasFixedSize(true);
        RecyclerView.LayoutManager stdLayout = new LinearLayoutManager(context3, RecyclerView.HORIZONTAL, false);
        stdView.setLayoutManager(stdLayout);
        LinearSnapHelper snapSTD = new LinearSnapHelper();
        snapSTD.attachToRecyclerView(stdView);
        stadiumAdapter = new StadiumAdapter(getContext(), stadd);
        stdView.setAdapter(stadiumAdapter);
    }

    private void stadiumCall() {
        FootballViewModel footballViewModel = ViewModelProviders.of(ThreeFragment.this).get(FootballViewModel.class);
        footballViewModel.initTeam();
        footballViewModel.getTeaam().observe(this, data -> {
            if (data == null) {
                Toast.makeText(getActivity(), "null", Toast.LENGTH_LONG).show();
            } else {
                stadiumGet(data);
                stadList.addAll(data);
                stadiumAdapter.notifyDataSetChanged();
            }
        });
    }
}