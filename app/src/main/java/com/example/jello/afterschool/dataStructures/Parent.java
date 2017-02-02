package com.example.jello.afterschool.dataStructures;


import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Parent extends DisplayItem {
    private static final String JSON_ID = "parentId";
    private static final String JSON_NAME = "name";
    private static final String JSON_IMAGE = "image";
    private static final String JSON_CHILDREN = "children";

    private final String mId;
    private final String mName;
    private final String mImage;
    private final List<String> mChildren;

    public Parent (String id, String name, String image, List<String> children) {
        mId = id;
        mName = name;
        mImage = image;
        mChildren = children;
    }

    public static Optional<Parent> parse(JSONObject json) {
        try {
            String id = json.getString(JSON_ID);
            String name = json.getString(JSON_NAME);
            String image = json.getString(JSON_IMAGE);
            JSONArray childrenList = json.getJSONArray(JSON_CHILDREN);
            List<String> children = new ArrayList<>();
            for (int index = 0; index < childrenList.length(); index++) {
                children.add(childrenList.getString(index));
            }
            return Optional.of(new Parent(id, name, image, children));
        } catch (JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
