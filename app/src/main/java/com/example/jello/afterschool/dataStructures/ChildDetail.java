package com.example.jello.afterschool.dataStructures;


import com.example.jello.afterschool.backend.child.AfterSchoolChildResponse;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

import java.util.ArrayList;
import java.util.List;

public class ChildDetail extends DisplayableScreen {
    public ChildDetail(String childId, AfterSchoolChildResponse content) {
        super(buildContent(childId, content));
    }

    private static List<DisplayItem> buildContent(String childId, AfterSchoolChildResponse content) {
        List<DisplayItem> result = new ArrayList<>();
        for (TestResult t : content.getResults()) {
            result.add(new TestResult(childId, t.getTestId(), t.getGrade()));
        }
        return result;
    }
}
