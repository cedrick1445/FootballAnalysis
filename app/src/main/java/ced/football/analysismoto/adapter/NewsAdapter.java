package ced.football.analysismoto.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ced.football.analysismoto.NewsWeb;
import ced.football.analysismoto.R;
import ced.football.analysismoto.model.NewsModel;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private final List<NewsModel.Article> nwe;
    Context contextNews;
    NewsHolder newsHolder;
    private NewsModel.Article newss;
    public NewsAdapter(List<NewsModel.Article> nwe, Context contextNews){
        this.nwe = nwe;
        this.contextNews = contextNews;
    }
    View newLayout;
    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        newLayout = layoutInflater.inflate(R.layout.news_layout, parent,false);
         newsHolder = new NewsHolder(newLayout);
         return newsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        newss = nwe.get(position);
        holder.newsTitle.setText(newss.getTitle());
        holder.newsDescription.setText(newss.getDescription());
        holder.newsDate.setText(newss.getPublishedAt());
        Picasso.get().load(newss.getUrlToImage()).into(holder.newsThumbnail);

        holder.cardView.setOnClickListener(v -> {
            Intent myIntent = new Intent(newLayout.getContext(), NewsWeb.class);
            myIntent.putExtra("url", newss.getUrl());
            newLayout.getContext().startActivity(myIntent);
        });


    }

    @Override
    public int getItemCount() {
        return nwe.size();
    }

    public static class NewsHolder extends RecyclerView.ViewHolder {
        public TextView newsTitle,newsDescription,newsDate;
        public ImageView newsThumbnail;
        public CardView cardView;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsDescription = itemView.findViewById(R.id.newsDescription);
            newsDate = itemView.findViewById(R.id.newsDate);
            newsThumbnail = itemView.findViewById(R.id.newsThumbnail);
        }
    }
}
