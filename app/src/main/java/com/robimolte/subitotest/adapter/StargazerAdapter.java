package com.robimolte.subitotest.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import com.robimolte.subitotest.R;
import com.robimolte.subitotest.model.Stargazer;

import static com.robimolte.subitotest.R.id.avatar;

/**
 * Created by robimolte on 04/02/2017.
 */

public class StargazerAdapter extends RecyclerView.Adapter<StargazerAdapter.MyViewHolder> {


    private final Context mContext;
    private List<Stargazer> stargazerList;



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.stargazer_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Stargazer singleStargazer = stargazerList.get(position);
        Picasso.with(mContext).load(singleStargazer.getAvatar_url()).into(holder.avatarImage);
        holder.username.setText(singleStargazer.getLogin());
    }



    @Override
    public int getItemCount() {
        return stargazerList.size();
    }



    public StargazerAdapter(Context context, ArrayList<Stargazer> stargazerList) {
        mContext = context;
        this.stargazerList = stargazerList;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView avatarImage;
        public TextView username;

        public MyViewHolder(final View view) {
            super(view);
            avatarImage = (ImageView) view.findViewById(R.id.avatar);
            username = (TextView) view.findViewById(R.id.username);

        }


    }
}