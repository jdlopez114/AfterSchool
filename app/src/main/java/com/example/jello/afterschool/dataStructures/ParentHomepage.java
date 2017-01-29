package com.example.jello.afterschool.dataStructures;

import android.graphics.Bitmap;

import com.example.jello.afterschool.backend.parent.AfterSchoolParentResponse;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.utils.BitmapInflater;

import java.util.ArrayList;
import java.util.List;

public class ParentHomepage extends DisplayableScreen {
    public ParentHomepage(AfterSchoolParentResponse result) {
        super( buildContent(result));
    }


    private static List<DisplayItem> buildContent(final AfterSchoolParentResponse data) {
        List<DisplayItem> result = new ArrayList<>();
        for (Teacher current : data.getTeachers()) {
            result.add(current);
        }
        for (Parent current : data.getParents()){
            result.add(current);
        }
        for (Child current : data.getChildren()) {
            result.add(current);
        }
        for (Classroom current : data.getClassrooms()){
            result.add(current);
        }
        return result;
    }

    private static Optional<Teacher> buildTeacherDisplayItem(Teacher current) {
        try {
            return Optional.ofNullable(current);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
