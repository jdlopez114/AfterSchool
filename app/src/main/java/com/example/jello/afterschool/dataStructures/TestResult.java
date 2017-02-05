package com.example.jello.afterschool.dataStructures;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;

import org.json.JSONException;
import org.json.JSONObject;

public class TestResult extends DisplayItem{
    private static final String JSON_TEST_ID = "testId";
    private static final String JSON_GRADE = "grade";
    private final String mChildId;
    private final String mTestId;
    private final String mGrade;

    private TestResult(String testId, String grade) {
        mChildId = "";
        mTestId = testId;
        mGrade = grade;
    }

    TestResult(String childId, String testId, String grade) {
        mChildId = childId;
        mTestId = testId;
        mGrade = grade;
    }

    public String getTestId() {
        return mTestId;
    }

    String getGrade() {
        return mGrade;
    }

    public static Optional<TestResult> parse(JSONObject json) {
        try {
            String testId = json.getString(JSON_TEST_ID);
            String grade = json.getString(JSON_GRADE);
            return Optional.of(new TestResult(testId, grade));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public String getTestGrade() {
        return mGrade;
    }
}
