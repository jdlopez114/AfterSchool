package com.example.jello.afterschool.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.Teacher;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    ImageView image;
    TextView summary;

    public HomeViewHolder(ViewGroup parent) { // View itemView
        super(createView(parent));              // super(itemView)

        name = (TextView) itemView.findViewById(R.id.name);
        image = (ImageView) itemView.findViewById(R.id.image);
        summary = (TextView) itemView.findViewById(R.id.summary);
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.teacher_item_view, parent, false);
    }

    public void setData(Teacher teacher) { // this is where things got blurry
        Context context = itemView.getContext(); // get context then get name, imae, and summary
        name.setText(teacher.getTeacherId());
//        Picasso.with(context).load(APIService)
        summary.setText(teacher.getTeacherId());
    }
}
