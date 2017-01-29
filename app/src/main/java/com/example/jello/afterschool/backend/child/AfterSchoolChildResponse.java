package com.example.jello.afterschool.backend.child;


import com.example.jello.afterschool.dataStructures.TestResult;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AfterSchoolChildResponse {
    private static final String JSON_RESULT = "result";
    private final List<TestResult> mResult;

    public AfterSchoolChildResponse(List<TestResult> result) {
        mResult = result;
    }

    public List<TestResult> getResults() {
        return mResult;
    }

    public static AfterSchoolChildResponse emptyResponse() {
        return new AfterSchoolChildResponse(Collections.emptyList());
    }

    public static AfterSchoolChildResponse parse(String response) {
        try {
            List<TestResult> tests = new ArrayList<>();
            JSONObject json = new JSONObject(response);
            JSONArray results = json.getJSONArray(JSON_RESULT);
            for (int index = 0; index < results.length(); index++ ){
                JSONObject testJson = results.getJSONObject(index);
                Optional<TestResult> testResult = TestResult.parse(testJson);
                testResult.ifPresent(tests::add);
            }
            return new AfterSchoolChildResponse(tests);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emptyResponse();
    }
}
