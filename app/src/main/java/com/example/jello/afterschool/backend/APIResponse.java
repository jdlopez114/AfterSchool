package com.example.jello.afterschool.backend;

import java.util.List;

/**
 * Created by jello on 1/28/17.
 */

public class APIResponse {

    private List<Classrooms> classrooms;

    private List<Children> children;

    private Parent parent;

    private Teacher teacher;

    private String success;

    public List<Classrooms> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classrooms> classrooms) {
        this.classrooms = classrooms;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
