package ced.football.analysismoto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ced.football.analysismoto.R;
import ced.football.analysismoto.model.FootbalModel;

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.StadiumHolder> {
    private final List<FootbalModel.Team> std;
    private FootbalModel.Team foot;
    Context context;
    StadiumHolder stadiumHolder;

    public StadiumAdapter(Context context, List<FootbalModel.Team> std) {
        this.std = std;
        this.context = context;
    }
    @NonNull
    @Override
    public StadiumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.stadium_layout, parent, false);
        stadiumHolder = new StadiumHolder(listItem);
        return stadiumHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StadiumHolder holder, int position) {
        foot = std.get(position);
        holder.teamStadium.setText(String.valueOf(foot.getStrStadium()));
        holder.teamlocation.setText(String.valueOf(foot.getStrStadiumLocation()));
        holder.capacity.setText(String.valueOf(foot.getIntStadiumCapacity()));
        Picasso.get().load(foot.getStrStadiumThumb()).into(holder.stadiumimg);
    }

    @Override
    public int getItemCount() {
        return std.size();
    }

    public static class StadiumHolder extends RecyclerView.ViewHolder {
        public TextView teamStadium, teamlocation, capacity;
        public ImageView stadiumimg;
        public StadiumHolder(@NonNull View itemView) {
            super(itemView);
            teamStadium = itemView.findViewById(R.id.stadiumName);
            teamlocation = itemView.findViewById(R.id.stadiumlocation);
            stadiumimg = itemView.findViewById(R.id.staduimimg);
            capacity = itemView.findViewById(R.id.capacity);
        }
    }
}
