package com.example.jello.afterschool.dataStructures;

import java.util.List;

/**
 * Created by jello on 1/28/17.
 */

public class Teacher {

    private List<String> classrooms;

    private String name;

    private String image;

    private String teacherId;

    public List<String> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<String> classrooms) {
        this.classrooms = classrooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

}