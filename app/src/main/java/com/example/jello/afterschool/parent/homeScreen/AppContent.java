package com.example.jello.afterschool.parent.homeScreen;

import android.graphics.Bitmap;

import com.example.jello.afterschool.backend.AfterSchoolResponse;
import com.example.jello.afterschool.dataStructures.Child;
import com.example.jello.afterschool.dataStructures.Classroom;
import com.example.jello.afterschool.dataStructures.Parent;
import com.example.jello.afterschool.dataStructures.Teacher;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.utils.BitmapInflater;

import java.util.ArrayList;
import java.util.List;

public class AppContent extends DisplayableScreen {
    public AppContent(AfterSchoolResponse result) {
        super(buildInflater(), buildContent(result));
    }

    private static BitmapInflater buildInflater() {
        return new BitmapInflater() {
            @Override
            public Bitmap buildBitmap(int width, int height) {
                return null;
            }
        };
    }

    private static List<DisplayItem> buildContent(final AfterSchoolResponse data) {
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
