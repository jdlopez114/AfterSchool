package com.example.jello.afterschool.dataStructures;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Classroom extends DisplayItem {
    private static final String JSON_CLASS_ID = "classId";
    private static final String JSON_NAME = "name";
    private static final String JSON_TEACHER = "teacher";
    private static final String JSON_CHILDREN = "children";
    private static final String JSON_SCHOOL = "school";
    private final String mClassId;
    private final String mName;
    private final String mTeacherId;
    private final String mSchool;
    private final List<String> mChildrenIds;

    public Classroom(String classId, String name, String teacherId, String school, List<String> childrenIds) {
        this.mClassId = classId;
        this.mName = name;
        this.mTeacherId = teacherId;
        this.mSchool = school;
        this.mChildrenIds = childrenIds;
    }

    public static Optional<Classroom> parse(JSONObject json) {
        try {
            String id = json.getString(JSON_CLASS_ID);
            String name = json.getString(JSON_NAME);
            String teacher = json.getString(JSON_TEACHER);
            String school = json.getString(JSON_SCHOOL);
            JSONArray childrenList = json.getJSONArray(JSON_CHILDREN);
            List<String> children = new ArrayList<>();
            for (int index = 0; index < childrenList.length(); index++) {
                children.add(childrenList.getString(index));
            }
            return Optional.of(new Classroom(id, name, teacher, school, children));
        } catch (JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
