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

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {
    Context context;
    private final List<FootbalModel.Team> tem;
    public TeamAdapter(Context context, List<FootbalModel.Team> tem){
        this.context = context;
        this.tem = tem;
    }
    TeamHolder teamHolder;
    @NonNull
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.teams_layout, parent, false);
        teamHolder = new TeamHolder(listItem);

        return teamHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamHolder holder, int position) {
        holder.teamAlternate.setText(tem.get(position).getStrAlternate());
        holder.teamStadium.setText(tem.get(position).getStrStadiumLocation());
        Picasso.get().load(tem.get(position).getStrTeamLogo()).into(holder.teamName);
        Picasso.get().load(tem.get(position).getStrTeamJersey()).into(holder.teamJersey);
        Picasso.get().load(tem.get(position).getStrTeamBadge()).into(holder.teamLogo);
        Picasso.get().load(tem.get(position).getStrTeamFanart2()).into(holder.teamBanner);

    }

    @Override
    public int getItemCount() {
        return tem.size();
    }

    public static class TeamHolder extends RecyclerView.ViewHolder {
        public TextView teamAlternate,teamStadium;
        public ImageView teamLogo,teamJersey,teamBanner,teamName;
        public TeamHolder(@NonNull View itemView) {
            super(itemView);
            teamBanner = itemView.findViewById(R.id.teamBanner);
            teamAlternate = itemView.findViewById(R.id.teamAlternate);
            teamStadium = itemView.findViewById(R.id.teamStadium);
            teamName = itemView.findViewById(R.id.teamName);
            teamLogo = itemView.findViewById(R.id.teamLogo);
            teamJersey = itemView.findViewById(R.id.teamJersey);

        }
    }
}
