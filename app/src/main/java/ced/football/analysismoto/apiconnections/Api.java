package ced.football.analysismoto.apiconnections;

import ced.football.analysismoto.model.FootbalModel;
import ced.football.analysismoto.model.NewsModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_FOOTBALL_TEAMS = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<FootbalModel> getTeams();

    String BASE_NEWS = "https://saurav.tech/NewsAPI/top-headlines/category/";

    @GET("sports/in.json")
    Call<NewsModel> getNews();

}
