package com.example.jello.afterschool.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.transition.Fade;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.network.APIService;
import com.example.jello.afterschool.view.home.HomeFragmentEnter;
import com.example.jello.afterschool.view.home.HomeFragmentExit;
import com.squareup.picasso.Picasso;

import static android.widget.Toast.LENGTH_LONG;
import static com.example.jello.afterschool.R.id.textView;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG_FRAGMENT = "TAG";
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
        Picasso.with(context).load(APIService.getUrl(context, children.getImage())).into(imageView);
        summaryView.setText(children.getChildId());

        cardView.setOnClickListener(new View.OnClickListener() {
//            HomeFragmentExit homeFragmentExit = new HomeFragmentExit();
            @Override
            public void onClick(View view) {

//                ImageView staticImage = (ImageView) view.findViewById(R.id.imageView);
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    homeFragmentExit.setSharedElementReturnTransition(TransitionInflater.from(homeFragmentExit.getContext()).inflateTransition(R.transition.change_image_trans));
//                    homeFragmentExit.setExitTransition(TransitionInflater.from(homeFragmentExit.getContext()).inflateTransition(android.R.transition.fade));
//
//                    homeFragmentExit.setSharedElementEnterTransition(TransitionInflater.from(homeFragmentExit.getContext()).inflateTransition(R.transition.change_image_trans));
//                    homeFragmentExit.setEnterTransition(TransitionInflater.from(homeFragmentExit.getContext()).inflateTransition(android.R.transition.fade));
//                }
//
//                Bundle bundle = new Bundle();
////                bundle.putString("ACTION", textView.toString());
//                bundle.putParcelable("IMAGE", ((BitmapDrawable) imageView.getDrawable()).getBitmap());
//                homeFragmentExit.setArguments(bundle);
//                FragmentManager fragmentManager = homeFragmentExit.getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.linear_layout, homeFragmentExit)
//                        .addToBackStack("Payment")
//                        .addSharedElement(staticImage, String.valueOf(R.id.image))
//                        .commit();

//                Intent intent = new Intent(context, HomeFragmentExit.class);
//
//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context, view.findViewById(R.id.imageView), "image");


                Toast.makeText(context, "WORKS", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
