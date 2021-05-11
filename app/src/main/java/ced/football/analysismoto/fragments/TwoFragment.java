package ced.football.analysismoto.fragments;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ced.football.analysismoto.R;
import ced.football.analysismoto.adapter.TeamAdapter;
import ced.football.analysismoto.apiconnections.Connection;
import ced.football.analysismoto.model.FootbalModel;
import ced.football.analysismoto.viewmodel.FootballViewModel;

public class TwoFragment extends Fragment {
    View tab2;
    Context context;
    Connection connectionTeam;
    private TeamAdapter teamAdapter;
    List<FootbalModel.Team> teaMList = new ArrayList<>();
    private LinearLayout loadingT,contentT;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tab2 = inflater.inflate(R.layout.activity_two_fragment, container, false);
        connectionTeam = new Connection();
        context = tab2.getContext();
        if (connectionTeam.isConnected(requireActivity())){
            loading_team();
            teamCall();
        }
        return tab2;
    }
    private void loading_team() {
        contentT = tab2.findViewById(R.id.content_teams);
        loadingT = tab2.findViewById(R.id.loading_team);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            loadingT.setVisibility(View.GONE);
            contentT.setVisibility(View.VISIBLE);
        }, 3500);
    }
    private void teamGet(List<FootbalModel.Team> teamm){
        RecyclerView tView = tab2.findViewById(R.id.teamRecycleView);
        tView.setHasFixedSize(true);
        RecyclerView.LayoutManager tlayout = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        tView.setLayoutManager(tlayout);
        teamAdapter = new TeamAdapter(getActivity(),teamm);
        tView.setAdapter(teamAdapter);
    }
    private void teamCall() {
        FootballViewModel footbalModel = ViewModelProviders.of(TwoFragment.this).get(FootballViewModel.class);
        footbalModel.initTeam();
        footbalModel.getTeaam().observe(this, data ->{
            if (data == null){
                Toast.makeText(getActivity(),"null", Toast.LENGTH_LONG).show();
            }else {
                teamGet(data);
                teaMList.addAll(data);
                teamAdapter.notifyDataSetChanged();
            }
        } );
    }
}