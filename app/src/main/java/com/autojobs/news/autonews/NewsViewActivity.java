package com.autojobs.news.autonews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Ayothi selvam on 11-11-2017.
 */

public class NewsViewActivity extends Activity {

    TextView textView_title,textView_date,textView_des;
    ImageView imageView_photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);

        textView_title=(TextView) findViewById(R.id.textView_newsview_title);
        textView_date=(TextView) findViewById(R.id.textView_newsview_date);
        textView_des=(TextView) findViewById(R.id.textView_newsview_desc);
        imageView_photo=(ImageView) findViewById(R.id.image_newsview_photo);

        String title=getIntent().getExtras().getString("title");
        String date=getIntent().getExtras().getString("date");
        String des=getIntent().getExtras().getString("des");
        String photo=getIntent().getExtras().getString("photo");

        textView_title.setText(title);
        textView_date.setText(date);
        textView_des.setText(des);
        textView_des.setGravity(Gravity.LEFT);
        Picasso.with(this)
                .load("http://autojobshere.com/admin/"+photo).into(imageView_photo);


    }
}
