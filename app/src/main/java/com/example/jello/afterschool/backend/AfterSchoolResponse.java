package com.example.jello.afterschool.backend;

import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.dataStructures.Classroom;
import com.example.jello.afterschool.dataStructures.Parent;
import com.example.jello.afterschool.dataStructures.Teacher;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AfterSchoolResponse {
    private static final String JSON_SUCCESS = "success";
    private static final String JSON_RESULT = "result";
    private static final String JSON_TEACHER = "teacher";
    private static final String JSON_PARENT = "parent";
    private static final String JSON_CHILDREN = "children";
    private static final String JSON_CLASSROOM = "classrooms";
    private final boolean mSuccess;

    private final List<Teacher> mTeachers;
    private final List<Parent> mParents;
    private final List<Child> mChildren;
    private final List<Classroom> mClassrooms;
    private final String mJson;

    private AfterSchoolResponse(String json, boolean success, List<Teacher> teachers, List<Parent> parents, List<Child> children, List<Classroom> classrooms) {
        mSuccess = success;
        mTeachers = teachers;
        mParents = parents;
        mChildren = children;
        mClassrooms = classrooms;
        mJson = json;
    }

    public boolean getSuccess() {
        return mSuccess;
    }

    public List<Teacher> getResult() {
        return mTeachers;
    }

    public static AfterSchoolResponse parse(String response) {
        try {
            JSONObject json = new JSONObject(response);
            boolean success = json.getBoolean(JSON_SUCCESS);
            JSONObject teacherJson = json.getJSONObject(JSON_TEACHER);
            JSONObject parentJson = json.getJSONObject(JSON_PARENT);
            JSONArray childrenJson = json.getJSONArray(JSON_CHILDREN);
            JSONArray classroomJson = json.getJSONArray(JSON_CLASSROOM);
            List<Teacher> teachers = inflateTeachers(teacherJson);
            List<Parent> parents = inflateParents(parentJson);
            List<Child> children = inflateChildren(childrenJson);
            List<Classroom> classrooms = inflateClassrooms(classroomJson);
            return new AfterSchoolResponse(response, success, teachers, parents, children, classrooms);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emptyResponse();
    }

    private static List<Classroom> inflateClassrooms(JSONArray classroomJson) {
        List<Classroom> result = new ArrayList<>();
        for (int index = 0; index < classroomJson.length(); index++ ) {
            try {
                JSONObject current = classroomJson.getJSONObject(index);
                Optional<Classroom> classroom = Classroom.parse(current);
                classroom.ifPresent(result::add);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return result;
    }

    private static List<Child> inflateChildren(JSONArray childrenJson) {
        List<Child> result = new ArrayList<>();
        for (int index = 0; index < childrenJson.length(); index++ ) {
            try {
                JSONObject current = childrenJson.getJSONObject(index);
                Optional<Child> child = Child.parse(current);
                child.ifPresent(result::add);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return result;
    }

    private static List<Parent> inflateParents(JSONObject parentJson) {
        Optional<Parent> parent = Parent.parse(parentJson);
        if (parent.isPresent()) {
            return Collections.singletonList(parent.get());
        }
        return Collections.emptyList();
    }

    private static List<Teacher> inflateTeachers(JSONObject teacherJson) {
        Optional<Teacher> teacher = Teacher.parse(teacherJson);
        if (teacher.isPresent()) {
            return Collections.singletonList(teacher.get());
        }
        return Collections.emptyList();
    }

    public boolean isSuccess() {
        return mSuccess;
    }

    public List<Teacher> getTeachers() {
        return mTeachers;
    }

    public List<Parent> getParents() {
        return mParents;
    }

    public List<Child> getChildren() {
        return mChildren;
    }


    public static AfterSchoolResponse emptyResponse() {
        return new AfterSchoolResponse(
                "",
                false,
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList());
    }

    public String getJson() {
        return mJson;
    }

    public List<Classroom> getClassrooms() {
        return mClassrooms;
    }
}
