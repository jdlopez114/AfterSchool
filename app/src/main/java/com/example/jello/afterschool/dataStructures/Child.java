package com.example.jello.afterschool.dataStructures;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Child extends DisplayItem{
    private static final String JSON_ID = "childId";
    private static final String JSON_NAME = "name";
    private static final String JSON_IMAGE = "image";
    private static final String JSON_PARENT = "parent";
    private static final String JSON_CLASSROOMS = "classrooms";
    private final String mId;
    private final String mName;
    private final String mImage;
    private final String mParentId;
    private final List<String> mClassroomIds;

    public Child(String id, String name, String image, String parent, List<String> classrooms) {
        this.mId = id;
        this.mName = name;
        this.mImage = image;
        this.mParentId = parent;
        this.mClassroomIds = classrooms;
    }

    public static Optional<Child> parse(JSONObject json) {
        try {
            String id = json.getString(JSON_ID);
            String name = json.getString(JSON_NAME);
            String image = json.getString(JSON_IMAGE);
            String parent = json.getString(JSON_PARENT);
            List<String> classrooms = new ArrayList<>();
            JSONArray classroomList = json.getJSONArray(JSON_CLASSROOMS);
            for (int index = 0; index < classroomList.length(); index++) {
                classrooms.add(classroomList.getString(index));
            }
            return Optional.of(new Child(id, name, image, parent, classrooms));
        } catch (JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public String getName() {
        return mName;
    }

    public String getImage() {
        return mImage;
    }

    public String getId() {
        return mId;
    }

    public String getParentId() {
        return mParentId;
    }

    public List<String> getClassrooms() {
        return mClassroomIds;
    }
}
