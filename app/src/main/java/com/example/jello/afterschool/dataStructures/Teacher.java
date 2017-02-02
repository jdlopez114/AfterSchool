package com.example.jello.afterschool.dataStructures;


import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends DisplayItem {

    private static final String JSON_ID = "teacherId";
    private static final String JSON_NAME = "name";
    private static final String JSON_IMAGE = "image";
    private static final String JSON_CLASSROOMS = "classrooms";
    private final String mName;
    private final String mImage;
    private final String mId;
    private final List<String> mClassrooms;

    public Teacher(String id, String name, String image, List<String> classromms) {
        mId = id;
        mName = name;
        mImage = image;
        mClassrooms = classromms;
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

    public List<String> getClassrooms() {
        return mClassrooms;
    }

    public static Optional<Teacher> parse(JSONObject json) {
        try {
            String id = json.getString(JSON_ID);
            String name = json.getString(JSON_NAME);
            String image = json.getString(JSON_IMAGE);
            List<String> classrooms = new ArrayList<>();
            JSONArray classroomList = json.getJSONArray(JSON_CLASSROOMS);
            for (int index = 0; index < classroomList.length(); index++) {
                classrooms.add(classroomList.getString(index));
            }
            return Optional.of(new Teacher(id, name, image, classrooms));
        } catch (JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
