package com.example.jello.afterschool.parent.homeScreen;

public enum NavigationOption {
    HOME("Home"),
    CHILD_PROGRESS("View Progress"),
    SEARCH_FOR_PROGRAMS("Find a Program"),
    MESSAGE_TEACHER("Message Teacher");

    private final String mDisplayName;


    NavigationOption(String name) {
        mDisplayName = name;
    }

    public String getDisplayName() {
        return mDisplayName;
    }
}
