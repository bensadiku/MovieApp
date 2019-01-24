package rx2retrofitmovieapp.com.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import rx2retrofitmovieapp.com.R;
import rx2retrofitmovieapp.com.models.TV.TvResult;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvHolder> {

    List<TvResult> tvList;
    Context context;

    public TvShowsAdapter(List<TvResult> tvList, Context context) {
        this.tvList = tvList;
        this.context = context;
    }

    @NonNull
    @Override
    public TvHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(context).inflate(R.layout.row_shows,viewGroup,false);
       TvHolder th = new TvHolder(view);
       return th;
    }

    @Override
    public void onBindViewHolder(@NonNull TvHolder holder, int position) {
        holder.tvTitle.setText(tvList.get(position).getName());
        holder.tvOverview.setText(tvList.get(position).getOverview());
        holder.tvReleaseDate.setText(tvList.get(position).getFirstAirDate());
        // holder.tvRating.setText(movieList.get(position).getPopularity().toString());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+tvList.get(position).getPosterPath()).into(holder.ivShow);
    }
    @Override
    public int getItemCount() {
        return tvList.size();
    }

    public class TvHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvOverview,tvReleaseDate;
        ImageView ivShow;
        public TvHolder(@NonNull View itemView) {
            super(itemView);
            ivShow = itemView.findViewById(R.id.iv_show);
            tvTitle = itemView.findViewById(R.id.tv_list_name);
            tvReleaseDate = itemView.findViewById(R.id.tv_list_release);
            tvOverview = itemView.findViewById(R.id.tv_list_overview);
        }
    }
}
