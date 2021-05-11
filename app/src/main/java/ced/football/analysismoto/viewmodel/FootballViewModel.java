package ced.football.analysismoto.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ced.football.analysismoto.apiconnections.Repositories;
import ced.football.analysismoto.model.FootbalModel;

public class FootballViewModel extends ViewModel {

    private MutableLiveData<List<FootbalModel.Team>> taem;

    public Repositories repositories;


    public void initTeam(){
        if (taem != null){
            return;
        }
        repositories = Repositories.getInstance();
        taem = repositories.getTeams();
    }

    public LiveData<List<FootbalModel.Team>> getTeaam(){
        return taem;
    }



}
