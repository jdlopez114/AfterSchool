package com.example.jello.afterschool.viewholders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.network.RetroHelper;
import com.squareup.picasso.Picasso;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    TextView nameView;
    ImageView imageView;
    TextView summaryView;
    CardView cardView;

    public HomeViewHolder(ViewGroup parent) { // View itemView
        super(createView(parent));              // super(itemView)

        nameView = (TextView) itemView.findViewById(R.id.nameView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        summaryView = (TextView) itemView.findViewById(R.id.summaryView);
        cardView = (CardView) itemView.findViewById(R.id.recycler_view_items);
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.student_item_view, parent, false);
    }

    public void setData(Children children) { // this is where things got blurry

        Context context = itemView.getContext(); // get context then get nameView, imageView, and summaryView
        nameView.setText(children.getName());
        Picasso.with(context).load(RetroHelper.getUrl(context, children.getImage())).into(imageView);
        summaryView.setText(children.getChildId());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "WORKS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
