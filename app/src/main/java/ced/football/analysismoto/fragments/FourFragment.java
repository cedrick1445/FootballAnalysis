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
import ced.football.analysismoto.adapter.NewsAdapter;
import ced.football.analysismoto.apiconnections.Connection;
import ced.football.analysismoto.model.NewsModel;
import ced.football.analysismoto.viewmodel.NewsViewModel;

public class FourFragment extends Fragment {
    Connection connectionNews;
    Context context4;
    final List<NewsModel.Article> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;
    View tab4;
    private LinearLayout loadNews, contentNews;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tab4 = inflater.inflate(R.layout.activity_four_fragment, container, false);
        connectionNews = new Connection();
        context4 = tab4.getContext();
        if (connectionNews.isConnected(requireActivity())){
            newsLoading();
            newsCall();
        }
        return tab4;
    }
    private void newsLoading() {
        loadNews = tab4.findViewById(R.id.loadingNews);
        contentNews = tab4.findViewById(R.id.newsContent);
        final Handler load  = new Handler();
        load.postDelayed(() ->{
            loadNews.setVisibility(View.GONE);
            contentNews.setVisibility(View.VISIBLE);
        }, 3600);
    }
    private void newsGet(List<NewsModel.Article> newa){
        RecyclerView newsView = tab4.findViewById(R.id.newsRecycleView);
        newsView.setHasFixedSize(true);
        RecyclerView.LayoutManager newsLayout = new LinearLayoutManager(context4, RecyclerView.VERTICAL, false);
        newsView.setLayoutManager(newsLayout);
        newsAdapter = new NewsAdapter(newa, getContext());
        newsView.setAdapter(newsAdapter);
    }
    private void newsCall() {
        NewsViewModel newsViewModel = ViewModelProviders.of(FourFragment.this).get(NewsViewModel.class);
        newsViewModel.initNews();
        newsViewModel.getNews().observe(this, data ->{
            if (data == null){
                Toast.makeText(getActivity(), "null", Toast.LENGTH_LONG).show();
            }else {
                newsGet(data);
                newsList.addAll(data);
                newsAdapter.notifyDataSetChanged();
            }
        });
    }
}