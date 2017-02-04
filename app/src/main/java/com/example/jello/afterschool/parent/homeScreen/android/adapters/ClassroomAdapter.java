package com.example.jello.afterschool.parent.homeScreen.android.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jello.afterschool.dataStructures.Classroom;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.parent.homeScreen.android.viewHolders.ClassroomViewHolder;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ClassroomAdapter extends RecyclerView.Adapter<ClassroomViewHolder> {
    private final WeakReference<Activity> mActivity;
    private List<String> mList = new ArrayList<>();

    public ClassroomAdapter(Activity activity, List<Children> childrenList) {
        mActivity = new WeakReference<>(activity);
        for (Children child : childrenList){
            List<String> childClasses = child.getClassrooms();
            for (String clazz : childClasses) {
                if (!mList.contains(clazz)){
                    mList.add(clazz);
                }
            }
        }
    }

    @Override
    public ClassroomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClassroomViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ClassroomViewHolder holder, int position) {
        holder.setData(mActivity, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
