package ced.football.analysismoto.apiconnections;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {


    private static final Retrofit retrofitFootball = new Retrofit.Builder()
            .baseUrl(Api.BASE_FOOTBALL_TEAMS)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static Api getFootballInterface(){
        return retrofitFootball.create(Api.class);
    }


    private static final Retrofit retrofitNews = new Retrofit.Builder()
            .baseUrl(Api.BASE_NEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Api getNewsInterface(){
        return retrofitNews.create(Api.class);
    }







}

