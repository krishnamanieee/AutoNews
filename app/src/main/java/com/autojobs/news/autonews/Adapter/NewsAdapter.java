package com.autojobs.news.autonews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.autojobs.news.autonews.NewsViewActivity;
import com.autojobs.news.autonews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ayothi selvam on 11-11-2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newsList;
    Context context;

    public NewsAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newsitem,parent,false);

        return new NewsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news=newsList.get(position);
        String des=news.getDescription();
        holder.textView_title.setText(news.getTitle());
        holder.textView_date.setText(news.getDate());
       holder.textView_des.setText( des.substring(0,100)+"...");
     Picasso.with(context)
                .load("http://autojobshere.com/admin/"+news.getImage()).into(holder.imageView_photo);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, NewsViewActivity.class);
                intent.putExtra("title",news.getTitle().toString());
                intent.putExtra("date",news.getDate());
                intent.putExtra("des",news.getDescription());
                intent.putExtra("photo",news.getImage());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView_title,textView_date,textView_des;
        ImageView imageView_photo;
        LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            textView_title=(TextView) itemView.findViewById(R.id.textView_title);
            textView_date=(TextView) itemView.findViewById(R.id.textView_date);
            textView_des=(TextView) itemView.findViewById(R.id.textView_desc);
            imageView_photo=(ImageView) itemView.findViewById(R.id.img_photo);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linerlayout_view);


        }
    }




}
