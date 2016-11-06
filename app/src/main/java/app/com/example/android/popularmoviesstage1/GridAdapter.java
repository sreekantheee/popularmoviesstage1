package app.com.example.android.popularmoviesstage1;


import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



/**
 * Created by sreek on 06-11-2016.
 */



public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MoviesViewHolder>
{   private Context context;
    private ArrayList<GridItem> gridItems;

    public GridAdapter(Context context, ArrayList<GridItem> gridItems) {
        this.context = context;
        this.gridItems = gridItems;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {   View V= LayoutInflater.from(context).inflate(R.layout.movie_grid,parent,false);
        return new MoviesViewHolder(V);
    }

    @Override
    public void onBindViewHolder(final MoviesViewHolder holder, int position)
    {   holder.title.setText(gridItems.get(position).getTitle());
        Picasso.with(context).load("http://image.tmdb.org/t/p/w185/"+gridItems.get(position).getImgUrl()).into(holder.banner);
    }

    @Override
    public int getItemCount() {
        return gridItems.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder
    {   public AppCompatImageView banner;
        public AppCompatTextView title;

        public MoviesViewHolder(View itemView)
        {   super(itemView);
            banner=(AppCompatImageView)itemView.findViewById(R.id.banner);
            title=(AppCompatTextView)itemView.findViewById(R.id.title);
        }
    }
}
