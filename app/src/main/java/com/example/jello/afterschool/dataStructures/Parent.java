package com.example.jello.afterschool.dataStructures;

import java.util.List;

/**
 * Created by jello on 1/28/17.
 */

public class Parent {

    private String parentId;

    private String name;

    private List<String> children;

    private String image;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
