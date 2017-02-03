package com.example.jello.afterschool.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.network.APIService;
import com.example.jello.afterschool.view.home.HomeFragmentEnter;
import com.example.jello.afterschool.view.home.HomeFragmentExit;
import com.squareup.picasso.Picasso;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    TextView nameView;
    ImageView imageView;
    TextView summaryView;

    public HomeViewHolder(ViewGroup parent) { // View itemView
        super(createView(parent));              // super(itemView)

        nameView = (TextView) itemView.findViewById(R.id.nameView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        summaryView = (TextView) itemView.findViewById(R.id.summaryView);
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.student_item_view, parent, false);
    }

    public void setData(Children children) { // this is where things got blurry
        Context context = itemView.getContext(); // get context then get nameView, imageView, and summaryView
        nameView.setText(children.getName());
        Picasso.with(context).load(APIService.getUrl(context, children.getImage())).into(imageView);
        summaryView.setText(children.getChildId());


    }
}
