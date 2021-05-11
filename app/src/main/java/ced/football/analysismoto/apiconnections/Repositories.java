package ced.football.analysismoto.apiconnections;


import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ced.football.analysismoto.model.FootbalModel;
import ced.football.analysismoto.model.NewsModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories {

    private static Repositories instance;

    public static Repositories getInstance() {
        if (instance == null) {
            instance = new Repositories();
        }
        return instance;
    }

    public MutableLiveData<List<FootbalModel.Team>> getTeams() {
        final MutableLiveData<List<FootbalModel.Team>> tem = new MutableLiveData<>();
        Call<FootbalModel> call = RetrofitService.getFootballInterface().getTeams();
        call.enqueue(new Callback<FootbalModel>() {
            @Override
            public void onResponse(@NonNull Call<FootbalModel> call, @NonNull Response<FootbalModel> response) {
                FootbalModel teamList = response.body();
                assert teamList != null;
                List<FootbalModel.Team> teem = teamList.getTeams();
                tem.setValue(teem);
            }
            @Override
            public void onFailure(@NonNull Call<FootbalModel> call, @NonNull Throwable t) {
                tem.setValue(null);
            }
        });
        return tem;
    }

    public MutableLiveData<List<NewsModel.Article>> getNews() {
        final MutableLiveData<List<NewsModel.Article>> neww = new MutableLiveData<>();
        Call<NewsModel> newsCall = RetrofitService.getNewsInterface().getNews();
        newsCall.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(@NonNull Call<NewsModel> call, @NonNull Response<NewsModel> response) {
                NewsModel newsList = response.body();
                assert newsList != null;
                List<NewsModel.Article> newe = newsList.getArticles();
                neww.setValue(newe);
            }
            @Override
            public void onFailure(@NonNull Call<NewsModel> call, @NonNull Throwable t) {
                neww.setValue(null);
            }
        });
        return neww;
    }
}
