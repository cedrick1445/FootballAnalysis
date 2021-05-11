package ced.football.analysismoto.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ced.football.analysismoto.apiconnections.Repositories;
import ced.football.analysismoto.model.NewsModel;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<List<NewsModel.Article>> neew;
    public Repositories repositories;


    public void initNews(){
        if (neew != null){
            return;
        }
        repositories = Repositories.getInstance();
        neew = repositories.getNews();
    }

    public LiveData<List<NewsModel.Article>> getNews(){
        return neew;
    }

}
