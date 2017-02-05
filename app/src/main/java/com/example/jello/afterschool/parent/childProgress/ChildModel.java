package com.example.jello.afterschool.parent.childProgress;

import android.content.Context;

import com.example.jello.afterschool.DefaultModel;
import com.example.jello.afterschool.backend.child.AfterSchoolChildResource;
import com.example.jello.afterschool.backend.parent.AfterSchoolParentResource;
import com.example.jello.afterschool.dataStructures.Child;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayTransformer;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ChildModel extends DefaultModel {

    private final AfterSchoolParentResource mParentResource;
    private final Context mContext;
    private List<Child> mChildData = new ArrayList<>();

    ChildModel(Context context) {
        mContext = context;
        mParentResource = new AfterSchoolParentResource(context);
    }


    void loadChildData(Receiver<Optional<DisplayableScreen>> receiver) {
        mChildData = new ArrayList<>();
        loadContent(mParentResource, buildParentReceiverWrapper(receiver));
    }

    private Receiver<Optional<DisplayableScreen>> buildParentReceiverWrapper(Receiver<Optional<DisplayableScreen>> childDataListener) {
        return response -> {
            if (!response.isPresent()) {
                childDataListener.accept(response);
                return;
            };
            DisplayTransformer<Child> transformer = buildChildTransformer(childDataListener);
            List<DisplayItem> parentHomepageContent = response.get().getContent();
            for (DisplayItem displayItem : parentHomepageContent) {
                displayItem.transform(transformer);
            }
        };
    }

    private DisplayTransformer<Child> buildChildTransformer(final Receiver<Optional<DisplayableScreen>> childDataListener) {
        return new DisplayTransformer<Child>() {
            @Override
            public Class<Child> getTransformToType() {
                return Child.class;
            }

            @Override
            public void apply(Child item) {
                AfterSchoolChildResource resource = new AfterSchoolChildResource(mContext, item.getId());
                loadContent(resource, childDataListener);
            }
        };
    }
}
